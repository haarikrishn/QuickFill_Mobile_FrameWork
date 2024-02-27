package com.DmartLabs.bdd.pages;

import com.DmartLabs.commonutils.Gestures;
import com.DmartLabs.commonutils.QXClient;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class ArticleDetailsPage {

    public ArticleDetailsPage(){
        PageFactory.initElements(new AppiumFieldDecorator(QXClient.get().driver()), this);
    }

    @FindBy(id = "com.dmartlabs.pwp:id/txt_aad_title")
    private MobileElement articleDetailsPageTitle;

    @FindBy(id = "com.dmartlabs.pwp:id/ib_aad_forward")
    private MobileElement addBoxes;

    @FindBy(id = "com.dmartlabs.pwp:id/ib_aad_backward")
    private MobileElement removeBoxes;

    @FindBy(id = "com.dmartlabs.pwp:id/btn_aad_cancel")
    private MobileElement cancelBtn;

    @FindBy(id = "com.dmartlabs.pwp:id/btn_aad_confirm")
    private MobileElement confirmBtn;
    Gestures gestures;

    public void verifyLoaderIsInArticleDetailPage(){
        gestures = QXClient.get().gestures();
        Assert.assertTrue(gestures.isElementPresent(articleDetailsPageTitle));
    }

    public void adjustItemBoxes(int totalBoxes) {
        for (int i=0; i<totalBoxes; i++){
            addBoxes.click();
        }
        confirmBtn.click();
    }

    public int[] adjustBoxesQuantity(String actions, int quantityAdjustment, int totalBoxes, int loadedBoxes, int expectedLoadedBoxes, int expectedLoadedArticle) {
        int []loadingProgress = null;
        gestures = QXClient.get().gestures();
        if (actions.equals("removeBoxesQuantity")){
            loadingProgress = decreaseBoxesQuantity(quantityAdjustment, totalBoxes, loadedBoxes, expectedLoadedBoxes, expectedLoadedArticle);
        } else if (actions.equals("addBoxesQuantity")){
            loadingProgress = increaseBoxesQuantity(quantityAdjustment, totalBoxes, loadedBoxes, expectedLoadedBoxes, expectedLoadedArticle);
        }
        return loadingProgress;
    }

    private int[] increaseBoxesQuantity(int quantityAdjustment, int totalBoxes, int loadedBoxes, int expectedLoadedBoxes, int expectedLoadedArticle) {
        int[] loadingProgress = new int[2];
        gestures.isElementPresent(addBoxes);
        if (quantityAdjustment<=totalBoxes && (loadedBoxes+quantityAdjustment)<=totalBoxes){
            for (int i=0; i<quantityAdjustment;i++)
                addBoxes.click();

            QXClient.get().report().info("Loaded Boxes Quantity is adjusted");
            confirmBtn.click();
        } else {
            System.out.println("Boxes quantity adjustment request is more than actual loaded Boxes !!!!!");
            QXClient.get().report().info("Boxes quantity adjustment request is more than actual loaded Boxes");
            cancelBtn.click();
            loadingProgress[0] = expectedLoadedBoxes;
            loadingProgress[1] = expectedLoadedArticle;
            return loadingProgress;
        }

        loadingProgress[0] = expectedLoadedBoxes + quantityAdjustment;
        loadingProgress[1] = expectedLoadedArticle + 1;
        return loadingProgress;
    }

    private int[] decreaseBoxesQuantity(int quantityAdjustment, int totalBoxes, int loadedBoxes, int expectedLoadedBoxes, int expectedLoadedArticle) {

        int[] loadingProgress = new int[2];
        gestures.isElementPresent(removeBoxes);
        if (quantityAdjustment<=loadedBoxes){
            for (int i=quantityAdjustment; i>0; i--)
                removeBoxes.click();

            QXClient.get().report().info("Loaded Boxes Quantity is adjusted");
            confirmBtn.click();
        } else {
            System.out.println("Boxes quantity adjustment request is more than actual loaded Boxes !!!!!");
            QXClient.get().report().info("Boxes quantity adjustment request is more than actual loaded Boxes");
            cancelBtn.click();
            loadingProgress[0] = expectedLoadedBoxes;
            loadingProgress[1] = expectedLoadedArticle;
            return loadingProgress;
        }
        loadingProgress[0] = expectedLoadedBoxes - quantityAdjustment;
        loadingProgress[1] = expectedLoadedArticle - 1;
        return loadingProgress;
    }
}
