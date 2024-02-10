package com.DmartLabs.bdd.pages;

import com.DmartLabs.commonutils.Gestures;
import com.DmartLabs.commonutils.QXClient;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.Map;

public class ItemsExceptionPage {

    public ItemsExceptionPage(){
        PageFactory.initElements(new AppiumFieldDecorator(QXClient.get().driver()), this);
    }

    @FindBy(id = "com.dmartlabs.pwp:id/txt_fbsd_dialog_title")
    private MobileElement selectExceptionTypeDialougeTitle;

    @FindBy(id = "com.dmartlabs.pwp:id/txt_fibe_title")
    private MobileElement cannotAddExceptionDialougeBox;

    @FindBy(id = "com.dmartlabs.pwp:id/btn_fibe_ok")
    private MobileElement okBtn;

    @FindBy(id = "com.dmartlabs.pwp:id/ib_huvel_back")
    private MobileElement backBtn;

    @FindBy(id = "com.dmartlabs.pwp:id/txt_huvel_title")
    private MobileElement itemExceptionPageTitle;

    @FindBy(xpath = "//android.widget.Button[@text='Damaged']")
    private MobileElement damagedButton;

    @FindBy(xpath = "//android.widget.Button[@text='Short']")
    private MobileElement shortButton;

    @FindBy(xpath = "//android.widget.Button[@text='Other']")
    private MobileElement otherButton;

    @FindBy(xpath = "//android.widget.Button[@text='Cancel']")
    private MobileElement cancelButton;

    @FindBy(id = "com.dmartlabs.pwp:id/fab_huvel_add_exception")
    private MobileElement addExceptionBtn;

    @FindBy(id = "com.dmartlabs.pwp:id/cv_laei_parent")
    private MobileElement exceptionCard;

    private Gestures gestures;

    public void addExceptionToSameItem(Map<String, String> exception){
        if (itemExceptionPageTitle.getText().equals(exception.get("itemNames"))) {
            addExceptionBtn.click();
            if (exception.get("exceptionType").equals("Damaged")) {
                QXClient.get().report().info("Exception Type is Damaged");
                damagedButton.click();
                DamagedExceptionPage damagedExceptionPage = new DamagedExceptionPage();
                damagedExceptionPage.isDamagedExceptionPageDisplayed();
                damagedExceptionPage.enterDetails(exception.get("damagedBoxes"), exception.get("comments"));
            } else if (exception.get("exceptionType").equals("Short")) {
                QXClient.get().report().info("Exception Type is Short");
                shortButton.click();
                ShortExceptionPage shortExceptionPage = new ShortExceptionPage();
                shortExceptionPage.isShortExceptionPageDisplayed();
                shortExceptionPage.enterDetails(exception.get("damagedBoxes"), exception.get("comments"));
            } else if (exception.get("exceptionType").equals("Other")) {
                QXClient.get().report().info("Exception Type is Other");
                otherButton.click();
                OtherExceptionPage otherExceptionPage = new OtherExceptionPage();
                otherExceptionPage.isOtherExceptionPageDisplayed();
                otherExceptionPage.enterDetails(exception.get("damagedBoxes"), exception.get("comments"));
            } else {
                QXClient.get().report().info("Exception Type is not given and Loader clicked on Cancel button");
                cancelButton.click();
            }
        }
        else {
            return;
        }

    }

    public void isCannotAddExceptionDialougeBoxDisplayed(){
        gestures = QXClient.get().gestures();
        boolean result = gestures.isElementPresent(cannotAddExceptionDialougeBox);
        if (result)
            QXClient.get().report().pass("Cannot Add Exception dialouge box is displayed");
        else
            QXClient.get().report().fail("Cannot Add Exception dialouge box is not displayed");

        Assert.assertTrue(result,"Cannot Add Exception dialouge box is not displayed");
        okBtn.click();
    }

    public void selectExceptionType(Map<String, String> exception) {
        gestures = QXClient.get().gestures();
//        boolean result = gestures.isElementPresent(selectExceptionTypeDialougeTitle);
//        if (!selectExceptionTypeDialougeTitle.isDisplayed()) {
//            addExceptionToSameItem(exception);
//            return;
//        }

        try {
            selectExceptionTypeDialougeTitle.isDisplayed();
        }catch (NoSuchElementException nse){
            addExceptionToSameItem(exception);
            return;
        }

        boolean result = gestures.isElementPresent(selectExceptionTypeDialougeTitle);

        if (result)
            QXClient.get().report().pass("Select Exception Type Dialouge Title is displayed");
        else
            QXClient.get().report().fail("Select Exception Type Dialouge Title is not displayed");

        Assert.assertTrue(result,"select exception type dialouge box is not displayed");
        if (exception.get("exceptionType").equals("Damaged")){
            QXClient.get().report().info("Exception Type is Damaged");
            damagedButton.click();
            DamagedExceptionPage damagedExceptionPage = new DamagedExceptionPage();
            damagedExceptionPage.isDamagedExceptionPageDisplayed();
            damagedExceptionPage.enterDetails(exception.get("damagedBoxes"), exception.get("comments"));
        }

        else if (exception.get("exceptionType").equals("Short")){
            QXClient.get().report().info("Exception Type is Short");
            shortButton.click();
            ShortExceptionPage shortExceptionPage = new ShortExceptionPage();
            shortExceptionPage.isShortExceptionPageDisplayed();
            shortExceptionPage.enterDetails(exception.get("damagedBoxes"), exception.get("comments"));
        }

        else if (exception.get("exceptionType").equals("Other")){
            QXClient.get().report().info("Exception Type is Other");
            otherButton.click();
            OtherExceptionPage otherExceptionPage = new OtherExceptionPage();
            otherExceptionPage.isOtherExceptionPageDisplayed();
            otherExceptionPage.enterDetails(exception.get("damagedBoxes"), exception.get("comments"));
        }

        else{
            QXClient.get().report().info("Exception Type is not given and Loader clicked on Cancel button");
            cancelButton.click();
        }

    }

    public void isItemExceptionTitleDisplayed() {
        boolean result = gestures.isElementPresent(itemExceptionPageTitle);
        if (result)
            QXClient.get().report().pass("Item Exception Page is displayed");
        else 
            QXClient.get().report().fail("Item Exception Page is not displayed");
        
        Assert.assertTrue(gestures.isElementPresent(itemExceptionPageTitle));
    }

    public void isExceptionCardDisplayed() {
        boolean result = gestures.isElementPresent(exceptionCard);
        if (result)
            QXClient.get().report().pass("Exception for item is displayed in Item's Exception Page");
        else
            QXClient.get().report().fail("Exception for item is not displayed in Item's Exception Page");

        Assert.assertTrue(gestures.isElementPresent(exceptionCard));
    }

    public void clickOnBackBtn(){
        backBtn.click();
    }

}
