package Pages;


import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import java.time.Duration;
public class HomePage {
   private AndroidDriver driver;
    //Constructor
    public HomePage(AndroidDriver driver) {
     this.driver=driver;
    }
    //Web Elements
    private By tempratureDropDown =By.id("com.info.weather.forecast:id/iv_temp_dropdown");
    private By fUnit = By.xpath("(//android.widget.TextView[@text=\"F\"])[2]");
   private By timeFormatDropDown = By.id("com.info.weather.forecast:id/iv_timeformat_dropdown");
    By twelveHoursTimeFormat = By.xpath("(//android.widget.TextView[@text=\"12 Hour\"])[2]");
    By doneButton = By.id("com.info.weather.forecast:id/tv_button_done");

    public void ClickOnTemperatureUnitDropDown(){

        driver.findElement(tempratureDropDown).click();
    }
    public void ClickOnFUnit(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(fUnit).click();
    }
    public void ClickOnTimeFormatDropDown(){
        driver.findElement(timeFormatDropDown).click();
    }
    public void ClickOnTwelveHoursTimeFormat(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(twelveHoursTimeFormat).click();
    }
    public void ClickOnDoneButton(){
        driver.findElement(doneButton).click();
    }
}

