package com.ranjansingh.ecommerce.service;

import com.ranjansingh.ecommerce.model.CustomUserDetail;
import com.ranjansingh.ecommerce.model.User;
import com.ranjansingh.ecommerce.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomUserDetailService implements UserDetailsService {
    @Autowired
    UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<User> user = userRepo.findUserByEmail(email);
        user.orElseThrow(()->new UsernameNotFoundException("User to nhi mila"));
        return user.map(CustomUserDetail::new).get();
    }
}
