package com.DmartLabs.bdd.pages;

import com.DmartLabs.commonutils.QXClient;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class FloorWalkPage {

    public FloorWalkPage(){
        PageFactory.initElements(new AppiumFieldDecorator(QXClient.get().driver()), this);
    }

    @FindBy(xpath = "//android.widget.TextView[@text='Floor Walk Summary']")
    private MobileElement floorwalkSummaryTitle;

    @FindBy(xpath = "//android.widget.TextView[@text='Floor Walk Summary']/following-sibling::android.view.View[1]")
    private MobileElement floorwalk;

    @FindBy(xpath = "//android.widget.Button")
    private MobileElement backBtn;

    public void verifyFloorWalkPage() {
        Assert.assertTrue(QXClient.get().gestures().isElementPresent(floorwalkSummaryTitle), "Floor Walk Summary Page is not displayed");
    }

    public void verifyFloorWalkCreated() {
        Assert.assertTrue(QXClient.get().gestures().isElementPresent(floorwalk),"FloorWalk is not created");
    }

    public void verifyFloorwalkStatus(String status) {
        Assert.assertTrue(floorwalk.getText().contains(status));
    }

    public void verifyOpenTaskInFloorwalk(int size) {
        Assert.assertTrue(floorwalk.getText().contains("Open "+size));
    }

    public void clickOnBackBtn() {
        backBtn.click();
    }
}
