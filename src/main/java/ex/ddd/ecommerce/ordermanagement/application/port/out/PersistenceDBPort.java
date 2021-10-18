package ex.ddd.ecommerce.ordermanagement.application.port.out;

import ex.ddd.ecommerce.ordermanagement.domain.OrderDomain;

public interface PersistenceDBPort {

	public OrderDomain saveOrder(OrderDomain order);
}
