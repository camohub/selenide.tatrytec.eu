package pages;


import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.WebDriver;
import static com.codeborne.selenide.Selenide.open;


public class LoginPage
{

    private String URL = "https://tatrytec.eu";

    private WebDriver driver;


    public LoginPage()
    {
        this.driver = WebDriverRunner.getWebDriver();
    }


    public void openPage()
    {
        open(URL);
        driver.manage().window().maximize();
    }


    public void openLoginModal() throws InterruptedException
    {

    }


    public void fillLoginForm()
    {

    }


    public void sendLoginForm()
    {

    }
}
