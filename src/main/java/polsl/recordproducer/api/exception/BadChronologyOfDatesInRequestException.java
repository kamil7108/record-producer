package polsl.recordproducer.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "StartDate is after endDate exception.")
public class BadChronologyOfDatesInRequestException extends RuntimeException
{
	public BadChronologyOfDatesInRequestException(){
		super();
	}
}
