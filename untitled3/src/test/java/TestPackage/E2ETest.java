package TestPackage;

import Pages.HomePage;
import Pages.MainPage;
import Pages.PrivacyPolicyPage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.junit.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class E2ETest {
    HomePage homePage;
    AndroidDriver driver;
    PrivacyPolicyPage privacyPolicyPage;
    MainPage mainPage;
    String privacyPageTitle;

    @BeforeTest
    public void SetUp() throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options()
                .setPlatformName("Android")
                .setAutomationName("UiAutomator2")
                .setPlatformVersion("13")
                .setDeviceName("emulator-5554")
                .setApp(System.getProperty("user.dir")+"/src/main/resources/Weather Forecast_3.6_apkcombo.com.apk");
        driver = new AndroidDriver(new URL("http://localhost:4723"), options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void ChangingSetting()
    {
        homePage =new HomePage(driver);
        homePage.ClickOnTemperatureUnitDropDown();
        homePage.ClickOnFUnit();
        homePage.ClickOnTimeFormatDropDown();
        homePage.ClickOnTwelveHoursTimeFormat();
        homePage.ClickOnDoneButton();
   }
   @Test(dependsOnMethods = "ChangingSetting")
    public void ProceedOnPrivacyPolicyPage()
   {
       privacyPolicyPage = new PrivacyPolicyPage(driver);
     privacyPageTitle  =new PrivacyPolicyPage(driver).getPrivacyPolicyPageTitle();
       Assert.assertEquals(privacyPageTitle,"Privacy policy");
       privacyPolicyPage.ClickOnGotItButton();
   }
   @Test(dependsOnMethods = "ProceedOnPrivacyPolicyPage")
    public void ValidateMainScreen()
   {
       mainPage = new MainPage(driver);
       mainPage.ClickOnAllowPermissionPopUp();
      Assert.assertEquals( mainPage.CheckThatFTempUnitIsDisplayed(),true);
      mainPage.CheckThatTimeFormatIsTwelveHours();
      mainPage.CheckThatRainingIconIsDisplayedInNextSixHours();
   }
    @AfterClass
    public void tearDown() {
        if (null != driver) {
            driver.quit();
            driver.resetApp();
        }
    }

}
