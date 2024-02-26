package com.daniboy.pageobjects.onboarding;

import com.daniboy.pageobjects.BasePage;
import com.daniboy.pageobjects.MainPage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class DataPrivacyPage extends BasePage {
    @AndroidFindBy(accessibility = "Accept and continue")
    private WebElement btnAcceptAndContinue;

    public DataPrivacyPage(AndroidDriver driver) {
        super(driver);
    }

    public MainPage clickOnAcceptAndContinueDataPrivacy() {
        btnAcceptAndContinue.click();
        return new MainPage(driver);
    }
}
