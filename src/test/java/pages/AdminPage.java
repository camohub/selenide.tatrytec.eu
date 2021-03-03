package pages;


import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.nio.channels.Selector;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static java.time.Duration.ofSeconds;


public class AdminPage extends BasePage
{

    private String URL = "https://tatrytec.eu";

    private WebDriver driver;


    public void openAdmin()
    {
        $("#sideMenu").find(byAttribute("href", "https://tatrytec.eu/admin")).click();
        $("#main").find(byAttribute("href", "https://tatrytec.eu/admin/articles/create"));
    }
}
