package com.DmartLabs.bdd.pages;

import com.DmartLabs.commonutils.Gestures;
import com.DmartLabs.commonutils.QXClient;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class ConsolidateHUPage {

    public ConsolidateHUPage(){
        PageFactory.initElements(new AppiumFieldDecorator(QXClient.get().driver()), this);
    }

    Gestures gestures;

    @FindBy(id = "com.dmartlabs.pwp:id/txt_dhpil_title")
    private MobileElement validation;

    @FindBy(id = "com.dmartlabs.pwp:id/cb_dhpil_show_all_items")
    private MobileElement selectAllCheckBox;

    @FindBy(id = "com.dmartlabs.pwp:id/btn_dhpil_move")
    private MobileElement moveBtn;

    @FindBy(id = "com.dmartlabs.pwp:id/txt_fshd_dialog_title")
    private MobileElement destinationHUDialougeBox;

    @FindBy(id = "com.dmartlabs.pwp:id/edt_fshd_hu_number")
    private MobileElement destinationHUNumberTextBox;

    @FindBy(id = "com.dmartlabs.pwp:id/btn_fshd_confirm")
    private MobileElement selectHUBtn;

    @FindBy(id = "com.dmartlabs.pwp:id/btn_fshd_back")
    private MobileElement backBtn;

    public void clickOnSelectAllCheckBox(){
        gestures = QXClient.get().gestures();
        Assert.assertTrue(gestures.isElementPresent(validation));
        selectAllCheckBox.click();

    }

    public void clickOnMoveButton(){
        moveBtn.click();
        Assert.assertTrue(gestures.isElementPresent(destinationHUDialougeBox));
    }

    public void provideDestinationHU_Number(String destionationHU){
        destinationHUNumberTextBox.sendKeys(destionationHU);
        selectHUBtn.click();
    }


}
