package com.example.springwithsql.Controller;

import com.example.springwithsql.Database.Entity.Food;
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
    // BASIC FOOD REQUESTS
    // ================================================================================================================
    @GetMapping("/api/Food/") // Fetch All
    public ResponseEntity<List<Food>> getFood(){
        return new ResponseEntity<>(foodRepository.findAll(), HttpStatus.OK);
    }
    @GetMapping("/api/Food/{id}") // Fetch One By ID
    public ResponseEntity<Food> getFoodByID(@PathVariable Long id){
        if (foodRepository.findById(id).isPresent()) {
            return new ResponseEntity<>(foodRepository.findById(id).get(), HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
    @PostMapping("/api/Food/")
    public ResponseEntity<Food> addFood(@RequestBody Food food){
        foodRepository.save(food);
        return new ResponseEntity<>(food, HttpStatus.OK);
    }
    @PutMapping("/api/Food/{id}") // Update Existing
    public ResponseEntity<Food> updateFoodByID(@PathVariable Long id, @RequestBody Food food){
        if (foodRepository.findById(id).isPresent()) {
            food.setId(id);
            foodRepository.save(food);
            return new ResponseEntity<>(food, HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
    @DeleteMapping("/api/Horse/{id}") // Delete One By ID
    public ResponseEntity<Food> deleteFoodByID(@PathVariable Long id){
        if (foodRepository.findById(id).isPresent()) {
            foodRepository.deleteById(id);
            return new ResponseEntity<>(null, HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
    // ================================================================================================================
    // BASIC HORSE REQUESTS
    // ================================================================================================================
    @GetMapping("/api/Horse/") // Fetch All
    public ResponseEntity<List<Horse>> getHorse(){
        return new ResponseEntity<>(horseRepository.findAll(), HttpStatus.OK);
    }
    @GetMapping("/api/Horse/{id}") // Fetch One By ID
    public ResponseEntity<Horse> getHorseByID(@PathVariable Long id){
        if (horseRepository.findById(id).isPresent()) {
            return new ResponseEntity<>(horseRepository.findById(id).get(), HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
    @PostMapping("/api/Horse/") // Add New
    public ResponseEntity<Horse> addHorse(@RequestBody Horse horse){
        horseRepository.save(horse);
        return new ResponseEntity<>(horse, HttpStatus.OK);
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



    @GetMapping("/api/error")
    public ResponseEntity<String> getError(){
        return new ResponseEntity<>("Hello World!", HttpStatus.BAD_REQUEST);
    } // Error Request

}
