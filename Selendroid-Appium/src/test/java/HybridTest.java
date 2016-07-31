import com.gmail.bo.EmpDirWorker;
import com.gmail.data.EmpDirData;
import com.gmail.data.GmailData;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by nazar on 7/16/16.
 */
public class HybridTest {
    //private AndroidDriver<WebElement> driver;
    @BeforeClass
    public void setUp() throws Exception {
        EmpDirWorker.setup();
    }
   /* @Test
    public void addContact() throws InterruptedException {
        //driver.get("and-activity://io.selendroid.directory.EmployeeDirectory");
        //driver.switchTo().window("WEBVIEW");
        String vpOfEngineering = "John Williams";
        //Thread.sleep(10000);
        driver.context("WEBVIEW_io.selendroid.directory");
        driver.findElement(By.tagName("input")).sendKeys(vpOfEngineering);
        driver.findElement(By.partialLinkText(vpOfEngineering)).click();
        Assert.assertEquals(driver.getCurrentUrl(), "file:///android_asset/www/index.html#employees/4");
        driver.findElement(By.xpath("/html/body/div/div[2]/div/ul/li[1]")).click();
        Thread.sleep(500);
        driver.findElement(By.xpath("/html/body/div/div[1]/div[1]/a/span")).click();

    }*/
    @Test(dataProviderClass = EmpDirData.class, dataProvider = "search")
    public void searchTest(String name, String url) throws InterruptedException {

        EmpDirWorker.switchToWeb();
       // System.out.println(EmpDirWorker.getContext());
        EmpDirWorker.searchByName(name);
        EmpDirWorker.clearInput();
        //EmpDirWorker.takeScreenshot();
        Assert.assertEquals(EmpDirWorker.getTextFromInput(),"");
        EmpDirWorker.searchByName(name);
        EmpDirWorker.clickOnEmployee(name);
        Assert.assertEquals(EmpDirWorker.getUrl(), url);
        EmpDirWorker.clickAdd();
        //EmpDirWorker.navigateBack();
        //Assert.assertTrue(EmpDirWorker.isInputBoxPresent(),"navigateBack does not work properly!");

    }
    @Test(enabled = false)
    public void rotateTest(){
        Assert.assertEquals(EmpDirWorker.rotate(), ScreenOrientation.LANDSCAPE);
    }



    @AfterClass
    public void close(){
        EmpDirWorker.close();
    }
}
