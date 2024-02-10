package com.DmartLabs.stepdefinitions;

import com.DmartLabs.bdd.pages.GenericLoginPage;
import io.cucumber.java.en.Given;

public class GenericStep {
    GenericLoginPage genericLoginPage=new GenericLoginPage();
    @Given("Enter username {string} and password {string} to login to the picker application")
    public void enterUsernameAndPasswordToLoginToThePickerApplication(String username, String password) {
genericLoginPage.ClickOnLogin(username,password);
    }
}
