package com.DmartLabs.stepdefinitions;

import com.DmartLabs.bdd.pages.GenericLoginPage;
import com.DmartLabs.bdd.pages.PickerInvalidQuantityPage;
import com.DmartLabs.bdd.pages.picker1Page;
import com.DmartLabs.bdd.pages.picker1TwoHUspage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

public class PickerIncorrectPickSequencePalletTypeOnline {

    com.DmartLabs.bdd.pages.picker1Page picker1Page =new picker1Page();
    GenericLoginPage genericLoginPage=new GenericLoginPage();
    com.DmartLabs.bdd.pages.picker1TwoHUspage picker1TwoHUspage=new picker1TwoHUspage();
    PickerInvalidQuantityPage pickerInvalidQuantityPage=new PickerInvalidQuantityPage();

    //invalid sequence Pallet Type
    //normal flow
    @When("user verify the items one By One  and move to PickerSevenItems with InvalidSequencePalletType")
    public void userVerifyTheItemsOneByOneAndMoveToPickerSevenItemsWithInvalidSequencePalletType() throws InterruptedException {
        genericLoginPage.ClickOnPickerAndValidate();
        Thread.sleep(2000);
        picker1Page.PickListDetails();
        // picker1Page.addElementsToList();
        picker1Page.addElementsToSetBoxType();
        Thread.sleep(2000);
        picker1Page.ClickItemOneByoneInBoxInvalidSequence();

    }

    @And("moving remaining items to pick list with invalidSequencePalletType")
    public void movingRemainingItemsToPickListWithInvalidSequencePalletType() throws InterruptedException {
        Thread.sleep(500);
        picker1Page.addElementsToBoxSet1();
        picker1Page.ClickItemOneByoneInBoxInvalidSequence1();
        Thread.sleep(2000);
        picker1Page.ClickOnCloseHU();

    }

    // 2 hus
    //===========================================================================
    @When("user verify the items one By One  and move to pickList one HU invalidSequencePalletType")
    public void userVerifyTheItemsOneByOneAndMoveToPickListOneHUInvalidSequencePalletType() throws InterruptedException {
        genericLoginPage.ClickOnPickerAndValidate();
        Thread.sleep(2000);
        picker1TwoHUspage.PickListDetails();
        Thread.sleep(2000);
        picker1TwoHUspage.addElementsToSetBoxType();
        Thread.sleep(2000);
        picker1TwoHUspage.ClickItemOneByoneInBoxInvalidSequence();
        //=================================
        picker1TwoHUspage.ClickONViewHU();
        Thread.sleep(500);
        picker1TwoHUspage.HUpageIsDisplayed();
        Thread.sleep(2000);
        picker1TwoHUspage.ClickOnCloseHU();
    }

    @And("user verify the items one By One  and move to pickList Second HU invalidSequencePalletType")
    public void userVerifyTheItemsOneByOneAndMoveToPickListSecondHUInvalidSequencePalletType() throws InterruptedException {
        Thread.sleep(2000);
        picker1TwoHUspage.addElementsToBoxSet1();
        Thread.sleep(2000);
        picker1TwoHUspage.ClickItemOneByoneInBoxInvalidSequence1();
        Thread.sleep(500);
        //   Thread.sleep(100);
        picker1TwoHUspage.ClickOnCloseHU();
    }



    //invalid quntity
    //=======================================================================================
    @When("user verify the items one By One  and move to pickList with invalid Quantity with invalidSequencePalletType")
    public void userVerifyTheItemsOneByOneAndMoveToPickListWithInvalidQuantityWithInvalidSequencePalletType(DataTable dataTable) throws InterruptedException {

        Thread.sleep(2000);
        genericLoginPage.ClickOnPickerAndValidate();
        Thread.sleep(2000);
        pickerInvalidQuantityPage.PickListDetails();
        Thread.sleep(2000);
        pickerInvalidQuantityPage.addElementsToSetBoxType();
        Thread.sleep(2000);
        pickerInvalidQuantityPage.ClickItemOneByoneInBoxInvalidSequence(dataTable);

    }

    @And("moving remaining items to pick list for invalid Quantity with invalidSequencePalletType")
    public void movingRemainingItemsToPickListForInvalidQuantityWithInvalidSequencePalletType(DataTable dataTable) throws InterruptedException {
        pickerInvalidQuantityPage.addElementsToBoxSet1();
        Thread.sleep(2000);
        pickerInvalidQuantityPage.ClickItemOneByoneInBoxInvalidSequence1(dataTable);
        Thread.sleep(100);
        pickerInvalidQuantityPage.ClickOnCloseHU();


    }

}
