package com.DmartLabs.bdd.pages;

import com.DmartLabs.commonutils.QXClient;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CreateTaskPage {

    public CreateTaskPage(){
        PageFactory.initElements(new AppiumFieldDecorator(QXClient.get().driver()), this);
    }

    @AndroidFindBy(accessibility="QuickFill")
    private MobileElement createTaskPageTitle;

    @FindBy(xpath = "//android.widget.Button[@text='Tasks']")
    private MobileElement taskBtn;

    @FindBy(className = "android.widget.EditText")
    private MobileElement searchBox;

    @FindBy(xpath = "//android.widget.Button[@text='REFILL']")
    private MobileElement refillTaskBtn;

    @FindBy(xpath = "//android.widget.Button[@text='BOARD']")
    private MobileElement priceboardTaskBtn;

    @FindBy(xpath = "//android.widget.Button[@text='OTHERS']")
    private MobileElement othersTaskBtn;

    @FindBy(xpath = "//android.widget.EditText[@text='Enter number of boxes']")
    private MobileElement enterBoxes;

    @FindBy(xpath = "//android.widget.TextView[@text='Select price boards']")
    private MobileElement selectPriceboard;

    @FindBy(xpath = "//android.widget.TextView[@text='Select Price Boards']")
    private MobileElement selectPriceboardPopUp;

    String priceboardCheckbox_Xpath = "//android.widget.TextView[@text='%s']/preceding-sibling::android.view.View";

    @FindBy(xpath = "//android.widget.Button[@text='OK']")
    private MobileElement okBtn;

//    @FindBy(xpath = "//android.widget.TextView[@text='Comment']/following-sibling::android.view.View")
//    private MobileElement enterComment;

    @FindBy(xpath = "//android.widget.EditText")
    private MobileElement enterComment;

    @FindBy(xpath = "//android.widget.Button[@text='CREATE REFILL TASK']")
    private MobileElement createRefillTaskBtn;

    @FindBy(xpath = "//android.widget.TextView[@text='Review Refill Task']")
    private MobileElement reviewRefillTaskPopUp;

    String refillQtyXpath = "//android.widget.TextView[contains(@text,'%s')]";

    @FindBy(xpath = "//android.widget.Button[@text='CREATE PRICE BOARD TASK']")
    private MobileElement createPriceboardTaskBtn;

    @FindBy(xpath = "//android.widget.TextView[@text='Review PriceBoard Task']")
    private MobileElement reviewPriceboardTaskPopUp;

    @FindBy(xpath = "//android.widget.TextView[@text='Selected Boards:']/following-sibling::android.widget.TextView")
    private List<MobileElement> actualPriceboardsSelected;

    @FindBy(xpath = "//android.widget.Button[@text='CREATE OTHER TASK']")
    private MobileElement createOtherTaskBtn;

    @FindBy(xpath = "//android.widget.TextView[@text='Review Others Task']")
    private MobileElement reviewOthersTaskPopUp;

    @FindBy(xpath = "//android.widget.TextView[@text='Comment']/following-sibling::android.widget.TextView")
    private MobileElement actualComment;

    @FindBy(xpath = "//android.widget.Button[@text='CONFIRM']")
    private MobileElement confirmBtn;

    @FindBy(xpath = "//android.widget.Button[@text='CANCEL']")
    private MobileElement cancelBtn;

    @FindBy(xpath = "//android.widget.Button[@text='CLOSE FLOOR WALK']")
    private MobileElement closeFloorwalkBtn;

    @FindBy(xpath = "//android.widget.TextView[@text='Floor Walk Closure']")
    private MobileElement floorwalkClosurePopUp;

    @FindBy(xpath = "//android.widget.Button[@text='YES']")
    private MobileElement closeFloorWalkYesBtn;

    @FindBy(xpath = "//android.widget.Button[@text='NO']")
    private MobileElement closeFloorWalkNoBtn;


    private Actions actions;

    public void verifyCreateTaskPageIsDisplayed() {
        Assert.assertTrue(QXClient.get().gestures().isElementPresent(createTaskPageTitle), "Create Task page title is not displayed");
    }


    public void createTasks(List<Map<String, String>> taskDetails) {
        for (int i=0; i<taskDetails.size(); i++){
            String ean = taskDetails.get(i).get("ean");
            QXClient.get().gestures().waitAndClickElementisVisible(searchBox);
            actions = new Actions(QXClient.get().driver());
            actions.sendKeys(ean).perform();
//            searchBox.setValue(ean);
            if (taskDetails.get(i).get("taskType").equals("Refill"))
                createRefillTask(taskDetails.get(i));
            else if (taskDetails.get(i).get("taskType").equals("Board"))
                createPriceboardTask(taskDetails.get(i));
            else if (taskDetails.get(i).get("taskType").equals("Other"))
                createOthersTask(taskDetails.get(i));
            else
                System.out.println("Wrong task type is provided !!!!!!!!");
        }
    }

    private void createRefillTask(Map<String, String> taskDetail) {
        refillTaskBtn.click();
        String requestedQty = taskDetail.get("requestedQuantity");
        QXClient.get().gestures().waitAndClickElementisVisible(enterBoxes);
        actions.sendKeys(requestedQty).perform();
        if (taskDetail.get("requesterComments")!=null) {
            QXClient.get().gestures().waitAndClickElementisVisible(enterComment);
            actions.sendKeys(taskDetail.get("requesterComments")).perform();
        }
        createRefillTaskBtn.click();
        Assert.assertTrue(QXClient.get().gestures().isElementPresent(reviewRefillTaskPopUp),"Review Refill Task PopUp is not displayed");
        MobileElement refillQty = getMobileElementFromDynamicXpath(refillQtyXpath, requestedQty + " Boxes");
        Assert.assertTrue(QXClient.get().gestures().isElementPresent(refillQty));
        confirmBtn.click();
    }

    private void createPriceboardTask(Map<String, String> taskDetail) {
        priceboardTaskBtn.click();
        selectPriceboard.click();
        Assert.assertTrue(QXClient.get().gestures().isElementPresent(selectPriceboardPopUp));
        String[] priceboards = taskDetail.get("priceboards").split(",");
        selectPriceboards(priceboards);
        if (taskDetail.get("requesterComments")!=null){
            QXClient.get().gestures().waitAndClickElementisVisible(enterComment);
            actions.sendKeys(taskDetail.get("requesterComments")).perform();
        }
        createPriceboardTaskBtn.click();
        Assert.assertTrue(QXClient.get().gestures().isElementPresent(reviewPriceboardTaskPopUp),"Review Priceboard PopUp is not displayed");
        verifyPriceboardSelected(priceboards);
        confirmBtn.click();
    }

    private void selectPriceboards(String[] priceboards) {
        for (String priceboard:priceboards){
            MobileElement priceboardCheckbox = getMobileElementFromDynamicXpath(priceboardCheckbox_Xpath, priceboard);
            priceboardCheckbox.click();
        }
        okBtn.click();
    }

    private void verifyPriceboardSelected(String[] priceboards) {
        int length = priceboards.length;
        List<String> pbs = new ArrayList<>();
        for (MobileElement selectedPriceboard:actualPriceboardsSelected){
            pbs.add(selectedPriceboard.getText());
        }
        for (int i=0; i<priceboards.length; i++){
            Assert.assertTrue(priceboards[i].contains(actualPriceboardsSelected.get(i).getText()),"Required Priceboard is not selected");
        }
    }

    private void createOthersTask(Map<String, String> taskDetail) {
        othersTaskBtn.click();
        QXClient.get().gestures().isElementPresent(enterComment);
        QXClient.get().gestures().waitAndClickElementisVisible(enterComment);
        actions.sendKeys(taskDetail.get("requesterComments")).perform();
        createOtherTaskBtn.click();
        Assert.assertTrue(QXClient.get().gestures().isElementPresent(reviewOthersTaskPopUp),"Review Others Task PopUp is not displayed");
        Assert.assertEquals(actualComment.getText(), taskDetail.get("requesterComments"));
        confirmBtn.click();
    }

    public void clickOnTaskBtn() {
        taskBtn.click();
    }

    public void closeFloorwalk() {
        QXClient.get().gestures().waitAndClickElementisVisible(closeFloorwalkBtn);
        Assert.assertTrue(QXClient.get().gestures().isElementPresent(floorwalkClosurePopUp));
        closeFloorWalkYesBtn.click();
    }

    private MobileElement getMobileElementFromDynamicXpath(String partialXpath, String replaceCharacter){
        String xpath = String.format(partialXpath, replaceCharacter);
        return (MobileElement) QXClient.get().driver().findElement(By.xpath(xpath));
    }

}
