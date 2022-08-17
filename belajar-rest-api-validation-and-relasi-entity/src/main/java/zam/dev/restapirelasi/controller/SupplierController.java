package zam.dev.restapirelasi.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import zam.dev.restapirelasi.dto.RespondBody;
import zam.dev.restapirelasi.dto.SupplierDto;
import zam.dev.restapirelasi.dto.UpdateSupplierDto;
import zam.dev.restapirelasi.model.entity.Supplier;
import zam.dev.restapirelasi.service.SupplierService;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/api/suppliers")
public class SupplierController {

    @Autowired
    private SupplierService supplierService;

    @Autowired
    private ModelMapper modelMapper;

    //get all supplier with get mapping
    @GetMapping("/all")
    public Iterable<Supplier> findAll(){
        return supplierService.findAll();
    }

    //add suplier with postmapping
    @PostMapping("/add")
    public ResponseEntity<RespondBody<Supplier>> create( @Valid @RequestBody SupplierDto supplierDto , Errors errors){
        RespondBody<Supplier> respondBody = new RespondBody<>();

        if(errors.hasErrors()){
            for(var objError: errors.getAllErrors()){
                respondBody.getMessage().add(objError.getDefaultMessage());
            }
            respondBody.setStatus(false);
            respondBody.setData(null);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(respondBody);
        }
        respondBody.getMessage().add("Succes add Supplier");
        respondBody.setStatus(true);

        Supplier supplier = modelMapper.map(supplierDto , Supplier.class);
        respondBody.setData(supplierService.save(supplier));
        return ResponseEntity.ok(respondBody);
    }

    //update data supplier with updatedtosupplier because need id in json
    @PutMapping("/update")
    public ResponseEntity<RespondBody<Supplier>> update(@Valid @RequestBody UpdateSupplierDto supplierDto , Errors errors){
        RespondBody<Supplier> respondBody = new RespondBody<>();

        if(errors.hasErrors()){
            for(var objError: errors.getAllErrors()){
                respondBody.getMessage().add(objError.getDefaultMessage());
            }
            respondBody.setStatus(false);
            respondBody.setData(null);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(respondBody);
        }
        respondBody.getMessage().add("Succes update Supplier");
        respondBody.setStatus(true);

        Supplier supplier = modelMapper.map(supplierDto , Supplier.class);
        respondBody.setData(supplierService.update(supplier));
        return ResponseEntity.ok(respondBody);
    }

    //get one supplier with id in url path
    @GetMapping("{id}")
    public Supplier findOne(@PathVariable("id")Long id){
        return supplierService.findOne(id);
    }

    //delete supplier with id in url path
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id")Long id){
       Supplier supplier = supplierService.findOne(id);
       if(supplier==null){
           throw new RuntimeException("Data Not Found");
       }
       supplierService.delete(supplier);
    }
}
