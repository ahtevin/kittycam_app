package com.example.kittycam_final;

public class listitem {


    public String name;
    public String date;
    public String time;


    public listitem() {
    }

    public listitem(String name, String date, String time) {
        this.name=name;
        this.date=date;
        this.time=time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name=name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date=date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time=time;
    }
}