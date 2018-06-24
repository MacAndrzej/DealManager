package info.deal.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * 
 * @author Andrzej
 *
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Order was not found")
public class IdNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;

	public IdNotFoundException() {
		super();
	}

	public IdNotFoundException(String message) {
		super(message);
	}

	public IdNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

}
