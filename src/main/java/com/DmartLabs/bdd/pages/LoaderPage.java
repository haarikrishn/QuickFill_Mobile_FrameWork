package com.DmartLabs.bdd.pages;

import com.DmartLabs.commonutils.Gestures;
import com.DmartLabs.commonutils.QXClient;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;


public class LoaderPage {

    public LoaderPage(){
        PageFactory.initElements(new AppiumFieldDecorator(QXClient.get().driver()), this);
    }

    Gestures gestures;

    @FindBy(xpath = "//android.widget.TextView[@text='Loader']")
    private MobileElement loaderModule;

    @FindBy(id = "com.dmartlabs.pwp:id/edt_dl_search")
    private MobileElement searchBox;

    @FindBy(id="com.dmartlabs.pwp:id/txt_lid_delivery_no")
    private List<WebElement> allDeliveries;

    @FindBy(id = "com.dmartlabs.pwp:id/txt_lid_truck_no")
    private MobileElement truckNumber;

//    @FindBy(id = "com.dmartlabs.pwp:id/pb_lid_hu_progress_loader")
//    private MobileElement pickProgress;

    @FindBy(id = "com.dmartlabs.pwp:id/txt_fibe_title")
    private MobileElement vehicleNotAssignedDialougeBox;

    @FindBy(id = "com.dmartlabs.pwp:id/btn_fibe_ok")
    private MobileElement vehicleNotAssignedDialougeBoxOkBtn;

    @FindBy(id = "com.dmartlabs.pwp:id/ib_fch_logout")
    private MobileElement logOutIcon;

    @FindBy(id = "com.dmartlabs.pwp:id/alertTitle")
    private MobileElement logoutAlertPanel;

    @FindBy(id = "android:id/button1")
    private MobileElement logoutYesBtn;

    @FindBy(id = "android:id/button2")
    private MobileElement logoutNoBtn;

    @FindBy(id = "com.dmartlabs.pwp:id/cl_parent")
    private MobileElement loggingOutPanel;

    private String specficDeliveryXpath = "//android.widget.TextView[@text='%s']/parent::android.view.ViewGroup";
    private String destinationSiteId = "//android.widget.TextView[@text='%s']/preceding-sibling::android.widget.TextView[@resource-id='com.dmartlabs.pwp:id/txt_lid_site_name']";
    private String dispatchTypeXpath = "//android.widget.TextView[@text='%s']/following-sibling::android.widget.TextView[@resource-id='com.dmartlabs.pwp:id/txt_lid_dispatch_label']";
    private String pickProgressXpath = "//android.widget.TextView[@text='%s']/following-sibling::android.widget.ProgressBar";

    @FindBy(id = "com.dmartlabs.pwp:id/txt_dl_search_error_msg")
    private MobileElement searchMsg;

    private MobileElement deliveryCard = null;

    private static List<String> deliveryList = new ArrayList<>();;
    private static boolean isScroll = false;
    private static int scrollCount = 0;

    private LinkedHashSet<String> deliveryListss = new LinkedHashSet<>();
    private List<String> loadedDeliveries = new ArrayList<>();
    private boolean result = true;

    public void isLoaderPageDisplayed(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        gestures = QXClient.get().gestures();
        boolean result = gestures.isElementPresent(loaderModule);
        if (result)
            QXClient.get().report().pass("Loader Page is displayed");
        else
            QXClient.get().report().fail("Loader Page is not displayed");

        Assert.assertTrue(result,"Loader is not in Loader Page");
    }

    public List<String> getAllDeliveries(){
        for (WebElement delivery:allDeliveries){
            String deliveryNumber = delivery.getText().trim();
            if (!deliveryList.contains(deliveryNumber))
                    deliveryList.add(deliveryNumber);
        }

        if (!isScroll){
            scrollCount++;
            QXClient.get().gestures().scrollVertically1(1);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            for (WebElement delivery:allDeliveries){
                if (deliveryList.contains(delivery.getText().trim()))
                    isScroll = true;
            }
            getAllDeliveries();
        }
        gestures.scrollVertically2(1);
        return deliveryList;
    }

    public List<String> getAllDeliveries1(){
        for (WebElement delivery:allDeliveries){
            deliveryList.add(delivery.getText());
        }

        if (isScroll){
            scrollCount++;
            QXClient.get().gestures().scrollVertically1(1);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if (allDeliveries.get(0).getText().equals(deliveryList.get(deliveryList.size()-1))){
                deliveryList.remove(deliveryList.get(deliveryList.size()-1));
                getAllDeliveries1();
            }
            else
                isScroll = false;
        }
        gestures.scrollVertically2(1);
        return deliveryList;
    }

