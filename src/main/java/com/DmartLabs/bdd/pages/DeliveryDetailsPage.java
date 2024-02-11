package com.DmartLabs.bdd.pages;

import com.DmartLabs.commonutils.Gestures;
import com.DmartLabs.commonutils.QXClient;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DeliveryDetailsPage {

    public DeliveryDetailsPage(){
        PageFactory.initElements(new AppiumFieldDecorator(QXClient.get().driver()), this);
    }

    Gestures gestures;

    @FindBy(id = "com.dmartlabs.pwp:id/txt_dd_delivery_number")
    private MobileElement deliveryNumber;

    @FindBy(id = "com.dmartlabs.pwp:id/iv_fch_wifi_off_signal")
    private MobileElement wifiOFF_Icon;

//    @FindBy(id = "com.dmartlabs.pwp:id/cv_lip_parent")
//    private List<MobileElement> deliveryItemsCards;

    @FindBy(id="com.dmartlabs.pwp:id/txt_lia_item_desc")
    private List<MobileElement> allItems;

    private String exceptionsBtnXpath = "//android.widget.TextView[@text='%s']/following-sibling::android.widget.Button";

    @FindBy(id = "com.dmartlabs.pwp:id/txt_dd_article_loaded_count")
    private MobileElement articleLoaded;

    @FindBy(id = "com.dmartlabs.pwp:id/txt_da_box_load_count")
    private MobileElement boxesLoadedCount;

    @FindBy(id = "com.dmartlabs.pwp:id/txt_da_exceptions_count")
    private MobileElement exceptionCount;

    @FindBy(id = "com.dmartlabs.pwp:id/fab_search")
    private MobileElement searchBtn;

    @FindBy(id = "com.dmartlabs.pwp:id/edt_dd_search")
    private MobileElement searchBox;

    @FindBy(id = "com.dmartlabs.pwp:id/txt_lia_caselot_count")
    private MobileElement totalBoxesCount;

//    String totalBoxesCount = "//android.widget.TextView[@text='%s']/following-sibling:: android.view.ViewGroup[@resource-id='com.dmartlabs.pwp:id/cl_lia_boxes_body_container']/android.widget.TextView[@resource-id='com.dmartlabs.pwp:id/txt_lia_caselot_count']";
    private String itemCard = "//android.widget.TextView[@text='%s']/parent::android.view.ViewGroup";

    @FindBy(id = "com.dmartlabs.pwp:id/btn_dd_consolidate")
    private MobileElement consolidateBtn;

    @FindBy(id= "com.dmartlabs.pwp:id/edt_fshd_hu_number")
    private MobileElement huNumberTextBox;

    @FindBy(id = "com.dmartlabs.pwp:id/txt_fshd_dialog_title")
    private MobileElement dialougeTitle;

    @FindBy(id = "com.dmartlabs.pwp:id/btn_fshd_confirm")
    private MobileElement openHuBtn;

    @FindBy(id = "com.dmartlabs.pwp:id/btn_fshd_back")
    private MobileElement backBtn;

    @FindBy(xpath = "//android.widget.TextView[@resource-id='com.dmartlabs.pwp:id/txt_lihu_hu_number']")
    private List<WebElement> allHUs;

    private List<String> huNumbers;

//    @FindBy(id = "com.dmartlabs.pwp:id/btn_lihu_load")
//    private List<MobileElement> loadBtns;

    @FindBy(id = "com.dmartlabs.pwp:id/btn_fdqd_no")
    private MobileElement noBtn;

    @FindBy(id = "com.dmartlabs.pwp:id/btn_fdqd_yes")
    private MobileElement yesBtn;

    @FindBy(id = "com.dmartlabs.pwp:id/btn_fshd_confirm")
    private MobileElement confirmBoxDeliveryYesBtn;

//    String huNumber;
//    String specificHUXpath = "//android.widget.TextView[@text='"+huNumber+"']";

//    String specificHuLoadBtnXpath = "//android.widget.TextView[@text='"+huNumber+"']/following-sibling::android.widget.LinearLayout/descendant::android.widget.Button";

    @FindBy(id = "com.dmartlabs.pwp:id/ib_dd_back")
    private MobileElement consolidateHuBackBtn;

    @FindBy(id = "com.dmartlabs.pwp:id/btn_dd_confirm")
    private MobileElement confirmBtn;

    @FindBy(id = "com.dmartlabs.pwp:id/txt_fibe_description")
    private MobileElement unsyncItemsDialougeBox;

    @FindBy(xpath = "//android.widget.TextView[@text='HUs Not Loaded']")
    private MobileElement huNotLoadedDialougeBox;

    @FindBy(id = "com.dmartlabs.pwp:id/cl_parent")
    private MobileElement deliveryConfirmation;

    @FindBy(id = "com.dmartlabs.pwp:id/btn_fibe_ok")
    private MobileElement boxTypeDeliveryConfirmationOkBtn;

    @FindBy(id = "com.dmartlabs.pwp:id/txt_fasd_title")
    private MobileElement noNetworkConnectionDialougeBox;

    @FindBy(id = "com.dmartlabs.pwp:id/btn_fasd_ok")
    private MobileElement okBtn;

    @FindBy(xpath = "//android.widget.Button[@text='OK']")
    private MobileElement okBtn1;

    @FindBy(id = "com.dmartlabs.pwp:id/iv_lihu_remote_sync")
    private List<WebElement> allRemoteSyncIcon;

    @FindBy(id = "com.dmartlabs.pwp:id/iv_lihu_remote_sync")
    private MobileElement remoteSyncIcon;
    
    @FindBy(id = "com.dmartlabs.pwp:id/txt_fibe_title")
    private MobileElement unableToConnectDialougeBox;

    @FindBy(id = "com.dmartlabs.pwp:id/btn_fibe_ok")
    private MobileElement unableToConnectDialougeBoxOkBtn;

    String loadBtnXpath = "//android.widget.TextView[@text='%s']/following-sibling::android.widget.LinearLayout/descendant::android.widget.Button[@text='LOAD']";

    String huStatusXpath = "//android.widget.TextView[@text='%s']/following-sibling::android.widget.LinearLayout/descendant::android.widget.TextView[@resource-id='com.dmartlabs.pwp:id/txt_lihu_loaded_text']";
    
    String remoteSyncIconXpath = "//android.widget.TextView[@text='%s']/following-sibling::android.widget.ImageView";

    @FindBy(id = "com.dmartlabs.pwp:id/iv_lia_remote_sync")
    private MobileElement remoteSyncIconForMultiUserLoading;

    @FindBy(id = "com.dmartlabs.pwp:id/txt_fibe_title")
    private MobileElement cannotConfirmDeliveryDialougeBox;

    @FindBy(id = "com.dmartlabs.pwp:id/btn_fibe_ok")
    private MobileElement cannotConfirmDeliveryBoxOkBtn;

    @FindBy(id = "com.dmartlabs.pwp:id/txt_fibe_description")
    private MobileElement boxDeliveryConfirmationDialougeBox;

    private List<String> deliveryAllItems = new ArrayList<>();
    private static List<Map<String, String>> itemsExceptions;
    private boolean isScroll = true;
    private int scrollCount = 0;


    public List<String> isDeliverDetailsPageDisplayed(Map<String, String> expectedDeliveryNumber){
        gestures = QXClient.get().gestures();
        MobileElement deliveryDetails = (MobileElement) gestures.waitForElementToAppear(deliveryNumber);
        String actualDeliveryNumber = deliveryDetails.getText();
        if (actualDeliveryNumber.equals(expectedDeliveryNumber.get("deliveryNumber")))
            QXClient.get().report().pass("Delivery Detail page is displayed");
        else
            QXClient.get().report().fail("Delivery Detail page is not displayed");

        Assert.assertEquals(actualDeliveryNumber, expectedDeliveryNumber.get("deliveryNumber"));
        huNumbers = new ArrayList<>();
        for (WebElement hu:allHUs){
            huNumbers.add(hu.getText().trim());
        }
//        return allHUs;
        return huNumbers;
    }

    public List<String> isDeliverDetailsPageDisplayed(String deliveryNumber){
        gestures = QXClient.get().gestures();
        MobileElement deliveryDetails = (MobileElement) gestures.waitForElementToAppear(this.deliveryNumber);
        String actualDeliveryNumber = deliveryDetails.getText();
        Assert.assertEquals(actualDeliveryNumber, deliveryNumber);
        huNumbers = new ArrayList<>();
        for (WebElement hu:allHUs){
            huNumbers.add(hu.getText().trim());
        }
//        return allHUs;
        return huNumbers;
    }

    public void isDeliverDetailsPageDisplayed(){
        gestures = QXClient.get().gestures();
        boolean result = gestures.isElementPresent(deliveryNumber);
        if (result)
            QXClient.get().report().pass("Delivery Detail Page is displayed");
        else
            QXClient.get().report().fail("Delivery Detail Page is not displayed");

        Assert.assertTrue(result,"Delivery Detail Page is not displayed");
    }


    public void verifyThatLoaderIsInOfflineMode(){
        Assert.assertTrue(gestures.isElementPresent(wifiOFF_Icon),"Loader is not in a Offline mode");
    }

    public void clickONConsolidateButton(){
        consolidateBtn.click();
    }

    public void provideSourceHU_Number(String sourceHU){
        gestures.isElementPresent(dialougeTitle);
        huNumberTextBox.sendKeys(sourceHU);
        openHuBtn.click();
    }

//    public SoftAssert loadDeliveryItems(){
//        AppiumDriver driver = QXClient.get().driver();
//        List<Boolean> results = new ArrayList<>();
//        SoftAssert softAssert = new SoftAssert();
//        for (int i=0;i< allHUs.size();i++) {
//            String huNumber = allHUs.get(i).getText();
//            System.out.println("hunumbers are =============> "+huNumber);
//
//            String huStatusXpath = "//android.widget.TextView[@text='"+huNumber+"']/following-sibling::android.widget.LinearLayout/descendant::android.widget.TextView[@resource-id='com.dmartlabs.pwp:id/txt_lihu_loaded_text']";
//            String loadBtnXpath = "//android.widget.TextView[@text='"+huNumber+"']/following-sibling::android.widget.LinearLayout/descendant::android.widget.Button";
//            //MobileElement loadBtn = (MobileElement) driver.findElement(By.xpath(loadBtnXpath));
//
//
//            boolean result;
//            try {
//                MobileElement loadBtn = (MobileElement) driver.findElement(By.xpath(loadBtnXpath));
//                  System.out.println("loadBtns ===========> "+loadBtn.isEnabled());
//                loadBtn.click();
//                gestures.waitForElementToVisible(yesBtn);
//                if (yesBtn.isEnabled()){
//                    System.out.println("yesBtn is enabled =============> "+yesBtn.isEnabled());
//                    yesBtn.click();
//                }
//                else {
//                    break;
//                }
//                Thread.sleep(1000);
//                MobileElement huStatus = (MobileElement) driver.findElement(By.xpath(huStatusXpath));
//                result = gestures.isElementPresent(huStatus);
//                softAssert.assertTrue(result, "item is not loaded");
//            } catch (NoSuchElementException nse) {
//                System.out.println("XXXXXXXXXXXXXXXXXXXXXXX ============================> NSE Catch Block");
//                MobileElement loadBtn = (MobileElement) driver.findElement(By.xpath(loadBtnXpath));
//                if (loadBtn.isDisplayed()){
//                    loadBtn.click();
//                    if (yesBtn.isEnabled()){
//                        System.out.println("yesBtn is enabled =============> "+yesBtn.isEnabled());
//                        yesBtn.click();
//                    }
//                }
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                MobileElement huStatus = (MobileElement) driver.findElement(By.xpath(huStatusXpath));
//                result = gestures.isElementPresent(huStatus);
//                softAssert.assertTrue(result, "item is not loaded");
//                if (result)
//                    continue;
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//
////            MobileElement huStatus = (MobileElement) driver.findElement(By.xpath(huStatusXpath));
////            if (gestures.isElementPresent(huStatus)){
////                continue;
////            }
////            else{
////
////                By xpath = By.xpath(loadBtnXpath);
////                MobileElement loadBtns = (MobileElement) driver.findElement(xpath);
////                loadBtns.click();
////                gestures.waitForElementToVisible(yesBtn);
////                yesBtn.click();
////            }
//        }
//        return softAssert;
//    }

    public SoftAssert loadHUs() {
        AppiumDriver driver = QXClient.get().driver();
        List<String> huNumbers = new ArrayList<>();
        SoftAssert softAssert = new SoftAssert();
        gestures = QXClient.get().gestures();
        allHUs = gestures.waitForVisiblityOfAllWebElement(allHUs);

        for (int i = 0; i < allHUs.size(); i++) {
                String huNumber = allHUs.get(i).getText();
                huNumbers.add(huNumber);
        }

        for (String huNumber : huNumbers) {
            boolean result;

            try {
                Thread.sleep(3000);
                MobileElement loadBtn = getMobileElementFromDynamicXpath(loadBtnXpath, huNumber);
                loadBtn.click();
                gestures.waitForElementToVisible(yesBtn);
                yesBtn.click();
                Thread.sleep(1000);
                MobileElement huStatus = getMobileElementFromDynamicXpath(huStatusXpath, huNumber);
                result = gestures.isElementPresent(huStatus);

                if (result)
                    QXClient.get().report().pass("HU is loaded into the truck");
                else
                    QXClient.get().report().fail("HU is not loaded into the truck");

                softAssert.assertTrue(result, "item is not loaded");
            } catch (NoSuchElementException nse) {
                MobileElement huStatus = getMobileElementFromDynamicXpath(huStatusXpath, huNumber);
                result = gestures.isElementPresent(huStatus);

                if (result)
                    QXClient.get().report().pass("HU is loaded into the truck");
                else
                    QXClient.get().report().fail("HU is not loaded into the truck");

                softAssert.assertTrue(result, "item is not loaded");
                if (result)
                    continue;
            } catch (Exception e) {
                //e.printStackTrace();
            }
        }
        return softAssert;
    }

    public SoftAssert loadHUsInOfflineMode() {
        AppiumDriver driver = QXClient.get().driver();
        List<String> huNumbers = new ArrayList<>();
        SoftAssert softAssert = new SoftAssert();
//        List<MobileElement> allHUs;
//        try {
//            allHUs.get(0);
//        } catch (StaleElementReferenceException sRE){
//            DeliveryDetailsPage deliveryDetails = new DeliveryDetailsPage();
//            allHUs = (List<MobileElement>) driver.findElements(By.xpath("//android.widget.TextView[@resource-id='com.dmartlabs.pwp:id/txt_lihu_hu_number']"));
//        }

//        try {
//            allHUs = (List<MobileElement>) driver.findElements(By.xpath("//android.widget.TextView[@resource-id='com.dmartlabs.pwp:id/txt_lihu_hu_number']"));
//            for (int i = 0; i < allHUs.size(); i++) {
//                String huNumber = allHUs.get(i).getText();
//                huNumbers.add(huNumber);
//            }
//        } catch (StaleElementReferenceException sre){
//            System.out.println("XXXXXXXXXXXXXXXXXXXXXX inside StaleElementReferenceException catch bloc ");
//            allHUs = (List<MobileElement>) driver.findElements(By.xpath("//android.widget.TextView[@resource-id='com.dmartlabs.pwp:id/txt_lihu_hu_number']"));
//            for (int i = 0; i < allHUs.size(); i++) {
//                String huNumber = allHUs.get(i).getText();
//                huNumbers.add(huNumber);
//            }
//        }

        gestures = QXClient.get().gestures();
        allHUs = gestures.waitForVisiblityOfAllWebElement(allHUs);

        for (int i = 0; i < allHUs.size(); i++) {
            String huNumber = allHUs.get(i).getText();
            huNumbers.add(huNumber);
        }

        for (String huNumber : huNumbers) {
            boolean result;

            try {
                MobileElement loadBtn = getMobileElementFromDynamicXpath(loadBtnXpath, huNumber);
                loadBtn.click();
                gestures.waitForElementToVisible(yesBtn);
                yesBtn.click();
                Assert.assertTrue(gestures.isElementPresent(noNetworkConnectionDialougeBox),"No network connection dialouge box is not displayed");
                //Thread.sleep(500);
//                gestures.waitForVisbilityOfWebElement(okBtn).click();
//                gestures.waitForVisbilityOfWebElement(okBtn1).click();
                gestures.isElementPresent(okBtn);
                okBtn.click();
                gestures.isElementPresent(okBtn1);
                okBtn1.click();
                Thread.sleep(500);
                MobileElement huStatus = getMobileElementFromDynamicXpath(huStatusXpath, huNumber);
                result = gestures.isElementPresent(huStatus);
                softAssert.assertTrue(result, "item is not loaded");
            } catch (NoSuchElementException nse) {
                System.out.println("XXXXXXXXXXXXXXXXXXXXXXX ============================> NSE Catch Block");
                MobileElement huStatus = getMobileElementFromDynamicXpath(huStatusXpath, huNumber);
                result = gestures.isElementPresent(huStatus);
                softAssert.assertTrue(result, "item is not loaded");
                if (result)
                    continue;
            } catch (Exception e) {
                //e.printStackTrace();
            }
        }
//        MobileElement remoteSyncIcon = getMobileElementFromDynamicXpath(remoteSyncIconXpath, huNumber);
        Assert.assertTrue(gestures.isElementPresent(remoteSyncIcon),"remote sync icon is not displayed");
        remoteSyncIcon.click();
        Assert.assertTrue(gestures.isElementPresent(unableToConnectDialougeBox));
        unableToConnectDialougeBoxOkBtn.click();
        return softAssert;
    }

    public SoftAssert loadHUs2() {
        AppiumDriver driver = QXClient.get().driver();
        List<String> huNumbers = new ArrayList<>();
        SoftAssert softAssert = new SoftAssert();
//        List<MobileElement> allHUs;
//        try {
//            allHUs.get(0);
//        } catch (StaleElementReferenceException sRE){
//            DeliveryDetailsPage deliveryDetails = new DeliveryDetailsPage();
//            allHUs = (List<MobileElement>) driver.findElements(By.xpath("//android.widget.TextView[@resource-id='com.dmartlabs.pwp:id/txt_lihu_hu_number']"));
//        }

//        try {
//            allHUs = (List<MobileElement>) driver.findElements(By.xpath("//android.widget.TextView[@resource-id='com.dmartlabs.pwp:id/txt_lihu_hu_number']"));
//            for (int i = 0; i < allHUs.size(); i++) {
//                String huNumber = allHUs.get(i).getText();
//                huNumbers.add(huNumber);
//            }
//        } catch (StaleElementReferenceException sre){
//            System.out.println("XXXXXXXXXXXXXXXXXXXXXX inside StaleElementReferenceException catch bloc ");
//            allHUs = (List<MobileElement>) driver.findElements(By.xpath("//android.widget.TextView[@resource-id='com.dmartlabs.pwp:id/txt_lihu_hu_number']"));
//            for (int i = 0; i < allHUs.size(); i++) {
//                String huNumber = allHUs.get(i).getText();
//                huNumbers.add(huNumber);
//            }
//        }

        gestures = QXClient.get().gestures();
        allHUs = gestures.waitForVisiblityOfAllWebElement(allHUs);

        for (int i = 0; i < allHUs.size(); i++) {
            String huNumber = allHUs.get(i).getText();
            huNumbers.add(huNumber);
        }

        for (String huNumber : huNumbers) {
//            String huStatusXpath = "//android.widget.TextView[@text='" + huNumber + "']/following-sibling::android.widget.LinearLayout/descendant::android.widget.TextView[@resource-id='com.dmartlabs.pwp:id/txt_lihu_loaded_text']";
//
//            String loadBtnXpath = "//android.widget.TextView[@text='" + huNumber + "']/following-sibling::android.widget.LinearLayout/descendant::android.widget.Button[@text='LOAD']";


            boolean result;

            try {
                boolean emptyHU_Status = verifyThatHU_IsEmpty(huNumber);
                if (emptyHU_Status)
                    continue;
                //MobileElement loadBtn = (MobileElement) driver.findElement(By.xpath(loadBtnXpath));
                Thread.sleep(3000);
                MobileElement loadBtn = getMobileElementFromDynamicXpath(loadBtnXpath, huNumber);
                loadBtn.click();
                gestures.waitForElementToVisible(yesBtn);
                yesBtn.click();
                Thread.sleep(500);
//                MobileElement huStatus = (MobileElement) driver.findElement(By.xpath(huStatusXpath));
                MobileElement huStatus = getMobileElementFromDynamicXpath(huStatusXpath, huNumber);
                result = gestures.isElementPresent(huStatus);
                softAssert.assertTrue(result, "item is not loaded");
            } catch (NoSuchElementException nse) {
                System.out.println("XXXXXXXXXXXXXXXXXXXXXXX ============================> NSE Catch Block");
                MobileElement huStatus = getMobileElementFromDynamicXpath(huStatusXpath, huNumber);
                result = gestures.isElementPresent(huStatus);
                softAssert.assertTrue(result, "item is not loaded");
                if (result)
                    continue;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return softAssert;
    }

    public SoftAssert leaveSomeHUsAndLoadReamainingHUs(List<String> leftHus) {
        AppiumDriver driver = QXClient.get().driver();
        List<String> huNumbers = new ArrayList<>();
        SoftAssert softAssert = new SoftAssert();
//        List<MobileElement> allHUs;
//        try {
//            allHUs.get(0);
//        } catch (StaleElementReferenceException sRE){
//            DeliveryDetailsPage deliveryDetails = new DeliveryDetailsPage();
//            allHUs = (List<MobileElement>) driver.findElements(By.xpath("//android.widget.TextView[@resource-id='com.dmartlabs.pwp:id/txt_lihu_hu_number']"));
//        }

//        try {
//            allHUs = (List<MobileElement>) driver.findElements(By.xpath("//android.widget.TextView[@resource-id='com.dmartlabs.pwp:id/txt_lihu_hu_number']"));
//            for (int i = 0; i < allHUs.size(); i++) {
//                String huNumber = allHUs.get(i).getText();
//                huNumbers.add(huNumber);
//            }
//        } catch (StaleElementReferenceException sre){
//            System.out.println("XXXXXXXXXXXXXXXXXXXXXX inside StaleElementReferenceException catch bloc ");
//            allHUs = (List<MobileElement>) driver.findElements(By.xpath("//android.widget.TextView[@resource-id='com.dmartlabs.pwp:id/txt_lihu_hu_number']"));
//            for (int i = 0; i < allHUs.size(); i++) {
//                String huNumber = allHUs.get(i).getText();
//                huNumbers.add(huNumber);
//            }
//        }

        gestures = QXClient.get().gestures();
        allHUs = gestures.waitForVisiblityOfAllWebElement(allHUs);

        for (int i = 0; i < allHUs.size(); i++) {
            String huNumber = allHUs.get(i).getText();
            huNumbers.add(huNumber);
        }

        for (String huNumber : huNumbers) {
//            String huStatusXpath = "//android.widget.TextView[@text='" + huNumber + "']/following-sibling::android.widget.LinearLayout/descendant::android.widget.TextView[@resource-id='com.dmartlabs.pwp:id/txt_lihu_loaded_text']";
//
//            String loadBtnXpath = "//android.widget.TextView[@text='" + huNumber + "']/following-sibling::android.widget.LinearLayout/descendant::android.widget.Button[@text='LOAD']";


            boolean result;

            try {
                //MobileElement loadBtn = (MobileElement) driver.findElement(By.xpath(loadBtnXpath));
                Thread.sleep(3000);
                MobileElement loadBtn = getMobileElementFromDynamicXpath(loadBtnXpath, huNumber);
                if (leftHus.contains(huNumber)){
                    continue;
                }
                loadBtn.click();
                gestures.waitForElementToVisible(yesBtn);
                yesBtn.click();
                Thread.sleep(500);
//                MobileElement huStatus = (MobileElement) driver.findElement(By.xpath(huStatusXpath));
                MobileElement huStatus = getMobileElementFromDynamicXpath(huStatusXpath, huNumber);
                result = gestures.isElementPresent(huStatus);
                softAssert.assertTrue(result, "item is not loaded");
            } catch (NoSuchElementException nse) {
                System.out.println("XXXXXXXXXXXXXXXXXXXXXXX ============================> NSE Catch Block");
                MobileElement huStatus = getMobileElementFromDynamicXpath(huStatusXpath, huNumber);
                result = gestures.isElementPresent(huStatus);
                softAssert.assertTrue(result, "item is not loaded");
                if (result)
                    continue;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return softAssert;
    }

    public SoftAssert leaveSomeHUsAndLoadRemaingHUsInOfflineMode(List<String> leftHus) {
        AppiumDriver driver = QXClient.get().driver();
        List<String> huNumbers = new ArrayList<>();
        SoftAssert softAssert = new SoftAssert();
//        List<MobileElement> allHUs;
//        try {
//            allHUs.get(0);
//        } catch (StaleElementReferenceException sRE){
//            DeliveryDetailsPage deliveryDetails = new DeliveryDetailsPage();
//            allHUs = (List<MobileElement>) driver.findElements(By.xpath("//android.widget.TextView[@resource-id='com.dmartlabs.pwp:id/txt_lihu_hu_number']"));
//        }

//        try {
//            allHUs = (List<MobileElement>) driver.findElements(By.xpath("//android.widget.TextView[@resource-id='com.dmartlabs.pwp:id/txt_lihu_hu_number']"));
//            for (int i = 0; i < allHUs.size(); i++) {
//                String huNumber = allHUs.get(i).getText();
//                huNumbers.add(huNumber);
//            }
//        } catch (StaleElementReferenceException sre){
//            System.out.println("XXXXXXXXXXXXXXXXXXXXXX inside StaleElementReferenceException catch bloc ");
//            allHUs = (List<MobileElement>) driver.findElements(By.xpath("//android.widget.TextView[@resource-id='com.dmartlabs.pwp:id/txt_lihu_hu_number']"));
//            for (int i = 0; i < allHUs.size(); i++) {
//                String huNumber = allHUs.get(i).getText();
//                huNumbers.add(huNumber);
//            }
//        }

        gestures = QXClient.get().gestures();
        allHUs = gestures.waitForVisiblityOfAllWebElement(allHUs);

        for (int i = 0; i < allHUs.size(); i++) {
            String huNumber = allHUs.get(i).getText();
            huNumbers.add(huNumber);
        }

        for (String huNumber : huNumbers) {
//            String huStatusXpath = "//android.widget.TextView[@text='" + huNumber + "']/following-sibling::android.widget.LinearLayout/descendant::android.widget.TextView[@resource-id='com.dmartlabs.pwp:id/txt_lihu_loaded_text']";
//
//            String loadBtnXpath = "//android.widget.TextView[@text='" + huNumber + "']/following-sibling::android.widget.LinearLayout/descendant::android.widget.Button[@text='LOAD']";


            boolean result;

            try {
                //MobileElement loadBtn = (MobileElement) driver.findElement(By.xpath(loadBtnXpath));
                Thread.sleep(3000);
                MobileElement loadBtn = getMobileElementFromDynamicXpath(loadBtnXpath, huNumber);
                if (leftHus.contains(huNumber)){
                    continue;
                }
                loadBtn.click();
                gestures.waitForElementToVisible(yesBtn);
                yesBtn.click();
                Assert.assertTrue(gestures.isElementPresent(noNetworkConnectionDialougeBox),"No network connection dialouge box is not displayed");
                //Thread.sleep(500);
//                gestures.waitForVisbilityOfWebElement(okBtn).click();
//                gestures.waitForVisbilityOfWebElement(okBtn1).click();
                gestures.isElementPresent(okBtn);
                okBtn.click();
//                gestures.isElementPresent(okBtn1);
//                okBtn1.click();
                Thread.sleep(500);
//                MobileElement huStatus = (MobileElement) driver.findElement(By.xpath(huStatusXpath));
                MobileElement huStatus = getMobileElementFromDynamicXpath(huStatusXpath, huNumber);
                result = gestures.isElementPresent(huStatus);
                softAssert.assertTrue(result, "item is not loaded");
            } catch (NoSuchElementException nse) {
                System.out.println("XXXXXXXXXXXXXXXXXXXXXXX ============================> NSE Catch Block");
                MobileElement huStatus = getMobileElementFromDynamicXpath(huStatusXpath, huNumber);
                result = gestures.isElementPresent(huStatus);
                softAssert.assertTrue(result, "item is not loaded");
                if (result)
                    continue;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return softAssert;
    }

    public SoftAssert loadParticularHU(List<String> huNumbers){
        AppiumDriver driver = QXClient.get().driver();
        SoftAssert softAssert = new SoftAssert();

        gestures = QXClient.get().gestures();
        allHUs = gestures.waitForVisiblityOfAllWebElement(allHUs);

        for (int i = 0; i < allHUs.size(); i++) {
            String huNumber = allHUs.get(i).getText();
            huNumbers.add(huNumber);
        }

        for (String huNumber : huNumbers) {
            boolean result;
            try {
                Thread.sleep(3000);
                MobileElement loadBtn = getMobileElementFromDynamicXpath(loadBtnXpath, huNumber);
                loadBtn.click();
                gestures.waitForElementToVisible(yesBtn);
                yesBtn.click();
                gestures.isElementPresent(okBtn);
                okBtn.click();
                Thread.sleep(500);
                MobileElement huStatus = getMobileElementFromDynamicXpath(huStatusXpath, huNumber);
                result = gestures.isElementPresent(huStatus);
                softAssert.assertTrue(result, "item is not loaded");
            } catch (NoSuchElementException nse) {
                MobileElement huStatus = getMobileElementFromDynamicXpath(huStatusXpath, huNumber);
                result = gestures.isElementPresent(huStatus);
                softAssert.assertTrue(result, "item is not loaded");
                if (result)
                    continue;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return softAssert;
    }


    public boolean verifyThatHU_IsEmpty(String huNumber){
        MobileElement huStatus = null;
        try {
            huStatus = getMobileElementFromDynamicXpath(huStatusXpath, huNumber);
            String actualHU_Status = huStatus.getText();
            if (actualHU_Status.equals("Loaded") || actualHU_Status.equals("Empty")) {
                if (!actualHU_Status.equals("Loaded"))
                    Assert.assertEquals(actualHU_Status, "Empty");
                return huStatus.isDisplayed();
            }
        } catch (Exception e){

        }
        return false;
    }

    public List<String> getDeliveryAllItems(){
        for (MobileElement item:allItems){
            deliveryAllItems.add(item.getText().trim());
        }

        if (isScroll){
            scrollCount++;
            QXClient.get().gestures().scrollDeliveryItemsUpwards(1);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if (allItems.get(0).getText().equals(deliveryAllItems.get(deliveryAllItems.size()-1))){
                deliveryAllItems.remove(deliveryAllItems.get(deliveryAllItems.size()-1));
                getDeliveryAllItems();
            }
            else
                isScroll = false;
        }
        gestures.scrollDeliveryItemsDownward(1);
        return deliveryAllItems;
    }

    public void scrollToEndDeliveryItem(){
        for (MobileElement item:allItems){
            deliveryAllItems.add(item.getText().trim());
        }

        if (isScroll){
            scrollCount++;
            QXClient.get().gestures().scrollDeliveryItemsUpwards(1);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if (allItems.get(0).getText().equals(deliveryAllItems.get(deliveryAllItems.size()-1))){
                getDeliveryAllItems();
            }
            else
                isScroll = false;
        }
    }

    private static int expectedLoadedArticle = 0;
    private static int expectedLoadedBoxes=0;
    private static int totalExpectedExceptionCount=0;

    public void  itemsException(List<Map<String, String>> exceptions) {
        itemsExceptions=exceptions;

        for (Map<String, String> exception:exceptions) {
            int repeatingExceptionItems=0;
            for (Map<String, String>repeatingException:exceptions){
                if (exception.get("itemNames").equals(repeatingException.get("itemNames")))
                    repeatingExceptionItems++;
            }

            String itemName = exception.get("itemNames");
            totalExpectedExceptionCount = totalExpectedExceptionCount + Integer.parseInt(exception.get("damagedBoxes"));
            QXClient.get().report().info(itemName + " is having a exception");
            gestures.isElementPresent(searchBtn);
            searchBtn.click();
            gestures.isElementPresent(searchBox);
            searchBox.sendKeys(itemName);
            MobileElement exceptionBtn = getMobileElementFromDynamicXpath(exceptionsBtnXpath, itemName);
            int totalBoxes = Integer.parseInt(totalBoxesCount.getText().split("/")[1]);
            int damagedBoxes = Integer.parseInt(exception.get("damagedBoxes"));
            exceptionBtn.click();
            ItemsExceptionPage itemsExceptionPage = new ItemsExceptionPage();
            itemsExceptionPage.selectExceptionType(exception);

            if (totalBoxes>damagedBoxes){
                itemsExceptionPage.isItemExceptionTitleDisplayed();
                if (!exception.get("exceptionType").equals("Cancel"))
                    itemsExceptionPage.isExceptionCardDisplayed();

                itemsExceptionPage.clickOnBackBtn();
                Assert.assertTrue(gestures.isElementPresent(deliveryNumber));
                gestures.isElementPresent(searchBtn);
                searchBtn.click();
            }

        }
    }

    public void loadBoxes() {
        deliveryAllItems = getDeliveryAllItems();
        expectedLoadedArticle = deliveryAllItems.size();
        for (String deliveryItem:deliveryAllItems){
            //int repeatingExceptionArticles=0;
            gestures.isElementPresent(totalBoxesCount);
            int totalBoxes = Integer.parseInt(totalBoxesCount.getText().split("/")[1]);
            expectedLoadedBoxes=expectedLoadedBoxes+totalBoxes;

            if (itemsExceptions!=null){
                for (Map<String, String> exception:itemsExceptions){

                    for (Map<String, String> checkRepeatedItems:itemsExceptions){
                        if (exception.get("itemNames").equals(checkRepeatedItems.get("itemNames"))){
                       //     repeatingExceptionArticles++;
                        }
                    }

                    if (deliveryItem.equals(exception.get("itemNames"))){
                        int damagedBoxes = Integer.parseInt(exception.get("damagedBoxes"));
                        totalBoxes=totalBoxes-damagedBoxes;
                        expectedLoadedBoxes = expectedLoadedBoxes-damagedBoxes;
                    }

                }
            }

//            if (repeatingExceptionArticles>1)
//                expectedLoadedArticle = expectedLoadedArticle--;

            if (totalBoxes==0) {
                expectedLoadedArticle--;
                continue;
            }

            MobileElement itemCardElement = getMobileElementFromDynamicXpath(itemCard, deliveryItem);
            itemCardElement.click();
            ArticleDetailsPage articleDetailsPage = new ArticleDetailsPage();
            articleDetailsPage.verifyLoaderIsInArticleDetailPage();
            articleDetailsPage.adjustItemBoxes(totalBoxes);
            isDeliverDetailsPageDisplayed();
        }
    }

    public void verifyBoxesLoaded() {
        String boxesLoadedString = (boxesLoadedCount.getText().split("/")[0]).trim();
        int actualBoxesLoaded = Integer.parseInt(boxesLoadedString);

        if (actualBoxesLoaded==expectedLoadedBoxes)
            QXClient.get().report().pass("Boxes Loaded container is passed");
        else
            QXClient.get().report().fail("Boxes Loaded container is failed");

        Assert.assertTrue(actualBoxesLoaded==expectedLoadedBoxes,"actual Boxes Loaded and expected Boxes loaded are not same");
    }

    public void verifyArticleLoaded(){
        String articleLoadedString = (articleLoaded.getText().split("/")[0]).trim();
        int actualArticleLoaded = Integer.parseInt(articleLoadedString);

        if (actualArticleLoaded==expectedLoadedArticle)
            QXClient.get().report().pass("Article Loaded container is passed");
        else
            QXClient.get().report().pass("Article Loaded container is failed");

        Assert.assertTrue(actualArticleLoaded==expectedLoadedArticle,"actual Article Loaded and expected Article loaded are not same");
    }

    public void verifyBoxException() {
        int actualExceptionCount = Integer.parseInt(exceptionCount.getText());
        if (actualExceptionCount==totalExpectedExceptionCount)
            QXClient.get().report().pass("Box Exceptions Conatainer is passed");
        else
            QXClient.get().report().fail("Box Exceptions Conatainer is failed");

        Assert.assertTrue(actualExceptionCount==totalExpectedExceptionCount,"actual Boxes Exceptions and expected Boxes Exceptions are not same");
    }

//    public void loadBoxesWithExceptions() {
//        deliveryAllItems = getDeliveryAllItems();
//        for (Map<String, String> itemException:itemsExceptions){
//            String deliveryItem = itemException.get("itemNames");
//            if (deliveryAllItems.contains(deliveryItem)){
//                gestures.isElementPresent(totalBoxesCount);
//                int totalBoxes = Integer.parseInt(totalBoxesCount.getText().split("/")[1]);
//                MobileElement itemCardElement = getMobileElementFromDynamicXpath(itemCard, deliveryItem);
//                itemCardElement.click();
//                ArticleDetailsPage articleDetailsPage = new ArticleDetailsPage();
//                articleDetailsPage.verifyLoaderIsInArticleDetailPage();
//                articleDetailsPage.adjustItemBoxes(totalBoxes);
//                isDeliverDetailsPageDisplayed();
//            }
//        }
//
//        for (String deliveryItem:deliveryAllItems){
//            gestures.isElementPresent(totalBoxesCount);
//            int totalBoxes = Integer.parseInt(totalBoxesCount.getText().split("/")[1]);
//            MobileElement itemCardElement = getMobileElementFromDynamicXpath(itemCard, deliveryItem);
//            itemCardElement.click();
//            ArticleDetailsPage articleDetailsPage = new ArticleDetailsPage();
//            articleDetailsPage.verifyLoaderIsInArticleDetailPage();
//            articleDetailsPage.adjustItemBoxes(totalBoxes);
//            isDeliverDetailsPageDisplayed();
//        }
//    }

    public void confirmLoadedItemsInOfflineMode(){
        confirmBtn.click();
    }

    public void verifyNoNetworkConnectionDialougeBox(){
        Assert.assertTrue(gestures.isElementPresent(noNetworkConnectionDialougeBox));
        gestures.waitForVisbilityOfWebElement(okBtn).click();
    }

    public void confirmLoadedItems(){
        confirmBtn.click();
        gestures.waitForElementToVisible(yesBtn);
        yesBtn.click();
    }

    public void confirmBoxTypeDeliveryLoading() {
        confirmBtn.click();
//        if (gestures.isElementPresent(unsyncItemsDialougeBox)){
//            //gestures.waitForVisbilityOfWebElement(okBtn);
//            cannotConfirmDeliveryBoxOkBtn.click();
//            scrollToEndDeliveryItem();
//            gestures.waitForInvisiblityOfAllElement(allRemoteSyncIcon);
//            confirmBtn.click();
//        }
        boolean result = gestures.isElementPresent(unsyncItemsDialougeBox);
        if (result) {
            //gestures.waitForVisbilityOfWebElement(okBtn);
            QXClient.get().report().info("Unsync Items DialougeBox is displayed");
            gestures.isElementPresent(cannotConfirmDeliveryBoxOkBtn);
            cannotConfirmDeliveryBoxOkBtn.click();
            QXClient.get().report().info("Click on OK button");
            scrollToEndDeliveryItem();
            gestures.waitForInvisiblityOfAllElement(allRemoteSyncIcon);
            confirmBtn.click();
            QXClient.get().report().info("Click on CONFIRM button");
        }
        result = gestures.isElementPresent(confirmBoxDeliveryYesBtn);
        confirmBoxDeliveryYesBtn.click();
    }

    public SoftAssert confirmPartiallyLoadedDelivery(){
        SoftAssert softAssert = new SoftAssert();
        confirmBtn.click();
        boolean result = gestures.isElementPresent(huNotLoadedDialougeBox);
        if (result)
            QXClient.get().report().pass("HU not loaded dailouge box is displayed");
        else
            QXClient.get().report().fail("HU not loaded dailouge box is not displayed");

        softAssert.assertTrue(gestures.isElementPresent(huNotLoadedDialougeBox));
        gestures.waitForElementToVisible(yesBtn);
        yesBtn.click();
        return softAssert;
    }

    public void deliveryLoadingConfirmation(){
        try {
            boolean result = gestures.isElementPresent(deliveryConfirmation);

            if (result)
                QXClient.get().report().pass("Delivery Loading Confirmation dialouge box is displayed");
            else
                QXClient.get().report().fail("Delivery Loading Confirmation dialouge box is not displayed");

            Assert.assertTrue(result,"delivery is not loaded");
        } catch (Exception e){
            boolean result = gestures.isElementPresent(deliveryConfirmation);

            if (result)
                QXClient.get().report().pass("Delivery Loading Confirmation dialouge box is displayed");
            else
                QXClient.get().report().fail("Delivery Loading Confirmation dialouge box is not displayed");

            Assert.assertTrue(result,"delivery is not loaded");
        }
    }

    public void boxTypeDeliveryLoadingConfirmation() {
        boolean result = gestures.isElementPresent(boxDeliveryConfirmationDialougeBox);
        if (result)
            QXClient.get().report().pass("Box Delivery Confirmation Dialouge Box is displayed");
        else
            QXClient.get().report().fail("Box Delivery Confirmation Dialouge Box is not displayed");

        Assert.assertTrue(result,"delivery is not loaded");
        boxTypeDeliveryConfirmationOkBtn.click();
    }

    public void verifyErrorMessage() {
        boolean result = gestures.isElementPresent(cannotConfirmDeliveryDialougeBox);
        if (result)
            QXClient.get().report().pass("Cannot confirm delivery dialouge box is displayed");
        else
            QXClient.get().report().fail("Cannot confirm delivery dialouge box is not displayed");

        Assert.assertTrue(result, "Cannot confirm delivery dialouge box is not displayed");
        cannotConfirmDeliveryBoxOkBtn.click();
    }

    public void searchItemAndLoadItem(Map<String, String> itemName) {
        searchBtn.click();
        gestures.isElementPresent(searchBox);
        searchBox.sendKeys(itemName.get("itemName"));
        MobileElement itemCardElement = getMobileElementFromDynamicXpath(itemCard, itemName.get("itemName"));
        int totalBoxes = Integer.parseInt(totalBoxesCount.getText().split("/")[1]);
        itemCardElement.click();
        ArticleDetailsPage articleDetailsPage = new ArticleDetailsPage();
        articleDetailsPage.verifyLoaderIsInArticleDetailPage();
        articleDetailsPage.adjustItemBoxes(totalBoxes);
        isDeliverDetailsPageDisplayed();
    }

    public void searchItem(String itemName) {
        searchBtn.click();
        gestures.isElementPresent(searchBox);
        searchBox.sendKeys(itemName);
    }

    public void clickOnExceptionButton(Map<String, String> itemName) {
        getMobileElementFromDynamicXpath(exceptionsBtnXpath, itemName.get("itemName")).click();
    }

    private MobileElement getMobileElementFromDynamicXpath(String partialXpath, String replaceCharacter){
        String xpath = String.format(partialXpath, replaceCharacter);
        return (MobileElement) QXClient.get().driver().findElement(By.xpath(xpath));
    }

}
