package com.DmartLabs.commonutils;


import java.io.File;

public class GlobalSession {

    private String reportPath;
    private String screenshotPath;
    private String logPath;
    private LogUtils logUtils;

    private static ThreadLocal<GlobalSession> globalSession = new ThreadLocal<GlobalSession>();

    public static void set(GlobalSession globalSession) {
        GlobalSession.globalSession.set(globalSession);
    }

    public static GlobalSession get(){
        return globalSession.get();
    }

    private AppiumManager appiumManager;

    public void setAppiumManager(AppiumManager appiumManager) {
        this.appiumManager = appiumManager;
    }

    public AppiumManager getAppiumManager(){
        return this.appiumManager;
    }

    public void setReportPath(String reportPath) {
        this.reportPath = reportPath;
    }

    public String getReportPath() {
        return reportPath;
    }

    public void setScreenshotPath(String screenshotPath) {
        this.screenshotPath = screenshotPath;
    }

    public String getScreenshotPath() {
        return screenshotPath;
    }

    public void setLogPath(String logPath) {
        this.logPath = logPath;
    }

    public String getLogPath() {
        return logPath;
    }

    public LogUtils getLogUtils(){
        if(this.logUtils == null){
            this.logUtils = new LogUtils(GlobalSession.get().getAppiumManager().getReportPath() + File.separator + "logs" + File.separator + "execution.log");
        }
        return this.logUtils;
    }
}
