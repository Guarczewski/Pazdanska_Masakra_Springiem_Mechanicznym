package com.example.springwithsql.Database.Repository;

import com.example.springwithsql.Database.Entity.Portions;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PortionsRepository extends JpaRepository<Portions, Long> {
}
