package com.example.springwithsql.Controller.Model;

import com.example.springwithsql.Database.Entity.Horse;
import com.example.springwithsql.Database.Entity.Portions;

import java.util.List;

public class HorseModel extends Horse {
    List<Portions> portionsList;

    public HorseModel(Horse horse, List<Portions> portionsList){
        setId(horse.getId());
        setName(horse.getName());

        this.portionsList = portionsList;

    }

    public List<Portions> getPortionsList() {
        return portionsList;
    }

    public void setPortionsList(List<Portions> portionsList) {
        this.portionsList = portionsList;
    }
}
