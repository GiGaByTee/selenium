package com.gmail.bo;

import com.gmail.pages.empdir.DetailedInfoScreen;
import com.gmail.pages.empdir.MainScreen;
import com.gmail.utilities.DriverFactory;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.support.PageFactory;

import java.awt.print.PageFormat;

/**
 * Created by nazar on 7/17/16.
 */
public class EmpDirWorker {
    static MainScreen mainScreen;
    static DetailedInfoScreen detailedInfoScreen;
    static AndroidDriver driver;

    public static void setup(){
        driver = (AndroidDriver) DriverFactory.getDriver(DriverFactory.BrowserType.APPIUM_HYBRID);
        mainScreen = new MainScreen(driver);
        detailedInfoScreen = new DetailedInfoScreen(driver);

    }

    public static void close(){
        DriverFactory.closeDriver();
    }

    public static void switchToWeb(){
        mainScreen.switchToWebView();
    }


    public static void searchByName(String name){
        mainScreen.search(name);
    }

    public static boolean verifyManagerName(String name){
        return detailedInfoScreen.verifyManagerName(name);
    }

    public static void clearInput(){
        mainScreen.clearInputBox();
    }

    public static void navigateBack(){
        detailedInfoScreen.navigateToMainScreen();
    }

    public static ScreenOrientation rotate(){
        return  mainScreen.rotateScreen();
    }

    public static String getUrl(){
       return driver.getCurrentUrl();
    }

    public  static String getTextFromInput(){
        return mainScreen.getText();
    }

    public static void clickOnEmployee(String name){
        mainScreen.clickOnEmp(name);
    }

    public static boolean isInputBoxPresent(){
        return mainScreen.presenceOfInput();
    }

    public static void clickAdd() throws InterruptedException {
        detailedInfoScreen.clickAdd();
    }

    public static void takeScreenshot(){
        mainScreen.takeScreenShot("nazar");
    }

    public static String getContext(){
        return driver.getContext();
    }
}
