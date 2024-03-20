package com.example.springwithsql.Test;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MyAddressRepository extends JpaRepository<Address, Integer> { }
