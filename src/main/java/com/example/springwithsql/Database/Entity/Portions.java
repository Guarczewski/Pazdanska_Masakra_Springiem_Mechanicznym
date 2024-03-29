package com.example.springwithsql.Database.Entity;

import jakarta.persistence.*;

@Entity
public class Portions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected long id;
    protected int quantity;
    protected String timeOfDay;
    @ManyToOne
    @JoinColumn(name = "food_id")
    protected Food food;

    public Portions(){}

    public Portions(int quantity, Food food, String timeOfDay) {
        this.quantity = quantity;
        this.food = food;
        this.timeOfDay = timeOfDay;
    }

    public String getTimeOfDay() {
        return timeOfDay;
    }

    public void setTimeOfDay(String timeOfDay) {
        this.timeOfDay = timeOfDay;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Food getFood() {
        return food;
    }

    public void setFood(Food food) {
        this.food = food;
    }

    @Override
    public String toString() {
        return "Portions{" +
                "id=" + id +
                ", quantity=" + quantity +
                ", timeOfDay='" + timeOfDay + '\'' +
                ", food=" + food +
                '}';
    }
}
