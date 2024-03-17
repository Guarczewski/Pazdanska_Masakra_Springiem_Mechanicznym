package com.example.springwithsql.Repository;

import com.example.springwithsql.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MyUserRepository extends JpaRepository<User, Integer> {
    List<User> findByNameAndPassword(String name,String password);
    List<User> findByName(String name);

}
