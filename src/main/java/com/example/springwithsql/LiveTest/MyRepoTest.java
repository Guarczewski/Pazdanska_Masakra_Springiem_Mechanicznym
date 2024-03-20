package com.example.springwithsql.LiveTest;

import com.example.springwithsql.Auth.Models.UserModel;
import com.example.springwithsql.Entity.Message;
import com.example.springwithsql.Auth.Trash.MyUserDetails;
import com.example.springwithsql.Repository.MyMessageRepository;
import com.example.springwithsql.Auth.MyUserRepository;
import com.example.springwithsql.Test.Address;
import com.example.springwithsql.Test.MyAddressRepository;
import com.example.springwithsql.Test.MyPersonRepository;
import com.example.springwithsql.Test.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class MyRepoTest implements ApplicationRunner {
    private final MyUserRepository myUserRepository;
    private final MyMessageRepository myMessageRepository;
    private final MyPersonRepository myPersonRepository;

    private final MyAddressRepository myAddressRepository;
    private final PasswordEncoder encoder;

    @Autowired
    public MyRepoTest(MyUserRepository personRepository,
                      MyMessageRepository myMessageRepository,
                      MyAddressRepository myAddressRepository,
                      MyPersonRepository myPersonRepository,
                      PasswordEncoder encoder
    ) {
        this.myUserRepository = personRepository;
        this.myMessageRepository = myMessageRepository;
        this.myAddressRepository = myAddressRepository;
        this.myPersonRepository = myPersonRepository;
        this.encoder = encoder;
    }
    public void run(ApplicationArguments args) {
        if (myUserRepository.findAll().isEmpty()) {
            myUserRepository.save(new UserModel("Jan", encoder.encode("q"), "ROLE_ADMIN"));
            myUserRepository.save(new UserModel("Anna", encoder.encode("q"), "ROLE_ADMIN"));
            myUserRepository.save(new UserModel("Marek", encoder.encode("q"), "ROLE_ADMIN"));
            myUserRepository.save(new UserModel("Julia", encoder.encode("q"), "ROLE_ADMIN"));
        }

        if (myMessageRepository.findAll().isEmpty()) {
            myMessageRepository.save(new Message("Hello!"));
            myMessageRepository.save(new Message("Hi!"));
            myMessageRepository.save(new Message("Yo!"));
            myMessageRepository.save(new Message("o/"));
            myMessageRepository.save(new Message("Morning!"));
        }

        if (myAddressRepository.findAll().isEmpty() && myPersonRepository.findAll().isEmpty()) {
            Address address1 = new Address("Krosno", "38-199");
            Address address2 = new Address("Jasło", "38-200");
            Address address3 = new Address("Brzozow", "38-201");
            Address address4 = new Address("Opacie", "38-202");
            Address address5 = new Address("Tarnow", "38-203");

            myAddressRepository.save(address1);
            myAddressRepository.save(address2);
            myAddressRepository.save(address3);
            myAddressRepository.save(address4);
            myAddressRepository.save(address5);

            myPersonRepository.save(new Person("Jan","Kowalski", address1));
            myPersonRepository.save(new Person("Ola","Kowalski", address2));
            myPersonRepository.save(new Person("Adam","Kowalski", address3));
            myPersonRepository.save(new Person("Krzysztof","Kowalski", address4));
            myPersonRepository.save(new Person("Antoni","Kowalski", address1));
            myPersonRepository.save(new Person("Kajetan","Kowalski", address2));
            myPersonRepository.save(new Person("Bogdan","Kowalski", address4));
            myPersonRepository.save(new Person("Janek","Kowalski", address1));
            myPersonRepository.save(new Person("Aleksandra","Kowalski", address1));


        }



    }
}
