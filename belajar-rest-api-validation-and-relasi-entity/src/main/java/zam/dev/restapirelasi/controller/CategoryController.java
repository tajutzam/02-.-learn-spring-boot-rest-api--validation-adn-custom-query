package zam.dev.restapirelasi.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import zam.dev.restapirelasi.dto.CategoryDto;
import zam.dev.restapirelasi.dto.RespondBody;
import zam.dev.restapirelasi.dto.UpdateCategoryDto;
import zam.dev.restapirelasi.model.entity.Category;
import zam.dev.restapirelasi.service.CategoryService;

import javax.validation.Valid;
import java.util.Collections;

@RestController
@RequestMapping("/api/categorys")
public class CategoryController
{
    @Autowired
    private CategoryService categoryService;
    @Autowired 
    private ModelMapper modelMapper;

    @GetMapping("/all")
    public Iterable<Category> findAll(){
        return categoryService.findAll();
    }

    @PostMapping("/add")
    public ResponseEntity<RespondBody<Category>> create(@Valid @RequestBody CategoryDto categoryDto , Errors errors){

        RespondBody<Category> categoryRespondBody = new RespondBody<>();

        if(errors.hasErrors()){
            for(var objError : errors.getAllErrors()){
                categoryRespondBody.getMessage().add(objError.getDefaultMessage());
            }
            categoryRespondBody.setData(null);
            categoryRespondBody.setStatus(false);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(categoryRespondBody);
        }

        var category = modelMapper.map(categoryDto, Category.class);
        categoryRespondBody.setData(categoryService.save(category));
        categoryRespondBody.setMessage(Collections.singletonList("Succes add Category"));
        categoryRespondBody.setStatus(true);
        return ResponseEntity.ok(categoryRespondBody);
    }

    @PutMapping("/update")
    public ResponseEntity<RespondBody<Category>> update(@Valid @RequestBody UpdateCategoryDto categoryDto , Errors errors){
        RespondBody<Category> categoryRespondBody = new RespondBody<>();

        if(errors.hasErrors()){
            for(var objError : errors.getAllErrors()){
                categoryRespondBody.getMessage().add(objError.getDefaultMessage());
            }
            categoryRespondBody.setData(null);
            categoryRespondBody.setStatus(false);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(categoryRespondBody);
        }

        var category = modelMapper.map(categoryDto, Category.class);
        categoryRespondBody.setData(categoryService.update(category));
        categoryRespondBody.setMessage(Collections.singletonList("Succes Update Category"));
        categoryRespondBody.setStatus(true);
        return ResponseEntity.ok(categoryRespondBody);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") Long id){

        Category category = categoryService.findOne(id);
        if(category==null){
            throw new RuntimeException("Category Not Found !");
        }
        categoryService.delete(category);
    }

    @GetMapping("/{id}")
    public Category findOne(@PathVariable("id") Long id){
        return categoryService.findOne(id);
    }
}
