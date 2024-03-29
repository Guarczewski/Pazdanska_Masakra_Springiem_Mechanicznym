package com.example.springwithsql.LiveTest;

import com.example.springwithsql.Auth.Models.UserModel;
import com.example.springwithsql.Database.Entity.Food;
import com.example.springwithsql.Database.Entity.Horse;
import com.example.springwithsql.Database.Entity.HorsePortions;
import com.example.springwithsql.Database.Entity.Portions;
import com.example.springwithsql.Database.Repository.*;
import com.example.springwithsql.Auth.MyUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class MyRepoTest implements ApplicationRunner {
    @Autowired
    private MyUserRepository myUserRepository;

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
    private HorsePortionsRepository horsePortionsRepository;
    @Autowired
    private PasswordEncoder encoder;


    public void run(ApplicationArguments args) {
        if (myUserRepository.findAll().isEmpty()) {
            myUserRepository.save(new UserModel("Jan", encoder.encode("q"), "ROLE_ADMIN"));
            myUserRepository.save(new UserModel("Anna", encoder.encode("q"), "ROLE_ADMIN"));
            myUserRepository.save(new UserModel("Marek", encoder.encode("q"), "ROLE_ADMIN"));
            myUserRepository.save(new UserModel("Julia", encoder.encode("q"), "ROLE_ADMIN"));
        }



       // if (listTestRepository.findAll().isEmpty()) {




/*        Food fish = new Food("Fish", 4.99);
        Food potato = new Food("Potato", 4.99);
        foodRepository.save(fish);
        foodRepository.save(potato);

        Portions portions1 = new Portions(5,fish);
        Portions portions2 = new Portions(15,potato);
        Portions portions3 = new Portions(25,potato);
        Portions portions4 = new Portions(35,potato);
        portionsRepository.save(portions1);
        portionsRepository.save(portions2);
        portionsRepository.save(portions3);
        portionsRepository.save(portions4);


        Horse horse = new Horse();
        List<Portions> portions = new ArrayList<>();
        portions.add(portions1);
        portions.add(portions2);

        horse.setName("Pies");

        horseRepository.save(horse);
        System.out.println("Horse id after save: " + horse.getId());

        for (Portions tmp : portions)
            horsePortionsRepository.save(new HorsePortions(horse, tmp));*/


        horseRepository.save(new Horse("Skarto", "Małopolska", "Gniada","Awans","Samira","Skarto to bardzo energiczny i chętny do pracy wałach. Koń z osiągnięciami sportowymi. Zawody i parkur nie są mu obce. Skarto jest ulubieńcem wszyskich jeźdźców.", LocalDate.now()));

    }
}
