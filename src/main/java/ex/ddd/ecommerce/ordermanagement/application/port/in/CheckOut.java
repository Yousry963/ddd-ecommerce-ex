package ex.ddd.ecommerce.ordermanagement.application.port.in;

import ex.ddd.ecommerce.common.annotations.UseCase;
import ex.ddd.ecommerce.ordermanagement.domain.OrderDomain;

@UseCase
public interface CheckOut {

	public OrderDomain submitOrder(OrderDomain order);
}
