package com.example.springwithsql.Database.Repository;

import com.example.springwithsql.Database.Entity.HorsePortions;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HorsePortionsRepository extends JpaRepository<com.example.springwithsql.Database.Entity.HorsePortions, Long> {
    List<HorsePortions> findAllByHorseId(Long horseId);
}
