package com.core.CapstoneProject.Controller;

import com.core.CapstoneProject.Dao.UserRepo;
import com.core.CapstoneProject.Model.User;
import com.core.CapstoneProject.Service.UserService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.security.Provider;

@RestController
public class AuthController {

    @Autowired
    AuthenticationProvider authenticationProvider;

    @Autowired
    private UserService service;

    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody User user){
       User user1 = service.save(user);
        return new ResponseEntity<>(user1, HttpStatus.OK);
    }


    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody User user){

            return new ResponseEntity<>( service.verify(user),HttpStatus.OK);
        }

    }



