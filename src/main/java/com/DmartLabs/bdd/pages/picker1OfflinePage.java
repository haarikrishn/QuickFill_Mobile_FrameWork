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

public class picker1OfflinePage {
    //normal delivery  number
    public picker1OfflinePage() {

        PageFactory.initElements(new AppiumFieldDecorator(QXClient.get().driver()), this);
    }
    //==============================================
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

    ArrayList<String> ElementText=new ArrayList<>();

    public  void addElementsToListInOffline()
    {
        for(int i=0;i<ListOfItems.size();i++)
        {
            ElementText.add(ListOfItems.get(i).getText());
            System.out.println(ListOfItems.get(i).getText() + i);
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
    @FindBy(xpath = "//android.widget.ImageView[@resource-id='com.dmartlabs.pwp:id/iv_lip_remote_sync']")
    private  MobileElement sync;

    public  void PickListDetailsInOffline()
    {
        QXClient.get().gestures().waitAndClickElementisVisible(pickListDetails);
        QXClient.get().report().info("store site Id is"+"============>"+storeSiteId.getText());
        QXClient.get().report().info("delivery nUmber is"+"=============>"+PickerDeliveryNumber.getText());
        String NormalDLVNumber = PickerDeliveryNumber.getText().replace("#", "");
        QXClient.setNormalDeliveryNumber(NormalDLVNumber);
        System.out.println(NormalDLVNumber+"=========NormalDLVNumber");
        System.out.println("store site Id is"+"============>"+storeSiteId.getText());
        System.out.println("delivery nUmber is"+"=============>"+PickerDeliveryNumber.getText());
        QXClient.get().gestures().clickOnElement(pickListDetailsOK);
    }
    @FindBy(xpath = "//android.widget.ImageView[@resource-id='com.dmartlabs.pwp:id/iv_fch_wifi_off_signal']")
    private  MobileElement wifiSignalOff;

    public  void ClickItemOneByoneInOffline() throws InterruptedException {
        QXClient.get().gestures().toggleWiFi();
        Thread.sleep(2000);
        for(String    itemText:ElementText)
        {

            QXClient.get().gestures().waitForElementToVisible(wifiSignalOff);
            System.out.println("================>"+wifiSignalOff.getText());

            // QXClient.get().gestures().t
            //     QXClient.get().driver().findElement(By.xpath("//android.widget.TextView[@text='Grace Deep Impact Shower Gel 250m']"));
            MobileElement ItemName = (MobileElement) QXClient.get().driver().findElement(By.xpath("//android.widget.TextView[@text='"+itemText+"']"));
            ////android.widget.TextView[@resource-id='com.dmartlabs.pwp:id/txt_lip_product_name' and @text='Grace Citrus Passi Shower Gel 250ml']/following-sibling::android.widget.TextView[@resource-id='com.dmartlabs.pwp:id/txt_lip_bin_no']
            MobileElement BinNo = (MobileElement) QXClient.get().driver().findElement(By.xpath("//android.widget.TextView[@resource-id='com.dmartlabs.pwp:id/txt_lip_product_name' and @text='"+itemText+"']/following-sibling::android.widget.TextView[@resource-id='com.dmartlabs.pwp:id/txt_lip_bin_no']"));
////android.widget.TextView[@resource-id='com.dmartlabs.pwp:id/txt_lip_product_name' and @text='Colgate Maxfresh Blue Gel Tp(300g)']/parent::android.view.ViewGroup[@resource-id='com.dmartlabs.pwp:id/cl_lip_parent']/descendant::android.widget.TextView[@resource-id='com.dmartlabs.pwp:id/txt_lip_hu_type_value']
            MobileElement Hutype = (MobileElement) QXClient.get().driver().findElement(By.xpath("//android.widget.TextView[@resource-id='com.dmartlabs.pwp:id/txt_lip_product_name' and @text='"+itemText+"']/parent::android.view.ViewGroup[@resource-id='com.dmartlabs.pwp:id/cl_lip_parent']/descendant::android.widget.TextView[@resource-id='com.dmartlabs.pwp:id/txt_lip_hu_type_value']"));
//android.widget.TextView[@resource-id='com.dmartlabs.pwp:id/txt_lip_product_name' and @text='Colgate Maxfresh Blue Gel Tp(300g)']/parent::android.view.ViewGroup[@resource-id='com.dmartlabs.pwp:id/cl_lip_parent']/descendant::android.widget.TextView[@resource-id='com.dmartlabs.pwp:id/txt_lip_boxes_value']
            MobileElement CaselotQuantity = (MobileElement) QXClient.get().driver().findElement(By.xpath("//android.widget.TextView[@resource-id='com.dmartlabs.pwp:id/txt_lip_product_name' and @text='" + itemText + "']/parent::android.view.ViewGroup[@resource-id='com.dmartlabs.pwp:id/cl_lip_parent']/descendant::android.widget.TextView[@resource-id='com.dmartlabs.pwp:id/txt_lip_boxes_value']"));

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
            System.out.println("itemName"+"======>"+itemText+"binNumber"+"======>"+BinNo.getText()+"HU type"+"======>"+Hutype.getText()+"caseLotQuantity"+"======>"+CaselotQuantity.getText());
            QXClient.get().report().info("itemName"+"======>"+itemText+"binNumber"+"======>"+BinNo.getText()+"HU type"+"======>"+Hutype.getText()+"caseLotQuantity"+"======>"+CaselotQuantity.getText());

            QXClient.get().gestures().waitAndClickElementisVisible(ItemName);


            QXClient.get().report().info("Clicking on item Name"+"===========>"+itemText);
            System.out.println("item successfully picked"+"==================>"+itemText);
            Thread.sleep(200);
            Thread.sleep(200);
            QXClient.get().gestures().waitAndClickElementisVisible(Verified);
            QXClient.get().report().info("after click on item verifying");
            Thread.sleep(200);
            //android.widget.TextView[@resource-id='com.dmartlabs.pwp:id/txt_vpip_item_desc' and @text='Colgate Maxfresh Blue Gel Tp(300g)']/following-sibling::android.widget.TextView[@resource-id='com.dmartlabs.pwp:id/txt_vpip_ean_value']
            WebElement EanNumer = QXClient.get().driver().findElement(By.xpath("//android.widget.TextView[@resource-id='com.dmartlabs.pwp:id/txt_vpip_item_desc' and @text='"+itemText+"']/following-sibling::android.widget.TextView[@resource-id='com.dmartlabs.pwp:id/txt_vpip_ean_value']"));
            System.out.println(itemText+" "+"============>EanNumer"+EanNumer.getText());
            Thread.sleep(200);
            QXClient.get().gestures().isElementPresent(EanNumer);
            QXClient.get().report().info("Ean number valid"+"=======>"+EanNumer.getText());
            QXClient.get().gestures().waitAndClickElementisVisible(CompletePick);
            QXClient.get().report().info("after verifying,complete picking");
            Thread.sleep(200);
            for (int j = 0; j < 2; j++) {
                QXClient.get().gestures().waitAndClickElementisVisible(plus);
                QXClient.get().report().info("adding case slot quantity");
            }
            Thread.sleep(200);
            QXClient.get().gestures().waitAndClickElementisVisible(confirm);
            QXClient.get().report().info("Finally click on confirm");
            Thread.sleep(1000);
            QXClient.get().gestures().waitForElementToVisible(sync);
            System.out.println("=====================>"+sync.getText());
        }
    }

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


    public  void HUpageIsDisplayedInoffline() throws InterruptedException {
        Thread.sleep(200);
//QXClient.get().gestures().isElementPresent(CloseHU);
        QXClient.get().report().info("CloseHu button is displayyed");
        //   QXClient.get().gestures().isElementPresent(HUTitle);
        Thread.sleep(200);
        QXClient.get().report().info("HU Titlle is displayed");
        QXClient.get().gestures().isElementPresent(NumberOfItems);
        Thread.sleep(200);
        QXClient.get().report().info(NumberOfItems.getText()+" "+"no.of items present");
        System.out.println(NumberOfItems.getText()+" "+"no.of items present");

    }

    @FindBy(xpath = "//android.widget.TextView[@text='Paste and scan the HU label']")
    private  MobileElement ScanHulabeltitle;

    @FindBy (xpath = "//android.widget.TextView[@resource-id='com.dmartlabs.pwp:id/txt_hm_title']")
    private  MobileElement MoveToDispatchTitle;

    @FindBy(xpath = "//android.widget.TextView[@resource-id='com.dmartlabs.pwp:id/txt_pl_title']")
    private  MobileElement pickListTitle;

    public  void ClickOnCloseHUInOffline() throws InterruptedException {

        QXClient.get().gestures().toggleWiFi();
        Thread.sleep(3000);
        System.out.println("===================>"+"wifi is on");
        QXClient.get().gestures().waitAndClickElementisVisible(closeHU);
        QXClient.get().report().info("After all items picking clicking on close Hu");
        Thread.sleep(500);
        QXClient.get().gestures().waitAndClickElementisVisible(CloseHuYes);
        QXClient.get().report().info("successfully clicked on close hu yes");
        Thread.sleep(200);

        QXClient.get().gestures().isElementPresent(PrintHuLabelTitle);
        QXClient.get().report().info("print HU label is displayed");
        QXClient.get().gestures().isElementPresent(DockType);
        QXClient.get().report().info(DockType.getText()+" "+"Dock Type");
        System.out.println((DockType.getText()+" "+"Dock Type"));

        QXClient.get().gestures().waitAndClickElementisVisible(withoutPrinter);
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

    public  void EmptyListDisplayed() throws InterruptedException {
        Thread.sleep(200);
        QXClient.get().gestures().isElementPresent(pickListTitle);
        QXClient.get().report().info("PickList Tilte is displayed");
        homeBtn.click();
    }
    //==================================================================================
    //seven items
//   ===============
    @FindBy(xpath = "//android.widget.TextView[@resource-id='com.dmartlabs.pwp:id/txt_lip_product_name']")
    private List<MobileElement> ListOfItems1;
    ArrayList<String>ElementText1=new ArrayList<>();
    List<String> uniqueItems = new ArrayList<>();

//        for (String item : list2) {
//        if (!list1.contains(item)) {
//            uniqueItems.add(item);
//        }
//    }


    public  void addElementsToList1InOffline()
    {
        int k=4;
        for(int i=0;i<ListOfItems1.size();i++) {
            ElementText1.add(ListOfItems1.get(i).getText());
        }

        for(String   unique:ElementText1)
        {
            if(!ElementText.contains(unique))
            {
                uniqueItems.add(unique) ;
                System.out.println(unique);
            }

        }
        QXClient.get().report().info("Adddign all items to ArrayList");
        System.out.println(ListOfItems1.size()+"============item size");
    }
    public  void ClickItemOneByone1InOffline() throws InterruptedException {


        for(String    uniqueItems1:uniqueItems)
        {
            QXClient.get().gestures().waitForElementToVisible(wifiSignalOff);
            System.out.println("================>"+wifiSignalOff.getText());

            //     QXClient.get().driver().findElement(By.xpath("//android.widget.TextView[@text='Grace Deep Impact Shower Gel 250m']"));
            MobileElement ItemName1 = (MobileElement) QXClient.get().driver().findElement(By.xpath("//android.widget.TextView[@text='"+uniqueItems1+"']"));
            ////android.widget.TextView[@resource-id='com.dmartlabs.pwp:id/txt_lip_product_name' and @text='Grace Citrus Passi Shower Gel 250ml']/following-sibling::android.widget.TextView[@resource-id='com.dmartlabs.pwp:id/txt_lip_bin_no']
            MobileElement BinNo1 = (MobileElement) QXClient.get().driver().findElement(By.xpath("//android.widget.TextView[@resource-id='com.dmartlabs.pwp:id/txt_lip_product_name' and @text='"+uniqueItems1+"']/following-sibling::android.widget.TextView[@resource-id='com.dmartlabs.pwp:id/txt_lip_bin_no']"));
////android.widget.TextView[@resource-id='com.dmartlabs.pwp:id/txt_lip_product_name' and @text='Colgate Maxfresh Blue Gel Tp(300g)']/parent::android.view.ViewGroup[@resource-id='com.dmartlabs.pwp:id/cl_lip_parent']/descendant::android.widget.TextView[@resource-id='com.dmartlabs.pwp:id/txt_lip_hu_type_value']
            MobileElement Hutype1 = (MobileElement) QXClient.get().driver().findElement(By.xpath("//android.widget.TextView[@resource-id='com.dmartlabs.pwp:id/txt_lip_product_name' and @text='"+uniqueItems1+"']/parent::android.view.ViewGroup[@resource-id='com.dmartlabs.pwp:id/cl_lip_parent']/descendant::android.widget.TextView[@resource-id='com.dmartlabs.pwp:id/txt_lip_hu_type_value']"));
//android.widget.TextView[@resource-id='com.dmartlabs.pwp:id/txt_lip_product_name' and @text='Colgate Maxfresh Blue Gel Tp(300g)']/parent::android.view.ViewGroup[@resource-id='com.dmartlabs.pwp:id/cl_lip_parent']/descendant::android.widget.TextView[@resource-id='com.dmartlabs.pwp:id/txt_lip_boxes_value']
            MobileElement CaselotQuantity1 = (MobileElement) QXClient.get().driver().findElement(By.xpath("//android.widget.TextView[@resource-id='com.dmartlabs.pwp:id/txt_lip_product_name' and @text='" + uniqueItems1 + "']/parent::android.view.ViewGroup[@resource-id='com.dmartlabs.pwp:id/cl_lip_parent']/descendant::android.widget.TextView[@resource-id='com.dmartlabs.pwp:id/txt_lip_boxes_value']"));

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
            //   Thread.sleep(200);
            QXClient.get().gestures().waitAndClickElementisVisible(Verified);
            QXClient.get().report().info("after click on item verifying");
            Thread.sleep(200);
            //android.widget.TextView[@resource-id='com.dmartlabs.pwp:id/txt_vpip_item_desc' and @text='Colgate Maxfresh Blue Gel Tp(300g)']/following-sibling::android.widget.TextView[@resource-id='com.dmartlabs.pwp:id/txt_vpip_ean_value']
            WebElement EanNumer = QXClient.get().driver().findElement(By.xpath("//android.widget.TextView[@resource-id='com.dmartlabs.pwp:id/txt_vpip_item_desc' and @text='"+uniqueItems1+"']/following-sibling::android.widget.TextView[@resource-id='com.dmartlabs.pwp:id/txt_vpip_ean_value']"));
            System.out.println(uniqueItems1+" "+"============>EanNumer"+EanNumer.getText());
            Thread.sleep(200);
            // QXClient.get().gestures().isElementPresent(EanNumer);
            QXClient.get().report().info("Ean number valid"+"=======>"+EanNumer.getText());
            QXClient.get().gestures().waitAndClickElementisVisible(CompletePick);
            QXClient.get().report().info("after verifying,complete picking");
            Thread.sleep(200);
            for (int j = 0; j < 2; j++) {
                QXClient.get().gestures().waitAndClickElementisVisible(plus);
                QXClient.get().report().info("adding case slot quantity");
            }
            Thread.sleep(200);
            QXClient.get().gestures().waitAndClickElementisVisible(confirm);
            QXClient.get().report().info("Finally click on confirm");
            Thread.sleep(1000);
            QXClient.get().gestures().waitForElementToVisible(sync);
            System.out.println("=====================>"+sync.getText());

        }
    }
}













