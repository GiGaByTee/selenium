package com.gmail.pages.contmanager;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

/**
 * Created by nazar on 7/23/16.
 */
public class ContactListScreen extends BaseScreen{
    @FindBy(className = "android.widget.LinearLayout")List<WebElement> contactList;
   // @FindBy(className = "android.widget.TextView") List<WebElement> contactInfo;
    public ContactListScreen(AndroidDriver driver){
        super(driver);
        loadPage();
    }

    public String[] getContactInfo(){
        List<WebElement> list = contactList.get(contactList.size()-1).findElements(By.className("android.widget.TextView"));
        return new String[]{list.get(0).getText(),list.get(1).getText(),list.get(2).getText(),list.get(3).getText()};
    }
}
