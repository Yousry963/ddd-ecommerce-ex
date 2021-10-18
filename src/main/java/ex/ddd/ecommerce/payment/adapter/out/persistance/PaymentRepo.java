package ex.ddd.ecommerce.payment.adapter.out.persistance;

import org.springframework.data.repository.CrudRepository;

import ex.ddd.ecommerce.payment.adapter.out.persistance.entities.OrderPayments;

public interface PaymentRepo extends CrudRepository<OrderPayments, String> {
	
}
