package com.DmartLabs.commonutils;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.ServerSocket;

public class AppiumManagerUtils {

    public static int getFreePort() throws Exception {
        int port = 0;
        try {
            ServerSocket socket = new ServerSocket(0);
            socket.setReuseAddress(true);
            port = socket.getLocalPort();
            socket.close();
        } catch (Exception e) {
            System.err.println("Exception while generating free port.");
            e.printStackTrace();
        }
        return port;
    }

    public static String getNodePath() throws IOException, InterruptedException {
        String jsPaths = null;
        String nodePath = null;

        Process p;
        BufferedReader reader;
        String operatingSystem = System.getProperty("os.name");

        if (operatingSystem.contains("Win")) {
            String whereAppium = "where" + " " + "node";
            p = Runtime.getRuntime().exec(whereAppium);
            reader = new BufferedReader(new InputStreamReader(p.getInputStream()));

            while ((jsPaths = reader.readLine()) != null) {
                nodePath = jsPaths;
                break;
            }

            p.waitFor();
            p.destroy();

            if (nodePath == null) {
                System.exit(0);
            }
        } else {
            String command = "which " + "node";
            p = Runtime.getRuntime().exec(command);
            p.waitFor();
            reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String line = "";

            while ((line = reader.readLine()) != null) {
                nodePath = line;
                break;
            }

            p.destroy();
            if (nodePath == null) {
                System.exit(0);
            }
        }

        System.out.println("nodePath: " + nodePath);
        return nodePath;
    }

    public static String getAppiumJSPath() throws IOException, InterruptedException {

        String jsPaths = null;
        String actualJSPath = null;
        String operatingSystem = System.getProperty("os.name");

        if (operatingSystem.contains("Win")) {
            String whereAppium = "where" + " " + "appium";
            Process p = Runtime.getRuntime().exec(whereAppium);
            BufferedReader stdInput = new BufferedReader(new InputStreamReader(p.getInputStream()));

            while ((jsPaths = stdInput.readLine()) != null) {
                actualJSPath = jsPaths.replace("appium", "node_modules\\appium\\build\\lib\\main.js");
                break;
            }
            p.waitFor();
            p.destroy();

            if (actualJSPath == null) {
                System.exit(0);
            }
        } else {
            actualJSPath = "//usr//local//lib//node_modules//appium//build//lib//main.js";
        }

        System.out.println("AppiumJSPath: " + actualJSPath);
        return actualJSPath;
    }

    public JSONObject getConfigJSON(String jsonPath){
        if(jsonPath == null){
            jsonPath = System.getProperty("user.dir") + File.separator + "caps" + File.separator + "capabilities.json";
        }
        JsonParser jsonParser = new JsonParser(jsonPath);
        return jsonParser.getObjectFromJSON();
    }

    public boolean isLocalHost(String host)  {
        try {
            if(host.equalsIgnoreCase("localhost") || host.equalsIgnoreCase("http://localhost") || host.equals("127.0.0.1") || host.equals("0.0.0.0")) {
                return true;
            }

            // Compare public IP address
            String requestHostAddress = InetAddress.getByName(host).getHostAddress();
            String myHostAddress = InetAddress.getLocalHost().getHostAddress();
            System.out.println("requestHostAddress: " + requestHostAddress);
            System.out.println("myHostAddress: " + myHostAddress);

            if(requestHostAddress.equals(myHostAddress)) {
                return true;
            }
        } catch (Exception e) {
            System.err.println("--Exception while checking isMyLocalAdress");
        }

        return false;
    }

    public static int getMajorVersion(String version){
        System.out.println("Debug ...." + version.indexOf("."));
        String major = version.substring(0, version.indexOf("."));
        return  Integer.parseInt(major);
    }
}
