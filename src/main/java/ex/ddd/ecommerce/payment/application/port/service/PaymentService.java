package ex.ddd.ecommerce.payment.application.port.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ex.ddd.ecommerce.payment.adapter.out.persistance.PaymentAdapter;
import ex.ddd.ecommerce.payment.application.port.in.PayOrder;
import ex.ddd.ecommerce.payment.domain.PaymentDomain;

@Service
public class PaymentService implements PayOrder {

	@Autowired
	private PaymentAdapter paymentAdapter;

	@Override
	public void payOrder(Long orderId, Double amount, String cardNumber) {

		PaymentDomain payment = PaymentDomain.request(orderId, amount, cardNumber);

		payment = paymentAdapter.upsertPayment(payment);

		String transactionID = paymentAdapter.payOrder(orderId, amount, cardNumber);

		payment.collect(transactionID);

		paymentAdapter.upsertPayment(payment);

	}

}
