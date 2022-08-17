package zam.dev.restapirelasi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import zam.dev.restapirelasi.model.entity.Supplier;
import zam.dev.restapirelasi.model.repository.SupplierRepository;

import java.util.Optional;

@Service
@Transactional
public class SupplierService {

    @Autowired
    private SupplierRepository supplierRepository;


    public Iterable<Supplier> findAll(){
        return supplierRepository.findAll();
    }
    public Supplier save(Supplier supplier){
        return supplierRepository.save(supplier);
    }
    public Supplier update(Supplier supplier){
        return supplierRepository.save(supplier);
    }
    public Supplier findOne(Long id){
        Optional<Supplier> optionalSupplier = supplierRepository.findById(id);

        if (!optionalSupplier.isPresent()){
            return null;
        }
        return optionalSupplier.get();
    }
    public void delete(Supplier supplier){
        supplierRepository.delete(supplier);
    }
}
