package com.gmail.data;

import org.testng.annotations.DataProvider;

/**
 * Created by nazar on 7/18/16.
 */
public class ContactManagerData {
    @DataProvider(name="contactIfo")
    public static Object[][] contactInfo(){
        return new Object[][]{
                {"Nazar", "09712345667", "email@gmail.com", "Yantarne"},
               /* {"Nazar", "09712345667", "email@gmail.com", "Yantarne"},
                {"Nazar", "09712345667", "email@gmail.com", "Yantarne"},
                {"Nazar", "09712345667", "email@gmail.com", "Yantarne"},
                {"Nazar", "09712345667", "email@gmail.com", "Yantarne"},
                {"Nazar", "09712345667", "email@gmail.com", "Yantarne"},
                {"Nazar", "09712345667", "email@gmail.com", "Yantarne"},
                {"Nazar", "09712345667", "email@gmail.com", "Yantarne"},
                {"Nazar", "09712345667", "email@gmail.com", "Yantarne"},
                {"Nazar", "09712345667", "email@gmail.com", "Yantarne"},
                {"Oleg", "09712345667", "email@gmail.com", "Yantarne"},
                {"Nazar", "09712345667", "email@gmail.com", "Yantarne"},
                {"Nazar", "09712345667", "email@gmail.com", "Yantarne"},
                {"Nazar", "09712345667", "email@gmail.com", "Yantarne"},
                {"Nazar", "09712345667", "email@gmail.com", "Yantarne"},
                {"Nazar", "09712345667", "email@gmail.com", "Yantarne"},
                {"Nazar", "09712345667", "email@gmail.com", "Yantarne"}*/
        };
    }
}
