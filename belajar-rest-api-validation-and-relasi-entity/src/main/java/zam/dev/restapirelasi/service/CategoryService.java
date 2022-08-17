package zam.dev.restapirelasi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import zam.dev.restapirelasi.model.entity.Category;
import zam.dev.restapirelasi.model.repository.CategoryRepository;

import java.util.Optional;

@Service
@Transactional
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public Iterable<Category> findAll(){
        return categoryRepository.findAll();
    }

    public Category save(Category category){
        return  categoryRepository.save(category);
    }

    public Category update(Category category){
        return categoryRepository.save(category);
    }

    public Category findOne(Long id){
        Optional<Category> categoryOptional = categoryRepository.findById(id);
        if(!categoryOptional.isPresent()){
            return null;
        }
        return categoryOptional.get();
    }

    public void delete(Category category){
        categoryRepository.delete(category);
    }
}
