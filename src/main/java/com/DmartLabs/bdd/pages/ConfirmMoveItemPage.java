package com.DmartLabs.bdd.pages;

import com.DmartLabs.commonutils.Gestures;
import com.DmartLabs.commonutils.QXClient;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class ConfirmMoveItemPage {

    public ConfirmMoveItemPage(){
        PageFactory.initElements(new AppiumFieldDecorator(QXClient.get().driver()), this);
    }

    @FindBy(id = "com.dmartlabs.pwp:id/txt_fdsid_dialog_title")
    private MobileElement confirmMoveItemsDialougeTitle;

    @FindBy(id = "com.dmartlabs.pwp:id/btn_fdsid_ok")
    private MobileElement okBtn;

    Gestures gestures;

    public void confirmMoveItems(){
        gestures = QXClient.get().gestures();
        Assert.assertTrue(gestures.isElementPresent(confirmMoveItemsDialougeTitle));
        okBtn.click();
    }

}
