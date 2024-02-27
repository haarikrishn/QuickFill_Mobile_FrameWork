package com.DmartLabs.stepdefinitions;

import com.DmartLabs.bdd.pages.GenericLoginPage;
import com.DmartLabs.bdd.pages.PickerBoxAndPalletInvalidQuantityType11Page;
import com.DmartLabs.bdd.pages.PickerBoxAndPalletType11Page;
import com.DmartLabs.bdd.pages.PickerBoxAndpalletTypeTwoHU11Page;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

public class pickerOnlineFlowBoxAndPalletType11Step {

    PickerBoxAndPalletType11Page pickerBoxAndPalletType11Page=new PickerBoxAndPalletType11Page();
    GenericLoginPage genericLoginPage=new GenericLoginPage();
    PickerBoxAndpalletTypeTwoHU11Page pickerBoxAndpalletTypeTwoHU11Page=new PickerBoxAndpalletTypeTwoHU11Page();
    PickerBoxAndPalletInvalidQuantityType11Page pickerBoxAndPalletInvalidQuantityType11Page=new PickerBoxAndPalletInvalidQuantityType11Page();

    // @PickingSevenItemsOnlineBoxAndDispatchType
    @When("user verify the items one By One  and move to PickerSevenItems BoxAndDispatchType")
    public void userVerifyTheItemsOneByOneAndMoveToPickerSevenItemsBoxAndDispatchType() throws InterruptedException {

        genericLoginPage.ClickOnPickerAndValidate();
        Thread.sleep(2000);
        pickerBoxAndPalletType11Page.PickListDetailsBoxAndPalletType();
        Thread.sleep(2000);
        pickerBoxAndPalletType11Page.getDeliveryAllItemsPicker();
        Thread.sleep(2000);
      pickerBoxAndPalletType11Page.ClickItemOneByoneBoxAndPalletType();
        Thread.sleep(2000);
     pickerBoxAndPalletType11Page.VerifyDispatchTypeAndClosePalletOrHU();

    }

    //@PickerOneDeliveryTwoHUsOnlineBoxAndDispatchType
    @When("user verify the items one By One  and move to pickList one HU BoxAndDispatchType")
    public void userVerifyTheItemsOneByOneAndMoveToPickListOneHUBoxAndDispatchType(DataTable dataTable) throws InterruptedException {
        genericLoginPage.ClickOnPickerAndValidate();
        Thread.sleep(2000);
        pickerBoxAndpalletTypeTwoHU11Page.PickListDetailsBoxAndPalletType();
        Thread.sleep(2000);
        pickerBoxAndpalletTypeTwoHU11Page.getDeliveryAllItemsPicker1();
        //getDeliveryAllItemsPicker
        pickerBoxAndpalletTypeTwoHU11Page.ClickItemOneByoneBoxAndPalletTypeViewHu(dataTable);
        pickerBoxAndPalletType11Page.VerifyDispatchTypeAndClosePalletOrHU();


    }


    //@PickerInvalidQunatityOnlineBoxAndDispatchType

    @When("user verify the items one By One  and move to pickList with invalid Quantity BoxAndDispatchType")
    public void userVerifyTheItemsOneByOneAndMoveToPickListWithInvalidQuantityBoxAndDispatchType(DataTable dataTable) throws InterruptedException {
        genericLoginPage.ClickOnPickerAndValidate();

        Thread.sleep(2000);
        pickerBoxAndPalletInvalidQuantityType11Page.PickListDetailsBoxAndPalletType();
        Thread.sleep(2000);
        pickerBoxAndPalletInvalidQuantityType11Page.getDeliveryAllItemsPicker1();
        Thread.sleep(2000);
        pickerBoxAndPalletInvalidQuantityType11Page.GetDataFromDataTableDT(dataTable);

    }


    @And("user verify the items one By One  and move to pickList without InvalidQuantity")
    public void userVerifyTheItemsOneByOneAndMoveToPickListWithoutInvalidQuantity(DataTable dataTable) throws InterruptedException {

        Thread.sleep(200);
        pickerBoxAndPalletInvalidQuantityType11Page.ClickItemOneByoneBoxAndPalletTypeInvalidQtyDT(dataTable);

    }

    @And("user verify the items one By One  and move to pickList without InvalidQuantity remaining items")
    public void userVerifyTheItemsOneByOneAndMoveToPickListWithoutInvalidQuantityRemainingItems() throws InterruptedException {
        Thread.sleep(2000);
        //    pickerBoxAndPalletInvalidQuantityType11Page.ClickItemOneByoneBoxAndPalletTypeInvalidQtyDTFoRHUfullORPalletFull();
//                Thread.sleep(2000);
        pickerBoxAndPalletType11Page.getDeliveryAllItemsPickerHUitem1();
//     Thread.sleep(2000);
//        pickerBoxAndPalletType11Page.ClickItemOneByoneBoxAndPalletType();
//        Thread.sleep(2000);
        //  pickerBoxAndPalletType11Page.VerifyDispatchTypeAndClosePalletOrHU();


    }
}
