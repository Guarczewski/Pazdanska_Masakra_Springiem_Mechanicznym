package com.example.springwithsql.LiveTest;

import com.example.springwithsql.Auth.Models.UserModel;
import com.example.springwithsql.Database.Entity.*;
import com.example.springwithsql.Database.Repository.*;
import com.example.springwithsql.Auth.MyUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class MyRepoTest implements ApplicationRunner {
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
    private HorsePortionsRepository horsePortionsRepository;
    @Autowired
    private HorseOwnerRepository horseOwnerRepository;
    @Autowired
    private PasswordEncoder encoder;


    public void run(ApplicationArguments args) {

        // Example User
        if (myUserRepository.findAll().isEmpty()) {
            myUserRepository.save(new UserModel("Jan", encoder.encode("q"), "ROLE_ADMIN"));
            myUserRepository.save(new UserModel("Anna", encoder.encode("q"), "ROLE_ADMIN"));
            myUserRepository.save(new UserModel("Marek", encoder.encode("q"), "ROLE_ADMIN"));
            myUserRepository.save(new UserModel("Adam", encoder.encode("q"), "ROLE_ADMIN"));
            myUserRepository.save(new UserModel("Julia", encoder.encode("q"), "ROLE_ADMIN"));
        }

        // Example Food
        if (foodRepository.findAll().isEmpty()) {
            foodRepository.save(new Food("Tomato",2.49));
            foodRepository.save(new Food("Potato",14.99));
            foodRepository.save(new Food("Hay",7.49));
            foodRepository.save(new Food("Apple",8.49));
            foodRepository.save(new Food("Sugar",1.99));
        }

        // Example Portions
        if (portionsRepository.findAll().isEmpty() && !foodRepository.findAll().isEmpty()) {
            portionsRepository.save(new Portions(13,foodRepository.findById(1L).get(),"Morning"));
            portionsRepository.save(new Portions(5,foodRepository.findById(2L).get(),"Noon"));
            portionsRepository.save(new Portions(3, foodRepository.findById(3L).get(),"Noon"));
            portionsRepository.save(new Portions(124, foodRepository.findById(4L).get(),"Evening"));
            portionsRepository.save(new Portions(122, foodRepository.findById(5L).get(),"Evening"));
        }

        // Example Address
        if (addressRepository.findAll().isEmpty()) {
            addressRepository.save(new Address("Poland", "Podkarpacie", "38-200", "Jasło", "3-Maja", "24"));
            addressRepository.save(new Address("Poland", "Podkarpacie", "38-201", "Krosno", "4-Czerwca", "13"));
            addressRepository.save(new Address("Poland", "Podkarpacie", "38-202", "Brzozów", "5-Lipca", "254"));
            addressRepository.save(new Address("Poland", "Podkarpacie", "38-203", "Iwonicz", "6-Sierpnia", "213"));
            addressRepository.save(new Address("Poland", "Podkarpacie", "38-204", "Tarnów", "7-Września", "3"));
        }

        // Example Owner
        if (ownerRepository.findAll().isEmpty() && !addressRepository.findAll().isEmpty()) {
            ownerRepository.save(new Owner("Jan","Kowalski","111 222 333","mail@mail.com",addressRepository.findById(1L).get()));
            ownerRepository.save(new Owner("Anna","Nowak","222 333 444","mail@mail.com",addressRepository.findById(1L).get()));
            ownerRepository.save(new Owner("Marek","Byk","333 444 555","mail@mail.com",addressRepository.findById(1L).get()));
            ownerRepository.save(new Owner("Adam","Kro","444 555 666","mail@mail.com",addressRepository.findById(1L).get()));
            ownerRepository.save(new Owner("Julia","Smith","555 666 777","mail@mail.com",addressRepository.findById(1L).get()));
        }

        // Example Horse
        if (horseRepository.findAll().isEmpty()) {
            horseRepository.save(new Horse("Skarto", "Małopolska", "Gniada","Nieznany","Nieznana","Lorem Ipsum is simply dummy text of the printing and typesetting industry.", LocalDate.now()));
            horseRepository.save(new Horse("Laki", "Małopolska", "Gniada","Nieznany","Nieznana","Lorem Ipsum is simply dummy text of the printing and typesetting industry.", LocalDate.now()));
            horseRepository.save(new Horse("Szakira", "Małopolska", "Gniada","Nieznany","Nieznana","Lorem Ipsum is simply dummy text of the printing and typesetting industry.", LocalDate.now()));
            horseRepository.save(new Horse("Juneska", "Małopolska", "Gniada","Nieznany","Nieznana","Lorem Ipsum is simply dummy text of the printing and typesetting industry.", LocalDate.now()));
            horseRepository.save(new Horse("Pagon", "Małopolska", "Gniada","Nieznany","Nieznana","Lorem Ipsum is simply dummy text of the printing and typesetting industry", LocalDate.now()));
        }

        if (horsePortionsRepository.findAll().isEmpty()) {
            horsePortionsRepository.save(new HorsePortions(horseRepository.findById(1L).get(), portionsRepository.findById(1L).get()));
            horsePortionsRepository.save(new HorsePortions(horseRepository.findById(1L).get(), portionsRepository.findById(2L).get()));
            horsePortionsRepository.save(new HorsePortions(horseRepository.findById(1L).get(), portionsRepository.findById(3L).get()));
            horsePortionsRepository.save(new HorsePortions(horseRepository.findById(1L).get(), portionsRepository.findById(4L).get()));
            horsePortionsRepository.save(new HorsePortions(horseRepository.findById(1L).get(), portionsRepository.findById(5L).get()));
        }

        if (horseOwnerRepository.findAll().isEmpty()) {
            horseOwnerRepository.save(new HorseOwner(horseRepository.findById(1L).get(), ownerRepository.findById(1L).get()));
            horseOwnerRepository.save(new HorseOwner(horseRepository.findById(1L).get(), ownerRepository.findById(2L).get()));
        }


    }
}
