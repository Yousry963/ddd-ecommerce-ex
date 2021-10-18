package ex.ddd.ecommerce.ordermanagement.adapter.out;

import org.springframework.data.repository.CrudRepository;

import ex.ddd.ecommerce.ordermanagement.adapter.out.persistance.entities.Order;

public interface OrderRepo extends CrudRepository<Order, String> {
	
}
