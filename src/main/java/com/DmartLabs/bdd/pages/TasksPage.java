package com.DmartLabs.bdd.pages;

import com.DmartLabs.commonutils.Gestures;
import com.DmartLabs.commonutils.QXClient;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TasksPage {

    public TasksPage(){
        PageFactory.initElements(new AppiumFieldDecorator(QXClient.get().driver()), this);
    }

    @FindBy(xpath = "//android.widget.TextView[@text='Tasks']")
    private MobileElement taskPageTitle;

    @FindBy(xpath = "//android.widget.Button[contains(@text,'OPEN')]")
    private MobileElement openTabBtn;

    @FindBy(xpath = "//android.widget.Button[contains(@text,'ALL')]")
    private MobileElement allTabBtn;

    @FindBy(xpath = "//android.widget.Button[contains(@text,'CLOSE')]")
    private MobileElement closeTabBtn;

    @FindBy(xpath = "//android.widget.Button[@text='Floor Walk']")
    private MobileElement floorwalkBtn;

    @FindBy(xpath = "//android.widget.TextView[@text='Tasks']/preceding-sibling::android.widget.Button")
    private MobileElement backBtn;

//    @FindBy(xpath = "//android.widget.EditText")
//    private MobileElement searchBox;
//
//    String openTaskXpath = "//android.widget.TextView[@text='%s']";
//
//    @FindBy(xpath = "//android.widget.TextView[@text='EAN']/following-sibling::android.widget.TextView[1]")
//    private MobileElement specificEan;
//
//    @FindBy(xpath = "//android.widget.TextView[@text='EAN']/following-sibling::android.widget.TextView[1]/parent::android.view.View/parent::android.view.View/preceding-sibling::android.widget.Button")
//    private List<MobileElement> taskNameBtn;

    public void verifyTaskPageIsDisplayed() {
        Assert.assertTrue(QXClient.get().gestures().isElementPresent(taskPageTitle), "Tasks Page title is not displayed");
    }

    public void clickOnOpenTab() {
        openTabBtn.click();
    }

    public void verifyTasks(List<Map<String, String>> taskDetails) {
        Assert.assertTrue(openTabBtn.getText().contains(String.valueOf(taskDetails.size())));
    }

    public void clickOnFloorWalkBtn() {
        floorwalkBtn.click();
    }

    public void clickOnBackBtn() {
        backBtn.click();
    }

//    private List<String> validatedTasks = new ArrayList<>();
//    public void verifyTasks(List<Map<String, String>> taskDetails) {
//        for(Map<String, String> taskDetail:taskDetails){
//            searchBox.sendKeys(taskDetail.get("ean"));
//            Gestures.clkEnterButton();
//            List<MobileElement> allSameArticleTasks = getMobileElementsFromDynamicXpath(openTaskXpath, taskDetail.get("ean"));
//            if (allSameArticleTasks.size()>1)
//                validateSameArticleTasks(allSameArticleTasks, taskDetails);
//        }
//    }
//
//
//    private void validateSameArticleTasks(List<MobileElement> allSameArticleTasks, List<Map<String, String>> taskDetails) {
//        int totalTasks = allSameArticleTasks.size();
//        for (int i=0; i<allSameArticleTasks.size(); i++){
//            for (int j=0; j<taskDetails.size(); j++){
//                if (allSameArticleTasks.get(i).getText().equals(taskDetails.get(i).get("ean"))){
//                    if (taskNameBtn.get(i).getText().contains(taskDetails.get(i).get("taskType"))){
//                        validatedTasks.add(allSameArticleTasks.get(i).getText());
//                        taskNameBtn.get(i).click();
//                        break;
//                    }
//                }
//            }
//        }
//        int taskSize = getSameTaskSize();
//        if (taskSize>totalTasks){
//            validateSameArticleTasks(allSameArticleTasks, taskDetails);
//        }
//    }
//
//    private int getSameTaskSize() {
//        return taskNameBtn.size();
//    }
//
//    private List<MobileElement> getMobileElementsFromDynamicXpath(String partialXpath, String replaceCharacter){
//        String xpath = String.format(partialXpath, replaceCharacter);
//        return (List<MobileElement>) QXClient.get().driver().findElements(By.xpath(xpath));
//    }
//
//    private MobileElement getMobileElementFromDynamicXpath(String partialXpath, String replaceCharacter){
//        String xpath = String.format(partialXpath, replaceCharacter);
//        return (MobileElement) QXClient.get().driver().findElements(By.xpath(xpath));
//    }
}
