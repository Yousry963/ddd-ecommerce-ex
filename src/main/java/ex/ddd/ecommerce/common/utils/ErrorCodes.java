package ex.ddd.ecommerce.common.utils;

import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorCodes {

	private String code, message;

	private HttpStatus status;

	public ErrorCodes(String code, String message, HttpStatus status) {
		super();
		this.code = code;
		this.message = message;
		this.status = status;
	}

	public static ErrorCodes VALIDATION_ERROR = new ErrorCodes("ERR-OM-00", "BAD Request", HttpStatus.BAD_REQUEST);

}
