package ex.ddd.ecommerce.common.utils;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import ex.ddd.ecommerce.common.exception.APIException;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(APIException.class)
	protected ResponseEntity<Object> handleAPIException(APIException ex) {
		ErrorResponse error = new ErrorResponse(ex);

		return new ResponseEntity<>(error, ex.getHttpStatus());
	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		
		List<ObjectError> errors = ex.getBindingResult().getAllErrors();

		ArrayList<ErrorDetails> apiSubErrors = new ArrayList<ErrorDetails>();

		errors.stream().forEach(error -> {

			ErrorDetails apiSubError = new ErrorDetails(error.getDefaultMessage(), "ERR-0000");
			apiSubErrors.add(apiSubError);

		});

		ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setMessage("Bad Request");
		errorResponse.setResponseCode("ERR-0202");
		errorResponse.setErrorDetails(apiSubErrors);
		return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
	}

}
