package com.example.springwithsql;

import com.example.springwithsql.Entity.User;
import com.example.springwithsql.Repository.MyMessageRepository;
import com.example.springwithsql.Repository.MyUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class MyAPIController {

    @Autowired
    private MyUserRepository myUserRepository;
    @Autowired
    private MyMessageRepository myMessageRepository;

    @GetMapping("/user")
    public List<User> getUsers(){
        return myUserRepository.findAll();
    }

    @PostMapping("/register")
    public boolean postRegister(@RequestBody MyLoginBody myLoginBody){
        if (myUserRepository.findByName(myLoginBody.getUsername()).isEmpty()) { // Check if username is taken
            try {
                myUserRepository.save(
                        new User(
                                myLoginBody.username,
                                User.HashPassword(myLoginBody.password),
                                0)
                ); // Try insert name

                return true;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return false;
    }

    @PostMapping("/login")
    public boolean postLogin(@RequestBody MyLoginBody myLoginBody) {
        return !myUserRepository.findByNameAndPassword(myLoginBody.username, myLoginBody.password).isEmpty();
    }

}
