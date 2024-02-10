package com.DmartLabs.commonutils;

import com.DmartLabs.config.Global;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.AndroidServerFlag;
import io.appium.java_client.service.local.flags.IOSServerFlag;
import org.openqa.selenium.SessionNotCreatedException;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.Map;

public class AppiumManager {

    private final String IP_ADDRESS = "127.0.0.1";
    private AppiumDriverLocalService appiumDriverLocalService;
    private URL endpoint;
    private boolean isAvailable;
    private DesiredCapabilities desiredCapabilities;
    private String deviceName;
    private String version;
    private String platform;
    private String reportPath;
    private AppiumDriver driver;
    private boolean isAndroid;
    private boolean isIOS;
    private boolean isNative;
    private boolean isBrowser;
    private String automationType;

    public AppiumManager(String deviceName, String version, String platform, String automationType){
        this.deviceName = deviceName;
        this.version = version;
        this.isAvailable = true;
        this.platform = platform;
        this.automationType = automationType;
        this.setAutomationType();
    }

    private void setAutomationType(){
        if(this.platform.equalsIgnoreCase("android"))
            this.isAndroid = true;
        else if(this.platform.equalsIgnoreCase("ios"))
            this.isIOS = true;

        if(this.automationType.equalsIgnoreCase("native"))
            this.isNative = true;
        else if(this.automationType.equalsIgnoreCase("browser"))
            this.isBrowser = true;

    }

    public URL startAppiumServer() throws Exception {
        String logPath = this.reportPath + File.separator + "logs" + File.separator + "appium_log_" + System.currentTimeMillis() + ".txt";
        File logFile = new File(logPath);
        logFile.createNewFile();

        String bootStrapPort = Integer.toString(AppiumManagerUtils.getFreePort());
        String browserPort = Integer.toString(AppiumManagerUtils.getFreePort());
        int serverPort = AppiumManagerUtils.getFreePort();
        File fileJS = new File(AppiumManagerUtils.getAppiumJSPath());
        File nodeJSPath = new File(AppiumManagerUtils.getNodePath());

        AppiumServiceBuilder appiumServiceBuilder = new AppiumServiceBuilder();
        appiumServiceBuilder.withAppiumJS(fileJS);
        appiumServiceBuilder.usingDriverExecutable(nodeJSPath);
        appiumServiceBuilder.withIPAddress(IP_ADDRESS);
        appiumServiceBuilder.usingPort(serverPort);
        appiumServiceBuilder.withArgument(AndroidServerFlag.BOOTSTRAP_PORT_NUMBER, bootStrapPort);
        appiumServiceBuilder.withLogFile(logFile);

        if(this.isIOS){
            appiumServiceBuilder.withArgument(IOSServerFlag.WEBKIT_DEBUG_PROXY_PORT, browserPort);
        }else if(this.isAndroid){
            appiumServiceBuilder.withArgument(AndroidServerFlag.CHROME_DRIVER_PORT, browserPort);
        }

        return this.startServer(appiumServiceBuilder);
    }

    public URL startServer(AppiumServiceBuilder appiumServiceBuilder) throws Exception {
        this.appiumDriverLocalService = AppiumDriverLocalService.buildService(appiumServiceBuilder);
        this.appiumDriverLocalService.start();
        this.appiumDriverLocalService.clearOutPutStreams();

        if (this.appiumDriverLocalService.isRunning()) {
            System.out.println("Appium Server Started");
            this.endpoint = this.appiumDriverLocalService.getUrl();
            return this.endpoint;
        } else {
            System.out.println("Server startup failed");
            throw new SessionNotCreatedException("");
        }
    }

    public void stopAppiumServer(){
        this.appiumDriverLocalService.stop();
    }

    public URL getEndpoint(){
        return this.endpoint;
    }

    public void setEndpoint(URL endpoint) {
        this.endpoint = endpoint;
    }

    public void createDriver() throws Exception {
        System.out.println("Create Driver...");
        System.out.println(Global.getConfig().isLocal());
        if(Global.getConfig().isLocal())
        {
            System.out.println("Entering Set Caps Local Execution....");
            this.setLocalCapabilities();
        }
        else{
            System.out.println("Entering Set Caps Cloud Execution....");
            this.setCloudCapabilities();
        }
        this.setDriver();
    }

