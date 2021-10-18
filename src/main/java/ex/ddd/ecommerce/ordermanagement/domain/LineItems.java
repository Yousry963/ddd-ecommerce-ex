package ex.ddd.ecommerce.ordermanagement.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import ex.ddd.ecommerce.common.validation.annotations.TrueBooleanValue;
import lombok.Data;

@Data
public class LineItems {
	
	@JsonIgnore
	private Long id;
	
	private long price;
	
	private int quantity;

	@TrueBooleanValue(message = "Product is not available")
	private boolean status;

}
