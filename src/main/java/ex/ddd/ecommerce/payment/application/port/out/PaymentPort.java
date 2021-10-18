package ex.ddd.ecommerce.payment.application.port.out;

public interface PaymentPort {

	public String payOrder(Long orderId, Double amount, String cardNumber);
}
