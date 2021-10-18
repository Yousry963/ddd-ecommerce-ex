package ex.ddd.ecommerce.common.utils;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorDetails {

	private String errorMessage;
	private String errorCode;

}
