package com.gmail.pages.empdir;

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
 * Created by nazar on 7/17/16.
 */
public class BaseScreen {
    @AndroidFindBy(className = "android.webkit.WebView") public WebElement androidWebView;
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

    public void switchToWebView() {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(androidWebView));
        Set<String> contextSet = driver.getContextHandles();
        for (String contextName : contextSet) {
            if (!contextName.contains("NATIVE_APP")) {
                driver.context(contextName);
                break;
            }
        }
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

