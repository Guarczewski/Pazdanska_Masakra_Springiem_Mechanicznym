package com.example.springwithsql.Controller;

import com.example.springwithsql.Database.Entity.HorsePortions;
import com.example.springwithsql.Database.Entity.Portions;
import com.example.springwithsql.Controller.Model.HorseModel;
import com.example.springwithsql.Database.Repository.FoodRepository;
import com.example.springwithsql.Database.Repository.HorsePortionsRepository;
import com.example.springwithsql.Database.Entity.Horse;
import com.example.springwithsql.Database.Repository.HorseRepository;
import com.example.springwithsql.Auth.MyUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MyAPIController {
    @Autowired
    private MyUserRepository myUserRepository;
    @Autowired
    private FoodRepository foodRepository;
    @Autowired
    private HorseRepository horseRepository;
    @Autowired
    private HorsePortionsRepository portionsRepository;


    @GetMapping("/Test/")
    public ResponseEntity<HorseModel> newHorse() {

        Horse temp = horseRepository.findById(10L).get();

        List<Portions> output = new ArrayList<>();

        for (HorsePortions tmp : portionsRepository.findAllByHorseId(temp.getId())) {
            output.add(tmp.getPortions());
        }

        return new ResponseEntity<>(new HorseModel(temp,output), HttpStatus.OK);
    }

    @GetMapping("/api/error")
    public ResponseEntity<String> getError(){
        return new ResponseEntity<>("Hello World!", HttpStatus.BAD_REQUEST);
    } // Error Request

}
