package com.example.springwithsql.Controller;

import com.example.springwithsql.Auth.MyUserRepository;
import com.example.springwithsql.Controller.Model.HorseModel;
import com.example.springwithsql.Database.Entity.*;
import com.example.springwithsql.Database.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MyAPIControllerAdv {

    @Autowired
    private MyUserRepository myUserRepository;
    @Autowired
    private OwnerRepository ownerRepository;
    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private FoodRepository foodRepository;
    @Autowired
    private PortionsRepository portionsRepository;
    @Autowired
    private HorseRepository horseRepository;
    @Autowired
    private HorseOwnerRepository horseOwnerRepository;
    @Autowired
    private HorsePortionsRepository horsePortionsRepository;


    @GetMapping("/api/All/{id}")
    public ResponseEntity<HorseModel> getAll(@PathVariable Long id){

        Horse horse = horseRepository.findById(id).get();

        List<HorseOwner> horseOwners = horseOwnerRepository.findAllByHorseId(id);
        List<Owner> owners = new ArrayList<>();
        for (HorseOwner tmp : horseOwners)
            owners.add(tmp.getOwner());

        List<HorsePortions> horsePortions = horsePortionsRepository.findAllByHorseId(id);
        List<Portions> portions = new ArrayList<>();
        for (HorsePortions tmp : horsePortions)
            portions.add(tmp.getPortions());

        return new ResponseEntity<>(new HorseModel(horse,portions,owners), HttpStatus.OK);


    }


}
