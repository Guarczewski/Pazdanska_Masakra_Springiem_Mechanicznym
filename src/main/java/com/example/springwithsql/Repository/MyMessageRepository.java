package com.example.springwithsql.Repository;

import com.example.springwithsql.Entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MyMessageRepository extends JpaRepository<Message, Integer> {
}
