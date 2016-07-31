package com.gmail.pages.gmail;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

/**
 * Created by nazar on 7/12/16.
 */
public class BasePage {
    public WebDriver driver;

    public String PAGE_URL;
    public String PAGE_TITLE;

    public BasePage(WebDriver driver){
        this.driver = driver;
    }

    public void loadPage(){
        driver.get(PAGE_URL);
        //Assert.assertEquals(driver.getTitle(), PAGE_TITLE);
    }

    public void clickElement(WebElement element){
        element.click();
    }

    public void setElementText(WebElement element, String text){
        // element.clear();
        element.sendKeys(text);
        //Assert.assertEquals(element.getAttribute("value"), text);
    }
}
