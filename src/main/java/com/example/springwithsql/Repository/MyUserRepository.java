package com.example.springwithsql.Repository;

import com.example.springwithsql.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MyRepository extends JpaRepository<User, Integer> {

    List<User> findByAgeGreaterThanEqual(int age);

    List<User> findByNameAndPassword(String name,String password);
    List<User> findByName(String name);

}
