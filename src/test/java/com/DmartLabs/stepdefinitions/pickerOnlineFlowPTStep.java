package com.DmartLabs.stepdefinitions;

import com.DmartLabs.bdd.pages.GenericLoginPage;
import com.DmartLabs.bdd.pages.PickerInvalidQuantityPage;
import com.DmartLabs.bdd.pages.picker1Page;
import com.DmartLabs.bdd.pages.picker1TwoHUspage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class pickerOnlineFlowPTStep {

    com.DmartLabs.bdd.pages.picker1Page picker1Page =new picker1Page();
    GenericLoginPage genericLoginPage=new GenericLoginPage();
    com.DmartLabs.bdd.pages.picker1TwoHUspage picker1TwoHUspage=new picker1TwoHUspage();
    PickerInvalidQuantityPage pickerInvalidQuantityPage=new PickerInvalidQuantityPage();


    //  GenericLoginPage genericLoginPage=new GenericLoginPage();
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
//================================================================================
//two hus

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
    //==============================================================================
    //invalid quantity

    @When("user verify the items one By One  and move to pickList with invalid Quantity")
    public void userVerifyTheItemsOneByOneAndMoveToPickListWithInvalidQuantity(DataTable dataTable) throws InterruptedException {
        Thread.sleep(2000);
        genericLoginPage.ClickOnPickerAndValidate();
        Thread.sleep(2000);
        pickerInvalidQuantityPage.PickListDetails();
        Thread.sleep(2000);
        pickerInvalidQuantityPage.addElementsToinvalidQuantity();
        Thread.sleep(2000);
        pickerInvalidQuantityPage.ClickItemOneByone(dataTable);
    }

    @And("moving remaining items to pick list for invalid Quantity")
    public void movingRemainingItemsToPickListForInvalidQuantity(DataTable dataTable) throws InterruptedException {

        //     pickerInvalidQuantityPage.PickListDetails();
        //   Thread.sleep(2000);
        pickerInvalidQuantityPage.addElementsToinvalidQuantity1();
        Thread.sleep(2000);
        pickerInvalidQuantityPage.ClickItemOneByone1(dataTable);
        pickerInvalidQuantityPage.HUpageIsDisplayed();
        Thread.sleep(2000);
        pickerInvalidQuantityPage.ClickOnCloseHU();
    }

    @Then("verify Items picked or not with invalid Quantity")
    public void verifyItemsPickedOrNotWithInvalidQuantity() throws InterruptedException {
        pickerInvalidQuantityPage.EmptyListDisplayed();
    }

}
