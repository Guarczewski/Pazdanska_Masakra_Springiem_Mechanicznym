package com.example.springwithsql.Test;

import jakarta.persistence.*;
import org.springframework.data.jpa.repository.JpaRepository;



public interface MyPersonRepository extends JpaRepository<Person, Integer> { }



