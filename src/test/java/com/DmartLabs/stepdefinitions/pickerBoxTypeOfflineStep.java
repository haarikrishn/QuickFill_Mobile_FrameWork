package com.DmartLabs.stepdefinitions;

import com.DmartLabs.bdd.pages.GenericLoginPage;
import com.DmartLabs.bdd.pages.PickerInvalidQuantityOfflinePage;
import com.DmartLabs.bdd.pages.picker1Page;
import com.DmartLabs.bdd.pages.picker1TwoHUsOfflinepage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.When;

public class pickerBoxTypeOfflineStep {

    GenericLoginPage genericLoginPage=new GenericLoginPage();
    picker1TwoHUsOfflinepage picker1TwoHUsOfflinepageObj=new picker1TwoHUsOfflinepage();
    PickerInvalidQuantityOfflinePage pickerInvalidQuantityOfflinePageObj=new PickerInvalidQuantityOfflinePage();
    com.DmartLabs.bdd.pages.picker1Page picker1Page =new picker1Page();

    //=============================================================================
//normal flow
    @When("user verify the items one By One  and move to PickerSevenItems in offline modeBoxType")
    public void userVerifyTheItemsOneByOneAndMoveToPickerSevenItemsInOfflineModeBoxType( ) throws InterruptedException {
        genericLoginPage.ClickOnPickerAndValidate();
        Thread.sleep(2000);
        picker1Page.PickListDetails();
        picker1Page.addElementsToList();
        Thread.sleep(2000);
        picker1Page.offlineModeClickItemOneByone();
        //   picker1Page.PickListDetails();
        Thread.sleep(500);
        picker1Page.addElementsToList1();
        picker1Page.offlineModeClickItemOneByone1();
        Thread.sleep(2000);
        // picker1Page.clickOnContinuePicking();
        picker1Page.clickOnContinuePickingInOffline();
    }
//===============================================================================================
    //two hus

    @When("user verify the items one By One  and move to pickList one HU in offlineBoxType")
    public void userVerifyTheItemsOneByOneAndMoveToPickListOneHUInOfflineBoxType( ) throws InterruptedException {

        genericLoginPage.ClickOnPickerAndValidate();
        Thread.sleep(2000);
        picker1TwoHUsOfflinepageObj.PickListDetailsInOffline();
        Thread.sleep(2000);
        picker1TwoHUsOfflinepageObj.addElementsToListFirstHUInOffline();
        Thread.sleep(2000);
        picker1TwoHUsOfflinepageObj.ClickItemOneByoneInoffline();
        Thread.sleep(100);
        picker1TwoHUsOfflinepageObj.clicknViewPallet();
        picker1TwoHUsOfflinepageObj.clickOnContinuePickingInOfflineTwoHU();


        // picker1TwoHUspage.scrollElementsForSecondHU();
        Thread.sleep(2000);
        picker1TwoHUsOfflinepageObj.addElementsToListSecondHUInOffline();
        Thread.sleep(2000);
        picker1TwoHUsOfflinepageObj.ClickItemOneByoneSecondHUInOffline();
        Thread.sleep(500);
        picker1TwoHUsOfflinepageObj.clickOnContinuePickingInOfflineTwoHU();

    }
//========================================================================================================

    //invalid qunatity
    @When("user verify the items one By One  and move to pickList with invalid Quantity in offline modeBoxType")
    public void userVerifyTheItemsOneByOneAndMoveToPickListWithInvalidQuantityInOfflineModeBoxType(DataTable dataTable) throws InterruptedException {

        Thread.sleep(2000);
        genericLoginPage.ClickOnPickerAndValidate();
        Thread.sleep(2000);
        pickerInvalidQuantityOfflinePageObj.PickListDetails();
        Thread.sleep(2000);
        pickerInvalidQuantityOfflinePageObj.addElementsToinvalidQuantity();
        Thread.sleep(2000);
        pickerInvalidQuantityOfflinePageObj.ClickItemOneByone(dataTable);
        Thread.sleep(2000);
        pickerInvalidQuantityOfflinePageObj.addElementsToinvalidQuantity1();
        Thread.sleep(2000);
        pickerInvalidQuantityOfflinePageObj.ClickItemOneByone1();
        Thread.sleep(100);
        pickerInvalidQuantityOfflinePageObj.clickOnContinuePickingInOffline();
    }

}
