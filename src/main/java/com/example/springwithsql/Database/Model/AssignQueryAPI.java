package com.example.springwithsql.Database.Model;

public class AssignQueryAPI {
    long firstID;
    long secondID;

    AssignQueryAPI(){

    }

    public long getFirstID() {
        return firstID;
    }

    public void setFirstID(long firstID) {
        this.firstID = firstID;
    }

    public long getSecondID() {
        return secondID;
    }

    public void setSecondID(long secondID) {
        this.secondID = secondID;
    }
}