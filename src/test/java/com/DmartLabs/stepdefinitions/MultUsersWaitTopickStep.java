package com.DmartLabs.stepdefinitions;


import com.DmartLabs.bdd.pages.GenericLoginPage;
import com.DmartLabs.bdd.pages.picker1Page;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

import java.util.concurrent.TimeUnit;

public class MultUsersWaitTopickStep {

    picker1Page picker1Page=new picker1Page();
    GenericLoginPage genericLoginPage=new GenericLoginPage();

    //================================================
    //multi user one
    @When("user verify the items one By One  and move to PickerSevenItemsfor Multiusers")
    public void userVerifyTheItemsOneByOneAndMoveToPickerSevenItemsforMultiusers() throws InterruptedException {
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

    @And("moving remaining items to pick list for multiUsers")
    public void movingRemainingItemsToPickListForMultiUsers() throws InterruptedException {

        Thread.sleep(500);
        picker1Page.addElementsToList1();
        picker1Page.ClickItemOneByone1();
        Thread.sleep(2000);
        picker1Page.HUpageIsDisplayed();
        Thread.sleep(2000);
        picker1Page.ClickOnCloseHU();
    }
//==============================================================================================================
    //multi user 2


    @When("user verify the items one By One  and move to PickerSevenItemsfor MultiuserTwo")
    public void userVerifyTheItemsOneByOneAndMoveToPickerSevenItemsforMultiuserTwo() throws InterruptedException {
        genericLoginPage.ClickOnPickerAndValidate();

        try {
            TimeUnit.MINUTES.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("after 1 minute starting execution");
        picker1Page.PickListDetails();

        picker1Page.addElementsToList();
        Thread.sleep(1000);
        picker1Page.ClickItemOneByone();
    }

    @And("moving remaining items to pick list for multiUserTwo")
    public void movingRemainingItemsToPickListForMultiUserTwo() throws InterruptedException {
        Thread.sleep(500);
        picker1Page.addElementsToList1();
        picker1Page.ClickItemOneByone1();
        Thread.sleep(2000);
        picker1Page.HUpageIsDisplayed();
        Thread.sleep(2000);
        picker1Page.ClickOnCloseHUInMultiUser();

    }

}
