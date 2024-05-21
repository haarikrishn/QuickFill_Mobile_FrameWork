package com.DmartLabs.commonutils;

import com.github.javafaker.Faker;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.MultiTouchAction;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.mobile.NetworkConnection;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.Duration;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static io.appium.java_client.touch.offset.PointOption.point;
import static java.time.Duration.ofMillis;
import static java.time.Duration.ofSeconds;

/**
 * Created by Qualitrix on DD/MM/YYY.
 *
 * @author
 */
public class Gestures {

    public static AppiumDriver driver;

    public Gestures(AppiumDriver driver) {
        Gestures.driver = driver;
    }

    public static boolean isDisabled(WebElement buttonLocator) {
        MobileElement button = (MobileElement) driver.findElement((By) buttonLocator);
        return !button.isEnabled();
    }

    public static void assertElementNotDisplayed(WebElement element) {
        if (!element.isDisplayed()) {
            System.out.println("Element is not displayed as expected.");
        } else {
            throw new AssertionError("Element is displayed, but it should not be.");
        }
    }

    public static void clkBackButton() {
        ((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.BACK));
        System.out.println("Clicked on back buttton");
    }

    public static void clkEnterButton() {
        ((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.ENTER));
        System.out.println("Clicked on enter buttton");
    }

    // Method for horizontal scroll in the upper part of the screen
    public static void horizontalScrollUpperScreen() {
        Dimension size = driver.manage().window().getSize();
        int startX = (int) (size.width * 0.2);
        int endX = (int) (size.width * 0.8);
        int y = (int) (size.height * 0.3);

        performHorizontalScroll(startX, y, endX, y);
    }

    // Method for horizontal scroll in the lower part of the screen
    public static void horizontalScrollLowerScreen() {
        Dimension size = driver.manage().window().getSize();
//        int startX = (int) (size.width * 0.2);
//        int endX = (int) (size.width * 0.8);
//        int y = (int) (size.height * 0.7);
        int startX = (int) (size.width * 0.8); // Start from the right side (80%)
        int endX = (int) (size.width * 0.2);   // Scroll to the left side (20%)
        int y = size.height / 2;

        performHorizontalScroll(startX, y, endX, y);
    }

