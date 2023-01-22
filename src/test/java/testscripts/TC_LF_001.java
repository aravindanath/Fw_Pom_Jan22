package testscripts;

import org.testng.annotations.Test;
import pages.BaseClass;
import pages.Baseclass1;
import pages.LoginPage;
import pages.RegisterPage;

public class TC_LF_001 extends BaseTest{


    @Test
    public  void TC_LF_001()throws InterruptedException

    {


        String names = Baseclass1.emailid();
        String password = "password@123";
        LoginPage LP = new LoginPage(driver);


        LP.navigateToLoginPage();
        LP.enterEmailAddress(names);
        LP.enterPassword(password);
        LP.clickLoginButton();
    }
}



