package com.example.springwithsql.Database.Repository;

import com.example.springwithsql.Database.Entity.Diet;
import com.example.springwithsql.Database.Entity.Horse;
import com.example.springwithsql.Database.Entity.Portions;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DietRepository extends JpaRepository<Diet, Long> {
    List<Diet> findAllByHorseId(Long horseId);
    Diet findByHorseAndPortions(Horse horse, Portions portions);
}
