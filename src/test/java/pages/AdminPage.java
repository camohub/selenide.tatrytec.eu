package pages;


import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;


public class AdminPage extends BasePage
{

    public AdminPage()
    {
        open(OPEN_URL);
        page(this);
    }


    public void openAdmin()
    {
        $("#sideMenu").find(byAttribute("href", "https://tatrytec.eu/admin")).click();
        $("#main").find(byAttribute("href", "https://tatrytec.eu/admin/articles/create"));
    }
}
