package polsl.recordproducer.api;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;

import polsl.recordproducer.api.dto.ProduceRecordsBetweenDto;
import polsl.recordproducer.api.dto.StreamRequestDto;
import polsl.recordproducer.service.StreamDatabaseManager;

@RestController
@RequestMapping("/")
public class ProcessApi
{
	private final static String RUN_PATH = "runStreamDatabase";
	private final static String CLEAN_PATH = "cleanStreamDatabase";
	private final static String STOP_PATH = "stopProcess";
	private final static String FILL_PATH = "fill";

	private final StreamDatabaseManager streamDatabaseManager;

	public ProcessApi(final StreamDatabaseManager streamDatabaseManager)
	{
		this.streamDatabaseManager = streamDatabaseManager;
	}

	@PutMapping(RUN_PATH)
	@JsonSerialize(using = LocalDateTimeSerializer.class)
	public void runProcess(@RequestBody final StreamRequestDto dto)
	{
		streamDatabaseManager.startProcessOfStreamDatabase(dto.getStartDate());
	}

	@PutMapping(STOP_PATH)
	public void stopProcess()
	{
		streamDatabaseManager.stopProcessOfStreamDatabase();
	}

	@PutMapping(CLEAN_PATH)
	public void cleanDatabase()
	{
		streamDatabaseManager.cleanStreamDatabase();
	}

	@PutMapping(FILL_PATH)
	public void fillDatabaseBetween(@RequestBody final ProduceRecordsBetweenDto dto)
	{
		streamDatabaseManager.produceRecordsBetween(dto.getStartDate(),dto.getEndDate());
	}
}
