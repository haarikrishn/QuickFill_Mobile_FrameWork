package com.DmartLabs.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Configuration {

    @SerializedName("properties")
    @Expose
    private Properties properties;
    @SerializedName("server")
    @Expose
    private Server server;
    @SerializedName("capabilities")
    @Expose
    private Capabilities capabilities;
    @SerializedName("devices")
    @Expose
    private List<Device> devices = null;

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    public Server getServer() {
        return server;
    }

    public void setServer(Server server) {
        this.server = server;
    }

    public Capabilities getCapabilities() {
        return capabilities;
    }

    public void setCapabilities(Capabilities capabilities) {
        this.capabilities = capabilities;
    }

    public List<Device> getDevices() {
        return devices;
    }

    public void setDevices(List<Device> devices) {
        this.devices = devices;
    }

}
