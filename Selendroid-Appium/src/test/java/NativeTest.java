import com.gmail.bo.ContactManagerWorker;
import com.gmail.bo.EmpDirWorker;
import com.gmail.data.ContactManagerData;
import com.gmail.data.EmpDirData;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

/**
 * Created by nazar on 7/17/16.
 */
public class NativeTest {
   // private AndroidDriver driver;
    @BeforeClass
    public void setup() throws MalformedURLException {
        ContactManagerWorker.setup();

    }

    @AfterClass
    public void close(){
        ContactManagerWorker.close();
    }

    @Test(dataProviderClass = ContactManagerData.class, dataProvider = "contactIfo")
    public void contactManagerTest(String name, String phone, String email, String address) throws InterruptedException {

        ContactManagerWorker.addContact(name,phone,email,address);
        ContactManagerWorker.goToContactList();
        String[] list = ContactManagerWorker.getLastContactInfo();
        Assert.assertEquals(list[0],name);
        Assert.assertEquals(list[1],phone);
        Assert.assertEquals(list[2],address);
        Assert.assertEquals(list[3],email);
    }

}
