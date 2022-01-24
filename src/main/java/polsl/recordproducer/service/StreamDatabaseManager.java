/*
 * [y] hybris Platform
 *
 * Copyright (c) 2021 SAP SE or an SAP affiliate company.  All rights reserved.
 *
 * This software is the confidential and proprietary information of SAP
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with SAP.
 */
package polsl.recordproducer.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.IntStream;

import org.springframework.stereotype.Service;

import polsl.recordproducer.ConfigurationProvider;
import polsl.recordproducer.api.exception.ProcessInNotRunning;
import polsl.recordproducer.api.exception.ProcessIsRunning;
import polsl.recordproducer.data.SingleGaugeRecord;
import polsl.recordproducer.data.SingleGaugeRecordJPA;

@Service
public class StreamDatabaseManager
{
	private final SingleGaugeRecordJPA singleGaugeRecordJPA;
	private final ConfigurationProvider configurationProvider;
	private final AtomicReference<Boolean> running = new AtomicReference<>(false);

	public StreamDatabaseManager(final SingleGaugeRecordJPA singleGaugeRecordJPA,
			final ConfigurationProvider configurationProvider)
	{
		this.singleGaugeRecordJPA = singleGaugeRecordJPA;
		this.configurationProvider = configurationProvider;
	}


	public void produceRecordsBetween(final LocalDateTime startData, final LocalDateTime endData)
	{
		var numberOfSensors = configurationProvider.getNumberOfSensors();
		var timeWindow = configurationProvider.getTimeWindow();
		var actualDate = startData;
		var records = new LinkedList<SingleGaugeRecord>();
		while (actualDate.isBefore(endData))
		{
			records.addAll(produceRecordsPerWindow(actualDate, numberOfSensors, timeWindow));
			actualDate = actualDate.plusMinutes(timeWindow);
			if(records.size()>500){
			singleGaugeRecordJPA.saveAllAndFlush(records);
			records = new LinkedList<>();
			}
		}
		if(!records.isEmpty()){
			singleGaugeRecordJPA.saveAllAndFlush(records);
		}
	}

	void produceRecords(final LocalDateTime startData)
	{
		CompletableFuture.runAsync(() -> {
			var actualDate = startData;
			var numberOfSensors = configurationProvider.getNumberOfSensors();
			var timeWindow = configurationProvider.getTimeWindow();
			while (running.get())
			{
				var records = produceRecordsPerWindow(actualDate, numberOfSensors, timeWindow);
				actualDate = actualDate.plusMinutes(timeWindow);
				singleGaugeRecordJPA.saveAll(records);
			}
		});
	}

	private List<SingleGaugeRecord> produceRecordsPerWindow(LocalDateTime actualDate, int numberOfSensors, int timeWindow)
	{
		Random random = new Random();
		var listOfRecords = new ArrayList<SingleGaugeRecord>();
		IntStream.range(0, numberOfSensors).forEach(sensorId -> {
			int randomAmountOfMinutes = random.nextInt(timeWindow);
			int randomAmountOfSeconds = random.nextInt(timeWindow);
			var recordDate = actualDate.plusMinutes(randomAmountOfMinutes).plusSeconds(randomAmountOfSeconds);
			var uuid = UUID.randomUUID();
			int randomWaterLevel = random.nextInt(2000);
			var newRecord = new SingleGaugeRecord(uuid, randomWaterLevel, recordDate, sensorId);
			listOfRecords.add(newRecord);
		});
		return listOfRecords;
	}


	public void startProcessOfStreamDatabase(final LocalDateTime startDate)
	{
		if (!running.get())
		{
			running.set(true);
			produceRecords(startDate);
		}
		else
		{
			throw new ProcessIsRunning("Cannot run running process");
		}
	}

	public void stopProcessOfStreamDatabase()
	{
		if (running.get())
		{
			running.set(false);
		}
		else
		{
			throw new ProcessInNotRunning("Tried to stop not running process");
		}
	}

	public void cleanStreamDatabase()
	{
		if (running.get())
		{
			stopProcessOfStreamDatabase();
		}
		singleGaugeRecordJPA.deleteAll();
	}
}
