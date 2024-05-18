package com.example.springwithsql.Database.Model;

public class PortionUpdate {
    protected long portionID, foodID, horseID;
    protected int quantity;
    protected String timeOfDay;

    public PortionUpdate(){

    }

    public PortionUpdate(long portionID, long foodID, long horseID, int quantity, String timeOfDay) {
        this.portionID = portionID;
        this.foodID = foodID;
        this.horseID = horseID;
        this.quantity = quantity;
        this.timeOfDay = timeOfDay;
    }

    public long getFoodID() {
        return foodID;
    }

    public void setFoodID(long foodID) {
        this.foodID = foodID;
    }

    public long getHorseID() {
        return horseID;
    }

    public void setHorseID(long horseID) {
        this.horseID = horseID;
    }

    public long getPortionID() {
        return portionID;
    }

    public void setPortionID(long portionID) {
        this.portionID = portionID;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getTimeOfDay() {
        return timeOfDay;
    }

    public void setTimeOfDay(String timeOfDay) {
        this.timeOfDay = timeOfDay;
    }
}
