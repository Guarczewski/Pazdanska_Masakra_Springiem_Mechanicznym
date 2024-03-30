package com.example.springwithsql.Controller;

import com.example.springwithsql.Auth.CUserDetails;
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
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
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
   // @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Person> checkLogin(){

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        CUserDetails fetchedUser = (CUserDetails) authentication.getPrincipal();
        System.out.println(authentication.getPrincipal().toString());

        return new ResponseEntity<>(fetchedUser.getAccount().getDetails(), HttpStatus.OK);
    }

    @GetMapping("/api/All/{id}")
    public ResponseEntity<List<HorseModel>> getAll(@PathVariable Long id){

        Horse horse = horseRepository.findById(id).get();

        List<Ownership> ownerships = ownershipRepository.findAllByHorseId(id);
        List<Person> people = new ArrayList<>();
        for (Ownership tmp : ownerships)
            people.add(tmp.getOwner());

        List<Diet> horsePortions = dietRepository.findAllByHorseId(id);
        List<Portions> portions = new ArrayList<>();
        for (Diet tmp : horsePortions)
            portions.add(tmp.getPortions());

        List<HorseModel> output = new ArrayList<>();
        output.add(new HorseModel(horse,portions, people));
        output.add(new HorseModel(horse,portions, people));
        output.add(new HorseModel(horse,portions, people));

        return new ResponseEntity<>(output, HttpStatus.OK);


    }


}
