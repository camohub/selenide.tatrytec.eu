
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
        SelenideElement header = $("#header").shouldHave( exactText("Tatrytec.euuu"));
    }


    public void testArticles()
    {
        ElementsCollection articles = $$("#main h1 a").shouldBe( size(7) );
    }


    public void testMenu()
    {
        ElementsCollection sideMenu = $$("#sideMenu li")
                .shouldBe( sizeGreaterThan(40) )
                .shouldHave( itemWithText("Najnovšie") )
                .shouldHave( itemWithText("Prihlásiť") )
                .shouldHave( itemWithText("Registrovať") );
    }


    public void testPagination()
    {
        ElementsCollection pagination = $$("ul.pagination li a")
                .shouldBe( sizeGreaterThan(2) );
        pagination.get(1).shouldHave( cssClass("active") );
    }

}
