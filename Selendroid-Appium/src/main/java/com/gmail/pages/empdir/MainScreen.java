package com.gmail.pages.empdir;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by nazar on 7/17/16.
 */
public class MainScreen extends BaseScreen {
    //@AndroidFindBy(className = "android.widget.EditText") public WebElement inputBox;
    @FindBy(tagName = "input") public WebElement inputBox;
    public MainScreen(AndroidDriver driver) {
        super(driver);
        loadPage();
    }

    public void search(String name) {
        inputBox.sendKeys(name);
        driver.pressKeyCode(66);
    }

    public void clickOnEmp(String name){
        driver.findElement(By.partialLinkText(name)).click();
    }

    public String getText(){
        return inputBox.getText();
    }
    public void clearInputBox(){
        inputBox.clear();
    }

    public boolean presenceOfInput(){
        return inputBox.isDisplayed();
    }
}
