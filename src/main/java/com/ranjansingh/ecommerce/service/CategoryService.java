package com.ranjansingh.ecommerce.service;

import com.ranjansingh.ecommerce.model.Category;
import com.ranjansingh.ecommerce.repository.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    CategoryRepo categoryRepo;

    public void addCategory(Category category){
        categoryRepo.save(category);
    }
    public List<Category> getAllCategory(){
        return categoryRepo.findAll();
    }
}
