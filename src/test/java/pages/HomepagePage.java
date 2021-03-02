package pages;


import com.codeborne.selenide.*;
import org.openqa.selenium.WebDriver;

import java.util.List;

import static com.codeborne.selenide.CollectionCondition.*;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;


public class HomepagePage
{

    private String URL = "https://tatrytec.eu";

    private final WebDriver driver;


    public HomepagePage()
    {
        driver = WebDriverRunner.getWebDriver();
    }


    public void openPage()
    {
        open(URL);
        //driver.manage().window().maximize();
    }


    public void testHeader() throws InterruptedException
    {
        SelenideElement header = $("#header").shouldHave( exactText("Tatrytec.eu"));
    }


    public void testArticles()
    {
        ElementsCollection articles = $$("#main h1 a").shouldBe( size(7) );
    }


    public void testMenu()
    {
        ElementsCollection sideMenu = $$("#sideMenu li")
                .shouldBe( sizeGreaterThan(4) )
                .shouldHave( itemWithText("Najnovšie") )
                .shouldHave( itemWithText("Prihlásiť") )
                .shouldHave( itemWithText("Registrovať") );
    }


    public void testPagination()
    {
        ElementsCollection pagination = $$("ul.pagination li").shouldBe( sizeGreaterThan(2) );
        pagination.get(1).shouldHave(cssClass("active"));
    }

}
