package se.salt.milkstore.order;

import org.springframework.data.repository.CrudRepository;

public interface JpaOrderRepository extends CrudRepository<Order, String> {
}
