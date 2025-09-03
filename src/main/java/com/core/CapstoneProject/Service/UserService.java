package com.core.CapstoneProject.Service;

import com.core.CapstoneProject.Dao.UserRepo;
import com.core.CapstoneProject.ExceptionHandler.InvalidUsername;
import com.core.CapstoneProject.Model.User;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepo repo;

    @Autowired
    JWTService jwt;

    @Autowired
    BCryptPasswordEncoder passwordEncoder;

    @Autowired
    AuthenticationManager authenticationManager;

    public User save(User user) {

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        repo.save(user);
        return user;
    }


    @CircuitBreaker(name = "loginService", fallbackMethod = "loginFallback")
    public String verify(User user) {


        if ("simulate".equals(user.getUsername())) {
            throw new RuntimeException("Simulated system failure");
        }

        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));

            if (authentication.isAuthenticated()) {
                return jwt.generateToken(user.getUsername());
            }

            return "Failed";
        } catch (InvalidUsername e) {
            return "Invalid username or password";
        } catch ( RuntimeException e) {
            throw e;
        }

    }


    private String loginFallback(User user, Throwable t) {
        return "Login temporarily unavailable";
    }
}
