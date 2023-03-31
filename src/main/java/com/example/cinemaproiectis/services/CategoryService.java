package com.example.cinemaproiectis.services;

import com.example.cinemaproiectis.models.Category;
import com.example.cinemaproiectis.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository){
        this.categoryRepository = categoryRepository;
    }

    public List<Category> getCategories(){
       return categoryRepository.findAll();
    }

    public void addNewCategory(Category category){
        Optional<Category> categoryOptional = categoryRepository.findCategoryByName(category.getName());
        if( categoryOptional.isPresent()){
            throw new IllegalStateException("Category with this name already exists");
        }
        categoryRepository.save(category);
    }

    public void deleteCategory(Long categoryId){
        boolean exists = categoryRepository.existsById(categoryId);
        if(!exists){
            throw new IllegalStateException("Category with id" + categoryId + "does not exists");
        }
        categoryRepository.deleteById(categoryId);
    }

    @Transactional
    public void updateCategory(Long categoryId, String name){
        Category category = categoryRepository.findById(categoryId).orElseThrow(()
                -> new IllegalStateException("category with id " + categoryId + " does not exist"));
        if(name != null &&
                name.length() > 0 &&
                !Objects.equals(category.getName(), name)){
            category.setName(name);
        }
    }
}
