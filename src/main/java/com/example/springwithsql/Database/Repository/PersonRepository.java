package com.example.springwithsql.Database.Repository;

import com.example.springwithsql.Database.Entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> { }



