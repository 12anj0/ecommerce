package com.ranjansingh.ecommerce.controller;

import com.ranjansingh.ecommerce.model.Category;
import com.ranjansingh.ecommerce.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AdminController {

    @Autowired
    CategoryService categoryService;

    @GetMapping("/admin")
    public String adminHome(){
        return "adminHome";
    }

    @GetMapping("/admin/categories")
    public String getCat(Model model){
        model.addAttribute("categories" ,categoryService.getAllCategory());
        return "categories";
    }
    @GetMapping("/admin/categories/add")
    public String getCategory(Model model){
        model.addAttribute("category" , new Category());
        return "addCategories";
    }
    @PostMapping("/admin/categories/add")
    public String postCategory(@ModelAttribute("category") Category category){
        categoryService.addCategory(category);
        return "redirect:/admin/categories  ";
    }
}