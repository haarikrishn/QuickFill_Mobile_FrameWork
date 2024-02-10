package com.DmartLabs.stepdefinitions;

import com.DmartLabs.bdd.pages.GenericLoginPage;
import com.DmartLabs.bdd.pages.picker1TwoHUspage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class picker1TwoHUsStep {


    picker1TwoHUspage picker1TwoHUspage=new picker1TwoHUspage();
    GenericLoginPage genericLoginPage=new GenericLoginPage();

    @When("user verify the items one By One  and move to pickList one HU")
    public void userVerifyTheItemsOneByOneAndMoveToPickListOneHU() throws InterruptedException {
        //=========================================
        genericLoginPage.ClickOnPickerAndValidate();
        Thread.sleep(2000);
        picker1TwoHUspage.PickListDetails();
        Thread.sleep(2000);
        picker1TwoHUspage.addElementsToListFirstHU();
        Thread.sleep(2000);
        picker1TwoHUspage.ClickItemOneByone();
        //=================================
        picker1TwoHUspage.ClickONViewHU();
        Thread.sleep(500);
        picker1TwoHUspage.HUpageIsDisplayed();
        Thread.sleep(2000);
        picker1TwoHUspage.ClickOnCloseHU();
    }

    @And("user verify the items one By One  and move to pickList Second HU")
    public void userVerifyTheItemsOneByOneAndMoveToPickListSecondHU() throws InterruptedException {

        // picker1TwoHUspage.scrollElementsForSecondHU();
        Thread.sleep(2000);
        picker1TwoHUspage.addElementsToListSecondHU();
        Thread.sleep(2000);
        picker1TwoHUspage.ClickItemOneByoneSecondHU();
        Thread.sleep(500);
        picker1TwoHUspage.HUpageIsDisplayed();
        Thread.sleep(2000);
        picker1TwoHUspage.ClickOnCloseHU();
    }

    @Then("verify Items picked or not In Two HUs")
    public void verifyItemsPickedOrNotInTwoHUs() throws InterruptedException {
        Thread.sleep(1000);
        picker1TwoHUspage.EmptyListDisplayed();
        System.out.println("Items successfully Picked");
    }


}
