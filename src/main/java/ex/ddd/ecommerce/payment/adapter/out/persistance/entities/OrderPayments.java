package ex.ddd.ecommerce.payment.adapter.out.persistance.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@Table(name = "ORDER_PAYMENTS")
public class OrderPayments {

	@Id
	@Column(name = "ID", unique = true, nullable = false, precision = 22, scale = 0)
	@EqualsAndHashCode.Include
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "ORDER_ID")
	private Long orderId;

	private String paymentStatus;

	private String cardNumber;
	
	private String transactionId;

}
