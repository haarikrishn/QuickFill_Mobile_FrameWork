package com.DmartLabs.bdd.pages;

import com.DmartLabs.commonutils.Gestures;
import com.DmartLabs.commonutils.QXClient;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class DamagedExceptionPage {

    public DamagedExceptionPage(){
        PageFactory.initElements(new AppiumFieldDecorator(QXClient.get().driver()), this);
    }

    @FindBy(id = "com.dmartlabs.pwp:id/txt_hure_report_issue_title")
    private MobileElement damagedExceptionTitle;

    @FindBy(id = "com.dmartlabs.pwp:id/edt_actual_qty")
    private MobileElement damagedBoxes;

    @FindBy(id = "com.dmartlabs.pwp:id/edt_hure_comment")
    private MobileElement comments;

    @FindBy(id = "com.dmartlabs.pwp:id/btn_hure_cancel")
    private MobileElement cancelBtn;

    @FindBy(id = "com.dmartlabs.pwp:id/btn_hure_submit")
    private MobileElement submitBtn;

    @FindBy(id = "com.dmartlabs.pwp:id/textinput_error")
    private MobileElement damagedBoxesErrorMsg;

    private Gestures gestures;

    public void isDamagedExceptionPageDisplayed(){
        gestures=QXClient.get().gestures();
        boolean result = gestures.isElementPresent(damagedExceptionTitle);
        if (result)
            QXClient.get().report().pass("Damaged Exception page is displayed");
        else
            QXClient.get().report().fail("Damaged Exception page is not displayed");

        Assert.assertTrue(result, "Damaged Exception page is not displayed");
    }

    public void enterDetails(String quantity, String comments) {
        damagedBoxes.sendKeys(quantity);
        if (comments!=null)
            this.comments.sendKeys(comments);
        submitBtn.click();
    }

    public void verifyDamagedBoxesErrorMessage() {
        gestures = QXClient.get().gestures();
        boolean result = gestures.isElementPresent(damagedBoxesErrorMsg);
        if (result)
            QXClient.get().report().pass( damagedBoxesErrorMsg.getText()+" Error Message is displayed");
        else
            QXClient.get().report().fail("Error Message is not displayed");

        Assert.assertTrue(result,"Error Message is not displayed");
    }
}
