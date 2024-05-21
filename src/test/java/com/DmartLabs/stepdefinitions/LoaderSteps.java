package com.DmartLabs.stepdefinitions;

import com.DmartLabs.bdd.pages.*;
import com.DmartLabs.commonutils.Gestures;
import com.DmartLabs.commonutils.QXClient;
import com.aventstack.extentreports.ExtentTest;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class LoaderSteps {

    private LoaderPage loader;
    private DeliveryDetailsPage deliveryDetails;
    private HU_DetailPage huDetail;
    private static Map<String, String> expectedDeliveryNumber;
    private String dispatchType;
//    List<WebElement> allHUs;
    private List<String> huNumbers;
    private ConsolidateHUPage consolidateHU;
    private ConfirmMoveItemPage confirmMoveItem;
    private DamagedExceptionPage damagedExceptionPage;
    private ShortExceptionPage shortExceptionPage;
    private OtherExceptionPage otherExceptionPage;
    private Map<String, String> sourceHU;
    private List<Map<String, String>> exceptions;
    private static Map<String, String> itemName;
    private Gestures gestures;

    @Given("Verify that Loader is in Loader Page")
    public void verifyThatLoaderIsInLoaderPage() {
        QXClient.get().report().info("Verify that Loader is in Loader Page");
        loader = new LoaderPage();
        loader.isLoaderPageDisplayed();
    }

    @When("Provide the delivery number of a Delivery for which Loading Operation is to be performed")
    public void provideTheDeliveryNumberOfADeliveryForWhichLoadingOperationIsToBePerformed(DataTable dataTable) {
        QXClient.get().report().info("Provide the delivery number of a Delivery for which Loading Operation is to be performed");
        expectedDeliveryNumber = dataTable.asMap(String.class, String.class);
    }

    @When("Get the delivery number to load the Delivery into the truck")
    public void getTheDeliveryNumberToLoadTheDeliveryIntoTheTruck() {
        QXClient.get().report().info("Get the delivery number to load the Delivery into the truck");
        expectedDeliveryNumber = new HashMap<>();
        expectedDeliveryNumber.put("deliveryNumber", QXClient.getNormalDeliveryNumber());
    }

    @And("Search the delivery in a Loader Page")
    public void searchTheDeliveryInALoaderPage() {
        QXClient.get().report().info("Search the delivery in a Loader Page");
        String deliveryNumber = expectedDeliveryNumber.get("deliveryNumber");
        loader.searchDelivery(deliveryNumber);
    }

    @And("Verify that vehicle is assigned for a Delivery")
    public void verifyThatTruckIsAssignedForADelivery() {
        QXClient.get().report().info("Verify that Truck is assigned for a Delivery");
        loader.isVehicleAssigned(expectedDeliveryNumber);
    }

    @And("Verify the dispatch type of a delivery")
    public void verifyTheDispatchTypeOfADelivery() {
        QXClient.get().report().info("Verify the dispatch type of a delivery");
        dispatchType = loader.verifyDispatchType(expectedDeliveryNumber.get("deliveryNumber"));
    }

    @And("Check the picking progress of a delivery")
    public void checkThePickingProgressOfADelivery() {
        QXClient.get().report().info("Check the picking progress of a delivery");
        loader.checkPickProgress(expectedDeliveryNumber.get("deliveryNumber"));
    }

    @When("Load all the deliveries into the truck")
    public void loadAllTheDeliveriesIntoTheTruck() {
        loader.loadAllDeliveries();
    }

    @And("Click on Delivery Card")
    public void clickOnDeliveryCard1() {
        QXClient.get().report().info("Click on Delivery Card");
        loader.clickOnDeliveryCard1(expectedDeliveryNumber);
    }

    @Then("Verify that vehicle has not assigned for this delivery dialouge box is displayed")
    public void verifyThatVehicleHasNotAssignedForThisDeliveryDialougeBoxIsDisplayed() {
        QXClient.get().report().info("Verify that vehicle has not assigned for this delivery dialouge box is displayed");
        loader.isVehicleNotAssignedDialougeBoxDisplayed();
    }

    @And("Verify that loader is in Delivery Details Page")
    public void verifyThatLoaderIsInDeliveryDetailsPage() {
        QXClient.get().report().info("Verify that loader is in Delivery Details Page");
        deliveryDetails = new DeliveryDetailsPage();
//        allHUs = deliveryDetails.isDeliverDetailsPageDisplayed(expectedDeliveryNumber);
        huNumbers = deliveryDetails.isDeliverDetailsPageDisplayed(expectedDeliveryNumber);
    }

    @And("Verify the loaded boxes quantity")
    public void verifyTheLoadedBoxesQuantity() {
        QXClient.get().report().info("Verify the loaded boxes quantity");
        deliveryDetails.verifyBoxesLoaded();
    }

    @And("Verify the loaded article quantity")
    public void verifyTheLoadedArticleQuantity() {
        QXClient.get().report().info("Verify the loaded article quantity");
        deliveryDetails.verifyArticleLoaded();
    }

    @And("Verify the Box Exception quantity")
    public void verifyTheBoxExceptionQuantity() {
        QXClient.get().report().info("Verify the Box Exception quantity");
        deliveryDetails.verifyBoxException();
    }

    @And("Provide the Exceptions for items in a delivery")
    public void provideTheExceptionsForItemsInADelivery(DataTable dataTable) {
        QXClient.get().report().info("Provide the Exceptions for items in a delivery");
        exceptions = dataTable.asMaps();
        deliveryDetails.itemsException2(exceptions);
    }

    @Then("Verify that error message is displayed")
    public void verifyThatErrorMessageIsDisplayed() {
        QXClient.get().report().info("Verify that error message is displayed");
        for (Map<String, String> exception:exceptions) {
            if (exception.get("exceptionType").equals("Damaged")) {
                damagedExceptionPage = new DamagedExceptionPage();
                damagedExceptionPage.verifyDamagedBoxesErrorMessage();
            } else if (exception.get("exceptionType").equals("Short")) {
                shortExceptionPage = new ShortExceptionPage();
                shortExceptionPage.verifyShortBoxesErrorMessage();
            } else if (exception.get("exceptionType").equals("Other")) {
                otherExceptionPage = new OtherExceptionPage();
                otherExceptionPage.verifyOtherErrorMessage();
            }
        }
    }

    @And("Click on submit button")
    public void clickOnSubmitButton() {
    }

    @And("Go to OFFLINE Mode")
    public void goToOFFLINEMode() {
        Gestures.turnOffWiFi();
    }

    @And("Verify that Loader is in offline mode")
    public void verifyThatLoaderIsInOfflineMode() {
        deliveryDetails.verifyThatLoaderIsInOfflineMode();
    }

    @And("Click on CONSOLIDATE button")
    public void clickOnCONSOLIDATEButton() {
        deliveryDetails.clickONConsolidateButton();
    }

    @And("Provide source HU Number")
    public void provideSourceHUNumber(DataTable dataTable) {
        sourceHU = dataTable.asMap(String.class, String.class);
        deliveryDetails.provideSourceHU_Number(sourceHU.get("sourceHUNumber"));
    }

    @And("In Consolidate HU Page click on select all checkbox")
    public void inConsolidateHUPageClickOnSelectAllCheckbox() {
        consolidateHU = new ConsolidateHUPage();
        consolidateHU.clickOnSelectAllCheckBox();
    }

    @And("Click on MOVE button")
    public void clickOnMOVEButton() {
        consolidateHU.clickOnMoveButton();
    }

    @And("Provide the destination HU number")
    public void provideTheDestinationHUNumber(DataTable dataTable) {
        Map<String, String> destinationHU = dataTable.asMap(String.class, String.class);
        consolidateHU.provideDestinationHU_Number(destinationHU.get("destinationHUNumber"));
    }

    @And("Verify that Confirm Move Item page is displayed and click on OK button")
    public void verifyThatConfirmMoveItemPageIsDisplayedAndClickOnOKButton() {
        confirmMoveItem = new ConfirmMoveItemPage();
        confirmMoveItem.confirmMoveItems();
    }

    @And("Verify that HU is empty")
    public void verifyThatHUIsEmpty() {
        deliveryDetails.verifyThatHU_IsEmpty(sourceHU.get("sourceHUNumber"));
    }

    @And("Adjust the item's caselot in HU")
    public void adjustItemsCaselotInHU(DataTable dataTable) {
        QXClient.get().report().info("Adjust the item's caselot in HU");
        Map<String, String> itemAdjustmentDetails = dataTable.asMap(String.class, String.class);
        huDetail = new HU_DetailPage();
//        huDetail.adjustItemCaselot(allHUs,itemAdjustmentDetails);
//        huDetail.adjustItemCaselot(huNumbers,itemAdjustmentDetails);
    }

    @And("Adjust the item's caselot in HU 1")
    public void adjustItemsCaselotInHU1(DataTable dataTable) {
        List<Map<String, String>> itemAdjustmentDetails = dataTable.asMaps();
        huDetail = new HU_DetailPage();
//        huDetail.adjustItemCaselot(allHUs,itemAdjustmentDetails);
        huDetail.adjustItemCaselotNew(huNumbers,itemAdjustmentDetails);
    }

    @And("Load the delivery into the truck")
    public void loadTheDeliveryIntoTheTruck() {
        QXClient.get().report().info("Load the delivery into the truck");
        if (dispatchType.equals("PALLET DISPATCH")) {
            SoftAssert softAssert = deliveryDetails.loadHUs();
            softAssert.assertAll();
        } else if (dispatchType.equals("BOX DISPATCH"))
            deliveryDetails.loadBoxes();
    }

    @And("Adjust the boxes quantity in loaded item")
    public void lessenTheCaselotQuantityFromLoadedItem(DataTable dataTable) {
        QXClient.get().report().info("Adjust the boxes quantity in loaded item");
        List<Map<String, String>> loadedItemsAdjustmentDetails = dataTable.asMaps();
        deliveryDetails.adjustBoxesQuantityInLoadedItems(loadedItemsAdjustmentDetails);
    }

    @And("Load the Box type delivery with exception into the truck")
    public void loadTheBoxTypeDeliveryWithExceptionIntoTheTruck() {
        //deliveryDetails.loadBoxesWithExceptions();
    }

    @And("Load the HUs into the truck and verify that No Network Connection dialouge box and Remote Sync Icon is displayed or not")
    public void loadTheHUsIntoTheTruckAndVerifyThatNoNetworkConnectionDialougeBoxAndRemoteSyncIconIsDisplayedOrNot() {
        deliveryDetails.loadHUsInOfflineMode();
    }

    @And("Provide HU number not to be loaded and load the remaining HUs into the truck")
    public void provideHUNumberNotToBeLoadedAndLoadTheRemainingHUsIntoTheTruck(DataTable dataTable) {
        QXClient.get().report().info("Provide HU number not to be loaded and load the remaining HUs into the truck");
        List<String> leftHUs = dataTable.asList();
        deliveryDetails.loadHUs(leftHUs);
    }

    @And("Provide HU number not to be loaded and load the remaining HUs into the truck in Offline mode")
    public void provideHUNumberNotToBeLoadedAndLoadTheRemainingHUsIntoTheTruckInOfflineMode(DataTable dataTable) {
        List<String> leftHUs = dataTable.asList();
        deliveryDetails.loadHUsInOfflineMode(leftHUs);
    }

    @And("Click on CONFIRM Button in Offline mode")
    public void clickOnCONFIRMButtonInOfflineMode() {
        deliveryDetails.confirmLoadedItemsInOfflineMode();
    }

    @And("Verify that No Network Connection dialouge box is displayed")
    public void verifyThatNoNetworkConnectionDialougeBoxIsDisplayed() {
        deliveryDetails.verifyNoNetworkConnectionDialougeBox();
    }

    @And("Go to ONLINE mode")
    public void goToONLINEMode() {
        QXClient.get().report().info("Go to ONLINE mode");
        Gestures.turnOnWiFi();
//        if (dispatchType.equals("BOX DISPATCH")){
//            QXClient.get().report().info("Refresh the page");
//            gestures = QXClient.get().gestures();
//            gestures.refreshPage();
//        }
    }

    @And("Refresh the page")
    public void refreshThePage() {
        QXClient.get().report().info("Refresh the page");
        gestures = QXClient.get().gestures();
        gestures.refreshPage();
    }

    @And("Confirm the loading")
    public void confirmTheLoading() {
        QXClient.get().report().info("Confirm the loading");

        QXClient.get().report().info("Load the delivery into the truck");
        if (dispatchType.equals("PALLET DISPATCH")) {
            deliveryDetails.confirmLoadedItems();
        } else if (dispatchType.equals("BOX DISPATCH"))
            deliveryDetails.confirmBoxTypeDeliveryLoading();
    }

    @And("Confirm the partially loaded HU delivery in Offline mode")
    public void confirmThePartiallyLoadedHUDeliveryInOfflineMode() {
        QXClient.get().report().info("Confirm the partially loaded HU delivery in Offline mode");
        SoftAssert softAssert = deliveryDetails.confirmPartiallyLoadedDelivery();
        softAssert.assertAll();
    }

    @And("Confirm the partially loaded HU delivery")
    public void confirmThePartiallyLoadedHUDelivery() {
        QXClient.get().report().info("Confirm the partially loaded HU delivery");
        SoftAssert softAssert = deliveryDetails.confirmPartiallyLoadedDelivery();
        softAssert.assertAll();
    }

    @Then("Verify that loading operation is completed")
    public void verifyThatLoadingOperationIsCompleted() {
        QXClient.get().report().info("Verify that loading operation is completed");
        if (dispatchType.equals("PALLET DISPATCH")) {
            deliveryDetails.deliveryLoadingConfirmation();
        } else if (dispatchType.equals("BOX DISPATCH"))
            deliveryDetails.boxTypeDeliveryLoadingConfirmation();
    }

    @And("Confirm Box type delivery loading")
    public void confirmBoxTypeDeliveryLoading() {
        QXClient.get().report().info("Confirm Box type delivery loading");
        deliveryDetails.confirmBoxTypeDeliveryLoading();
    }

    @And("Click on CONFIRM Button")
    public void clickOnCONFIRMButton() {
        QXClient.get().report().info("Click on CONFIRM Button");
        deliveryDetails.clickOnConfirmBtn();
    }


    @Then("Verify that Box type delivery loading operation is completed")
    public void verifyThatBoxTypeDeliveryLoadingOperationIsCompleted() {
        QXClient.get().report().info("Verify that Box type delivery loading operation is completed");
        deliveryDetails.boxTypeDeliveryLoadingConfirmation();
    }

    @And("Wait for {int} minute")
    public void waitForMinutes(long waitingPeriod) {
        try {
            TimeUnit.MINUTES.sleep(waitingPeriod);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @And("Provide HUs to be loaded into the truck")
    public void provideHUsToBeLoadedIntoTheTruck(DataTable dataTable) {
        huNumbers = dataTable.asList();
        //SoftAssert softAssert = deliveryDetails.loadParticularHU(huNumbers);
        //softAssert.assertAll();
    }

    @And("Load remaining HUs")
    public void loadRemainingHUs() {
        deliveryDetails.loadHUs(huNumbers);
    }

    @And("Verify that no results found message is displayed")
    public void verifyThatNoResultsFoundMessageIsDisplayed() {
        loader.isNoResultFoundMsgDisplayed();
    }

    @And("Search and load the item")
    public void searchAndLoadTheItem(DataTable dataTable) {
        QXClient.get().report().info("Search and load the item");
        itemName = dataTable.asMap(String.class, String.class);
        deliveryDetails.searchItemAndLoadItem(itemName);
    }

    @And("Search the item")
    public void searchTheItem() {
        QXClient.get().report().info("Search the item");
        deliveryDetails.searchItem(itemName.get("itemName"));
    }

    @And("Click on the EXCEPTION button")
    public void clickOnTheEXCEPTIONButton() {
        QXClient.get().report().info("Click on the EXCEPTION button");
        deliveryDetails.clickOnExceptionButton(itemName);
    }

    @Then("Verify that Cannot add exception dialouge box is displayed")
    public void verifyThatCannotAddExceptionDialougeBoxIsDisplayed() {
        QXClient.get().report().info("Verify that Cannot add exception dialouge box is displayed");
        ItemsExceptionPage itemsExceptionPage = new ItemsExceptionPage();
        itemsExceptionPage.isCannotAddExceptionDialougeBoxDisplayed();
    }

    @Then("Verify that Error Message is displayed while same delivery is loaded by multiple users")
    public void verifyThatErrorMessageIsDisplayedWhileSameDeliveryIsLoadedByMultipleUsers() {
        QXClient.get().report().info("Verify that Error Message is displayed while same delivery is loaded by multiple users");
        deliveryDetails.verifyErrorMessage();
    }

    @Then("Verify that Cannot confirm delivery dialouge box is displayed")
    public void verifyThatCannotConfirmDeliveryDialougeBoxIsDisplayed() {
        QXClient.get().report().info("Verify that Cannot confirm delivery dialouge box is displayed");
        deliveryDetails.verifyErrorMessage();
    }

    @And("Load the delivery into the truck in Offline mode and verify that No Network Connection dialouge box and Remote Sync Icon is displayed or not for Pallet type dispatch delivery")
    public void loadTheDeliveryIntoTheTruckInOfflineModeAndVerifyThatNoNetworkConnectionDialougeBoxAndRemoteSyncIconIsDisplayedOrNotForPalletTypeDispatchDelivery() {
        QXClient.get().report().info("Load the delivery into the truck in Offline mode and verify that No Network Connection dialouge box and Remote Sync Icon is displayed or not for Pallet type dispatch delivery");
        if (dispatchType.equals("PALLET DISPATCH")) {
            deliveryDetails.loadHUsInOfflineMode();
        } else if (dispatchType.equals("BOX DISPATCH"))
            deliveryDetails.loadBoxes();
    }
}
