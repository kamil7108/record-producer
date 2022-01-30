package polsl.recordproducer.api.dto;

import java.time.LocalDateTime;

public class ProduceRecordsBetweenDto
{
	private LocalDateTime startDate;
	private LocalDateTime endDate;

	public ProduceRecordsBetweenDto()
	{
	}

	public ProduceRecordsBetweenDto(final LocalDateTime startDate, final LocalDateTime endDate)
	{
		if(startDate.isAfter(endDate))
			throw new RuntimeException();
		this.startDate = startDate;
		this.endDate = endDate;
	}


	public LocalDateTime getStartDate()
	{
		return startDate;
	}

	public LocalDateTime getEndDate()
	{
		return endDate;
	}

	public void setStartDate(final LocalDateTime startDate)
	{
		this.startDate = startDate;
	}

	public void setEndDate(final LocalDateTime endDate)
	{
		this.endDate = endDate;
	}
}
