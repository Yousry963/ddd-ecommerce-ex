package ex.ddd.ecommerce.ordermanagement.adapter.out.persistance.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@Data
@Table(name = "ORDER")
public class Order {

	@Id
	@Column(name = "ID", unique = true, nullable = false, precision = 22, scale = 0)
	@EqualsAndHashCode.Include
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@ToString.Exclude
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "order")
	private List<OrderLineItems> lineItems;

	private String customerId;

	private String cardNumber;

	private Double totalAmount;

	public void addProductPrice(long price, int quantity) {
		totalAmount += (price * quantity);

	}

}
