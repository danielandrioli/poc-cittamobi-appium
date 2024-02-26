package com.daniboy.pageobjects.onboarding;

import com.daniboy.pageobjects.BasePage;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class PrivacyPolicyPage extends BasePage {
    @AndroidFindBy(accessibility = "I accept the Terms of Use and Privacy Policies of Cittamobi")
    private WebElement cbAcceptPrivacyPolicy;
    @AndroidFindBy(accessibility = "I accept the Terms and Conditions of Use and Data Sharing.")
    private WebElement cbAcceptDataSharing;
    @AndroidFindBy(accessibility = "Accept and continue")
    private WebElement btnAcceptAndContinue;

    public PrivacyPolicyPage(AndroidDriver driver) {
        super(driver);
    }

    public PrivacyPolicyPage scrollToBottom() {
        String uiAutomatorText = "new UiScrollable(new UiSelector().scrollable(true).instance(0))" +
                ".scrollToEnd(10)"; //parâmetro do scrollToEnd é maxSwipes

        // https://developer.android.com/reference/androidx/test/uiautomator/UiSelector
        https://developer.android.com/reference/androidx/test/uiautomator/UiScrollable#scrollToEnd(int,int)
        driver.findElement(AppiumBy.androidUIAutomator(uiAutomatorText));

        return this;
    }

    public PrivacyPolicyPage acceptPrivacyPolicy() {
        cbAcceptPrivacyPolicy.click();
        return this;
    }

    public PrivacyPolicyPage acceptDataSharing() {
        cbAcceptDataSharing.click();
        return this;
    }

    public DataPrivacyPage clickOnAcceptAndContinue() {
        btnAcceptAndContinue.click();
        return new DataPrivacyPage(driver);
    }

}
