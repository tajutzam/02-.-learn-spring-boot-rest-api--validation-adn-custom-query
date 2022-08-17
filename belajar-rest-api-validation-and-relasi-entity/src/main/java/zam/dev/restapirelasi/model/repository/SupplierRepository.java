package zam.dev.restapirelasi.model.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import zam.dev.restapirelasi.model.entity.Supplier;

import java.util.List;

@Repository
public interface SupplierRepository extends CrudRepository<Supplier , Long> {

    Supplier findByEmail(String email);


    List<Supplier> findByNameLike(String name);

    Supplier findByNameOrEmail(String name , String email);

}
