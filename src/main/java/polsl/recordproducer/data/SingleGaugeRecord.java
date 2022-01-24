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
package polsl.recordproducer.data;

import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;

@Entity
@Table(name = "MeterReadings",indexes = {
		@Index(name = "timeStampIndex", columnList = "timeStamp ASC")
})
public class SingleGaugeRecord
{
	@Id
	private UUID uuid;
	private Integer waterLevel;
	private LocalDateTime timeStamp;
	private Integer guageId;

	public SingleGaugeRecord(final UUID uuid, final Integer waterLevel, final LocalDateTime timeStamp, final Integer guageId)
	{
		this.uuid = uuid;
		this.waterLevel = waterLevel;
		this.timeStamp = timeStamp;
		this.guageId = guageId;
	}

	public SingleGaugeRecord()
	{
	}

	public UUID getUuid()
	{
		return uuid;
	}

	public Integer getWaterLevel()
	{
		return waterLevel;
	}

	public LocalDateTime getTimeStamp()
	{
		return timeStamp;
	}

	public Integer getGuageId()
	{
		return guageId;
	}
}