    // Reusable method to perform horizontal scroll
    public static void performHorizontalScroll(int startX, int startY, int endX, int endY) {
        TouchAction action = new TouchAction(driver);
        action.press(PointOption.point(startX, startY)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(500))).moveTo(PointOption.point(endX, endY)).release().perform();
    }

    public static void toggleWiFi(boolean enable) throws IOException, InterruptedException {
        if (enable) {
            executeCommand("adb shell am start -a android.intent.action.MAIN -n com.android.settings/.wifi.WifiSettings");
            Thread.sleep(2000);
            executeCommand("adb shell input keyevent 23");
            executeCommand("adb shell input keyevent 23");
            // Press Enter to turn WiFi on
            executeCommand("adb shell input keyevent 4");
        } else {
            executeCommand("adb shell am start -a android.intent.action.MAIN -n com.android.settings/.wifi.WifiSettings");
            Thread.sleep(2000);
            executeCommand("adb shell input keyevent 20"); // Press Down to navigate to "Turn off"
            executeCommand("adb shell input keyevent 23");
            executeCommand("adb shell input keyevent 23");
            executeCommand("adb shell input keyevent 4");// Press Enter to turn WiFi off
        }
    }

    public void toggleWiFi(){
        AndroidDriver driver = (AndroidDriver) QXClient.get().driver();
        driver.toggleWifi();
    }

    public static void turnOnWiFi() {

        try {
            executeCommand("adb shell \"svc wifi enable\"");
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public static void turnOffWiFi() {
        try {
            executeCommand("adb shell \"svc wifi disable\"");
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void sendAppsToBackground() throws IOException {
        String command = "adb shell input keyevent 187";
        executeCommand(command);
    }

    public static void openPeviousApp() throws IOException {
        clkBackButton();
    }

    private static void executeCommand(String command) throws IOException {
        Process process = Runtime.getRuntime().exec(command);
        try {
            process.waitFor();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void startActivity(String appPackage, String appActivity) {
        ((AndroidDriver) driver).startActivity(new Activity(appPackage, appActivity));
    }

    public void horizontalSwipingTest(WebElement element) throws Exception {

        MobileElement slider = (MobileElement) element;
        Point source = slider.getLocation(); //Source WebElement from where we have to perform swipe
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence dragNDrop = new Sequence(finger, 1);
        dragNDrop.addAction(finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), source.x, source.y));
        dragNDrop.addAction(finger.createPointerDown(PointerInput.MouseButton.MIDDLE.asArg()));
        dragNDrop.addAction(new Pause(finger, Duration.ofMillis(600)));
        dragNDrop.addAction(finger.createPointerMove(Duration.ofMillis(600), PointerInput.Origin.viewport(), source.x + 400, source.y));
        dragNDrop.addAction(finger.createPointerUp(PointerInput.MouseButton.MIDDLE.asArg()));
        driver.perform(Collections.singletonList(dragNDrop));
    }

    public void verticalSwipeTest(WebElement element) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
        wait.until(ExpectedConditions.visibilityOf(element));
        verticalSwipe(element);
    }

    public void dragAndDrop(WebElement element) throws InterruptedException {
        Thread.sleep(5000);
        element.click();
        MobileElement dragMe = (MobileElement) new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(element));
        Point source = dragMe.getCenter();
        //IMPORTANT - This needs to be corrected.
        //Point target = (MobileElement) driver.findElementByAccessibilityId("dropzone").getCenter();
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence dragNDrop = new Sequence(finger, 1);
        dragNDrop.addAction(finger.createPointerMove(ofMillis(0), PointerInput.Origin.viewport(), source.x, source.y));
        dragNDrop.addAction(finger.createPointerDown(PointerInput.MouseButton.MIDDLE.asArg()));
        dragNDrop.addAction(new Pause(finger, ofMillis(600)));
        dragNDrop.addAction(finger.createPointerUp(PointerInput.MouseButton.MIDDLE.asArg()));
        driver.perform(Collections.singletonList(dragNDrop));
    }

    public void pinchAndZoom(WebElement element) throws InterruptedException {
        Thread.sleep(5000);
        element.click();
        Thread.sleep(3000);
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        PointerInput finger2 = new PointerInput(PointerInput.Kind.TOUCH, "finger2");

        Dimension size = driver.manage().window().getSize();
        Point source = new Point(size.getWidth(), size.getHeight());

        Sequence pinchAndZoom1 = new Sequence(finger, 0);
        pinchAndZoom1.addAction(finger.createPointerMove(ofMillis(0), PointerInput.Origin.viewport(), source.x / 2, source.y / 2));
        pinchAndZoom1.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        pinchAndZoom1.addAction(new Pause(finger, ofMillis(100)));
        pinchAndZoom1.addAction(finger.createPointerMove(ofMillis(600), PointerInput.Origin.viewport(), source.x / 3, source.y / 3));
        pinchAndZoom1.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));


        Sequence pinchAndZoom2 = new Sequence(finger2, 0);
        pinchAndZoom2.addAction(finger2.createPointerMove(ofMillis(0), PointerInput.Origin.viewport(), source.x / 2, source.y / 2));
        pinchAndZoom2.addAction(finger2.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        pinchAndZoom2.addAction(new Pause(finger, ofMillis(100)));
        pinchAndZoom2.addAction(finger2.createPointerMove(ofMillis(600), PointerInput.Origin.viewport(), source.x * 3 / 4, source.y * 3 / 4));
        pinchAndZoom2.addAction(finger2.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        driver.perform(Arrays.asList(pinchAndZoom1, pinchAndZoom2));
    }

    public void longPress(WebElement element) throws InterruptedException {

        Thread.sleep(5000);
        element.click();
        MobileElement longpress = (MobileElement) new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(element));
        new Actions(driver).clickAndHold(longpress).perform();
        Thread.sleep(5000);
    }

    public void doubleTap(MobileElement mobileElement) {
        TouchActions action = new TouchActions(driver);
        action.doubleTap(mobileElement);
        action.perform();
    }

    public void doubleTap(WebElement element) throws InterruptedException {

        Thread.sleep(5000);
        driver.findElementByAccessibilityId("doubleTap").click();
        MobileElement mobileElement = (MobileElement) new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(element));
        Thread.sleep(1000);
        Point source = mobileElement.getCenter();
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
        Sequence tap = new Sequence(finger, 1);
        tap.addAction(finger.createPointerMove(ofMillis(0), PointerInput.Origin.viewport(), source.x, source.y));
        tap.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        tap.addAction(new Pause(finger, ofMillis(200)));
        tap.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        tap.addAction(new Pause(finger, ofMillis(40)));
        tap.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        tap.addAction(new Pause(finger, ofMillis(200)));
        tap.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        driver.perform(Collections.singletonList(tap));
        Thread.sleep(4000);
    }

    private void verticalSwipe(WebElement element) throws InterruptedException {
        Thread.sleep(5000);
        MobileElement slider = (MobileElement) element;
        Point source = slider.getCenter();
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence dragNDrop = new Sequence(finger, 1);
        dragNDrop.addAction(finger.createPointerMove(ofMillis(0), PointerInput.Origin.viewport(), source.x / 2, source.y + 400));
        dragNDrop.addAction(finger.createPointerDown(PointerInput.MouseButton.MIDDLE.asArg()));
        dragNDrop.addAction(finger.createPointerMove(ofMillis(600), PointerInput.Origin.viewport(), source.getX() / 2, source.y / 2));
        dragNDrop.addAction(finger.createPointerUp(PointerInput.MouseButton.MIDDLE.asArg()));
        driver.perform(Collections.singletonList(dragNDrop));
    }

    public void multiTouchTest(WebElement element) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
        Thread.sleep(3000);
        MobileElement slider = (MobileElement) element;
        MobileElement slider1 = (MobileElement) element;

        Dimension sizeSlider = slider.getSize();
        Dimension sizeSlider1 = slider1.getSize();
        TouchAction touchAction1 = new TouchAction(driver).press(ElementOption.element(slider, 0, sizeSlider.height / 2)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1))).moveTo(ElementOption.element(slider, sizeSlider.width / 2, sizeSlider.height / 2));
        TouchAction touchAction2 = new TouchAction(driver).press(ElementOption.element(slider1, 0, sizeSlider1.height / 2)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1))).moveTo(ElementOption.element(slider1, sizeSlider1.width / 2, sizeSlider1.height / 2));
        new MultiTouchAction(driver).add(touchAction1).add(touchAction2).perform();
        Thread.sleep(2000);
    }

    public void closeApp() {
        driver.closeApp();
    }

    public void clickOnElement(WebElement element) {
        element.click();
    }

    public void waitAndClickElementisVisible(WebElement element) {
        // Set implicit wait
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

        try {
            // Explicitly wait for the visibility of the element
            WebDriverWait wait = new WebDriverWait(driver, 15);
            wait.until(ExpectedConditions.visibilityOf(element));

            // Perform the click operation
            element.click();
        } finally {
            // Reset implicit wait to its default value (optional)
            driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        }
    }

    public void waitForElementToBeClickable(WebElement element) {
        // Set implicit wait
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

        try {
            // Explicitly wait for the visibility of the element
            WebDriverWait wait = new WebDriverWait(driver, 15);
            wait.until(ExpectedConditions.elementToBeClickable(element));

        } finally {
            // Reset implicit wait to its default value (optional)
            driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        }
    }


    //    public boolean isElementPresent(WebElement locator) {
