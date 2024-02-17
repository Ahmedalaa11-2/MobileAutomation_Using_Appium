package Utils;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;

public class Actions {
    private AndroidDriver driver;

    public Actions(AndroidDriver driver) {
        this.driver=driver;
    }
   private By meddleSection =By.id("com.info.weather.forecast:id/line_chart_hourly");
    public void swipeLeft(By locator)
    {

       WebElement meddleSectionValue = driver.findElement(meddleSection);

        // Get the location and size of the section element value
        Dimension sectionSize = meddleSectionValue.getSize();

        // Calculate the start and end coordinates within the section element for the swipe gesture
        int startX = sectionSize.getWidth() * 3 / 4; // 3/4 to the right from the left edge of the section
        int startY = sectionSize.getHeight() / 2; // Center Y-coordinate of the section
        int endX = sectionSize.getWidth() / 4; // 1/4 to the left from the right edge of the section
        int endY = startY; // Same Y-coordinate as startY

        // Perform swipe gesture
        TouchAction touchAction = new TouchAction(driver);
        touchAction.press(PointOption.point(meddleSectionValue.getLocation().getX(), meddleSectionValue.getLocation().getY()))
                .moveTo(PointOption.point(endX - startX, endY - startY))
                .release().perform();


    }


}
