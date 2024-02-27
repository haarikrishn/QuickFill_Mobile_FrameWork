package com.DmartLabs.bdd.pages;

import com.DmartLabs.commonutils.QXClient;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.cucumber.datatable.DataTable;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.*;
import java.util.concurrent.TimeUnit;

public class PickerBoxAndPalletInvalidQuantityType11Page {

    String ExpectedBoxTypeDispatch = "BOX DISPATCH";
    String ExpectedPalletTypeDispatch = "PALLET DISPATCH";

    PickerBoxAndPalletType11Page pickerBoxAndPalletType11Page = new PickerBoxAndPalletType11Page();

    public PickerBoxAndPalletInvalidQuantityType11Page() {

        PageFactory.initElements(new AppiumFieldDecorator(QXClient.get().driver()), this);
    }


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
        Thread.sleep(500);
        try {
            QXClient.get().gestures().waitAndClickElementisVisible(pickListDetails);
        }
        catch (NoSuchElementException e)
        {
            System.out.println("============>+ items are not available");
        }

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

    public Set<String> getDeliveryAllItemsPicker1() throws InterruptedException {
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














    //=========================================================================================================
    public Set<String> getDeliveryAllItemsPicker() throws InterruptedException {
      //  TimeUnit.SECONDS.sleep(10);
        Thread.sleep(500);
        int k = 0;
        for (MobileElement item : WithoutBlockItems) {
            deliveryAllItemsPickerAl.add(item.getText().trim());
            //    System.out.println(item.getText()+k++);
        }
        //    System.out.println(deliveryAllItemsPickerAl.size() + "=======>deliveryAllItemsPickerAl");
        if (isScroll) {
            scrollCount++;
            QXClient.get().gestures().scrollDeliveryItemsUpwardsPicker(1);
          //  TimeUnit.SECONDS.sleep(10);
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
                    Thread.sleep(100);
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
      //  TimeUnit.SECONDS.sleep(10);
        Thread.sleep(500);
        QXClient.get().gestures().scrollDeliveryItemsDownwardPicker(1);
        System.out.println("scroll downward ");
       // TimeUnit.SECONDS.sleep(10);
        //  int i=0;
        return deliveryAllItemsPickerAl;
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

    //=====================================================================
    @FindBy(xpath = "  //android.widget.RadioButton[@text='Damaged']")
    private MobileElement radioXpath;

    @FindBy(xpath = "//android.widget.RadioButton[@resource-id='com.dmartlabs.pwp:id/rb_iqd_hu_full']")
    private MobileElement HUfull;

    @FindBy(xpath = "//android.widget.RadioButton")
    private List<MobileElement> AllRadioButtons;

    @FindBy(xpath = "//android.widget.Button[@resource-id='com.dmartlabs.pwp:id/btn_iqd_submit']")
    private MobileElement submit;


    public void ClickItemOneByoneBoxAndPalletType() throws InterruptedException {
////        for(int i=0;i<deliveryAllItemsPickerAl.size();i++)
////        {
////            System.out.println(deliveryAllItemsPickerAl.get(i)+"Final Item"+i);
////        }
//        int k=0;
//        for(String   itms:deliveryAllItemsPickerAl)
//        {
//            System.out.println(itms+"=========>itms"+k++);
//        }
//        System.out.println(deliveryAllItemsPickerAl.size()+"========>deliveryAllItemsPickerAlSize");
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
                QXClient.get().gestures().clickOnElement(Verified);
            } catch (Exception e) {
                //     QXClient.get().gestures().isElementPresent(IncorrectBinMsg);
                //    QXClient.get().report().info(IncorrectBinMsg.getText());
                //    System.out.println(IncorrectBinMsg.getText());
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
//==========================================================

    // String PalletFullItem1;
    String HuFullItem1;

    public void GetDataFromDataTableDT(DataTable dataTable) throws InterruptedException {

        Map<String, String> InvalidQtyDt = dataTable.asMap(String.class, String.class);

        String ActualDispatchType = QXClient.getDispatchType();
        System.out.println(ActualDispatchType + "======is ActualDispatchType");

        if (ActualDispatchType.equals(ExpectedBoxTypeDispatch)) {
            System.out.println(ExpectedBoxTypeDispatch + "==========+is ExpectedBoxTypeDispatch");
            HuFullItem1 = InvalidQtyDt.get("PalletFullItem");
        }
        //HUFullItem
        else if (ActualDispatchType.equals(ExpectedPalletTypeDispatch)) {
            System.out.println(ExpectedPalletTypeDispatch + "==========+is ExpectedPalletTypeDispatch");
            HuFullItem1 = InvalidQtyDt.get("HUFullItem");
        } else {
            System.out.println("invalid dispatch type ");
        }

        // HuFullItem1 = InvalidQtyDt.get("HUFullItem");
        //PalletFullItem1=InvalidQtyDt.get("PalletFullItem");
        //   int CaselotRemoveQty1 = Integer.parseInt(InvalidQtyDt.get("CaselotRemoveQty"));

    }
    //===========================================================================================================

    //             | ItemName                            | Reason               | RemoveQuantity |
//            | Pampers Aloe Baby Wips(72n)         | Short                | 1              |
//            | Boroplus Alov Hal Ch Kes Gel(150ml) | Damaged              | 1              |
//            | Colgate Maxfresh Blue Gel Tp(300g)  | Wrong article        | 1              |
//            | Oral B Kids 2+ Year Toothbrush(3n)  | HU FullORPallet Full | 1              |
    List<String> itemsAl = new ArrayList<>();
    //
//    public void ClickItemOneByoneBoxAndPalletTypeInvalidQtyDT(DataTable dataTable) throws InterruptedException {
//        List<Map<String, String>> pickerItemsDT = dataTable.asMaps();
//        int k = 0;
//        for (int i = 0; i < pickerItemsDT.size(); i++) {
//            Map<String, String> PickerItemOneByOne = pickerItemsDT.get(i);//data table
//
//            String ItemNameValue = PickerItemOneByOne.get("ItemName");
//            String ReasonValue = PickerItemOneByOne.get("Reason");
//            int RemoveQuantityValue = Integer.parseInt(PickerItemOneByOne.get("RemoveQuantity"));
//
//
//            for (String itms : deliveryAllItemsPickerAl) {
//                itemsAl.add(itms);
//                System.out.println(itms + "=========>item" + k++);
//            }
////        System.out.println(deliveryAllItemsPickerAl.size() + "========>deliveryAllItemsPickerAlSize");
//            //  for (String itemText : deliveryAllItemsPickerAl) {
//            Thread.sleep(3500);
//            // QXClient.get().gestures().t
//            //     QXClient.get().driver().findElement(By.xpath("//android.widget.TextView[@text='Grace Deep Impact Shower Gel 250m']"));
//            MobileElement ItemName = (MobileElement) QXClient.get().driver().findElement(By.xpath("//android.widget.TextView[@text='" + itemsAl.get(i) + "']"));
//            //System.out.println(ItemName.getText()+"===========>ItemName  text1");
//
//            ////android.widget.TextView[@resource-id='com.dmartlabs.pwp:id/txt_lip_product_name' and @text='Grace Citrus Passi Shower Gel 250ml']/following-sibling::android.widget.TextView[@resource-id='com.dmartlabs.pwp:id/txt_lip_bin_no']
//            MobileElement BinNo = (MobileElement) QXClient.get().driver().findElement(By.xpath("//android.widget.TextView[@resource-id='com.dmartlabs.pwp:id/txt_lip_product_name' and @text='" + itemsAl.get(i) + "']/following-sibling::android.widget.TextView[@resource-id='com.dmartlabs.pwp:id/txt_lip_bin_no']"));
//////android.widget.TextView[@resource-id='com.dmartlabs.pwp:id/txt_lip_product_name' and @text='Colgate Maxfresh Blue Gel Tp(300g)']/parent::android.view.ViewGroup[@resource-id='com.dmartlabs.pwp:id/cl_lip_parent']/descendant::android.widget.TextView[@resource-id='com.dmartlabs.pwp:id/txt_lip_hu_type_value']
//            //       MobileElement Hutype = (MobileElement) QXClient.get().driver().findElement(By.xpath("//android.widget.TextView[@resource-id='com.dmartlabs.pwp:id/txt_lip_product_name' and @text='"+itemText+"']/parent::android.view.ViewGroup[@resource-id='com.dmartlabs.pwp:id/cl_lip_parent']/descendant::android.widget.TextView[@resource-id='com.dmartlabs.pwp:id/txt_lip_hu_type_value']"));
////android.widget.TextView[@resource-id='com.dmartlabs.pwp:id/txt_lip_product_name' and @text='Colgate Maxfresh Blue Gel Tp(300g)']/parent::android.view.ViewGroup[@resource-id='com.dmartlabs.pwp:id/cl_lip_parent']/descendant::android.widget.TextView[@resource-id='com.dmartlabs.pwp:id/txt_lip_boxes_value']
//            MobileElement CaselotQuantity = (MobileElement) QXClient.get().driver().findElement(By.xpath("//android.widget.TextView[@resource-id='com.dmartlabs.pwp:id/txt_lip_product_name' and @text='" + itemsAl.get(i) + "']/parent::android.view.ViewGroup[@resource-id='com.dmartlabs.pwp:id/cl_lip_parent']/descendant::android.widget.TextView[@resource-id='com.dmartlabs.pwp:id/txt_lip_boxes_value']"));
//
//            int caseLotNum = Integer.parseInt(CaselotQuantity.getText().trim());
//
//            QXClient.get().gestures().isElementPresent(ItemName);
//            QXClient.get().report().info("Item name is present" + "====>" + ItemName.getText());
//            Thread.sleep(100);
//            QXClient.get().gestures().isElementPresent(BinNo);
//            QXClient.get().report().info("BinNo is present" + "====>" + BinNo.getText());
//            Thread.sleep(100);
//            // QXClient.get().gestures().isElementPresent(Hutype);
//            //QXClient.get().report().info("Hutype is present"+"====>"+Hutype.getText());
//            Thread.sleep(100);
//            QXClient.get().gestures().isElementPresent(CaselotQuantity);
//            QXClient.get().report().info("CaselotQuantity is present" + "====>" + CaselotQuantity.getText());
//            Thread.sleep(100);
//            //   System.out.println(ItemName.getText()+"===============>"+"name of item");
//            //  System.out.println("itemName"+"======>"+itemText+"binNumber"+"======>"+BinNo.getText()+"HU type"+"======>"+Hutype.getText()+"caseLotQuantity"+"======>"+CaselotQuantity.getText());
//            //QXClient.get().report().info("itemName"+"======>"+itemText+"binNumber"+"======>"+BinNo.getText()+"HU type"+"======>"+Hutype.getText()+"caseLotQuantity"+"======>"+CaselotQuantity.getText());
//            Thread.sleep(2000);
//            QXClient.get().gestures().waitAndClickElementisVisible(ItemName);
//
//            try {
//                QXClient.get().gestures().clickOnElement(Verified);
//            } catch (Exception e) {
//                //     QXClient.get().gestures().isElementPresent(IncorrectBinMsg);
//                //    QXClient.get().report().info(IncorrectBinMsg.getText());
//                //    System.out.println(IncorrectBinMsg.getText());
//                QXClient.get().gestures().waitAndClickElementisVisible(IncorrectBinYes);
//                QXClient.get().gestures().waitAndClickElementisVisible(Verified);
//
//            }
////               QXClient.get().report().info("Clicking on item Name" + "===========>" + itemText);
////               System.out.println("item successfully picked" + "==================>" + itemText);
//            QXClient.get().report().info("Clicking on item Name" + "===========>" + itemsAl.get(i));
//            System.out.println("item successfully picked" + "==================>" + itemsAl.get(i));
//
//            Thread.sleep(200);
//            //  Thread.sleep(200);
//            //   QXClient.get().gestures().waitAndClickElementisVisible(Verified);
//            QXClient.get().report().info("after click on item verifying");
//            Thread.sleep(2000);
//            //android.widget.TextView[@resource-id='com.dmartlabs.pwp:id/txt_vpip_item_desc' and @text='Colgate Maxfresh Blue Gel Tp(300g)']/following-sibling::android.widget.TextView[@resource-id='com.dmartlabs.pwp:id/txt_vpip_ean_value']
//            WebElement EanNumer = QXClient.get().driver().findElement(By.xpath("//android.widget.TextView[@resource-id='com.dmartlabs.pwp:id/txt_vpip_item_desc' and @text='" + itemsAl.get(i) + "']/following-sibling::android.widget.TextView[@resource-id='com.dmartlabs.pwp:id/txt_vpip_ean_value']"));
//            //   System.out.println(itemText + " " + "============>EanNumer" + EanNumer.getText());
//            System.out.println(itemsAl.get(i) + " " + "============>EanNumer" + EanNumer.getText());
//
//            Thread.sleep(200);
//            QXClient.get().gestures().isElementPresent(EanNumer);
//            QXClient.get().report().info("Ean number valid" + "=======>" + EanNumer.getText());
//
//            QXClient.get().gestures().waitAndClickElementisVisible(CompletePick);
//
//            QXClient.get().report().info("after verifying,complete picking");
//            Thread.sleep(200);
//            System.out.println("caselot size is============>" + caseLotNum);
//
//            Thread.sleep(2000);
//            System.out.println(ItemNameValue + "=========>ItemNameValue");
////               try {
////                   System.out.println(ItemName.getText() + "============>ItemName.getText()");
////               }
////               catch (Exception e)
////               {
////                   ItemName = (MobileElement) QXClient.get().driver().findElement(By.xpath("//android.widget.TextView[@text='" + itemText + "']"));
////                   System.out.println(ItemName.getText() + "============>ItemName.getText()");
////               }
//
//            if (ItemNameValue.equals(itemsAl.get(i))) {
//                System.out.println("inside if");
//                for (int j = 0; j < caseLotNum - RemoveQuantityValue; j++) {
//                    QXClient.get().gestures().waitAndClickElementisVisible(plus);
//                    Thread.sleep(200);
//                    QXClient.get().report().info("adding case slot quantity");
//                }
//                QXClient.get().gestures().waitAndClickElementisVisible(confirm);
//                QXClient.get().report().info("Finally click on confirm");
//                Thread.sleep(100);
//
//                ArrayList<String> AllRadioList = new ArrayList<>();
//
//                for (int n = 0; n < AllRadioButtons.size(); n++) {
//                    AllRadioList.add(AllRadioButtons.get(n).getText());
//                    //    System.out.println(AllRadioButtons.get(n).getText() + n);
//                }
//                MobileElement radioButton = (MobileElement) QXClient.get().driver().findElement(By.xpath("//android.widget.RadioButton[@text='" + AllRadioList.get(i) + "']"));
//                //   System.out.println(ReasonValue+"============>ReasonValue");
//                // System.out.println(HuFullItem1+"============>HuFullItem1");
//
//
//                for (String radioOneByOne : AllRadioList) {
//                    if (radioOneByOne.equals(ReasonValue)) {
//                        QXClient.get().gestures().waitAndClickElementisVisible(radioButton);
//                        System.out.println("Incorrect Qty Item is==============>" + radioOneByOne);
//                        Thread.sleep(2000);
//                        QXClient.get().gestures().waitAndClickElementisVisible(submit);
//                    } else if (radioOneByOne.equals(HuFullItem1) && ReasonValue.equals("HuFullOrPalletFull")) {
//                        System.out.println("inside hu full");
//                        QXClient.get().gestures().waitAndClickElementisVisible(radioButton);
//                        System.out.println("Incorrect Qty Item is==============>" + radioOneByOne);
//                        Thread.sleep(2000);
//                        QXClient.get().gestures().waitAndClickElementisVisible(submit);
//                        VerifyDispatchTypeAndClosePalletOrHU();
//                    }
//                }
//            } else {
//                System.out.println("inside else============>");
//                for (int j = 0; j < caseLotNum; j++) {
//                    QXClient.get().gestures().waitAndClickElementisVisible(plus);
//                    QXClient.get().report().info("adding case slot quantity");
//                    Thread.sleep(1000);
//                }
//                Thread.sleep(200);
//                QXClient.get().gestures().waitAndClickElementisVisible(confirm);
//                QXClient.get().report().info("Finally click on confirm");
//                Thread.sleep(1000);
//            }
//
//
//        }
//    }
//========================================================================================
    public  void ClickItemOneByoneBoxAndPalletTypeInvalidQtyDT(DataTable dataTable) throws InterruptedException {

        List<Map<String, String>> pickerItemsDT = dataTable.asMaps();
        int k = 0;
        int radiocount=0;
        for(String  setItems:deliveryAllItemsPickerAl)
        {

            System.out.println(setItems+" "+k++);
        }
        int caseLotNum=0;
        MobileElement ItemName = null;
        for (String itms : deliveryAllItemsPickerAl) {
            //  int c=0;
            String actionedItem = "";
            for (int i = 0; i < pickerItemsDT.size(); i++) {

                Map<String, String> PickerItemOneByOne = pickerItemsDT.get(i);//data table

                String ItemNameValue = PickerItemOneByOne.get("ItemName");
                String ReasonValue = PickerItemOneByOne.get("Reason");
                int RemoveQuantityValue = Integer.parseInt(PickerItemOneByOne.get("RemoveQuantity"));
                Thread.sleep(500);
                try {
                    ItemName = (MobileElement) QXClient.get().driver().findElement(By.xpath("//android.widget.TextView[@text='" + itms + "']"));

                }
                catch (NoSuchElementException e)

                {
                    break;
                }
                MobileElement CaselotQuantity = (MobileElement) QXClient.get().driver().findElement(By.xpath("//android.widget.TextView[@resource-id='com.dmartlabs.pwp:id/txt_lip_product_name' and @text='" + itms + "']/parent::android.view.ViewGroup[@resource-id='com.dmartlabs.pwp:id/cl_lip_parent']/descendant::android.widget.TextView[@resource-id='com.dmartlabs.pwp:id/txt_lip_boxes_value']"));

                caseLotNum = Integer.parseInt(CaselotQuantity.getText().trim());

                if (ItemNameValue.equals(itms))
                {

                    //   System.out.println("inside second for loop");
                    Thread.sleep(1000);
                    Thread.sleep(500);
                    QXClient.get().gestures().waitAndClickElementisVisible(ItemName);

                    Thread.sleep(100);
                    QXClient.get().report().info("Clicking on item Name" + "===========>" + itms);
                    try {
                        QXClient.get().gestures().clickOnElement(Verified);
                    } catch (Exception e) {
                        QXClient.get().gestures().waitAndClickElementisVisible(IncorrectBinYes);
                        QXClient.get().gestures().waitAndClickElementisVisible(Verified);

                    }

                    //         System.out.println("item successfully picked" + "==================>" + itms);

                    Thread.sleep(200);

                    QXClient.get().gestures().waitAndClickElementisVisible(CompletePick);

                    actionedItem = itms;

                    for (int j = 0; j < caseLotNum - RemoveQuantityValue; j++) {
                        QXClient.get().gestures().waitAndClickElementisVisible(plus);
                        Thread.sleep(200);
                        QXClient.get().report().info("adding case slot quantity");
                    }
                    QXClient.get().gestures().waitAndClickElementisVisible(confirm);
                    QXClient.get().report().info("Finally click on confirm");
                    Thread.sleep(100);

                    ArrayList<String> AllRadioList = new ArrayList<>();

                    for (int n = 0; n < AllRadioButtons.size(); n++) {
                        AllRadioList.add(AllRadioButtons.get(n).getText());
                        //    System.out.println(AllRadioButtons.get(n).getText() + n);
                    }

                    for (String radioOneByOne : AllRadioList) {
                        // int j=0;
                        try {
                            if (radioOneByOne.equals(ReasonValue)) {
                                //    System.out.println("inside 3 radio buttons");
                                MobileElement radioButton = (MobileElement) QXClient.get().driver().findElement(By.xpath("//android.widget.RadioButton[@text='" + radioOneByOne + "']"));
                                QXClient.get().gestures().waitAndClickElementisVisible(radioButton);
                                System.out.println(ItemNameValue+" "+"ItemNameValue"+" "+ReasonValue+"===============>ReasonValue");
                                Thread.sleep(2000);
                                QXClient.get().gestures().waitAndClickElementisVisible(submit);
                                // break;
                            }

                            else if(radioOneByOne.equals(HuFullItem1) && ReasonValue.equals("HuFullOrPalletFull"))
                            {
                                //  System.out.println(HuFullItem1+"===============HuFullItem1");
                                MobileElement radioButton = (MobileElement) QXClient.get().driver().findElement(By.xpath("//android.widget.RadioButton[@text='" + radioOneByOne + "']"));
                                QXClient.get().gestures().waitAndClickElementisVisible(radioButton);
                                System.out.println(ItemNameValue+" "+"ItemNameValue"+" "+HuFullItem1+"===============>ReasonValue");
                                Thread.sleep(2000);
                                QXClient.get().gestures().waitAndClickElementisVisible(submit);
                                Thread.sleep(2000);
                                VerifyDispatchTypeAndClosePalletOrHU();

                            }
                        }
                        catch (Exception e)
                        {
                            break;
                        }
                    }
                    //  c++;
                }



            }
            //  System.out.println(actionedItem+"==============actionedItem");
            //     System.out.println(itms+"====================itms");


            if (!actionedItem.equals(itms)){
                //   System.out.println("inside first for loop");
                // System.out.println("inside main if  actioned item");
                ItemName = (MobileElement) QXClient.get().driver().findElement(By.xpath("//android.widget.TextView[@text='" + itms + "']"));

                Thread.sleep(500);
                QXClient.get().gestures().waitAndClickElementisVisible(ItemName);

                Thread.sleep(100);
                try {
                    QXClient.get().gestures().clickOnElement(Verified);
                } catch (Exception e) {
                    QXClient.get().gestures().waitAndClickElementisVisible(IncorrectBinYes);
                    QXClient.get().gestures().waitAndClickElementisVisible(Verified);

                }
                Thread.sleep(200);

                QXClient.get().gestures().waitAndClickElementisVisible(CompletePick);
                //   System.out.println("caselot size is============>" + caseLotNum);
                Thread.sleep(2000);
                for (int j = 0; j < caseLotNum; j++) {
                    QXClient.get().gestures().waitAndClickElementisVisible(plus);
                    QXClient.get().report().info("adding case slot quantity");
                    Thread.sleep(1000);
                }
                Thread.sleep(200);
                QXClient.get().gestures().waitAndClickElementisVisible(confirm);
                QXClient.get().report().info("Finally click on confirm");
                Thread.sleep(1000);
            }

        }
        try
        {
            if(closeHU.isDisplayed())
            {
                Thread.sleep(1000);
                VerifyDispatchTypeAndClosePalletOrHU();
            }
        }
        catch (Exception e)
        {
            Thread.sleep(1000);
            ClickONViewHuOrViewPallet();
            VerifyDispatchTypeAndClosePalletOrHU();
        }

    }
    //===================================================================================================================
    //hu full
    public  void ClickItemOneByoneBoxAndPalletTypeInvalidQtyDTFoRHUfullORPalletFull(DataTable dataTable) throws InterruptedException {

        List<Map<String, String>> pickerItemsDT = dataTable.asMaps();
        int k = 0;
        int radiocount=0;
//    for(String  setItems:deliveryAllItemsPickerAl)
//    {
//
//        System.out.println(setItems+" "+k++);
//    }
        int caseLotNum=0;
        MobileElement ItemName = null;
        for (String itms : deliveryAllItemsPickerAl) {
            int c=0;
            String actionedItem = "";
            for (int i = 0; i < pickerItemsDT.size(); i++) {

                Map<String, String> PickerItemOneByOne = pickerItemsDT.get(c);//data table

                String ItemNameValue = PickerItemOneByOne.get("ItemName");
                String ReasonValue = PickerItemOneByOne.get("Reason");
                int RemoveQuantityValue = Integer.parseInt(PickerItemOneByOne.get("RemoveQuantity"));

                //   Thread.sleep(3500);

                ItemName = (MobileElement) QXClient.get().driver().findElement(By.xpath("//android.widget.TextView[@text='" + itms + "']"));
                MobileElement CaselotQuantity = (MobileElement) QXClient.get().driver().findElement(By.xpath("//android.widget.TextView[@resource-id='com.dmartlabs.pwp:id/txt_lip_product_name' and @text='" + itms + "']/parent::android.view.ViewGroup[@resource-id='com.dmartlabs.pwp:id/cl_lip_parent']/descendant::android.widget.TextView[@resource-id='com.dmartlabs.pwp:id/txt_lip_boxes_value']"));

                caseLotNum = Integer.parseInt(CaselotQuantity.getText().trim());

                if (ItemNameValue.equals(itms)) {
                    //   System.out.println("inside second for loop");
                    Thread.sleep(1000);

                    QXClient.get().gestures().waitAndClickElementisVisible(ItemName);

                    Thread.sleep(100);
                    QXClient.get().report().info("Clicking on item Name" + "===========>" + itms);
                    try {
                        QXClient.get().gestures().clickOnElement(Verified);
                    } catch (Exception e) {
                        QXClient.get().gestures().waitAndClickElementisVisible(IncorrectBinYes);
                        QXClient.get().gestures().waitAndClickElementisVisible(Verified);

                    }

                    System.out.println("item successfully picked" + "==================>" + itms);

                    Thread.sleep(200);

                    QXClient.get().gestures().waitAndClickElementisVisible(CompletePick);

                    actionedItem = itms;

                    for (int j = 0; j < caseLotNum - RemoveQuantityValue; j++) {
                        QXClient.get().gestures().waitAndClickElementisVisible(plus);
                        Thread.sleep(200);
                        QXClient.get().report().info("adding case slot quantity");
                    }
                    QXClient.get().gestures().waitAndClickElementisVisible(confirm);
                    QXClient.get().report().info("Finally click on confirm");
                    Thread.sleep(100);

                    ArrayList<String> AllRadioList = new ArrayList<>();

                    for (int n = 0; n < AllRadioButtons.size(); n++) {
                        AllRadioList.add(AllRadioButtons.get(n).getText());
                        //    System.out.println(AllRadioButtons.get(n).getText() + n);
                    }

                    for (String radioOneByOne : AllRadioList) {
                        int j=0;
                        if (radioOneByOne.equals(HuFullItem1)&&ReasonValue.equals("HuFullOrPalletFull")) {
                            System.out.println("inside 3 radio buttons");
                            MobileElement radioButton = (MobileElement) QXClient.get().driver().findElement(By.xpath("//android.widget.RadioButton[@text='" + radioOneByOne + "']"));
                            QXClient.get().gestures().waitAndClickElementisVisible(radioButton);
                            System.out.println("Incorrect Qty Item is==============>" + radioOneByOne);
                            Thread.sleep(2000);
                            QXClient.get().gestures().waitAndClickElementisVisible(submit);
                            VerifyDispatchTypeAndClosePalletOrHU();

                        }
                    }
                }
                c++;

            }

            if (!actionedItem.equals(itms)){
                System.out.println("inside first for loop");
                System.out.println("inside main if  actioned item");
                ItemName = (MobileElement) QXClient.get().driver().findElement(By.xpath("//android.widget.TextView[@text='" + itms + "']"));

                Thread.sleep(1000);
                QXClient.get().gestures().waitAndClickElementisVisible(ItemName);

                Thread.sleep(100);
                try {
                    QXClient.get().gestures().clickOnElement(Verified);
                } catch (Exception e) {
                    QXClient.get().gestures().waitAndClickElementisVisible(IncorrectBinYes);
                    QXClient.get().gestures().waitAndClickElementisVisible(Verified);

                }
                Thread.sleep(200);

                QXClient.get().gestures().waitAndClickElementisVisible(CompletePick);
                System.out.println("caselot size is============>" + caseLotNum);
                Thread.sleep(2000);
                for (int j = 0; j < caseLotNum; j++) {
                    QXClient.get().gestures().waitAndClickElementisVisible(plus);
                    QXClient.get().report().info("adding case slot quantity");
                    Thread.sleep(1000);
                }
                Thread.sleep(200);
                QXClient.get().gestures().waitAndClickElementisVisible(confirm);
                QXClient.get().report().info("Finally click on confirm");
                Thread.sleep(1000);
            }

        }



    }


    //=======================================================================================
    @FindBy(xpath = "//android.widget.ImageView[@resource-id='com.dmartlabs.pwp:id/iv_lip_remote_sync']")
    private  MobileElement sync;

    @FindBy(xpath = "//android.widget.ImageView[@resource-id='com.dmartlabs.pwp:id/iv_fch_wifi_off_signal']")
    private  MobileElement wifiSignalOff;

    @FindBy(id="com.dmartlabs.pwp:id/txt_fasd_title")
    private  MobileElement noNetworktitle;
    @FindBy(id="com.dmartlabs.pwp:id/btn_fasd_ok")
    private  MobileElement NoNetworkOk;

    public  void ClickItemOneByoneBoxAndPalletTypeInvalidQtyDTInOfflineMode(DataTable dataTable) throws InterruptedException {

        QXClient.get().gestures().toggleWiFi();

        Thread.sleep(1000);

        List<Map<String, String>> pickerItemsDT = dataTable.asMaps();
        int k = 0;
        int radiocount=0;
        for(String  setItems:deliveryAllItemsPickerAl)
        {

            System.out.println(setItems+" "+k++);
        }
        int caseLotNum=0;
        MobileElement ItemName = null;
        for (String itms : deliveryAllItemsPickerAl) {

            QXClient.get().gestures().waitForElementToVisible(wifiSignalOff);
            QXClient.get().gestures().isElementPresent(wifiSignalOff);
            System.out.println("======================>"+"wifi is off");
            QXClient.get().report().info("======================>"+"wifi is off");
            QXClient.get().report().info(wifiSignalOff.getText());

            //  int c=0;
            String actionedItem = "";
            for (int i = 0; i < pickerItemsDT.size(); i++) {

                Map<String, String> PickerItemOneByOne = pickerItemsDT.get(i);//data table

                String ItemNameValue = PickerItemOneByOne.get("ItemName");
                String ReasonValue = PickerItemOneByOne.get("Reason");
                int RemoveQuantityValue = Integer.parseInt(PickerItemOneByOne.get("RemoveQuantity"));
                Thread.sleep(500);
                try {
                    ItemName = (MobileElement) QXClient.get().driver().findElement(By.xpath("//android.widget.TextView[@text='" + itms + "']"));

                }
                catch (NoSuchElementException e)

                {
                    break;
                }
                MobileElement CaselotQuantity = (MobileElement) QXClient.get().driver().findElement(By.xpath("//android.widget.TextView[@resource-id='com.dmartlabs.pwp:id/txt_lip_product_name' and @text='" + itms + "']/parent::android.view.ViewGroup[@resource-id='com.dmartlabs.pwp:id/cl_lip_parent']/descendant::android.widget.TextView[@resource-id='com.dmartlabs.pwp:id/txt_lip_boxes_value']"));

                caseLotNum = Integer.parseInt(CaselotQuantity.getText().trim());

                if (ItemNameValue.equals(itms))
                {

                    //   System.out.println("inside second for loop");
                    Thread.sleep(1000);

                    QXClient.get().gestures().waitAndClickElementisVisible(ItemName);

                    Thread.sleep(100);
                    QXClient.get().report().info("Clicking on item Name" + "===========>" + itms);
                    try {
                        QXClient.get().gestures().clickOnElement(Verified);
                    } catch (Exception e) {
                        QXClient.get().gestures().waitAndClickElementisVisible(IncorrectBinYes);
                        QXClient.get().gestures().waitAndClickElementisVisible(Verified);

                    }

                    //         System.out.println("item successfully picked" + "==================>" + itms);

                    Thread.sleep(200);

                    QXClient.get().gestures().waitAndClickElementisVisible(CompletePick);

                    actionedItem = itms;

                    for (int j = 0; j < caseLotNum - RemoveQuantityValue; j++) {
                        QXClient.get().gestures().waitAndClickElementisVisible(plus);
                        Thread.sleep(200);
                        QXClient.get().report().info("adding case slot quantity");
                    }
                    QXClient.get().gestures().waitAndClickElementisVisible(confirm);
                    QXClient.get().report().info("Finally click on confirm");
                    Thread.sleep(100);

                    ArrayList<String> AllRadioList = new ArrayList<>();

                    for (int n = 0; n < AllRadioButtons.size(); n++) {
                        AllRadioList.add(AllRadioButtons.get(n).getText());
                        //    System.out.println(AllRadioButtons.get(n).getText() + n);
                    }

                    for (String radioOneByOne : AllRadioList) {
                        // int j=0;
                        try {
                            if (radioOneByOne.equals(ReasonValue)) {
                                //    System.out.println("inside 3 radio buttons");
                                MobileElement radioButton = (MobileElement) QXClient.get().driver().findElement(By.xpath("//android.widget.RadioButton[@text='" + radioOneByOne + "']"));
                                QXClient.get().gestures().waitAndClickElementisVisible(radioButton);
                                System.out.println(ItemNameValue+" "+"ItemNameValue"+" "+ReasonValue+"===============>ReasonValue");
                                Thread.sleep(2000);
                                QXClient.get().gestures().waitAndClickElementisVisible(submit);
                                // break;
                            }

                            else if(radioOneByOne.equals(HuFullItem1) && ReasonValue.equals("HuFullOrPalletFull"))
                            {
                                //  System.out.println(HuFullItem1+"===============HuFullItem1");
                                MobileElement radioButton = (MobileElement) QXClient.get().driver().findElement(By.xpath("//android.widget.RadioButton[@text='" + radioOneByOne + "']"));
                                QXClient.get().gestures().waitAndClickElementisVisible(radioButton);
                                System.out.println(ItemNameValue+" "+"ItemNameValue"+" "+HuFullItem1+"===============>ReasonValue");
                                Thread.sleep(2000);
                                QXClient.get().gestures().waitAndClickElementisVisible(submit);
                                Thread.sleep(2000);
                                //   VerifyDispatchTypeAndClosePalletOrHU();
                                pickerBoxAndPalletType11Page.VerifyDispatchTypeAndClosePalletOrHUInOfflineMode();
                                Thread.sleep(1000);
                                QXClient.get().gestures().toggleWiFi();

                                Thread.sleep(1000);
                            }
                        }
                        catch (Exception e)
                        {
                            break;
                        }
                    }
                    //  c++;
                }



            }
            //  System.out.println(actionedItem+"==============actionedItem");
            //     System.out.println(itms+"====================itms");


            if (!actionedItem.equals(itms)){
                //   System.out.println("inside first for loop");
                // System.out.println("inside main if  actioned item");
                Thread.sleep(1000);

                ItemName = (MobileElement) QXClient.get().driver().findElement(By.xpath("//android.widget.TextView[@text='" + itms + "']"));

                Thread.sleep(1000);
                QXClient.get().gestures().waitAndClickElementisVisible(ItemName);

                Thread.sleep(100);
                try {
                    QXClient.get().gestures().clickOnElement(Verified);
                } catch (Exception e) {
                    QXClient.get().gestures().waitAndClickElementisVisible(IncorrectBinYes);
                    QXClient.get().gestures().waitAndClickElementisVisible(Verified);

                }
                Thread.sleep(200);

                QXClient.get().gestures().waitAndClickElementisVisible(CompletePick);
                //   System.out.println("caselot size is============>" + caseLotNum);
                Thread.sleep(2000);
                for (int j = 0; j < caseLotNum; j++) {
                    QXClient.get().gestures().waitAndClickElementisVisible(plus);
                    QXClient.get().report().info("adding case slot quantity");
                    Thread.sleep(1000);
                }
                Thread.sleep(200);
                QXClient.get().gestures().waitAndClickElementisVisible(confirm);
                QXClient.get().report().info("Finally click on confirm");
                Thread.sleep(1000);
            }

        }
        try
        {
            if(closeHU.isDisplayed())
            {
                Thread.sleep(1000);

                //  VerifyDispatchTypeAndClosePalletOrHU();
                pickerBoxAndPalletType11Page.VerifyDispatchTypeAndClosePalletOrHUInOfflineMode();

            }
        }
        catch (Exception e)
        {
            Thread.sleep(1000);
            ClickONViewHuOrViewPallet();
            pickerBoxAndPalletType11Page.VerifyDispatchTypeAndClosePalletOrHUInOfflineMode();
        }

    }



//==============================================================================================

    public  void CloseHUPalletType() throws InterruptedException {

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
        Thread.sleep(2000);
        QXClient.get().gestures().waitAndClickElementisVisible(CloseHuYes);
        QXClient.get().report().info("successfully clicked on close hu yes");
        Thread.sleep(500);
        try {
            QXClient.get().gestures().isElementPresent(printHulabelText);
            QXClient.get().gestures().waitAndClickElementisVisible(withoutPrinter);
        } catch (Exception e) {
            System.out.println("inside catch");
            QXClient.get().gestures().waitAndClickElementisVisible(closeHUxpath);
            QXClient.get().report().info("After all items picking clicking on close Hu");
            //closeHUText.click();
            Thread.sleep(500);
            QXClient.get().gestures().waitAndClickElementisVisible(CloseHuYes);
            QXClient.get().gestures().isElementPresent(printHulabelText);
            QXClient.get().gestures().waitAndClickElementisVisible(withoutPrinter);
        }

//scan hu label titlee
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

//=========================================================================================

    //click on view HU
    @FindBy(xpath = "//android.widget.TextView[@resource-id='com.dmartlabs.pwp:id/txt_pl_view_hu']")
    private  MobileElement ClickOnViewHU;

    public  void ClickONViewHuOrViewPallet() throws InterruptedException {
        QXClient.get().gestures().waitAndClickElementisVisible(ClickOnViewHU);
        Thread.sleep(100);
        QXClient.get().report().info("HU is successfully displayed");
    }


    //=======================================================================================



    public  void VerifyDispatchTypeAndClosePalletOrHU() throws InterruptedException {

        String ActualDispatchType = QXClient.getDispatchType();
        System.out.println(ActualDispatchType+"======is ActualDispatchType");

        if(ActualDispatchType.equals(ExpectedBoxTypeDispatch))
        {
            System.out.println(ExpectedBoxTypeDispatch+"==========+is ExpectedBoxTypeDispatch");
            ClosePalletBoxType();
        }
        else if(ActualDispatchType.equals(ExpectedPalletTypeDispatch))
        {
            System.out.println(ExpectedPalletTypeDispatch+"==========+is ExpectedPalletTypeDispatch");
            CloseHUPalletType();
        }
        else
        {
            System.out.println("invalid dispatch type ");
        }
    }


    //=============================================================================
    @FindBy(id="com.dmartlabs.pwp:id/txt_pl_view_hu")
    private  MobileElement ViewPallet;
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

    public  void ClosePalletBoxType() throws InterruptedException {

        //view pallet
        //   QXClient.get().gestures().waitAndClickElementisVisible(ViewPallet);

//close pallet full
        QXClient.get().gestures().isElementPresent(palletFull);
        QXClient.get().report().info("palletFull page is displayed");

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
            Thread.sleep(100);
            QXClient.get().gestures().isElementPresent(moveToDispatchTitle);
            QXClient.get().report().info(dockName.getText());
        }
        System.out.println(dockName.getText()+"=========>"+dockName);
        QXClient.get().gestures().waitAndClickElementisVisible(continuePickBox);

    }

//================================================================================================
//@FindBy(xpath = "//android.widget.TextView[@resource-id='com.dmartlabs.pwp:id/txt_pl_view_hu']")
//private  MobileElement ClickOnViewHU;

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
    @FindBy(xpath = "//android.widget.Button[@resource-id='com.dmartlabs.pwp:id/btn_vhu_close_hu']")
    private  MobileElement CloseHU;
    //=================================================================================================
    @FindBy(xpath = "//android.widget.Button[@resource-id='com.dmartlabs.pwp:id/btn_vhu_close_hu']")
    private  MobileElement closeHUxpath;

    @FindBy(xpath = "//android.widget.TextView[@text='Print HU label']")
    private  MobileElement printHulabelText;

//


























//    public  void ClickItemOneByoneBoxAndPalletTypeInvalidQty() throws InterruptedException {
//
//            QXClient.get().report().info("HU Titlle is displayed");
//            QXClient.get().gestures().isElementPresent(NumberOfItems);
//            Thread.sleep(100);
//
//            QXClient.get().gestures().isElementPresent(CloseHU);
//            QXClient.get().report().info("CloseHu button is displayyed");
//
//            QXClient.get().report().info(NumberOfItems.getText() + " " + "no.of items present");
//            System.out.println(NumberOfItems.getText() + " " + "no.of items present");
//Thread.sleep(2000);
//            QXClient.get().gestures().waitAndClickElementisVisible(closeHU);
//            QXClient.get().report().info("After all items picking clicking on close Hu");
//            //closeHUText.click();
//            Thread.sleep(2000);
//            QXClient.get().gestures().waitAndClickElementisVisible(CloseHuYes);
//            QXClient.get().report().info("successfully clicked on close hu yes");
//            Thread.sleep(500);
//            try {
//                QXClient.get().gestures().isElementPresent(printHulabelText);
//                QXClient.get().gestures().waitAndClickElementisVisible(withoutPrinter);
//            } catch (Exception e) {
//                System.out.println("inside catch");
//                QXClient.get().gestures().waitAndClickElementisVisible(closeHUxpath);
//                QXClient.get().report().info("After all items picking clicking on close Hu");
//                //closeHUText.click();
//                Thread.sleep(500);
//                QXClient.get().gestures().waitAndClickElementisVisible(CloseHuYes);
//                QXClient.get().gestures().isElementPresent(printHulabelText);
//                QXClient.get().gestures().waitAndClickElementisVisible(withoutPrinter);
//            }
//
////scan hu label titlee
//            QXClient.get().gestures().isElementPresent(ScanHulabeltitle);
//            QXClient.get().report().info(" scan HU label is present");
//
//
//            QXClient.get().gestures().waitAndClickElementisVisible(withoutScan);
//            QXClient.get().report().info("successfully clicked on without scan");
//            Thread.sleep(200);
//            QXClient.get().gestures().waitAndClickElementisVisible(HuVerified);
//            QXClient.get().report().info("successsfully clicked on HU verified");
//            Thread.sleep(200);
//
//            QXClient.get().gestures().isElementPresent(MoveToDispatchTitle);
//            QXClient.get().report().info("Move to dispatch Title is present");
//
//            QXClient.get().gestures().waitAndClickElementisVisible(ContinuePicking);
//            QXClient.get().report().info("Successfully cliked on continue picking");
//
//        }
//
}

//====================================================================================================

//invalid qty offfline one obne by one click
//     QXClient.get().gestures().isElementPresent(IncorrectBinMsg);
//    QXClient.get().report().info(IncorrectBinMsg.getText());
//    System.out.println(IncorrectBinMsg.getText());


//    System.out.println(ItemNameValue + "=========>ItemNameValue");
//               try {
//                   System.out.println(ItemName.getText() + "============>ItemName.getText()");
//               }
//               catch (Exception e)
//               {
//                   ItemName = (MobileElement) QXClient.get().driver().findElement(By.xpath("//android.widget.TextView[@text='" + itemText + "']"));
//                   System.out.println(ItemName.getText() + "============>ItemName.getText()");
//               }


