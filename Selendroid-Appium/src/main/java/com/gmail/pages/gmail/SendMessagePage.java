package com.gmail.pages.gmail;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by nazar on 7/12/16.
 */
public class SendMessagePage extends BasePage {
    public SendMessagePage(WebDriver driver) {
        super(driver);
    }

    //@FindBy(css=".mr") WebElement emailField;
    @FindBy(xpath = "//*[@id=\"composeto\"]") WebElement emailField;

   // @FindBy(css=".Fr") WebElement messageField;
    @FindBy(xpath = "//*[@id=\"cmcbody\"]") WebElement messageField;
    @FindBy(xpath = "//*[text() = 'Надіслати']") WebElement sendButton;

    public void setEmail(String email){
        emailField.sendKeys(email);
    }

    public void setMessage(String text){
        messageField.sendKeys(text);
    }

    public void sendMessage(){
        sendButton.click();
    }
}
