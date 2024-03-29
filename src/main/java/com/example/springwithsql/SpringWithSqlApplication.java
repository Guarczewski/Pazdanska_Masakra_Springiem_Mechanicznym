package com.example.springwithsql;

import com.example.springwithsql.Database.Entity.*;
import com.example.springwithsql.Database.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDate;

@SpringBootApplication
public class SpringWithSqlApplication implements ApplicationRunner {

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
    private DietRepository dietRepository;
    @Autowired
    private OwnershipRepository ownershipRepository;
    @Autowired
    private PasswordEncoder encoder;

    public static void main(String[] args) {
        SpringApplication.run(SpringWithSqlApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) {
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
        if (personRepository.findAll().isEmpty() && !addressRepository.findAll().isEmpty()) {
            personRepository.save(new Person("Jan","Kowalski","111 222 333","mail@mail.com",addressRepository.findById(1L).get()));
            personRepository.save(new Person("Anna","Nowak","222 333 444","mail@mail.com",addressRepository.findById(1L).get()));
            personRepository.save(new Person("Marek","Byk","333 444 555","mail@mail.com",addressRepository.findById(1L).get()));
            personRepository.save(new Person("Adam","Kro","444 555 666","mail@mail.com",addressRepository.findById(1L).get()));
            personRepository.save(new Person("Julia","Smith","555 666 777","mail@mail.com",addressRepository.findById(1L).get()));
        }

        // Example User
        if (accountRepository.findAll().isEmpty()) {
            accountRepository.save(new Account("Jan", encoder.encode("q"), "ROLE_ADMIN", personRepository.findById(1L).get()));
            accountRepository.save(new Account("Anna", encoder.encode("q"), "ROLE_ADMIN", personRepository.findById(2L).get()));
            accountRepository.save(new Account("Marek", encoder.encode("q"), "ROLE_ADMIN", personRepository.findById(3L).get()));
            accountRepository.save(new Account("Adam", encoder.encode("q"), "ROLE_ADMIN", personRepository.findById(4L).get()));
            accountRepository.save(new Account("Julia", encoder.encode("q"), "ROLE_ADMIN", personRepository.findById(5L).get()));
        }

        // Example Horse
        if (horseRepository.findAll().isEmpty()) {
            horseRepository.save(new Horse("Skarto", "Małopolska", "Gniada","Nieznany","Nieznana","Lorem Ipsum is simply dummy text of the printing and typesetting industry.", LocalDate.now()));
            horseRepository.save(new Horse("Laki", "Małopolska", "Gniada","Nieznany","Nieznana","Lorem Ipsum is simply dummy text of the printing and typesetting industry.", LocalDate.now()));
            horseRepository.save(new Horse("Szakira", "Małopolska", "Gniada","Nieznany","Nieznana","Lorem Ipsum is simply dummy text of the printing and typesetting industry.", LocalDate.now()));
            horseRepository.save(new Horse("Juneska", "Małopolska", "Gniada","Nieznany","Nieznana","Lorem Ipsum is simply dummy text of the printing and typesetting industry.", LocalDate.now()));
            horseRepository.save(new Horse("Pagon", "Małopolska", "Gniada","Nieznany","Nieznana","Lorem Ipsum is simply dummy text of the printing and typesetting industry", LocalDate.now()));
        }

        if (dietRepository.findAll().isEmpty()) {
            dietRepository.save(new Diet(horseRepository.findById(1L).get(), portionsRepository.findById(1L).get()));
            dietRepository.save(new Diet(horseRepository.findById(1L).get(), portionsRepository.findById(2L).get()));
            dietRepository.save(new Diet(horseRepository.findById(1L).get(), portionsRepository.findById(3L).get()));
            dietRepository.save(new Diet(horseRepository.findById(1L).get(), portionsRepository.findById(4L).get()));
            dietRepository.save(new Diet(horseRepository.findById(1L).get(), portionsRepository.findById(5L).get()));
        }

        if (ownershipRepository.findAll().isEmpty()) {
            ownershipRepository.save(new Ownership(horseRepository.findById(1L).get(), personRepository.findById(1L).get()));
            ownershipRepository.save(new Ownership(horseRepository.findById(1L).get(), personRepository.findById(2L).get()));
        }


    }
}
