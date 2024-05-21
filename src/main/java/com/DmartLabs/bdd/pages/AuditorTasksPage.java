package com.DmartLabs.bdd.pages;

import com.DmartLabs.commonutils.Gestures;
import com.DmartLabs.commonutils.QXClient;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class AuditorTasksPage {

    public AuditorTasksPage(){
        PageFactory.initElements(new AppiumFieldDecorator(QXClient.get().driver()), this);
    }

//    @FindBy(xpath = "//android.view.View[@text='Tasks']")
//    private MobileElement tasksPageTitle;

    @FindBy(xpath = "//android.widget.TextView[@text='Tasks']")
    private MobileElement tasksPageTitle;

    @FindBy(xpath = "//android.widget.Button[contains(@text, 'ALL')]")
    private MobileElement allBtn;

    @FindBy(xpath = "//android.widget.Button[contains(@text, 'OPEN')]")
    private MobileElement openBtn;

    @FindBy(xpath = "//android.widget.Button[contains(@text, 'CLOSED')]")
    private MobileElement closeBtn;

//    @FindBy(xpath = "//android.widget.EditText[@resource-id='field_ean']")
//    private MobileElement searchBox;

    @FindBy(xpath = "//android.widget.EditText']")
    private MobileElement searchBox;

    @FindBy(xpath = "//android.view.View/parent::android.view.View/following-sibling::android.view.View/android.view.View/android.view.View/android.widget.Button")
    private List<MobileElement> allTasks;

    String specificTaskXpath = "//android.widget.Button[@text='%s']";

    @FindBy(xpath = "//android.widget.Button[@text='barcode']/parent::android.view.View/parent::android.view.View/parent::android.view.View/following-sibling::android.view.View/android.view.View/android.view.View")
    private MobileElement task;

    @FindBy(xpath = "//android.widget.Button[@text='Close Task']")
    private MobileElement closeTaskBtn;

//    @FindBy(xpath = "//android.view.View[@text='Close Task']")
//    private MobileElement closeTaskPopUp;

    @FindBy(xpath = "//android.widget.TextView[@text='Close Task']")
    private MobileElement closeTaskPopUp;

    @FindBy(xpath = "//android.widget.EditText")
    private MobileElement commentTextBox;

    @FindBy(xpath = "//android.widget.Button[@text='CONFIRM']")
    private MobileElement confirmBtn;

    @FindBy(xpath = "//android.widget.Button[@text='CANCEL']")
    private MobileElement cancelBtn;

//    @FindBy(xpath = "//android.view.View[@text='Closed']")
//    private MobileElement taskStatus;

    @FindBy(xpath = "//android.widget.TextView[@text='Closed']")
    private MobileElement taskStatus;

    @FindBy(xpath = "//*[name()='svg' and @class='wTqO_Quick-FIll-MuiSvgIcon-root wTqO_Quick-FIll-r_79']")
    private WebElement syncSymbol;

    public void isTaskPageDisplayed(){
        boolean result = QXClient.get().gestures().isElementPresent(tasksPageTitle);
        Assert.assertTrue(result);
    }

    public void clickOnOpenTab() {
        openBtn.click();
    }

    private List<String> tasks;
    private static List<String> closedTasks = new ArrayList<>();
    public void getTasksNames(){
        tasks = new ArrayList<>();
        for (MobileElement task:allTasks){
            tasks.add(task.getText());
        }
    }

//    public void closeTasks() {
//        Gestures gestures = QXClient.get().gestures();
////        int allTasksSize = allTasks.size();
//        for (MobileElement tasks:allTasks){
//            if (allTasks.size()>0){
//                try {
//                    gestures.waitAndClickElementisVisible(tasks);
//                } catch (StaleElementReferenceException sERE){
//                    closeTasks();
//                }
//
//                gestures.waitAndClickElementisVisible(closeTaskBtn);
//                //closeTaskBtn.click();
//                boolean result = gestures.isElementPresent(closeTaskPopUp);
//                if (result){
//                    confirmBtn.click();
//                }
//            }
//        }
//
//        if (gestures.isElementPresent(task))
//            closeTasks();
//    }

    public void closeTasks() {
        Gestures gestures = QXClient.get().gestures();
        for (String task:tasks){
            try {
                MobileElement closeTask = getMobileElementFromDynamicXpath(specificTaskXpath, task);
                //gestures.isElementPresent(closeTask);
                closeTask.click();
//                Thread.sleep(1000);
                gestures.waitAndClickElementisVisible(closeTaskBtn);
                boolean result = gestures.isElementPresent(closeTaskPopUp);
                if (result){
                    confirmBtn.click();
                    closedTasks.add(task);
                }
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (NoSuchElementException nse){
                break;
            } catch (Exception e){
//                e.printStackTrace();
            }

        }

        try {
            if (task.isDisplayed()){
                getTasksNames();
                closeTasks();
            }
        } catch (NoSuchElementException nse){

        }

    }

    public void verifyClosedTasks() {
        Gestures gestures = QXClient.get().gestures();
        closeBtn.click();

        for (String closedTask:closedTasks){
            if (validatedTasks.contains(closedTask))
                continue;

            if (closedTask.contains(" Board"))
                closedTask = closedTask.split(" Board")[0];
            else if (closedTask.contains(" Other"))
                closedTask = closedTask.split(" Other")[0];
            else if (closedTask.contains(" Refill")){
                closedTask = closedTask.split(" Refill")[0];
            }
            searchBox.clear();
            searchBox.click();
            searchBox.sendKeys(closedTask);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Gestures.clkEnterButton();
//            gestures.isElementNotPresent(taskStatus);
            if (allTasks.size()>1){
                verifyDuplicateClosedTask(closedTasks, closedTask);
            } else {
                try {
                    Assert.assertEquals(taskStatus.getText(), "Closed");
                } catch (NoSuchElementException nse){
                    gestures.scrollTilltextVisible("Closed");
                    Assert.assertEquals(taskStatus.getText(), "Closed");
                }
            }
            searchBox.clear();
        }
    }

    private static List<String> validatedTasks = new ArrayList<>();
    private void verifyDuplicateClosedTask(List<String> closedTasks, String closedTask) {
        //int l = 0;
        int k = 0;
        int endY = allTasks.get(0).getLocation().getY()+150;
        int startX = allTasks.get(0).getLocation().getX();
        for (int i=0; i<closedTasks.size();i++){
            if (closedTasks.get(i).contains(closedTask)) {
                for (int j = 0; j < allTasks.size(); k++) {
                    if (allTasks.get(j).getText().equals(closedTasks.get(i))) {
                        try {
                            Assert.assertEquals(taskStatus.getText(), "Closed");
                        } catch (Exception e){
                            int startY = allTasks.get(j).getLocation().getY();
                            QXClient.get().gestures().scrollVerticallyDevice(startX,startY,endY,1);
                            Assert.assertEquals(taskStatus.getText(), "Closed");
                        }

                        allTasks.get(j).click();
//                        try {
//                            Thread.sleep(500);
//                        } catch (InterruptedException e) {
//                            e.printStackTrace();
//                        }
                        validatedTasks.add(closedTasks.get(i));
                        break;
                    }
                    j=k;
                }
                allTasks = allTasks;
            }
        }

//        Gestures gestures = QXClient.get().gestures();

//        for (String closedTask:closedTasks){
//            for (MobileElement task:allTasks){
//
//            }
//        }
    }

    public void verifySyncedAndClosedTasks() {
        Gestures gestures = QXClient.get().gestures();
        closeBtn.click();
//        Assert.assertTrue(gestures.isElementPresentPicker(syncSymbol));
        for (String closedTask:closedTasks){
            if (closedTask.contains(" Board"))
                closedTask = closedTask.split(" Board")[0];
            else if (closedTask.contains(" Other"))
                closedTask = closedTask.split(" Other")[0];
            else if (closedTask.contains(" Refill"))
                closedTask = closedTask.split(" Refill")[0];
            searchBox.click();
            searchBox.sendKeys(closedTask);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Gestures.clkEnterButton();
//            gestures.isElementNotPresent(taskStatus);
            try {
//                Assert.assertTrue(syncSymbol.isDisplayed());
                Assert.assertEquals(taskStatus.getText(), "Closed");
            } catch (NoSuchElementException nse){
                gestures.scrollTilltextVisible("Closed");
                Assert.assertEquals(taskStatus.getText(), "Closed");
            }
            searchBox.clear();
        }
    }

    private MobileElement getMobileElementFromDynamicXpath(String partialXpath, String replaceCharacter){
        String xpath = String.format(partialXpath, replaceCharacter);
        return (MobileElement) QXClient.get().driver().findElement(By.xpath(xpath));
    }

}
