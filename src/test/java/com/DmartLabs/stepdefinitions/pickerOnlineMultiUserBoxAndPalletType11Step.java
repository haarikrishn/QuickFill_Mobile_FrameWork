package com.DmartLabs.stepdefinitions;

import com.DmartLabs.bdd.pages.GenericLoginPage;
import com.DmartLabs.bdd.pages.PickerBoxAndPalletType11Page;
import io.cucumber.java.en.When;

import java.util.concurrent.TimeUnit;

public class pickerOnlineMultiUserBoxAndPalletType11Step {

    PickerBoxAndPalletType11Page pickerBoxAndPalletType11Page=new PickerBoxAndPalletType11Page();
    GenericLoginPage genericLoginPage=new GenericLoginPage();

    // @PickingSevenItemsOnlineBoxAndDispatchType
    @When("userOne verify the items one By One  and move to PickerSevenItems BoxAndDispatchType in multiUserOne")
    public void useroneVerifyTheItemsOneByOneAndMoveToPickerSevenItemsBoxAndDispatchTypeInMultiUserOne()  throws InterruptedException {

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


    //=======================================================================================================



    @When("userTwo verify the items one By One  and move to PickerSevenItems BoxAndDispatchType in multiUserTwo")
    public void usertwoVerifyTheItemsOneByOneAndMoveToPickerSevenItemsBoxAndDispatchTypeInMultiUserTwo() throws InterruptedException {
        genericLoginPage.ClickOnPickerAndValidate();
        Thread.sleep(2000);

        try {
            TimeUnit.SECONDS.sleep(150);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("after 1 minute starting execution");

        pickerBoxAndPalletType11Page.PickListDetailsBoxAndPalletType();
        Thread.sleep(2000);
        pickerBoxAndPalletType11Page.getDeliveryAllItemsPicker();
        Thread.sleep(2000);
        pickerBoxAndPalletType11Page.ClickItemOneByoneBoxAndPalletType();
        Thread.sleep(2000);

        pickerBoxAndPalletType11Page.VerifyDispatchTypeAndClosePalletOrHUMultiUserOnline();

    }
}

