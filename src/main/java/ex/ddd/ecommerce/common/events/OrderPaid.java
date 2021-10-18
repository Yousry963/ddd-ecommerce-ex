package ex.ddd.ecommerce.common.events;

import java.time.Instant;

import ex.ddd.ecommerce.payment.domain.PaymentDomain;

public class OrderPaid extends DomainEvent<PaymentDomain> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3017865035009426791L;

	public OrderPaid(Object source, Instant when, Long orderId, PaymentDomain payment) {
		super(source, when, orderId, payment);
	}

}
