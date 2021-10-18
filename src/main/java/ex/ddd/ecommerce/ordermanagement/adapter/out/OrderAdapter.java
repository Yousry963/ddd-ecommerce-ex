package ex.ddd.ecommerce.ordermanagement.adapter.out;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ex.ddd.ecommerce.ordermanagement.adapter.out.persistance.entities.Order;
import ex.ddd.ecommerce.ordermanagement.application.port.out.PersistenceDBPort;
import ex.ddd.ecommerce.ordermanagement.domain.OrderDomain;

@Component
public class OrderAdapter implements PersistenceDBPort {

	private OrderMapper mapper;
	private OrderRepo orderRepo;

	@Autowired
	public OrderAdapter(OrderRepo orderRepo, OrderMapper mapper) {
		this.orderRepo = orderRepo;
		this.mapper = mapper;
	}

	@Override
	public OrderDomain saveOrder(OrderDomain order) {

		Order orderDB = orderRepo.save(mapper.toEntity(order));

		return mapper.toDomain(orderDB);
	}

}
