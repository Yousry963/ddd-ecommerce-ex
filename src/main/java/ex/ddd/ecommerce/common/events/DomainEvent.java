package ex.ddd.ecommerce.common.events;

import java.time.Instant;

import org.springframework.context.ApplicationEvent;

import lombok.Getter;

/**
 * A Domain Event is a role, and thus should be represented explicitly.
 */
@Getter
public class DomainEvent<T> extends ApplicationEvent {

	private static final long serialVersionUID = -7110832367589185430L;

	private Instant when;
	private Long orderId;
	private T domain;

	public DomainEvent(Object source, Instant when, Long orderId, T domain) {
		super(source);
		this.when = when;
		this.orderId = orderId;
		this.domain = domain;
	}

}
