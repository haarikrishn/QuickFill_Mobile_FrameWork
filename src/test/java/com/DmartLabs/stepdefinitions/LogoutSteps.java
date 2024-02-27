package com.DmartLabs.stepdefinitions;

import com.DmartLabs.bdd.pages.HomePage;
import com.DmartLabs.bdd.pages.LoaderPage;
import com.DmartLabs.commonutils.QXClient;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;

public class LogoutSteps {

    HomePage homePage;
    LoaderPage loaderPage;
//    com.DmartLabs.bdd.pages.picker1Page picker1Page;



    @Given("Logout the user from Loader application")
    public void logoutTheUserFromLoaderApplication() {
        QXClient.get().report().info("Logout the user from Loader application");
        loaderPage = new LoaderPage();
        loaderPage.logoutUser();
    }

    @Given("Logout the user from Picker application")
    public void logoutTheUserFromPickerApplication() {
        QXClient.get().report().info("Logout the user from Picker application");
//        picker1Page = new picker1Page();
//        picker1Page.logoutUser();
    }

    @And("Logout the user from application")
    public void logoutTheUserFromApplication() throws InterruptedException {
        QXClient.get().report().info("Logout the user from application");
        homePage = new HomePage();
        homePage.logoutUser();
    }
}
