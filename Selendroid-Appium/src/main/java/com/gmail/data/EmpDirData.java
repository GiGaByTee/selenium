package com.gmail.data;

import org.testng.annotations.DataProvider;

/**
 * Created by nazar on 7/17/16.
 */
public class EmpDirData {
    @DataProvider(name="search")
    public static Object[][] search(){
        return new Object[][]{
                {"John Williams","file:///android_asset/www/index.html#employees/4"}
        };
    }
}
