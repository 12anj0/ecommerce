package com.ranjansingh.ecommerce.controller;

import com.ranjansingh.ecommerce.global.GlobalData;
import com.ranjansingh.ecommerce.model.Role;
import com.ranjansingh.ecommerce.model.User;
import com.ranjansingh.ecommerce.repository.RoleRepo;
import com.ranjansingh.ecommerce.repository.UserRepo;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class LoginController {
    @Autowired
    BCryptPasswordEncoder passwordEncoder;

    @Autowired
    UserRepo userRepo;

    @Autowired
    RoleRepo roleRepo;

    @GetMapping("/login")
    public String login(){
        GlobalData.cart.clear();
        return "login";
    }
    @GetMapping("/register")
    public String registerGet(Model model){
        model.addAttribute("user" , new User());
        return "register";
    }
    @PostMapping("/register")
    public String registerPost(@ModelAttribute("user")User user , HttpServletRequest request)throws ServletException {
        String password = user.getPassword();
        user.setPassword(passwordEncoder.encode(password));
        List<Role> roles = new ArrayList<>();
        roles.add(roleRepo.findById(2).get());
        user.setRoles(roles);
        userRepo.save(user);

        request.login(user.getEmail() , password);

        return "redirect:/";
    }
}
