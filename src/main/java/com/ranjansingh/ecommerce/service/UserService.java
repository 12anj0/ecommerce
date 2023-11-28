package com.ranjansingh.ecommerce.service;

import com.ranjansingh.ecommerce.model.Role;
import com.ranjansingh.ecommerce.model.User;
import com.ranjansingh.ecommerce.repository.RoleRepo;
import com.ranjansingh.ecommerce.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepo userRepo;
    @Autowired
    RoleRepo roleRepo;

    public User registerUser(String email ,String password){
        if(email != null && password != null){
            User user = new User();
            user.setEmail(email);
            user.setPassword(password);
            List<Role> roles = new ArrayList<>();
            roles.add(roleRepo.findById(2).get());
            user.setRoles(roles);
            return userRepo.save(user);
        }else{
            return null;
        }
    }

}
