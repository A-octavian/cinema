package com.example.cinemaproiectis.controllers;

import com.example.cinemaproiectis.models.Category;
import com.example.cinemaproiectis.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CategoryController {
    private final CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService){
        this.categoryService = categoryService;
    }

    @GetMapping("/category")
    public List<Category> getCategories(){
        return categoryService.getCategories();
    }

    @PostMapping("/category")
    public void addNewCategory(@RequestBody Category category){
        categoryService.addNewCategory(category);
    }

    @DeleteMapping(path = "category/{categoryId}")
    public void deleteCategory(@PathVariable("categoryId") Long categoryId){
        categoryService.deleteCategory(categoryId);
    }

    @PutMapping(path = "category/{categoryId}")
    public void updateStudent(
            @PathVariable("categoryId") Long categoryId,
            @RequestParam(required = false) String name){
        categoryService.updateCategory(categoryId,name);
    }

}
