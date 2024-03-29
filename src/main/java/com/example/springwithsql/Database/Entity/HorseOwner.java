package com.example.springwithsql.Database.Entity;

import jakarta.persistence.*;
@Entity
public class HorseOwner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "horseID")
    private Horse horse;
    @ManyToOne
    @JoinColumn(name = "ownerID")
    private Owner owner;

    HorseOwner(){

    }

    public HorseOwner(Horse horse, Owner owner) {
        this.horse = horse;
        this.owner = owner;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Horse getHorse() {
        return horse;
    }

    public void setHorse(Horse horse) {
        this.horse = horse;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }
}
