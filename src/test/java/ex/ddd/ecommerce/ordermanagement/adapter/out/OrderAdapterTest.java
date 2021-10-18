package ex.ddd.ecommerce.ordermanagement.adapter.out;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import ex.ddd.ecommerce.ordermanagement.domain.LineItems;
import ex.ddd.ecommerce.ordermanagement.domain.OrderDomain;

@ExtendWith(MockitoExtension.class)
class OrderAdapterTest {

	@Test
	void testSaveOrder() {

		OrderRepo orderRepo = mock(OrderRepo.class);
		OrderMapper mapper = mock(OrderMapper.class);

		OrderDomain orderDomain = new OrderDomain();

		orderDomain.setCardNumber("123");

		orderDomain.setCustomerId("123123");

		orderDomain.setLineItems(new ArrayList<LineItems>());

		LineItems orderItem = new LineItems();

		orderItem.setPrice(100);
		orderItem.setQuantity(1);

		orderDomain.getLineItems().add(orderItem);

		orderDomain = new OrderAdapter(orderRepo, mapper).saveOrder(orderDomain);

		assertThat(orderDomain);

	}

}
