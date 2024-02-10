package com.DmartLabs.commonutils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.DmartLabs.annotation.values.Author;
import com.aventstack.extentreports.Status;


/**
 * Created by Qualitrix on DD/MM/YYY.
 * @author Sandhya
 */

public class ExtentTestManager {

	private static ExtentTest extentTtest;
	public static ExtentReports extentReports;

	public static void InitReport(){
		extentReports = ExtentManager.getExtent();
	}

	public synchronized static ExtentTest createTest(String name, String description, String deviceId) {
		extentTtest = extentReports.createTest(name, description).assignCategory(deviceId);
		return extentTtest;
	}

	public synchronized static ExtentTest createTest(String name, String deviceId) {
		extentTtest = extentReports.createTest(name).assignCategory(deviceId);
		return extentTtest;
	}

	public synchronized static ExtentTest createTest(String name, String deviceId, Author author) {
		extentTtest = extentReports.createTest(name).assignCategory(deviceId).assignAuthor(author.name());
		return extentTtest;
	}
	public static void logPass(String log) {
		extentTtest.pass(log);
	}

	public static void logFail(String log) {
		extentTtest.fail(log);
	}

	public static void logError(String log, Throwable throwable) {
		extentTtest.fail(log);
		extentTtest.log(Status.FAIL, "Error details:");
	}

	public static void logInfo(String log) {
		extentTtest.info(log);
	}

	public static void logScreenshot(String screenshotPath) {
		extentTtest.addScreenCaptureFromPath(screenshotPath);
	}

}

