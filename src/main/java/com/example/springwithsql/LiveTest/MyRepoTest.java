package com.example.springwithsql.LiveTest;

import com.example.springwithsql.Entity.Message;
import com.example.springwithsql.Entity.User;
import com.example.springwithsql.Repository.MyMessageRepository;
import com.example.springwithsql.Repository.MyUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class MyRepoTest implements ApplicationRunner {
    private final MyUserRepository myUserRepository;
    private final MyMessageRepository myMessageRepository;

    @Autowired
    public MyRepoTest(MyUserRepository personRepository, MyMessageRepository myMessageRepository) {
        this.myUserRepository = personRepository;
        this.myMessageRepository = myMessageRepository;
    }
    public void run(ApplicationArguments args) {
        if (myUserRepository.findAll().isEmpty()) {
            myUserRepository.save(new User("Jan", "Kowalski", 42));
            myUserRepository.save(new User("Anna", "Burska", 32));
            myUserRepository.save(new User("Marek", "Nowak", 45));
            myUserRepository.save(new User("Julia", "Tarska", 37));
        }

        if (myMessageRepository.findAll().isEmpty()) {
            myMessageRepository.save(new Message("Hello!"));
            myMessageRepository.save(new Message("Hi!"));
            myMessageRepository.save(new Message("Yo!"));
            myMessageRepository.save(new Message("o/"));
            myMessageRepository.save(new Message("Morning!"));
        }
    }
}
