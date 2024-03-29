package com.example.springwithsql.Database.Entity;

import jakarta.persistence.*;
@Entity
public class Ownership {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "horseID")
    private Horse horse;
    @ManyToOne
    @JoinColumn(name = "ownerID")
    private Person person;

    Ownership(){

    }

    public Ownership(Horse horse, Person person) {
        this.horse = horse;
        this.person = person;
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

    public Person getOwner() {
        return person;
    }

    public void setOwner(Person person) {
        this.person = person;
    }
}
