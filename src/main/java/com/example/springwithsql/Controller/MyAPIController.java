package com.example.springwithsql.Controller;

import com.example.springwithsql.Database.Entity.*;

import com.example.springwithsql.Database.Repository.*;

import com.example.springwithsql.Database.Repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class MyAPIController {
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private FoodRepository foodRepository;
    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private HorseRepository horseRepository;
    @Autowired
    private DietRepository dietRepository;
    @Autowired
    private PortionsRepository portionsRepository;
    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private LogRepository logRepository;

    // ================================================================================================================
    // BASIC FOOD REQUESTS
    // ================================================================================================================
    @GetMapping("/api/Food/") // Fetch All
    public ResponseEntity<List<Food>> getFood(){
        logRepository.save(new Log("Controller","Nie znaleziono obiektu","Nie znaleziono obiektu w bazie danych o takim ID","BRAK","BRAK"));
        return new ResponseEntity<>(foodRepository.findAll(), HttpStatus.OK);
    }
    @GetMapping("/api/Food/{id}") // Fetch One By ID
    public ResponseEntity<Food> getFoodByID(@PathVariable Long id){
        if (foodRepository.findById(id).isPresent()) {
            logRepository.save(new Log("Controller","Success","Pozytywnie przetwożono zapytanie","BRAK","BRAK"));
            return new ResponseEntity<>(foodRepository.findById(id).get(), HttpStatus.OK);
        }
        else {
            logRepository.save(new Log("Controller","Nie znaleziono obiektu","Nie znaleziono obiektu w bazie danych o takim ID","BRAK","BRAK"));
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
    @PostMapping("/api/Food/")
    public ResponseEntity<Food> addFood(@RequestBody Food food){
        foodRepository.save(food);
        logRepository.save(new Log("Controller","Success","Pozytywnie przetwożono zapytanie","BRAK","BRAK"));
        return new ResponseEntity<>(food, HttpStatus.OK);
    }
    @PutMapping("/api/Food/{id}") // Update Existing
    public ResponseEntity<Food> updateFoodByID(@PathVariable Long id, @RequestBody Food food){
        if (foodRepository.findById(id).isPresent()) {
            food.setId(id);
            foodRepository.save(food);
            logRepository.save(new Log("Controller","Success","Pozytywnie przetwożono zapytanie","BRAK","BRAK"));
            return new ResponseEntity<>(food, HttpStatus.OK);
        }
        else {
            logRepository.save(new Log("Controller","Nie znaleziono obiektu","Nie znaleziono obiektu w bazie danych o takim ID","BRAK","BRAK"));
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
    @DeleteMapping("/api/Food/{id}") // Delete One By ID
    public ResponseEntity<Food> deleteFoodByID(@PathVariable Long id){
        if (foodRepository.findById(id).isPresent()) {
            foodRepository.deleteById(id);
            logRepository.save(new Log("Controller","Success","Pozytywnie przetwożono zapytanie","BRAK","BRAK"));
            return new ResponseEntity<>(null, HttpStatus.OK);
        }
        else {
            logRepository.save(new Log("Controller","Nie znaleziono obiektu","Nie znaleziono obiektu w bazie danych o takim ID","BRAK","BRAK"));
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
    // ================================================================================================================
    // BASIC PORTIONS REQUESTS
    // ================================================================================================================
    @GetMapping("/api/Portions/") // Fetch All
    public ResponseEntity<List<Portions>> getPortions(){
        logRepository.save(new Log("Controller","Success","Pozytywnie przetwożono zapytanie","BRAK","BRAK"));
        return new ResponseEntity<>(portionsRepository.findAll(), HttpStatus.OK);
    }
    @GetMapping("/api/Portions/{id}") // Fetch One By ID
    public ResponseEntity<Portions> getPortionsByID(@PathVariable Long id){
        if (portionsRepository.findById(id).isPresent()) {
            logRepository.save(new Log("Controller","Success","Pozytywnie przetwożono zapytanie","BRAK","BRAK"));
            return new ResponseEntity<>(portionsRepository.findById(id).get(), HttpStatus.OK);
        }
        else {
            logRepository.save(new Log("Controller","Nie znaleziono obiektu","Nie znaleziono obiektu w bazie danych o takim ID","BRAK","BRAK"));
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
    @PostMapping("/api/Portions/")
    public ResponseEntity<Portions> addPortion(@RequestBody Portions portions){
        portionsRepository.save(portions);
        logRepository.save(new Log("Controller","Success","Pozytywnie przetwożono zapytanie","BRAK","BRAK"));
        return new ResponseEntity<>(portions, HttpStatus.OK);
    }
    @PutMapping("/api/Portions/{id}") // Update Existing
    public ResponseEntity<Portions> updatePortionsByID(@PathVariable Long id, @RequestBody Portions portions){
        if (portionsRepository.findById(id).isPresent()) {
            portions.setId(id);
            portionsRepository.save(portions);
            logRepository.save(new Log("Controller","Success","Pozytywnie przetwożono zapytanie","BRAK","BRAK"));
            return new ResponseEntity<>(portions, HttpStatus.OK);
        }
        else {
            logRepository.save(new Log("Controller","Nie znaleziono obiektu","Nie znaleziono obiektu w bazie danych o takim ID","BRAK","BRAK"));
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
    @DeleteMapping("/api/Portions/{id}") // Delete One By ID
    public ResponseEntity<Portions> deletePortionsByID(@PathVariable Long id){
        if (portionsRepository.findById(id).isPresent()) {
            portionsRepository.deleteById(id);
            logRepository.save(new Log("Controller","Success","Pozytywnie przetwożono zapytanie","BRAK","BRAK"));
            return new ResponseEntity<>(null, HttpStatus.OK);
        }
        else {
            logRepository.save(new Log("Controller","Nie znaleziono obiektu","Nie znaleziono obiektu w bazie danych o takim ID","BRAK","BRAK"));
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
    // ================================================================================================================
    // BASIC HORSE REQUESTS
    // ================================================================================================================
    @GetMapping("/api/Horse/") // Fetch All
    public ResponseEntity<List<Horse>> getHorse(){
        logRepository.save(new Log("Controller","Success","Pozytywnie przetwożono zapytanie","BRAK","BRAK"));
        return new ResponseEntity<>(horseRepository.findAll(), HttpStatus.OK);
    }
    @GetMapping("/api/Horse/{id}") // Fetch One By ID
    public ResponseEntity<Horse> getHorseByID(@PathVariable Long id){
        if (horseRepository.findById(id).isPresent()) {
            logRepository.save(new Log("Controller","Success","Pozytywnie przetwożono zapytanie","BRAK","BRAK"));
            return new ResponseEntity<>(horseRepository.findById(id).get(), HttpStatus.OK);
        }
        else {
            logRepository.save(new Log("Controller","Nie znaleziono obiektu","Nie znaleziono obiektu w bazie danych o takim ID","BRAK","BRAK"));
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
    @PostMapping("/api/Horse/") // Add New
    public ResponseEntity<Horse> addHorse(@RequestBody Horse horse){
        horseRepository.save(horse);
        logRepository.save(new Log("Controller","Success","Pozytywnie przetwożono zapytanie","BRAK","BRAK"));
        return new ResponseEntity<>(horse, HttpStatus.OK);
    }
    @PutMapping("/api/Horse/{id}") // Update Existing
    public ResponseEntity<Horse> updateHorseByID(@PathVariable Long id, @RequestBody Horse horse){
        if (horseRepository.findById(id).isPresent()) {
            horse.setId(id);
            horseRepository.save(horse);
            logRepository.save(new Log("Controller","Success","Pozytywnie przetwożono zapytanie","BRAK","BRAK"));
            return new ResponseEntity<>(horse, HttpStatus.OK);
        }
        else {
            logRepository.save(new Log("Controller","Nie znaleziono obiektu","Nie znaleziono obiektu w bazie danych o takim ID","BRAK","BRAK"));
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
    @DeleteMapping("/api/Horse/{id}") // Delete One By ID
    public ResponseEntity<Horse> deleteHorseByID(@PathVariable Long id){
        if (horseRepository.findById(id).isPresent()) {
            horseRepository.deleteById(id);
            logRepository.save(new Log("Controller","Success","Pozytywnie przetwożono zapytanie","BRAK","BRAK"));
            return new ResponseEntity<>(null, HttpStatus.OK);
        }
        else {
            logRepository.save(new Log("Controller","Nie znaleziono obiektu","Nie znaleziono obiektu w bazie danych o takim ID","BRAK","BRAK"));
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
    // ================================================================================================================
    // BASIC ADDRESS REQUEST
    // ================================================================================================================
    @GetMapping("/api/Address/") // Fetch All
    public ResponseEntity<List<Address>> getAddress(){
        logRepository.save(new Log("Controller","Success","Pozytywnie przetwożono zapytanie","BRAK","BRAK"));
        return new ResponseEntity<>(addressRepository.findAll(), HttpStatus.OK);
    }
    @GetMapping("/api/Address/{id}") // Fetch One By ID
    public ResponseEntity<Address> getAddressByID(@PathVariable Long id){
        if (addressRepository.findById(id).isPresent()) {
            logRepository.save(new Log("Controller","Success","Pozytywnie przetwożono zapytanie","BRAK","BRAK"));
            return new ResponseEntity<>(addressRepository.findById(id).get(), HttpStatus.OK);
        }
        else {
            logRepository.save(new Log("Controller","Nie znaleziono obiektu","Nie znaleziono obiektu w bazie danych o takim ID","BRAK","BRAK"));
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
    @PostMapping("/api/Address/") // Add New
    public ResponseEntity<Address> addAddress(@RequestBody Address address){
        addressRepository.save(address);
        logRepository.save(new Log("Controller","Success","Pozytywnie przetwożono zapytanie","BRAK","BRAK"));
        return new ResponseEntity<>(address, HttpStatus.OK);
    }
    @PutMapping("/api/Address/{id}") // Update Existing
    public ResponseEntity<Address> updateAddressByID(@PathVariable Long id, @RequestBody Address address){
        if (addressRepository.findById(id).isPresent()) {
            address.setId(id);
            addressRepository.save(address);
            logRepository.save(new Log("Controller","Success","Pozytywnie przetwożono zapytanie","BRAK","BRAK"));
            return new ResponseEntity<>(address, HttpStatus.OK);
        }
        else {
            logRepository.save(new Log("Controller","Nie znaleziono obiektu","Nie znaleziono obiektu w bazie danych o takim ID","BRAK","BRAK"));
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
    @DeleteMapping("/api/Address/{id}") // Delete One By ID
    public ResponseEntity<Address> deleteAddressByID(@PathVariable Long id){
        if (addressRepository.findById(id).isPresent()) {
            addressRepository.deleteById(id);
            logRepository.save(new Log("Controller","Success","Pozytywnie przetwożono zapytanie","BRAK","BRAK"));
            return new ResponseEntity<>(null, HttpStatus.OK);
        }
        else {
            logRepository.save(new Log("Controller","Nie znaleziono obiektu","Nie znaleziono obiektu w bazie danych o takim ID","BRAK","BRAK"));
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
    // ================================================================================================================
    // BASIC PERSON REQUEST
    // ================================================================================================================
    @GetMapping("/api/Person/") // Fetch All
    public ResponseEntity<List<Person>> getPerson(){
        logRepository.save(new Log("Controller","Success","Pozytywnie przetwożono zapytanie","BRAK","BRAK"));
        return new ResponseEntity<>(personRepository.findAll(), HttpStatus.OK);
    }
    @GetMapping("/api/Person/{id}") // Fetch One By ID
    public ResponseEntity<Person> getPersonByID(@PathVariable Long id){
        if (personRepository.findById(id).isPresent()) {
            logRepository.save(new Log("Controller","Success","Pozytywnie przetwożono zapytanie","BRAK","BRAK"));
            return new ResponseEntity<>(personRepository.findById(id).get(), HttpStatus.OK);
        }
        else {
            logRepository.save(new Log("Controller","Nie znaleziono obiektu","Nie znaleziono obiektu w bazie danych o takim ID","BRAK","BRAK"));
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
    @PostMapping("/api/Person/") // Add New
    public ResponseEntity<Person> addPerson(@RequestBody Person person){
        personRepository.save(person);
        logRepository.save(new Log("Controller","Success","Pozytywnie przetwożono zapytanie","BRAK","BRAK"));
        return new ResponseEntity<>(person, HttpStatus.OK);
    }
    @PutMapping("/api/Person/{id}") // Update Existing
    public ResponseEntity<Person> updatePersonByID(@PathVariable Long id, @RequestBody Person person){
        if (personRepository.findById(id).isPresent()) {
            person.setId(id);
            personRepository.save(person);
            logRepository.save(new Log("Controller","Success","Pozytywnie przetwożono zapytanie","BRAK","BRAK"));
            return new ResponseEntity<>(person, HttpStatus.OK);
        }
        else {
            logRepository.save(new Log("Controller","Nie znaleziono obiektu","Nie znaleziono obiektu w bazie danych o takim ID","BRAK","BRAK"));
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
    @DeleteMapping("/api/Person/{id}") // Delete One By ID
    public ResponseEntity<Person> deletePersonByID(@PathVariable Long id){
        if (personRepository.findById(id).isPresent()) {
            personRepository.deleteById(id);
            logRepository.save(new Log("Controller","Success","Pozytywnie przetwożono zapytanie","BRAK","BRAK"));
            return new ResponseEntity<>(null, HttpStatus.OK);
        }
        else {
            logRepository.save(new Log("Controller","Nie znaleziono obiektu","Nie znaleziono obiektu w bazie danych o takim ID","BRAK","BRAK"));
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
    // ================================================================================================================
    // Log REQUEST
    // ================================================================================================================
    @GetMapping("/api/Log/") // Fetch All
    public ResponseEntity<List<Log>> getLog(){
        return new ResponseEntity<>(logRepository.findAll(), HttpStatus.OK);
    }
    @GetMapping("/api/Log/{id}") // Fetch One By ID
    public ResponseEntity<Log> getLogByID(@PathVariable Long id){
        if (logRepository.findById(id).isPresent()) {
            logRepository.save(new Log("Controller","Success","Pozytywnie przetwożono zapytanie","BRAK","BRAK"));
            return new ResponseEntity<>(logRepository.findById(id).get(), HttpStatus.OK);
        }
        else {
            logRepository.save(new Log("Controller","Nie znaleziono obiektu","Nie znaleziono obiektu w bazie danych o takim ID","BRAK","BRAK"));
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("/api/Log/{logHeader}") // Fetch All
    public ResponseEntity<List<Log>> getLogByHeader(String logHeader){
        return new ResponseEntity<>(logRepository.findAllByLogHeader(logHeader), HttpStatus.OK);
    }
    @GetMapping("/api/Log/{logUser}") // Fetch All
    public ResponseEntity<List<Log>> getLogByUser(String logUser){
        return new ResponseEntity<>(logRepository.findAllByLogUserRole(logUser), HttpStatus.OK);
    }
    @GetMapping("/api/Log/{logRole}") // Fetch All
    public ResponseEntity<List<Log>> getLogByRole(String logRole){
        return new ResponseEntity<>(logRepository.findAllByLogUserRole(logRole), HttpStatus.OK);
    }
    // ================================================================================================================
    // OTHER REQUEST
    // ================================================================================================================

    @GetMapping("/api/error")
    public ResponseEntity<String> getError(){
        return new ResponseEntity<>("Hello World!", HttpStatus.BAD_REQUEST);
    } // Error Request

}
