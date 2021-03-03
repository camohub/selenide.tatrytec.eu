package pages;


import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static java.time.Duration.ofSeconds;


public class BasePage
{
    WebDriver driver;


    public BasePage()
    {
        this.driver = WebDriverRunner.getWebDriver();
    }


    public void login()
    {
        open("https://tatrytec.eu");
        driver.manage().window().maximize();

        $("#sideMenu").find(byAttribute("data-target", "#loginModal")).click();

        SelenideElement modal = $("#loginModal");
        modal.find( byName("email") ).val("vladimircamaj@gmail.com");
        modal.find( byName("password") ).val("vladimir");
        modal.find( byAttribute("type", "submit") ).click();
    }
}
