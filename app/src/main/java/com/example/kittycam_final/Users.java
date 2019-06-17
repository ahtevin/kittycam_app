package com.example.kittycam_final;

public class Users {

    String name;
    String emailid;
    String passw;
    String num1;

    public Users() {
    }

    public Users(String name, String emailid, String passw, String num1) {
        this.name=name;
        this.emailid=emailid;
        this.passw=passw;
        this.num1=num1;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name=name;
    }

    public String getEmailid() {
        return emailid;
    }

    public void setEmailid(String emailid) {
        this.emailid=emailid;
    }

    public String getPassw() {
        return passw;
    }

    public void setPassw(String passw) {
        this.passw=passw;
    }

    public String getNum1() {
        return num1;
    }

    public void setNum1(String num1) {
        this.num1=num1;
    }
}
