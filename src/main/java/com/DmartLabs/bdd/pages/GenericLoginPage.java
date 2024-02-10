package com.DmartLabs.bdd.pages;

import com.DmartLabs.commonutils.QXClient;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GenericLoginPage {


    public GenericLoginPage() {

        PageFactory.initElements(new AppiumFieldDecorator(QXClient.get().driver()), this);

    }

//declaration
    @FindBy(id = "com.dmartlabs.pwp:id/edt_username")
    public MobileElement username;
    @FindBy(id = "btn_lso_next")
    public MobileElement userNameNext;
    @FindBy(xpath = "//android.widget.EditText[@resource-id='com.dmartlabs.pwp:id/edt_password']")
    public MobileElement password;

    @FindBy(xpath = "//android.widget.Button[@resource-id='com.dmartlabs.pwp:id/btn_login']")
    public MobileElement login;

    @FindBy(id="com.dmartlabs.pwp:id/txt_fch_title")
    public  MobileElement pwpHome;
    //initilization


   //utilization
    public  void ClickOnLogin(String UserName,String PassWord)
    {
       QXClient.get().gestures().waitForElementToVisible(username);
        username.sendKeys(UserName);
        QXClient.get().report().info("Enter the UserName");
       QXClient.get().gestures().clickOnElement(userNameNext);
        QXClient.get().report().info("click on next");
        QXClient.get().gestures().waitForElementToVisible(password);
        password.sendKeys(PassWord);
        QXClient.get().report().info("enter password");
        QXClient.get().gestures().clickOnElement(login);
        QXClient.get().report().info("click on login");
    }
//==========================================================
    //generic clik on picker
//select picker
@FindBy(xpath = "//android.widget.TextView[@text='Picker']")
private MobileElement SelectPicker;
    @FindBy(xpath = "//android.widget.TextView[@resource-id='com.dmartlabs.pwp:id/txt_fch_title']")
    private  MobileElement PickerTitle;

    public void ClickOnPickerAndValidate() throws InterruptedException {
        Thread.sleep(2000);
        QXClient.get().gestures().clickOnElement(SelectPicker);
        QXClient.get().report().info("click on picker");
        QXClient.get().gestures().isElementPresent(PickerTitle);
        QXClient.get().report().info("picker title is displayed");
        System.out.println("picker title is successfully validated");
    }
    //==============================================================

    public void isPwpHomePageDisplayed() throws InterruptedException {
        QXClient.get().gestures().isElementPresent(pwpHome);
      //  QXClient.get().gestures().scrollVertically1(2);
        QXClient.get().report().info("pwp home page is displayed");

    }
}

