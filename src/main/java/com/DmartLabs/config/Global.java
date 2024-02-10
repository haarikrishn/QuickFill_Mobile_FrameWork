package com.DmartLabs.config;

import com.DmartLabs.commonutils.AppiumManager;

import java.util.ArrayList;
import java.util.List;

public class Global {

    private static Config config;
    private static String reportPath;

    private static List<AppiumManager> appiumManagerList = new ArrayList<AppiumManager>();

    public static void setConfig(String configJSON){
        config = new Config(configJSON);
    }

    public static Config getConfig(){
        return  config;
    }

    public synchronized  static void addAppiumManagerToList(AppiumManager appiumManager){
        appiumManagerList.add(appiumManager);
        System.out.println("size is"+appiumManagerList.size());


    }

    public synchronized  static List<AppiumManager> getAppiumManagerList(){
        System.out.println("list size***"+appiumManagerList);
        return appiumManagerList;
    }


    public static void setReportPath(String reportPath) {
        Global.reportPath = reportPath;
    }

    public static String getReportPath() {
        return reportPath;
    }

    public static synchronized AppiumManager getAvailableDevice(){
        for (AppiumManager appiumManager1 : Global.getAppiumManagerList()) {
            if (appiumManager1.isAvailable()) {
                System.out.println("divise");

                appiumManager1.setAvailable(false);
                return appiumManager1;
            }
        }
        return null;
    }
}
