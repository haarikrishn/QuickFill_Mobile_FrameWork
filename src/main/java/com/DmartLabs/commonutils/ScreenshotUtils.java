package com.DmartLabs.commonutils;

import com.DmartLabs.commonutils.*;
import io.appium.java_client.AppiumDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

public class ScreenshotUtils {

    AppiumDriver driver;

    public ScreenshotUtils(AppiumDriver driver){
        this.driver = driver;
    }

    public String captureBase64(){
        TakesScreenshot newScreen = (TakesScreenshot) driver;
        String scnShot = newScreen.getScreenshotAs(OutputType.BASE64);
        return "data:image/jpg;base64, " + scnShot;
    }

    public File captureFile() throws IOException {
        System.out.println("GlobalSession.get(): " + GlobalSession.get());
        System.out.println("AppiumManger: " + GlobalSession.get().getAppiumManager());
        String path = GlobalSession.get().getAppiumManager().getReportPath() + File.separator + "screenshots" + File.separator + UUID.randomUUID().toString() + ".jpg";
        System.out.println("@Path: " + path);
        return this.captureFile(path);
    }

    public File captureFile(String filePath) throws IOException {
        return this.captureFile(new File(filePath));
    }

    public File captureFile(File file) throws IOException {
        File screenshotFile = ((TakesScreenshot)this.driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshotFile, file);
        return file;
    }
}