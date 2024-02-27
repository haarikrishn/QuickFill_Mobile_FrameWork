package com.DmartLabs.bdd.pages;

import com.DmartLabs.commonutils.Gestures;
import com.DmartLabs.commonutils.QXClient;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HU_DetailPage {

    public HU_DetailPage(){
        PageFactory.initElements(new AppiumFieldDecorator(QXClient.get().driver()), this);
    }

    @FindBy(id = "com.dmartlabs.pwp:id/txt_dhpil_title")
    private MobileElement pageTitle;

    @FindBy(id = "com.dmartlabs.pwp:id/txt_dhpil_hu_number")
    private MobileElement huNumber;

    @FindBy(id = "com.dmartlabs.pwp:id/edt_dhpil_search")
    private MobileElement searchBox;

    @FindBy(id = "com.dmartlabs.pwp:id/txt_ldhpi_item_name")
    private List<MobileElement> allItems;

    @FindBy(id = "com.dmartlabs.pwp:id/txt_ldhpi_item_name")
    private MobileElement item;

    @FindBy(id = "com.dmartlabs.pwp:id/txt_dhpil_search_error_msg")
    private MobileElement noResultMsg;

    //android.widget.TextView[@text='Grace Citrus Passi Shower Gel 250ml']

//    @FindBy(id="com.dmartlabs.pwp:id/txt_ldhpi_boxes_value")
//    private List<MobileElement> totalCaselots;

    String totalCaselotXpath = "//android.widget.TextView[@text='%s']/following-sibling::android.widget.TextView[@resource-id='com.dmartlabs.pwp:id/txt_ldhpi_boxes_value']";

    @FindBy(id = "com.dmartlabs.pwp:id/ib_ldhpi_backward")
    private MobileElement removeCaselotBtn;

    String removeCaselotBtnXpath = "//android.widget.TextView[@text='%s']/following-sibling::android.view.ViewGroup/android.widget.ImageButton[1]";
    String addCaselotBtnXpath = "//android.widget.TextView[@text='%s']/following-sibling::android.view.ViewGroup/android.widget.ImageButton[2]";

    @FindBy(id = "com.dmartlabs.pwp:id/ib_ldhpi_forward")
    private MobileElement addCaselotBtn;

    @FindBy(id = "com.dmartlabs.pwp:id/btn_dhpil_remove")
    private MobileElement removeBtn;

    @FindBy(id = "com.dmartlabs.pwp:id/txt_fricd_dialog_title")
    private MobileElement confirmChangesDialougeBox;

    @FindBy(id="com.dmartlabs.pwp:id/btn_fricd_yes")
    private MobileElement confirmChangesYesBtn;

    @FindBy(id="com.dmartlabs.pwp:id/btn_fricd_no")
    private MobileElement confirmChangesNoBtn;

    @FindBy(id = "com.dmartlabs.pwp:id/btn_dhpil_bottom_bar_back")
    private MobileElement backBtn;

    private String specificHUXpath = "//android.widget.TextView[@text='%s']";

    private boolean isScroll = true;
    private List<String> itemList = new ArrayList<>();
    private static int scrollCount = 0;

    Gestures gestures;

//    public void adjustItemCaselot(List<String> allHus, Map<String, String> adjustmentDetails){
//        gestures = QXClient.get().gestures();
//        String itemName = adjustmentDetails.get("itemName");
//        int adjustCaselot = 0;
//        AppiumDriver driver = QXClient.get().driver();
//        boolean flag = false;
//        for(String huNumber:allHus){
//            String xpath = String.format(specificHUXpath, huNumber);
//            MobileElement hu = getMobileElementFromDynamicXpath(specificHUXpath, huNumber);
//            gestures.waitForVisbilityOfWebElement(hu).click();
//            boolean result = gestures.isElementPresent(this.huNumber);
//            if (result) {
//                QXClient.get().report().pass("HU Details Page is displayed");
//                QXClient.get().report().info("Item's caselot quantity is adjusted");
//            }
//            else
//                QXClient.get().report().fail("HU Details Page is not displayed");
//
//            Assert.assertTrue(result,"HU Details Page is not displayed");
//
//            for (int i=0; i<allItems.size(); i++){
//                if (allItems.get(i).getText().contains(itemName)){
//                    System.out.println(allItems.get(i).getText());
//                    flag = true;
//                    if (adjustmentDetails.containsKey("removeCaselot")) {
//                        adjustCaselot = Integer.parseInt(adjustmentDetails.get("removeCaselot"));
//                        String totalCaselotXpath = "//android.widget.TextView[@text='"+itemName+"']/following-sibling::android.widget.TextView[@resource-id='com.dmartlabs.pwp:id/txt_ldhpi_boxes_value']";
//                        int totalCaselot = Integer.parseInt(((MobileElement) driver.findElement(By.xpath(totalCaselotXpath))).getText());
//                        String removeCaselotBtnXpath = "//android.widget.TextView[@text='"+itemName+"']/following-sibling::android.view.ViewGroup/android.widget.ImageButton[1]";
//                        MobileElement removeCaselotBtn = (MobileElement) driver.findElement(By.xpath(removeCaselotBtnXpath));
//
//                        if (adjustCaselot<=totalCaselot && adjustCaselot!=0){
//                            for(int j=1;j<=totalCaselot;j++){
//                                removeCaselotBtn.click();
//                                if (j==adjustCaselot){
//                                    break;
//                                }
//                            }
//                            removeBtn.click();
//                            Assert.assertTrue(gestures.isElementPresent(confirmChangesDialougeBox));
//                            confirmChangesYesBtn.click();
//                            break;
//                        }
//                        else {
//                            backBtn.click();
//                            System.out.println("Valid Quantity is not provided !!!!!!!!!!!!!!!!!!!!!");
//                        }
//
//                        //put it inside if() --> 77 not sure
////                        removeBtn.click();
////                        Assert.assertTrue(gestures.isElementPresent(confirmChangesDialougeBox));
////                        confirmChangesYesBtn.click();
////                        break;
//
//                    } else if (adjustmentDetails.containsKey("addCaselot")) {
//                        adjustCaselot = Integer.parseInt(adjustmentDetails.get("addCaselot"));
//                        String totalCaselotXpath = "//android.widget.TextView[@text='"+itemName+"']/following-sibling::android.widget.TextView[@resource-id='com.dmartlabs.pwp:id/txt_ldhpi_boxes_value']";
//                        int totalCaselot = Integer.parseInt(((MobileElement) driver.findElement(By.xpath(totalCaselotXpath))).getText());
//                        String addCaselotBtnXpath = "//android.widget.TextView[@text='"+itemName+"']/following-sibling::android.view.ViewGroup/android.widget.ImageButton[2]";
//                        MobileElement addCaselotBtn = (MobileElement) driver.findElement(By.xpath(addCaselotBtnXpath));
//                        if (adjustCaselot<=totalCaselot && adjustCaselot!=0){
//                            for(int j=1;j<=totalCaselot;j++){
//                                addCaselotBtn.click();
//                                if (j==adjustCaselot){
//                                    break;
//                                }
//                            }
//                            removeBtn.click();
//                            Assert.assertTrue(gestures.isElementPresent(confirmChangesDialougeBox));
//                            confirmChangesYesBtn.click();
//                            break;
//                        }
//                        else {
//                            backBtn.click();
//                            System.out.println("Valid Quantity is not provided !!!!!!!!!!!!!!!!!!!!!");
//                        }
//
////                        removeBtn.click();
////                        Assert.assertTrue(gestures.isElementPresent(confirmChangesDialougeBox));
////                        confirmChangesYesBtn.click();
////                        break;
//
//                    } else
//                        System.out.println("Wrong Details provided !!!!!!!!!!!!!!!!!!!");
//                }
//
//                if (i==allItems.size()-1 && !allItems.get(i).getText().contains(itemName)){
//                    backBtn.click();
//                }
//            }
//
//            if (flag){
//                break;
//            }
//        }
//    }


//    public void adjustItemCaselot1(List<String> allHus, List<Map<String, String>> itemsAdjustmentDetails) {
//        gestures = QXClient.get().gestures();
//        int adjustCaselot = 0;
//        int adjustedItem = 0;
//        AppiumDriver driver = QXClient.get().driver();
//        //boolean flag = false;
//        List<Boolean> huFlag = new ArrayList<>();
//        List<Boolean> itemsFlag = new ArrayList<>();
//        Map<String, Boolean> adjustedItems = new HashMap<>();
//        for(String huNumber:allHus){
//            MobileElement hu = getMobileElementFromDynamicXpath(specificHUXpath, huNumber);
//            gestures.waitForVisbilityOfWebElement(hu).click();
//            Assert.assertTrue(gestures.isElementPresent(this.huNumber));
//
//            for (Map<String, String> itemAdjustmentDetail:itemsAdjustmentDetails) {
//                String itemName = itemAdjustmentDetail.get("itemName");
//
//                if (adjustedItems.containsKey(itemName) && adjustedItems.get(itemName))
//                    continue;
//
//                for (int i=0; i<allItems.size(); i++){
//                    String actualItemName = allItems.get(i).getText();
//                    System.out.println(actualItemName);
//                    if (allItems.get(i).getText().contains(itemName)){
//                        adjustedItem++;
//                        //String actualItemName = allItems.get(i).getText();
//                        System.out.println(actualItemName);
//                        adjustedItems.put(itemName, true);
//                        //flag = true;
////                        itemsFlag.add(true);
////                        huFlag.add(true);
//                        if (itemAdjustmentDetail.containsKey("removeCaselot")) {
//                            adjustCaselot = Integer.parseInt(itemAdjustmentDetail.get("removeCaselot"));
//                            MobileElement totalCaselots = getMobileElementFromDynamicXpath(totalCaselotXpath, itemName);
//                            int totalCaselot = Integer.parseInt(totalCaselots.getText());
//                            MobileElement removeCaselotBtn = getMobileElementFromDynamicXpath(removeCaselotBtnXpath, itemName);
//
//                            if (adjustCaselot<=totalCaselot && adjustCaselot!=0){
//                                for(int j=1;j<=totalCaselot;j++){
//                                    removeCaselotBtn.click();
//                                    if (j==adjustCaselot){
//                                        break;
//                                    }
//                                }
////                                removeBtn.click();
////                                Assert.assertTrue(gestures.isElementPresent(confirmChangesDialougeBox));
////                                confirmChangesYesBtn.click();
////                                break;
//                            } else {
//                                backBtn.click();
//                                System.out.println("Valid Quantity is not provided !!!!!!!!!!!!!!!!!!!!!");
//                            }
//
//                            //put it inside if() --> 77 not sure
////                        removeBtn.click();
////                        Assert.assertTrue(gestures.isElementPresent(confirmChangesDialougeBox));
////                        confirmChangesYesBtn.click();
////                        break;
//
//                        } else if (itemAdjustmentDetail.containsKey("addCaselot")) {
//                            adjustCaselot = Integer.parseInt(itemAdjustmentDetail.get("addCaselot"));
//                            MobileElement totalCaselots = getMobileElementFromDynamicXpath(totalCaselotXpath, itemName);
//                            int totalCaselot = Integer.parseInt(totalCaselots.getText());
//                            MobileElement addCaselotBtn = getMobileElementFromDynamicXpath(addCaselotBtnXpath, itemName);
//                            if (adjustCaselot<=totalCaselot && adjustCaselot!=0){
//                                for(int j=1;j<=totalCaselot;j++){
//                                    addCaselotBtn.click();
//                                    if (j==adjustCaselot){
//                                        break;
//                                    }
//                                }
////                                removeBtn.click();
////                                Assert.assertTrue(gestures.isElementPresent(confirmChangesDialougeBox));
////                                confirmChangesYesBtn.click();
////                                break;
//                            } else {
//                                backBtn.click();
//                                System.out.println("Valid Quantity is not provided !!!!!!!!!!!!!!!!!!!!!");
//                            }
//
//                        } else
//                            System.out.println("Wrong Details provided !!!!!!!!!!!!!!!!!!!");
//
//                        break;
//
//                    }
//
////                    if (i==allItems.size()-1 && !allItems.get(i).getText().contains(itemName)){
////                        backBtn.click();
////                    }
////
////                    if (itemsFlag.size()==itemsAdjustmentDetails.size()){
////                        break;
////                    }
//                }
////                removeBtn.click();
////                Assert.assertTrue(gestures.isElementPresent(confirmChangesDialougeBox));
////                confirmChangesYesBtn.click();
//            }
//
////            if (huFlag.size()==itemsAdjustmentDetails.size()){
////                break;
////            }
//
//            if (adjustedItem==0) {
//                backBtn.click();
//            } else if (adjustedItem<itemsAdjustmentDetails.size()){
//                for (int i=0; i<allItems.size(); i++){
//                    if (adjustedItems.containsKey(allItems.get(i).getText())){
//                        removeBtn.click();
//                        Assert.assertTrue(gestures.isElementPresent(confirmChangesDialougeBox));
//                        confirmChangesYesBtn.click();
//                        break;
//                    } else if (i==allItems.size()-1 && !adjustedItems.containsKey(allItems.get(i).getText())) {
//                        backBtn.click();
//                    }
//                }
////                removeBtn.click();
////                Assert.assertTrue(gestures.isElementPresent(confirmChangesDialougeBox));
////                confirmChangesYesBtn.click();
//            } else if (adjustedItem==itemsAdjustmentDetails.size()){
//                removeBtn.click();
//                Assert.assertTrue(gestures.isElementPresent(confirmChangesDialougeBox));
//                confirmChangesYesBtn.click();
//                break;
//            }
//
//            try {
//                Thread.sleep(500);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//
//    }

    public void adjustItemCaselot2(List<String> allHus, List<Map<String, String>> itemsAdjustmentDetails) {
        gestures = QXClient.get().gestures();
        int adjustCaselot = 0;
        int adjustedItem = 0;
        Map<String, Boolean> adjustedItems = new HashMap<>();
        for (int i=0; i<allHus.size(); i++){
            MobileElement hu = getMobileElementFromDynamicXpath(specificHUXpath, allHus.get(i));
            gestures.waitForVisbilityOfWebElement(hu).click();
            Assert.assertTrue(gestures.isElementPresent(this.huNumber));

            for (Map<String, String> itemAdjustmentDetail:itemsAdjustmentDetails) {
                String itemName = itemAdjustmentDetail.get("itemName");
                if (adjustedItems.containsKey(itemName) && adjustedItems.get(itemName))
                    continue;
                gestures.isElementPresent(searchBox);
                searchBox.sendKeys(itemName);
                try {
                    if (item!=null && item.getText().contains(itemName)){
                        adjustedItem++;
                        adjustedItems.put(itemName, true);
                        if (itemAdjustmentDetail.containsKey("removeCaselot")) {
                            adjustCaselot = Integer.parseInt(itemAdjustmentDetail.get("removeCaselot"));
                            MobileElement totalCaselots = getMobileElementFromDynamicXpath(totalCaselotXpath, itemName);
                            int totalCaselot = Integer.parseInt(totalCaselots.getText());
                            MobileElement removeCaselotBtn = getMobileElementFromDynamicXpath(removeCaselotBtnXpath, itemName);

                            if (adjustCaselot<=totalCaselot && adjustCaselot!=0){
                                for(int k=1;k<=totalCaselot;k++){
                                    removeCaselotBtn.click();
                                    if (k==adjustCaselot){
                                        break;
                                    }
                                }
                            } else {
                                System.out.println("Valid Quantity is not provided !!!!!!!!!!!!!!!!!!!!!");
                            }

                        } else if (itemAdjustmentDetail.containsKey("addCaselot")) {
                            adjustCaselot = Integer.parseInt(itemAdjustmentDetail.get("addCaselot"));
                            MobileElement totalCaselots = getMobileElementFromDynamicXpath(totalCaselotXpath, itemName);
                            int totalCaselot = Integer.parseInt(totalCaselots.getText());
                            MobileElement addCaselotBtn = getMobileElementFromDynamicXpath(addCaselotBtnXpath, itemName);
                            if (adjustCaselot<=totalCaselot && adjustCaselot!=0){
                                for(int k=1;k<=totalCaselot;k++){
                                    addCaselotBtn.click();
                                    if (k==adjustCaselot){
                                        break;
                                    }
                                }
                            } else {
//                            backBtn.click();
                                System.out.println("Valid Quantity is not provided !!!!!!!!!!!!!!!!!!!!!");
                            }

                        } else
                            System.out.println("Wrong Details provided !!!!!!!!!!!!!!!!!!!");
                        //searchBox.clear();
                        item = null;
                        //break;
                    }
                } catch (Exception e){
                    if (noResultMsg!=null && noResultMsg.isDisplayed()){
                        //searchBox.clear();
                        continue;
                    }
                }

            }

            if (adjustedItem==0) {
                backBtn.click();
            } else if (adjustedItem<itemsAdjustmentDetails.size()){
                for (int j=0; j<allItems.size(); j++) {
                    if (adjustedItems.containsKey(allItems.get(j).getText())) {
                        removeBtn.click();
                        Assert.assertTrue(gestures.isElementPresent(confirmChangesDialougeBox));
                        confirmChangesYesBtn.click();
                        break;
                    } else if (j == allItems.size() - 1 && !adjustedItems.containsKey(allItems.get(j).getText())) {
                        backBtn.click();
                    }
                }
            } else if (adjustedItem==itemsAdjustmentDetails.size()){
                removeBtn.click();
                Assert.assertTrue(gestures.isElementPresent(confirmChangesDialougeBox));
                confirmChangesYesBtn.click();
                break;
            }

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void adjustItemCaselotNew(List<String> allHus, List<Map<String, String>> itemsAdjustmentDetails) {
        gestures = QXClient.get().gestures();
        int adjustCaselot = 0;
        int adjustedItem = 0;
        AppiumDriver driver = QXClient.get().driver();
        //boolean flag = false;
        List<Boolean> huFlag = new ArrayList<>();
        List<Boolean> itemsFlag = new ArrayList<>();
        Map<String, Boolean> adjustedItems = new HashMap<>();
        for(String huNumber:allHus){
            MobileElement hu = getMobileElementFromDynamicXpath(specificHUXpath, huNumber);
            gestures.waitForVisbilityOfWebElement(hu).click();
            Assert.assertTrue(gestures.isElementPresent(this.huNumber));

            for (Map<String, String> itemAdjustmentDetail:itemsAdjustmentDetails) {
                String itemName = itemAdjustmentDetail.get("itemName");

                if (adjustedItems.containsKey(itemName) && adjustedItems.get(itemName))
                    continue;

                for (int i=0; i<allItems.size(); i++){
                    if (allItems.size()<=3 || i<=allItems.size()-2){
                    //if (allItems.size()<2 || i<=allItems.size()-2){
                        if (allItems.get(i).getText().contains(itemName)) {
                            adjustedItem++;
                            adjustedItems.put(itemName, true);
//                            try {
                                adjustItemsCaselotQuantity(itemAdjustmentDetail);
//                            } catch (Exception e){
//                                int[] scrollDetails = scrollToItem(itemName);
//                                for (int j=0; j<allItems.size(); j++) {
//                                    if (allItems.get(j).getText().contains(itemName)) {
//                                        adjustedItem++;
//                                        adjustedItems.put(itemName, true);
//                                        adjustItemsCaselotQuantity(itemAdjustmentDetail);
//                                        gestures.scrollHU_ItemsDownwards(scrollDetails[0], scrollDetails[1]);
//                                        break;
//                                    }
//                                }
//                                int scrollStartHeight = allItems.get(allItems.size()-1).getLocation().getY();
//                                gestures.scrollHU_ItemsUpward(scrollStartHeight, 1);
//                                adjustItemsCaselotQuantity(itemAdjustmentDetail);
//                            }
                            break;
                        }
                    } else {
                        scrollCount = 0;
                        int[] scrollDetails = scrollToItem(itemName);
                        for (int j=0; j<allItems.size(); j++) {
                            if (allItems.get(j).getText().contains(itemName)) {
                                adjustedItem++;
                                adjustedItems.put(itemName, true);
                                adjustItemsCaselotQuantity(itemAdjustmentDetail);
                                gestures.scrollHU_ItemsDownwards(scrollDetails[0], scrollDetails[1]);
                                break;
                            }
                        }
                        break;
                    }

                }

//                if (allItems.size()<=4){
//                    for (int i=0; i<allItems.size(); i++) {
//                        if (allItems.get(i).getText().contains(itemName)) {
//                            adjustedItem++;
//                            adjustedItems.put(itemName, true);
//                            try {
//                                adjustItemsCaselotQuantity(itemAdjustmentDetail);
//                            } catch (Exception e){
//                                int scrollStartHeight = allItems.get(allItems.size()-1).getLocation().getY();
//                                gestures.scrollHU_ItemsUpward(scrollStartHeight, 1);
//                                adjustItemsCaselotQuantity(itemAdjustmentDetail);
//                            }
//                            break;
//                        }
//                    }
//                } else {
//                    int[] scrollDetails = scrollToItem(itemName);
//                    for (int i=0; i<allItems.size(); i++) {
//                        if (allItems.get(i).getText().contains(itemName)) {
//                            adjustedItem++;
//                            adjustedItems.put(itemName, true);
//                            adjustItemsCaselotQuantity(itemAdjustmentDetail);
//                            gestures.scrollHU_ItemsDownwards(scrollDetails[0], scrollDetails[1]);
//                            break;
//                        }
//                    }
//                }
            }

            if (adjustedItem==0) {
                backBtn.click();
            } else if (adjustedItem<itemsAdjustmentDetails.size()) {
//                for (int i=0; i<allItems.size(); i++){
//                    if (adjustedItems.containsKey(allItems.get(i).getText())){
//                        removeBtn.click();
//                        Assert.assertTrue(gestures.isElementPresent(confirmChangesDialougeBox));
//                        confirmChangesYesBtn.click();
//                        break;
//                    } else if (i==allItems.size()-1 && !adjustedItems.containsKey(allItems.get(i).getText())) {
//                        backBtn.click();
//                    }
//                }
                if (Boolean.parseBoolean(removeBtn.getAttribute("clickable")))  {
                    removeBtn.click();
                    Assert.assertTrue(gestures.isElementPresent(confirmChangesDialougeBox));
                    confirmChangesYesBtn.click();
                } else
                    backBtn.click();
            } else if (adjustedItem==itemsAdjustmentDetails.size()){
                removeBtn.click();
                Assert.assertTrue(gestures.isElementPresent(confirmChangesDialougeBox));
                confirmChangesYesBtn.click();
                break;
            }

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    private void adjustItemsCaselotQuantity(Map<String, String> itemAdjustmentDetail){
        int adjustCaselot = 0;
        String itemName = itemAdjustmentDetail.get("itemName");
        if (itemAdjustmentDetail.containsKey("removeCaselot")) {
            adjustCaselot = Integer.parseInt(itemAdjustmentDetail.get("removeCaselot"));
            MobileElement totalCaselots = getMobileElementFromDynamicXpath(totalCaselotXpath, itemName);
            int totalCaselot = Integer.parseInt(totalCaselots.getText());
            MobileElement removeCaselotBtn = getMobileElementFromDynamicXpath(removeCaselotBtnXpath, itemName);

            if (adjustCaselot<=totalCaselot && adjustCaselot!=0){
                for(int j=1;j<=totalCaselot;j++){
                    removeCaselotBtn.click();
                    if (j==adjustCaselot){
                        break;
                    }
                }
            } else {
                backBtn.click();
                System.out.println("Valid Quantity is not provided !!!!!!!!!!!!!!!!!!!!!");
            }

        } else if (itemAdjustmentDetail.containsKey("addCaselot")) {
            adjustCaselot = Integer.parseInt(itemAdjustmentDetail.get("addCaselot"));
            MobileElement totalCaselots = getMobileElementFromDynamicXpath(totalCaselotXpath, itemName);
            int totalCaselot = Integer.parseInt(totalCaselots.getText());
            MobileElement addCaselotBtn = getMobileElementFromDynamicXpath(addCaselotBtnXpath, itemName);
            if (adjustCaselot<=totalCaselot && adjustCaselot!=0){
                for(int j=1;j<=totalCaselot;j++){
                    addCaselotBtn.click();
                    if (j==adjustCaselot){
                        break;
                    }
                }
            } else {
                backBtn.click();
                System.out.println("Valid Quantity is not provided !!!!!!!!!!!!!!!!!!!!!");
            }

        } else
            System.out.println("Wrong Details provided !!!!!!!!!!!!!!!!!!!");
    }


    private int[] scrollToItem(String itemName){
//        for (WebElement item:allItems){
//            itemList.add(item.getText());
//            if (item.getText().equals(itemName)){
//                isScroll = false;
//                break;
//            }
//        }


        int scrollHeight = allItems.get(allItems.size()-1).getLocation().getY();
        if (isScroll){
            for (WebElement item:allItems){
                itemList.add(item.getText());
                if (item.getText().equals(itemName)){
                    isScroll = false;
                    break;
                }
            }
            scrollCount++;
            QXClient.get().gestures().scrollHU_ItemsUpward(scrollHeight,1);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if (allItems.size()>3 && allItems.get(0).getText().equals(itemList.get(itemList.size()-1))){
                itemList.remove(itemList.get(itemList.size()-1));
                scrollToItem(itemName);
            }
        }
        int[] scrollDetails = {scrollHeight, scrollCount};
        isScroll = true;
        return scrollDetails;
        //gestures.scrollVertically2(1);
    }

    private MobileElement getMobileElementFromDynamicXpath(String partialXpath, String replaceCharacter){
        String xpath = String.format(partialXpath, replaceCharacter);
        return (MobileElement) QXClient.get().driver().findElement(By.xpath(xpath));
    }

}
