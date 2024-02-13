package com.daniboy;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.AutomationName;
import org.openqa.selenium.Platform;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseCittamobiTest {

    protected AndroidDriver driver;
    protected UiAutomator2Options options;

    @BeforeClass
    public void setup() {
        options = getAndroidCittamobiOptions();
        try {
            driver = new AndroidDriver(new URL("http://127.0.0.1:4723/"), options);
        } catch (MalformedURLException exception) {
            System.out.println("Exception! " + exception.getLocalizedMessage());
        }
        options.setAppActivity(".MainActivity");
    }

    private UiAutomator2Options getAndroidCittamobiOptions() {
        UiAutomator2Options options = new UiAutomator2Options();

        options.setAutomationName(AutomationName.ANDROID_UIAUTOMATOR2); //Optional. It's the default value.
        options.setPlatformName(Platform.ANDROID.name()); //Optional. It's the default value.

        options.setDeviceName("emulator-5554");

        options.setAppPackage("br.com.cittabus");
        options.setApp(System.getProperty("user.dir") + "/apps/cittamobi-7.2.8-hml.apk");
        options.autoGrantPermissions();

        return options;
    }

    @AfterClass // It was AfterTest, but then it was causing flaky tests when all testes were executed in testng.xml. With AfterClass I'm isolating more the testes and everything is running good! ;)
    public void teardown() {
        driver.quit();
    }
}
