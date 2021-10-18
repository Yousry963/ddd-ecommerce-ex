package ex.ddd.ecommerce.payment.application.port.in;

import ex.ddd.ecommerce.common.annotations.UseCase;

@UseCase
public interface PayOrder {

	public void payOrder(Long orderId, Double amount, String cardNumber);

}
