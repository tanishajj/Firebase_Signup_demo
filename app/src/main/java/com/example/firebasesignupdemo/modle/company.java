package com.example.firebasesignupdemo.modle;

import com.google.gson.annotations.SerializedName;

public class company {

    @SerializedName("name")
    String string_cname;

    @SerializedName("catchPhrase")
    String string_catchPhrase;

    @SerializedName("bs")
    String string_bs;

    public String getString_cname() {
        return string_cname;
    }

    public void setString_cname(String string_cname) {
        this.string_cname = string_cname;
    }

    public String getString_catchPhrase() {
        return string_catchPhrase;
    }

    public void setString_catchPhrase(String string_catchPhrase) {
        this.string_catchPhrase = string_catchPhrase;
    }

    public String getString_bs() {
        return string_bs;
    }

    public void setString_bs(String string_bs) {
        this.string_bs = string_bs;
    }
}
