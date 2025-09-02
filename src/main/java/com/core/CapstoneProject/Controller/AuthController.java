package com.core.CapstoneProject.Controller;

import com.core.CapstoneProject.Dao.UserRepo;
import com.core.CapstoneProject.Model.User;
import com.core.CapstoneProject.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.security.Provider;

@RestController
public class AuthController {

    @Autowired
    private UserService service;

    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody User user){
       User user1 = service.save(user);
        return new ResponseEntity<>(user1, HttpStatus.OK);
    }

    @GetMapping("/login")
    public ResponseEntity<String> login(){
        return new ResponseEntity<>("Dashboard Page",HttpStatus.OK);
    }
}
