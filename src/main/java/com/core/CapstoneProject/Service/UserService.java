package com.core.CapstoneProject.Service;

import com.core.CapstoneProject.Dao.UserRepo;
import com.core.CapstoneProject.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepo repo;

    @Autowired
    BCryptPasswordEncoder passwordEncoder;

    public User save(User user) {

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        repo.save(user);
        return user;
    }
}
