package com.example.prayertime.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

class Month {

    @SerializedName("number")
    @Expose
    private Integer number;
    @SerializedName("en")
    @Expose
    private String en;

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getEn() {
        return en;
    }

    public void setEn(String en) {
        this.en = en;
    }

}
