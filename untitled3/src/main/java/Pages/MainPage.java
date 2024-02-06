package Pages;

import Utils.Actions;
import io.appium.java_client.android.AndroidDriver;
import junit.framework.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.time.Duration;
import java.util.List;
public class MainPage  {
    Actions actions;
    private AndroidDriver driver;
    //Constructor
    public MainPage(AndroidDriver driver) {
        this.driver=driver;
    }
    //Web Element
   private By whileUsingTheAppPermissionButton = By.id("com.android.permissioncontroller:id/permission_allow_foreground_only_button");
   private By currentTempUnitIcon = By.id("com.info.weather.forecast:id/tv_current_temper_unit");
   private By timeFormatInMainScreen = By.xpath("(//android.widget.TextView[@resource-id=\"com.info.weather.forecast:id/tv_hour_item\"])[1]");
    private By meddleSection =By.id("com.info.weather.forecast:id/line_chart_hourly");
    public void ClickOnAllowPermissionPopUp (){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(whileUsingTheAppPermissionButton).click();
    }
    public Boolean CheckThatFTempUnitIsDisplayed(){
       return driver.findElement(currentTempUnitIcon).isDisplayed();
    }
    //get the text of time format element
    public void CheckThatTimeFormatIsTwelveHours(){
       String displayedTime = driver.findElement(timeFormatInMainScreen).getText();
        // Extract the hours part from the displayed time using regular expression
        String hoursPart = displayedTime.split(":")[0].trim(); // Extract "08" from "08:00 pm"
        // Convert the hours part to an integer
        int hours = Integer.parseInt(hoursPart);
        // Assert that the hours value is less than or equal to 12
        Assert.assertTrue("Hours value is not less than or equal to 12,so its 24 hours Format",hours <= 12 );
    }
    public void CheckThatRainingIconIsDisplayedInNextSixHours()
    {
        actions =new Actions(driver);
        List<WebElement> ListOfElemets;
             ListOfElemets  = (List<WebElement>) driver.findElements(By.xpath("(//android.widget.ImageView[@resource-id=\"com.info.weather.forecast:id/iv_rain_chance\"])[position()<7]"));
        // Check visibility of each element
        for (WebElement element : ListOfElemets) {
            // Check if the element is displayed
            if (!element.isDisplayed()) {
                // Perform a swipe action to make the element visible
                actions.swipeLeft(meddleSection);
            }
            // Assert that the element is displayed
            Assert.assertTrue("Element is not displayed on the screen.", element.isDisplayed());
        }
    }
}
