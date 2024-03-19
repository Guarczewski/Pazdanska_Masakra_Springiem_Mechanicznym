package com.example.springwithsql.Auth;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@Controller
@RestController
public class MyLoginController {
    @GetMapping("/profile")
    @PreAuthorize("hasRole('ADMIN')")
    public String profilePage(){
        return "123";
    }



}
