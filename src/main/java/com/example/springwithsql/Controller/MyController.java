package com.example.springwithsql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyController {







    @RequestMapping("/add_person")
    public String add(){
      //  myRepository.save(new User(0,0,"123", "123"));
        return "addform";
    }


}
