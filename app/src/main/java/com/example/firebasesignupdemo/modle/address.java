package com.example.firebasesignupdemo.modle;

import com.google.gson.annotations.SerializedName;

public class address {

    @SerializedName("street")
    String string_street;

    @SerializedName("suite")
    String string_suite;

    @SerializedName("city")
    String string_city;

    @SerializedName("zipcode")
    String string_zipcode;

    @SerializedName("geo")
    private geolocation geolocation = null;

    public String getString_street() {
        return string_street;
    }

    public void setString_street(String string_street) {
        this.string_street = string_street;
    }

    public String getString_suite() {
        return string_suite;
    }

    public void setString_suite(String string_suite) {
        this.string_suite = string_suite;
    }

    public String getString_city() {
        return string_city;
    }

    public void setString_city(String string_city) {
        this.string_city = string_city;
    }

    public String getString_zipcode() {
        return string_zipcode;
    }

    public void setString_zipcode(String string_zipcode) {
        this.string_zipcode = string_zipcode;
    }

    public com.example.firebasesignupdemo.modle.geolocation getGeolocation() {
        return geolocation;
    }

    public void setGeolocation(com.example.firebasesignupdemo.modle.geolocation geolocation) {
        this.geolocation = geolocation;
    }
}
