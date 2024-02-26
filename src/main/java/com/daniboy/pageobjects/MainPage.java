package com.daniboy.pageobjects;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class MainPage extends BasePage {
    @AndroidFindBy(xpath = "(//android.view.View[@class=\"android.view.View\"])[7]")
    private WebElement btnMenu;

    public MainPage(AndroidDriver driver) {
        super(driver);
    }

    public void openMenu() {
        btnMenu.click();
    }
}
