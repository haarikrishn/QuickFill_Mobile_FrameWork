package com.DmartLabs.bdd.pages;

import com.DmartLabs.commonutils.Gestures;
import com.DmartLabs.commonutils.QXClient;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class HomePage {

    public HomePage(){
        PageFactory.initElements(new AppiumFieldDecorator(QXClient.get().driver()), this);
    }

    Gestures gestures;

    @FindBy(id = "com.dmartlabs.pwp:id/txt_fch_title")
    private MobileElement homePage;

    @FindBy(xpath="//android.widget.TextView[@text='Picker']")
    private MobileElement pickerModule;

    @FindBy(xpath = "//android.widget.TextView[@text='Loader']")
    private MobileElement loaderModule;

    @FindBy(id = "com.dmartlabs.pwp:id/ib_fch_logout")
    private MobileElement logOutIcon;

    @FindBy(id = "com.dmartlabs.pwp:id/alertTitle")
    private MobileElement logoutAlertPanel;

    @FindBy(id = "android:id/button1")
    private MobileElement logoutYesBtn;

    @FindBy(id = "android:id/button2")
    private MobileElement logoutNoBtn;

    @FindBy(id = "com.dmartlabs.pwp:id/cl_parent")
    private MobileElement loggingOutPanel;

    public void isHomePageDisplayed(){
        gestures = QXClient.get().gestures();
        boolean result = gestures.isElementPresent(homePage);
        if (result)
            QXClient.get().report().pass("Home Page is displayed");
        else
            QXClient.get().report().fail("Home Page is not displayed");
        Assert.assertTrue(result,"Home Page is not displayed");
    }

    public void clickOnLoaderModule(){
        loaderModule.click();
    }

    public void clickOnPickerModule(){
        pickerModule.click();
    }

    public void logoutUser() throws InterruptedException {
        gestures = QXClient.get().gestures();
       // logOutIcon.click();
        Thread.sleep(200);
        gestures.waitAndClickElementisVisible(logOutIcon);
        Thread.sleep(200);
        gestures.waitForVisbilityOfWebElement(logoutAlertPanel);
    //    logoutYesBtn.click();
        Thread.sleep(200);
        gestures.waitAndClickElementisVisible(logoutYesBtn);
        Assert.assertTrue(loggingOutPanel.isDisplayed());
        LoginPage loginPage = new LoginPage();
        loginPage.loginTitleIsDisplayed();
    }

}
