package com.DmartLabs.bdd.pages;

import com.DmartLabs.commonutils.Gestures;
import com.DmartLabs.commonutils.QXClient;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import java.util.Map;

public class LoginPage {

    public LoginPage(){
        PageFactory.initElements(new AppiumFieldDecorator(QXClient.get().driver()), this);
    }

    @FindBy(id = "com.dmartlabs.pwp:id/txt_login_title")
    private MobileElement loginTitle;

    @FindBy(id="com.dmartlabs.pwp:id/edt_username")
    private MobileElement userNameTextField;

    @FindBy(id="com.dmartlabs.pwp:id/btn_lso_next")
    private MobileElement nextBtn;

    @FindBy(id="com.dmartlabs.pwp:id/edt_password")
    private MobileElement passwordTextField;

    @FindBy(id="com.dmartlabs.pwp:id/btn_login")
    private MobileElement loginBtn;

    public void loginToPWP(Map<String, String> loginCredential){
        String userId = loginCredential.get("userId");
        String password = loginCredential.get("password");
        QXClient.get().report().info("Emp Id is : "+userId);
        QXClient.get().report().info("password is : "+password);

        Gestures gestures = QXClient.get().gestures();
        gestures.waitForElementToVisible(userNameTextField);
        userNameTextField.sendKeys(userId);
        nextBtn.click();
        gestures.waitForElementToVisible(passwordTextField);
        passwordTextField.sendKeys(password);
        loginBtn.click();
    }

    public void loginTitleIsDisplayed(){
        boolean result = QXClient.get().gestures().isElementPresent(loginTitle);
        if (result)
            QXClient.get().report().pass("Login Page is displayed");
        else
            QXClient.get().report().fail("Login Page is not displayed");
    }

}
