package com.DmartLabs.stepdefinitions;

import com.DmartLabs.bdd.pages.LoginPage;
import com.DmartLabs.commonutils.QXClient;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;

import java.util.Map;

public class LoginSteps {

    @Given("Provide username and password to login to application")
    public void provideUsernameAndPasswordToLoginToApplication(DataTable dataTable) throws InterruptedException {
        QXClient.get().report().info("Provide username and password to login to application");
        Map<String, String> loginCredentials = dataTable.asMap(String.class, String.class);
        LoginPage loginPage = new LoginPage();
        loginPage.loginToPWP(loginCredentials);
    }
}
