package ex.ddd.ecommerce.ordermanagement.adapter.out;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import ex.ddd.ecommerce.common.DomainMapper;
import ex.ddd.ecommerce.ordermanagement.adapter.out.persistance.entities.Order;
import ex.ddd.ecommerce.ordermanagement.adapter.out.persistance.entities.OrderLineItems;
import ex.ddd.ecommerce.ordermanagement.domain.LineItems;
import ex.ddd.ecommerce.ordermanagement.domain.OrderDomain;

@Component
public class OrderMapper implements DomainMapper<OrderDomain, Order> {

	public Order toEntity(OrderDomain orderDomain) {
		Order order = new Order();

		order.setId(orderDomain.getId());
		order.setCardNumber(orderDomain.getCardNumber());
		order.setCustomerId(orderDomain.getCustomerId());
		order.setTotalAmount(0d);
		order.setLineItems(new ArrayList<OrderLineItems>());

		orderDomain.getLineItems().forEach(item -> {
			OrderLineItems orderItem = new OrderLineItems();
			orderItem.setId(item.getId());
			orderItem.setOrder(order);
			orderItem.setPrice(item.getPrice());
			orderItem.setQuantity(item.getQuantity());

			order.getLineItems().add(orderItem);
			order.addProductPrice(item.getPrice(), item.getQuantity());

		});

		return order;

	}

	public OrderDomain toDomain(Order order) {
		OrderDomain orderDomain = new OrderDomain();

		orderDomain.setId(order.getId());
		orderDomain.setCardNumber(order.getCardNumber());

		orderDomain.setCustomerId(order.getCustomerId());

		orderDomain.setLineItems(new ArrayList<LineItems>());

		order.getLineItems().forEach(item -> {
			LineItems orderItem = new LineItems();
			orderItem.setId(item.getId());
			orderItem.setPrice(item.getPrice());
			orderItem.setQuantity(item.getQuantity());

			orderDomain.getLineItems().add(orderItem);

		});
		orderDomain.setTotalPrice(order.getTotalAmount());
		return orderDomain;

	}

}
