package com.example.springwithsql.Controller.Model;

import com.example.springwithsql.Database.Entity.Horse;
import com.example.springwithsql.Database.Entity.Owner;
import com.example.springwithsql.Database.Entity.Portions;

import java.util.List;

public class HorseModel extends Horse {
    List<Portions> portionsList;
    List<Owner> ownerList;

    public HorseModel(Horse horse, List<Portions> portionsList, List<Owner> ownerList){
        setId(horse.getId());
        setName(horse.getName());
        setRace(horse.getRace());
        setOintment(horse.getOintment());
        setFatherName(horse.getFatherName());
        setMotherName(horse.getMotherName());
        setDescription(horse.getDescription());
        setBirthDate(horse.getBirthDate());

        this.portionsList = portionsList;
        this.ownerList = ownerList;
    }

    public List<Portions> getPortionsList() {
        return portionsList;
    }

    public void setPortionsList(List<Portions> portionsList) {
        this.portionsList = portionsList;
    }

    public List<Owner> getOwnerList() {
        return ownerList;
    }

    public void setOwnerList(List<Owner> ownerList) {
        this.ownerList = ownerList;
    }
}
