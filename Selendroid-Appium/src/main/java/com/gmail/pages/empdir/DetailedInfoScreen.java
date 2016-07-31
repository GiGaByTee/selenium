package com.gmail.pages.empdir;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by nazar on 7/17/16.
 */
public class DetailedInfoScreen extends BaseScreen {
    @FindBy(xpath = "/html/body/div/div[2]/div/ul/li[5]") WebElement go;

    public DetailedInfoScreen(AndroidDriver driver) {
        super(driver);
        loadPage();
    }

    public MainScreen navigateToMainScreen() {
        driver.navigate().back();
        try {
            Thread.sleep(800);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new MainScreen(driver);
    }


    public boolean verifyManagerName(String employeeName) {
        return isElementPresent(MobileBy.AndroidUIAutomator("new UiSelector().descriptionContains(\"" + employeeName
                + "\")"));
    }

    public void clickAdd() throws InterruptedException {
        go.click();
        driver.pressKeyCode(AndroidKeyCode.BACK);

    }
}
