
package pages;


import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import com.typesafe.config.Config;
import org.openqa.selenium.WebDriver;
import services.ConfigSingletonService;

import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.*;


public class BasePage
{

    protected static Config conf = ConfigSingletonService.conf();  // resources/application.conf

    public static String OPEN_URL = "";  // Needs to have empty string. Does not work without value or null.


    public void login()
    {
        $("#sideMenu").find(byAttribute("data-target", "#loginModal")).click();

        SelenideElement modal = $("#loginModal");
        modal.find( byName("email") ).val(conf.getString("login.email"));
        modal.find( byName("password") ).val(conf.getString("login.password"));
        modal.find( byAttribute("type", "submit") ).click();
    }
}
