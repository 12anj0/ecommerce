package com.ranjansingh.ecommerce.config;

import com.ranjansingh.ecommerce.model.Role;
import com.ranjansingh.ecommerce.model.User;
import com.ranjansingh.ecommerce.repository.RoleRepo;
import com.ranjansingh.ecommerce.repository.UserRepo;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.core.OAuth2AuthenticatedPrincipal;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class googleOAuth2SuccessHandler implements AuthenticationSuccessHandler {

    @Autowired
    RoleRepo roleRepo;

    @Autowired
    UserRepo userRepo;

    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        OAuth2AuthenticatedPrincipal token = (OAuth2AuthenticatedPrincipal) authentication.getPrincipal();
        String email = token.getAttribute("email").toString();
        if(userRepo.findUserByEmail(email).isPresent()){

        }else{
            User user = new User();
            user.setFirstName(token.getAttribute("given_name").toString());
            user.setLastName(token.getAttribute("family_name").toString());
            user.setEmail(email);
            List<Role> roles = new ArrayList<>();
            roles.add(roleRepo.findById(2).get());
            user.setRoles(roles);
            userRepo.save(user);
        }
        redirectStrategy.sendRedirect(request , response , "/");
    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authentication) throws IOException, ServletException {
        AuthenticationSuccessHandler.super.onAuthenticationSuccess(request, response, chain, authentication);
    }
}
