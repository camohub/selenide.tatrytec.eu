
package pages;


import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.WebDriver;
import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.*;


public class BasePage
{

    public static String OPEN_URL = "";  // Needs to have empty string. Does not work without value or null.


    public void login()
    {
        $("#sideMenu").find(byAttribute("data-target", "#loginModal")).click();

        SelenideElement modal = $("#loginModal");
        modal.find( byName("email") ).val("vladimircamaj@gmail.com");
        modal.find( byName("password") ).val("vladimir");
        modal.find( byAttribute("type", "submit") ).click();
    }
}
