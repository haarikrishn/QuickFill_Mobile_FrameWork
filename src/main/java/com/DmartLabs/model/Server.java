package com.DmartLabs.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Server {
    @SerializedName("host")
    @Expose
    private String host;

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }
}
