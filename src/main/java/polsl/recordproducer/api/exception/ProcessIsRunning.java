package polsl.recordproducer.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Tried run running process")
public class ProcessIsRunning extends RuntimeException
{
	public ProcessIsRunning(final String msg)
	{
		super(msg);
	}
}
