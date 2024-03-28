package com.example.springwithsql.Database.Entity;

import jakarta.persistence.*;

@Entity
public class Portions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected long id;
    protected int quantity;
    @ManyToOne
    @JoinColumn(name = "food_id")
    protected Food food;

    public Portions(){}

    public Portions(int quantity, Food food) {
        this.quantity = quantity;
        this.food = food;
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
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
                ", food=" + food +
                '}';
    }
}
