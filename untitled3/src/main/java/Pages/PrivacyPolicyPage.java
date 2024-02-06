package Pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import java.time.Duration;
public class PrivacyPolicyPage {
    private AndroidDriver driver;
    //Constructor
    public PrivacyPolicyPage(AndroidDriver driver) {
        this.driver=driver;
    }
   private By gotItButton =By.xpath("//android.widget.LinearLayout[@resource-id=\"com.info.weather.forecast:id/ll_got_it\"]/android.widget.ImageView");
   private By privacyPolicyTitle =By.xpath("//android.widget.TextView[@text=\"Privacy policy\"]");

    public String getPrivacyPolicyPageTitle()
    {
    return driver.findElement(privacyPolicyTitle).getText();
    }
    public MainPage ClickOnGotItButton()
    {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(gotItButton).click();
        return new MainPage(driver);
    }
}
