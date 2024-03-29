package com.example.springwithsql.Database.Repository;

import com.example.springwithsql.Database.Entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> { }
