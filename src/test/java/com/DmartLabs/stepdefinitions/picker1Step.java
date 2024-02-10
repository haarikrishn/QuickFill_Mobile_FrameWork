package com.DmartLabs.stepdefinitions;

import com.DmartLabs.bdd.pages.GenericLoginPage;
import com.DmartLabs.bdd.pages.picker1Page;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class picker1Step {

    picker1Page picker1Page =new picker1Page();
    GenericLoginPage genericLoginPage=new GenericLoginPage();
    @When("user verify the items one By One  and move to pickList")
    public void userVerifyTheItemsOneByOneAndMoveToPickList() throws InterruptedException {
        genericLoginPage.ClickOnPickerAndValidate();
        Thread.sleep(2000);
        picker1Page.PickListDetails();
        picker1Page.addElementsToList();
        Thread.sleep(2000);
        picker1Page.ClickItemOneByone();
        Thread.sleep(2000);
        picker1Page.HUpageIsDisplayed();
        Thread.sleep(2000);
        picker1Page.ClickOnCloseHU();
    }
    //==================================================================================
//    @Then("verify Items picked or not")
//    public void verifyItemsPickedOrNotInPositiveFlow() throws InterruptedException {
//        Thread.sleep(1000);
//        picker1Page.EmptyListDisplayed();
//    }
    //==============================================================================
//picker with 7 items
    @When("user verify the items one By One  and move to PickerSevenItems")
    public void userVerifyTheItemsOneByOneAndMoveToPickerSevenItems() throws InterruptedException {

        genericLoginPage.ClickOnPickerAndValidate();
        Thread.sleep(2000);
        picker1Page.PickListDetails();
        picker1Page.addElementsToList();
        Thread.sleep(2000);
        picker1Page.ClickItemOneByone();
    }
    @And("moving remaining items to pick list")
    public void movingRemainingItemsToPickList() throws InterruptedException {
        //   picker1Page.PickListDetails();
        Thread.sleep(500);
        picker1Page.addElementsToList1();
        picker1Page.ClickItemOneByone1();
        Thread.sleep(2000);
        picker1Page.HUpageIsDisplayed();
        Thread.sleep(2000);
        picker1Page.ClickOnCloseHU();
    }

    @Then("verify Items picked or not positiveFlow")
    public void verifyItemsPickedOrNotPositiveFlow() throws InterruptedException {
        Thread.sleep(1000);
        picker1Page.EmptyListDisplayed();
    }

}
