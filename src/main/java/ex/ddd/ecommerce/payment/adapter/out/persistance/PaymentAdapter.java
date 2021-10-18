package ex.ddd.ecommerce.payment.adapter.out.persistance;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ex.ddd.ecommerce.payment.adapter.out.persistance.entities.OrderPayments;
import ex.ddd.ecommerce.payment.application.port.out.PaymentPort;
import ex.ddd.ecommerce.payment.application.port.out.PersistenceDBPort;
import ex.ddd.ecommerce.payment.domain.PaymentDomain;
import ex.ddd.ecommerce.payment.mockup.PaymentSystem;

@Component
public class PaymentAdapter implements PersistenceDBPort, PaymentPort {

	private PaymentMapper mapper;
	private PaymentRepo paymentRepo;
	private PaymentSystem paymentSystem;

	@Autowired
	public PaymentAdapter(PaymentMapper mapper, PaymentRepo paymentRepo, PaymentSystem paymentSystem) {
		this.mapper = mapper;
		this.paymentRepo = paymentRepo;
		this.paymentSystem = paymentSystem;
	}

	@Override
	public PaymentDomain upsertPayment(PaymentDomain payment) {

		OrderPayments orderpayment = paymentRepo.save(mapper.toEntity(payment));

		return mapper.toDomain(orderpayment);
	}

	@Override
	public String payOrder(Long orderId, Double amount, String cardNumber) {

		String transactionId = paymentSystem.payAmount(amount, cardNumber);
		return transactionId;
	}

}
