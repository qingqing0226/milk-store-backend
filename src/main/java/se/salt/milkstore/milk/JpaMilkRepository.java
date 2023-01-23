package se.salt.milkstore.milk;

import org.springframework.data.repository.CrudRepository;

public interface JpaMilkRepository extends CrudRepository<Milk, String> {
}
