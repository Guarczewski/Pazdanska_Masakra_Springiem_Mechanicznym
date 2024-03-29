package com.example.springwithsql.Database.Entity;

import jakarta.persistence.*;

@Entity
public class Diet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "horseID")
    private Horse horse;

    @ManyToOne
    @JoinColumn(name = "portionID")
    private Portions portions;

    Diet(){

    }

    public Diet(Horse horse, Portions portions) {
        this.horse = horse;
        this.portions = portions;
    }

    public Horse getHorse() {
        return horse;
    }

    public void setHorse(Horse horse) {
        this.horse = horse;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Portions getPortions() {
        return portions;
    }

    public void setPortions(Portions portions) {
        this.portions = portions;
    }
}
