package com.DmartLabs.stepdefinitions;

import com.DmartLabs.bdd.pages.GenericLoginPage;
import com.DmartLabs.bdd.pages.PickerBoxAndPalletType11Page;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class GenericStep {
    GenericLoginPage genericLoginPage=new GenericLoginPage();
    PickerBoxAndPalletType11Page pickerBoxAndPalletType11Page=new PickerBoxAndPalletType11Page();


    @Given("Enter username {string} and password {string} to login to the picker application")
    public void enterUsernameAndPasswordToLoginToThePickerApplication(String username, String password) throws InterruptedException {
        genericLoginPage.ClickOnLogin(username,password);
    }


    @Then("verify Items picked or not")
    public void verifyItemsPickedOrNot() throws InterruptedException {
        Thread.sleep(1000);

        pickerBoxAndPalletType11Page.EmptyListDisplayed();


    }
}

