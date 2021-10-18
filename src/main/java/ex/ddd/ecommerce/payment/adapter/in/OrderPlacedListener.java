package ex.ddd.ecommerce.payment.adapter.in;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import ex.ddd.ecommerce.common.events.OrderPlaced;
import ex.ddd.ecommerce.payment.application.port.in.PayOrder;

@Component
public class OrderPlacedListener {

	@Autowired
	private PayOrder payOrder;

	@Async
	@EventListener(classes = OrderPlaced.class)
	void handleAsyncEvent(OrderPlaced event) {

		payOrder.payOrder(event.getOrderId(), event.getDomain().getTotalPrice(), event.getDomain().getCardNumber());

	}

}
