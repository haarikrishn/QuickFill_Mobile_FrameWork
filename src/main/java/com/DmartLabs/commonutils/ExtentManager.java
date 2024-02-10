package com.DmartLabs.commonutils;

import java.io.File;
import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.DmartLabs.config.Global;

public class ExtentManager {

	private static ExtentReports extent;
//	private static Date date = new Date() ;
//	private static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss") ;
//	private static String reportPath = System.getProperty("user.dir") + File.separator +"reports" + File.separator + "Report_" + dateFormat.format(date);;
	public static ExtentReports getExtent() {
		if (extent == null) {
			try {
				extent = new ExtentReports();
				extent.attachReporter(getHtmlReporter());
				return extent;
			}catch (Exception e) {
				System.out.println("Exception while creating report html file.");
			}
		}
		return extent;
	}
	
	private static ExtentHtmlReporter getHtmlReporter() throws IOException {
//		String reportPath = getReportPath();
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(Global.getReportPath() + File.separator + "report.html");

		htmlReporter.loadXMLConfig(System.getProperty("user.dir") + "/src/main/resources/extent.xml");
		htmlReporter.config().setDocumentTitle(Global.getConfig().getProperties().getReportName());
		htmlReporter.config().setReportName(Global.getConfig().getProperties().getReportName());
		htmlReporter.config().setTheme(Theme.STANDARD);
		return htmlReporter;
	}

//	private static String getReportPath(){
//
////		String folderName = "Report_" + dateFormat.format(date);
//		String reportName = "report.html";
//
//		GlobalSession.setGlobalSession(new GlobalSession());
//		GlobalSession.getGlobalSession().setReportPath(reportPath);
//
//
////		File file = new File(reportPath + File.separator + folderName);
////		file.mkdir();
//		setDeviceReportPath();
//		return reportPath + File.separator + reportName;
//	}
//
//	public static  void setDeviceReportPath(){
//		for(AppiumManager appiumManager: Global.getAppiumManagerList()){
//			String deviceName = appiumManager.getDeviceName();
//			String folderName = deviceName + "_" + dateFormat.format(date);
//			File file = new File(reportPath + File.separator + folderName);
//			file.mkdir();
//
//			appiumManager.setReportPath(file.getPath());
//		}
//	}
}
