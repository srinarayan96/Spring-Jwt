package com.jwt.example.Jwt_demo.controllers;

import com.jwt.example.Jwt_demo.models.Token;
import com.jwt.example.Jwt_demo.models.User;
import com.jwt.example.Jwt_demo.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/home")
@RequiredArgsConstructor
public class HomeController {
    private final UserService userService;
    @GetMapping("/user")
    @Secured("ROLE_MANAGER")
    public List<User> getUser(){
        System.out.println("in controller getUser");
        return userService.getUsers();
    }
    @GetMapping("/current-user")
    public String getLoggedInUser(Principal principal){
        return principal.getName();
        //return SecurityContextHolder.getContext().getAuthentication().getName();
    }

}
