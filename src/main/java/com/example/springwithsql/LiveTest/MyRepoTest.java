package com.example.springwithsql.LiveTest;

import com.example.springwithsql.Auth.Models.UserModel;
import com.example.springwithsql.Entity.Message;
import com.example.springwithsql.Auth.Trash.MyUserDetails;
import com.example.springwithsql.Repository.MyMessageRepository;
import com.example.springwithsql.Auth.MyUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class MyRepoTest implements ApplicationRunner {
    private final MyUserRepository myUserRepository;
    private final MyMessageRepository myMessageRepository;
    private final PasswordEncoder encoder;

    @Autowired
    public MyRepoTest(MyUserRepository personRepository, MyMessageRepository myMessageRepository, PasswordEncoder encoder) {
        this.myUserRepository = personRepository;
        this.myMessageRepository = myMessageRepository;
        this.encoder = encoder;
    }
    public void run(ApplicationArguments args) {
        if (myUserRepository.findAll().isEmpty()) {
            myUserRepository.save(new UserModel("Jan", encoder.encode("q"), "ROLE_ADMIN"));
            myUserRepository.save(new UserModel("Anna", encoder.encode("q"), "ROLE_ADMIN"));
            myUserRepository.save(new UserModel("Marek", encoder.encode("q"), "ROLE_ADMIN"));
            myUserRepository.save(new UserModel("Julia", encoder.encode("q"), "ROLE_ADMIN"));
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
