import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.codeborne.selenide.Configuration;
import com.task.pages.FundaSearchPage;
import com.task.pages.ResultPage;



public class SearchTest
{
    // WebDriver driver = new FirefoxDriver();

    @Test
    public void testSearch()
    {
        FundaSearchPage searchPage = open("http://www.funda.nl/", FundaSearchPage.class);
        ResultPage resultPage = searchPage.search("Amsterdam");

        resultPage.results().get(0).shouldHave(text("Amsterdam"));
    }


    @BeforeClass
    public void setUp()
    {
        Configuration.browser = "chrome";
        Configuration.timeout = 6000;
    }



    @AfterMethod
    public void tearDown()
    {
        // driver.close();
        // driver.quit();
    }
}
