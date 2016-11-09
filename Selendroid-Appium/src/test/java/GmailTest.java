import com.gmail.bo.GmailWorker;
import com.gmail.data.GmailData;
import com.google.common.annotations.VisibleForTesting;
import io.selendroid.client.SelendroidDriver;
import io.selendroid.common.SelendroidCapabilities;
import io.selendroid.standalone.SelendroidConfiguration;
import io.selendroid.standalone.SelendroidLauncher;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * Created by nazar on 7/12/16.
 */
public class GmailTest {
    // added comment1
    @Test(dataProviderClass = GmailData.class, dataProvider = "login")
    public void loginTest(String email,String password){
        GmailWorker.login(email,password);
    }

    @Test(dependsOnMethods = "loginTest",dataProviderClass = GmailData.class, dataProvider = "sendMessage")
    public void sendMessage(String email, String text){
        GmailWorker.refreshMailbox();
        int countOfMessageBeforeCompose = GmailWorker.getMessageCount();
        GmailWorker.sendMessage(email,text);
        int countOfMessageAfterCompose = GmailWorker.getMessageCount();
        Assert.assertEquals(countOfMessageBeforeCompose+1,countOfMessageAfterCompose);
        GmailWorker.clickTheNewestMessage();
        Assert.assertEquals(GmailWorker.getInfoFromMessage(),text);
    }

    @BeforeClass
    public void startSelendroidServer() throws Exception {
        GmailWorker.setup();
    }

    @AfterClass
    public void stopSelendroidServer() {
        GmailWorker.finish();
    }

}
