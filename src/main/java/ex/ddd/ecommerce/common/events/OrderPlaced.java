package ex.ddd.ecommerce.common.events;

import java.time.Instant;

import ex.ddd.ecommerce.ordermanagement.domain.OrderDomain;


public class OrderPlaced extends DomainEvent<OrderDomain> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5582899158119009659L;

	public OrderPlaced(Object source, Instant when, Long orderId, OrderDomain order) {
		super(source, when, orderId, order);
	}

}
