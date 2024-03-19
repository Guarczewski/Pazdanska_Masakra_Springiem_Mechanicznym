package com.example.springwithsql.Controller;

import com.example.springwithsql.Auth.Models.LoginModel;
import com.example.springwithsql.Auth.Models.UserModel;
import com.example.springwithsql.Auth.MyUserRepository;
import com.example.springwithsql.Repository.MyMessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class MyOpenAPIController {
    @Autowired
    private MyUserRepository myUserRepository;
    @Autowired
    private MyMessageRepository myMessageRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/openAPI/register")
    public HttpStatus postNewUser(@RequestBody LoginModel loginModel){
        if (myUserRepository.findByUsername(loginModel.getInUsername()).isPresent())
            return HttpStatus.ALREADY_REPORTED;
        else {
            try {
                myUserRepository.save(new UserModel(loginModel.getInUsername(), passwordEncoder.encode(loginModel.getInPassword()), "ROLE_USER"));
                return HttpStatus.OK;
            }
            catch (Exception e) {
                return HttpStatus.BAD_REQUEST;
            }
        }
    }

}

