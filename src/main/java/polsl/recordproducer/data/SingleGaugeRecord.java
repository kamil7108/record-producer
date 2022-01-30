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
