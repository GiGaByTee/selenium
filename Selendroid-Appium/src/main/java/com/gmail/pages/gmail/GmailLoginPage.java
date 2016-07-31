package com.gmail.pages.gmail;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by nazar on 7/12/16.
 */
public class GmailLoginPage extends BasePage {
    WebDriverWait wait = new WebDriverWait(driver, 10);
    @FindBy(id = "Email") WebElement fieldEmail;
    @FindBy(id = "Passwd") WebElement fieldPassword;
    @FindBy(css = ".to a") WebElement linkToMobileVersion;
    @FindBy(xpath = "//*[@id=\"gmail-sign-in\"]") WebElement signInButton;

    public GmailLoginPage(WebDriver driver) {
        super(driver);
        PAGE_URL="http://www.gmail.com";
        PAGE_TITLE="Gmail";
    }


    public void clickSignIn(){
        signInButton.click();
    }

    public void setTextEmailLogin(String text){
        setElementText(fieldEmail, text);
    }

    public void setTextPasswordLogin(String text){
        setElementText(fieldPassword, text);
    }

    public void submitEmail(){
        fieldEmail.submit();
    }

    public void submitPassword(){
        fieldPassword.submit();
    }
    public void goToMobileVersion(){

        wait.until(ExpectedConditions.visibilityOf(linkToMobileVersion));
        linkToMobileVersion.click();
    }
}
