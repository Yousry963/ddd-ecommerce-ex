package ex.ddd.ecommerce.ordermanagement.adapter.in.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ex.ddd.ecommerce.ordermanagement.adapter.in.web.apis.OrderManagementAPIs;
import ex.ddd.ecommerce.ordermanagement.application.port.in.CheckOut;
import ex.ddd.ecommerce.ordermanagement.domain.OrderDomain;

@RestController
@RequestMapping(path = "/api/om/")
public class OrderManagementController implements OrderManagementAPIs {

	@Autowired
	private CheckOut checkOut;

	@Override
	public ResponseEntity<OrderDomain> submitOrder(@Validated OrderDomain order) {

		OrderDomain result = checkOut.submitOrder(order);

		return new ResponseEntity<OrderDomain>(result, HttpStatus.CREATED);
	}

}
