package com.example.springwithsql.Database.Repository;


import com.example.springwithsql.Database.Entity.Horse;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HorseRepository extends JpaRepository<Horse, Long> {

}
