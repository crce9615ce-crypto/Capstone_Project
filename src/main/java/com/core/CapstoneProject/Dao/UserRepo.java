package com.core.CapstoneProject.Dao;

import com.core.CapstoneProject.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Integer> {

    User findByUsername(String username);

}