    private DesiredCapabilities setLocalCapabilities() throws Exception {
        System.out.println("setting capabilities");
        System.out.println("setting isAndroid: " + isAndroid);
        if(this.isAndroid) {
            this.desiredCapabilities = new DesiredCapabilities(Global.getConfig().getCapabilityMap("android"));
            desiredCapabilities.setCapability("systemPort", AppiumManagerUtils.getFreePort());
            if(AppiumManagerUtils.getMajorVersion(version) >=6)
                desiredCapabilities.setCapability("automationName", "uiautomator2");
            else
                desiredCapabilities.setCapability("automationName", "uiautomator1");
        }else {
            this.desiredCapabilities = new DesiredCapabilities(Global.getConfig().getCapabilityMap("ios"));
            desiredCapabilities.setCapability("wdaLocalPort", AppiumManagerUtils.getFreePort());
            if(AppiumManagerUtils.getMajorVersion(version) >= 9)
                desiredCapabilities.setCapability("automationName", "XCUITest");
        }

        this.desiredCapabilities.setCapability("platformVersion", this.version);

        if(Global.getConfig().isLocal()){
            desiredCapabilities.setCapability("deviceName", this.deviceName);
            desiredCapabilities.setCapability("udid", this.deviceName);
        }

        return desiredCapabilities;
    }

    private DesiredCapabilities setCloudCapabilities() throws Exception {
        this.desiredCapabilities = new DesiredCapabilities(Global.getConfig().getCapabilityMap("cloudCapabilities"));
        System.out.println(Arrays.asList(Global.getConfig().getCapabilityMap("cloudCapabilities")));
//        desiredCapabilities.setCapability("build","Lycaa Android");
//        desiredCapabilities.setCapability("name","Android Samsung Galaxy S22");
//        desiredCapabilities.setCapability("platformName", "android");
//        desiredCapabilities.setCapability("deviceName", "Galaxy S22 5G");
//        desiredCapabilities.setCapability("platformVersion", "13");
//        desiredCapabilities.setCapability("app", "lt://APP10160612541701335219010523");
//        desiredCapabilities.setCapability("video", true);
//        desiredCapabilities.setCapability("isRealMobile", true);

        return desiredCapabilities;
    }

    private void setDriver() throws MalformedURLException {
        if(this.isAndroid){
            if(Global.getConfig().isLocal()){
                System.out.println("Entering Set Driver Local Execution....");
                this.driver = new AndroidDriver (endpoint, this.desiredCapabilities);
            }
            else{
                System.out.println("Entering Set Driver Cloud Execution....");
                Map<String, Object> serverDetails = Global.getConfig().getCapabilityMap("cloud_server");
                String serverURL = "https://" + serverDetails.get("userName") + ":" + serverDetails.get("accessKey") + serverDetails.get("host");
                System.out.println(serverURL);
                this.endpoint = new URL(serverURL);
                this.driver = new AndroidDriver(endpoint, this.desiredCapabilities);
            }
            AppiumManager.setDriverToThreadLocal(this.driver);
        }else if(this.isIOS){
            this.driver = new IOSDriver (endpoint, this.desiredCapabilities);
            AppiumManager.setDriverToThreadLocal(this.driver);
        }
    }

    private static ThreadLocal<AppiumDriver<?>> appiumDriver = new ThreadLocal<AppiumDriver<?>>();

    public static void setDriverToThreadLocal(AppiumDriver<?> driver) {
        appiumDriver.set(driver);
    }

    public static AppiumDriver<?> getAppiumDriver(){
        return appiumDriver.get();
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public DesiredCapabilities getDesiredCapabilities() {
        return desiredCapabilities;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setReportPath(String reportPath) {
        this.reportPath = reportPath;
    }

    public String getReportPath() {
        return reportPath;
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

    public String getPlatform() {
        return platform;
    }

    public void quitDriver(){
try {
    if (this.driver != null) {
        this.driver.quit();
    }
}catch (Exception e){}
    }
}
