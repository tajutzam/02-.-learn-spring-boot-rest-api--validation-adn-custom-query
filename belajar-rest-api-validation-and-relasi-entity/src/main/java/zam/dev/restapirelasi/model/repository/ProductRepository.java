package zam.dev.restapirelasi.model.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import zam.dev.restapirelasi.model.entity.Product;

import javax.websocket.server.PathParam;
import java.util.List;

@Repository
public interface ProductRepository extends CrudRepository<Product , Long> {

     @Query("Select p from Product p where p.name_product =?1")
     Product findByName(String name);

     @Query("Select p from Product p where p.name_product like ?1")
     List<Product> findByNameLike(String name);

}
