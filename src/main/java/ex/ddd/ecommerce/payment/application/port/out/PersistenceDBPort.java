package ex.ddd.ecommerce.payment.application.port.out;

import ex.ddd.ecommerce.payment.domain.PaymentDomain;

public interface PersistenceDBPort {
	
	public PaymentDomain upsertPayment(PaymentDomain payment);


}
