package com.DmartLabs.bdd.pages;

import com.DmartLabs.commonutils.Gestures;
import com.DmartLabs.commonutils.QXClient;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class OtherExceptionPage {

    public OtherExceptionPage(){
        PageFactory.initElements(new AppiumFieldDecorator(QXClient.get().driver()), this);
    }

    @FindBy(id = "com.dmartlabs.pwp:id/txt_hure_report_issue_title")
    private MobileElement otherExceptionTitle;

    @FindBy(id = "com.dmartlabs.pwp:id/edt_actual_qty")
    private MobileElement other;

    @FindBy(id = "com.dmartlabs.pwp:id/edt_hure_comment")
    private MobileElement comments;

    @FindBy(id = "com.dmartlabs.pwp:id/btn_hure_cancel")
    private MobileElement cancelBtn;

    @FindBy(id = "com.dmartlabs.pwp:id/btn_hure_submit")
    private MobileElement submitBtn;

    @FindBy(id = "com.dmartlabs.pwp:id/textinput_error")
    private MobileElement otherErrorMsg;

    private Gestures gestures;

    public void isOtherExceptionPageDisplayed(){
        gestures = QXClient.get().gestures();
        boolean result = gestures.isElementPresent(otherExceptionTitle);
        if (result)
            QXClient.get().report().pass("Other Exception Page is displayed");
        else
            QXClient.get().report().fail("Other Exception Page is not displayed");

        Assert.assertTrue(result, "Other Exception Page is not displayed");
    }

    public void enterDetails(String quantity, String comments) {
        other.sendKeys(quantity);
        if (comments!=null)
            this.comments.sendKeys(comments);
        submitBtn.click();
    }

    public void verifyOtherErrorMessage() {
        boolean result = gestures.isElementPresent(otherErrorMsg);
        if (result)
            QXClient.get().report().pass( otherErrorMsg.getText()+" Error Message is displayed");
        else
            QXClient.get().report().fail("Error Message is not displayed");

        Assert.assertTrue(result,"Error Message is not displayed");
    }
}
