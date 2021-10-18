package ex.ddd.ecommerce.ordermanagement.application.port.service;

import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import ex.ddd.ecommerce.common.events.OrderPlaced;
import ex.ddd.ecommerce.ordermanagement.application.port.in.CheckOut;
import ex.ddd.ecommerce.ordermanagement.application.port.out.PersistenceDBPort;
import ex.ddd.ecommerce.ordermanagement.domain.OrderDomain;

@Service
public class OrderService implements CheckOut {

	@Autowired
	private PersistenceDBPort dbPort;

	@Autowired
	private ApplicationEventPublisher eventPublisher;

	@Override
	public OrderDomain submitOrder(OrderDomain order) {

		order = dbPort.saveOrder(order);

		OrderPlaced orderPlaced = new OrderPlaced(this, Instant.now(), order.getId(), order);

		eventPublisher.publishEvent(orderPlaced);

		return order;

	}

}
