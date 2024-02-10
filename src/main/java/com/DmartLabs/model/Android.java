package com.DmartLabs.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Android {
    @SerializedName("appPackage")
    @Expose
    private String appPackage;
    @SerializedName("appActivity")
    @Expose
    private String appActivity;
    @SerializedName("browserName")
    @Expose
    private String browserName;

    public String getAppPackage() {
        return appPackage;
    }

    public void setAppPackage(String appPackage) {
        this.appPackage = appPackage;
    }

    public String getAppActivity() {
        return appActivity;
    }

    public void setAppActivity(String appActivity) {
        this.appActivity = appActivity;
    }

    public String getBrowserName() {
        return browserName;
    }

    public void setBrowserName(String browserName) {
        this.browserName = browserName;
    }
}