//        try {
//            waitForElementToAppear(locator);
//            String elementText = locator.getText();
//            if (!elementText.isEmpty()) {
//                System.out.println("Element present on screen ***********" + elementText);
//            } else {
//                System.out.println("Element present on screen, but no text available"+locator);
//            }
//            return true;
//        } catch (Exception e) {
//            String elementText1 = locator.getText();
//            if (!elementText1.isEmpty()) {
//                System.out.println("Element not present on screen ***********" + elementText1);
//            } else {
//                System.out.println("Element not present on screen, but no text available" +locator);
//            }
//            return false;
//        }
//    }
    public boolean isElementPresent(WebElement locator) {
        try {
            // Set implicit wait
            driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

            // Wait for the element to appear using your custom waitForElementToAppear method
            waitForElementToAppear(locator);

            // Check if the element is displayed
            if (locator.isDisplayed()) {
                String elementText = locator.getText().trim();
                if (!elementText.isEmpty()) {
                    System.out.println("Element present on screen: " + elementText);
                } else {
                    System.out.println("Element present on screen, but no text available for element: " + locator);
                }
                return true;
            } else {
                System.out.println("Element not displayed on screen: " + locator);
                return false;
            }
        } catch (NoSuchElementException e) {
            String elementText = locator.getText().trim();
            if (!elementText.isEmpty()) {
                System.out.println("Element not present on screen: " + elementText);
            } else {
                System.out.println("Element not present on screen, and no text available for element: " + locator);
            }
            return false;
        } catch (Exception e) {
            System.out.println("Exception while checking element presence: " + e.getMessage());
            return false;
        } finally {
            // Reset implicit wait to its default value (optional)
            driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        }
    }
