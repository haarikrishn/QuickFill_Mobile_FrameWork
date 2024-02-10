package com.DmartLabs.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Ios {
    @SerializedName("bundleId")
    @Expose
    private String bundleId;
    @SerializedName("browserName")
    @Expose
    private String browserName;

    public String getBundleId() {
        return bundleId;
    }

    public void setBundleId(String bundleId) {
        this.bundleId = bundleId;
    }

    public String getBrowserName() {
        return browserName;
    }

    public void setBrowserName(String browserName) {
        this.browserName = browserName;
    }
}
