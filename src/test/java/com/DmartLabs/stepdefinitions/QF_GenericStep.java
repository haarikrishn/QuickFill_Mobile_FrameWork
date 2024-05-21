package com.DmartLabs.stepdefinitions;

import com.DmartLabs.bdd.pages.GenericLoginPage;
import com.DmartLabs.bdd.pages.PickerBoxAndPalletType11Page;
import com.DmartLabs.bdd.pages.QF_GenericLoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class QF_GenericStep {

    QF_GenericLoginPage qf_genericLoginPage=new QF_GenericLoginPage();

    @Given("Enter username {string} and password {string} to login to the QuickFill application")
    public void enterUsernameAndPasswordToLoginToTheQuickFillApplication(String username, String password) throws InterruptedException {
        Thread.sleep(5000);
        qf_genericLoginPage.ClickOnLogin(username,password);
        Thread.sleep(500);

    }



}

