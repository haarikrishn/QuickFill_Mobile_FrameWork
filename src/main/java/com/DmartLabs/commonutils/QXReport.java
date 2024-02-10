package com.DmartLabs.commonutils;

import com.aventstack.extentreports.ExtentTest;


public class QXReport {

    private static ThreadLocal<ExtentTest> testReport = new ThreadLocal<>();

    public static synchronized ExtentTest getTest() {
        return testReport.get();
    }

    public static synchronized void setTestReport(ExtentTest extent) {
        testReport.set(extent);
    }
}

