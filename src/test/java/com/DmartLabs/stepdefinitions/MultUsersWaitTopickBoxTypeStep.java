package com.DmartLabs.stepdefinitions;

import com.DmartLabs.bdd.pages.GenericLoginPage;
import com.DmartLabs.bdd.pages.picker1Page;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

import java.util.concurrent.TimeUnit;

public class MultUsersWaitTopickBoxTypeStep {

    com.DmartLabs.bdd.pages.picker1Page picker1Page=new picker1Page();
    GenericLoginPage genericLoginPage=new GenericLoginPage();

    //================================================================================================
    //user one
    @When("user verify the items one By One  and move to PickerSevenItemsfor Multiusers In Boxtype")
    public void userVerifyTheItemsOneByOneAndMoveToPickerSevenItemsforMultiusersInBoxtype() throws InterruptedException {
        genericLoginPage.ClickOnPickerAndValidate();

        try {
            TimeUnit.SECONDS.sleep(30);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("after 1 minute starting execution");
        picker1Page.PickListDetails();

        picker1Page.addElementsToList();
        Thread.sleep(1000);
        picker1Page.ClickItemOneByone();

    }

    @And("moving remaining items to pick list for multiUsers InBoxtype")
    public void movingRemainingItemsToPickListForMultiUsersInBoxtype() throws InterruptedException {
        Thread.sleep(500);
        picker1Page.addElementsToList1();
        picker1Page.ClickItemOneByone1();
        Thread.sleep(2000);
        picker1Page.clickOnContinuePicking();

    }
    //===============================================================================================
    //user two
    @When("user verify the items one By One  and move to PickerSevenItemsfor MultiuserTwo In Boxtype")
    public void userVerifyTheItemsOneByOneAndMoveToPickerSevenItemsforMultiuserTwoInBoxtype() throws InterruptedException {
        genericLoginPage.ClickOnPickerAndValidate();

        try {
            TimeUnit.SECONDS.sleep(120);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("after 1 minute starting execution");
        picker1Page.PickListDetails();

        picker1Page.addElementsToList();
        Thread.sleep(1000);
        picker1Page.ClickItemOneByone();

    }

    @And("moving remaining items to pick list for multiUserTwo InBoxtype")
    public void movingRemainingItemsToPickListForMultiUserTwoInBoxtype() throws InterruptedException {
        Thread.sleep(500);
        picker1Page.addElementsToList1();
        picker1Page.ClickItemOneByone1();
        Thread.sleep(2000);
        //Thread.sleep(100);
        picker1Page.clickOnContinuePicking();
    }

}
