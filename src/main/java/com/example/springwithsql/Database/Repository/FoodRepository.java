package com.example.springwithsql.Database.Repository;

import com.example.springwithsql.Database.Entity.Food;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FoodRepository extends JpaRepository<Food, Long> { }



