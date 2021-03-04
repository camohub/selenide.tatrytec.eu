
package tests;


import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.junit.ScreenShooter;
import com.codeborne.selenide.junit.TextReport;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.openqa.selenium.WebDriver;
import rules.TestWatcher;
import services.WebDriverService;
import java.io.IOException;
import java.net.MalformedURLException;


public class BaseTest
{

    @Rule
    public ScreenShooter makeScreenshotOnFailure = ScreenShooter.failedTests();

    @Rule
    public TextReport textReport = new TextReport();

    static {
        Configuration.baseUrl = "https://tatrytec.eu";
        Configuration.headless = true;
        Configuration.startMaximized = true;
        //Configuration.holdBrowserOpen = true;
    }

    /**
     * This is the JUnit way how to catch fail event.
     */
    //@Rule
    //public TestWatcher failWatcher = new TestWatcher();


    @Before
    public void baseSetUp() throws MalformedURLException
    {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(true));

        //(new WebDriverService()).setDriver();

        //failWatcher.setTestClass(getClass().getSimpleName());
    }


    @After
    public void baseTearDown() throws IOException
    {
        // Is implemented in TestWatcher::finish()
    }
}
