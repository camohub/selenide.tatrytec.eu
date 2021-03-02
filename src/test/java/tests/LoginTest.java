package tests;

import categories.FastTest;
import categories.FullTest;
import com.google.code.tempusfugit.concurrency.ConcurrentTestRunner;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import pages.LoginPage;


@RunWith(ConcurrentTestRunner.class)
public class LoginTest extends baseTest
{


    @Category({FastTest.class, FullTest.class})
    @Test
    public void login() throws InterruptedException
    {
        LoginPage loginPage = new LoginPage();

        loginPage.openPage();

        loginPage.openLoginModal();
        loginPage.fillLoginForm();
        loginPage.checkLoginResponse();

    }
}