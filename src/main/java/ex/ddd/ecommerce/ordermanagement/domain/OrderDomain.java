package ex.ddd.ecommerce.ordermanagement.domain;

import java.util.ArrayList;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import ex.ddd.ecommerce.common.validation.annotations.OrderTotalAmount;
import lombok.Data;

@Data
@OrderTotalAmount
public class OrderDomain {

	@JsonIgnore
	private Long id;

	@NotEmpty(message = "Please add at least one item")
	@Size(min = 1, message = "Please add at least one item")
	@Valid
	private ArrayList<LineItems> lineItems;

	@NotBlank(message = "Invalid customer id")
	private String customerId;

	@NotBlank(message = "Invalid Card Number")
	private String cardNumber;

	@JsonIgnore
	private Double totalPrice;

}
