package com.example.prayertime.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

class Weekday {

    @SerializedName("en")
    @Expose
    private String en;

    public String getEn() {
        return en;
    }

    public void setEn(String en) {
        this.en = en;
    }
}
