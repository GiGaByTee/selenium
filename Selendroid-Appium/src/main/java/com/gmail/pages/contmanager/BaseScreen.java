package com.gmail.pages.contmanager;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.util.Set;

/**
 * Created by nazar on 7/23/16.
 */
public class BaseScreen {
    public AndroidDriver driver;

    public BaseScreen(AndroidDriver driver) {
        this.driver = driver;
    }

    public void loadPage(){
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public ScreenOrientation rotateScreen() {
        driver.rotate(ScreenOrientation.LANDSCAPE);
        return driver.getOrientation();
    }


    public void takeScreenShot(String fileName) {
        File file = new File(fileName + ".png");
        File tmpFile = driver.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(tmpFile, file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}

