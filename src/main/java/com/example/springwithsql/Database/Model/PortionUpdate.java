package com.example.springwithsql.Database.Model;

public class PortionUpdate {
    protected long ID;
    protected int quantity;
    protected String timeOfDay;

    public PortionUpdate(){

    }

    public PortionUpdate(long ID, int quantity, String timeOfDay) {
        this.ID = ID;
        this.quantity = quantity;
        this.timeOfDay = timeOfDay;
    }

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
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
