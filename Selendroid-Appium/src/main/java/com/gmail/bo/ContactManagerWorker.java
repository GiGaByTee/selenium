package com.gmail.bo;

import com.gmail.pages.contmanager.AddContactScreen;
import com.gmail.pages.contmanager.ContactListScreen;
import com.gmail.pages.empdir.DetailedInfoScreen;
import com.gmail.pages.empdir.MainScreen;
import com.gmail.utilities.DriverFactory;
import io.appium.java_client.android.AndroidDriver;

/**
 * Created by nazar on 7/23/16.
 */
public class ContactManagerWorker {
    static AddContactScreen addContactScreen;
    static ContactListScreen contactListScreen;
    static AndroidDriver driver;

    public static void setup(){
        driver = (AndroidDriver) DriverFactory.getDriver(DriverFactory.BrowserType.APPIUM_NATIVE);
        addContactScreen = new AddContactScreen(driver);
        contactListScreen = new ContactListScreen(driver);
    }

    public static void close(){
        DriverFactory.closeDriver();
    }

    public static void addContact(String name, String phone, String address, String email){
        addContactScreen.setName(name);
        addContactScreen.setPhone(phone);
        addContactScreen.setEmail(email);
        addContactScreen.setAddress(address);
        addContactScreen.addContactToList();
    }

    public static void goToContactList(){
        addContactScreen.goToContactList();
    }

    public static String[] getLastContactInfo(){
        return contactListScreen.getContactInfo();
    }
}