    public void scrollToDeliveryCardAndClick(String expectedDeliveryNumber){

        for (WebElement delivery:allDeliveries){
            String deliveryNumber = delivery.getText().trim();
            if (deliveryNumber.equals("#0075707900")){
                continue;
            }
            if (!deliveryList.contains(deliveryNumber))
                deliveryList.add(deliveryNumber);
        }

        if (!isScroll){
            scrollCount++;
            QXClient.get().gestures().scrollVertically1(1);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            for (WebElement delivery:allDeliveries){
                if (deliveryList.contains(delivery.getText().trim()))
                    isScroll = true;

                if (delivery.getText().equals(expectedDeliveryNumber)){
                    delivery.click();
                    return;
                }
            }
            scrollToDeliveryCardAndClick(expectedDeliveryNumber);
        }
    }


    public void loadAllDeliveries(){
//        deliveryList = getAllDeliveries1();
        gestures = QXClient.get().gestures();
        DeliveryDetailsPage deliveryDetails = new DeliveryDetailsPage();

//        try {
////            for (MobileElement delivery:allDeliveries){
////                deliveryList.add(delivery.getText().trim());
////            }
//
//            for (String deliveryNumber:deliveryList){
//                if (deliveryNumber.contains("#0075707900") || deliveryNumber.contains("#936752817"))
//                    continue;
//                MobileElement delivery = getMobileElementFromDynamicXpath(specficDeliveryXpath, deliveryNumber);
//                //gestures.waitForVisbilityOfWebElement(delivery);
//                gestures.isElementPresent(delivery);
//                String dispatchType = verifyDispatchType(deliveryNumber);
//                clickOnDeliveryCard(deliveryNumber);
//                if (dispatchType.equals("PALLET DISPATCH")) {
//                    deliveryDetails.isDeliverDetailsPageDisplayed(deliveryNumber);
//                    deliveryDetails.loadHUs();
//                    deliveryDetails.confirmLoadedItems();
//                    deliveryDetails.deliveryLoadingConfirmation();
//                    searchDelivery(deliveryNumber);
//                    isNoResultFoundMsgDisplayed();
//                    allDeliveries.remove(delivery);
//                } else if (dispatchType.equals("BOX DISPATCH")) {
//                    deliveryDetails.isDeliverDetailsPageDisplayed(deliveryNumber);
//                    deliveryDetails.loadBoxes();
//                    deliveryDetails.verifyBoxesLoaded();
//                    deliveryDetails.verifyArticleLoaded();
//                    deliveryDetails.verifyBoxException();
//                    deliveryDetails.confirmBoxTypeDeliveryLoading();
//                    deliveryDetails.boxTypeDeliveryLoadingConfirmation();
//                }
//            }
//        } catch (StaleElementReferenceException sre){
//            loadAllDeliveries();
//        }
//        catch (Exception e){
//            e.printStackTrace();
//        }

        try {
            for (WebElement delivery:allDeliveries) {
                if (delivery.getText().equals("9363567222") || delivery.getText().equals("9921595649"))
                    continue;
                result = deliveryListss.add(delivery.getText());
                if (!result)
                    break;
            }

            for (String deliveryNumber:deliveryListss) {
                if (loadedDeliveries.contains(deliveryNumber))
                    continue;

                MobileElement delivery = getMobileElementFromDynamicXpath(specficDeliveryXpath, deliveryNumber);
                gestures.isElementPresent(delivery);
                String dispatchType = verifyDispatchType(deliveryNumber);
                clickOnDeliveryCard1(deliveryNumber);
                if (dispatchType.equals("PALLET DISPATCH")) {
                    deliveryDetails.isDeliverDetailsPageDisplayed(deliveryNumber);
                    deliveryDetails.loadHUs();
                    deliveryDetails.confirmLoadedItems();
                    deliveryDetails.deliveryLoadingConfirmation();
                    searchDelivery(deliveryNumber);
                    isNoResultFoundMsgDisplayed();
                    searchBox.clear();
                    gestures.refreshPage();
                    loadedDeliveries.add(deliveryNumber);
                } else if (dispatchType.equals("BOX DISPATCH")) {
                    deliveryDetails.isDeliverDetailsPageDisplayed(deliveryNumber);
                    deliveryDetails.loadBoxes();
                    deliveryDetails.verifyBoxesLoaded();
                    deliveryDetails.verifyArticleLoaded();
                    deliveryDetails.verifyBoxException();
                    deliveryDetails.confirmBoxTypeDeliveryLoading();
                    deliveryDetails.boxTypeDeliveryLoadingConfirmation();
                    loadedDeliveries.add(deliveryNumber);
                }

            }

            if (result){
                loadAllDeliveries();
            }

        } catch (StaleElementReferenceException sre){
            loadAllDeliveries();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

//    public List<String> getDeliveryList(){
//        List<String> deliveryList = new ArrayList<>();
//        for (MobileElement delivery:allDeliveries){
//            deliveryList.add(delivery.getText().trim());
//        }
//        System.out.println("list1 ========> "+deliveryList);
//        System.out.println();
//        return deliveryList;
//    }

    public void searchDelivery(String deliveryNumber){
        gestures.waitForVisiblityOfAllWebElement(allDeliveries);
        gestures.isElementPresent(searchBox);
        searchBox.sendKeys(deliveryNumber);
        QXClient.get().report().info("Delivery Number "+deliveryNumber+" is entered in search box");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void isVehicleAssigned(Map<String, String> expectedDeliveryNumber) {
        deliveryCard = getMobileElementFromDynamicXpath(specficDeliveryXpath, expectedDeliveryNumber.get("deliveryNumber"));
        gestures.isElementPresent(deliveryCard);
        boolean result = gestures.isElementPresent(truckNumber);
        if (result)
            QXClient.get().report().pass("Registrantion Number for vehicle assigned for a delivery is "+truckNumber.getText());
        else {
            QXClient.get().report().fail("Vehicle is not assigned for a delivery");
            clickOnDeliveryCard1(expectedDeliveryNumber);
            isVehicleNotAssignedDialougeBoxDisplayed();
        }

        Assert.assertTrue(result,"Vehicle is not assigned for a delivery");
    }

    public void isVehicleNotAssignedDialougeBoxDisplayed() {
        boolean result = gestures.isElementPresent(vehicleNotAssignedDialougeBox);
        if (result)
            QXClient.get().report().pass("Vehicle has not assigned dialouge box is displayed");
        else
            QXClient.get().report().fail("Vehicle has not assigned dialouge box is not displayed");

        Assert.assertTrue(result,"Vehicle has not assigned dialouge box is not displayed");
        vehicleNotAssignedDialougeBoxOkBtn.click();
    }

    public String verifyDispatchType(String deliveryNumber) {
        MobileElement dispatchTypeElement = getMobileElementFromDynamicXpath(dispatchTypeXpath, deliveryNumber);
        MobileElement destinationSite = getMobileElementFromDynamicXpath(destinationSiteId, deliveryNumber);

        String dispatchType = dispatchTypeElement.getText();

        if (destinationSite.getText().contains("5019")){

            if (dispatchType.equals("PALLET DISPATCH"))
                QXClient.get().report().pass("Dispatch Type is PALLET");
            else
                QXClient.get().report().fail("Dispatch Type is not a PALLET");

            Assert.assertEquals(dispatchType,"PALLET DISPATCH");
        } else if (destinationSite.getText().contains("4019")){

            if (dispatchType.equals("BOX DISPATCH"))
                QXClient.get().report().pass("Dispatch Type is BOX");
            else
                QXClient.get().report().fail("Dispatch Type is not a BOX");

            Assert.assertEquals(dispatchType, "BOX DISPATCH");
        }
        return dispatchType;
    }

    public void checkPickProgress(String deliveryNumber) {
        MobileElement pickProgress = getMobileElementFromDynamicXpath(pickProgressXpath, deliveryNumber);
        boolean result = gestures.isElementPresent(pickProgress);
        Assert.assertTrue(result,"Pick Progress bar is not displayed");
        float pickPerecentage = Float.parseFloat(pickProgress.getText());
        if (pickPerecentage<100.0) {
            QXClient.get().report().warning("Loading cannot be started as the Picking for a Delivery "+deliveryNumber+" is completed "+pickPerecentage+"%");
            Assert.fail("Wait for picking to be completed for a Delivery " + deliveryNumber + ", right now picking completed for delivery is " + pickPerecentage + "%");
        }
    }

    public void clickOnDeliveryCard(Map<String, String> deliveryNumber) {
        String expectedDeliveryNumber = deliveryNumber.get("deliveryNumber");
//        String specificDeliveryXpath = "//android.widget.TextView[@text='"+expectedDeliveryNumber+"']";
//        By xpath = By.xpath(specificDeliveryXpath);
        try {
//            MobileElement deliveryCard = (MobileElement) QXClient.get().driver().findElement(xpath);
              MobileElement deliveryCard = getMobileElementFromDynamicXpath(specficDeliveryXpath, expectedDeliveryNumber);
//            int eleLoc = deliveryCard.getLocation().getY();
//            System.out.println("Element location is ================> "+eleLoc);
//            Dimension dim = QXClient.get().driver().manage().window().getSize();
//            System.out.println(dim.height);

            if (deliveryCard.getText().trim().equals(allDeliveries.get(allDeliveries.size()-1).getText().trim())){
                QXClient.get().gestures().scrollVertically1(1);
            }
            deliveryCard.click();
        }
        catch (NoSuchElementException nse){
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            gestures.scrollAndClick(expectedDeliveryNumber);
        }
        catch (Exception e){
            e.printStackTrace();
        }
//        MobileElement deliveryCard = (MobileElement) QXClient.get().driver().findElement(xpath);
        //deliveryCard.getLocation().
//        if (!deliveryCard.isDisplayed()){
//            gestures.scrollAndClick(expectedDeliveryNumber);
//        }
//        else
//            deliveryCard.click();
    }

    public void clickOnDeliveryCard1(Map<String, String> deliveryNumber) {
        String expectedDeliveryNumber = deliveryNumber.get("deliveryNumber");
        //MobileElement deliveryCard=null;
        try {
            deliveryCard = getMobileElementFromDynamicXpath(specficDeliveryXpath, expectedDeliveryNumber);
            if (allDeliveries.size()-1==3 && deliveryCard.getText().trim().equals(allDeliveries.get(allDeliveries.size()-1).getText().trim())){
                QXClient.get().gestures().scrollVertically1(1);
            }
            deliveryCard.click();
        }
        catch (NoSuchElementException nse){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            scrollToDeliveryCardAndClick(expectedDeliveryNumber);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public void clickOnDeliveryCard(String deliveryNumber) {

        String specificDeliveryXpath = "//android.widget.TextView[@text='"+deliveryNumber+"']";
        By xpath = By.xpath(specificDeliveryXpath);
        try {
            MobileElement deliveryCard = (MobileElement) QXClient.get().driver().findElement(xpath);
            deliveryCard.click();
        }
        catch (NoSuchElementException nse){
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            gestures.scrollAndClick(deliveryNumber);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public void clickOnDeliveryCard1(String deliveryNumber) {
        String expectedDeliveryNumber = deliveryNumber;
//        String specificDeliveryXpath = "//android.widget.TextView[@text='"+expectedDeliveryNumber+"']";
//        By xpath = By.xpath(specificDeliveryXpath);
        MobileElement deliveryCard=null;
        try {
//            MobileElement deliveryCard = (MobileElement) QXClient.get().driver().findElement(xpath);
            deliveryCard = getMobileElementFromDynamicXpath(specficDeliveryXpath, expectedDeliveryNumber);
//            int eleLoc = deliveryCard.getLocation().getY();
//            System.out.println("Element location is ================> "+eleLoc);
//            Dimension dim = QXClient.get().driver().manage().window().getSize();
//            System.out.println(dim.height);

            if (deliveryCard.getText().trim().equals(allDeliveries.get(allDeliveries.size()-1).getText().trim())){
                QXClient.get().gestures().scrollVertically1(1);
            }
            deliveryCard.click();
        }
        catch (NoSuchElementException nse){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            scrollToDeliveryCardAndClick(expectedDeliveryNumber);
        }
        catch (Exception e){
            e.printStackTrace();
        }
//        MobileElement deliveryCard = (MobileElement) QXClient.get().driver().findElement(xpath);
        //deliveryCard.getLocation().
//        if (!deliveryCard.isDisplayed()){
//            gestures.scrollAndClick(expectedDeliveryNumber);
//        }
//        else
//            deliveryCard.click();
    }

    public void logoutUser(){
        gestures = QXClient.get().gestures();
        gestures.waitForVisbilityOfWebElement(logOutIcon).click();
        gestures.waitForVisbilityOfWebElement(logoutAlertPanel);
        logoutYesBtn.click();
        try {
            Thread.sleep(400L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assert.assertTrue(loggingOutPanel.isDisplayed());
        LoginPage loginPage = new LoginPage();
        loginPage.loginTitleIsDisplayed();
    }

    private MobileElement getMobileElementFromDynamicXpath(String partialXpath, String replaceCharacter){
        String xpath = String.format(partialXpath, replaceCharacter);
        return (MobileElement) QXClient.get().driver().findElement(By.xpath(xpath));
    }

    public void isNoResultFoundMsgDisplayed() {
        Assert.assertTrue(gestures.isElementPresent(searchMsg));
    }

}
