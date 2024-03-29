package com.example.springwithsql.Controller;

import com.example.springwithsql.Database.Entity.*;

import com.example.springwithsql.Database.Repository.*;

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
    private OwnerRepository ownerRepository;
    @Autowired
    private HorseRepository horseRepository;
    @Autowired
    private HorsePortionsRepository horsePortionsRepository;
    @Autowired
    private PortionsRepository portionsRepository;
    @Autowired
    private AddressRepository addressRepository;

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
    @DeleteMapping("/api/Food/{id}") // Delete One By ID
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
    // BASIC PORTIONS REQUESTS
    // ================================================================================================================
    @GetMapping("/api/Portions/") // Fetch All
    public ResponseEntity<List<Portions>> getPortions(){
        return new ResponseEntity<>(portionsRepository.findAll(), HttpStatus.OK);
    }
    @GetMapping("/api/Portions/{id}") // Fetch One By ID
    public ResponseEntity<Portions> getPortionsByID(@PathVariable Long id){
        if (portionsRepository.findById(id).isPresent()) {
            return new ResponseEntity<>(portionsRepository.findById(id).get(), HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
    @PostMapping("/api/Portions/")
    public ResponseEntity<Portions> addPortion(@RequestBody Portions portions){
        portionsRepository.save(portions);
        return new ResponseEntity<>(portions, HttpStatus.OK);
    }
    @PutMapping("/api/Portions/{id}") // Update Existing
    public ResponseEntity<Portions> updatePortionsByID(@PathVariable Long id, @RequestBody Portions portions){
        if (portionsRepository.findById(id).isPresent()) {
            portions.setId(id);
            portionsRepository.save(portions);
            return new ResponseEntity<>(portions, HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
    @DeleteMapping("/api/Portions/{id}") // Delete One By ID
    public ResponseEntity<Portions> deletePortionsByID(@PathVariable Long id){
        if (portionsRepository.findById(id).isPresent()) {
            portionsRepository.deleteById(id);
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
    // BASIC ADDRESS REQUEST
    // ================================================================================================================
    @GetMapping("/api/Address/") // Fetch All
    public ResponseEntity<List<Address>> getAddress(){
        return new ResponseEntity<>(addressRepository.findAll(), HttpStatus.OK);
    }
    @GetMapping("/api/Address/{id}") // Fetch One By ID
    public ResponseEntity<Address> getAddressByID(@PathVariable Long id){
        if (addressRepository.findById(id).isPresent()) {
            return new ResponseEntity<>(addressRepository.findById(id).get(), HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
    @PostMapping("/api/Address/") // Add New
    public ResponseEntity<Address> addAddress(@RequestBody Address address){
        addressRepository.save(address);
        return new ResponseEntity<>(address, HttpStatus.OK);
    }
    @PutMapping("/api/Address/{id}") // Update Existing
    public ResponseEntity<Address> updateAddressByID(@PathVariable Long id, @RequestBody Address address){
        if (addressRepository.findById(id).isPresent()) {
            address.setId(id);
            addressRepository.save(address);
            return new ResponseEntity<>(address, HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
    @DeleteMapping("/api/Address/{id}") // Delete One By ID
    public ResponseEntity<Address> deleteAddressByID(@PathVariable Long id){
        if (addressRepository.findById(id).isPresent()) {
            addressRepository.deleteById(id);
            return new ResponseEntity<>(null, HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
    // ================================================================================================================
    // BASIC OWNER REQUEST
    // ================================================================================================================
    @GetMapping("/api/Owner/") // Fetch All
    public ResponseEntity<List<Owner>> getOwner(){
        return new ResponseEntity<>(ownerRepository.findAll(), HttpStatus.OK);
    }
    @GetMapping("/api/Owner/{id}") // Fetch One By ID
    public ResponseEntity<Owner> getOwnerByID(@PathVariable Long id){
        if (ownerRepository.findById(id).isPresent()) {
            return new ResponseEntity<>(ownerRepository.findById(id).get(), HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
    @PostMapping("/api/Owner/") // Add New
    public ResponseEntity<Owner> addOwner(@RequestBody Owner owner){
        ownerRepository.save(owner);
        return new ResponseEntity<>(owner, HttpStatus.OK);
    }
    @PutMapping("/api/Owner/{id}") // Update Existing
    public ResponseEntity<Owner> updateOwnerByID(@PathVariable Long id, @RequestBody Owner owner){
        if (ownerRepository.findById(id).isPresent()) {
            owner.setId(id);
            ownerRepository.save(owner);
            return new ResponseEntity<>(owner, HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
    @DeleteMapping("/api/Owner/{id}") // Delete One By ID
    public ResponseEntity<Owner> deleteOwnerByID(@PathVariable Long id){
        if (ownerRepository.findById(id).isPresent()) {
            ownerRepository.deleteById(id);
            return new ResponseEntity<>(null, HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
    // ================================================================================================================
    // OTHER REQUEST
    // ================================================================================================================


    @GetMapping("/api/error")
    public ResponseEntity<String> getError(){
        return new ResponseEntity<>("Hello World!", HttpStatus.BAD_REQUEST);
    } // Error Request

}
