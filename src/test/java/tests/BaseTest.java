
package tests;


import com.codeborne.selenide.AssertionMode;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.junit.ScreenShooter;
import com.codeborne.selenide.junit.SoftAsserts;
import com.codeborne.selenide.junit.TextReport;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.typesafe.config.Config;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.openqa.selenium.WebDriver;
import rules.TestWatcher;
import services.ConfigSingletonService;
import services.WebDriverService;
import java.io.IOException;
import java.net.MalformedURLException;
import com.typesafe.config.ConfigFactory;


public class BaseTest
{

    protected static Config conf = ConfigSingletonService.conf();  // resources/application.conf

    public static String HUB_URL = "http://127.0.0.1:4444";

    public static String BASE_URL = "https://tatrytec.eu";

    // This is the JUnit way how to catch fail event.
    //@Rule
    //public TestWatcher failWatcher = new TestWatcher();

    // Set screenshots only on fail. This is extension of native JUnit TestWatcher like above.
    @Rule
    public ScreenShooter makeScreenshotOnFailure = ScreenShooter.failedTests();

    // Create test report as table.
    @Rule
    public TextReport textReport = new TextReport();

    // Reports all failed tests not only the first one.
    //@Rule
    //public SoftAsserts softAsserts = new SoftAsserts();


    static {
        Configuration.remote = HUB_URL;
        Configuration.baseUrl = BASE_URL;
        //Configuration.assertionMode = AssertionMode.SOFT;  // Is able to use it on Class level.
        Configuration.startMaximized = true;
        Configuration.headless = conf.getBoolean("env.production");
        //Configuration.screenshots = false;
        //Configuration.holdBrowserOpen = true;
    }


    @Before
    public void baseSetUp() throws MalformedURLException
    {
        //(new WebDriverService()).setDriver();

        //failWatcher.setTestClass(getClass().getSimpleName());
    }


    @After
    public void baseTearDown() throws IOException
    {
        // Is implemented in TestWatcher::finish()
    }
}
