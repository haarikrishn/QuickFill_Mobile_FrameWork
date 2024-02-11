package com.DmartLabs.bdd.pages;

import com.DmartLabs.commonutils.QXClient;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class picker1TwoHUsOfflinepage {


    public picker1TwoHUsOfflinepage() {

        PageFactory.initElements(new AppiumFieldDecorator(QXClient.get().driver()), this);
    }

    //select picker
    @FindBy(xpath = "//android.widget.TextView[@text='Picker']")
    private MobileElement SelectPicker;

    public void ClickOnPicker() {
        QXClient.get().gestures().clickOnElement(SelectPicker);
        QXClient.get().report().info("click on picker");
    }

    @FindBy(xpath = "//android.widget.TextView[@resource-id='com.dmartlabs.pwp:id/txt_fch_title']")
    private  MobileElement PickerTitle;

    public  void isPickerPageDisplayed()
    {
        QXClient.get().gestures().isElementPresent(PickerTitle);
        QXClient.get().report().info("picker title is displayed");
        System.out.println("picker title is successfully validated");
    }
    //======================================================================
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

    //===============================================================
    @FindBy(xpath = "//android.widget.TextView[@resource-id='com.dmartlabs.pwp:id/txt_lip_product_name']")
    private List<MobileElement> ListOfItemsFirstHU;

    //===========================================================================
//    Pampers Aloe Baby Wips(72n)0
//    Boroplus Alov Hal Ch Kes Gel(150ml)1
//    Colgate Maxfresh Blue Gel Tp(300g)2
//    Oral B Kids 2+ Year Toothbrush(3n)3
    //=================================================================================
    ArrayList<String> FirstHU = new ArrayList<>();
    public void addElementsToListFirstHUInOffline() {
        for (int i = 0; i < ListOfItemsFirstHU.size(); i++) {
            FirstHU.add(ListOfItemsFirstHU.get(i).getText());
            System.out.println(ListOfItemsFirstHU.get(i).getText() +"="+"item number"+ i);
        }
        QXClient.get().report().info("Adddign all items to ArrayList");
    }
    @FindBy(id="com.dmartlabs.pwp:id/txt_vpip_ean_label")
    private  MobileElement ean;
    @FindBy(xpath = "//android.widget.ImageView[@resource-id='com.dmartlabs.pwp:id/iv_pl_info_alert']")
    private  MobileElement pickListDetails;
    @FindBy(xpath = "//android.widget.TextView[@resource-id='com.dmartlabs.pwp:id/txt_fpsdid_store_code_name']")
    private  MobileElement storeSiteId;
    @FindBy(xpath = "//android.widget.TextView[@resource-id='com.dmartlabs.pwp:id/txt_fpsdid_delivery_number']")
    private  MobileElement PickerDeliveryNumber;
    @FindBy(xpath = "//android.widget.Button[@resource-id='com.dmartlabs.pwp:id/btn_fpsdid_ok']")
    private  MobileElement  pickListDetailsOK;
    @FindBy(xpath = "//android.widget.ImageView[@resource-id='com.dmartlabs.pwp:id/iv_fch_wifi_off_signal']")
    private  MobileElement wifiSignalOff;

    public  void PickListDetailsInOffline()
    {
        QXClient.get().gestures().waitAndClickElementisVisible(pickListDetails);
        QXClient.get().report().info("store site Id is"+"============>"+storeSiteId.getText());
        QXClient.get().report().info("delivery nUmber is"+"=============>"+PickerDeliveryNumber.getText());
        String TwoHUsDLVnumber = PickerDeliveryNumber.getText().replace("#", "");
        QXClient.setNormalDeliveryNumber(TwoHUsDLVnumber);
        System.out.println("store site Id is"+"============>"+storeSiteId.getText());
        System.out.println("delivery nUmber is"+"=============>"+PickerDeliveryNumber.getText());
        QXClient.get().gestures().clickOnElement(pickListDetailsOK);
        QXClient.get().gestures().isElementPresent(DispatchType);
        System.out.println("Dispatch type is"+DispatchType.getText());
    }
    @FindBy(xpath = "//android.widget.TextView[@resource-id='com.dmartlabs.pwp:id/txt_pl_no_shrink_wrap']")
    private  MobileElement DispatchType;
    public  void PickListDetailsInOfflinePalletTypeV2()
    {
        QXClient.get().gestures().waitAndClickElementisVisible(pickListDetails);
        QXClient.get().report().info("store site Id is"+"============>"+storeSiteId.getText());
        QXClient.get().report().info("delivery nUmber is"+"=============>"+PickerDeliveryNumber.getText());
        String TwoHUsDLVnumber = PickerDeliveryNumber.getText().replace("#", "");
        QXClient.setNormalDeliveryNumber(TwoHUsDLVnumber);
        System.out.println("store site Id is"+"============>"+storeSiteId.getText());
        System.out.println("delivery nUmber is"+"=============>"+PickerDeliveryNumber.getText());
        QXClient.get().gestures().clickOnElement(pickListDetailsOK);
        QXClient.get().gestures().isElementPresent(DispatchType);
        System.out.println("Dispatch type is"+DispatchType.getText());
    }


    //=====================================================================
    @FindBy(xpath = "//android.widget.ImageView[@resource-id='com.dmartlabs.pwp:id/iv_lip_remote_sync']")
    private  MobileElement sync;

    public  void ClickItemOneByoneInoffline() throws InterruptedException {

        QXClient.get().gestures().toggleWiFi();

        Thread.sleep(1000);
        for(String    itemTextFirstHu:FirstHU)
        {
            QXClient.get().gestures().waitForElementToVisible(wifiSignalOff);
            QXClient.get().gestures().isElementPresent(wifiSignalOff);
            System.out.println("======================>"+"wifi is off");
            QXClient.get().report().info("======================>"+"wifi is off");
            QXClient.get().report().info(wifiSignalOff.getText());

            //     QXClient.get().driver().findElement(By.xpath("//android.widget.TextView[@text='Grace Deep Impact Shower Gel 250m']"));
            MobileElement ItemName = (MobileElement) QXClient.get().driver().findElement(By.xpath("//android.widget.TextView[@text='"+itemTextFirstHu+"']"));
            ////android.widget.TextView[@resource-id='com.dmartlabs.pwp:id/txt_lip_product_name' and @text='Grace Citrus Passi Shower Gel 250ml']/following-sibling::android.widget.TextView[@resource-id='com.dmartlabs.pwp:id/txt_lip_bin_no']
            MobileElement BinNo = (MobileElement) QXClient.get().driver().findElement(By.xpath("//android.widget.TextView[@resource-id='com.dmartlabs.pwp:id/txt_lip_product_name' and @text='"+itemTextFirstHu+"']/following-sibling::android.widget.TextView[@resource-id='com.dmartlabs.pwp:id/txt_lip_bin_no']"));
////android.widget.TextView[@resource-id='com.dmartlabs.pwp:id/txt_lip_product_name' and @text='Colgate Maxfresh Blue Gel Tp(300g)']/parent::android.view.ViewGroup[@resource-id='com.dmartlabs.pwp:id/cl_lip_parent']/descendant::android.widget.TextView[@resource-id='com.dmartlabs.pwp:id/txt_lip_hu_type_value']
            MobileElement Hutype = (MobileElement) QXClient.get().driver().findElement(By.xpath("//android.widget.TextView[@resource-id='com.dmartlabs.pwp:id/txt_lip_product_name' and @text='"+itemTextFirstHu+"']/parent::android.view.ViewGroup[@resource-id='com.dmartlabs.pwp:id/cl_lip_parent']/descendant::android.widget.TextView[@resource-id='com.dmartlabs.pwp:id/txt_lip_hu_type_value']"));
//android.widget.TextView[@resource-id='com.dmartlabs.pwp:id/txt_lip_product_name' and @text='Colgate Maxfresh Blue Gel Tp(300g)']/parent::android.view.ViewGroup[@resource-id='com.dmartlabs.pwp:id/cl_lip_parent']/descendant::android.widget.TextView[@resource-id='com.dmartlabs.pwp:id/txt_lip_boxes_value']
            MobileElement CaselotQuantity = (MobileElement) QXClient.get().driver().findElement(By.xpath("//android.widget.TextView[@resource-id='com.dmartlabs.pwp:id/txt_lip_product_name' and @text='" + itemTextFirstHu + "']/parent::android.view.ViewGroup[@resource-id='com.dmartlabs.pwp:id/cl_lip_parent']/descendant::android.widget.TextView[@resource-id='com.dmartlabs.pwp:id/txt_lip_boxes_value']"));


            int caseLotNum = Integer.parseInt(CaselotQuantity.getText().trim());
            QXClient.get().gestures().isElementPresent(ItemName);
            QXClient.get().report().info("Item name is present"+"====>"+ItemName.getText());
            Thread.sleep(100);
            QXClient.get().gestures().isElementPresent(BinNo);
            QXClient.get().report().info("BinNo is present"+"====>"+BinNo.getText());
            Thread.sleep(100);
            QXClient.get().gestures().isElementPresent(Hutype);
            QXClient.get().report().info("Hutype is present"+"====>"+Hutype.getText());
            Thread.sleep(100);
            QXClient.get().gestures().isElementPresent(CaselotQuantity);
            QXClient.get().report().info("CaselotQuantity is present"+"====>"+CaselotQuantity.getText());
            Thread.sleep(100);
            //   System.out.println(ItemName.getText()+"===============>"+"name of item");
            System.out.println("itemName"+"======>"+itemTextFirstHu+"binNumber"+"======>"+BinNo.getText()+"HU type"+"======>"+Hutype.getText()+"caseLotQuantity"+"======>"+CaselotQuantity.getText());
            QXClient.get().report().info("itemName"+"======>"+itemTextFirstHu+"binNumber"+"======>"+BinNo.getText()+"HU type"+"======>"+Hutype.getText()+"caseLotQuantity"+"======>"+CaselotQuantity.getText());
            QXClient.get().gestures().waitAndClickElementisVisible(ItemName);
            QXClient.get().report().info("Clicking on item Name"+"===========>"+itemTextFirstHu);
            System.out.println("item successfully picked"+"==================>"+itemTextFirstHu);
            Thread.sleep(200);
            Thread.sleep(200);
            QXClient.get().gestures().waitAndClickElementisVisible(Verified);
            QXClient.get().report().info("after click on item verifying");
            Thread.sleep(200);
            //android.widget.TextView[@resource-id='com.dmartlabs.pwp:id/txt_vpip_item_desc' and @text='Colgate Maxfresh Blue Gel Tp(300g)']/following-sibling::android.widget.TextView[@resource-id='com.dmartlabs.pwp:id/txt_vpip_ean_value']
            WebElement EanNumer = QXClient.get().driver().findElement(By.xpath("//android.widget.TextView[@resource-id='com.dmartlabs.pwp:id/txt_vpip_item_desc' and @text='"+itemTextFirstHu+"']/following-sibling::android.widget.TextView[@resource-id='com.dmartlabs.pwp:id/txt_vpip_ean_value']"));
            System.out.println(itemTextFirstHu+" "+"============>EanNumer"+EanNumer.getText());
            Thread.sleep(200);
            QXClient.get().gestures().isElementPresent(EanNumer);
            QXClient.get().report().info("Ean number valid"+"=======>"+EanNumer.getText());
            QXClient.get().gestures().waitAndClickElementisVisible(CompletePick);
            QXClient.get().report().info("after verifying,complete picking");
            Thread.sleep(200);
            for (int j = 0; j < caseLotNum; j++) {
                QXClient.get().gestures().waitAndClickElementisVisible(plus);
                QXClient.get().report().info("adding case slot quantity");
            }
            Thread.sleep(200);
            QXClient.get().gestures().waitAndClickElementisVisible(confirm);
            QXClient.get().report().info("Finally click on confirm");
            Thread.sleep(500);

        }
        QXClient.get().gestures().waitForElementToVisible(sync);
        QXClient.get().gestures().isElementPresent(sync);
        System.out.println("==============>"+"item is try to sync");
        QXClient.get().report().info("==============>"+"item is try to sync");
    }
    //============================================================================
    //click on view HU
    @FindBy(xpath = "//android.widget.TextView[@resource-id='com.dmartlabs.pwp:id/txt_pl_view_hu']")
    private  MobileElement ClickOnViewHU;

    @FindBy(id="com.dmartlabs.pwp:id/btn_vhu_close_hu")
    private  MobileElement closeHU;
    @FindBy(xpath = "//android.widget.Button[@resource-id='android:id/button1']")
    private  MobileElement CloseHuYes;
    @FindBy (id = "com.dmartlabs.pwp:id/txt_phu_proceed_without_printer")
    private  MobileElement withoutPrinter;
    @FindBy(id="com.dmartlabs.pwp:id/txt_shu_proceed_without_scan")
    private  MobileElement withoutScan;
    @FindBy(xpath = "//android.widget.Button[@resource-id='com.dmartlabs.pwp:id/btn_fhwd_verified']")
    private  MobileElement HuVerified;
    @FindBy(id = "com.dmartlabs.pwp:id/btn_hm_continue_picking")
    private WebElement ContinuePicking;

    @FindBy(xpath = "//android.widget.Button[@resource-id='com.dmartlabs.pwp:id/btn_vhu_close_hu']")
    private  MobileElement CloseHU;

    @FindBy(xpath = "//android.widget.TextView[@resource-id='com.dmartlabs.pwp:id/txt_vhu_title']")
    private  MobileElement HUTitle;
    @FindBy(xpath = "//android.widget.TextView[@resource-id='com.dmartlabs.pwp:id/txt_vhu_tasks_progress_status']")
    private  MobileElement NumberOfItems;

    @FindBy (xpath = "//android.widget.TextView[@resource-id='com.dmartlabs.pwp:id/txt_phu_print_hu_title']")
    private  MobileElement PrintHuLabelTitle;

    @FindBy(xpath = "//android.widget.TextView[@resource-id='com.dmartlabs.pwp:id/txt_phu_dock_number']")
    private  MobileElement DockType;

    @FindBy(xpath = "//android.widget.TextView[@text='Paste and scan the HU label']")
    private  MobileElement ScanHulabeltitle;

    @FindBy (xpath = "//android.widget.TextView[@resource-id='com.dmartlabs.pwp:id/txt_hm_title']")
    private  MobileElement MoveToDispatchTitle;

    @FindBy(xpath = "//android.widget.TextView[@resource-id='com.dmartlabs.pwp:id/txt_pl_title']")
    private  MobileElement pickListTitle;
    //=======================================================
    public  void ClickONViewHU() throws InterruptedException {
        //  QXClient.get().gestures().ToggleWiFi();
        //   System.out.println("=======================>"+"wifi is turn on");
        Thread.sleep(2000);
        QXClient.get().gestures().waitAndClickElementisVisible(ClickOnViewHU);
        QXClient.get().report().info("HU is successfully displayed");
    }
    //==============================================================
    public  void HUpageIsDisplayed() throws InterruptedException {
        Thread.sleep(100);
        //  QXClient.get().gestures().isElementPresent(CloseHU);
        QXClient.get().report().info("CloseHu button is displayyed");
        //  QXClient.get().gestures().isElementPresent(HUTitle);
        Thread.sleep(100);
        QXClient.get().report().info("HU Titlle is displayed");
        QXClient.get().gestures().isElementPresent(NumberOfItems);
        Thread.sleep(100);
        QXClient.get().report().info(NumberOfItems.getText()+" "+"no.of items present");
        System.out.println(NumberOfItems.getText()+" "+"no.of items present");
    }

    @FindBy(id="com.dmartlabs.pwp:id/txt_fasd_title")
    private  MobileElement noNetworktitle;
    @FindBy(id="com.dmartlabs.pwp:id/btn_fasd_ok")
    private  MobileElement NoNetworkOk;

    public  void ClickOnCloseHUInOffline() throws InterruptedException {


        QXClient.get().gestures().waitAndClickElementisVisible(closeHU);
        QXClient.get().report().info("After all items picking clicking on close Hu");
        Thread.sleep(500);
        QXClient.get().gestures().waitAndClickElementisVisible(CloseHuYes);

        System.out.println(noNetworktitle.getText());
        QXClient.get().report().info(noNetworktitle.getText());
        QXClient.get().gestures().isElementPresent(noNetworktitle);
        Thread.sleep(200);
        QXClient.get().gestures().toggleWiFi();
        System.out.println("=======================>"+"wifi is turn on");
        QXClient.get().report().info("=======================>"+"wifi is turn on");
        QXClient.get().gestures().waitAndClickElementisVisible(NoNetworkOk);
        //   Thread.sleep(200);
        Thread.sleep(4000);
        QXClient.get().gestures().waitAndClickElementisVisible(closeHU);
        QXClient.get().report().info("After all items picking clicking on close Hu");
        Thread.sleep(500);
        QXClient.get().gestures().waitAndClickElementisVisible(CloseHuYes);
        try
        {
            QXClient.get().gestures().isElementPresent(PrintHuLabelTitle);
            QXClient.get().gestures().waitAndClickElementisVisible(withoutPrinter);
        }
        catch (Exception e)
        {
            System.out.println("inside catch block");
            QXClient.get().gestures().waitAndClickElementisVisible(closeHU);
            QXClient.get().gestures().waitAndClickElementisVisible(CloseHuYes);
            QXClient.get().gestures().isElementPresent(PrintHuLabelTitle);
            QXClient.get().gestures().waitAndClickElementisVisible(withoutPrinter);

        }

        QXClient.get().report().info("successfully clicked on close hu yes");
        Thread.sleep(200);


        QXClient.get().report().info("print HU label is displayed");
        //    QXClient.get().gestures().isElementPresent(DockType);
        //  QXClient.get().report().info(DockType.getText()+" "+"Dock Type");
        //System.out.println((DockType.getText()+" "+"Dock Type"));


        QXClient.get().report().info("successfully clicked on without printer");
        Thread.sleep(200);

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

    //==================================================================

    public  void scrollElementsForSecondHU() throws InterruptedException {
        QXClient.get().gestures().scrollVertically1(3);
        Thread.sleep(1000);
    }
//===============================================================================================Grace Citrus Passi Shower Gel 250ml1
//Grace Citrus Passi Shower Gel 250ml1
//    Meadows Air Freshener Lav Bls-240ml2
//    Grace Deep Impact Shower Gel 250m3
    //=============================================================================

    @FindBy(xpath = "//android.widget.TextView[@resource-id='com.dmartlabs.pwp:id/txt_lip_product_name']")
    private List<MobileElement> ListOfItemsSecondHU;
    ArrayList<String> SecondHU = new ArrayList<>();
    List<String> uniqueItems = new ArrayList<>();

    public void addElementsToListSecondHUInOffline() throws InterruptedException {

        Thread.sleep(500);
        int k = 4;
        for (int n = 0; n < ListOfItemsSecondHU.size(); n++) {
            SecondHU.add(ListOfItemsSecondHU.get(n).getText());
            // System.out.println(ListOfItemsSecondHU.get(n).getText()+"="+"ItemNumber"+(k++));
        }
        for (String unique : SecondHU) {
            if (!FirstHU.contains(unique)) {
                uniqueItems.add(unique);
                System.out.println(unique);
            }
        }
    }


    public  void ClickItemOneByoneSecondHUInOffline() throws InterruptedException {

        QXClient.get().gestures().toggleWiFi();

        Thread.sleep(1000);
        for(String    uniqueItems1:uniqueItems)
        {
            QXClient.get().gestures().waitForElementToVisible(wifiSignalOff);
            QXClient.get().gestures().isElementPresent(wifiSignalOff);
            System.out.println("=====================>"+"wifi is turn off");
            QXClient.get().report().info("=====================>"+"wifi is turn off");
            QXClient.get().report().info(wifiSignalOff.getText());
            //     QXClient.get().driver().findElement(By.xpath("//android.widget.TextView[@text='Grace Deep Impact Shower Gel 250m']"));
            MobileElement ItemName1 = (MobileElement) QXClient.get().driver().findElement(By.xpath("//android.widget.TextView[@text='"+uniqueItems1+"']"));
            ////android.widget.TextView[@resource-id='com.dmartlabs.pwp:id/txt_lip_product_name' and @text='Grace Citrus Passi Shower Gel 250ml']/following-sibling::android.widget.TextView[@resource-id='com.dmartlabs.pwp:id/txt_lip_bin_no']
            MobileElement BinNo1 = (MobileElement) QXClient.get().driver().findElement(By.xpath("//android.widget.TextView[@resource-id='com.dmartlabs.pwp:id/txt_lip_product_name' and @text='"+uniqueItems1+"']/following-sibling::android.widget.TextView[@resource-id='com.dmartlabs.pwp:id/txt_lip_bin_no']"));
////android.widget.TextView[@resource-id='com.dmartlabs.pwp:id/txt_lip_product_name' and @text='Colgate Maxfresh Blue Gel Tp(300g)']/parent::android.view.ViewGroup[@resource-id='com.dmartlabs.pwp:id/cl_lip_parent']/descendant::android.widget.TextView[@resource-id='com.dmartlabs.pwp:id/txt_lip_hu_type_value']
            MobileElement Hutype1 = (MobileElement) QXClient.get().driver().findElement(By.xpath("//android.widget.TextView[@resource-id='com.dmartlabs.pwp:id/txt_lip_product_name' and @text='"+uniqueItems1+"']/parent::android.view.ViewGroup[@resource-id='com.dmartlabs.pwp:id/cl_lip_parent']/descendant::android.widget.TextView[@resource-id='com.dmartlabs.pwp:id/txt_lip_hu_type_value']"));
//android.widget.TextView[@resource-id='com.dmartlabs.pwp:id/txt_lip_product_name' and @text='Colgate Maxfresh Blue Gel Tp(300g)']/parent::android.view.ViewGroup[@resource-id='com.dmartlabs.pwp:id/cl_lip_parent']/descendant::android.widget.TextView[@resource-id='com.dmartlabs.pwp:id/txt_lip_boxes_value']
            MobileElement CaselotQuantity1 = (MobileElement) QXClient.get().driver().findElement(By.xpath("//android.widget.TextView[@resource-id='com.dmartlabs.pwp:id/txt_lip_product_name' and @text='" + uniqueItems1 + "']/parent::android.view.ViewGroup[@resource-id='com.dmartlabs.pwp:id/cl_lip_parent']/descendant::android.widget.TextView[@resource-id='com.dmartlabs.pwp:id/txt_lip_boxes_value']"));

            int caseLotNum = Integer.parseInt(CaselotQuantity1.getText().trim());
            QXClient.get().gestures().isElementPresent(ItemName1);
            QXClient.get().report().info("Item name is present"+"====>"+ItemName1.getText());
            Thread.sleep(100);
            QXClient.get().gestures().isElementPresent(BinNo1);
            QXClient.get().report().info("BinNo is present"+"====>"+BinNo1.getText());
            Thread.sleep(100);
            QXClient.get().gestures().isElementPresent(Hutype1);
            QXClient.get().report().info("Hutype is present"+"====>"+Hutype1.getText());
            Thread.sleep(100);
            QXClient.get().gestures().isElementPresent(CaselotQuantity1);
            QXClient.get().report().info("CaselotQuantity is present"+"====>"+CaselotQuantity1.getText());
            Thread.sleep(100);
            //   System.out.println(ItemName.getText()+"===============>"+"name of item");
            System.out.println("itemName"+"======>"+uniqueItems1+"binNumber"+"======>"+BinNo1.getText()+"HU type"+"======>"+Hutype1.getText()+"caseLotQuantity"+"======>"+CaselotQuantity1.getText());
            QXClient.get().report().info("itemName"+"======>"+uniqueItems1+"binNumber"+"======>"+BinNo1.getText()+"HU type"+"======>"+Hutype1.getText()+"caseLotQuantity"+"======>"+CaselotQuantity1.getText());
            QXClient.get().gestures().waitAndClickElementisVisible(ItemName1);
            QXClient.get().report().info("Clicking on item Name"+"===========>"+uniqueItems1);
            System.out.println("item successfully picked"+"==================>"+uniqueItems1);
            Thread.sleep(100);
            Thread.sleep(100);
            QXClient.get().gestures().waitAndClickElementisVisible(Verified);
            QXClient.get().report().info("after click on item verifying");
            Thread.sleep(100);
            //android.widget.TextView[@resource-id='com.dmartlabs.pwp:id/txt_vpip_item_desc' and @text='Colgate Maxfresh Blue Gel Tp(300g)']/following-sibling::android.widget.TextView[@resource-id='com.dmartlabs.pwp:id/txt_vpip_ean_value']
            WebElement EanNumer = QXClient.get().driver().findElement(By.xpath("//android.widget.TextView[@resource-id='com.dmartlabs.pwp:id/txt_vpip_item_desc' and @text='"+uniqueItems1+"']/following-sibling::android.widget.TextView[@resource-id='com.dmartlabs.pwp:id/txt_vpip_ean_value']"));
            System.out.println(uniqueItems1+" "+"============>EanNumer"+EanNumer.getText());
            Thread.sleep(100);
            //  QXClient.get().gestures().isElementPresent(EanNumer);
            QXClient.get().report().info("Ean number valid"+"=======>"+EanNumer.getText());
            QXClient.get().gestures().waitAndClickElementisVisible(CompletePick);
            QXClient.get().report().info("after verifying,complete picking");
            Thread.sleep(200);
            for (int j = 0; j < caseLotNum; j++) {
                QXClient.get().gestures().waitAndClickElementisVisible(plus);
                QXClient.get().report().info("adding case slot quantity");
            }
            Thread.sleep(200);
            QXClient.get().gestures().waitAndClickElementisVisible(confirm);
            QXClient.get().report().info("Finally click on confirm");
            Thread.sleep(500);

        }
        QXClient.get().gestures().isElementPresent(sync);
        System.out.println("item is try to sync");
        QXClient.get().report().info("item is try to sync");
    }
    public  void EmptyListDisplayed() throws InterruptedException {
        Thread.sleep(200);
        QXClient.get().gestures().isElementPresent(pickListTitle);
        QXClient.get().report().info("PickList Tilte is displayed");
    }
    public  void ClickOnSecondHuCloseHUInOffline() throws InterruptedException {

        QXClient.get().gestures().waitAndClickElementisVisible(closeHU);
        QXClient.get().report().info("After all items picking clicking on close Hu");
        Thread.sleep(200);
        QXClient.get().gestures().waitAndClickElementisVisible(CloseHuYes);
        Thread.sleep(200);
        System.out.println(noNetworktitle.getText());
        QXClient.get().gestures().isElementPresent(noNetworktitle);
        QXClient.get().report().info(noNetworktitle.getText());
        Thread.sleep(200);
        //  Thread.sleep(200);
        QXClient.get().gestures().toggleWiFi();
        System.out.println("=======================>"+"wifi is turn on");
        QXClient.get().report().info("=======================>"+"wifi is turn on");
        QXClient.get().gestures().waitAndClickElementisVisible(NoNetworkOk);

        Thread.sleep(4000);
        QXClient.get().gestures().waitAndClickElementisVisible(closeHU);
        QXClient.get().report().info("After all items picking clicking on close Hu");
        Thread.sleep(500);
        QXClient.get().gestures().waitAndClickElementisVisible(CloseHuYes);
        Thread.sleep(200);
        try
        {
            QXClient.get().gestures().isElementPresent(PrintHuLabelTitle);
            QXClient.get().gestures().waitAndClickElementisVisible(withoutPrinter);
        }
        catch (Exception e) {
            System.out.println("inside catch block");
            QXClient.get().gestures().waitAndClickElementisVisible(closeHU);
            QXClient.get().gestures().waitAndClickElementisVisible(CloseHuYes);
            QXClient.get().gestures().isElementPresent(PrintHuLabelTitle);
            QXClient.get().gestures().waitAndClickElementisVisible(withoutPrinter);
        }

        QXClient.get().report().info("print HU label is displayed");
        // QXClient.get().gestures().isElementPresent(DockType);
        //QXClient.get().report().info(DockType.getText()+" "+"Dock Type");
        //System.out.println((DockType.getText()+" "+"Dock Type"));


        QXClient.get().report().info("successfully clicked on without printer");
        Thread.sleep(200);

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
    //    =======================================================================
    //box type
    // =======
    @FindBy(id="com.dmartlabs.pwp:id/btn_vhu_close_hu")
    private  MobileElement palletFull;
    @FindBy(xpath = "//android.widget.Button[@text='YES']")
    private  MobileElement palletfullYes;
    @FindBy(id = "com.dmartlabs.pwp:id/txt_hm_title")
    private  MobileElement moveToDispatchTitle;

    @FindBy(id="com.dmartlabs.pwp:id/txt_hm_dock_name")
    private  MobileElement dockName;
    @FindBy(id = "com.dmartlabs.pwp:id/btn_hm_continue_picking")
    private  MobileElement continuePickBox;

    @FindBy(id="com.dmartlabs.pwp:id/txt_pl_view_hu")
    private  MobileElement ViewPallet;
//==================================================================================================================
    //offline box type

    public  void clicknViewPallet()
    {
        QXClient.get().gestures().waitAndClickElementisVisible(ViewPallet);
    }

    public  void clickOnContinuePicking()
    {

        QXClient.get().gestures().isElementPresent(palletFull);
        QXClient.get().report().info("palletFull page is displayed");

        QXClient.get().gestures().waitAndClickElementisVisible(palletFull);
        QXClient.get().gestures().waitAndClickElementisVisible(palletfullYes);

        QXClient.get().gestures().isElementPresent(moveToDispatchTitle);
        QXClient.get().report().info(dockName.getText());
        System.out.println(dockName.getText()+"=========>"+dockName);
        QXClient.get().gestures().waitAndClickElementisVisible(continuePickBox);
    }

    public  void clickOnContinuePickingInOfflineTwoHU() throws InterruptedException {

        QXClient.get().gestures().isElementPresent(palletFull);
        QXClient.get().report().info("palletFull page is displayed");

        QXClient.get().gestures().waitAndClickElementisVisible(palletFull);
        Thread.sleep(100);
        QXClient.get().gestures().waitAndClickElementisVisible(palletfullYes);

        System.out.println(noNetworktitle.getText());
        QXClient.get().report().info(noNetworktitle.getText());
        QXClient.get().gestures().isElementPresent(noNetworktitle);
        Thread.sleep(200);
        QXClient.get().gestures().toggleWiFi();
        System.out.println("=======================>"+"wifi is turn on");
        QXClient.get().report().info("=======================>"+"wifi is turn on");
        QXClient.get().gestures().waitAndClickElementisVisible(NoNetworkOk);
        //   Thread.sleep(200);
        Thread.sleep(4000);

        QXClient.get().gestures().waitAndClickElementisVisible(palletFull);
        Thread.sleep(100);
        QXClient.get().gestures().waitAndClickElementisVisible(palletfullYes);
        Thread.sleep(100);
        try {
            QXClient.get().gestures().isElementPresent(moveToDispatchTitle);
            QXClient.get().report().info(dockName.getText());
        }
        catch (Exception e)
        {
            System.out.println("inside catch");
            QXClient.get().gestures().waitAndClickElementisVisible(palletFull);
            Thread.sleep(100);
            QXClient.get().gestures().waitAndClickElementisVisible(palletfullYes);
            QXClient.get().gestures().isElementPresent(moveToDispatchTitle);
            QXClient.get().report().info(dockName.getText());
        }
        System.out.println(dockName.getText()+"=========>"+dockName);
        QXClient.get().gestures().waitAndClickElementisVisible(continuePickBox);
    }
}
//==========



//=====================================================================================================
//
//    public  void  clicknViewPallet()
//    {
//
//        QXClient.get().gestures().waitAndClickElementisVisible(ViewPallet);
//    }
//
//    public void  PalletFullPageDisplayed()
//    {
//        QXClient.get().gestures().isElementPresent(palletFull);
//        QXClient.get().report().info("palletFull page is displayed");
//    }
//    public  void clickOnPalletFull()
//    {
//        QXClient.get().gestures().waitAndClickElementisVisible(palletFull);
//        QXClient.get().gestures().waitAndClickElementisVisible(palletfullYes);
//    }
//
//    public void moveToDispatchTitleIsDisplayed()
//    {
//        QXClient.get().gestures().isElementPresent(moveToDispatchTitle);
//        QXClient.get().report().info(dockName.getText());
//        System.out.println(dockName.getText()+"=========>"+dockName);
//    }
//    public  void clickOnContinuePicking()
//    {
//        QXClient.get().gestures().waitAndClickElementisVisible(continuePickBox);
//
//    }










