package com.example.springwithsql.Database.Repository;

import com.example.springwithsql.Database.Entity.HorseOwner;
import com.example.springwithsql.Database.Entity.HorsePortions;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HorseOwnerRepository extends JpaRepository<HorseOwner, Long> {
    List<HorseOwner> findAllByHorseId(Long horseId);
}
