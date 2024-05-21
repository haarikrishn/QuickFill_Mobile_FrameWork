package com.DmartLabs.bdd.pages;

import com.DmartLabs.commonutils.QXClient;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.cucumber.datatable.DataTable;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class QF_AllOfflinePage {


    public QF_AllOfflinePage() {

        PageFactory.initElements(new AppiumFieldDecorator(QXClient.get().driver()), this);

    }

    //===============================================================================
    //scroll

    Actions actions = new Actions(QXClient.get().driver());
    @FindBy(xpath = "//android.widget.Button[@resource-id='panel1a-header']")
    private List<MobileElement> ListOfItems;

    @FindBy(xpath = "//android.widget.Button[@text='Complete']")
    private MobileElement completeBtn;

    @FindBy(xpath = "//android.widget.Button[@text='CONFIRM']")
    private MobileElement confirmBtn;

    // Set<String> deliveryAllItemsPickerAl = new LinkedHashSet<>();


    List<String> deliveryAllItemsPickerAl = new LinkedList<>();

    boolean isScroll = true;
    int scrollCount = 0;

    public List<String> getAllItems() throws InterruptedException {

        Thread.sleep(1000);
        for (MobileElement item : ListOfItems) {
            deliveryAllItemsPickerAl.add(item.getText().trim());
        }
        if (isScroll) {
            scrollCount++;

            QXClient.get().gestures().scrollItemsUpward(1);
            System.out.println("scroll Upward ");

            System.out.println(ListOfItems.get(0).getText() + "=======>WithoutBlockItems.get(0).getText()");
            System.out.println(deliveryAllItemsPickerAl.get(deliveryAllItemsPickerAl.size() - 1) + "============>list.get(deliveryAllItemsPickerAl.size() - 1)");

            if (ListOfItems.get(0).getText().equals(deliveryAllItemsPickerAl.get(deliveryAllItemsPickerAl.size() - 1))) {

//                deliveryAllItemsPickerAl.remove(deliveryAllItemsPickerAl.size() - 1);
                //   System.out.println("after removing")
                Thread.sleep(500);
                getAllItems();

            } else {

                isScroll = false;
            }
        } else {

            isScroll = false;
        }

        Thread.sleep(500);
        QXClient.get().gestures().scrollDeliveryItemsDownward(1);
        System.out.println("scroll downward ");
        Thread.sleep(500);

        return deliveryAllItemsPickerAl;
    }
//========================================================================================================


    static int startY = 0;
    static int endY = 0;

    public int[] getLocation() {
        System.out.println(ListOfItems.size() + "============>ListOfItems.size()");

        startY = ListOfItems.get(ListOfItems.size() - 2).getLocation().getY();//end y

        // startY = ListOfItems.get(ListOfItems.size()).getLocation().getY();
        endY = ListOfItems.get(0).getLocation().getY();
        return new int[]{startY, endY};
    }


    //   LinkedHashSet<String> deliveryAllItemsPickerAlNew = new LinkedHashSet<>();
    public List<String> getAllItemsNew(int[] location) throws InterruptedException {

        Thread.sleep(1000);
        int k = 0;

        int xAxis = (ListOfItems.get(0).getLocation().getX()) * 2;

        for (MobileElement item : ListOfItems) {
            deliveryAllItemsPickerAl.add(item.getText().trim());

        }

//        for(String all:deliveryAllItemsPickerAl)
//        {
//            System.out.println(all);
//        }

        System.out.println("one round after");
        System.out.println(deliveryAllItemsPickerAl.size() + "==============>" + "deliveryAllItemsPickerAl.size()");
        if (isScroll) {
            scrollCount++;

            System.out.println("scroll Upward ");
            Thread.sleep(500);

            QXClient.get().gestures().scrollVerticallyDevice(xAxis, location[0], location[1], 1);

            System.out.println("compare before");


            if (ListOfItems.get(0).getText().equals(deliveryAllItemsPickerAl.get(deliveryAllItemsPickerAl.size() - 2))) {
                System.out.println(ListOfItems.get(0).getText() + "=======>WithoutBlockItems.get(0).getText()");
                System.out.println(deliveryAllItemsPickerAl.get(deliveryAllItemsPickerAl.size() - 2) + "============>list.get(deliveryAllItemsPickerAl.size() - 1)");

                System.out.println("compare after");

                deliveryAllItemsPickerAl.remove(deliveryAllItemsPickerAl.size() - 1);
//                deliveryAllItemsPickerAl.remove(deliveryAllItemsPickerAl.size() - 1);
                System.out.println("after removing");
                getAllItemsNew(location);
            } else {

                isScroll = false;
            }
        } else {

            isScroll = false;
        }
        Thread.sleep(2000);
        System.out.println("scroll downward ");
        QXClient.get().gestures().scrollVerticallyDevice12(xAxis, location[1], location[0], 1);
        Thread.sleep(500);
        return deliveryAllItemsPickerAl;

    }


    // ====================================================================================


    public void PrintAllIems() {
        int i = 0;
        for (String Items : deliveryAllItemsPickerAl) {
            System.out.println(Items + "====>" + i++);
        }

    }

    //=====================================================================================
    //headline
    @FindBy(xpath = "//android.widget.TextView[@text='Tasks']")
    private MobileElement taskHeadline;

    @FindBy(xpath = "//android.widget.Button[@text='Floor Walk']")
    private MobileElement floorwalk;

    @FindBy(xpath = "//android.widget.Button[contains(@text,'ALL')]")
    private MobileElement AllTasks;
    @FindBy(xpath = "//android.widget.Button[contains(@text,'OPEN')]")
    private MobileElement openTasks;

    @FindBy(xpath = "//android.widget.Button[contains(@text,'CLOSED')]")
    private MobileElement closedTasks;


    //===================================================================

    @FindBy(xpath = "//android.widget.EditText[@resource-id='field_qnt' and @text='Enter number of boxes']")
    private MobileElement EnterNoofBoxes;

    @FindBy(xpath = "//android.widget.TextView[contains(@text, 'board') and not(contains(@text, 'boards'))]")
    private List<MobileElement> PriceBoardsEle;

    @FindBy(xpath = "//android.app.Dialog/android.view.View/android.view.View[1]/android.widget.CheckBox")
    private MobileElement checkbox1;
    @FindBy(xpath = "//android.app.Dialog/android.view.View/android.view.View[2]/android.widget.CheckBox")
    private MobileElement checkbox2;
    @FindBy(xpath = "//android.app.Dialog/android.view.View/android.view.View[3]/android.widget.CheckBox")
    private MobileElement checkbox3;
    @FindBy(xpath = "//android.app.Dialog/android.view.View/android.view.View[4]/android.widget.CheckBox")
    private MobileElement checkbox4;
    @FindBy(xpath = "//android.widget.EditText[@resource-id='field_comment']")
    private MobileElement enterComment;
    @FindBy(xpath = "//android.widget.TextView[@text='No record found']")
            private MobileElement norecordsfoundEle;


    String FullPriceBoardValue;
    String HalfPriceBoardValue;
    String MediumPriceBoardValue;
    String smallPriceBoardValue;

    public void getPriceBoards(DataTable dataTable) {
        Map<String, String> priceBoardDT = dataTable.asMap(String.class, String.class);
        FullPriceBoardValue = priceBoardDT.get("FullPriceBoard");
        HalfPriceBoardValue = priceBoardDT.get("HalfPriceBoard");
        MediumPriceBoardValue = priceBoardDT.get("MediumPriceBoard");
        smallPriceBoardValue = priceBoardDT.get("smallPriceBoard");
    }

    public void getPriceBoardsOffline(DataTable dataTable) {
        Map<String, String> priceBoardDT = dataTable.asMap(String.class, String.class);
        FullPriceBoardValue = priceBoardDT.get("FullPriceBoard");
        HalfPriceBoardValue = priceBoardDT.get("HalfPriceBoard");
        MediumPriceBoardValue = priceBoardDT.get("MediumPriceBoard");
        smallPriceBoardValue = priceBoardDT.get("smallPriceBoard");
    }




//online
    public void completeAllTheTask(DataTable dataTable) throws InterruptedException {

        int k = 0;
        Map<String, String> TaskTypeDT = dataTable.asMap(String.class, String.class);
        RefillValue = TaskTypeDT.get("TaskTypeRefill");
        OtherValue = TaskTypeDT.get("TaskTypeOther");
        BoardValue = TaskTypeDT.get("TaskTypeBoard");
        RefilledQuantityValue = TaskTypeDT.get("RefilledQuantity");
        OthersCommentValue = TaskTypeDT.get("OthersComment");

        Thread.sleep(2000);
//ctrl+alt+l
//android.widget.Button[@resource-id='panel1a-header' and @text='Dabur Lemon Glucoplus-C Jar(400g) Refill']
        //=====turnoff wifi



        QXClient.get().gestures().waitAndClickElementisVisible(openTasks);
        Thread.sleep(2000);

        for (int i = 0; i < ListOfItems.size(); i++) {
            itemsList.add(ListOfItems.get(i).getText());
            System.out.println(ListOfItems.get(i).getText() + i);
        }

//===================================================
        for (String newItems : itemsList) {
            //android.widget.Button[@resource-id='panel1a-header' and @text='Dabur Lemon Glucoplus-C Jar(400g) Refill']
            MobileElement item1 = null;
            try {
                item1 = (MobileElement) QXClient.get().driver().findElement(By.xpath("//android.widget.Button[@resource-id='panel1a-header' and @text='" + newItems + "']"));
                //other
            } catch (Exception e1) {
                // QXClient.get().gestures().scrollUpToMobileElement(item1,"1");
                //  QXClient.get().gestures().swipeUp();
                try {
                    item1 = (MobileElement) QXClient.get().driver().findElement(By.xpath("//android.widget.Button[@resource-id='panel1a-header' and @text='" + newItems + "']"));
                } catch (Exception e2) {//other
                    //    QXClient.get().gestures().scrollToMobileElement(item1, "1");
                    QXClient.get().gestures().scrollUpToMobileElement(item1,"1");//scroll down)
                    Thread.sleep(1000);
                    item1 = (MobileElement) QXClient.get().driver().findElement(By.xpath("//android.widget.Button[@resource-id='panel1a-header' and @text='" + newItems + "']"));

                    //  QXClient.get().gestures().scrollTilltextVisible(newItems);
                }
            }
            Thread.sleep(1000);

            if (item1.getText().contains(OtherValue)) {
                try {
                    QXClient.get().gestures().waitAndClickElementisVisible(item1);
                } catch (StaleElementReferenceException e) {
                    completeAllTheTask1(dataTable);
                }
                Thread.sleep(4000);
                try {
                    completeBtn.click();
                } catch (Exception e) {
                    QXClient.get().gestures().scrollToMobileElement(completeBtn, "1");
                    completeBtn.click();
                }
                try {
                    //OthersCommentValue
                    enterComment.click();
                    enterComment.sendKeys(OthersCommentValue);
                } catch (Exception e) {
                    actions.sendKeys(OthersCommentValue).perform();
                }
                Thread.sleep(4000);
                confirmBtn.click();
                Thread.sleep(4000);
            }


            //=====================================================
            //refill
            else if (item1.getText().contains(RefillValue)) {
                //    System.out.println(RefilledQuantityValue+"==============>RefilledQuantityValue");
                try {
                    QXClient.get().gestures().waitAndClickElementisVisible(item1);
                } catch (Exception e) {
                    completeAllTheTask1(dataTable);
                }
                Thread.sleep(4000);
                try {
                    completeBtn.click();
                } catch (Exception e) {
                    QXClient.get().gestures().scrollToMobileElement(completeBtn, "1");
                    completeBtn.click();
                }
                Thread.sleep(1000);

                actions.sendKeys(RefilledQuantityValue).build().perform();


                //=========================================================
                Thread.sleep(5000);

                //      Thread.sleep(4000);
                confirmBtn.click();
                Thread.sleep(4000);
            }


            //===========================================================================
            //board      crtl+alt+l
            else if (item1.getText().contains(BoardValue)) {
                try {
                    QXClient.get().gestures().waitAndClickElementisVisible(item1);
                } catch (Exception e) {
                    completeAllTheTask1(dataTable);
                }
                Thread.sleep(4000);
                try {
                    completeBtn.click();
                } catch (Exception e) {
                    QXClient.get().gestures().scrollToMobileElement(completeBtn, "1");
                    completeBtn.click();
                }
                Thread.sleep(4000);
                //ctrl+alt+l
                List<String> priceBoardAL = new LinkedList<>();

                for (int i = 0; i < PriceBoardsEle.size(); i++) {
                    priceBoardAL.add(PriceBoardsEle.get(i).getText());
                }

                for (String priceText : priceBoardAL) {
                    System.out.println(priceText + "===================>priceText");
                    System.out.println(FullPriceBoardValue + "===========>FullPriceBoardValue");
                    if (priceText.equals(FullPriceBoardValue)) {
                        checkbox1.click();
                        Thread.sleep(2000);

                    } else if (priceText.equals(HalfPriceBoardValue)) {
                        checkbox2.click();
                        Thread.sleep(2000);
                    } else if (priceText.equals(MediumPriceBoardValue)) {
                        checkbox3.click();
                        Thread.sleep(2000);
                    } else if (priceText.equals(smallPriceBoardValue)) {
                        checkbox4.click();
                        Thread.sleep(2000);
                    }

                }

                Thread.sleep(4000);
                confirmBtn.click();
                Thread.sleep(4000);
            }

            if (k >= itemsList.size() - 1) {
                System.out.println("items completed, iterate");
                itemsList.clear();
                try {
                    if (norecordsfoundEle.isDisplayed()) {
                        System.out.println("items are not available");
                        break;
                    }
                }
                catch (Exception e)
                {
                    System.out.println(e.getMessage());
                }
                completeAllTheTask1(dataTable);

            }
            k++;

        }

    }

    //==================================================================================

    String RefillValue;
    String OtherValue;
    String BoardValue;
    String RefilledQuantityValue;
    String OthersCommentValue;

    List<String> itemsList = new LinkedList<>();

    public void completeAllTheTask1(DataTable dataTable) throws InterruptedException {
        int k = 0;
        Map<String, String> TaskTypeDT = dataTable.asMap(String.class, String.class);
         RefillValue = TaskTypeDT.get("TaskTypeRefill");
         OtherValue = TaskTypeDT.get("TaskTypeOther");
         BoardValue = TaskTypeDT.get("TaskTypeBoard");
         RefilledQuantityValue = TaskTypeDT.get("RefilledQuantity");
         OthersCommentValue = TaskTypeDT.get("OthersComment");

        Thread.sleep(2000);
//ctrl+alt+l
//android.widget.Button[@resource-id='panel1a-header' and @text='Dabur Lemon Glucoplus-C Jar(400g) Refill']
     //=====turnoff wifi

QXClient.get().gestures().toggleWiFi();
Thread.sleep(500);


        QXClient.get().gestures().waitAndClickElementisVisible(openTasks);
        Thread.sleep(2000);

        for (int i = 0; i < ListOfItems.size(); i++) {
            itemsList.add(ListOfItems.get(i).getText());
            System.out.println(ListOfItems.get(i).getText() + i);
        }

//===================================================
        for (String newItems : itemsList) {
            //android.widget.Button[@resource-id='panel1a-header' and @text='Dabur Lemon Glucoplus-C Jar(400g) Refill']
            MobileElement item1 = null;
            try {
                item1 = (MobileElement) QXClient.get().driver().findElement(By.xpath("//android.widget.Button[@resource-id='panel1a-header' and @text='" + newItems + "']"));
                //other
            } catch (Exception e1) {
                // QXClient.get().gestures().scrollUpToMobileElement(item1,"1");
                //  QXClient.get().gestures().swipeUp();
                try {
                    item1 = (MobileElement) QXClient.get().driver().findElement(By.xpath("//android.widget.Button[@resource-id='panel1a-header' and @text='" + newItems + "']"));
                } catch (Exception e2) {//other
                //    QXClient.get().gestures().scrollToMobileElement(item1, "1");
                   QXClient.get().gestures().scrollUpToMobileElement(item1,"1");//scroll down)
                   Thread.sleep(1000);
                    item1 = (MobileElement) QXClient.get().driver().findElement(By.xpath("//android.widget.Button[@resource-id='panel1a-header' and @text='" + newItems + "']"));

                    //  QXClient.get().gestures().scrollTilltextVisible(newItems);
                }
            }
            Thread.sleep(1000);

                if (item1.getText().contains(OtherValue)) {
                    try {
                        QXClient.get().gestures().waitAndClickElementisVisible(item1);
                    } catch (StaleElementReferenceException e) {
                        completeAllTheTask1(dataTable);
                    }
                    Thread.sleep(4000);
                    try {
                        completeBtn.click();
                    } catch (Exception e) {
                        QXClient.get().gestures().scrollToMobileElement(completeBtn, "1");
                        completeBtn.click();
                    }
                    try {
                        //OthersCommentValue
                        enterComment.click();
                        enterComment.sendKeys(OthersCommentValue);
                    } catch (Exception e) {
                        actions.sendKeys(OthersCommentValue).perform();
                    }
                    Thread.sleep(4000);
                    confirmBtn.click();
                    Thread.sleep(4000);
                }


            //=====================================================
            //refill
            else if (item1.getText().contains(RefillValue)) {
                //    System.out.println(RefilledQuantityValue+"==============>RefilledQuantityValue");
                try {
                    QXClient.get().gestures().waitAndClickElementisVisible(item1);
                } catch (Exception e) {
                    completeAllTheTask1(dataTable);
                }
                Thread.sleep(4000);
                try {
                    completeBtn.click();
                } catch (Exception e) {
                    QXClient.get().gestures().scrollToMobileElement(completeBtn, "1");
                    completeBtn.click();
                }
                Thread.sleep(1000);

                actions.sendKeys(RefilledQuantityValue).build().perform();


                //=========================================================
                Thread.sleep(5000);

                //      Thread.sleep(4000);
                confirmBtn.click();
                Thread.sleep(4000);
            }


            //===========================================================================
            //board      crtl+alt+l
            else if (item1.getText().contains(BoardValue)) {
                try {
                    QXClient.get().gestures().waitAndClickElementisVisible(item1);
                } catch (Exception e) {
                    completeAllTheTask1(dataTable);
                }
                Thread.sleep(4000);
                try {
                    completeBtn.click();
                } catch (Exception e) {
                    QXClient.get().gestures().scrollToMobileElement(completeBtn, "1");
                    completeBtn.click();
                }
                Thread.sleep(4000);
                //ctrl+alt+l
                List<String> priceBoardAL = new LinkedList<>();

                for (int i = 0; i < PriceBoardsEle.size(); i++) {
                    priceBoardAL.add(PriceBoardsEle.get(i).getText());
                }

                for (String priceText : priceBoardAL) {
                    System.out.println(priceText + "===================>priceText");
                    System.out.println(FullPriceBoardValue + "===========>FullPriceBoardValue");
                    if (priceText.equals(FullPriceBoardValue)) {
                        checkbox1.click();
                        Thread.sleep(2000);

                    } else if (priceText.equals(HalfPriceBoardValue)) {
                        checkbox2.click();
                        Thread.sleep(2000);
                    } else if (priceText.equals(MediumPriceBoardValue)) {
                        checkbox3.click();
                        Thread.sleep(2000);
                    } else if (priceText.equals(smallPriceBoardValue)) {
                        checkbox4.click();
                        Thread.sleep(2000);
                    }

                }

                Thread.sleep(4000);
                confirmBtn.click();
                Thread.sleep(4000);
            }

            if (k >= itemsList.size() - 1) {
                System.out.println("items completed, iterate");
                itemsList.clear();
                try {
                    if (norecordsfoundEle.isDisplayed()) {
                        System.out.println("items are not available");
                        break;
                    }
                }
                catch (Exception e)
                {
                    System.out.println(e.getMessage());
                }
                completeAllTheTask1(dataTable);

            }
            k++;

        }

    }
//=========================================================================================
//closed items


//done in half way
    List<String>closedItemsList=new LinkedList<>();

    public  void closeOffline(DataTable dataTable) throws InterruptedException {
        QXClient.get().gestures().clickOnElement(closedTasks);
        for (int i = 0; i < ListOfItems.size(); i++) {
            closedItemsList.add(ListOfItems.get(i).getText());
            System.out.println(ListOfItems.get(i).getText() + i);
        }
int m=0;
//===================================================
        for (String newItems : closedItemsList) {
            //android.widget.Button[@resource-id='panel1a-header' and @text='Dabur Lemon Glucoplus-C Jar(400g) Refill']
            MobileElement item1 = null;
            try {
                item1 = (MobileElement) QXClient.get().driver().findElement(By.xpath("//android.widget.Button[@resource-id='panel1a-header' and @text='" + newItems + "']"));
                //other
            } catch (Exception e1) {
                // QXClient.get().gestures().scrollUpToMobileElement(item1,"1");
                //  QXClient.get().gestures().swipeUp();
                try {
                    item1 = (MobileElement) QXClient.get().driver().findElement(By.xpath("//android.widget.Button[@resource-id='panel1a-header' and @text='" + newItems + "']"));
                } catch (Exception e2) {//other
                    //    QXClient.get().gestures().scrollToMobileElement(item1, "1");
                    QXClient.get().gestures().scrollUpToMobileElement(item1, "1");//scroll down)
                    Thread.sleep(1000);
                    item1 = (MobileElement) QXClient.get().driver().findElement(By.xpath("//android.widget.Button[@resource-id='panel1a-header' and @text='" + newItems + "']"));

                    //  QXClient.get().gestures().scrollTilltextVisible(newItems);
                }
            }
            Thread.sleep(1000);

            if (item1.getText().contains(OtherValue)) {
                try {
                    QXClient.get().gestures().waitAndClickElementisVisible(item1);
                } catch (StaleElementReferenceException e) {
                    completeAllTheTask1(dataTable);
                }
                Thread.sleep(4000);
                try {
                    //  completeBtn.click();

                    if (completeBtn.isDisplayed()) {
                        System.out.println(OtherValue+ "task is completed");
                    }

                } catch (Exception e) {
                    QXClient.get().gestures().scrollToMobileElement(completeBtn, "1");
                    if (completeBtn.isDisplayed()) {
                        System.out.println(OtherValue+"task is completed");
                    }
                }
                Thread.sleep(500);
                QXClient.get().gestures().waitAndClickElementisVisible(item1);
                Thread.sleep(500);
            }


            //=====================================================
            //refill
            else if (item1.getText().contains(RefillValue)) {
                //    System.out.println(RefilledQuantityValue+"==============>RefilledQuantityValue");
                try {
                    QXClient.get().gestures().waitAndClickElementisVisible(item1);
                } catch (StaleElementReferenceException e) {
                    completeAllTheTask1(dataTable);
                }
                Thread.sleep(4000);
                try {
                    //  completeBtn.click();

                    if (completeBtn.isDisplayed()) {
                        System.out.println(RefillValue+"task is completed");
                    }

                } catch (Exception e) {
                    QXClient.get().gestures().scrollToMobileElement(completeBtn, "1");
                    if (completeBtn.isDisplayed()) {
                        System.out.println(RefillValue+"task is completed");
                    }
                }
                Thread.sleep(500);
                QXClient.get().gestures().waitAndClickElementisVisible(item1);
                Thread.sleep(500);
            }


            //===========================================================================
            //board      crtl+alt+l
            else if (item1.getText().contains(BoardValue)) {
                try {
                    QXClient.get().gestures().waitAndClickElementisVisible(item1);
                } catch (StaleElementReferenceException e) {
                    completeAllTheTask1(dataTable);
                }
                Thread.sleep(4000);
                try {
                    //  completeBtn.click();

                    if (completeBtn.isDisplayed()) {
                        System.out.println(BoardValue+"task is completed");
                    }

                } catch (Exception e) {
                    QXClient.get().gestures().scrollToMobileElement(completeBtn, "1");
                    if (completeBtn.isDisplayed()) {
                        System.out.println(BoardValue+"task is completed");
                    }
                }
                Thread.sleep(500);
                QXClient.get().gestures().waitAndClickElementisVisible(item1);
                Thread.sleep(500);

            }

            if (m >= itemsList.size() - 1) {
                System.out.println("items completed, iterate");
                itemsList.clear();
                try {
                    if (norecordsfoundEle.isDisplayed()) {
                        System.out.println("items are not available");
                        break;
                    }
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                completeAllTheTask1(dataTable);

            }
            m++;

        }
        Thread.sleep(500);
        System.out.println("turn on the wifi");
        QXClient.get().gestures().toggleWiFi();
        System.out.println("items are trying to sync");
        Thread.sleep(10000);
        System.out.println("items syncing are completed");


    }
        //==========================================================================================================================
// //offline
//
//
// public void completeAllTheTaskInOfflineMode(DataTable dataTable) throws InterruptedException {
//     int k = 0;
//     Map<String, String> TaskTypeDT = dataTable.asMap(String.class, String.class);
//     String RefillValue = TaskTypeDT.get("TaskTypeRefill");
//     String OtherValue = TaskTypeDT.get("TaskTypeOther");
//     String BoardValue = TaskTypeDT.get("TaskTypeBoard");
//     String RefilledQuantityValue = TaskTypeDT.get("RefilledQuantity");
//     String OthersCommentValue = TaskTypeDT.get("OthersComment");
//
//     Thread.sleep(2000);
////ctrl+alt+l
////android.widget.Button[@resource-id='panel1a-header' and @text='Dabur Lemon Glucoplus-C Jar(400g) Refill']
//     QXClient.get().gestures().waitAndClickElementisVisible(openTasks);
//     Thread.sleep(2000);
//
//     for (int i = 0; i < ListOfItems.size(); i++) {
//         itemsList.add(ListOfItems.get(i).getText());
//         System.out.println(ListOfItems.get(i).getText() + i);
//     }
//
////===================================================
//     for (String newItems : itemsList) {
//         //android.widget.Button[@resource-id='panel1a-header' and @text='Dabur Lemon Glucoplus-C Jar(400g) Refill']
//         MobileElement item1 = null;
//         try {
//             item1 = (MobileElement) QXClient.get().driver().findElement(By.xpath("//android.widget.Button[@resource-id='panel1a-header' and @text='" + newItems + "']"));
//             //other
//         } catch (Exception e1) {
//             // QXClient.get().gestures().scrollUpToMobileElement(item1,"1");
//             //  QXClient.get().gestures().swipeUp();
//             try {
//                 item1 = (MobileElement) QXClient.get().driver().findElement(By.xpath("//android.widget.Button[@resource-id='panel1a-header' and @text='" + newItems + "']"));
//             } catch (Exception e2) {//other
//                 //    QXClient.get().gestures().scrollToMobileElement(item1, "1");
//                 QXClient.get().gestures().scrollUpToMobileElement(item1,"1");//scroll down)
//                 Thread.sleep(1000);
//                 item1 = (MobileElement) QXClient.get().driver().findElement(By.xpath("//android.widget.Button[@resource-id='panel1a-header' and @text='" + newItems + "']"));
//
//                 //  QXClient.get().gestures().scrollTilltextVisible(newItems);
//             }
//         }
//         Thread.sleep(1000);
//
//         if (item1.getText().contains(OtherValue)) {
//             try {
//                 QXClient.get().gestures().waitAndClickElementisVisible(item1);
//             } catch (StaleElementReferenceException e) {
//                 completeAllTheTask1(dataTable);
//             }
//             Thread.sleep(4000);
//             try {
//                 completeBtn.click();
//             } catch (Exception e) {
//                 QXClient.get().gestures().scrollToMobileElement(completeBtn, "1");
//                 completeBtn.click();
//             }
//             try {
//                 //OthersCommentValue
//                 enterComment.click();
//                 enterComment.sendKeys(OthersCommentValue);
//             } catch (Exception e) {
//                 actions.sendKeys(OthersCommentValue).perform();
//             }
//             Thread.sleep(4000);
//             confirmBtn.click();
//             Thread.sleep(4000);
//         }
//
//
//         //=====================================================
//         //refill
//         else if (item1.getText().contains(RefillValue)) {
//             //    System.out.println(RefilledQuantityValue+"==============>RefilledQuantityValue");
//             try {
//                 QXClient.get().gestures().waitAndClickElementisVisible(item1);
//             } catch (Exception e) {
//                 completeAllTheTask1(dataTable);
//             }
//             Thread.sleep(4000);
//             try {
//                 completeBtn.click();
//             } catch (Exception e) {
//                 QXClient.get().gestures().scrollToMobileElement(completeBtn, "1");
//                 completeBtn.click();
//             }
//             Thread.sleep(1000);
//
//             actions.sendKeys(RefilledQuantityValue).build().perform();
//
//
//             //=========================================================
//             Thread.sleep(5000);
//
//             //      Thread.sleep(4000);
//             confirmBtn.click();
//             Thread.sleep(4000);
//         }
//
//
//         //===========================================================================
//         //board      crtl+alt+l
//         else if (item1.getText().contains(BoardValue)) {
//             try {
//                 QXClient.get().gestures().waitAndClickElementisVisible(item1);
//             } catch (Exception e) {
//                 completeAllTheTask1(dataTable);
//             }
//             Thread.sleep(4000);
//             try {
//                 completeBtn.click();
//             } catch (Exception e) {
//                 QXClient.get().gestures().scrollToMobileElement(completeBtn, "1");
//                 completeBtn.click();
//             }
//             Thread.sleep(4000);
//             //ctrl+alt+l
//             List<String> priceBoardAL = new LinkedList<>();
//
//             for (int i = 0; i < PriceBoardsEle.size(); i++) {
//                 priceBoardAL.add(PriceBoardsEle.get(i).getText());
//             }
//
//             for (String priceText : priceBoardAL) {
//                 System.out.println(priceText + "===================>priceText");
//                 System.out.println(FullPriceBoardValue + "===========>FullPriceBoardValue");
//                 if (priceText.equals(FullPriceBoardValue)) {
//                     checkbox1.click();
//                     Thread.sleep(2000);
//
//                 } else if (priceText.equals(HalfPriceBoardValue)) {
//                     checkbox2.click();
//                     Thread.sleep(2000);
//                 } else if (priceText.equals(MediumPriceBoardValue)) {
//                     checkbox3.click();
//                     Thread.sleep(2000);
//                 } else if (priceText.equals(smallPriceBoardValue)) {
//                     checkbox4.click();
//                     Thread.sleep(2000);
//                 }
//
//             }
//
//             Thread.sleep(4000);
//             confirmBtn.click();
//             Thread.sleep(4000);
//         }
//
//         if (k >= itemsList.size() - 1) {
//             System.out.println("items completed, iterate");
//             itemsList.clear();
//             try {
//                 if (norecordsfoundEle.isDisplayed()) {
//                     System.out.println("items are not available");
//                     break;
//                 }
//             }
//             catch (Exception e)
//             {
//                 System.out.println(e.getMessage());
//             }
//             completeAllTheTask1(dataTable);
//
//         }
//         k++;
//
//     }
// }

}
