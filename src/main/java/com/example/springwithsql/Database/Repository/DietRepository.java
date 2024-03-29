package com.example.springwithsql.Database.Repository;

import com.example.springwithsql.Database.Entity.Diet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DietRepository extends JpaRepository<Diet, Long> {
    List<Diet> findAllByHorseId(Long horseId);
}
