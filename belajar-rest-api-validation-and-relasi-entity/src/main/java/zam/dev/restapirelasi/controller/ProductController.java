package zam.dev.restapirelasi.controller;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import zam.dev.restapirelasi.dto.*;
import zam.dev.restapirelasi.model.entity.Category;
import zam.dev.restapirelasi.model.entity.Product;
import zam.dev.restapirelasi.model.entity.Supplier;
import zam.dev.restapirelasi.service.ProductService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {


    //add obj productService with dependency
    @Autowired
    private ProductService productService;

    //add modelMapper for help to assignment in Product Entity
    @Autowired
    private ModelMapper modelMapper;

    //maping to get all products
    @GetMapping("/all")
    public Iterable<Product> findAll(){
        return productService.findAll();
    }

    //postMapping to add product with json format
    @PostMapping("/add")
    public ResponseEntity<RespondBody<Product>> addProduct(@Valid @RequestBody ProductDto productDto , Errors errors){
        RespondBody<Product> respondBody = new RespondBody<>();
        if(errors.hasErrors()){
            for(var eror :errors.getAllErrors()){
                respondBody.getMessage().add(eror.getDefaultMessage());
            }
            respondBody.setData(null);
            respondBody.setStatus(false);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(respondBody);
        }
        respondBody.getMessage().add("Succes add Product");
        respondBody.setStatus(true);
        var productMap = modelMapper.map(productDto, Product.class);
        respondBody.setData(productService.save(productMap));
        return ResponseEntity.ok(respondBody);
    }

    //put mapping for update with Update productDto
    @PutMapping("/update")
    public ResponseEntity<RespondBody<Product>> update(@Valid @RequestBody UpdateProductDto productDto, Errors errors ){

        RespondBody<Product> respondBody = new RespondBody<>();

        if(errors.hasErrors()){
            for(var objError : errors.getAllErrors()){
                respondBody.getMessage().add(objError.getDefaultMessage());
            }
            respondBody.setStatus(false);
            respondBody.setData(null);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(respondBody);
        }
        respondBody.getMessage().add("Succes Update Product");
        respondBody.setStatus(true);
        var product = modelMapper.map(productDto, Product.class);
        respondBody.setData(productService.update(product));
        return ResponseEntity.ok(respondBody);
    }

    @GetMapping("/{id}")
    public Product findOne(@PathVariable("id") Long id){
        return productService.findOne(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id ){
        productService.delete(id);
    }

    @PostMapping("/add_sup/{id}")
    public void addSupplier(@PathVariable("id") Long id , @RequestBody Supplier supplier ){
        productService.addSupplier(id ,supplier);
    }

    @PostMapping("add_category/{id}")
    public void addCategory(@PathVariable("id") Long id , @RequestBody Category category){
        productService.addCategory(id , category);
    }

    @PostMapping("/search/name")
    public Product findByName(@RequestBody SearchDto searchDto){
        return productService.findByName(searchDto.getKeyword());
    }

    @PostMapping("/search/namelike")
    public List<Product> findByNameLike(@RequestBody SearchDto searchDto){
        return productService.findByNamelike(searchDto.getKeyword());
    }

}
