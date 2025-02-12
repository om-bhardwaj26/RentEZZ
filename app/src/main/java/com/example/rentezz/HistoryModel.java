package com.example.rentezz;

public class HistoryModel {
    int rent,electric;
   String date,name;

    public int getRent() {
        return rent;
    }

    public void setRent(int rent) {
        this.rent = rent;
    }

    public int getElectric() {
        return electric;
    }

    public void setElectric(int electric) {
        this.electric = electric;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HistoryModel(int rent , int electric, String date, String name){
       this.date = date;
       this.rent=rent;
       this.electric=electric;
       this.name=name;

   }
}
