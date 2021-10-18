package ex.ddd.ecommerce.ordermanagement.adapter.in.web.apis;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import ex.ddd.ecommerce.ordermanagement.domain.OrderDomain;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = { "Order Management APIs" })
public interface OrderManagementAPIs {

	@ApiOperation("Api to submit an order")
	@PostMapping(value = { "checkout", "checkout/" })
	public ResponseEntity<OrderDomain> submitOrder(@RequestBody OrderDomain cart) throws Exception;

}
