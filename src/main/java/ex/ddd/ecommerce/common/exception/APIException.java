package ex.ddd.ecommerce.common.exception;

import org.springframework.http.HttpStatus;

import ex.ddd.ecommerce.common.utils.ErrorCodes;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class APIException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6682265109605968848L;
	private HttpStatus httpStatus;
	private String errorMessage;
	private String errorCode;

	public APIException(ErrorCodes error) {

		this.errorCode = error.getCode();
		this.errorMessage = error.getMessage();
		this.httpStatus = error.getStatus();
	}
}
