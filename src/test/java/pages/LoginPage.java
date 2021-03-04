
package pages;


import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.*;
import static java.time.Duration.*;


public class LoginPage extends BasePage
{

    public LoginPage()
    {
        open(OPEN_URL);
        page(this);
    }


    public void fillLoginForm(String email, String pass)
    {
        $("#sideMenu").find(byAttribute("data-target", "#loginModal")).click();

        SelenideElement modal = $("#loginModal").should(appear);
        modal.find( byName("email") ).val(email);
        modal.find( byName("password") ).val(pass);
        modal.find( byAttribute("type", "submit") ).click();
    }


    public void checkLoginResponse(String cssSelector, String text)
    {
        // Is new element do not use prev one.
        $(cssSelector).shouldBe(visible, ofSeconds(7))
                .shouldHave(text(text).because("Prihlasovanie nedopadlo podľa očakávania. Alert neobsahuje text " + text));
    }
}
