package com.example.springwithsql.Database.Repository;

import com.example.springwithsql.Database.Entity.Ownership;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OwnershipRepository extends JpaRepository<Ownership, Long> {
    List<Ownership> findAllByHorseId(Long horseId);
}
