package com.DmartLabs.commonutils;

import com.aventstack.extentreports.ExtentTest;
import io.appium.java_client.AppiumDriver;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.security.GeneralSecurityException;


public class QXClient {

    private AppiumDriver appiumDriver;
    private QXReport qxReport;
    private Gestures gestures;
    private WaitForUtils waitForUtils;
    private ExcelUtils excelUtils;
    private PropUtils clientUtils;
    private ScreenshotUtils screenshotUtils;
    private AssertUtils assertUtils;
    private LogUtils logUtils;
    private GSheetObject gSheetObject;
    public  static  ThreadLocal<String>threadSafeNormalDeliveryNumber=new ThreadLocal<>();
    public  static  ThreadLocal<String>threadSafeTwoHUsDeliveryNumber=new ThreadLocal<>();
    public  static  ThreadLocal<String>threadSafeIncorrectQuantityDeliveryNumber=new ThreadLocal<>();

    public QXClient(AppiumDriver appiumDriver){
        this.appiumDriver = appiumDriver;
    }

    public Gestures gestures(){
        if(this.gestures == null){
            this.gestures = new Gestures(this.appiumDriver);
        }

        return this.gestures;
    }

    public WaitForUtils waitUtils(){
        if(this.waitForUtils == null){
            this.waitForUtils = new WaitForUtils(this.appiumDriver);
        }

        return this.waitForUtils;
    }

    public ExcelUtils excelUtils(){
        if(this.excelUtils == null){
            this.excelUtils = new ExcelUtils();
        }
        return this.excelUtils;
    }

    public PropUtils propUtils(){
        if(this.clientUtils == null){
            this.clientUtils = new PropUtils();
        }

        return this.clientUtils;
    }

    public ScreenshotUtils screenshotUtils(){
        if(this.screenshotUtils == null){
            this.screenshotUtils = new ScreenshotUtils(this.appiumDriver);
        }

        return screenshotUtils;
    }

    public AssertUtils getAssertUtils(){
        if(this.assertUtils == null){
            this.assertUtils = new AssertUtils();
        }

        return this.assertUtils;
    }

    public GSheet GSheet(String sheetId) throws GeneralSecurityException, IOException {
        if(this.gSheetObject == null){
            this.gSheetObject = new GSheetObject();
        }

        return this.gSheetObject.getGSheet(sheetId);
    }

    public ExtentTest report(){
        return QXReport.getTest();
    }

    public Logger logger(){
        return GlobalSession.get().getLogUtils().getLogger();
    }

    private static ThreadLocal<QXClient> qualitrix = new ThreadLocal<>();

    public static void setQX(QXClient qx) {
        qualitrix.set(qx);
    }

    public static QXClient get(){
        return qualitrix.get();
    }

    public AppiumDriver driver(){
        return this.appiumDriver;
    }

    public  static  String getNormalDeliveryNumber()
    {
        return threadSafeNormalDeliveryNumber.get();
    }
    public  static  void setNormalDeliveryNumber(String NormalDeliveryNumber)
    {
        QXClient.threadSafeNormalDeliveryNumber.set(NormalDeliveryNumber);
    }
    //threadSafeTwoHUsDeliveryNumber
    public  static  String getTwoHUsDeliveryNumber(String TwoHUsDeliveryNumber)
    {
        return threadSafeTwoHUsDeliveryNumber.get();
    }
    public  static  void setTwoHUsDeliveryNumber(String TwoHUsDeliveryNumber)
    {
        QXClient.threadSafeTwoHUsDeliveryNumber.set(TwoHUsDeliveryNumber);
    }

    //threadSafeIncorrectQuantityDeliveryNumber
    public  static  String getIncorrectQuantityDeliveryNumber(String IncorrectQuantityDeliveryNumber)
    {
        return threadSafeIncorrectQuantityDeliveryNumber.get();
    }

    public  static  void setIncorrectQuantityDeliveryNumber(String IncorrectQuantityDeliveryNumber)
    {
        QXClient.threadSafeIncorrectQuantityDeliveryNumber.set(IncorrectQuantityDeliveryNumber);
    }


}
