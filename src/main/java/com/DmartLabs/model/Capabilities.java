package com.DmartLabs.model;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Capabilities {

    @SerializedName("android")
    @Expose
    private Android android;
    @SerializedName("ios")
    @Expose
    private Ios ios;

    public Android getAndroid() {
        return android;
    }

    public void setAndroid(Android android) {
        this.android = android;
    }

    public Ios getIos() {
        return ios;
    }

    public void setIos(Ios ios) {
        this.ios = ios;
    }
}