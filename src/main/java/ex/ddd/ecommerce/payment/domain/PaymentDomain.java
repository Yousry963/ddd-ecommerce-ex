package ex.ddd.ecommerce.payment.domain;

import lombok.Data;

@Data
public class PaymentDomain {

	private Long id;
	private Long orderId;
	private String paymentStatus;
	private String cardNumber;
	private String transactionId;

	public static PaymentDomain request(Long orderId, Double amount, String cardNumber) {

		PaymentDomain payment = new PaymentDomain();
		payment.setCardNumber(cardNumber);
		payment.setOrderId(orderId);
		payment.setPaymentStatus("CREATED");

		return payment;

	}

	public void collect(String transactionId) {
		this.setPaymentStatus("COLLECTED");
		this.setTransactionId(transactionId);

	}
}
