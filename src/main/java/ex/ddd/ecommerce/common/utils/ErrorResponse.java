package ex.ddd.ecommerce.common.utils;

import java.util.ArrayList;

import ex.ddd.ecommerce.common.exception.APIException;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ErrorResponse {

	private String responseCode;
	private String message;
	private ArrayList<ErrorDetails> errorDetails;

	public ErrorResponse(APIException ex) {
		this.responseCode = ex.getErrorCode();
		this.message = ex.getErrorMessage();
		// this.httpStatus = ex.getHttpStatus();
	}

}
