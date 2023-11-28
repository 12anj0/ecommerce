package com.ranjansingh.ecommerce.repository;

import com.ranjansingh.ecommerce.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepo extends JpaRepository<Role , Integer> {
}
