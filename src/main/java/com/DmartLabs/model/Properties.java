package com.DmartLabs.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Properties {
    @SerializedName("environment")
    @Expose
    private String environment;

    @SerializedName("reportName")
    @Expose
    private String reportName;

    public String getEnvironment() {
        return environment;
    }

    public void setEnvironment(String environment) {
        this.environment = environment;
    }

    public void setReportName(String reportName) {
        this.reportName = reportName;
    }

    public String getReportName() {
        return reportName;
    }
}
