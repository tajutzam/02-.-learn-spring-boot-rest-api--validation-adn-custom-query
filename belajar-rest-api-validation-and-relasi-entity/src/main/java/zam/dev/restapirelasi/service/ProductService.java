package zam.dev.restapirelasi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import zam.dev.restapirelasi.model.entity.Category;
import zam.dev.restapirelasi.model.entity.Product;
import zam.dev.restapirelasi.model.entity.Supplier;
import zam.dev.restapirelasi.model.repository.ProductRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProductService {

    @Autowired
    private ProductRepository productRepository;




    public Iterable<Product> findAll(){
        return productRepository.findAll();
    }

    public Product save(Product product){
        return  productRepository.save(product);
    }



    public Product findOne(Long id){
        Optional<Product> productOptional = productRepository.findById(id);
        if(!productOptional.isPresent()){
            return null;
        }
        return  productOptional.get();
    }

    public Product update(Product product){
       return productRepository.save(product);
    }
    public void delete(Long id){
        productRepository.deleteById(id);
    }


    public void addSupplier(Long idProduct  , Supplier supplier ){

        Product product = findOne(idProduct);
        if(product==null){
            throw  new RuntimeException("Product tidak ditemukan");
        }
        product.getSuppliers().add(supplier);
        save(product);
    }

    public void addCategory(Long idProduct , Category category){
        Product product = findOne(idProduct);
        if(product==null){
            throw new RuntimeException("Product does not exits");
        }
        product.setCategory(category);
        save(product);
    }

    public Product findByName(String name){
        Product product = productRepository.findByName(name);
        if(product==null){
            throw new RuntimeException("Cant find Product with name : "+name+"");
        }
        return product;
    }

    public List<Product > findByNamelike(String name){
       List<Product> product = productRepository.findByNameLike("%"+name+"%");
        if(product==null){
            throw new RuntimeException("Cant find Product with name : "+name+"");
        }
        return product;
    }

}
