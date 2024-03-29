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

    // ================================================================================================================
    // BASIC HORSE REQUESTS
    // ================================================================================================================

    @GetMapping("/api/Horse/") // Fetch All
    public ResponseEntity<List<Horse>> getHorse(){
        return new ResponseEntity<>(horseRepository.findAll(), HttpStatus.BAD_REQUEST);
    }
    @GetMapping("/api/Horse/{id}") // Fetch One By ID
    public ResponseEntity<Horse> getHorseById(@PathVariable Long id){
        if (horseRepository.findById(id).isPresent()) {
            return new ResponseEntity<>(horseRepository.findById(id).get(), HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
    @PostMapping("/api/Horse/") // Add New
    public ResponseEntity<Horse> addHorse(@RequestBody Horse horse){
        if (horseRepository.findById(horse.getId()).isPresent()) {
            return new ResponseEntity<>(horse, HttpStatus.ALREADY_REPORTED);
        }
        else {
            horseRepository.save(horse);
            return new ResponseEntity<>(horse, HttpStatus.OK);
        }
    }
    @PutMapping("/api/Horse/{id}") // Update Existing
    public ResponseEntity<Horse> updateHorseByID(@PathVariable Long id, @RequestBody Horse horse){
        if (horseRepository.findById(id).isPresent()) {
            horse.setId(id);
            horseRepository.save(horse);
            return new ResponseEntity<>(horse, HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
    @DeleteMapping("/api/Horse/{id}") // Delete One By ID
    public ResponseEntity<Horse> deleteHorseByID(@PathVariable Long id){
        if (horseRepository.findById(id).isPresent()) {
            horseRepository.deleteById(id);
            return new ResponseEntity<>(null, HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    // ================================================================================================================
    //
    // ================================================================================================================


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
