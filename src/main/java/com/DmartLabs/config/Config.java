package com.DmartLabs.config;

import com.google.gson.Gson;
import com.DmartLabs.model.Capabilities;
import com.DmartLabs.model.Configuration;
import com.DmartLabs.model.Device;
import com.DmartLabs.model.Properties;
import com.DmartLabs.model.Server;

import java.util.List;
import java.util.Map;

import org.json.JSONObject;

public class Config {

    private final Configuration configuration;
    private String configJSON;
    private boolean isLocal;
    private boolean isAndroid;
    private boolean isIOS;
    private boolean isNative;
    private boolean isBrowser;

    public  Config(String configJSON){
        this.configJSON = configJSON;
        this.configuration = new Gson().fromJson(configJSON, Configuration.class);

        if(this.configuration.getProperties().getEnvironment().equalsIgnoreCase("local")){
            this.isLocal = true;
        }
    }

    public boolean isLocal() {
        return isLocal;
    }

    public boolean isAndroid() {
        return isAndroid;
    }

    public boolean isIOS() {
        return isIOS;
    }

    public boolean isNative() {
        return isNative;
    }

    public boolean isBrowser() {
        return isBrowser;
    }

    public Capabilities getCapabilities(){
        return this.configuration.getCapabilities();
    }

    public Server getServer(){
        return this.configuration.getServer();
    }

    public String getConfigJSON() {
        return configJSON;
    }

    public Map<String, Object> getCapabilityMap(String platform){
        String configJSON = Global.getConfig().getConfigJSON();
        System.out.print("configJSON: " +configJSON);
        JSONObject jsonObject = new JSONObject(configJSON);

        if(platform.equalsIgnoreCase("android")){
            JSONObject capObject = jsonObject.getJSONObject("capabilities").getJSONObject("android");
            return capObject.toMap();
        }else if(platform.equalsIgnoreCase("ios")){
            JSONObject capObject = jsonObject.getJSONObject("capabilities").getJSONObject("ios");
            return capObject.toMap();
        }
        else{
            JSONObject capObject = jsonObject.getJSONObject(platform);
            return capObject.toMap();
        }
    }

    public List<Device> getDevices(){
        return this.configuration.getDevices();
    }

    public Properties getProperties(){
        return this.configuration.getProperties();
    }
}