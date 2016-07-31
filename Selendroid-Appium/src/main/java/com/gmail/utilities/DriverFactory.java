package com.gmail.utilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.selendroid.client.SelendroidDriver;
import io.selendroid.common.SelendroidCapabilities;
import io.selendroid.standalone.SelendroidConfiguration;
import io.selendroid.standalone.SelendroidLauncher;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

/**
 * Created by nazar on 7/13/16.
 */
public class DriverFactory {
    static WebDriver driver;
    static SelendroidLauncher selendroidServer = null;
    static BrowserType browserType;
    private static Properties prop = new Properties();
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

        },
        APPIUM{
            public WebDriver getDriver(){
                DesiredCapabilities capabilities = new DesiredCapabilities();
                capabilities.setCapability(CapabilityType.BROWSER_NAME, "Browser");

                capabilities.setCapability("platformName", "Android");
                capabilities.setCapability("deviceName","Android Emulator");
                capabilities.setCapability("platformVersion", "4.4.4");

                try {
                    driver = new RemoteWebDriver (new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                return driver;
            }
            public void closeDriver(){
                if (driver != null) {
                    driver.quit();
                }
            }

        },
        APPIUM_HYBRID{
            public WebDriver getDriver(){
                try {
                    prop.load(ClassLoader.getSystemResource("desiredCapabilities.properties").openStream());
                } catch (IOException e) {
                    e.printStackTrace();
                }
                DesiredCapabilities capabilities = new DesiredCapabilities();
                capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, prop.getProperty("device.name") );
                capabilities.setCapability(MobileCapabilityType.APP, prop.getProperty("application.path"));
                capabilities.setCapability(MobileCapabilityType.APP_ACTIVITY, prop.getProperty("application.activity"));
                capabilities.setCapability(MobileCapabilityType.APP_PACKAGE, prop.getProperty("app.package"));
                capabilities.setCapability(MobileCapabilityType.TAKES_SCREENSHOT, "true");
                try {
                    driver = new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"),  capabilities);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
                driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
                return driver;
            }
            public void closeDriver(){
                if(driver!=null)
                    driver.quit();
            }
        },
        APPIUM_NATIVE{
            public WebDriver getDriver(){
                DesiredCapabilities capabilities = new DesiredCapabilities();
                capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Emulator" );
                capabilities.setCapability(MobileCapabilityType.APP, "Selendroid/src/main/resources/Contact Manager_v1.0_apkpure.com.apk");
                capabilities.setCapability(MobileCapabilityType.APP_PACKAGE, "com.RevoFone.renatusludos.contactmanager");
                try {
                    driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),  capabilities);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
                driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
                return driver;
            }

            public void closeDriver(){
                if(driver!=null)
                    driver.quit();
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
