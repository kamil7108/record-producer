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
