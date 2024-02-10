package com.DmartLabs.stepdefinitions;

import com.DmartLabs.bdd.pages.HomePage;
import com.DmartLabs.commonutils.QXClient;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class HomePageSteps {

    HomePage homePage;

    @Given("Verify that User is in PWP application's Home Page after login")
    public void verifyThatUserIsInPWPApplicationSHomePage() {
        QXClient.get().report().info("Verify that User is in PWP application's Home Page after login");
        homePage = new HomePage();
        homePage.isHomePageDisplayed();
    }

    @Given("Verify that User is in PWP application's Home Page")
    public void verifyThatUserIsInHomePage() {
        QXClient.get().report().info("Verify that User is in PWP application's Home Page");
        homePage = new HomePage();
        homePage.isHomePageDisplayed();
    }

    @When("Click on Loader Module to perform Loading operations")
    public void clickOnLoaderModuleToPerformLoadingOperations() {
        QXClient.get().report().info("Click on Loader Module to perform Loading operations");
        homePage.clickOnLoaderModule();

    }

    @When("Click on Picker Module to perform Picking operations")
    public void clickOnPickerModuleToPerformPickingOperations() {
        QXClient.get().report().info("Click on Picker Module to perform Picking operations");
        homePage.clickOnPickerModule();
    }
}
