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
