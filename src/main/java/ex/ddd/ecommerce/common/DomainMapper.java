package ex.ddd.ecommerce.common;

public interface DomainMapper<T, G> {

	public G toEntity(T domain);

	public T toDomain(G entity);

}
