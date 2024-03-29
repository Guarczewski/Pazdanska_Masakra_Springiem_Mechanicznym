package com.example.springwithsql.Database.Entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Horse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected long id;
    protected String name;
    protected String race;
    protected String ointment;
    protected String fatherName;
    protected String motherName;
    protected String description;
    protected LocalDate birthDate;

    public Horse() {}

    public Horse(String name, String race, String ointment, String fatherName, String motherName, String description, LocalDate birthDate) {
        this.name = name;
        this.race = race;
        this.ointment = ointment;
        this.fatherName = fatherName;
        this.motherName = motherName;
        this.description = description;
        this.birthDate = birthDate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public String getOintment() {
        return ointment;
    }

    public void setOintment(String ointment) {
        this.ointment = ointment;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public String getMotherName() {
        return motherName;
    }

    public void setMotherName(String motherName) {
        this.motherName = motherName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }
}
