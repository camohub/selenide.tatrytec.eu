
package pages;


import com.codeborne.selenide.*;
import static com.codeborne.selenide.CollectionCondition.*;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;


public class HomepagePage extends BasePage
{

    public HomepagePage()
    {
        open(OPEN_URL);
        page(this);
    }


    public void testHeader() throws InterruptedException
    {
        SelenideElement header = $("#header")
                .shouldHave( exactText("Tatrytec.euuu").because("Homapage header má obsahovať text Tatrytec.eu"));
    }


    public void testArticles()
    {
        ElementsCollection articles = $$("#main h1 a")
                .shouldBe( size(7).because("Počet článkov na homepage by mal byť 7.") );
    }


    public void testMenu()
    {
        ElementsCollection sideMenu = $$("#sideMenu li")
                .shouldBe( sizeGreaterThan(4) )
                .shouldHave( itemWithText("Najnovšie").because("Menu by malo obsahovať kategóriu Najnovšie.") )
                .shouldHave( itemWithText("Prihlásiť").because("Menu by malo obsahovať odkaz Prihlásiť.") )
                .shouldHave( itemWithText("Registrovať").because("Menu by malo obsahovať odkaz Registrovať.") );
    }


    public void testPagination()
    {
        ElementsCollection pagination = $$("ul.pagination li").shouldBe( sizeGreaterThan(2) );
        pagination.get(1).shouldHave(cssClass("active").because("Hľadaný li element v stránkovaní, by mal mať css class .active."));
    }

}
