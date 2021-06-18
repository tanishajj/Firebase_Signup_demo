package com.example.firebasesignupdemo.modle;

public class User {

    private String full_name, mail, password;

    public User() {
    }

    public User(String full_name, String mail, String password) {
        this.full_name = full_name;
        this.mail = mail;
        this.password = password;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
