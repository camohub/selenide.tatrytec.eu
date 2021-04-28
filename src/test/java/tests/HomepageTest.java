
package tests;


import categories.FastTest;
import categories.FullTest;
import com.google.code.tempusfugit.concurrency.ConcurrentTestRunner;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import pages.HomepagePage;


@Category({FastTest.class, FullTest.class})
@RunWith(ConcurrentTestRunner.class)
public class HomepageTest extends BaseTest
{

    @Test
    public void homepage() throws InterruptedException
    {
        HomepagePage homepagePage = new HomepagePage();

        homepagePage.testHeader();
        homepagePage.testMenu();
        homepagePage.testArticles();
        homepagePage.testPagination();
    }
}