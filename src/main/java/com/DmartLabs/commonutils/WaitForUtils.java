package com.DmartLabs.commonutils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;

public class WaitForUtils {
  public AppiumDriver driver;
  WebDriverWait wait = null;

  public WaitForUtils(AppiumDriver driver) {
    this.driver = driver;
  }

  public void waitTillTheElementIsVisibleAndClickable(MobileElement element) {
    WebDriverWait wait = new WebDriverWait(driver, 20);
    wait.until(ExpectedConditions.visibilityOf(element));
    wait = new WebDriverWait(driver, 5);
    wait.until(ExpectedConditions.elementToBeClickable(element));
  }

  /**
     * This will Wait maximum 20 secs for the list to have atleast one element.
     *
     * @author :
     * @since :
     */
  public void waitTillListHasElements(List<MobileElement> list) {
    for (byte i = 1; list.size() == 0 && i <= 20; i++) {
      waitInSec(1);
    }
  }

  public void waitTillTheElementInVisible(MobileElement element) {
    WebDriverWait wait = new WebDriverWait(driver, 30);
    wait.until(ExpectedConditions.invisibilityOf(element));
  }

  public void waitForPageToLoad(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

  public void waitForElementState(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.stalenessOf(element));
        wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

  public void waitForPageToLoad(List<WebElement> elementList) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfAllElements(elementList));
    }

  public void waitForElementToDisAppear(List<WebElement> elementList, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.until(ExpectedConditions.invisibilityOfAllElements(elementList));
    }

  public void waitForElementToAppear(MobileElement element) {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

  public void waitForElementToAppear(WebElement element, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

  public WebElement waitForElement(WebElement arg) {
        waitForPageToLoad(arg);
        WebElement el = arg;
        return el;
    }

  public void WaitForFrameAndSwitchToIt(String id) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(id));
    }

  public void WaitForFrameAndSwitchToIt(int id) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(id));
    }

  public void ScrollToElement(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

  public void waitForElements(List<WebElement> elementList) {
        waitForPageToLoad(elementList);
    }

  public void waitForElementToAppearOnScreen(MobileElement arg) {
        waitForElementToAppear(arg);
    }

  public void clickUntilElementExists(WebElement element, By by) {
        boolean elementOnScreen;
        int i = 0;
        do {
            if (i == 25) {
                break;
            }
            try {
                driver.findElement(by);
                break;
            } catch (NoSuchElementException e) {
                element.click();
                elementOnScreen = false;
                System.out.println(i);
            }
            i++;
        } while (!elementOnScreen);
    }

  public String getCurrentMethodName() {
        return Thread.currentThread().getStackTrace()[2].getMethodName();
    }

  /**
     * This Function is to check the element is present or not
     *
     * @author
     * @param:
     */
  public boolean isElementDisplayed(MobileElement element) {
        try {
            if (element.isDisplayed())
                System.out.println("Element present on screen ***********" + element);
            return true;
        } catch (NoSuchElementException e) {
            System.out.println("Element not present on screen **************" + element);
            return false;
        }
    }

  /**
     * This Function will pause the execution for given secs.
     *
     * @param secs : No of seconds to be paused.
     * @author
     */
  public void waitInSec(int secs) {
        try {
            Thread.sleep(secs * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

  /**
     * This Function is to Wait till element visible
     *
     * @author
     * @param: Mobile Element & String
     */
  public void waitTillTheElementIsVisible(MobileElement element) {
        WebDriverWait wait = new WebDriverWait(driver, 50);
        wait.until(ExpectedConditions.visibilityOf(element));
    }
}
