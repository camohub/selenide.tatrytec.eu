package pages;


import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static java.time.Duration.*;


public class LoginPage
{

    private String URL = "https://tatrytec.eu";

    private WebDriver driver;

    private SelenideElement modal;


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
        this.modal = $("#loginModal").shouldBe(hidden);
        SelenideElement email = modal.find( byName("email") ).shouldBe(hidden);
        SelenideElement password = modal.find( byName("password") ).shouldBe(hidden);
        SelenideElement submit = modal.find( byAttribute("type", "submit") ).shouldBe(hidden);

        $("#sideMenu").find(byAttribute("data-target", "#loginModal")).click();

        this.modal.shouldBe(visible);
        email.shouldBe(visible);
        password.shouldBe(visible);
        submit.shouldBe(visible);
    }


    public void fillLoginForm()
    {
        modal.find( byName("email") ).sendKeys("aaaaa@aaaaa.aa");
        modal.find( byName("password") ).sendKeys("aaaaaaaaaaa");
        modal.find( byAttribute("type", "submit") ).click();
    }


    public void checkLoginResponse()
    {
        // Is new element do not use prev one.
        SelenideElement modal = $("#loginModal").shouldBe(visible, ofSeconds(7));
        modal.find(By.className("alert-danger")).shouldHave(text("Nesprávny email alebo heslo."));
    }
}
