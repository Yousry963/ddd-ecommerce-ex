package ex.ddd.ecommerce.payment.adapter.out.persistance;

import org.springframework.stereotype.Component;

import ex.ddd.ecommerce.common.DomainMapper;
import ex.ddd.ecommerce.payment.adapter.out.persistance.entities.OrderPayments;
import ex.ddd.ecommerce.payment.domain.PaymentDomain;

@Component
public class PaymentMapper implements DomainMapper<PaymentDomain, OrderPayments> {

	@Override
	public OrderPayments toEntity(PaymentDomain domain) {
		OrderPayments orderPayment = new OrderPayments();
		orderPayment.setCardNumber(domain.getCardNumber());
		orderPayment.setId(domain.getId());
		orderPayment.setOrderId(domain.getOrderId());
		orderPayment.setPaymentStatus(domain.getPaymentStatus());
		orderPayment.setTransactionId(domain.getTransactionId());

		return orderPayment;
	}

	@Override
	public PaymentDomain toDomain(OrderPayments entity) {
		
		PaymentDomain paymentDomain = new PaymentDomain();
		paymentDomain.setCardNumber(entity.getCardNumber());
		paymentDomain.setId(entity.getId());
		paymentDomain.setOrderId(entity.getOrderId());
		paymentDomain.setPaymentStatus(entity.getPaymentStatus());
		paymentDomain.setTransactionId(entity.getTransactionId());

		return paymentDomain;
	}

}
