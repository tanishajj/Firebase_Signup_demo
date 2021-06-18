package com.example.firebasesignupdemo.modle;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Users {

    @SerializedName("id")
    String string_id;

    @SerializedName("name")
    String string_name;

    @SerializedName("username")
    String string_username;

    @SerializedName("email")
    String string_email;

    @SerializedName("address")
    private address address = null;

    @SerializedName("phone")
    String string_phone;

    @SerializedName("website")
    String string_website;

    @SerializedName("company")
    private company company = null;

    public String getString_id() {
        return string_id;
    }

    public void setString_id(String string_id) {
        this.string_id = string_id;
    }

    public String getString_name() {
        return string_name;
    }

    public void setString_name(String string_name) {
        this.string_name = string_name;
    }

    public String getString_username() {
        return string_username;
    }

    public void setString_username(String string_username) {
        this.string_username = string_username;
    }

    public String getString_email() {
        return string_email;
    }

    public void setString_email(String string_email) {
        this.string_email = string_email;
    }

    public com.example.firebasesignupdemo.modle.address getAddress() {
        return address;
    }

    public void setAddress(com.example.firebasesignupdemo.modle.address address) {
        this.address = address;
    }

    public String getString_phone() {
        return string_phone;
    }

    public void setString_phone(String string_phone) {
        this.string_phone = string_phone;
    }

    public String getString_website() {
        return string_website;
    }

    public void setString_website(String string_website) {
        this.string_website = string_website;
    }

    public com.example.firebasesignupdemo.modle.company getCompany() {
        return company;
    }

    public void setCompany(com.example.firebasesignupdemo.modle.company company) {
        this.company = company;
    }
}

