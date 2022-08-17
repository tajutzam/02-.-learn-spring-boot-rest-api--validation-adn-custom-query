package zam.dev.restapirelasi.model.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import zam.dev.restapirelasi.model.entity.Supplier;

@Repository
public interface SupplierRepository extends CrudRepository<Supplier , Long> {

}
