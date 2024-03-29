package com.example.springwithsql.Database.Repository;

import com.example.springwithsql.Database.Entity.Owner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OwnerRepository extends JpaRepository<Owner, Long> { }



