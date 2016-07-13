package com.gmail.utilities;

import io.selendroid.client.SelendroidDriver;
import io.selendroid.common.SelendroidCapabilities;
import io.selendroid.standalone.SelendroidConfiguration;
import io.selendroid.standalone.SelendroidLauncher;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.concurrent.TimeUnit;

/**
 * Created by nazar on 7/13/16.
 */
public class DriverFactory {
    static WebDriver driver;
    static SelendroidLauncher selendroidServer = null;
    static BrowserType browserType;
    public enum BrowserType {
        CHROME{
            public WebDriver getDriver(){
                System.setProperty("webdriver.chrome.driver", "chromedriver");

                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.setExperimentalOption("androidPackage", "com.android.chrome");
                DesiredCapabilities capabilities = DesiredCapabilities.chrome();
                capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);

                driver = new ChromeDriver(capabilities);
                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                return driver;
            }
            public void closeDriver(){
                if (driver != null) {
                    driver.quit();
                }
            }
        },
        SELENDROID{
            public WebDriver getDriver(){
                if (selendroidServer != null) {
                    selendroidServer.stopSelendroid();
                }
                SelendroidConfiguration config = new SelendroidConfiguration();

                selendroidServer = new SelendroidLauncher(config);
                selendroidServer.launchSelendroid();

                DesiredCapabilities caps = SelendroidCapabilities.android();

                try {
                    driver = new SelendroidDriver(caps);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                return  driver;
            }
            public void closeDriver(){
                if (driver != null) {
                    driver.quit();
                }
                if (selendroidServer != null) {
                    selendroidServer.stopSelendroid();
                }
            }

        };

        public abstract WebDriver getDriver();
        public abstract void closeDriver();
    }
    public static WebDriver getDriver(BrowserType type){
        browserType=type;
        return type.getDriver();
    }
    public static void closeDriver(){
        browserType.closeDriver();
    }
}
