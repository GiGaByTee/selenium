package com.gmail.data;

import org.testng.annotations.DataProvider;

/**
 * Created by nazar on 7/12/16.
 */
public class GmailData {
    @DataProvider(name="login")
    public static Object[][] login(){
        return new Object[][]{
                {"lesnazarko18@gmail.com","lesnazarko1"}
        };
    }

    @DataProvider(name="sendMessage")
    public static Object[][] sendMessage(){
        return new Object[][]{
                {"lesnazarko18@gmail.com","Just a message!"}
        };
    }
}
