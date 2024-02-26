package com.daniboy.tests;

import com.daniboy.BaseCittamobiTest;
import com.daniboy.pageobjects.MainPage;
import com.daniboy.pageobjects.onboarding.PrivacyPolicyPage;
import org.testng.annotations.Test;

public class TestTest extends BaseCittamobiTest {

    @Test
    public void acceptingTermsOnboarding() {
        PrivacyPolicyPage ppp = new PrivacyPolicyPage(driver);
        ppp.scrollToBottom()
                .acceptPrivacyPolicy()
                .acceptDataSharing()
                .clickOnAcceptAndContinue()
                .clickOnAcceptAndContinueDataPrivacy();
    }

    @Test(dependsOnMethods = "acceptingTermsOnboarding")
    public void openingMenu() {
        new MainPage(driver).openMenu();
    }

}
