package com.DmartLabs.stepdefinitions;

import com.DmartLabs.bdd.pages.GenericLoginPage;
import com.DmartLabs.bdd.pages.PickerBoxAndPalletInvalidQuantityType11Page;
import com.DmartLabs.bdd.pages.PickerBoxAndPalletType11Page;
import com.DmartLabs.bdd.pages.PickerBoxAndpalletTypeTwoHU11Page;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class pickerOfflineFlowBoxAndPalletType11Step {

    PickerBoxAndPalletType11Page pickerBoxAndPalletType11Page=new PickerBoxAndPalletType11Page();
    GenericLoginPage genericLoginPage=new GenericLoginPage();
    PickerBoxAndpalletTypeTwoHU11Page pickerBoxAndpalletTypeTwoHU11Page=new PickerBoxAndpalletTypeTwoHU11Page();
    PickerBoxAndPalletInvalidQuantityType11Page pickerBoxAndPalletInvalidQuantityType11Page=new PickerBoxAndPalletInvalidQuantityType11Page();

    // @PickingSevenItemsOBoxAndDispatchTypeoffline

    @When("user verify the items one By One  and move to PickerSevenItems BoxAndDispatchTypeOffline")
    public void userVerifyTheItemsOneByOneAndMoveToPickerSevenItemsBoxAndDispatchTypeOffline() throws InterruptedException {

        genericLoginPage.ClickOnPickerAndValidate();
        Thread.sleep(2000);
        pickerBoxAndPalletType11Page.PickListDetailsBoxAndPalletType();
        Thread.sleep(2000);
        pickerBoxAndPalletType11Page.getDeliveryAllItemsPicker();
        Thread.sleep(2000);
        pickerBoxAndPalletType11Page.ClickItemOneByoneBoxAndPalletTypeInOfflineMode();
        Thread.sleep(2000);
        pickerBoxAndPalletType11Page.VerifyDispatchTypeAndClosePalletOrHUInOfflineMode();

    }

    //@PickerOneDeliveryTwoHUsOnlineBoxAndDispatchTypeoffline
    @When("user verify the items one By One  and move to pickList one HU BoxAndDispatchTypeOffline")
    public void userVerifyTheItemsOneByOneAndMoveToPickListOneHUBoxAndDispatchTypeOffline(DataTable dataTable) throws InterruptedException {
        genericLoginPage.ClickOnPickerAndValidate();
        Thread.sleep(2000);
        pickerBoxAndpalletTypeTwoHU11Page.PickListDetailsBoxAndPalletType();
        Thread.sleep(2000);
        pickerBoxAndpalletTypeTwoHU11Page.getDeliveryAllItemsPicker1();
        Thread.sleep(2000);
        pickerBoxAndpalletTypeTwoHU11Page.ClickItemOneByoneBoxAndPalletTypeViewHuInofflineMode(dataTable);
        Thread.sleep(2000);
        pickerBoxAndPalletType11Page.VerifyDispatchTypeAndClosePalletOrHUInOfflineMode();



    }

    //@PickerInvalidQunatityOnlineBoxAndDispatchType offline

    @When("user verify the items one By One  and move to pickList with invalid Quantity BoxAndDispatchTypeOffline")
    public void userVerifyTheItemsOneByOneAndMoveToPickListWithInvalidQuantityBoxAndDispatchTypeOffline(DataTable dataTable) throws InterruptedException {
        genericLoginPage.ClickOnPickerAndValidate();

        Thread.sleep(2000);
        pickerBoxAndPalletInvalidQuantityType11Page.PickListDetailsBoxAndPalletType();
        Thread.sleep(2000);
        pickerBoxAndPalletInvalidQuantityType11Page.getDeliveryAllItemsPicker1();
        Thread.sleep(2000);
        pickerBoxAndPalletInvalidQuantityType11Page.GetDataFromDataTableDT(dataTable);
    }

    @And("user verify the items one By One  and move to pickList without InvalidQuantityOffline")
    public void userVerifyTheItemsOneByOneAndMoveToPickListWithoutInvalidQuantityOffline(DataTable dataTable) throws InterruptedException {

        pickerBoxAndPalletInvalidQuantityType11Page.ClickItemOneByoneBoxAndPalletTypeInvalidQtyDTInOfflineMode(dataTable);
    }

    @And("user verify the items one By One  and move to pickList without InvalidQuantity remaining itemsOffline")
    public void userVerifyTheItemsOneByOneAndMoveToPickListWithoutInvalidQuantityRemainingItemsOffline()throws InterruptedException {


        Thread.sleep(2000);
        //  pickerBoxAndPalletType11Page.VerifyDispatchTypeAndClosePalletOrHUInOfflineMode();
        pickerBoxAndPalletType11Page.getDeliveryAllItemsPickerHUitemOfflineMode1();



    }

    @Then("verify Items picked or not with invalid Quantity")
    public void verifyItemsPickedOrNotWithInvalidQuantity() throws InterruptedException {
        pickerBoxAndPalletType11Page.EmptyListDisplayed();
    }

//===========================================================================


}

