package com.ranjansingh.ecommerce.repository;

import com.ranjansingh.ecommerce.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepo extends JpaRepository<Category , Integer> {
}
