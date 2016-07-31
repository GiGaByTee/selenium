package com.gmail.bo;

import com.gmail.pages.gmail.GmailLoginPage;
import com.gmail.pages.gmail.GmailMainPage;
import com.gmail.pages.gmail.SendMessagePage;
import com.gmail.utilities.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by nazar on 7/12/16.
 */
public class GmailWorker {
    static GmailLoginPage gmailLoginPage;
    static GmailMainPage gmailMainPage;
    static SendMessagePage sendMessagePage;
    //static private SelendroidLauncher selendroidServer = null;
    static private WebDriver driver = null;

    public static void setup() throws Exception {
        driver = DriverFactory.getDriver(DriverFactory.BrowserType.APPIUM);
        gmailLoginPage = PageFactory.initElements(driver,GmailLoginPage.class);
        gmailMainPage = PageFactory.initElements(driver,GmailMainPage.class);
        sendMessagePage = PageFactory.initElements(driver,SendMessagePage.class);

    }

    public static void finish(){
        DriverFactory.closeDriver();
    }

    public static void login(String email, String password){
        driver.manage().deleteAllCookies();
        driver.get("http://www.gmail.com");
        gmailLoginPage.clickSignIn();
        gmailLoginPage.setTextEmailLogin(email);
        gmailLoginPage.submitEmail();
        gmailLoginPage.setTextPasswordLogin(password);
        gmailLoginPage.submitPassword();
        gmailLoginPage.goToMobileVersion();
    }

    public static void sendMessage(String email,String text){
        gmailMainPage.compose();
        sendMessagePage.setEmail(email);
        sendMessagePage.setMessage(text);
        sendMessagePage.sendMessage();
        gmailMainPage.refreshMailbox();
    }

    public static void clickTheNewestMessage(){
        gmailMainPage.clickTheNewestMessage();
    }

    public static String getInfoFromMessage(){
        return gmailMainPage.messageInfo();
    }

    public static void refreshMailbox(){
        gmailMainPage.refreshMailbox();
    }

    public static int getMessageCount(){
        return gmailMainPage.getMessageCount();
    }
}
