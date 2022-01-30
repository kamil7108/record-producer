package polsl.recordproducer.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Cannot stop not running process")
public class ProcessInNotRunning extends RuntimeException
{
	public ProcessInNotRunning(final String s)
	{
		super(s);
	}
}
