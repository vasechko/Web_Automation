import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;


public class SearchTest
{
    @Test
    public void testSearch()
    {

        WebDriver driver = new FirefoxDriver();

        driver.navigate().to("http://www.funda.nl/");
        driver.findElement(By.id("autocomplete-input")).sendKeys("Amsterdam");
        driver.findElement(By.className("button-primary-alternative")).click();

        Assert.assertTrue(driver.getTitle().startsWith("Selenium Simplified"), "title should start differently");

        driver.close();
        driver.quit();
    }
}
