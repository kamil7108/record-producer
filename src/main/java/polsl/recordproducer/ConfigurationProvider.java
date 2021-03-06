package polsl.recordproducer;
import static java.lang.Integer.parseInt;

import java.util.Map;

import org.springframework.stereotype.Component;

import polsl.recordproducer.api.dto.ConfigurationRequestDto;

@Component
public class ConfigurationProvider
{
	private static final String NUMBER_OF_SENSORS = "NUMBER_OF_SENSORS";
	private static final String TIME_WINDOW = "TIME_WINDOW";

	private static final String DEFAULT_NUMBER_OF_SENSORS = "20";
	private static final String DEFAULT_TIME_WINDOW = "30";

	private int numberOfSensors;
	private int timeWindow;


	public ConfigurationProvider(final Map<String, String> envs)
	{
		numberOfSensors = parseInt(envs.getOrDefault(NUMBER_OF_SENSORS, DEFAULT_NUMBER_OF_SENSORS));
		timeWindow = parseInt(envs.getOrDefault(TIME_WINDOW, DEFAULT_TIME_WINDOW));
	}

	public int getNumberOfSensors()
	{
		return numberOfSensors;
	}

	public void setNumberOfSensors(final int numberOfSensors)
	{
		this.numberOfSensors = numberOfSensors;
	}

	public int getTimeWindow()
	{
		return timeWindow;
	}

	public void setTimeWindow(final int timeWindow)
	{
		this.timeWindow = timeWindow;
	}

	public ConfigurationRequestDto getDto()
	{
		return new ConfigurationRequestDto(numberOfSensors, timeWindow);
	}
}
