package ex.ddd.ecommerce.payment.mockup;

import java.util.UUID;

import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class PaymentSystem {

	public String payAmount(Double amount, String cardNumber) {
		log.info("Payment done for amount : " + amount);
		return UUID.randomUUID().toString();
	}

}
