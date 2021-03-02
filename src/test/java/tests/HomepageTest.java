
package tests;


import categories.FastTest;
import categories.FullTest;
import com.google.code.tempusfugit.concurrency.ConcurrentTestRunner;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import pages.HomepagePage;


@RunWith(ConcurrentTestRunner.class)
public class HomepageTest extends baseTest
{

    @Category({FastTest.class, FullTest.class})
    @Test
    public void homepage() throws InterruptedException
    {
        HomepagePage homepagePage = new HomepagePage();

        homepagePage.openPage();

        homepagePage.testHeader();
        homepagePage.testArticles();
        homepagePage.testPagination();
        homepagePage.testMenu();
    }
}