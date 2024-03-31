package com.example.springwithsql.Controller;

import com.example.springwithsql.Auth.CUserDetails;
import com.example.springwithsql.Database.Model.AssignQueryAPI;
import com.example.springwithsql.Database.Model.PortionUpdate;
import com.example.springwithsql.Database.Repository.AccountRepository;
import com.example.springwithsql.Database.Model.HorseModel;
import com.example.springwithsql.Database.Entity.*;
import com.example.springwithsql.Database.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin()

public class MyAPIControllerAdv {

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


    @GetMapping("/api/profile")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Person> checkLogin(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        CUserDetails fetchedUser = (CUserDetails) authentication.getPrincipal();
        System.out.println(authentication.getPrincipal().toString());

        return new ResponseEntity<>(fetchedUser.getAccount().getDetails(), HttpStatus.OK);
    }

    @GetMapping("/api/All/{id}")
    public ResponseEntity<HorseModel> getAll(@PathVariable Long id){

        Horse horse = new Horse();

        if (horseRepository.findById(id).isPresent())
            horse = horseRepository.findById(id).get();

        List<Ownership> ownerships = ownershipRepository.findAllByHorseId(id);
        List<Person> people = new ArrayList<>();
        for (Ownership tmp : ownerships)
            people.add(tmp.getOwner());

        List<Diet> horsePortions = dietRepository.findAllByHorseId(id);
        List<Portions> portions = new ArrayList<>();
        for (Diet tmp : horsePortions)
            portions.add(tmp.getPortions());

        return new ResponseEntity<>(new HorseModel(horse,portions, people), HttpStatus.OK);
    }

    @GetMapping("/api/MyHorses/")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<List<Horse>> getMyHorses(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        CUserDetails fetchedUser = (CUserDetails) authentication.getPrincipal();
        long tempID = fetchedUser.getAccount().getDetails().getId();

        List<Horse> outList = new ArrayList<>();
        for (Ownership ownership : ownershipRepository.findAllByPersonId(tempID))
            outList.add(ownership.getHorse());

        return new ResponseEntity<>(outList, HttpStatus.OK);
    }
    @PostMapping("/api/Portion/Update/")
    public ResponseEntity<Portions> updatePortionByPortionID(@RequestBody PortionUpdate portionUpdate){
        Portions portions = new Portions();
        if (portionsRepository.findById(portionUpdate.getID()).isPresent())
            portions = portionsRepository.findById(portionUpdate.getID()).get();

        portions.setQuantity(portionUpdate.getQuantity());
        portions.setTimeOfDay(portionUpdate.getTimeOfDay());

        portionsRepository.save(portions);

        return new ResponseEntity<>(portions, HttpStatus.OK);
    }
    @PostMapping("/api/Portion/Add/")
    public ResponseEntity<Portions> addPortionByFoodID(@RequestBody PortionUpdate portionUpdate){
        Portions portions = new Portions();
        Food food = null;

        if (foodRepository.findById(portionUpdate.getID()).isPresent())
             food = foodRepository.findById(portionUpdate.getID()).get();

        portions.setQuantity(portionUpdate.getQuantity());
        portions.setTimeOfDay(portionUpdate.getTimeOfDay());
        portions.setFood(food);

        portionsRepository.save(portions);

        return new ResponseEntity<>(portions, HttpStatus.OK);
    }

    @PostMapping("/api/Diet/")
    public ResponseEntity<Diet> addDiet(@RequestBody AssignQueryAPI assignQueryAPI){
        Horse horse = null;
        Portions portions = null;
        Diet diet = null;
        if (horseRepository.findById(assignQueryAPI.getFirstID()).isPresent())
            horse = horseRepository.findById(assignQueryAPI.getFirstID()).get();


        if (portionsRepository.findById(assignQueryAPI.getSecondID()).isPresent())
            portions = portionsRepository.findById(assignQueryAPI.getSecondID()).get();

        if (horse != null && portions != null) {
            diet = new Diet(horse, portions);
            dietRepository.save(diet);
        }

        if (diet == null)
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);

        return new ResponseEntity<>(diet, HttpStatus.OK);

    }

}


