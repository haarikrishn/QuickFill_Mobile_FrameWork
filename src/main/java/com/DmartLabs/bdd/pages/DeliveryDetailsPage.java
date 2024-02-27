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

import java.nio.charset.StandardCharsets;
import java.util.*;

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

    @FindBy(id = "com.dmartlabs.pwp:id/txt_lia_ean_txt")
    private List<MobileElement> boxTypeDeliveryAllEans;

    private String itemFromEanXpath = "//android.widget.TextView[@text='%s']/preceding-sibling::android.widget.TextView[@resource-id='com.dmartlabs.pwp:id/txt_lia_item_desc']";
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

    @FindBy(id = "com.dmartlabs.pwp:id/iv_da_clear_search")
    private MobileElement removeSearchBox;

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

    String eanXpath = "//android.widget.TextView[@text='%s']/following-sibling::android.widget.TextView[@resource-id='com.dmartlabs.pwp:id/txt_lia_ean_txt']";

    @FindBy(id = "com.dmartlabs.pwp:id/iv_lia_remote_sync")
    private MobileElement remoteSyncIconForMultiUserLoading;

    @FindBy(id = "com.dmartlabs.pwp:id/txt_fibe_title")
    private MobileElement cannotConfirmDeliveryDialougeBox;

    @FindBy(id = "com.dmartlabs.pwp:id/btn_fibe_ok")
    private MobileElement cannotConfirmDeliveryBoxOkBtn;

    @FindBy(id = "com.dmartlabs.pwp:id/txt_fibe_description")
    private MobileElement boxDeliveryConfirmationDialougeBox;

    private List<String> deliveryAllItems = new ArrayList<>();

    private LinkedHashSet<String> huNumberss = new LinkedHashSet<>();
    private SoftAssert softAssert = new SoftAssert();
    private List<String> loadedHus = new ArrayList<>();

    private static List<Map<String, String>> itemsExceptions;
    private boolean isScroll = true;
    private int scrollCount = 0;
    private static int expectedLoadedArticle = 0;
    private static int expectedLoadedBoxes=0;
    private static int totalExpectedExceptionCount=0;

    private static LinkedHashSet<String> itemsLists = new LinkedHashSet<>();
    private static List<String> loadedItems = new ArrayList<>();
    private static List<Map<String, String>> unloadableEans = new ArrayList<>();
    private static int unloadedArticles = 0;


    public List<String> isDeliverDetailsPageDisplayed(Map<String, String> expectedDeliveryNumber){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        gestures = QXClient.get().gestures();
        gestures.waitForElementToVisible(deliveryNumber);
        String actualDeliveryNumber = deliveryNumber.getText();

        if (actualDeliveryNumber.equals(expectedDeliveryNumber.get("deliveryNumber")))
            QXClient.get().report().pass("Delivery Detail page is displayed");
        else
            QXClient.get().report().fail("Delivery Detail page is not displayed");

        Assert.assertEquals(actualDeliveryNumber, expectedDeliveryNumber.get("deliveryNumber"));
        huNumbers = new ArrayList<>();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (WebElement hu:allHUs){
            huNumbers.add(hu.getText().trim());
        }
//        return allHUs;
        return huNumbers;
    }

    public List<String> isDeliverDetailsPageDisplayed(String deliveryNumber){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
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

//    public SoftAssert loadHUs() {
//        AppiumDriver driver = QXClient.get().driver();
//        List<String> huNumbers = new ArrayList<>();
//        SoftAssert softAssert = new SoftAssert();
//        gestures = QXClient.get().gestures();
//        allHUs = gestures.waitForVisiblityOfAllWebElement(allHUs);
//
//        for (int i = 0; i < allHUs.size(); i++) {
//                String huNumber = allHUs.get(i).getText();
//                huNumbers.add(huNumber);
//        }
//
//        for (String huNumber : huNumbers) {
//            boolean result;
//
//            try {
//                Thread.sleep(3000);
//                MobileElement loadBtn = getMobileElementFromDynamicXpath(loadBtnXpath, huNumber);
//                loadBtn.click();
//                gestures.waitForElementToVisible(yesBtn);
//                yesBtn.click();
//                Thread.sleep(1000);
//                MobileElement huStatus = getMobileElementFromDynamicXpath(huStatusXpath, huNumber);
//                result = gestures.isElementPresent(huStatus);
//
//                if (result)
//                    QXClient.get().report().pass("HU is loaded into the truck");
//                else
//                    QXClient.get().report().fail("HU is not loaded into the truck");
//
//                softAssert.assertTrue(result, "item is not loaded");
//            } catch (NoSuchElementException nse) {
//                MobileElement huStatus = getMobileElementFromDynamicXpath(huStatusXpath, huNumber);
//                result = gestures.isElementPresent(huStatus);
//
//                if (result)
//                    QXClient.get().report().pass("HU is loaded into the truck");
//                else
//                    QXClient.get().report().fail("HU is not loaded into the truck");
//
//                softAssert.assertTrue(result, "item is not loaded");
//                if (result)
//                    continue;
//            } catch (Exception e) {
//                //e.printStackTrace();
//            }
//        }
//        return softAssert;
//    }


    public SoftAssert loadHUs() {
        AppiumDriver driver = QXClient.get().driver();
        gestures = QXClient.get().gestures();
        allHUs = gestures.waitForVisiblityOfAllWebElement(allHUs);

        boolean flag = true;
        try {
            Thread.sleep(500L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < allHUs.size(); i++) {
            flag = huNumberss.add(allHUs.get(i).getText());
            if (!flag)
                break;
        }

        for (String huNumber : huNumberss) {
            boolean result;
            if (loadedHus.contains(huNumber))
                continue;

            try {
                Thread.sleep(3000);
                MobileElement loadBtn = getMobileElementFromDynamicXpath(loadBtnXpath, huNumber);
                loadBtn.click();
                gestures.waitForElementToVisible(yesBtn);
                yesBtn.click();
                searchBox.sendKeys(huNumber.split(" ")[1]);
                Thread.sleep(1000);
                MobileElement huStatus = getMobileElementFromDynamicXpath(huStatusXpath, huNumber);
                result = gestures.isElementPresent(huStatus);

                if (result) {
                    loadedHus.add(huNumber);
                    QXClient.get().report().pass("HU is loaded into the truck");
                } else
                    QXClient.get().report().fail("HU is not loaded into the truck");

                searchBox.clear();
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
        if (flag){
            loadHUs();
        }
        return softAssert;
    }

    public SoftAssert loadHUs(List<String> leftHus) {
        AppiumDriver driver = QXClient.get().driver();
        gestures = QXClient.get().gestures();
        allHUs = gestures.waitForVisiblityOfAllWebElement(allHUs);

        boolean flag = true;

        for (int i = 0; i < allHUs.size(); i++) {
            flag = huNumberss.add(allHUs.get(i).getText());
            if (!flag)
                break;
        }

        for (String huNumber : huNumberss) {
            boolean result;

            if (loadedHus.contains(huNumber))
                continue;

            try {
                if (leftHus.contains(huNumber))
                    continue;
                Thread.sleep(3000);
                MobileElement loadBtn = getMobileElementFromDynamicXpath(loadBtnXpath, huNumber);
                loadBtn.click();
                gestures.waitForElementToVisible(yesBtn);
                yesBtn.click();
                searchBox.sendKeys(huNumber.split(" ")[1]);
                Thread.sleep(1000);
                MobileElement huStatus = getMobileElementFromDynamicXpath(huStatusXpath, huNumber);
                result = gestures.isElementPresent(huStatus);

                if (result) {
                    loadedHus.add(huNumber);
                    QXClient.get().report().pass("HU is loaded into the truck");
                } else
                    QXClient.get().report().fail("HU is not loaded into the truck");

                searchBox.clear();
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
        if (flag){
            loadHUs(leftHus);
        }
        return softAssert;
    }

    public SoftAssert loadHUsInOfflineMode() {
        AppiumDriver driver = QXClient.get().driver();
        gestures = QXClient.get().gestures();
        allHUs = gestures.waitForVisiblityOfAllWebElement(allHUs);

        boolean flag = true;

        for (int i = 0; i < allHUs.size(); i++) {
            flag = huNumberss.add(allHUs.get(i).getText());
            if (!flag)
                break;
        }

        for (String huNumber : huNumberss) {
            boolean result;
            if (loadedHus.contains(huNumber))
                continue;

            try {
                Thread.sleep(3000);
                MobileElement loadBtn = getMobileElementFromDynamicXpath(loadBtnXpath, huNumber);
                loadBtn.click();
                gestures.waitForElementToVisible(yesBtn);
                yesBtn.click();
                Thread.sleep(300L);
                Assert.assertTrue(gestures.isElementPresent(noNetworkConnectionDialougeBox),"No network connection dialouge box is not displayed");
                //Thread.sleep(500);
//                gestures.waitForVisbilityOfWebElement(okBtn).click();
//                gestures.waitForVisbilityOfWebElement(okBtn1).click();
                gestures.isElementPresent(okBtn);
                okBtn.click();
                if (gestures.isElementPresent(okBtn1))
                    okBtn1.click();
                Thread.sleep(500);
                searchBox.sendKeys(huNumber.split(" ")[1]);
                Thread.sleep(1000);
                MobileElement huStatus = getMobileElementFromDynamicXpath(huStatusXpath, huNumber);
                result = gestures.isElementPresent(huStatus);

                if (result) {
                    loadedHus.add(huNumber);
                    QXClient.get().report().pass("HU is loaded into the truck");
                } else
                    QXClient.get().report().fail("HU is not loaded into the truck");

                searchBox.clear();
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
        if (flag){
            loadHUsInOfflineMode();
        }
        Assert.assertTrue(gestures.isElementPresent(remoteSyncIcon),"remote sync icon is not displayed");
        remoteSyncIcon.click();
        Assert.assertTrue(gestures.isElementPresent(unableToConnectDialougeBox));
        unableToConnectDialougeBoxOkBtn.click();
        return softAssert;
    }

    public SoftAssert loadHUsInOfflineMode(List<String> leftHus) {
        AppiumDriver driver = QXClient.get().driver();
        gestures = QXClient.get().gestures();
        allHUs = gestures.waitForVisiblityOfAllWebElement(allHUs);

        boolean flag = true;

        for (int i = 0; i < allHUs.size(); i++) {
            flag = huNumberss.add(allHUs.get(i).getText());
            if (!flag)
                break;
        }

        for (String huNumber : huNumberss) {
            boolean result;

            if (loadedHus.contains(huNumber))
                continue;

            try {
                if (leftHus.contains(huNumber))
                    continue;
                Thread.sleep(3000);
                MobileElement loadBtn = getMobileElementFromDynamicXpath(loadBtnXpath, huNumber);
                loadBtn.click();
                gestures.waitForElementToVisible(yesBtn);
                yesBtn.click();
                Thread.sleep(300L);
                Assert.assertTrue(gestures.isElementPresent(noNetworkConnectionDialougeBox),"No network connection dialouge box is not displayed");
                gestures.isElementPresent(okBtn);
                okBtn.click();
                if (gestures.isElementPresent(okBtn1))
                    okBtn1.click();
                Thread.sleep(500);
                searchBox.sendKeys(huNumber.split(" ")[1]);
                Thread.sleep(1000);
                MobileElement huStatus = getMobileElementFromDynamicXpath(huStatusXpath, huNumber);
                result = gestures.isElementPresent(huStatus);

                if (result) {
                    loadedHus.add(huNumber);
                    QXClient.get().report().pass("HU is loaded into the truck");
                } else
                    QXClient.get().report().fail("HU is not loaded into the truck");

                searchBox.clear();
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
        if (flag){
            loadHUsInOfflineMode(leftHus);
        }
        Assert.assertTrue(gestures.isElementPresent(remoteSyncIcon),"remote sync icon is not displayed");
        remoteSyncIcon.click();
        Assert.assertTrue(gestures.isElementPresent(unableToConnectDialougeBox));
        unableToConnectDialougeBoxOkBtn.click();
        return softAssert;
    }

//    public SoftAssert loadHUsInOfflineMode() {
//        AppiumDriver driver = QXClient.get().driver();
//        List<String> huNumbers = new ArrayList<>();
//        SoftAssert softAssert = new SoftAssert();
//
//        gestures = QXClient.get().gestures();
//        allHUs = gestures.waitForVisiblityOfAllWebElement(allHUs);
//
//        for (int i = 0; i < allHUs.size(); i++) {
//            String huNumber = allHUs.get(i).getText();
//            huNumbers.add(huNumber);
//        }
//
//        for (String huNumber : huNumbers) {
//            boolean result;
//
//            try {
//                MobileElement loadBtn = getMobileElementFromDynamicXpath(loadBtnXpath, huNumber);
//                loadBtn.click();
//                gestures.waitForElementToVisible(yesBtn);
//                yesBtn.click();
//                Assert.assertTrue(gestures.isElementPresent(noNetworkConnectionDialougeBox),"No network connection dialouge box is not displayed");
//                //Thread.sleep(500);
////                gestures.waitForVisbilityOfWebElement(okBtn).click();
////                gestures.waitForVisbilityOfWebElement(okBtn1).click();
//                gestures.isElementPresent(okBtn);
//                okBtn.click();
//                gestures.isElementPresent(okBtn1);
//                okBtn1.click();
//                Thread.sleep(500);
//                MobileElement huStatus = getMobileElementFromDynamicXpath(huStatusXpath, huNumber);
//                result = gestures.isElementPresent(huStatus);
//                softAssert.assertTrue(result, "item is not loaded");
//            } catch (NoSuchElementException nse) {
//                System.out.println("XXXXXXXXXXXXXXXXXXXXXXX ============================> NSE Catch Block");
//                MobileElement huStatus = getMobileElementFromDynamicXpath(huStatusXpath, huNumber);
//                result = gestures.isElementPresent(huStatus);
//                softAssert.assertTrue(result, "item is not loaded");
//                if (result)
//                    continue;
//            } catch (Exception e) {
//                //e.printStackTrace();
//            }
//        }
////        MobileElement remoteSyncIcon = getMobileElementFromDynamicXpath(remoteSyncIconXpath, huNumber);
//        Assert.assertTrue(gestures.isElementPresent(remoteSyncIcon),"remote sync icon is not displayed");
//        remoteSyncIcon.click();
//        Assert.assertTrue(gestures.isElementPresent(unableToConnectDialougeBox));
//        unableToConnectDialougeBoxOkBtn.click();
//        return softAssert;
//    }

//    public SoftAssert loadHUs2() {
//        AppiumDriver driver = QXClient.get().driver();
//        List<String> huNumbers = new ArrayList<>();
//        SoftAssert softAssert = new SoftAssert();
////        List<MobileElement> allHUs;
////        try {
////            allHUs.get(0);
////        } catch (StaleElementReferenceException sRE){
////            DeliveryDetailsPage deliveryDetails = new DeliveryDetailsPage();
////            allHUs = (List<MobileElement>) driver.findElements(By.xpath("//android.widget.TextView[@resource-id='com.dmartlabs.pwp:id/txt_lihu_hu_number']"));
////        }
//
////        try {
////            allHUs = (List<MobileElement>) driver.findElements(By.xpath("//android.widget.TextView[@resource-id='com.dmartlabs.pwp:id/txt_lihu_hu_number']"));
////            for (int i = 0; i < allHUs.size(); i++) {
////                String huNumber = allHUs.get(i).getText();
////                huNumbers.add(huNumber);
////            }
////        } catch (StaleElementReferenceException sre){
////            System.out.println("XXXXXXXXXXXXXXXXXXXXXX inside StaleElementReferenceException catch bloc ");
////            allHUs = (List<MobileElement>) driver.findElements(By.xpath("//android.widget.TextView[@resource-id='com.dmartlabs.pwp:id/txt_lihu_hu_number']"));
////            for (int i = 0; i < allHUs.size(); i++) {
////                String huNumber = allHUs.get(i).getText();
////                huNumbers.add(huNumber);
////            }
////        }
//
//        gestures = QXClient.get().gestures();
//        allHUs = gestures.waitForVisiblityOfAllWebElement(allHUs);
//
//        for (int i = 0; i < allHUs.size(); i++) {
//            String huNumber = allHUs.get(i).getText();
//            huNumbers.add(huNumber);
//        }
//
//        for (String huNumber : huNumbers) {
////            String huStatusXpath = "//android.widget.TextView[@text='" + huNumber + "']/following-sibling::android.widget.LinearLayout/descendant::android.widget.TextView[@resource-id='com.dmartlabs.pwp:id/txt_lihu_loaded_text']";
////
////            String loadBtnXpath = "//android.widget.TextView[@text='" + huNumber + "']/following-sibling::android.widget.LinearLayout/descendant::android.widget.Button[@text='LOAD']";
//
//
//            boolean result;
//
//            try {
//                boolean emptyHU_Status = verifyThatHU_IsEmpty(huNumber);
//                if (emptyHU_Status)
//                    continue;
//                //MobileElement loadBtn = (MobileElement) driver.findElement(By.xpath(loadBtnXpath));
//                Thread.sleep(3000);
//                MobileElement loadBtn = getMobileElementFromDynamicXpath(loadBtnXpath, huNumber);
//                loadBtn.click();
//                gestures.waitForElementToVisible(yesBtn);
//                yesBtn.click();
//                Thread.sleep(500);
////                MobileElement huStatus = (MobileElement) driver.findElement(By.xpath(huStatusXpath));
//                MobileElement huStatus = getMobileElementFromDynamicXpath(huStatusXpath, huNumber);
//                result = gestures.isElementPresent(huStatus);
//                softAssert.assertTrue(result, "item is not loaded");
//            } catch (NoSuchElementException nse) {
//                System.out.println("XXXXXXXXXXXXXXXXXXXXXXX ============================> NSE Catch Block");
//                MobileElement huStatus = getMobileElementFromDynamicXpath(huStatusXpath, huNumber);
//                result = gestures.isElementPresent(huStatus);
//                softAssert.assertTrue(result, "item is not loaded");
//                if (result)
//                    continue;
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//        return softAssert;
//    }

//    public SoftAssert leaveSomeHUsAndLoadReamainingHUs(List<String> leftHus) {
//        AppiumDriver driver = QXClient.get().driver();
//        List<String> huNumbers = new ArrayList<>();
//        SoftAssert softAssert = new SoftAssert();
//
//        gestures = QXClient.get().gestures();
//        allHUs = gestures.waitForVisiblityOfAllWebElement(allHUs);
//
//        for (int i = 0; i < allHUs.size(); i++) {
//            String huNumber = allHUs.get(i).getText();
//            huNumbers.add(huNumber);
//        }
//
//        for (String huNumber : huNumbers) {
//            boolean result;
//
//            try {
//                Thread.sleep(3000);
//                MobileElement loadBtn = getMobileElementFromDynamicXpath(loadBtnXpath, huNumber);
//                if (leftHus.contains(huNumber)){
//                    continue;
//                }
//                loadBtn.click();
//                gestures.waitForElementToVisible(yesBtn);
//                yesBtn.click();
//                Thread.sleep(500);
//                MobileElement huStatus = getMobileElementFromDynamicXpath(huStatusXpath, huNumber);
//                result = gestures.isElementPresent(huStatus);
//                softAssert.assertTrue(result, "item is not loaded");
//            } catch (NoSuchElementException nse) {
//                System.out.println("XXXXXXXXXXXXXXXXXXXXXXX ============================> NSE Catch Block");
//                MobileElement huStatus = getMobileElementFromDynamicXpath(huStatusXpath, huNumber);
//                result = gestures.isElementPresent(huStatus);
//                softAssert.assertTrue(result, "item is not loaded");
//                if (result)
//                    continue;
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//        return softAssert;
//    }

//    public SoftAssert leaveSomeHUsAndLoadRemaingHUsInOfflineMode(List<String> leftHus) {
//        AppiumDriver driver = QXClient.get().driver();
//        List<String> huNumbers = new ArrayList<>();
//        SoftAssert softAssert = new SoftAssert();
////        List<MobileElement> allHUs;
////        try {
////            allHUs.get(0);
////        } catch (StaleElementReferenceException sRE){
////            DeliveryDetailsPage deliveryDetails = new DeliveryDetailsPage();
////            allHUs = (List<MobileElement>) driver.findElements(By.xpath("//android.widget.TextView[@resource-id='com.dmartlabs.pwp:id/txt_lihu_hu_number']"));
////        }
//
////        try {
////            allHUs = (List<MobileElement>) driver.findElements(By.xpath("//android.widget.TextView[@resource-id='com.dmartlabs.pwp:id/txt_lihu_hu_number']"));
////            for (int i = 0; i < allHUs.size(); i++) {
////                String huNumber = allHUs.get(i).getText();
////                huNumbers.add(huNumber);
////            }
////        } catch (StaleElementReferenceException sre){
////            System.out.println("XXXXXXXXXXXXXXXXXXXXXX inside StaleElementReferenceException catch bloc ");
////            allHUs = (List<MobileElement>) driver.findElements(By.xpath("//android.widget.TextView[@resource-id='com.dmartlabs.pwp:id/txt_lihu_hu_number']"));
////            for (int i = 0; i < allHUs.size(); i++) {
////                String huNumber = allHUs.get(i).getText();
////                huNumbers.add(huNumber);
////            }
////        }
//
//        gestures = QXClient.get().gestures();
//        allHUs = gestures.waitForVisiblityOfAllWebElement(allHUs);
//
//        for (int i = 0; i < allHUs.size(); i++) {
//            String huNumber = allHUs.get(i).getText();
//            huNumbers.add(huNumber);
//        }
//
//        for (String huNumber : huNumbers) {
////            String huStatusXpath = "//android.widget.TextView[@text='" + huNumber + "']/following-sibling::android.widget.LinearLayout/descendant::android.widget.TextView[@resource-id='com.dmartlabs.pwp:id/txt_lihu_loaded_text']";
////
////            String loadBtnXpath = "//android.widget.TextView[@text='" + huNumber + "']/following-sibling::android.widget.LinearLayout/descendant::android.widget.Button[@text='LOAD']";
//
//
//            boolean result;
//
//            try {
//                //MobileElement loadBtn = (MobileElement) driver.findElement(By.xpath(loadBtnXpath));
//                Thread.sleep(3000);
//                MobileElement loadBtn = getMobileElementFromDynamicXpath(loadBtnXpath, huNumber);
//                if (leftHus.contains(huNumber)){
//                    continue;
//                }
//                loadBtn.click();
//                gestures.waitForElementToVisible(yesBtn);
//                yesBtn.click();
//                Assert.assertTrue(gestures.isElementPresent(noNetworkConnectionDialougeBox),"No network connection dialouge box is not displayed");
//                //Thread.sleep(500);
////                gestures.waitForVisbilityOfWebElement(okBtn).click();
////                gestures.waitForVisbilityOfWebElement(okBtn1).click();
//                gestures.isElementPresent(okBtn);
//                okBtn.click();
////                gestures.isElementPresent(okBtn1);
////                okBtn1.click();
//                Thread.sleep(500);
////                MobileElement huStatus = (MobileElement) driver.findElement(By.xpath(huStatusXpath));
//                MobileElement huStatus = getMobileElementFromDynamicXpath(huStatusXpath, huNumber);
//                result = gestures.isElementPresent(huStatus);
//                softAssert.assertTrue(result, "item is not loaded");
//            } catch (NoSuchElementException nse) {
//                System.out.println("XXXXXXXXXXXXXXXXXXXXXXX ============================> NSE Catch Block");
//                MobileElement huStatus = getMobileElementFromDynamicXpath(huStatusXpath, huNumber);
//                result = gestures.isElementPresent(huStatus);
//                softAssert.assertTrue(result, "item is not loaded");
//                if (result)
//                    continue;
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//        return softAssert;
//    }
//
//    public SoftAssert loadParticularHU(List<String> huNumbers){
//        AppiumDriver driver = QXClient.get().driver();
//        SoftAssert softAssert = new SoftAssert();
//
//        gestures = QXClient.get().gestures();
//        allHUs = gestures.waitForVisiblityOfAllWebElement(allHUs);
//
//        for (int i = 0; i < allHUs.size(); i++) {
//            String huNumber = allHUs.get(i).getText();
//            huNumbers.add(huNumber);
//        }
//
//        for (String huNumber : huNumbers) {
//            boolean result;
//            try {
//                Thread.sleep(3000);
//                MobileElement loadBtn = getMobileElementFromDynamicXpath(loadBtnXpath, huNumber);
//                loadBtn.click();
//                gestures.waitForElementToVisible(yesBtn);
//                yesBtn.click();
//                gestures.isElementPresent(okBtn);
//                okBtn.click();
//                Thread.sleep(500);
//                MobileElement huStatus = getMobileElementFromDynamicXpath(huStatusXpath, huNumber);
//                result = gestures.isElementPresent(huStatus);
//                softAssert.assertTrue(result, "item is not loaded");
//            } catch (NoSuchElementException nse) {
//                MobileElement huStatus = getMobileElementFromDynamicXpath(huStatusXpath, huNumber);
//                result = gestures.isElementPresent(huStatus);
//                softAssert.assertTrue(result, "item is not loaded");
//                if (result)
//                    continue;
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//        return softAssert;
//    }


    public boolean verifyThatHU_IsEmpty(String huNumber){
        MobileElement huStatus = null;
        try {
            searchBox.sendKeys(huNumber);
            Thread.sleep(800L);
            huStatus = getMobileElementFromDynamicXpath(huStatusXpath, huNumber);
            String actualHU_Status = huStatus.getText();
            searchBox.clear();
            if (actualHU_Status.equals("Loaded") || actualHU_Status.equals("Empty")) {
                QXClient.get().report().info("HU is "+actualHU_Status);
                if (!actualHU_Status.equals("Loaded"))
                    Assert.assertEquals(actualHU_Status, "Empty","HU is not empty !!!");
                return huStatus.isDisplayed();
            }
        } catch (Exception e){

        }
        searchBox.clear();
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

//    public void  itemsException(List<Map<String, String>> exceptions) {
//        itemsExceptions=exceptions;
//
//        for (int i=0; i<exceptions.size(); i++) {
//
//            if (exceptions.get(i).containsKey("itemNames")){
//
//                if (i > 0 && exceptions.get(i).get("itemNames").equals(exceptions.get(i - 1).get("itemNames"))) {
//                    totalExpectedExceptionCount = totalExpectedExceptionCount + Integer.parseInt(exceptions.get(i).get("damagedBoxes"));
//                    ItemsExceptionPage itemsExceptionPage = new ItemsExceptionPage();
//                    itemsExceptionPage.addExceptionToSameItem(exceptions.get(i));
//                    itemsExceptionPage.clickOnBackBtn();
//                    Assert.assertTrue(gestures.isElementPresent(deliveryNumber));
//                    gestures.refreshPage();
//                } else {
//                    String itemName = exceptions.get(i).get("itemNames");
//                    totalExpectedExceptionCount = totalExpectedExceptionCount + Integer.parseInt(exceptions.get(i).get("damagedBoxes"));
//                    QXClient.get().report().info(itemName + " is having a exception");
//
//                    gestures.isElementPresent(searchBtn);
//                    searchBtn.click();
//                    gestures.isElementPresent(searchBox);
//                    searchBox.sendKeys(itemName);
//                    MobileElement exceptionBtn = getMobileElementFromDynamicXpath(exceptionsBtnXpath, itemName);
//                    int totalBoxes = Integer.parseInt(totalBoxesCount.getText().split("/")[1]);
//                    int damagedBoxes = Integer.parseInt(exceptions.get(i).get("damagedBoxes"));
//                    exceptionBtn.click();
//                    ItemsExceptionPage itemsExceptionPage = new ItemsExceptionPage();
//                    itemsExceptionPage.selectExceptionType(exceptions.get(i));
//
//                    if (totalBoxes > damagedBoxes) {
//                        itemsExceptionPage.isItemExceptionTitleDisplayed();
//                        if (!exceptions.get(i).get("exceptionType").equals("Cancel"))
//                            itemsExceptionPage.isExceptionCardDisplayed();
//
//                        if ((i + 1) != exceptions.size() && !exceptions.get(i + 1).get("itemNames").equals(exceptions.get(i).get("itemNames")) || (i + 1) == exceptions.size()) {
//                            itemsExceptionPage.clickOnBackBtn();
//                            Assert.assertTrue(gestures.isElementPresent(deliveryNumber));
//                            gestures.isElementPresent(searchBtn);
//                            searchBtn.click();
//                        }
//                    }
//                }
//            } else if (exceptions.get(i).containsKey("ean")){
//                if (i > 0 && exceptions.get(i).get("ean").equals(exceptions.get(i - 1).get("ean"))) {
//                    totalExpectedExceptionCount = totalExpectedExceptionCount + Integer.parseInt(exceptions.get(i).get("damagedBoxes"));
//                    ItemsExceptionPage itemsExceptionPage = new ItemsExceptionPage();
//                    itemsExceptionPage.addExceptionToSameItem(exceptions.get(i));
//                    itemsExceptionPage.clickOnBackBtn();
//                    Assert.assertTrue(gestures.isElementPresent(deliveryNumber));
//                    gestures.refreshPage();
//                } else {
//                    String ean = exceptions.get(i).get("ean");
//                    totalExpectedExceptionCount = totalExpectedExceptionCount + Integer.parseInt(exceptions.get(i).get("damagedBoxes"));
//                    QXClient.get().report().info(ean + " is having a exception");
//
//                    gestures.isElementPresent(searchBtn);
//                    searchBtn.click();
//                    gestures.isElementPresent(searchBox);
//                    searchBox.sendKeys(ean);
//                    MobileElement exceptionBtn = getMobileElementFromDynamicXpath(exceptionsBtnXpath, ean);
//                    int totalBoxes = Integer.parseInt(totalBoxesCount.getText().split("/")[1]);
//                    int damagedBoxes = Integer.parseInt(exceptions.get(i).get("damagedBoxes"));
//                    exceptionBtn.click();
//                    ItemsExceptionPage itemsExceptionPage = new ItemsExceptionPage();
//                    itemsExceptionPage.selectExceptionType(exceptions.get(i));
//
//                    if (totalBoxes > damagedBoxes) {
//                        itemsExceptionPage.isItemExceptionTitleDisplayed();
//                        if (!exceptions.get(i).get("exceptionType").equals("Cancel"))
//                            itemsExceptionPage.isExceptionCardDisplayed();
//
//                        if ((i + 1) != exceptions.size() && !exceptions.get(i + 1).get("ean").equals(exceptions.get(i).get("ean")) || (i + 1) == exceptions.size()) {
//                            itemsExceptionPage.clickOnBackBtn();
//                            Assert.assertTrue(gestures.isElementPresent(deliveryNumber));
//                            gestures.isElementPresent(searchBtn);
//                            searchBtn.click();
//                        }
//                    }
//                }
//            }
//        }

//        for (Map<String, String> exception:exceptions) {
//            int repeatingExceptionItems=0;
//            for (Map<String, String>repeatingException:exceptions){
//                if (exception.get("itemNames").equals(repeatingException.get("itemNames")))
//                    repeatingExceptionItems++;
//            }
//
//            String itemName = exception.get("itemNames");
//            totalExpectedExceptionCount = totalExpectedExceptionCount + Integer.parseInt(exception.get("damagedBoxes"));
//            QXClient.get().report().info(itemName + " is having a exception");
//
//            gestures.isElementPresent(searchBtn);
//            searchBtn.click();
//            gestures.isElementPresent(searchBox);
//            searchBox.sendKeys(itemName);
//            MobileElement exceptionBtn = getMobileElementFromDynamicXpath(exceptionsBtnXpath, itemName);
//            int totalBoxes = Integer.parseInt(totalBoxesCount.getText().split("/")[1]);
//            int damagedBoxes = Integer.parseInt(exception.get("damagedBoxes"));
//            exceptionBtn.click();
//            ItemsExceptionPage itemsExceptionPage = new ItemsExceptionPage();
//            itemsExceptionPage.selectExceptionType(exception);
//
//            if (totalBoxes>damagedBoxes){
//                itemsExceptionPage.isItemExceptionTitleDisplayed();
//                if (!exception.get("exceptionType").equals("Cancel"))
//                    itemsExceptionPage.isExceptionCardDisplayed();
//
//                itemsExceptionPage.clickOnBackBtn();
//                Assert.assertTrue(gestures.isElementPresent(deliveryNumber));
//                gestures.isElementPresent(searchBtn);
//                searchBtn.click();
//            }
//
//        }
//    }


//    public void  itemsException1(List<Map<String, String>> exceptions) {
//        itemsExceptions=exceptions;
//        int itemsTotalDamagedBoxes=0;
//        int totalBoxes = 0;
//        for (int i=0; i<exceptions.size(); i++) {
//
//            if (exceptions.get(i).containsKey("itemNames")){
//
//                if (i > 0 && exceptions.get(i).get("itemNames").equals(exceptions.get(i - 1).get("itemNames"))) {
//                    totalExpectedExceptionCount = totalExpectedExceptionCount + Integer.parseInt(exceptions.get(i).get("damagedBoxes"));
//                    if (itemsTotalDamagedBoxes<=totalBoxes){
//                        if (itemsTotalDamagedBoxes==totalBoxes){
//                            Map<String, String> unloadableItem = new HashMap<>();
//                            unloadableItem.put("itemNames", exceptions.get(i).get("itemNames"));
//                            //unloadableItems.add(unloadableItem);
//                        }
//                        ItemsExceptionPage itemsExceptionPage = new ItemsExceptionPage();
//                        itemsExceptionPage.addExceptionToSameItem(exceptions.get(i));
//                        itemsExceptionPage.clickOnBackBtn();
//                        Assert.assertTrue(gestures.isElementPresent(deliveryNumber));
//                        gestures.refreshPage();
//                    } else {
//                        System.out.println("Wrong Damaged Box quantity is provided !!!!!!!");
//                    }
//                    try {
//                        if (exceptions.get(i+1).get("itemNames").equals(exceptions.get(i).get("itemNames")))
//                            itemsTotalDamagedBoxes = itemsTotalDamagedBoxes+Integer.parseInt(exceptions.get(i+1).get("damagedBoxes"));
//                    } catch (Exception e){
//
//                    }
//                } else {
//                    itemsTotalDamagedBoxes=0;
//                    String itemName = exceptions.get(i).get("itemNames");
//                    totalExpectedExceptionCount = totalExpectedExceptionCount + Integer.parseInt(exceptions.get(i).get("damagedBoxes"));
//                    QXClient.get().report().info(itemName + " is having a exception");
//                    gestures.isElementPresent(searchBtn);
//                    searchBtn.click();
//                    gestures.isElementPresent(searchBox);
//                    searchBox.sendKeys(itemName);
//                    MobileElement exceptionBtn = getMobileElementFromDynamicXpath(exceptionsBtnXpath, itemName);
//                    totalBoxes = Integer.parseInt(totalBoxesCount.getText().split("/")[1]);
//                    int damagedBoxes = Integer.parseInt(exceptions.get(i).get("damagedBoxes"));
//                    exceptionBtn.click();
//                    ItemsExceptionPage itemsExceptionPage = new ItemsExceptionPage();
//                    itemsExceptionPage.selectExceptionType(exceptions.get(i));
//
//                    if (damagedBoxes<=totalBoxes){
//                        if (damagedBoxes==totalBoxes){
//                            Map<String, String> unloadableItem = new HashMap<>();
//                            unloadableItem.put("itemName", exceptions.get(i).get("itemNames"));
//                            //unloadableItems.add(unloadableItem);
//                        }
//
//                        itemsExceptionPage.isItemExceptionTitleDisplayed();
//                        if (!exceptions.get(i).get("exceptionType").equals("Cancel"))
//                            itemsExceptionPage.isExceptionCardDisplayed();
//
//                        if ((i + 1) != exceptions.size() && !exceptions.get(i + 1).get("itemNames").equals(exceptions.get(i).get("itemNames")) || (i + 1) == exceptions.size()) {
//                            itemsExceptionPage.clickOnBackBtn();
//                            Assert.assertTrue(gestures.isElementPresent(deliveryNumber));
//                            gestures.isElementPresent(searchBtn);
//                            searchBtn.click();
//                        } else {
//                            itemsTotalDamagedBoxes = itemsTotalDamagedBoxes+damagedBoxes+Integer.parseInt(exceptions.get(i+1).get("damagedBoxes"));
//                        }
//                    }
//
//                }
//            } else if (exceptions.get(i).containsKey("ean")){
//                if (i > 0 && exceptions.get(i).get("ean").equals(exceptions.get(i - 1).get("ean"))) {
//                    totalExpectedExceptionCount = totalExpectedExceptionCount + Integer.parseInt(exceptions.get(i).get("damagedBoxes"));
//                    ItemsExceptionPage itemsExceptionPage = new ItemsExceptionPage();
//                    itemsExceptionPage.addExceptionToSameItem(exceptions.get(i));
//                    itemsExceptionPage.clickOnBackBtn();
//                    Assert.assertTrue(gestures.isElementPresent(deliveryNumber));
//                    gestures.refreshPage();
//                } else {
//                    String ean = exceptions.get(i).get("ean");
//                    totalExpectedExceptionCount = totalExpectedExceptionCount + Integer.parseInt(exceptions.get(i).get("damagedBoxes"));
//                    QXClient.get().report().info(ean + " is having a exception");
//
//                    gestures.isElementPresent(searchBtn);
//                    searchBtn.click();
//                    gestures.isElementPresent(searchBox);
//                    searchBox.sendKeys(ean);
//                    MobileElement exceptionBtn = getMobileElementFromDynamicXpath(exceptionsBtnXpath, ean);
//                    totalBoxes = Integer.parseInt(totalBoxesCount.getText().split("/")[1]);
//                    int damagedBoxes = Integer.parseInt(exceptions.get(i).get("damagedBoxes"));
//                    exceptionBtn.click();
//                    ItemsExceptionPage itemsExceptionPage = new ItemsExceptionPage();
//                    itemsExceptionPage.selectExceptionType(exceptions.get(i));
//
//                    if (totalBoxes > damagedBoxes) {
//                        itemsExceptionPage.isItemExceptionTitleDisplayed();
//                        if (!exceptions.get(i).get("exceptionType").equals("Cancel"))
//                            itemsExceptionPage.isExceptionCardDisplayed();
//
//                        if ((i + 1) != exceptions.size() && !exceptions.get(i + 1).get("ean").equals(exceptions.get(i).get("ean")) || (i + 1) == exceptions.size()) {
//                            itemsExceptionPage.clickOnBackBtn();
//                            Assert.assertTrue(gestures.isElementPresent(deliveryNumber));
//                            gestures.isElementPresent(searchBtn);
//                            searchBtn.click();
//                        }
//                    }
//                }
//            }
//        }
//    }

    public void  itemsException2(List<Map<String, String>> exceptions) {
        itemsExceptions=exceptions;
        int itemsTotalDamagedBoxes=0;
        int totalBoxes = 0;
        String unloadableItemName = null;

        for (int i=0; i<exceptions.size(); i++) {

            if (exceptions.get(i).containsKey("itemNames")){

                if (i > 0 && exceptions.get(i).get("itemNames").equals(exceptions.get(i - 1).get("itemNames"))) {
                    totalExpectedExceptionCount = totalExpectedExceptionCount + Integer.parseInt(exceptions.get(i).get("damagedBoxes"));
                    ItemsExceptionPage itemsExceptionPage = new ItemsExceptionPage();
                    itemsExceptionPage.addExceptionToSameItem(exceptions.get(i));
                    if (i==exceptions.size()-1) {
                        itemsExceptionPage.clickOnBackBtn();
                        Assert.assertTrue(gestures.isElementPresent(deliveryNumber));
                        gestures.refreshPage();
                    }
                } else {
                    String itemName = exceptions.get(i).get("itemNames");
                    totalExpectedExceptionCount = totalExpectedExceptionCount + Integer.parseInt(exceptions.get(i).get("damagedBoxes"));
                    QXClient.get().report().info(itemName + " is having a exception");

                    gestures.isElementPresent(searchBtn);
                    searchBtn.click();
                    gestures.isElementPresent(searchBox);
                    searchBox.sendKeys(itemName);
                    MobileElement exceptionBtn = getMobileElementFromDynamicXpath(exceptionsBtnXpath, itemName);
                    totalBoxes = Integer.parseInt(totalBoxesCount.getText().split("/")[1]);
                    int damagedBoxes = Integer.parseInt(exceptions.get(i).get("damagedBoxes"));
                    exceptionBtn.click();
                    ItemsExceptionPage itemsExceptionPage = new ItemsExceptionPage();
                    itemsExceptionPage.selectExceptionType(exceptions.get(i));

                    if (totalBoxes >= damagedBoxes) {
                        itemsExceptionPage.isItemExceptionTitleDisplayed();
                        if (!exceptions.get(i).get("exceptionType").equals("Cancel"))
                            itemsExceptionPage.isExceptionCardDisplayed();

                        if ((i + 1) != exceptions.size() && !exceptions.get(i + 1).get("itemNames").equals(exceptions.get(i).get("itemNames")) || (i + 1) == exceptions.size()) {
                            itemsExceptionPage.clickOnBackBtn();
                            Assert.assertTrue(gestures.isElementPresent(deliveryNumber));
                            gestures.isElementPresent(searchBtn);
                            searchBtn.click();
                        }
                    }
                }
            } else if (exceptions.get(i).containsKey("ean")){

                if (i > 0 && exceptions.get(i).get("ean").equals(exceptions.get(i - 1).get("ean"))) {
                    totalExpectedExceptionCount = totalExpectedExceptionCount + Integer.parseInt(exceptions.get(i).get("damagedBoxes"));
                    if (itemsTotalDamagedBoxes<=totalBoxes){
                        if (itemsTotalDamagedBoxes==totalBoxes){
                            Map<String, String> unloadableEan = new HashMap<>();
                            unloadableEan.put("itemName", unloadableItemName);
                            unloadableEan.put("damagedBoxes", String.valueOf(itemsTotalDamagedBoxes));
                            unloadableEans.add(unloadableEan);
                        }
                        ItemsExceptionPage itemsExceptionPage = new ItemsExceptionPage();
                        itemsExceptionPage.addExceptionToSameItem(exceptions.get(i));
                        if (i==exceptions.size()-1) {
                            itemsExceptionPage.clickOnBackBtn();
                            Assert.assertTrue(gestures.isElementPresent(deliveryNumber));
                            gestures.refreshPage();
                        }
                    } else {
                        System.out.println("Damaged Box quantity is more than Total Box quantity !!!!!!!");
                    }
                    try {
                        if (exceptions.get(i+1).get("itemNames").equals(exceptions.get(i).get("itemNames")))
                            itemsTotalDamagedBoxes = itemsTotalDamagedBoxes+Integer.parseInt(exceptions.get(i+1).get("damagedBoxes"));
                    } catch (Exception e){

                    }
                } else {
                    itemsTotalDamagedBoxes=0;
                    String ean = exceptions.get(i).get("ean");
                    totalExpectedExceptionCount = totalExpectedExceptionCount + Integer.parseInt(exceptions.get(i).get("damagedBoxes"));
                    QXClient.get().report().info(ean + " is having a exception");

                    gestures.isElementPresent(searchBtn);
                    searchBtn.click();
                    gestures.isElementPresent(searchBox);
                    searchBox.sendKeys(ean);
                    MobileElement exceptionBtn = getMobileElementFromDynamicXpath(exceptionsBtnXpath, ean);
                    unloadableItemName = getMobileElementFromDynamicXpath(itemFromEanXpath, exceptions.get(i).get("ean")).getText();
                    totalBoxes = Integer.parseInt(totalBoxesCount.getText().split("/")[1]);
                    int damagedBoxes = Integer.parseInt(exceptions.get(i).get("damagedBoxes"));
                    if (damagedBoxes==totalBoxes){
                        Map<String, String> unloadableEan = new HashMap<>();
                        unloadableEan.put("itemName", unloadableItemName);
                        unloadableEans.add(unloadableEan);
                    }
                    exceptionBtn.click();
                    ItemsExceptionPage itemsExceptionPage = new ItemsExceptionPage();
                    itemsExceptionPage.selectExceptionType(exceptions.get(i));

                    if (damagedBoxes<=totalBoxes) {
                        itemsExceptionPage.isItemExceptionTitleDisplayed();
                        if (!exceptions.get(i).get("exceptionType").equals("Cancel"))
                            itemsExceptionPage.isExceptionCardDisplayed();

                        if ((i + 1) != exceptions.size() && !exceptions.get(i + 1).get("ean").equals(exceptions.get(i).get("ean")) || (i + 1) == exceptions.size()) {
                            itemsExceptionPage.clickOnBackBtn();
                            Assert.assertTrue(gestures.isElementPresent(deliveryNumber));
                            gestures.isElementPresent(searchBtn);
                            searchBtn.click();
                        } else {
                            itemsTotalDamagedBoxes = itemsTotalDamagedBoxes+damagedBoxes+Integer.parseInt(exceptions.get(i+1).get("damagedBoxes"));
                            System.out.println("itemsTotalDamagedBoxes ============> "+itemsTotalDamagedBoxes);
                        }
                    }
                }
            }
        }

    }


//    public void loadBoxes() {
//        deliveryAllItems = getDeliveryAllItems();
//        System.out.println("all items ======================> "+deliveryAllItems.size());
//        expectedLoadedArticle = deliveryAllItems.size();
//        for (String deliveryItem:deliveryAllItems){
//            //int repeatingExceptionArticles=0;
//            gestures.isElementPresent(totalBoxesCount);
//            int totalBoxes = Integer.parseInt(totalBoxesCount.getText().split("/")[1]);
//            expectedLoadedBoxes=expectedLoadedBoxes+totalBoxes;
//
//            if (itemsExceptions!=null){
//                for (Map<String, String> exception:itemsExceptions){
//
////                    for (Map<String, String> checkRepeatedItems:itemsExceptions){
////                        if (exception.get("itemNames").equals(checkRepeatedItems.get("itemNames"))){
////                       //     repeatingExceptionArticles++;
////                        }
////                    }
//
//                    if (exception.containsKey("itemNames")) {
//                        if (deliveryItem.equals(exception.get("itemNames"))) {
//                            int damagedBoxes = Integer.parseInt(exception.get("damagedBoxes"));
//                            totalBoxes = totalBoxes - damagedBoxes;
//                            expectedLoadedBoxes = expectedLoadedBoxes - damagedBoxes;
//                        }
//                    } else if (exception.containsKey("ean")){
//                        if (unloadableEans.size()==0) {
//                            String ean = getMobileElementFromDynamicXpath(eanXpath, deliveryItem).getText();
//                            if (ean.equals(exception.get("ean"))) {
//                                int damagedBoxes = Integer.parseInt(exception.get("damagedBoxes"));
//                                totalBoxes = totalBoxes - damagedBoxes;
//                                expectedLoadedBoxes = expectedLoadedBoxes - damagedBoxes;
//                            }
//                        }
//                    }
//
//                }
//            }
//
////            if (repeatingExceptionArticles>1)
////                expectedLoadedArticle = expectedLoadedArticle--;
//
//            if (unloadableEans.size()>0){
//                int i=0;
//                for (Map<String, String> unloadableEan:unloadableEans) {
//                    if (deliveryItem.equals(unloadableEan.get("itemName"))){
//                        expectedLoadedBoxes = expectedLoadedBoxes-(Integer.parseInt(unloadableEan.get("damagedBoxes")));
//                        expectedLoadedArticle--;
//                        i++;
//                        break;
//                   }
//                }
//                if (i>0){
//                    continue;
//                } else {
//                    MobileElement itemCardElement = getMobileElementFromDynamicXpath(itemCard, deliveryItem);
//                    itemCardElement.click();
//                    ArticleDetailsPage articleDetailsPage = new ArticleDetailsPage();
//                    articleDetailsPage.verifyLoaderIsInArticleDetailPage();
//                    articleDetailsPage.adjustItemBoxes(totalBoxes);
//                    isDeliverDetailsPageDisplayed();
//                }
//            } else {
//                if (totalBoxes==0) {
//                    expectedLoadedArticle--;
//                    continue;
//                }
//
//                MobileElement itemCardElement = getMobileElementFromDynamicXpath(itemCard, deliveryItem);
//                itemCardElement.click();
//                ArticleDetailsPage articleDetailsPage = new ArticleDetailsPage();
//                articleDetailsPage.verifyLoaderIsInArticleDetailPage();
//                articleDetailsPage.adjustItemBoxes(totalBoxes);
//                isDeliverDetailsPageDisplayed();
//            }
//
//        }
//    }


    public void loadBoxes(){
        boolean result = true;
        for (MobileElement items:allItems){
            result=itemsLists.add(items.getText());
            if (!result) {
                //itemsLists.remove(items.getText());
                break;
            }
//            if (!itemsLists.contains(items.getText())) {
//                itemsLists.add(items.getText());
//            } else {
//                result = false;
//                break;
//            }
        }

        //expectedLoadedArticle = expectedLoadedArticle+itemsLists.size();
        expectedLoadedArticle = itemsLists.size();
        //String firstItem = itemsLists.iterator().next();
        for (String item:itemsLists) {
            if (loadedItems.contains(item))
                continue;
            gestures.isElementPresent(totalBoxesCount);
            int totalBoxes = Integer.parseInt(totalBoxesCount.getText().split("/")[1]);
            expectedLoadedBoxes=expectedLoadedBoxes+totalBoxes;

            if (itemsExceptions!=null){
                for (Map<String, String> exception:itemsExceptions){

                    if (exception.containsKey("itemNames")) {
                        if (item.equals(exception.get("itemNames"))) {
                            int damagedBoxes = Integer.parseInt(exception.get("damagedBoxes"));
                            totalBoxes = totalBoxes - damagedBoxes;
                            expectedLoadedBoxes = expectedLoadedBoxes - damagedBoxes;
                        }
                    } else if (exception.containsKey("ean")){
                        if (unloadableEans.size()==0) {
                            String ean = getMobileElementFromDynamicXpath(eanXpath, item).getText();
                            if (ean.equals(exception.get("ean"))) {
                                int damagedBoxes = Integer.parseInt(exception.get("damagedBoxes"));
                                totalBoxes = totalBoxes - damagedBoxes;
                                expectedLoadedBoxes = expectedLoadedBoxes - damagedBoxes;
                            }
                        }
                    }

                }
            }

            if (unloadableEans.size()>0){
                int i=0;
                for (Map<String, String> unloadableEan:unloadableEans) {
                    if (item.equals(unloadableEan.get("itemName"))){
                        loadedItems.add(item);
                        expectedLoadedBoxes = expectedLoadedBoxes-(Integer.parseInt(unloadableEan.get("damagedBoxes")));
                        //expectedLoadedArticle--;
                        unloadedArticles++;
                        i++;
                        break;
                    }
                }
                if (i>0){
                    continue;
                } else {
                    MobileElement itemCardElement = getMobileElementFromDynamicXpath(itemCard, item);
                    itemCardElement.click();
                    loadedItems.add(item);
                    ArticleDetailsPage articleDetailsPage = new ArticleDetailsPage();
                    articleDetailsPage.verifyLoaderIsInArticleDetailPage();
                    articleDetailsPage.adjustItemBoxes(totalBoxes);
                    isDeliverDetailsPageDisplayed();
                }
            } else {
                if (totalBoxes==0) {
                    loadedItems.add(item);
                    //expectedLoadedArticle--;
                    unloadedArticles++;
                    continue;
                }

                MobileElement itemCardElement = getMobileElementFromDynamicXpath(itemCard, item);
                itemCardElement.click();
                loadedItems.add(item);
                ArticleDetailsPage articleDetailsPage = new ArticleDetailsPage();
                articleDetailsPage.verifyLoaderIsInArticleDetailPage();
                articleDetailsPage.adjustItemBoxes(totalBoxes);
                isDeliverDetailsPageDisplayed();
            }
        }

//        itemsLists = new LinkedHashSet<>();
//        itemsLists.add(firstItem);

        if (result){
            loadBoxes();
        }

    }

//    private static List<MobileElement> itemsList = new ArrayList<>();
//    public void loadBoxes1() {
//        boolean result = false;
//        expectedLoadedArticle = deliveryAllItems.size();
//        for (MobileElement items:allItems){
//            System.out.println(items.getText());
//            result = itemsList.add(items);
//            if (result==false)
//                break;
//        }
//
//        System.out.println("Items ==================> "+itemsList.size());
//
//        for (MobileElement item:itemsList)
//            System.out.println(item.getText());
//
//        for (MobileElement item:itemsList){
//            gestures.isElementPresent(totalBoxesCount);
//            int totalBoxes = Integer.parseInt(totalBoxesCount.getText().split("/")[1]);
//            expectedLoadedBoxes=expectedLoadedBoxes+totalBoxes;
//            if (itemsExceptions!=null){
//                for (Map<String, String> exception:itemsExceptions){
//                    if (exception.containsKey("itemNames")) {
//                        if (item.getText().equals(exception.get("itemNames"))) {
//                            int damagedBoxes = Integer.parseInt(exception.get("damagedBoxes"));
//                            totalBoxes = totalBoxes - damagedBoxes;
//                            expectedLoadedBoxes = expectedLoadedBoxes - damagedBoxes;
//                        }
//                    } else if (exception.containsKey("ean")){
//                        if (unloadableEans.size()==0) {
//                            String ean = getMobileElementFromDynamicXpath(eanXpath, item.getText()).getText();
//                            if (ean.equals(exception.get("ean"))) {
//                                int damagedBoxes = Integer.parseInt(exception.get("damagedBoxes"));
//                                totalBoxes = totalBoxes - damagedBoxes;
//                                expectedLoadedBoxes = expectedLoadedBoxes - damagedBoxes;
//                            }
//                        }
//                    }
//
//                }
//            }
//
//            if (unloadableEans.size()>0){
//                int i=0;
//                for (Map<String, String> unloadableEan:unloadableEans) {
//                    if (item.getText().equals(unloadableEan.get("itemName"))){
//                        expectedLoadedBoxes = expectedLoadedBoxes-(Integer.parseInt(unloadableEan.get("damagedBoxes")));
//                        expectedLoadedArticle--;
//                        i++;
//                        break;
//                    }
//                }
//                if (i>0){
//                    continue;
//                } else {
////                    MobileElement itemCardElement = getMobileElementFromDynamicXpath(itemCard, item.getText());
////                    itemCardElement.click();
//                    item.click();
//                    ArticleDetailsPage articleDetailsPage = new ArticleDetailsPage();
//                    articleDetailsPage.verifyLoaderIsInArticleDetailPage();
//                    articleDetailsPage.adjustItemBoxes(totalBoxes);
//                    isDeliverDetailsPageDisplayed();
//                }
//            } else {
//                if (totalBoxes==0) {
//                    expectedLoadedArticle--;
//                    continue;
//                }
//
////                MobileElement itemCardElement = getMobileElementFromDynamicXpath(itemCard, item.getText());
////                itemCardElement.click();
//                item.click();
//                ArticleDetailsPage articleDetailsPage = new ArticleDetailsPage();
//                articleDetailsPage.verifyLoaderIsInArticleDetailPage();
//                articleDetailsPage.adjustItemBoxes(totalBoxes);
//                isDeliverDetailsPageDisplayed();
//            }
//
//        }
//
//        if (result){
//            loadBoxes1();
//        }
//
//    }

    public void adjustBoxesQuantityInLoadedItems(List<Map<String, String>> loadedItemsAdjustmentDetails) {
        for (Map<String, String>adjustmentDetails:loadedItemsAdjustmentDetails){
            //int[] loadingProgress = {expectedLoadedBoxes, expectedLoadedArticle};
            String itemName = adjustmentDetails.get("itemNames");
            String actions = adjustmentDetails.get("actions");
            int quantityAdjustment = Integer.parseInt(adjustmentDetails.get("boxesQuantityAdjustment"));
            gestures.isElementPresent(searchBtn);
            try {
                Thread.sleep(500l);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            searchBtn.click();
            gestures.isElementPresent(searchBox);
            searchBox.sendKeys(itemName);
            int totalBoxes = Integer.parseInt(totalBoxesCount.getText().split("/")[1]);
            int loadedBoxes = Integer.parseInt(totalBoxesCount.getText().split("/")[0]);
            getMobileElementFromDynamicXpath(itemCard, itemName).click();
            try {
                Thread.sleep(500L);
                ArticleDetailsPage articleDetailsPage = new ArticleDetailsPage();
                int[] loadingProgress = articleDetailsPage.adjustBoxesQuantity(actions, quantityAdjustment, totalBoxes, loadedBoxes, expectedLoadedBoxes, expectedLoadedArticle);
                expectedLoadedBoxes = loadingProgress[0];
                expectedLoadedArticle = loadingProgress[1];
                Thread.sleep(500L);
                removeSearchBox.click();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
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
        expectedLoadedArticle = expectedLoadedArticle-unloadedArticles;

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

    public void clickOnConfirmBtn() {
        confirmBtn.click();
    }

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
        boolean result = gestures.isElementPresent(unsyncItemsDialougeBox);
        if (result) {
            QXClient.get().report().info("Unsync Items DialougeBox is displayed");
            gestures.isElementPresent(cannotConfirmDeliveryBoxOkBtn);
            cannotConfirmDeliveryBoxOkBtn.click();
            QXClient.get().report().info("Click on OK button");
//            scrollToEndDeliveryItem();
            gestures.refreshPage();
            gestures.waitForInvisiblityOfAllElement(allRemoteSyncIcon);
            try {
                Thread.sleep(5000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            confirmBtn.click();
            QXClient.get().report().info("Click on CONFIRM button");
        }
        gestures.isElementPresent(confirmBoxDeliveryYesBtn);
        confirmBoxDeliveryYesBtn.click();
    }

    public void confirmBoxTypeDeliveryLoading1() {
        confirmBtn.click();
//        if (gestures.isElementPresent(unsyncItemsDialougeBox)){
//            //gestures.waitForVisbilityOfWebElement(okBtn);
//            cannotConfirmDeliveryBoxOkBtn.click();
//            scrollToEndDeliveryItem();
//            gestures.waitForInvisiblityOfAllElement(allRemoteSyncIcon);
//            confirmBtn.click();
//        }
        boolean result = true;
        while (result) {
            result = gestures.isElementPresent(unsyncItemsDialougeBox);
            if (result) {
                //gestures.waitForVisbilityOfWebElement(okBtn);
                QXClient.get().report().info("Unsync Items DialougeBox is displayed");
                gestures.isElementPresent(cannotConfirmDeliveryBoxOkBtn);
                cannotConfirmDeliveryBoxOkBtn.click();
                QXClient.get().report().info("Click on OK button");
//            scrollToEndDeliveryItem();
                gestures.refreshPage();
            }
        }
        confirmBtn.click();
        QXClient.get().report().info("Click on CONFIRM button");
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

            Assert.assertTrue(result,"Delivery Loading Confirmation dialouge box is not displayed");
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

    private List<String> huList = new ArrayList<>();
    private String specificHUXpath = "//android.widget.TextView[@text='%s']";

    public List<String> getAllHUs(){
        for (WebElement hu:allHUs){
            String huText = hu.getText();
            if (!huList.contains(huText))
                huList.add(huText);
        }


        if (isScroll){
            QXClient.get().gestures().scrollDeliveryItemsUpwards(1);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if (allHUs.get(0).getText().equals(huList.get(huList.size()-1))){
                huList.remove(huList.get(huList.size()-1));
                getAllHUs();
            }
            else
                isScroll = false;
        }
        gestures.scrollDeliveryItemsDownward(1);


        return huList;
    }

}
