package com.DmartLabs.stepdefinitions;

import com.DmartLabs.bdd.pages.GenericLoginPage;
import com.DmartLabs.bdd.pages.PickerInvalidQuantityPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class pickerInvalidQuantityStep {

    GenericLoginPage genericLoginPage=new GenericLoginPage();
    PickerInvalidQuantityPage pickerInvalidQuantityPage=new PickerInvalidQuantityPage();

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
