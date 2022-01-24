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

import java.time.LocalDateTime;

public class StreamRequestDto
{
	private LocalDateTime startDate;

	public StreamRequestDto()
	{
	}

	public StreamRequestDto(final LocalDateTime startDate)
	{
		this.startDate = startDate;
	}

	public LocalDateTime getStartDate()
	{
		return startDate;
	}

	public void setStartDate(final LocalDateTime startDate)
	{
		this.startDate = startDate;
	}
}
