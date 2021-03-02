package tests;


import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.openqa.selenium.WebDriver;
import rules.TestWatcher;
import services.WebDriverService;
import java.io.IOException;
import java.net.MalformedURLException;


public class baseTest
{

    protected String baseUrl = "http://localhost/seleniumweb";


    /**
     * This is the JUnit way how to catch fail event.
     */
    @Rule
    public TestWatcher failWatcher = new TestWatcher();


    @Before
    public void baseSetUp() throws MalformedURLException
    {
        (new WebDriverService()).setDriver();

        failWatcher.setTestClass(getClass().getSimpleName());
    }


    @After
    public void baseTearDown() throws IOException
    {
        // Is implemented in TestWatcher::finish()
    }
}
