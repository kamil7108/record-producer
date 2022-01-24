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
package polsl.recordproducer.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import polsl.recordproducer.ConfigurationProvider;
import polsl.recordproducer.api.dto.ConfigurationRequestDto;

@RestController
@RequestMapping("/configuration")
public class ConfigurationApi
{
	private final ConfigurationProvider configurationProvider;

	public ConfigurationApi(final ConfigurationProvider configurationProvider)
	{
		this.configurationProvider = configurationProvider;
	}

	@GetMapping
	public ConfigurationRequestDto getConfiguration()
	{
		return configurationProvider.getDto();
	}

	@PatchMapping
	public void changeConfiguration(@RequestBody ConfigurationRequestDto dto)
	{
		if (dto.getNumberOfSensors() != null)
		{
			configurationProvider.setNumberOfSensors(dto.getNumberOfSensors());
		}
		if (dto.getTimeWindow() != null)
		{
			configurationProvider.setTimeWindow(dto.getTimeWindow());
		}
	}
}
