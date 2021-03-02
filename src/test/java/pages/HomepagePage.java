package pages;


import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.WebDriver;
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
        SelenideElement header = $("#header");
        System.out.println(header.getText());
    }


    public void testArticles()
    {
        ElementsCollection articles = $$("#main h1 a");
        System.out.println(articles.stream().count());
    }


    public void testMenu()
    {
        ElementsCollection sideMenu = $$("#sideMenu li");
        System.out.println(sideMenu.stream().count());
    }


    public void testPagination()
    {
        ElementsCollection pagination = $$("ul.pagination li");
        System.out.println(pagination.stream().count());
    }
}
