package com.ranjansingh.ecommerce.repository;

import com.ranjansingh.ecommerce.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User , Integer> {
    Optional<User> findUserByEmail(String email);
    Optional<User> findByEmailAndPassword(String email , String password);
}
