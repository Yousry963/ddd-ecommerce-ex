package ex.ddd.ecommerce.payment.adapter.out.persistance;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.Test;

import ex.ddd.ecommerce.payment.domain.PaymentDomain;
import ex.ddd.ecommerce.payment.mockup.PaymentSystem;

class PaymentAdapterTest {

	PaymentMapper mapper = mock(PaymentMapper.class);

	PaymentRepo paymentRepo = mock(PaymentRepo.class);

	PaymentSystem paymentSystem = mock(PaymentSystem.class);

	@Test
	void testUpsertPayment() {

		PaymentDomain paymentDomain = new PaymentDomain();
		paymentDomain.setCardNumber("123");
		paymentDomain.setId(1l);
		paymentDomain.setOrderId(1l);
		paymentDomain.setPaymentStatus("Test");
		paymentDomain.setTransactionId("123123");

		paymentDomain = new PaymentAdapter(mapper, paymentRepo, paymentSystem).upsertPayment(paymentDomain);

		assertThat(paymentDomain);

	}

	@Test
	void testPayOrder() {
		String transactionId = new PaymentAdapter(mapper, paymentRepo, paymentSystem).payOrder(1l, 100.0, "12313");

		assertThat(transactionId);
	}

}
