package com.DmartLabs.bdd.pages;

import com.DmartLabs.commonutils.Gestures;
import com.DmartLabs.commonutils.QXClient;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.FieldDecorator;
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
}
