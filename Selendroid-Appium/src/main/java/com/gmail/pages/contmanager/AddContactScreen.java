package com.gmail.pages.contmanager;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

/**
 * Created by nazar on 7/23/16.
 */
public class AddContactScreen extends BaseScreen{
    @FindBy(id = "txtName") WebElement fieldName;
    @FindBy(id = "txtPhone") WebElement fieldPhone;
    @FindBy(id = "txtEmail") WebElement fieldEmail;
    @FindBy(id = "txtAddress") WebElement fieldAddress;
    @FindBy(id = "btnAdd") WebElement addButton;
    @FindBy(className = "android.widget.LinearLayout")
    List<WebElement> contactListButton;
    public AddContactScreen(AndroidDriver driver){
        super(driver);
        loadPage();
    }

    public void goToContactList(){
        contactListButton.get(6).click();
    }

    public void setName(String name){
        fieldName.sendKeys(name);
    }

    public void setPhone(String phone){
        fieldPhone.sendKeys(phone);
    }

    public void setAddress(String address){
        fieldAddress.sendKeys(address);
    }

    public void setEmail(String email){
        fieldEmail.sendKeys(email);
    }

    public void addContactToList(){
        addButton.click();
    }
}