//====================================================================================================
public boolean isElementPresentPicker(WebElement locator) {
    try {
        // Set implicit wait
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

        // Wait for the element to appear using your custom waitForElementToAppear method
        waitForElementToAppearPicker(locator);

        // Check if the element is displayed
        if (locator.isDisplayed()) {
            String elementText = locator.getText().trim();
            if (!elementText.isEmpty()) {
                System.out.println("Element present on screen: " + elementText);
            } else {
                System.out.println("Element present on screen, but no text available for element: " + locator);
            }
            return true;
        } else {
            System.out.println("Element not displayed on screen: " + locator);
            return false;
        }
    } catch (NoSuchElementException e) {
        String elementText = locator.getText().trim();
        if (!elementText.isEmpty()) {
            System.out.println("Element not present on screen: " + elementText);
        } else {
            System.out.println("Element not present on screen, and no text available for element: " + locator);
        }
        return false;
    } catch (Exception e) {
        System.out.println("Exception while checking element presence: " + e.getMessage());
        return false;
    } finally {
        // Reset implicit wait to its default value (optional)
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
    }
}



















    //==============================================================================
    public boolean isElementNotPresent(WebElement element) {
        // Set implicit wait
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

        try {
            waitForInvisiblityOfElement(element);
            if (!element.isDisplayed()) {
                return true;
            }
        } catch (Exception e) {
            return false;
        } finally {
            // Reset implicit wait to its default value (optional)
            driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        }
        return true;
    }

    public WebElement waitForElementToAppear(WebElement id) {
        WebDriverWait wait = new WebDriverWait(driver, 25);
        wait.until(ExpectedConditions.visibilityOf(id));
        return id;
    }

    public WebElement waitForElementToAppearPicker(WebElement id) {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.visibilityOf(id));
        return id;
    }

    public WebElement waitForInvisiblityOfElement(WebElement element){
        WebDriverWait wait = new WebDriverWait(driver, 35);
        wait.until(ExpectedConditions.invisibilityOf(element));
        return element;
    }

    public List<WebElement> waitForInvisiblityOfAllElement(List<WebElement> element){
        WebDriverWait wait = new WebDriverWait(driver, 25);
        wait.until(ExpectedConditions.invisibilityOfAllElements(element));
        return element;
    }

    public boolean isElementPresent(WebElement locator, int timeOut) {
        // Set implicit wait
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

        try {
            waitForElementToAppear(locator, timeOut);
            if (locator.isDisplayed()) {
                System.out.println("Element present on screen ***********" + locator);
                return true;
            }
        } catch (Exception e) {
            System.out.println("Element not present on screen **************" + locator);
            return false;
        } finally {
            // Reset implicit wait to its default value (optional)
            driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        }

        return false;
    }

    public WebElement waitForElementToAppear(WebElement id, int timeOut) {
        WebDriverWait wait = new WebDriverWait(driver, timeOut);
        wait.until(ExpectedConditions.visibilityOf(id));
        return id;
    }


    public void waitForElementToVisible(WebElement locator) {
        WebDriverWait wait = new WebDriverWait(driver, 35);
        wait.until(ExpectedConditions.visibilityOf(locator));

    }
    public void waitForElementToVisiblePicker(WebElement locator) {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.visibilityOf(locator));

    }

    public void clickWithJavaScript(WebElement ele) {
        try {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", ele);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void scrollFromElementToElementVertical(MobileElement startElement, MobileElement endElement, String scrollCount) {
        Dimension size = driver.manage().window().getSize();
        int starty = startElement.getLocation().getY();
        int endy = startElement.getLocation().getY() - 400;
        int constx = (int) (size.width * 0.5);
        System.out.println("Co-ordinates = startY:" + starty + " endY:" + endy + " constX:" + constx);

        try {
            int count = Integer.parseInt(scrollCount);
            for (int i = 0; i < count; i++) {
                if (isElementPresent(endElement, 5)) {
                    break;
                } else {
                    swipeCoordinates(constx, starty, constx, endy);
                }
            }
        } catch (Exception e) {
            System.out.println("Scroll to mobile element failed");
        }
    }

    public void scrollFromElementToElementHorizontal(MobileElement startElement, MobileElement endElement, String scrollCount) {
        Dimension size = driver.manage().window().getSize();
        int startx = startElement.getLocation().getX();
        int endx = startElement.getLocation().getX() - 300;
        int consty = startElement.getLocation().getY();
        System.out.println("Co-ordinates = startX:" + startx + " endX:" + endx + " constY:" + consty);

        try {
            int count = Integer.parseInt(scrollCount);
            for (int i = 0; i < count; i++) {
                if (isElementPresent(endElement, 5)) {
                    break;
                } else {
                    swipeCoordinates(startx, consty, endx, consty);
                }
            }
        } catch (Exception e) {
            System.out.println("Scroll to mobile element failed");
        }
    }

    public void scrollFromElementToElementHorizontalMax(MobileElement startElement, MobileElement endElement, String scrollCount) {
        Dimension size = driver.manage().window().getSize();
        int startx = startElement.getLocation().getX();
        int endx = startElement.getLocation().getX() - 600;
        int consty = startElement.getLocation().getY();
        System.out.println("Co-ordinates = startX:" + startx + " endX:" + endx + " constY:" + consty);

        try {
            int count = Integer.parseInt(scrollCount);
            for (int i = 0; i < count; i++) {
                if (isElementPresent(endElement, 5)) {
                    break;
                } else {
                    swipeCoordinates(startx, consty, endx, consty);
                }
            }
        } catch (Exception e) {
            System.out.println("Scroll to mobile element failed");
        }
    }

    public void scrollToMobileElement(MobileElement element, String scrollCount) {
        try {
            int count = Integer.parseInt(scrollCount);
            for (int i = 0; i < count; i++) {
                if (isElementPresent(element)) {
                    break;
                } else {
                    swipeUp();
                }
            }
        } catch (Exception e) {
            System.out.println("Scroll to mobile element failed");
        }
    }

    public void swipeUp() {
        Dimension size = driver.manage().window().getSize();
        int starty = (int) (size.height * 0.5);
        int endy = (int) (size.height * 0.2);
        int startx = (int) (size.width * 0.5);
        try {
            System.out.println("Trying to swipe up from x:" + startx + " y:" + starty + ", to x:" + startx + " y:" + endy);
            new TouchAction(driver).press(point(startx, starty)).waitAction(waitOptions(ofSeconds(1))).moveTo(point(startx, endy)).release().perform();

        } catch (Exception e) {
            System.out.println("Swipe action was not successful.");
        }
    }

    public void swipeCoordinates(int startX, int startY, int endX, int endY) {
        try {
            System.out.println("Trying to swipe up from x:" + startX + " y:" + startY + ", to x:" + endX + " y:" + endY);
            new TouchAction(driver).press(point(startX, startY)).waitAction(waitOptions(ofSeconds(1))).moveTo(point(endX, endY)).release().perform();

        } catch (Exception e) {
            System.out.println("Swipe action was not successful.");
        }
    }

    public WebElement getWebElClickable(WebElement id ) {
        WebDriverWait wait = new WebDriverWait(driver, 50);
        return wait.ignoring(StaleElementReferenceException.class).until(
                ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(id)));
    }

    public WebElement waitForVisbilityOfWebElement(WebElement id ) {
        WebDriverWait wait = new WebDriverWait(driver, 50);
        return wait.ignoring(StaleElementReferenceException.class).until(
                ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(id)));
    }

    public List<WebElement> waitForVisiblityOfAllWebElement(List<WebElement> allElements) {
        WebDriverWait wait = new WebDriverWait(driver, 50);
        return wait.ignoring(StaleElementReferenceException.class).until(
                ExpectedConditions.refreshed(ExpectedConditions.visibilityOfAllElements(allElements)));
    }

    public boolean generateTextXpathIsElementPresent(String value) {
        boolean flag = false;
        List<MobileElement> elements = driver.findElements(By.xpath("//*[contains(@text,'" + value + "')]"));
        if (elements.size() > 0) {
            flag = true;
        }
        Assert.assertTrue(flag, "Element is not present");
        return flag;
    }

    public void generateXpathAndClickElement(String value) throws Exception {
        BlindWait(3000);
        try {
            MobileElement element = (AndroidElement) driver.findElement(By.xpath("//*[contains(@text,'" + value + "')]"));
            element.click();
        } catch (Exception e) {
            System.out.println("Scroll to mobile element failed");
        }
    }

    public void generateXpathUsingTextAndClickElement(String value) {
        try {
            WebElement element = driver.findElement(By.xpath("//*[@text='" + value + "']"));
            element.click();
        } catch (Exception e) {
            System.out.println("Scroll to mobile element failed");
        }
    }

    public void swipeDown() {
        Dimension size = driver.manage().window().getSize();
        int starty = (int) (size.height * 0.45);
        int endy = (int) (size.height * 0.90);
        int startx = (int) (size.width / 2.2);
        try {
            System.out.println("Trying to swipe up from x:" + startx + " y:" + starty + ", to x:" + startx + " y:" + endy);
            new TouchAction(driver).press(point(startx, starty)).waitAction(waitOptions(ofSeconds(1))).moveTo(point(startx, endy)).release().perform();
        } catch (Exception e) {
            System.out.println("Swipe did not complete successfully.");
        }
    }
    //============================================================







    //======================================================================================

    public String getText(WebElement element) {
        String elementText = element.getText();
        return elementText;
    }

    public void openNotification() {
        ((AndroidDriver) driver).openNotifications();
    }

    public String generateRandomName() {
        Faker faker = new Faker();
        String name = faker.name().fullName();
        return name;
    }

    public void scrollTilltextVisible(String visibleText) {
        ((AndroidDriver) driver).findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"" + visibleText + "\").instance(0))");
    }

    public void scrollAndClick(String visibleText) {
        ((AndroidDriver) driver).findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"" + visibleText + "\").instance(0))").click();
    }

    public void alternativeMethodForSendKeys(String textData) {
        Actions a = new Actions(driver);
        a.sendKeys(textData);
        a.perform();
        a.sendKeys(Keys.ENTER).build().perform();

    }

    public void BlindWait(int wait) throws Exception {
        Thread.sleep(wait);

    }

    public void scrollUpToMobileElement(MobileElement element, String scrollCount) {
        try {
            int count = Integer.parseInt(scrollCount);
            for (int i = 0; i < count; i++) {
//                if (isElementDisplayed(element)) {
                if (isElementPresent(element)) {
                    break;
                } else {
                  //  swipeUp();
                    swipeDown();
                }

            }
        } catch (Exception e) {
            System.out.println("Scroll to mobile element failed");
        }
    }
