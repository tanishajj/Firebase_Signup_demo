package com.example.firebasesignupdemo.modle;

import com.google.gson.annotations.SerializedName;

public class geolocation {

    @SerializedName("lat")
    String string_lat;

    @SerializedName("lng")
    String string_lng;

    public String getString_lat() {
        return string_lat;
    }

    public void setString_lat(String string_lat) {
        this.string_lat = string_lat;
    }

    public String getString_lng() {
        return string_lng;
    }

    public void setString_lng(String string_lng) {
        this.string_lng = string_lng;
    }
}
