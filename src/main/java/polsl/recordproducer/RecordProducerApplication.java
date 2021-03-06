package polsl.recordproducer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;

@SpringBootApplication
@EntityScan(basePackageClasses = {RecordProducerApplication.class, Jsr310JpaConverters.class})
public class RecordProducerApplication
{
	public static void main(String[] args)
	{
		SpringApplication.run(RecordProducerApplication.class, args);
	}
}
