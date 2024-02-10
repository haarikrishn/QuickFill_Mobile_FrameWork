package com.DmartLabs.stepdefinitions;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.aventstack.extentreports.ExtentTest;
import com.DmartLabs.commonutils.*;
import com.DmartLabs.model.Device;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.DmartLabs.config.Global;
import com.aventstack.extentreports.Status;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;

public class Hooks {


	public Hooks() {

	}

	@Before
	public void setUp() {

		String capabilitiesJSONPath = System.getProperty("prop.capabilities");


		System.out.println("AlterSuite");
		System.out.println("prop.capabilities: " + System.getProperty("prop.capabilities"));


		AppiumManagerUtils utils = new AppiumManagerUtils();
		Global.setConfig(utils.getConfigJSON(capabilitiesJSONPath).toString());

		//this.generateTestNGXML(suites, Global.getConfig().getDevices());

		this.createHtmlReportFile();

		List<Device> devices = Global.getConfig().getDevices();
		for(Device device: Global.getConfig().getDevices()){
			this.setAppiumManager(device.getName(), device.getVersion(), device.getPlatform());
		}
		System.out.println("@Start: ITestContext");
		GlobalSession.set(new GlobalSession());
		AppiumManager appiumManager = Global.getAvailableDevice();
		if (appiumManager != null) {
			GlobalSession.get().setAppiumManager(appiumManager);
			if(Global.getConfig().isLocal()){
				try {
					appiumManager.startAppiumServer();
					System.out.println("in side before");
				} catch (Exception e) {
					System.out.println("Exception onStart: " + e.getMessage());
					e.printStackTrace();
				}
			}
		}

		try {
			GlobalSession g=  GlobalSession.get();

			AppiumManager	am=	g.getAppiumManager();

			am.createDriver();
			Thread.sleep(5000);
			QXReport.getTest().log(Status.PASS, "Application Launched Successfully");
		} catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
			e.printStackTrace();
			//Cant't throw because don't know if client using driver in his testcase.
			//throw new RuntimeException("Driver not created: " + e.getMessage());
		}
		QXClient.setQX(new QXClient(AppiumManager.getAppiumDriver()));

		ExtentTestManager.InitReport();
	}



	private void setAppiumManager(String deviceName, String version, String platform) {
		System.out.println(this.getClass().getSimpleName() + ": Set Appium Manager");
		String automationType = getAutomationType(platform);
		AppiumManager appiumManager = new AppiumManager(deviceName, version, platform, automationType);
		this.setDeviceReportPath(appiumManager);
		Global.addAppiumManagerToList(appiumManager);
	}

	private String getAutomationType(String platform){
		String automationType = "";
		if(platform.equalsIgnoreCase("android")){
			if(Global.getConfig().getCapabilities().getAndroid().getAppPackage() != null ){
				automationType = "native";
			}else if (Global.getConfig().getCapabilities().getAndroid().getBrowserName() !=null){
				automationType = "browser";
			}
		}
		else if(platform.equalsIgnoreCase("ios")){
			if(Global.getConfig().getCapabilities().getIos().getBundleId() != null ){
				automationType = "native";
			}else if (Global.getConfig().getCapabilities().getIos().getBrowserName() !=null){
				automationType = "browser";
			}
		}
		return automationType;
	}

	private void createHtmlReportFile(){
		Date date = new Date() ;
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss") ;
		String reportPath = System.getProperty("user.dir") + File.separator +"reports" + File.separator + "Report_" + dateFormat.format(date);
		File file = new File(reportPath);
		file.mkdir();
		Global.setReportPath(reportPath);
	}

	private void setDeviceReportPath(AppiumManager appiumManager){
		String folderPath = Global.getReportPath() + File.separator + appiumManager.getDeviceName();
		File file = new File(folderPath);
		file.mkdir();
		appiumManager.setReportPath(folderPath);

		folderPath = Global.getReportPath() + File.separator + appiumManager.getDeviceName() + File.separator + "screenshots";
		file = new File(folderPath);
		file.mkdir();

		folderPath = Global.getReportPath() + File.separator + appiumManager.getDeviceName() + File.separator + "logs";
		file = new File(folderPath);
		file.mkdir();
	}




	@BeforeStep()
	public void beforeScenarioStart(Scenario scenario) throws IOException {
		ExtentTest testReport = ExtentTestManager.createTest(scenario.getName(),
				GlobalSession.get().getAppiumManager().getDeviceName());

		QXReport.setTestReport(testReport);

		/*
		 * String testName = iTestResult.getMethod().getMethodName() + " " + this;
		 * System.out.println("@onTestStart: " + iTestResult.getMethod().getMethodName()
		 * + this); // Author author =
		 * iTestResult.getMethod().getConstructorOrMethod().getMethod().getAnnotation(
		 * Author.class); Skip skip =
		 * iTestResult.getMethod().getConstructorOrMethod().getMethod().getAnnotation(
		 * Skip.class); ExtentTest testReport = ExtentTestManager
		 * .createTest(iTestResult.getMethod().getMethodName(),
		 * GlobalSession.get().getAppiumManager().getDeviceName());
		 *
		 * QXReport.setTestReport(testReport);
		 */



	}


	@AfterStep(order = 1)
	public void addScreenshot(Scenario scenario) throws IOException {
		if(scenario.isFailed()) {
			File screenshot = ((TakesScreenshot) QXClient.get().driver()).getScreenshotAs(OutputType.FILE);
			byte[] fileContent = FileUtils.readFileToByteArray(screenshot);
			scenario.attach(fileContent,"image/png", "screenshot");
		}
/*

			  if(AppiumManager.getAppiumDriver() != null){ QXReport.getTest().log(
			  Status.FAIL ,result.getThrowable().getMessage()); String base64 =
			  QXClient.get().screenshotUtils().captureBase64();
			  System.out.print("@Base64: " + base64);
			  QXReport.getTest().addScreenCaptureFromBase64String(QXClient.get().
			  screenshotUtils().captureBase64(), result.getMethod().getMethodName()); try {
			  QXReport.getTest().fail(result.getMethod().getMethodName(),
			  MediaEntityBuilder.createScreenCaptureFromBase64String(base64).build()); }
			  catch (IOException e) { e.printStackTrace(); } }else{
			  QXReport.getTest().log(Status.FAIL, "Driver not created");
			  QXReport.getTest().log( Status.FAIL ,result.getMethod().getMethodName() +
			  " Failed"); }

			  GlobalSession.get().getAppiumManager().quitDriver();
*/

	}

	@After
	public void tearDown() {
		System.out.println("@OnFinish: ITestContext");
		System.out.println("@Stop Appium Server");
		try {
			GlobalSession.get().getAppiumManager().stopAppiumServer();
			System.out.println("Stopped appium server...");
		} catch (Exception e) {
			System.out.println("Exception onStop Appium Server: " + e.getMessage());
		}
		ExtentManager.getExtent().flush();
		GlobalSession.get().getAppiumManager().quitDriver();

	}

}