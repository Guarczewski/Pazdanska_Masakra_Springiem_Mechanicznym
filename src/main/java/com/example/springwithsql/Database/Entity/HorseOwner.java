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
}
