package com.DmartLabs.bdd.pages;

import com.DmartLabs.commonutils.QXClient;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PickListPage {

    public PickListPage(){
        PageFactory.initElements(new AppiumFieldDecorator(QXClient.get().driver()), this);
    }

    @FindBy(id = "com.dmartlabs.pwp:id/txt_pl_title ")
    private MobileElement pickListPage;
}
