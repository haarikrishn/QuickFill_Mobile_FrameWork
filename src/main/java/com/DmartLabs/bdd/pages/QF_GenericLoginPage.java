package com.DmartLabs.bdd.pages;

import com.DmartLabs.commonutils.QXClient;
import gherkin.lexer.Th;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class QF_GenericLoginPage {



    public QF_GenericLoginPage() {

        PageFactory.initElements(new AppiumFieldDecorator(QXClient.get().driver()), this);

    }
    Actions actions=new Actions(QXClient.get().driver());

@FindBy(xpath = "//android.widget.Button[@content-desc='NEXT']")
private MobileElement Next;

@FindBy(xpath = "//android.widget.Button[@content-desc='LOGIN']")

private MobileElement Login;
@FindBy(xpath = "//android.widget.ImageView[@content-desc='QuickFill']")
private MobileElement QfLogo;

    @FindBy(xpath = "//android.widget.ImageView[@content-desc='QuickFill\n" +
            "QuickFill']")
    private MobileElement QfLogo1;

@FindBy(xpath = "//android.widget.Button[@resource-id='com.android.permissioncontroller:id/permission_allow_foreground_only_button']")
private MobileElement WhileUsingtheApp;

@FindBy(id = "com.android.packageinstaller:id/perm_desc_root")
private MobileElement deviceLocationDialogueBox;

@FindBy(id = "com.android.packageinstaller:id/permission_allow_button")
private MobileElement allowDeviceLocBtn;

@FindBy(id = "com.android.packageinstaller:id/permission_deny_button")
private MobileElement denyDeviceLocBtn;

@FindBy(xpath = "//android.view.View[@content-desc='QuickFill']/android.view.View[1]")
private MobileElement home;

@FindBy(xpath = "//android.view.View[@text='find Finding Store']")
private MobileElement findStore;

    //utilization

    public  void ClickOnLogin(String UserName,String PassWord) throws InterruptedException {
        Thread.sleep(3000);
      //  QXClient.get().driver().switchTo().activeElement().sendKeys(UserName);
        actions.sendKeys(UserName).perform();

        Thread.sleep(3000);
QXClient.get().gestures().waitAndClickElementisVisible(Next);
Thread.sleep(3000);
//QXClient.get().driver().switchTo().activeElement().sendKeys(PassWord);
        actions.sendKeys(PassWord).perform();
Thread.sleep(3000);
QXClient.get().gestures().waitAndClickElementisVisible(Login);
Thread.sleep(3000);
//try {
//    QXClient.get().gestures().waitAndClickElementisVisible(QfLogo);
//} catch (Exception e){
    QXClient.get().gestures().waitAndClickElementisVisible(QfLogo1);
//}

//try {
//    QXClient.get().gestures().waitAndClickElementisVisible(WhileUsingtheApp);
//}
//catch (Exception e)
//{
    boolean result = QXClient.get().gestures().isElementPresent(deviceLocationDialogueBox);
    if (result){
        QXClient.get().gestures().waitAndClickElementisVisible(allowDeviceLocBtn);
    }
////    System.out.println(e.getMessage());
//}
QXClient.get().gestures().waitAndClickElementisVisible(home);
        Thread.sleep(1000);
//        try {
//            QXClient.get().gestures().waitAndClickElementisVisible(QfLogo);
//        } catch (Exception e){
            QXClient.get().gestures().waitAndClickElementisVisible(QfLogo1);
//        }

        Thread.sleep(10000);

//        QXClient.get().gestures().isElementPresent(findStore);

    }
    //==========================================================
//    //generic clik on picker
////select picker
//    @FindBy(xpath = "//android.widget.TextView[@text='Picker']")
//    private MobileElement SelectPicker;
//    @FindBy(xpath = "//android.widget.TextView[@resource-id='com.dmartlabs.pwp:id/txt_fch_title']")
//    private  MobileElement PickerTitle;
//
//    public void ClickOnPickerAndValidate() throws InterruptedException {
//        Thread.sleep(5000);
//        QXClient.get().gestures().clickOnElement(SelectPicker);
//        QXClient.get().report().info("click on picker");
//        QXClient.get().gestures().isElementPresent(PickerTitle);
//        QXClient.get().report().info("picker title is displayed");
//        System.out.println("picker title is successfully validated");
//    }
//    //==============================================================
//
//    public void isPwpHomePageDisplayed() throws InterruptedException {
//        QXClient.get().gestures().isElementPresent(pwpHome);
//        //  QXClient.get().gestures().scrollVertically1(2);
//        QXClient.get().report().info("pwp home page is displayed");
//
//    }
}

