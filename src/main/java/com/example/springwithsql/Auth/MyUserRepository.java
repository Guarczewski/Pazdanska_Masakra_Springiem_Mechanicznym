package com.example.springwithsql.Auth;

import com.example.springwithsql.Auth.Models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MyUserRepository extends JpaRepository<UserModel, Integer> {
    Optional<UserModel> findByUsernameAndPassword(String username, String password);
    Optional<UserModel> findByUsername(String username);
   // User getUserByUsername(String username);
}
