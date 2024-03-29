package com.example.springwithsql.Database.Model;

import com.example.springwithsql.Database.Entity.Horse;
import com.example.springwithsql.Database.Entity.Person;
import com.example.springwithsql.Database.Entity.Portions;

import java.util.List;

public class HorseModel extends Horse {
    List<Portions> portionsList;
    List<Person> personList;

    public HorseModel(Horse horse, List<Portions> portionsList, List<Person> personList){
        setId(horse.getId());
        setName(horse.getName());
        setRace(horse.getRace());
        setOintment(horse.getOintment());
        setFatherName(horse.getFatherName());
        setMotherName(horse.getMotherName());
        setDescription(horse.getDescription());
        setBirthDate(horse.getBirthDate());

        this.portionsList = portionsList;
        this.personList = personList;
    }

    public List<Portions> getPortionsList() {
        return portionsList;
    }

    public void setPortionsList(List<Portions> portionsList) {
        this.portionsList = portionsList;
    }

    public List<Person> getOwnerList() {
        return personList;
    }

    public void setOwnerList(List<Person> personList) {
        this.personList = personList;
    }
}
