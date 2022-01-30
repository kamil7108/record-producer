package polsl.recordproducer.api.dto;

public class ConfigurationRequestDto
{
	private Integer numberOfSensors;
	private Integer timeWindow;

	public ConfigurationRequestDto()
	{
	}

	public ConfigurationRequestDto(final Integer numberOfSensors, final Integer timeWindow)
	{
		this.numberOfSensors = numberOfSensors;
		this.timeWindow = timeWindow;
	}

	public Integer getNumberOfSensors()
	{
		return numberOfSensors;
	}

	public void setNumberOfSensors(final Integer numberOfSensors)
	{
		this.numberOfSensors = numberOfSensors;
	}

	public Integer getTimeWindow()
	{
		return timeWindow;
	}

	public void setTimeWindow(final Integer timeWindow)
	{
		this.timeWindow = timeWindow;
	}
}
