package com.DmartLabs.stepdefinitions;

import com.DmartLabs.bdd.pages.GenericLoginPage;
import com.DmartLabs.bdd.pages.PickerInvalidQuantityPage;
import com.DmartLabs.bdd.pages.picker1Page;
import com.DmartLabs.bdd.pages.picker1TwoHUspage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

public class PickerBoxTypeOnlineStep {

    com.DmartLabs.bdd.pages.picker1Page picker1Page =new picker1Page();
    com.DmartLabs.bdd.pages.picker1TwoHUspage picker1TwoHUspage=new picker1TwoHUspage();
    GenericLoginPage genericLoginPage=new GenericLoginPage();
    PickerInvalidQuantityPage pickerInvalidQuantityPage=new PickerInvalidQuantityPage();

    //normal flow
    @When("user verify the items one By One  and move to PickerSevenItems in box type")
    public void userVerifyTheItemsOneByOneAndMoveToPickerSevenItemsInBoxType() throws InterruptedException {
        genericLoginPage.ClickOnPickerAndValidate();
        Thread.sleep(2000);
        picker1Page.PickListDetails();
        picker1Page.addElementsToList();
        Thread.sleep(2000);
        picker1Page.ClickItemOneByone();
    }

    @And("moving remaining items to pick list in box type")
    public void movingRemainingItemsToPickListInBoxType() throws InterruptedException {
        Thread.sleep(500);
        picker1Page.addElementsToList1();
        picker1Page.ClickItemOneByone1();
        Thread.sleep(2000);
        picker1Page.clickOnContinuePicking();

    }
    //===========================================================================
    //two hus
    @When("user verify the items one By One  and move to pickList one HU in box type")
    public void userVerifyTheItemsOneByOneAndMoveToPickListOneHUInBoxType() throws InterruptedException {

        genericLoginPage.ClickOnPickerAndValidate();
        Thread.sleep(2000);
        picker1TwoHUspage.PickListDetails();
        Thread.sleep(2000);
        picker1TwoHUspage.addElementsToListFirstHU();
        Thread.sleep(2000);
        picker1TwoHUspage.ClickItemOneByone();
        //=================================
        picker1TwoHUspage.clicknViewPallet();
        Thread.sleep(100);
        picker1TwoHUspage.clickOnContinuePicking();

    }

    @And("user verify the items one By One  and move to pickList Second HU in box type")
    public void userVerifyTheItemsOneByOneAndMoveToPickListSecondHUInBoxType() throws InterruptedException {
        Thread.sleep(2000);
        picker1TwoHUspage.addElementsToListSecondHU();
        Thread.sleep(2000);
        picker1TwoHUspage.ClickItemOneByoneSecondHU();
        Thread.sleep(500);
        picker1TwoHUspage.clickOnContinuePicking();

    }
//====================================================================
    //invalid quantity

    @When("user verify the items one By One  and move to pickList with invalid Quantity in box type")
    public void userVerifyTheItemsOneByOneAndMoveToPickListWithInvalidQuantityInBoxType(DataTable dataTable) throws InterruptedException {
        Thread.sleep(2000);
        genericLoginPage.ClickOnPickerAndValidate();
        Thread.sleep(2000);
        pickerInvalidQuantityPage.PickListDetails();
        Thread.sleep(2000);
        pickerInvalidQuantityPage.addElementsToinvalidQuantity();
        Thread.sleep(2000);
        pickerInvalidQuantityPage.ClickItemOneByone(dataTable);



    }
    @And("moving remaining items to pick list for invalid Quantity in box type")
    public void movingRemainingItemsToPickListForInvalidQuantityInBoxType(DataTable dataTable) throws InterruptedException {

        pickerInvalidQuantityPage.addElementsToinvalidQuantity1();
        Thread.sleep(2000);
        pickerInvalidQuantityPage.ClickItemOneByone1(dataTable);
        Thread.sleep(100);
        pickerInvalidQuantityPage.clickOnContinuePicking();

    }

}
