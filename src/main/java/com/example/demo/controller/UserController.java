package com.example.demo.controller;

import com.example.demo.model.InfectRec;
import com.example.demo.model.User;
import com.example.demo.repository.InfectRecRepository;
import com.example.demo.repository.UserRepository;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@RestController
public class UserController {

    @Autowired
    private UserRepository<User> repository;

    @GetMapping("/user/getusername")
    public String getUserName(Authentication authentication){
            return authentication.getName();
    }

    @PostMapping("/user/changeusername")
    public String changeUserName(@RequestParam String newName,
                                 Authentication authentication,
                                 HttpServletResponse response) {
        String name = authentication.getName();
        if (repository.findByUsername(newName)!= null)
        {
            response.setStatus(HttpServletResponse.SC_CONFLICT);
            return "Sorry, but name has been used.";
        }
        User currentUser = repository.findByUsername(authentication.getName());
        currentUser.setUsername(newName);
        repository.save(currentUser);
        return "sucess.";
    }

}