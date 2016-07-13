package com.gmail.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;

/**
 * Created by nazar on 7/12/16.
 */
public class GmailMainPage extends BasePage {
    @FindBy(xpath = "//*[@class='Rl']") WebElement messageCount;
    @FindBy(css = ".lc") WebElement composeButton;
    @FindBy(xpath = "//*[@aria-label='Оновити']") WebElement refreshButton;
    @FindBy(xpath = "//*[@role='list']") WebElement messageList;
    @FindBy(xpath = "//*[@class='gi hi ']") WebElement messageText;


    public GmailMainPage(WebDriver driver) {
        super(driver);
        PAGE_URL="http://www.gmail.com";
        PAGE_TITLE="Gmail inbox";
    }

    public void loadPage(){
        //driver.get(PAGE_URL);
    }

    public int getMessageCount(){
        return Integer.parseInt(messageCount.getText());
    }

    public void compose(){
        composeButton.click();
    }

    public void refreshMailbox(){
        refreshButton.click();
        try {
            Thread.sleep(1600);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void clickTheNewestMessage(){
        messageList.findElement(By.cssSelector(":first-child")).click();
    }

    public String messageInfo(){
        return messageText.getText();
    }


}
