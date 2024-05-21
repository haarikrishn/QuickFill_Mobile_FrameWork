package com.DmartLabs.bdd.pages;

import com.DmartLabs.commonutils.QXClient;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.*;

public class QF_RefillerOfflinePage {


    public QF_RefillerOfflinePage() {

        PageFactory.initElements(new AppiumFieldDecorator(QXClient.get().driver()), this);

    }

    //===============================================================================
    //scroll


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
        }
        else {

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

    public int[] getLocation(){
        System.out.println(ListOfItems.size()+"============>ListOfItems.size()");
        try {
            startY = ListOfItems.get(ListOfItems.size() - 2).getLocation().getY();//end y
        }
        catch (ArrayIndexOutOfBoundsException  e)
        {
            startY = ListOfItems.get(ListOfItems.size()).getLocation().getY();
        }

        endY = ListOfItems.get(0).getLocation().getY();
        return new int[]{startY, endY};
    }



    //   LinkedHashSet<String> deliveryAllItemsPickerAlNew = new LinkedHashSet<>();
    public  List<String>  getAllItemsNew(int[] location) throws InterruptedException {

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
        System.out.println(deliveryAllItemsPickerAl.size()+"==============>"+"deliveryAllItemsPickerAl.size()");
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
            }
            else {

            isScroll = false;
               }
    }


        else {

            isScroll = false;
        }
        Thread.sleep(2000);
        System.out.println("scroll downward ");
        QXClient.get().gestures().scrollVerticallyDevice12(xAxis, location[1], location[0], 1);
        Thread.sleep(500);
        return deliveryAllItemsPickerAl;

    }



   // ====================================================================================


        public void PrintAllIems()
        {
            int i=0;
         for(String  Items:deliveryAllItemsPickerAl)
         {
             System.out.println(Items+"====>"+i++);
         }

        }
    
        public  void completeTheTask() throws InterruptedException {
            Thread.sleep(2000);
        for (MobileElement item:ListOfItems){

            try {
                QXClient.get().gestures().waitAndClickElementisVisible(item);
            } catch (Exception e){
                completeTheTask();
            }
                Thread.sleep(4000);
            completeBtn.click();
                Thread.sleep(4000);
            confirmBtn.click();
                Thread.sleep(4000);
        }
        if (ListOfItems.size()>6) {
            completeTheTask();
        }


    }
}

