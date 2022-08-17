package zam.dev.restapirelasi.model.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import zam.dev.restapirelasi.model.entity.Category;

@Repository
public interface CategoryRepository extends CrudRepository<Category , Long> {
}
