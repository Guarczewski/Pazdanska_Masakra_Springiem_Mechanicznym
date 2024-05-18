package com.example.springwithsql.Controller;

import com.example.springwithsql.Database.Entity.*;
import com.example.springwithsql.Database.Model.AssignQueryAPI;
import com.example.springwithsql.Database.Model.PortionUpdate;
import com.example.springwithsql.Database.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin("*")
public class HorseController {

    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private FoodRepository foodRepository;
    @Autowired
    private PortionsRepository portionsRepository;
    @Autowired
    private HorseRepository horseRepository;
    @Autowired
    private OwnershipRepository ownershipRepository;
    @Autowired
    private DietRepository dietRepository;

    // List Horse Owners

    @GetMapping("/api/Horse/Owners/{id}")
    public ResponseEntity<List<Person>> getAllOwners(@PathVariable Long id){
        List<Ownership> ownerships = ownershipRepository.findAllByHorseId(id);

        List<Person> people = new ArrayList<>();
        for (Ownership tmp : ownerships)
            people.add(tmp.getOwner());

        return new ResponseEntity<>(people, HttpStatus.OK);
    }

    // List Horse Diet

    @GetMapping("/api/Horse/Diet/{id}")
    public ResponseEntity<List<Portions>> getAllDiet(@PathVariable Long id){
        List<Diet> diets = dietRepository.findAllByHorseId(id);
        List<Portions> portions = new ArrayList<>();

        for (Diet diet : diets)
            portions.add(diet.getPortions());

        return new ResponseEntity<>(portions, HttpStatus.OK);
    }
    // Portion Update
    @PostMapping("/api/Portion/Update/")
    public ResponseEntity<Portions> updatePortionByPortionID(@RequestBody PortionUpdate portionUpdate){

        Portions portions = new Portions();
        if (portionsRepository.findById(portionUpdate.getPortionID()).isPresent())
            portions = portionsRepository.findById(portionUpdate.getPortionID()).get();

        portions.setQuantity(portionUpdate.getQuantity());
        portions.setTimeOfDay(portionUpdate.getTimeOfDay());

        portionsRepository.save(portions);

        return new ResponseEntity<>(portions, HttpStatus.OK);
    }
    @PostMapping("/api/Horse/AddPortion/")
    public ResponseEntity<Portions> addHorsePortion(@RequestBody PortionUpdate portionUpdate){
        Portions portions = new Portions();
        Food food = null;
        Horse horse = null;

        if (foodRepository.findById(portionUpdate.getFoodID()).isPresent())
            food = foodRepository.findById(portionUpdate.getFoodID()).get();

        if (horseRepository.findById(portionUpdate.getHorseID()).isPresent())
            horse = horseRepository.findById(portionUpdate.getHorseID()).get();

        if (food != null && horse != null) {
            portions.setQuantity(portionUpdate.getQuantity());
            portions.setTimeOfDay(portionUpdate.getTimeOfDay());
            portions.setFood(food);

            portionsRepository.save(portions);
            dietRepository.save(new Diet(horse, portions));

            return new ResponseEntity<>(portions, HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/api/Horse/RemovePortion/")
    public ResponseEntity<Diet> removeHorsePortion(@RequestBody AssignQueryAPI assignQueryAPI){
        Portions portions = null;
        Horse horse = null;
        Diet diet;

        System.out.println("Here");

        if (horseRepository.findById(assignQueryAPI.getFirstID()).isPresent())
            horse = horseRepository.findById(assignQueryAPI.getFirstID()).get();

        if (portionsRepository.findById(assignQueryAPI.getSecondID()).isPresent())
            portions = portionsRepository.findById(assignQueryAPI.getSecondID()).get();

        if (portions != null && horse != null) {

            diet = dietRepository.findByHorseAndPortions(horse, portions);
            dietRepository.delete(diet);

            return new ResponseEntity<>(diet, HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    // Horse Update
    @PostMapping("/api/Horse/AddOwner/")
    public ResponseEntity<Ownership> addHorseOwner(@RequestBody AssignQueryAPI assignQueryAPI){
        Person person = null;
        Horse horse = null;
        Ownership ownership;

        System.out.println("Here");

        if (horseRepository.findById(assignQueryAPI.getFirstID()).isPresent())
            horse = horseRepository.findById(assignQueryAPI.getFirstID()).get();

        if (personRepository.findById(assignQueryAPI.getSecondID()).isPresent())
            person = personRepository.findById(assignQueryAPI.getSecondID()).get();

        if (person != null && horse != null) {
            ownership = new Ownership(horse,person);
            ownershipRepository.save(ownership);
            return new ResponseEntity<>(ownership, HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/api/Horse/RemoveOwner/")
    public ResponseEntity<Ownership> removeHorseOwner(@RequestBody AssignQueryAPI assignQueryAPI){
        Person person = null;
        Horse horse = null;
        Ownership ownership;

        System.out.println("Here");

        if (horseRepository.findById(assignQueryAPI.getFirstID()).isPresent())
            horse = horseRepository.findById(assignQueryAPI.getFirstID()).get();

        if (personRepository.findById(assignQueryAPI.getSecondID()).isPresent())
            person = personRepository.findById(assignQueryAPI.getSecondID()).get();

        if (person != null && horse != null) {

            ownership = ownershipRepository.findByPersonAndHorse(person,horse);
            ownershipRepository.delete(ownership);

            return new ResponseEntity<>(ownership, HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

}
