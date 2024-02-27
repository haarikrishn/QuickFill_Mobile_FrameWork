package com.DmartLabs.bdd.pages;

import com.DmartLabs.commonutils.Gestures;
import com.DmartLabs.commonutils.QXClient;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class PickerBoxAndPalletType11Page {


    public PickerBoxAndPalletType11Page() {

        PageFactory.initElements(new AppiumFieldDecorator(QXClient.get().driver()), this);
    }


    //=========================================================================================
    @FindBy(id = "com.dmartlabs.pwp:id/txt_vpip_ean_label")
    private MobileElement ean;
    @FindBy(xpath = "//android.widget.ImageView[@resource-id='com.dmartlabs.pwp:id/iv_pl_info_alert']")
    private MobileElement pickListDetails;
    @FindBy(xpath = "//android.widget.TextView[@resource-id='com.dmartlabs.pwp:id/txt_fpsdid_store_code_name']")
    private MobileElement storeSiteId;
    @FindBy(xpath = "//android.widget.TextView[@resource-id='com.dmartlabs.pwp:id/txt_fpsdid_delivery_number']")
    private MobileElement PickerDeliveryNumber;
    @FindBy(xpath = "//android.widget.Button[@resource-id='com.dmartlabs.pwp:id/btn_fpsdid_ok']")
    private MobileElement pickListDetailsOK;


    @FindBy(xpath = "//android.widget.TextView[@resource-id='com.dmartlabs.pwp:id/txt_pl_no_shrink_wrap']")
    private MobileElement DispatchType;


    public void PickListDetailsBoxAndPalletType() throws InterruptedException {
        Thread.sleep(100);
        QXClient.get().gestures().waitAndClickElementisVisible(pickListDetails);
        QXClient.get().report().info("store site Id is" + "============>" + storeSiteId.getText());
        QXClient.get().report().info("delivery nUmber is" + "=============>" + PickerDeliveryNumber.getText());
        String NormalDLVNumber = PickerDeliveryNumber.getText();
        QXClient.setNormalDeliveryNumber(NormalDLVNumber);
        System.out.println(NormalDLVNumber + "=========NormalDLVNumber");
        System.out.println("store site Id is" + "============>" + storeSiteId.getText());
        System.out.println("delivery nUmber is" + "=============>" + PickerDeliveryNumber.getText());
        QXClient.get().gestures().clickOnElement(pickListDetailsOK);
        Thread.sleep(200);
        QXClient.get().gestures().isElementPresent(DispatchType);

        String NormalDispatchType = DispatchType.getText();
        QXClient.setDispatchType(NormalDispatchType);
        System.out.println("Dispatch type is" + NormalDispatchType);
    }

    @FindBy(xpath = "//android.widget.TextView[@resource-id='com.dmartlabs.pwp:id/txt_lip_product_name' and not(preceding-sibling::android.widget.ImageView[@resource-id='com.dmartlabs.pwp:id/iv_lip_block'])]")
    private List<MobileElement> WithoutBlockItems;


    @FindBy(xpath = "(//android.widget.ImageView[@resource-id='com.dmartlabs.pwp:id/iv_lip_block'])[1]")
    private MobileElement SingleBlock;
//=============================================================================
//Set<String> set = new HashSet<>();
//        set.add("Apple");
//    // Convert Set to List
//    List<String> list = new ArrayList<>(set);
//

    //=====================================================================
    // List<String> deliveryAllItemsPickerAl = new ArrayList<>();
    Set<String> deliveryAllItemsPickerAl = new LinkedHashSet<>();
    // List<String> deliveryAllItemsPickerAl=new ArrayList<>();

    boolean isScroll = true;
    int scrollCount = 0;

    // public List<String> getDeliveryAllItemsPicker() {
    //generic method
    //=======================================================================================

@FindBy(id="com.dmartlabs.pwp:id/btn_lip_weight_category")
private  MobileElement MeadiumEle;

    public Set<String> getDeliveryAllItemsPicker() throws InterruptedException {
      //  TimeUnit.SECONDS.sleep(20);
        Thread.sleep(500);
        int k = 0;
        int yAxis = MeadiumEle.getLocation().getY();
        int xAxis = MeadiumEle.getLocation().getX();
        for (MobileElement item : WithoutBlockItems) {
            deliveryAllItemsPickerAl.add(item.getText().trim());
            //    System.out.println(item.getText()+k++);
        }
        //    System.out.println(deliveryAllItemsPickerAl.size() + "=======>deliveryAllItemsPickerAl");
        if (isScroll) {
            scrollCount++;
          // QXClient.get().gestures().scrollDeliveryItemsUpwardsPicker(1);
            QXClient.get().gestures(). scrollVerticallyDevice(xAxis,yAxis,1);
            Thread.sleep(500);
            List<String> list = new ArrayList<>(deliveryAllItemsPickerAl);

            try {
                if (WithoutBlockItems.get(0).getText().equals(list.get(deliveryAllItemsPickerAl.size() - 1))) {

                    System.out.println(WithoutBlockItems.get(0).getText() + "=======>WithoutBlockItems.get(0).getText()");
                    System.out.println(list.get(deliveryAllItemsPickerAl.size() - 1) + "============>list.get(deliveryAllItemsPickerAl.size() - 1)");

                    deliveryAllItemsPickerAl.remove(deliveryAllItemsPickerAl.size() - 1);
                    //   System.out.println("after removing");
                    try {
                        SingleBlock.isDisplayed();
                        isScroll = false;
                    } catch (NoSuchElementException NSE) {
                        System.out.println(NSE + "===========>NSE catch block");
                        getDeliveryAllItemsPicker();
                    }
                    Thread.sleep(500);
                    getDeliveryAllItemsPicker();

                } else {
                    isScroll = false;
                }
            } catch (IndexOutOfBoundsException IOBE) {
                System.out.println(IOBE + "====================>IOBE");
                try {
                    SingleBlock.isDisplayed();
                    isScroll = false;
                } catch (NoSuchElementException nse1) {
                    System.out.println(nse1 + "===========>nse1");
                    getDeliveryAllItemsPicker();
                }

            }

        } else {

            isScroll = false;
        }
        Thread.sleep(500);
      //  QXClient.get().gestures().scrollDeliveryItemsDownwardPicker(1);
        QXClient.get().gestures(). scrollVerticallyDevice1(xAxis, yAxis,1);
        System.out.println("scroll downward ");
        Thread.sleep(500);
        //  int i=0;
        return deliveryAllItemsPickerAl;
    }

    //=====================================================================================================
    //single HU

    public void getDeliveryAllItemsPickerHUitemOfflineMode1() throws InterruptedException {
        Thread.sleep(500);
        int k = 0;
        int yAxis = MeadiumEle.getLocation().getY();
        int xAxis = MeadiumEle.getLocation().getX();
        for (MobileElement item : WithoutBlockItems) {
            deliveryAllItemsPickerAl.add(item.getText().trim());
            //  System.out.println(item.getText()+k++);
        }
        //  System.out.println(deliveryAllItemsPickerAl.size()+"=======>deliveryAllItemsPickerAl");
        if (deliveryAllItemsPickerAl.size() >= 1) {
            if (isScroll) {
                scrollCount++;
               // QXClient.get().gestures().scrollDeliveryItemsUpwardsPicker(1);
                QXClient.get().gestures(). scrollVerticallyDevice(xAxis,yAxis,1);
                Thread.sleep(1000);
                try {
                    if((SingleBlock.isDisplayed())||(!(SingleBlock.isDisplayed()))){
                        isScroll = false;
                    }
                }
                catch (NoSuchElementException e)
                {
                    isScroll=false;
                }
                catch (Exception  e) {
                    getDeliveryAllItemsPickerHUitem();
                }
                Thread.sleep(100);
                getDeliveryAllItemsPicker();

            } else {
                isScroll = false;
            }

            //QXClient.get().gestures().scrollDeliveryItemsDownwardPicker(1);
            QXClient.get().gestures(). scrollVerticallyDevice1(xAxis, yAxis,1);
            //  System.out.println("scroll downward ");
            Thread.sleep(200);
            //  int i=0;
            try {
                Thread.sleep(1000);
                if (closeHU.isDisplayed()) {
                    //VerifyDispatchTypeAndClosePalletOrHU();
                    VerifyDispatchTypeAndClosePalletOrHUInOfflineMode();

                }

            } catch (Exception e)
            {
                Thread.sleep(1000);
                //  ClickItemOneByoneBoxAndPalletType();
                //VerifyDispatchTypeAndClosePalletOrHU();
                ClickItemOneByoneBoxAndPalletTypeInOfflineMode();
                VerifyDispatchTypeAndClosePalletOrHUInOfflineMode();
            }

        }
        else {
            System.out.println("there is no delivery items are present ");
        }


    }




    //=================================================================================
    public void getDeliveryAllItemsPickerHUitemOfflineMode() throws InterruptedException {
        int k = 0;
        for (MobileElement item : WithoutBlockItems) {
            deliveryAllItemsPickerAl.add(item.getText().trim());
            //  System.out.println(item.getText()+k++);
        }
        //  System.out.println(deliveryAllItemsPickerAl.size()+"=======>deliveryAllItemsPickerAl");
        if (deliveryAllItemsPickerAl.size() >= 1) {
            if (isScroll) {
                scrollCount++;
                QXClient.get().gestures().scrollDeliveryItemsUpwardsPicker(1);
                Thread.sleep(1000);
                try {
                    if((SingleBlock.isDisplayed())||(!(SingleBlock.isDisplayed()))){
                        isScroll = false;
                    }
                }
                catch (NoSuchElementException e)
                {
                    isScroll=false;
                }
                catch (Exception  e) {
                    getDeliveryAllItemsPickerHUitem();
                }
                Thread.sleep(100);
                getDeliveryAllItemsPicker();

            } else {
                isScroll = false;
            }

            QXClient.get().gestures().scrollDeliveryItemsDownwardPicker(1);
            //  System.out.println("scroll downward ");
            Thread.sleep(200);
            //  int i=0;
            try {
                Thread.sleep(1000);
                if (closeHU.isDisplayed()) {
                    //VerifyDispatchTypeAndClosePalletOrHU();
                    VerifyDispatchTypeAndClosePalletOrHUInOfflineMode();

                }

            } catch (Exception e)
            {
                Thread.sleep(1000);
                //  ClickItemOneByoneBoxAndPalletType();
                //VerifyDispatchTypeAndClosePalletOrHU();
                ClickItemOneByoneBoxAndPalletTypeInOfflineMode();
                VerifyDispatchTypeAndClosePalletOrHUInOfflineMode();
            }

        }
        else {
            System.out.println("there is no delivery items are present ");
        }


    }


    //==============================================================================================
    //single HU

    public void getDeliveryAllItemsPickerHUitem1() throws InterruptedException {
        Thread.sleep(500);
        int k = 0;
        int yAxis = MeadiumEle.getLocation().getY();
        int xAxis = MeadiumEle.getLocation().getX();


        for (MobileElement item : WithoutBlockItems) {
            deliveryAllItemsPickerAl.add(item.getText().trim());
            //  System.out.println(item.getText()+k++);
        }
        //  System.out.println(deliveryAllItemsPickerAl.size()+"=======>deliveryAllItemsPickerAl");
        if (deliveryAllItemsPickerAl.size() >= 1) {
            if (isScroll) {
                scrollCount++;
              //  QXClient.get().gestures().scrollDeliveryItemsUpwardsPicker(1);
                QXClient.get().gestures(). scrollVerticallyDevice(xAxis,yAxis,1);
                Thread.sleep(500);
                try {
                    if((SingleBlock.isDisplayed())||(!(SingleBlock.isDisplayed()))){
                        isScroll = false;
                    }
                }
                catch (NoSuchElementException e)
                {
                    isScroll=false;
                }
                catch (Exception  e) {
                    getDeliveryAllItemsPickerHUitem();
                }
                Thread.sleep(100);
                getDeliveryAllItemsPicker();

            } else {
                isScroll = false;
            }
            Thread.sleep(500);
           // QXClient.get().gestures().scrollDeliveryItemsDownwardPicker(1);

            QXClient.get().gestures(). scrollVerticallyDevice1(xAxis, yAxis,1);
            //  System.out.println("scroll downward ");
            Thread.sleep(200);
            //  int i=0;
            try {
                Thread.sleep(1000);
                if (closeHU.isDisplayed()) {
                    VerifyDispatchTypeAndClosePalletOrHU();
                }

            } catch (Exception e)
            {
                Thread.sleep(1000);
                ClickItemOneByoneBoxAndPalletType();
                VerifyDispatchTypeAndClosePalletOrHU();
            }

        }
        else {
            System.out.println("there is no delivery items are present ");
        }


    }

    //===============================================================================================
    public void getDeliveryAllItemsPickerHUitem() throws InterruptedException {
        Thread.sleep(500);
        int k = 0;
        for (MobileElement item : WithoutBlockItems) {
            deliveryAllItemsPickerAl.add(item.getText().trim());
            //  System.out.println(item.getText()+k++);
        }
        //  System.out.println(deliveryAllItemsPickerAl.size()+"=======>deliveryAllItemsPickerAl");
        if (deliveryAllItemsPickerAl.size() >= 1) {
            if (isScroll) {
                scrollCount++;
                QXClient.get().gestures().scrollDeliveryItemsUpwardsPicker(1);
                Thread.sleep(500);
                try {
                    if((SingleBlock.isDisplayed())||(!(SingleBlock.isDisplayed()))){
                        isScroll = false;
                    }
                }
                catch (NoSuchElementException e)
                {
                    isScroll=false;
                }
                catch (Exception  e) {
                    getDeliveryAllItemsPickerHUitem();
                }
                Thread.sleep(100);
                getDeliveryAllItemsPicker();

            } else {
                isScroll = false;
            }
            Thread.sleep(500);
            QXClient.get().gestures().scrollDeliveryItemsDownwardPicker(1);
            //  System.out.println("scroll downward ");
            Thread.sleep(200);
            //  int i=0;
            try {
                Thread.sleep(1000);
                if (closeHU.isDisplayed()) {
                    VerifyDispatchTypeAndClosePalletOrHU();
                }

            } catch (Exception e)
            {
                Thread.sleep(1000);
                ClickItemOneByoneBoxAndPalletType();
                VerifyDispatchTypeAndClosePalletOrHU();
            }

        }
        else {
            System.out.println("there is no delivery items are present ");
        }


    }




    //==========================================================================================
    @FindBy(xpath = "//android.widget.Button[@resource-id='com.dmartlabs.pwp:id/btn_fbwd_verified']")
    private MobileElement Verified;
    //android.widget.Button[@resource-id="com.dmartlabs.pwp:id/btn_fbwd_verified"]
    @FindBy(xpath = "//android.widget.Button[@resource-id='com.dmartlabs.pwp:id/btn_ip_pick_complete']")
    private MobileElement CompletePick;

    @FindBy(xpath = "//android.widget.ImageButton[@resource-id='com.dmartlabs.pwp:id/ib_cq_forward']")
    private MobileElement plus;

    @FindBy(xpath = "//android.widget.Button[@resource-id='com.dmartlabs.pwp:id/btn_cq_confirm']")
    private MobileElement confirm;

    @FindBy(xpath = "//android.widget.Button[@resource-id='com.dmartlabs.pwp:id/btn_fpsed_yes']")
    ////android.widget.Button[@resource-id='com.dmartlabs.pwp:id/btn_fpsed_yes']
    private MobileElement INcorrectYes;

    @FindBy(xpath = "//android.widget.TextView[@resource-id='com.dmartlabs.pwp:id/txt_lip_product_name']")
    private List<MobileElement> ListOfItems;

    @FindBy(id = "com.dmartlabs.pwp:id/ib_fch_home")
    private MobileElement homeBtn;

    @FindBy(id = "com.dmartlabs.pwp:id/btn_vhu_close_hu")
    private MobileElement closeHU;

    @FindBy(xpath = "//android.widget.TextView[@resource-id='com.dmartlabs.pwp:id/txt_fpsed_dialog_title']")
    private MobileElement IncorrectBinMsg;

    @FindBy(xpath = "//android.widget.Button[@resource-id='com.dmartlabs.pwp:id/btn_fpsed_yes']")
    private MobileElement IncorrectBinYes;


    public void ClickItemOneByoneBoxAndPalletType() throws InterruptedException {

        int k = 0;
        for (String itms : deliveryAllItemsPickerAl) {
            System.out.println(itms + "=========>item" + k++);
        }
        System.out.println(deliveryAllItemsPickerAl.size()+"========>deliveryAllItemsPickerAlSize");
        for (String itemText : deliveryAllItemsPickerAl) {
            // QXClient.get().gestures().t
            //     QXClient.get().driver().findElement(By.xpath("//android.widget.TextView[@text='Grace Deep Impact Shower Gel 250m']"));
            Thread.sleep(2000);
            MobileElement ItemName = (MobileElement) QXClient.get().driver().findElement(By.xpath("//android.widget.TextView[@text='" + itemText + "']"));
            ////android.widget.TextView[@resource-id='com.dmartlabs.pwp:id/txt_lip_product_name' and @text='Grace Citrus Passi Shower Gel 250ml']/following-sibling::android.widget.TextView[@resource-id='com.dmartlabs.pwp:id/txt_lip_bin_no']
            MobileElement BinNo = (MobileElement) QXClient.get().driver().findElement(By.xpath("//android.widget.TextView[@resource-id='com.dmartlabs.pwp:id/txt_lip_product_name' and @text='" + itemText + "']/following-sibling::android.widget.TextView[@resource-id='com.dmartlabs.pwp:id/txt_lip_bin_no']"));
////android.widget.TextView[@resource-id='com.dmartlabs.pwp:id/txt_lip_product_name' and @text='Colgate Maxfresh Blue Gel Tp(300g)']/parent::android.view.ViewGroup[@resource-id='com.dmartlabs.pwp:id/cl_lip_parent']/descendant::android.widget.TextView[@resource-id='com.dmartlabs.pwp:id/txt_lip_hu_type_value']
            //       MobileElement Hutype = (MobileElement) QXClient.get().driver().findElement(By.xpath("//android.widget.TextView[@resource-id='com.dmartlabs.pwp:id/txt_lip_product_name' and @text='"+itemText+"']/parent::android.view.ViewGroup[@resource-id='com.dmartlabs.pwp:id/cl_lip_parent']/descendant::android.widget.TextView[@resource-id='com.dmartlabs.pwp:id/txt_lip_hu_type_value']"));
//android.widget.TextView[@resource-id='com.dmartlabs.pwp:id/txt_lip_product_name' and @text='Colgate Maxfresh Blue Gel Tp(300g)']/parent::android.view.ViewGroup[@resource-id='com.dmartlabs.pwp:id/cl_lip_parent']/descendant::android.widget.TextView[@resource-id='com.dmartlabs.pwp:id/txt_lip_boxes_value']
            MobileElement CaselotQuantity = (MobileElement) QXClient.get().driver().findElement(By.xpath("//android.widget.TextView[@resource-id='com.dmartlabs.pwp:id/txt_lip_product_name' and @text='" + itemText + "']/parent::android.view.ViewGroup[@resource-id='com.dmartlabs.pwp:id/cl_lip_parent']/descendant::android.widget.TextView[@resource-id='com.dmartlabs.pwp:id/txt_lip_boxes_value']"));

            int caseLotNum = Integer.parseInt(CaselotQuantity.getText().trim());

            QXClient.get().gestures().isElementPresent(ItemName);
            QXClient.get().report().info("Item name is present" + "====>" + ItemName.getText());
            Thread.sleep(100);
            QXClient.get().gestures().isElementPresent(BinNo);
            QXClient.get().report().info("BinNo is present" + "====>" + BinNo.getText());
            Thread.sleep(100);
            // QXClient.get().gestures().isElementPresent(Hutype);
            //QXClient.get().report().info("Hutype is present"+"====>"+Hutype.getText());
            Thread.sleep(100);
            QXClient.get().gestures().isElementPresent(CaselotQuantity);
            QXClient.get().report().info("CaselotQuantity is present" + "====>" + CaselotQuantity.getText());
            Thread.sleep(100);
            //   System.out.println(ItemName.getText()+"===============>"+"name of item");
            //  System.out.println("itemName"+"======>"+itemText+"binNumber"+"======>"+BinNo.getText()+"HU type"+"======>"+Hutype.getText()+"caseLotQuantity"+"======>"+CaselotQuantity.getText());
            //QXClient.get().report().info("itemName"+"======>"+itemText+"binNumber"+"======>"+BinNo.getText()+"HU type"+"======>"+Hutype.getText()+"caseLotQuantity"+"======>"+CaselotQuantity.getText());
            Thread.sleep(2000);

            QXClient.get().gestures().waitAndClickElementisVisible(ItemName);

            try {
                Thread.sleep(500);
                QXClient.get().gestures().clickOnElement(Verified);
            } catch (Exception e) {
                //     QXClient.get().gestures().isElementPresent(IncorrectBinMsg);
                //    QXClient.get().report().info(IncorrectBinMsg.getText());
                //    System.out.println(IncorrectBinMsg.getText());
                Thread.sleep(500);
                QXClient.get().gestures().waitAndClickElementisVisible(IncorrectBinYes);
                QXClient.get().gestures().waitAndClickElementisVisible(Verified);

            }
            QXClient.get().report().info("Clicking on item Name" + "===========>" + itemText);
            System.out.println("item successfully picked" + "==================>" + itemText);
            Thread.sleep(200);
            //  Thread.sleep(200);
            //   QXClient.get().gestures().waitAndClickElementisVisible(Verified);
            QXClient.get().report().info("after click on item verifying");
            Thread.sleep(2000);
            //android.widget.TextView[@resource-id='com.dmartlabs.pwp:id/txt_vpip_item_desc' and @text='Colgate Maxfresh Blue Gel Tp(300g)']/following-sibling::android.widget.TextView[@resource-id='com.dmartlabs.pwp:id/txt_vpip_ean_value']
            WebElement EanNumer = QXClient.get().driver().findElement(By.xpath("//android.widget.TextView[@resource-id='com.dmartlabs.pwp:id/txt_vpip_item_desc' and @text='" + itemText + "']/following-sibling::android.widget.TextView[@resource-id='com.dmartlabs.pwp:id/txt_vpip_ean_value']"));
            System.out.println(itemText + " " + "============>EanNumer" + EanNumer.getText());
            Thread.sleep(200);
            QXClient.get().gestures().isElementPresent(EanNumer);
            QXClient.get().report().info("Ean number valid" + "=======>" + EanNumer.getText());
            Thread.sleep(2000);
            QXClient.get().gestures().waitAndClickElementisVisible(CompletePick);
            QXClient.get().report().info("after verifying,complete picking");
            Thread.sleep(200);
            System.out.println("caselot size is============>" + caseLotNum);
            for (int j = 0; j < caseLotNum; j++) {
                QXClient.get().gestures().waitAndClickElementisVisible(plus);
                QXClient.get().report().info("adding case slot quantity");
            }
            Thread.sleep(200);
            QXClient.get().gestures().waitAndClickElementisVisible(confirm);
            QXClient.get().report().info("Finally click on confirm");
            Thread.sleep(1000);
       }
  }

    //==============================================================================================
    String ExpectedBoxTypeDispatch = "BOX DISPATCH";
    String ExpectedPalletTypeDispatch = "PALLET DISPATCH";

    public void VerifyDispatchTypeAndClosePalletOrHU() throws InterruptedException {


        String ActualDispatchType = QXClient.getDispatchType();
        System.out.println(ActualDispatchType + "======is ActualDispatchType");

        if (ActualDispatchType.equals(ExpectedBoxTypeDispatch)) {
            System.out.println(ExpectedBoxTypeDispatch + "==========+is ExpectedBoxTypeDispatch");
            Thread.sleep(2000);
            ClosePalletBoxType();
        } else if (ActualDispatchType.equals(ExpectedPalletTypeDispatch)) {
            System.out.println(ExpectedPalletTypeDispatch + "==========+is ExpectedPalletTypeDispatch");
            Thread.sleep(2000);
            CloseHUPalletType();
        } else {
            System.out.println("invalid dispatch type ");
        }
    }
    //===================================================================================================
    public void VerifyDispatchTypeAndClosePalletOrHUMultiUserOnline() throws InterruptedException {

        String ActualDispatchType = QXClient.getDispatchType();
        System.out.println(ActualDispatchType + "======is ActualDispatchType");

        if (ActualDispatchType.equals(ExpectedBoxTypeDispatch)) {
            System.out.println(ExpectedBoxTypeDispatch + "==========+is ExpectedBoxTypeDispatch");
            Thread.sleep(2000);
            //   ClosePalletBoxType();
            ClosePalletBoxTypeMultiUserOnline();

        } else if (ActualDispatchType.equals(ExpectedPalletTypeDispatch)) {
            System.out.println(ExpectedPalletTypeDispatch + "==========+is ExpectedPalletTypeDispatch");
            Thread.sleep(2000);

            //  CloseHUPalletType();
            CloseHUPalletTypeMultiUserOnline();


        } else {
            System.out.println("invalid dispatch type ");
        }
    }




//============================================================================================

    public void VerifyDispatchTypeAndClosePalletOrHUInOfflineMode() throws InterruptedException {


        String ActualDispatchType = QXClient.getDispatchType();
        System.out.println(ActualDispatchType + "======is ActualDispatchType");

        if (ActualDispatchType.equals(ExpectedBoxTypeDispatch)) {
            System.out.println(ExpectedBoxTypeDispatch + "==========+is ExpectedBoxTypeDispatch");
            Thread.sleep(2000);
            //   ClosePalletBoxType();
            ClosePalletBoxTypeInOfflineMode();
        } else if (ActualDispatchType.equals(ExpectedPalletTypeDispatch)) {
            System.out.println(ExpectedPalletTypeDispatch + "==========+is ExpectedPalletTypeDispatch");
            Thread.sleep(2000);
            // CloseHUPalletType();
            CloseHUPalletTypeInOfflineMode();
        } else {
            System.out.println("invalid dispatch type ");
        }
    }


    //=============================================================================
    @FindBy(id = "com.dmartlabs.pwp:id/txt_pl_view_hu")
    private MobileElement ViewPallet;
    //box type
    // =======
    @FindBy(id = "com.dmartlabs.pwp:id/btn_vhu_close_hu")
    private MobileElement palletFull;


    @FindBy(xpath = "//android.widget.Button[@text='YES']")
    private MobileElement palletfullYes;
    @FindBy(id = "com.dmartlabs.pwp:id/txt_hm_title")
    private MobileElement moveToDispatchTitle;

    @FindBy(id = "com.dmartlabs.pwp:id/txt_hm_dock_name")
    private MobileElement dockName;
    @FindBy(id = "com.dmartlabs.pwp:id/btn_hm_continue_picking")
    private MobileElement continuePickBox;

    public void ClosePalletBoxType() throws InterruptedException {

        //view pallet
        //   QXClient.get().gestures().waitAndClickElementisVisible(ViewPallet);

//close pallet full
        Thread.sleep(2000);
        QXClient.get().gestures().isElementPresent(palletFull);
        QXClient.get().report().info("palletFull page is displayed");
        Thread.sleep(5000);
        QXClient.get().gestures().waitAndClickElementisVisible(palletFull);
        Thread.sleep(2000);
        QXClient.get().gestures().waitAndClickElementisVisible(palletfullYes);
        Thread.sleep(2000);
        try {
            QXClient.get().gestures().isElementPresent(moveToDispatchTitle);
            QXClient.get().report().info(dockName.getText());
        } catch (Exception e) {
            System.out.println("inside catch");
            QXClient.get().gestures().waitAndClickElementisVisible(palletFull);
            Thread.sleep(500);
            QXClient.get().gestures().waitAndClickElementisVisible(palletfullYes);
            Thread.sleep(100);
            QXClient.get().gestures().isElementPresent(moveToDispatchTitle);
            QXClient.get().report().info(dockName.getText());
        }
        System.out.println(dockName.getText() + "=========>" + dockName);
        Thread.sleep(2000);
        QXClient.get().gestures().waitAndClickElementisVisible(continuePickBox);
        Thread.sleep(2000);

    }
    //==============================================================================================

    @FindBy(id="com.dmartlabs.pwp:id/snackbar_text")
    public  MobileElement oops;

    @FindBy(id="com.dmartlabs.pwp:id/iv_lip_remote_sync")
    public  MobileElement RemoteSync;

    @FindBy(xpath = "//android.widget.TextView[@resource-id='com.dmartlabs.pwp:id/txt_fibe_title']")
    private  MobileElement applicationErrorTitle;

    @FindBy(xpath = "//android.widget.TextView[@resource-id='com.dmartlabs.pwp:id/txt_fibe_description']")
    private  MobileElement ErrorCode;

    @FindBy(id="com.dmartlabs.pwp:id/btn_fibe_ok")
    private  MobileElement errrorOK;



    public void ClosePalletBoxTypeMultiUserOnline() throws InterruptedException {

        //view pallet
        //   QXClient.get().gestures().waitAndClickElementisVisible(ViewPallet);

//close pallet full
        Thread.sleep(100);
        QXClient.get().gestures().isElementPresent(palletFull);
        QXClient.get().report().info("palletFull page is displayed");
        Thread.sleep(2000);
        QXClient.get().gestures().waitAndClickElementisVisible(palletFull);
        Thread.sleep(2000);
        QXClient.get().gestures().waitAndClickElementisVisible(palletfullYes);
        Thread.sleep(2000);

        Thread.sleep(100);
        QXClient.get().gestures().isElementPresent(oops);
        System.out.println(oops.getText()+"===========>Error Message");
        QXClient.get().gestures().waitAndClickElementisVisible(RemoteSync);
        Thread.sleep(100);
        QXClient.get().gestures().isElementPresent(applicationErrorTitle);
        Thread.sleep(100);
        QXClient.get().gestures().getText(applicationErrorTitle);
        System.out.println("Error message is===========>"+applicationErrorTitle.getText()+" "+applicationErrorTitle.getText());
        Thread.sleep(100);
        QXClient.get().gestures().waitAndClickElementisVisible(errrorOK);

//        try {
//            QXClient.get().gestures().isElementPresent(moveToDispatchTitle);
//            QXClient.get().report().info(dockName.getText());
//        } catch (Exception e) {
//            System.out.println("inside catch");
//            QXClient.get().gestures().waitAndClickElementisVisible(palletFull);
//            Thread.sleep(100);
//            QXClient.get().gestures().waitAndClickElementisVisible(palletfullYes);
//            Thread.sleep(100);
//            QXClient.get().gestures().isElementPresent(moveToDispatchTitle);
//            QXClient.get().report().info(dockName.getText());
//        }
//        System.out.println(dockName.getText() + "=========>" + dockName);
//        QXClient.get().gestures().waitAndClickElementisVisible(continuePickBox);

    }

//===================================================

    public void ClosePalletBoxTypeInOfflineMode() throws InterruptedException {

//close pallet full
        Thread.sleep(500);
        QXClient.get().gestures().isElementPresent(palletFull);
        QXClient.get().report().info("palletFull page is displayed");
        Thread.sleep(5000);
        QXClient.get().gestures().waitAndClickElementisVisible(palletFull);
        Thread.sleep(2000);
        QXClient.get().gestures().waitAndClickElementisVisible(palletfullYes);
        Thread.sleep(2000);

        System.out.println(noNetworktitle.getText());
        QXClient.get().report().info(noNetworktitle.getText());
        QXClient.get().gestures().isElementPresent(noNetworktitle);
        Thread.sleep(5000);

        QXClient.get().gestures().toggleWiFi();
        System.out.println("=======================>" + "wifi is turn on");
        QXClient.get().report().info("=======================>" + "wifi is turn on");
        Thread.sleep(200);
        QXClient.get().gestures().waitAndClickElementisVisible(NoNetworkOk);

        Thread.sleep(5000);

        QXClient.get().gestures().isElementPresent(palletFull);
        QXClient.get().report().info("palletFull page is displayed");
        Thread.sleep(5000);
        QXClient.get().gestures().waitAndClickElementisVisible(palletFull);
        Thread.sleep(5000);
        QXClient.get().gestures().waitAndClickElementisVisible(palletfullYes);
        Thread.sleep(4000);
        try {
            QXClient.get().gestures().isElementPresent(moveToDispatchTitle);
            QXClient.get().report().info(dockName.getText());
        } catch (Exception e) {
            System.out.println("inside catch");
            QXClient.get().gestures().waitAndClickElementisVisible(palletFull);
            Thread.sleep(100);
            QXClient.get().gestures().waitAndClickElementisVisible(palletfullYes);
            Thread.sleep(2000);
            QXClient.get().gestures().isElementPresent(moveToDispatchTitle);
            QXClient.get().report().info(dockName.getText());
        }


        System.out.println(dockName.getText() + "=========>" + dockName);
        QXClient.get().gestures().waitAndClickElementisVisible(continuePickBox);

    }


    //================================================================================================
    @FindBy(xpath = "//android.widget.TextView[@resource-id='com.dmartlabs.pwp:id/txt_pl_view_hu']")
    private MobileElement ClickOnViewHU;

    @FindBy(xpath = "//android.widget.Button[@resource-id='android:id/button1']")
    private MobileElement CloseHuYes;
    @FindBy(id = "com.dmartlabs.pwp:id/txt_phu_proceed_without_printer")
    private MobileElement withoutPrinter;
    @FindBy(id = "com.dmartlabs.pwp:id/txt_shu_proceed_without_scan")
    private MobileElement withoutScan;
    @FindBy(xpath = "//android.widget.Button[@resource-id='com.dmartlabs.pwp:id/btn_fhwd_verified']")
    private MobileElement HuVerified;
    @FindBy(id = "com.dmartlabs.pwp:id/btn_hm_continue_picking")
    private WebElement ContinuePicking;

    @FindBy(xpath = "//android.widget.TextView[@resource-id='com.dmartlabs.pwp:id/txt_vhu_title']")
    private MobileElement HUTitle;
    @FindBy(xpath = "//android.widget.TextView[@resource-id='com.dmartlabs.pwp:id/txt_vhu_tasks_progress_status']")
    private MobileElement NumberOfItems;

    @FindBy(xpath = "//android.widget.TextView[@resource-id='com.dmartlabs.pwp:id/txt_phu_print_hu_title']")
    private MobileElement PrintHuLabelTitle;

    @FindBy(xpath = "//android.widget.TextView[@resource-id='com.dmartlabs.pwp:id/txt_phu_dock_number']")
    private MobileElement DockType;
    @FindBy(xpath = "//android.widget.TextView[@text='Paste and scan the HU label']")
    private MobileElement ScanHulabeltitle;

    @FindBy(xpath = "//android.widget.TextView[@resource-id='com.dmartlabs.pwp:id/txt_hm_title']")
    private MobileElement MoveToDispatchTitle;

    @FindBy(xpath = "//android.widget.TextView[@resource-id='com.dmartlabs.pwp:id/txt_pl_title']")
    private MobileElement pickListTitle;
    @FindBy(xpath = "//android.widget.Button[@resource-id='com.dmartlabs.pwp:id/btn_vhu_close_hu']")
    private MobileElement CloseHU;
    //=================================================================================================
    @FindBy(xpath = "//android.widget.Button[@resource-id='com.dmartlabs.pwp:id/btn_vhu_close_hu']")
    private MobileElement closeHUxpath;

    @FindBy(xpath = "//android.widget.TextView[@text='Print HU label']")
    private MobileElement printHulabelText;


    public void CloseHUPalletType() throws InterruptedException {

        QXClient.get().report().info("HU Titlle is displayed");
        QXClient.get().gestures().isElementPresent(NumberOfItems);
        Thread.sleep(100);
        Thread.sleep(2000);
        QXClient.get().gestures().isElementPresent(CloseHU);
        QXClient.get().report().info("CloseHu button is displayyed");

        QXClient.get().report().info(NumberOfItems.getText() + " " + "no.of items present");
        System.out.println(NumberOfItems.getText() + " " + "no.of items present");
        Thread.sleep(5000);
        QXClient.get().gestures().waitAndClickElementisVisible(closeHU);
        QXClient.get().report().info("After all items picking clicking on close Hu");
        //closeHUText.click();
        Thread.sleep(200);
        QXClient.get().gestures().waitAndClickElementisVisible(CloseHuYes);
        QXClient.get().report().info("successfully clicked on close hu yes");
        Thread.sleep(2000);
        try {
            Thread.sleep(2000);
            QXClient.get().gestures().isElementPresent(printHulabelText);

            Thread.sleep(1000);
            QXClient.get().gestures().waitAndClickElementisVisible(withoutPrinter);
        } catch (Exception e) {
            System.out.println("inside catch");
            QXClient.get().gestures().waitAndClickElementisVisible(closeHUxpath);
            QXClient.get().report().info("After all items picking clicking on close Hu");
            //closeHUText.click();
            Thread.sleep(1000);
            QXClient.get().gestures().waitAndClickElementisVisible(CloseHuYes);
            QXClient.get().gestures().isElementPresent(printHulabelText);
            QXClient.get().gestures().waitAndClickElementisVisible(withoutPrinter);
        }

//scan hu label titlee
        Thread.sleep(500);
        QXClient.get().gestures().isElementPresent(ScanHulabeltitle);
        QXClient.get().report().info(" scan HU label is present");

        Thread.sleep(100);
        QXClient.get().gestures().waitAndClickElementisVisible(withoutScan);
        QXClient.get().report().info("successfully clicked on without scan");
        Thread.sleep(200);
        QXClient.get().gestures().waitAndClickElementisVisible(HuVerified);
        QXClient.get().report().info("successsfully clicked on HU verified");
        Thread.sleep(200);

        QXClient.get().gestures().isElementPresent(MoveToDispatchTitle);
        QXClient.get().report().info("Move to dispatch Title is present");
        Thread.sleep(2000);
        QXClient.get().gestures().waitAndClickElementisVisible(ContinuePicking);
        QXClient.get().report().info("Successfully cliked on continue picking");
        Thread.sleep(2000);

    }



    public void CloseHUPalletTypeMultiUserOnline() throws InterruptedException {

        QXClient.get().report().info("HU Titlle is displayed");
        QXClient.get().gestures().isElementPresent(NumberOfItems);
        Thread.sleep(100);

        QXClient.get().gestures().isElementPresent(CloseHU);
        QXClient.get().report().info("CloseHu button is displayyed");

        QXClient.get().report().info(NumberOfItems.getText() + " " + "no.of items present");
        System.out.println(NumberOfItems.getText() + " " + "no.of items present");
        Thread.sleep(2000);
        QXClient.get().gestures().waitAndClickElementisVisible(closeHU);
        QXClient.get().report().info("After all items picking clicking on close Hu");
        //closeHUText.click();
        Thread.sleep(200);
        QXClient.get().gestures().waitAndClickElementisVisible(CloseHuYes);
        QXClient.get().report().info("successfully clicked on close hu yes");
        Thread.sleep(2000);

        Thread.sleep(500);
        QXClient.get().gestures().isElementPresent(oops);
        System.out.println(oops.getText()+"===========>Error Message");
        QXClient.get().gestures().waitAndClickElementisVisible(RemoteSync);
        Thread.sleep(500);
        QXClient.get().gestures().isElementPresent(applicationErrorTitle);
        Thread.sleep(500);
        QXClient.get().gestures().getText(applicationErrorTitle);
        System.out.println("Error message is===========>"+applicationErrorTitle.getText()+" "+applicationErrorTitle.getText());
        Thread.sleep(500);
        QXClient.get().gestures().waitAndClickElementisVisible(errrorOK);

//        try {
//            QXClient.get().gestures().isElementPresent(printHulabelText);
//            QXClient.get().gestures().waitAndClickElementisVisible(withoutPrinter);
//        } catch (Exception e) {
//            System.out.println("inside catch");
//            QXClient.get().gestures().waitAndClickElementisVisible(closeHUxpath);
//            QXClient.get().report().info("After all items picking clicking on close Hu");
//            //closeHUText.click();
//            Thread.sleep(1000);
//            QXClient.get().gestures().waitAndClickElementisVisible(CloseHuYes);
//            QXClient.get().gestures().isElementPresent(printHulabelText);
//            QXClient.get().gestures().waitAndClickElementisVisible(withoutPrinter);
//        }
    }

//====================================================================================

    public void CloseHUPalletTypeInOfflineMode() throws InterruptedException {

        QXClient.get().report().info("HU Titlle is displayed");
        QXClient.get().gestures().isElementPresent(NumberOfItems);
        Thread.sleep(100);
        Thread.sleep(500);
        QXClient.get().gestures().isElementPresent(CloseHU);
        QXClient.get().report().info("CloseHu button is displayyed");

        QXClient.get().report().info(NumberOfItems.getText() + " " + "no.of items present");
        System.out.println(NumberOfItems.getText() + " " + "no.of items present");
        Thread.sleep(5000);

        QXClient.get().gestures().waitAndClickElementisVisible(closeHU);
        QXClient.get().report().info("After all items picking clicking on close Hu");
        //closeHUText.click();
        Thread.sleep(200);
        QXClient.get().gestures().waitAndClickElementisVisible(CloseHuYes);
        QXClient.get().report().info("successfully clicked on close hu yes");

        System.out.println(noNetworktitle.getText());
        QXClient.get().report().info(noNetworktitle.getText());
        QXClient.get().gestures().isElementPresent(noNetworktitle);
        Thread.sleep(5000);

//        QXClient.get().gestures().toggleWiFi();
        Gestures.turnOnWiFi();
        System.out.println("=======================>"+"wifi is turn on");
        QXClient.get().report().info("=======================>"+"wifi is turn on");
        Thread.sleep(5000);
        QXClient.get().gestures().waitAndClickElementisVisible(NoNetworkOk);
        //   Thread.sleep(200);
        Thread.sleep(5000);

        QXClient.get().gestures().waitAndClickElementisVisible(closeHU);
        QXClient.get().report().info("After all items picking clicking on close Hu");
        //closeHUText.click();
        Thread.sleep(200);
        QXClient.get().gestures().waitAndClickElementisVisible(CloseHuYes);
        QXClient.get().report().info("successfully clicked on close hu yes");
        Thread.sleep(4000);

        try {
            QXClient.get().gestures().isElementPresent(printHulabelText);
            QXClient.get().gestures().waitAndClickElementisVisible(withoutPrinter);
        } catch (Exception e) {
            System.out.println("inside catch");
            try {
                QXClient.get().gestures().waitAndClickElementisVisible(closeHUxpath);
            } catch (Exception f) {
                QXClient.get().gestures().waitAndClickElementisVisible(NoNetworkOk);
            }
        }
//            QXClient.get().report().info("After all items picking clicking on close Hu");
//            //closeHUText.click();
//        QXClient.get().gestures().waitAndClickElementisVisible(closeHUxpath);
//            Thread.sleep(1000);
//            QXClient.get().gestures().waitAndClickElementisVisible(CloseHuYes);
//            Thread.sleep(2000);
//            QXClient.get().gestures().isElementPresent(printHulabelText);
//            QXClient.get().gestures().waitAndClickElementisVisible(withoutPrinter);


//scan hu label titlee
        Thread.sleep(100);
        QXClient.get().gestures().isElementPresent(ScanHulabeltitle);
        QXClient.get().report().info(" scan HU label is present");


        QXClient.get().gestures().waitAndClickElementisVisible(withoutScan);
        QXClient.get().report().info("successfully clicked on without scan");
        Thread.sleep(200);
        QXClient.get().gestures().waitAndClickElementisVisible(HuVerified);
        QXClient.get().report().info("successsfully clicked on HU verified");
        Thread.sleep(200);

        QXClient.get().gestures().isElementPresent(MoveToDispatchTitle);
        QXClient.get().report().info("Move to dispatch Title is present");

        QXClient.get().gestures().waitAndClickElementisVisible(ContinuePicking);
        QXClient.get().report().info("Successfully cliked on continue picking");
    }

    public  void EmptyListDisplayed() throws InterruptedException {
        Thread.sleep(200);
        QXClient.get().gestures().isElementPresent(pickListTitle);
        QXClient.get().report().info("PickList Tilte is displayed");
        homeBtn.click();
    }

//========================================================================================
    //offline


    @FindBy(xpath = "//android.widget.ImageView[@resource-id='com.dmartlabs.pwp:id/iv_lip_remote_sync']")
    private  MobileElement sync;

    @FindBy(xpath = "//android.widget.ImageView[@resource-id='com.dmartlabs.pwp:id/iv_fch_wifi_off_signal']")
    private  MobileElement wifiSignalOff;

    @FindBy(id="com.dmartlabs.pwp:id/txt_fasd_title")
    private  MobileElement noNetworktitle;
    @FindBy(id="com.dmartlabs.pwp:id/btn_fasd_ok")
    private  MobileElement NoNetworkOk;


    public  void ClickItemOneByoneBoxAndPalletTypeInOfflineMode() throws InterruptedException {

        QXClient.get().gestures().toggleWiFi();

        Thread.sleep(500);

        int k=0;
        for(String   itms:deliveryAllItemsPickerAl)
        {
            System.out.println(itms+"=========>item"+k++);
        }
//        System.out.println(deliveryAllItemsPickerAl.size()+"========>deliveryAllItemsPickerAlSize");
        for(String    itemText:deliveryAllItemsPickerAl)
        {
            QXClient.get().gestures().waitForElementToVisible(wifiSignalOff);
            QXClient.get().gestures().isElementPresent(wifiSignalOff);
            System.out.println("======================>"+"wifi is off");
            QXClient.get().report().info("======================>"+"wifi is off");
            QXClient.get().report().info(wifiSignalOff.getText());

            // QXClient.get().gestures().t
            //     QXClient.get().driver().findElement(By.xpath("//android.widget.TextView[@text='Grace Deep Impact Shower Gel 250m']"));
            Thread.sleep(500);
            MobileElement ItemName = (MobileElement) QXClient.get().driver().findElement(By.xpath("//android.widget.TextView[@text='"+itemText+"']"));
            ////android.widget.TextView[@resource-id='com.dmartlabs.pwp:id/txt_lip_product_name' and @text='Grace Citrus Passi Shower Gel 250ml']/following-sibling::android.widget.TextView[@resource-id='com.dmartlabs.pwp:id/txt_lip_bin_no']
            MobileElement BinNo = (MobileElement) QXClient.get().driver().findElement(By.xpath("//android.widget.TextView[@resource-id='com.dmartlabs.pwp:id/txt_lip_product_name' and @text='"+itemText+"']/following-sibling::android.widget.TextView[@resource-id='com.dmartlabs.pwp:id/txt_lip_bin_no']"));
////android.widget.TextView[@resource-id='com.dmartlabs.pwp:id/txt_lip_product_name' and @text='Colgate Maxfresh Blue Gel Tp(300g)']/parent::android.view.ViewGroup[@resource-id='com.dmartlabs.pwp:id/cl_lip_parent']/descendant::android.widget.TextView[@resource-id='com.dmartlabs.pwp:id/txt_lip_hu_type_value']
            //       MobileElement Hutype = (MobileElement) QXClient.get().driver().findElement(By.xpath("//android.widget.TextView[@resource-id='com.dmartlabs.pwp:id/txt_lip_product_name' and @text='"+itemText+"']/parent::android.view.ViewGroup[@resource-id='com.dmartlabs.pwp:id/cl_lip_parent']/descendant::android.widget.TextView[@resource-id='com.dmartlabs.pwp:id/txt_lip_hu_type_value']"));
//android.widget.TextView[@resource-id='com.dmartlabs.pwp:id/txt_lip_product_name' and @text='Colgate Maxfresh Blue Gel Tp(300g)']/parent::android.view.ViewGroup[@resource-id='com.dmartlabs.pwp:id/cl_lip_parent']/descendant::android.widget.TextView[@resource-id='com.dmartlabs.pwp:id/txt_lip_boxes_value']
            MobileElement CaselotQuantity = (MobileElement) QXClient.get().driver().findElement(By.xpath("//android.widget.TextView[@resource-id='com.dmartlabs.pwp:id/txt_lip_product_name' and @text='" + itemText + "']/parent::android.view.ViewGroup[@resource-id='com.dmartlabs.pwp:id/cl_lip_parent']/descendant::android.widget.TextView[@resource-id='com.dmartlabs.pwp:id/txt_lip_boxes_value']"));

            int caseLotNum = Integer.parseInt(CaselotQuantity.getText().trim());

            QXClient.get().gestures().isElementPresent(ItemName);
            QXClient.get().report().info("Item name is present"+"====>"+ItemName.getText());
            Thread.sleep(100);
            QXClient.get().gestures().isElementPresent(BinNo);
            QXClient.get().report().info("BinNo is present"+"====>"+BinNo.getText());
            Thread.sleep(100);
            // QXClient.get().gestures().isElementPresent(Hutype);
            //QXClient.get().report().info("Hutype is present"+"====>"+Hutype.getText());
            Thread.sleep(100);
            QXClient.get().gestures().isElementPresent(CaselotQuantity);
            QXClient.get().report().info("CaselotQuantity is present"+"====>"+CaselotQuantity.getText());
            Thread.sleep(100);
            //   System.out.println(ItemName.getText()+"===============>"+"name of item");
            //  System.out.println("itemName"+"======>"+itemText+"binNumber"+"======>"+BinNo.getText()+"HU type"+"======>"+Hutype.getText()+"caseLotQuantity"+"======>"+CaselotQuantity.getText());
            //QXClient.get().report().info("itemName"+"======>"+itemText+"binNumber"+"======>"+BinNo.getText()+"HU type"+"======>"+Hutype.getText()+"caseLotQuantity"+"======>"+CaselotQuantity.getText());
            Thread.sleep(2000);
            QXClient.get().gestures().waitAndClickElementisVisible(ItemName);

            try {
                QXClient.get().gestures().clickOnElement(Verified);
            }
            catch (Exception e) {
                //     QXClient.get().gestures().isElementPresent(IncorrectBinMsg);
                //    QXClient.get().report().info(IncorrectBinMsg.getText());
                //    System.out.println(IncorrectBinMsg.getText());
                QXClient.get().gestures().waitAndClickElementisVisible(IncorrectBinYes);
                QXClient.get().gestures().waitAndClickElementisVisible(Verified);

            }
            QXClient.get().report().info("Clicking on item Name"+"===========>"+itemText);
            System.out.println("item successfully picked"+"==================>"+itemText);
            Thread.sleep(200);
            //  Thread.sleep(200);
            //   QXClient.get().gestures().waitAndClickElementisVisible(Verified);
            QXClient.get().report().info("after click on item verifying");
            Thread.sleep(2000);
            //android.widget.TextView[@resource-id='com.dmartlabs.pwp:id/txt_vpip_item_desc' and @text='Colgate Maxfresh Blue Gel Tp(300g)']/following-sibling::android.widget.TextView[@resource-id='com.dmartlabs.pwp:id/txt_vpip_ean_value']
            WebElement EanNumer = QXClient.get().driver().findElement(By.xpath("//android.widget.TextView[@resource-id='com.dmartlabs.pwp:id/txt_vpip_item_desc' and @text='"+itemText+"']/following-sibling::android.widget.TextView[@resource-id='com.dmartlabs.pwp:id/txt_vpip_ean_value']"));
            System.out.println(itemText+" "+"============>EanNumer"+EanNumer.getText());
            Thread.sleep(200);
            QXClient.get().gestures().isElementPresent(EanNumer);
            QXClient.get().report().info("Ean number valid"+"=======>"+EanNumer.getText());
            QXClient.get().gestures().waitAndClickElementisVisible(CompletePick);
            QXClient.get().report().info("after verifying,complete picking");
            Thread.sleep(200);
            System.out.println("caselot size is============>"+caseLotNum);
            for (int j = 0; j < caseLotNum; j++) {
                QXClient.get().gestures().waitAndClickElementisVisible(plus);
                QXClient.get().report().info("adding case slot quantity");
            }
            Thread.sleep(200);
            QXClient.get().gestures().waitAndClickElementisVisible(confirm);
            QXClient.get().report().info("Finally click on confirm");
            Thread.sleep(1000);
        }
        QXClient.get().gestures().waitForElementToVisible(sync);
        QXClient.get().gestures().isElementPresent(sync);
        System.out.println("==============>"+"item is try to sync");
        QXClient.get().report().info("==============>"+"item is try to sync");
    }



}