//================================================================================
public void scrollDownToMobileElement(MobileElement element, String scrollCount) {
    try {
        int count = Integer.parseInt(scrollCount);
        for (int i = 0; i < count; i++) {
//                if (isElementDisplayed(element)) {
            if (isElementPresent(element)) {
                break;
            } else {
             //   swipeUp();
                swipeDown();
            }

        }
    } catch (Exception e) {
        System.out.println("Scroll to mobile element failed");
    }
}














    //==========================================================


    public void tocuh() throws Exception {
        /*
         * Dimension dims = driver.manage().window().getSize(); int edgeBorder = 10;
         * PointOption pointOptionStart, pointOptionEnd; // init start point = center of
         * screen pointOptionStart = PointOption.point(dims.width / 2, dims.height / 2);
         * pointOptionEnd = PointOption.point(dims.width / 2, dims.height - edgeBorder);
         */
        new TouchAction(driver).tap(point(299, 150)).perform();
    }



    public void generateXpathUsingClassAndTextAndClickElement(String value) throws Exception {

        BlindWait(6000);


        MobileElement element = (AndroidElement) driver.findElement(By.xpath("//android.view.View[@text='" + value + "']"));
        element.click();
        BlindWait(5000);

    }

    public void airplaneMode() {

//        NetworkConnection mobileNetwork = (NetworkConnection) driver;
//        mobileNetwork.setNetworkConnection(NetworkConnection.ConnectionType.AIRPLANE_MODE);
        ((AndroidDriver) driver).toggleAirplaneMode();
//        ((AndroidDriver)driver).setConnection(new ConnectionState(0b001));

    }

    public void enableAllNetwork() {

        NetworkConnection mobileNetwork = (NetworkConnection) driver;
        mobileNetwork.setNetworkConnection(NetworkConnection.ConnectionType.ALL);
    }

    public void scrollTestUsingFinger() {
//        Dimension dimension = driver.manage().window().getSize();
//        int scrollStart = (int) (dimension.getHeight() * 0.5);
//        int scrollEnd = (int) (dimension.getHeight() * 0.2);
//        int widthHalf = (int) (dimension.getWidth() * 0.5);
//
//        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
//        Sequence dragNDrop = new Sequence(finger, 1);
//
//        // Move the finger to the starting position
//        dragNDrop.addAction(finger.createPointerMove(ofMillis(0), PointerInput.Origin.viewport(), widthHalf, scrollStart));
//
//        // Press the left mouse button (simulate touch)
//        dragNDrop.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
//
//        // Pause for 600 milliseconds (you can adjust this as needed)
//        dragNDrop.addAction(new Pause(finger, ofMillis(600)));
//
//        // Move the finger to the ending position (simulate dragging)
//        dragNDrop.addAction(finger.createPointerMove(ofMillis(700), PointerInput.Origin.viewport(), widthHalf, scrollEnd));
//
//        // Release the left mouse button (simulate release)
//        dragNDrop.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
//
//        // Perform the sequence of actions
//        driver.perform(Collections.singletonList(dragNDrop));
        Dimension dimension = driver.manage().window().getSize();
        int scrollStart = (int) (dimension.getHeight() * 0.5);
        int scrollEnd = (int) (dimension.getHeight() * 0.2);
        int widthHalf = (int) (dimension.getWidth() * 0.5);

        TouchAction touchAction = new TouchAction(driver);

// Perform a press-and-move action to simulate scrolling
        touchAction.press(PointOption.point(widthHalf, scrollStart)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(600))).moveTo(PointOption.point(widthHalf, scrollEnd)).release().perform();

    }

    public void scrollFromElementToElementVertically(MobileElement startElement, MobileElement endElement, String scrollCount) {
        Dimension size = driver.manage().window().getSize();
        int starty = startElement.getLocation().getY();
        int endy = startElement.getLocation().getY() - 300;
        int constx = startElement.getLocation().getX();
        System.out.println("Co-ordinates = startY:" + starty + " endY:" + endy + " constX:" + constx);

        try {
            int count = Integer.parseInt(scrollCount);
            for (int i = 0; i < count; i++) {
                if (isElementPresent(endElement, 5)) {
                    break;
                } else {
                    swipeCoordinates(constx, starty, constx, endy);
                }
            }
        } catch (Exception e) {
            System.out.println("Scroll to mobile element failed");
        }
    }

    public void horizontalScrollUsingFinger() {
        Dimension dimension = driver.manage().window().getSize();
        int scrollStartX = (int) (dimension.getWidth() * 0.8); // Start from the right side
        int scrollEndX = (int) (dimension.getWidth() * 0.2);   // End on the left side
        int heightHalf = (int) (dimension.getHeight() * 0.5);

        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence dragNDrop = new Sequence(finger, 1);

        // Move the finger to the starting position (right side)
        dragNDrop.addAction(finger.createPointerMove(ofMillis(0), PointerInput.Origin.viewport(), scrollStartX, heightHalf));

        // Press the left mouse button (simulate touch)
        dragNDrop.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));

        // Pause for 600 milliseconds (you can adjust this as needed)
        dragNDrop.addAction(new Pause(finger, ofMillis(600)));

        // Move the finger to the ending position (left side)
        dragNDrop.addAction(finger.createPointerMove(ofMillis(700), PointerInput.Origin.viewport(), scrollEndX, heightHalf));

        // Release the left mouse button (simulate release)
        dragNDrop.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        // Perform the sequence of actions
        driver.perform(Collections.singletonList(dragNDrop));
    }

    public void hideKeyBoard() {

        try {
            // Run the ADB command to check if the keyboard is showing
            Process process = Runtime.getRuntime().exec("adb shell dumpsys input_method");

            // Read the output of the command
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            boolean isKeyboardShowing = false;

            while ((line = reader.readLine()) != null) {
                if (line.contains("mInputShown=true")) {
                    isKeyboardShowing = true;
                    break;
                }
            }

            // Close the reader
            reader.close();

            if (isKeyboardShowing) {
                // If the keyboard is showing, send a key event to hide it
                Process hideProcess = Runtime.getRuntime().exec("adb shell input keyevent KEYCODE_BACK");
                hideProcess.waitFor();
                System.out.println("Keyboard hidden");
            } else {
                System.out.println("Keyboard is not showing");
            }
//            if (isKeyboardShowing) {
//                // If the keyboard is showing, send a key event to hide it
//                driver.hideKeyboard();
//                System.out.println("Keyboard hidden");
//            } else {
//                System.out.println("Keyboard is not showing");
//            }
//            if (isKeyboardShowing) {
//                // If the keyboard is showing, send a key event to hide it
//                new TouchAction(driver).tap(PointOption.point(10, 10)).perform();
//                System.out.println("Keyboard hidden");
//            } else {
//                System.out.println("Keyboard is not showing");
//            }
//
//            if (isKeyboardShowing) {
//                // If the keyboard is showing, use JavaScript to hide it
//                JavascriptExecutor js = (JavascriptExecutor) driver;
//                js.executeScript("mobile: hideKeyboard");
//                System.out.println("Keyboard hidden");
//            } else {
//                System.out.println("Keyboard is not showing");
//            }
//
//            if (isKeyboardShowing) {
//                // If the keyboard is showing, use "mobile: performEditorAction" to hide it
//                driver.executeScript("mobile: performEditorAction", ImmutableMap.of("action", "done"));
//                System.out.println("Keyboard hidden");
//            } else {
//                System.out.println("Keyboard is not showing");
//            }

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void scrollVertically(MobileElement startElement, int defaultScrollCount) {
        Dimension size = driver.manage().window().getSize();
        int starty = startElement.getLocation().getY();
        int endy = startElement.getLocation().getY() - 300;
        int constx = startElement.getLocation().getX();
        System.out.println("Co-ordinates = startY:" + starty + " endY:" + endy + " constX:" + constx);

        try {
            int count = defaultScrollCount;
            for (int i = 0; i < count; i++) {
                // Modify this condition as needed based on your requirements
                swipeCoordinates(constx, starty, constx, endy);
            }
        } catch (Exception e) {
            System.out.println("Scroll to mobile element failed");
        }
    }


    //============================================================================

//    int yAxis = MeadiumEle.getLocation().getY();  460
//    int xAxis = MeadiumEle.getLocation().getX();   523
 //   QXClient.get().gestures(). scrollVerticallyDevice(xAxis,yAxis,1); 523  460  1

    public void scrollVerticallyDevice1(int getX, int startElement, int defaultScrollCount) {
        Dimension size = driver.manage().window().getSize();
        int startY = startElement;
        int endY = size.getHeight();
        System.out.println(endY+"==========>starty");

//        int endy = startElement;
//        System.out.println(endy+"==============>endy");

        int constx = getX;
        //   System.out.println("Co-ordinates = startY:" + starty + " endY:" + endy + " constX:" + constx);

        try {
            int count = defaultScrollCount;
            for (int i = 0; i < count; i++) {
                // Modify this condition as needed based on your requirements
                swipeCoordinates(constx, startY, constx, endY);
            }
        } catch (Exception e) {
            System.out.println("Scroll to mobile element failed");
        }
    }

    public void scrollVerticallyDevice12(int getX, int startY, int endY, int defaultScrollCount) {


        int constx = getX;
        startY = startY+5;
        //   System.out.println("Co-ordinates = startY:" + starty + " endY:" + endy + " constX:" + constx);

        try {
            int count = defaultScrollCount;
            for (int i = 0; i < count; i++) {
                // Modify this condition as needed based on your requirements
                swipeCoordinates(constx, startY, constx, endY);
            }
        } catch (Exception e) {
            System.out.println("Scroll to mobile element failed");
        }
    }

    public void scrollVerticallyDevice(int getX, int startElement, int defaultScrollCount) {
        Dimension size = driver.manage().window().getSize();
        int startY = size.getHeight()-5;
        //  int endY = startElement;
        System.out.println(startY+"==========>starty");

        int endy = startElement;
        System.out.println(endy+"==============>endy");

        int constx = getX;
        //   System.out.println("Co-ordinates = startY:" + starty + " endY:" + endy + " constX:" + constx);

        try {
            int count = defaultScrollCount;
            for (int i = 0; i < count; i++) {
                // Modify this condition as needed based on your requirements
                swipeCoordinates(constx, startY, constx, endy);
            }
        } catch (Exception e) {
            System.out.println("Scroll to mobile element failed");
        }
    }

    public void scrollVerticallyDevice(int getX, int startY, int endY, int defaultScrollCount) {
        //Dimension size = driver.manage().window().getSize();

        int constx = getX;
        //   System.out.println("Co-ordinates = startY:" + starty + " endY:" + endy + " constX:" + constx);

        try {
            int count = defaultScrollCount;
            for (int i = 0; i < count; i++) {
                // Modify this condition as needed based on your requirements
                swipeCoordinates(constx, startY, constx, endY);
            }
        } catch (Exception e) {
            System.out.println("Scroll to mobile element failed");
        }
    }




    //===================================================================
    public static void BackNavigate() throws IOException {
        driver.hideKeyboard();

    }





    public void scrollVertically(int defaultScrollCount) {
        Dimension dimension = driver.manage().window().getSize();
        int scrollStart = (int) (dimension.getHeight() * 0.5);
        int scrollEnd = (int) (dimension.getHeight() * 0.2);
        int widthHalf = (int) (dimension.getWidth() * 0.5);

        try {
            int count = defaultScrollCount;
            for (int i = 0; i < count; i++) {
                // Modify this condition as needed based on your requirements
                swipeCoordinates(widthHalf, scrollStart, widthHalf, scrollEnd);
            }
        } catch (Exception e) {
            System.out.println("Scroll to mobile element failed");
        }
    }

    public void scrollVertically1(int defaultScrollCount) {
        Dimension dimension = driver.manage().window().getSize();
        int scrollStart = (int) dimension.getHeight();
        int scrollEnd = (int) (dimension.getHeight() * 0.1879);
        //int scrollEnd = 450;
        int widthHalf = (int) (dimension.getWidth() * 0.5);

        try {
            int count = defaultScrollCount;
            for (int i = 0; i < count; i++) {
                // Modify this condition as needed based on your requirements
                swipeCoordinates(widthHalf, scrollStart, widthHalf, scrollEnd);
            }
        } catch (Exception e) {
            System.out.println("Scroll to mobile element failed");
        }
    }

    public void scrollDeliveryItemsUpwards(int defaultScrollCount) {
        Dimension dimension = driver.manage().window().getSize();
        int scrollStart = (int) dimension.getHeight();
        int scrollEnd = (int) (dimension.getHeight() * 0.3838);
        int widthHalf = (int) (dimension.getWidth() * 0.5);

        try {
            int count = defaultScrollCount;
            for (int i = 0; i < count; i++) {
                // Modify this condition as needed based on your requirements
                swipeCoordinates(widthHalf, scrollStart, widthHalf, scrollEnd);
            }
        } catch (Exception e) {
            System.out.println("Scroll to mobile element failed");
        }
    }

    public void scrollDeliveryItemsDownward(int defaultScrollCount) {
        Dimension dimension = driver.manage().window().getSize();
        int scrollEnd = (int) dimension.getHeight();
        int scrollStart = (int) (dimension.getHeight() * 0.3838);
        int widthHalf = (int) (dimension.getWidth() * 0.5);

        try {
            int count = defaultScrollCount;
            for (int i = 0; i < count; i++) {
                // Modify this condition as needed based on your requirements
                swipeCoordinates(widthHalf, scrollStart, widthHalf, scrollEnd);
            }
        } catch (Exception e) {
            System.out.println("Scroll to mobile element failed");
        }
    }

    public void scrollVertically2(int defaultScrollCount) {
        Dimension dimension = driver.manage().window().getSize();
        int scrollEnd = (int) dimension.getHeight();
        int scrollStart = (int) (dimension.getHeight() * 0.1879);
        int widthHalf = (int) (dimension.getWidth() * 0.5);

        try {
            int count = defaultScrollCount;
            for (int i = 0; i < count; i++) {
                // Modify this condition as needed based on your requirements
                swipeCoordinates(widthHalf, scrollStart, widthHalf, scrollEnd);
            }
        } catch (Exception e) {
            System.out.println("Scroll to mobile element failed");
        }
    }

    public void scrollVerticallyUpwards(int defaultScrollCount) {
        Dimension dimension = driver.manage().window().getSize();
        int scrollStart = (int) (dimension.getHeight() * 0.2);   // Start from 20% of the height
        int scrollEnd = (int) (dimension.getHeight() * 0.8);     // End at 80% of the height
        int widthHalf = (int) (dimension.getWidth() * 0.5);

        try {
            int count = defaultScrollCount;
            for (int i = 0; i < count; i++) {
                // Modify this condition as needed based on your requirements
                swipeCoordinatesup(widthHalf, scrollStart, widthHalf, scrollEnd);
            }
        } catch (Exception e) {
            System.out.println("Scroll downwards to mobile element failed");
        }
    }

    public void scrollHU_Upwards(int defaultScrollCount) {
        Dimension dimension = driver.manage().window().getSize();
        int scrollStart = (int) dimension.getHeight();
        int scrollEnd = (int) (dimension.getHeight() * 0.3838);
        int widthHalf = (int) (dimension.getWidth() * 0.5);

        try {
            int count = defaultScrollCount;
            for (int i = 0; i < count; i++) {
                // Modify this condition as needed based on your requirements
                swipeCoordinates(widthHalf, scrollStart, widthHalf, scrollEnd);
            }
        } catch (Exception e) {
            System.out.println("Scroll to mobile element failed");
        }
    }

    public void scrollHU_Downward(int defaultScrollCount) {
        Dimension dimension = driver.manage().window().getSize();
        int scrollEnd = (int) dimension.getHeight();
        int scrollStart = (int) (dimension.getHeight() * 0.3838);
        int widthHalf = (int) (dimension.getWidth() * 0.5);

        try {
            int count = defaultScrollCount;
            for (int i = 0; i < count; i++) {
                // Modify this condition as needed based on your requirements
                swipeCoordinates(widthHalf, scrollStart, widthHalf, scrollEnd);
            }
        } catch (Exception e) {
            System.out.println("Scroll to mobile element failed");
        }
    }

    public void scrollHU_ItemsUpward(int scrollStartHeight, int defaultScrollCount) {
        Dimension dimension = driver.manage().window().getSize();
        //int scrollStart = (int) dimension.getHeight();
        int scrollStart = scrollStartHeight;
        int scrollEnd = (int) (dimension.getHeight() * 0.3824);
        int widthHalf = (int) (dimension.getWidth() * 0.5);

        try {
            int count = defaultScrollCount;
            for (int i = 0; i < count; i++) {
                // Modify this condition as needed based on your requirements
                swipeCoordinates(widthHalf, scrollStart, widthHalf, scrollEnd);
            }
        } catch (Exception e) {
            System.out.println("Scroll to mobile element failed");
        }
    }

    public void scrollHU_ItemsDownwards(int scrollEndHeight, int defaultScrollCount) {
        Dimension dimension = driver.manage().window().getSize();
        int scrollStart = (int) (dimension.getHeight() * 0.3824);
        int scrollEnd = scrollEndHeight;
        int widthHalf = (int) (dimension.getWidth() * 0.5);

        try {
            int count = defaultScrollCount;
            for (int i = 0; i < count; i++) {
                // Modify this condition as needed based on your requirements
                swipeCoordinates(widthHalf, scrollStart, widthHalf, scrollEnd);
            }
        } catch (Exception e) {
            System.out.println("Scroll to mobile element failed");
        }
    }

    private void swipeCoordinatesup(int startx, int starty, int endx, int endy) {
        TouchAction<?> touchAction = new TouchAction<>(driver);
        touchAction.press(PointOption.point(startx, starty))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
                .moveTo(PointOption.point(endx, endy))
                .release()
                .perform();
    }

    public void refreshPage() {
        Dimension size = driver.manage().window().getSize();
        int starty = (int) (size.height * 0.5);
        int endy = (int) (size.height);
        int startx = (int) (size.width / 2);
        try {
            System.out.println("Trying to swipe up from x:" + startx + " y:" + starty + ", to x:" + startx + " y:" + endy);
            new TouchAction(driver).press(point(startx, starty)).waitAction(waitOptions(ofSeconds(3))).moveTo(point(startx, endy)).release().perform();
        } catch (Exception e) {
            System.out.println("Swipe did not complete successfully.");
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void scrollDeliveryItemsUpwardsPicker(int defaultScrollCount) {
        Dimension dimension = driver.manage().window().getSize();

        int scrollStart = (int) dimension.getHeight();
        // System.out.println(scrollStart+"===================scrollStart");
        // int scrollEnd = (int) (dimension.getHeight() * 0.3838);
        //  scrool    form 1198--->326,         326,  1198   326/1198    0.2751
       int scrollEnd = (int) (dimension.getHeight() * 0.4340);
        //  int scrollEnd = (int) (dimension.getHeight() * 0.4340);



        // System.out.println(scrollEnd+"========================scrollEnd");
        int widthHalf = (int) (dimension.getWidth() * 0.5);
        //Trying to swipe up from x:360 y:555, to x:360 y:1198

        try {
            int count = defaultScrollCount;
            for (int i = 0; i < count; i++) {
                // Modify this condition as needed based on your requirements
                swipeCoordinates(widthHalf, scrollStart, widthHalf, scrollEnd);
                //Trying to swipe up from x:360 y:1198, to x:360 y:135
            }
        } catch (Exception e) {
            System.out.println("Scroll to mobile element failed");
        }
    }
    //======================================================================
    public void scrollItemsUpward(int defaultScrollCount) {
        Dimension dimension = driver.manage().window().getSize();
     //  x:360 y:1198, to x:360 y:446
        int scrollStart = (int) dimension.getHeight();
        // System.out.println(scrollStart+"===================scrollStart");
        // int scrollEnd = (int) (dimension.getHeight() * 0.3838);
        //  scrool       396/1062    0.3728
        int scrollEnd = (int) (dimension.getHeight() * 0.3728);
        //  int scrollEnd = (int) (dimension.getHeight() * 0.4340);



        // System.out.println(scrollEnd+"========================scrollEnd");
        int widthHalf = (int) (dimension.getWidth() * 0.5);
        //Trying to swipe up from x:360 y:555, to x:360 y:1198

        try {
            int count = defaultScrollCount;
            for (int i = 0; i < count; i++) {
                // Modify this condition as needed based on your requirements
                swipeCoordinates(widthHalf, scrollStart, widthHalf, scrollEnd);
                //Trying to swipe up from x:360 y:1198, to x:360 y:135
            }
        } catch (Exception e) {
            System.out.println("Scroll to mobile element failed");
        }
    }
    //================================
    public void scrollItemsDownward(int defaultScrollCount) {
        Dimension dimension = driver.manage().window().getSize();
        int scrollEnd = (int) dimension.getHeight();
        // System.out.println(scrollEnd+"=================scrollEnd");
        //   int scrollStart = (int) (dimension.getHeight() * 0.3838);
        int scrollStart = (int) (dimension.getHeight() * 0.3600);//0.4641
        // System.out.println(scrollStart+"=======================scrollStart");

        int widthHalf = (int) (dimension.getWidth() * 0.5);

        try {
            int count = defaultScrollCount;
            for (int i = 0; i < count; i++) {
                // Modify this condition as needed based on your requirements
                swipeCoordinates(widthHalf, scrollStart, widthHalf, scrollEnd);
            }
        } catch (Exception e) {
            System.out.println("Scroll to mobile element failed");
        }
    }



    //============================================================================
    public void scrollDeliveryItemsDownwardPicker(int defaultScrollCount) {
        Dimension dimension = driver.manage().window().getSize();
        int scrollEnd = (int) dimension.getHeight();
        // System.out.println(scrollEnd+"=================scrollEnd");
        //   int scrollStart = (int) (dimension.getHeight() * 0.3838);
        int scrollStart = (int) (dimension.getHeight() * 0.4340);//0.4641
        // System.out.println(scrollStart+"=======================scrollStart");

        int widthHalf = (int) (dimension.getWidth() * 0.5);

        try {
            int count = defaultScrollCount;
            for (int i = 0; i < count; i++) {
                // Modify this condition as needed based on your requirements
                swipeCoordinates(widthHalf, scrollStart, widthHalf, scrollEnd);
            }
        } catch (Exception e) {
            System.out.println("Scroll to mobile element failed");
        }
    }
//===========================================================================================

}
