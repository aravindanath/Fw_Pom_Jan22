package testscripts;

import net.bytebuddy.description.type.TypeList;
import org.testng.annotations.Test;
import pages.BaseClass;
import pages.RegisterPage;

public class TC_RF_001 extends BaseTest{

    String fn = BaseClass.firstName(), ln = BaseClass.lastName(), email = BaseClass.email(),
    telephone = BaseClass.telephoneNumber(), password = "password@123", confirmPassword = "password@123";

    @Test
    public void TC_RF_001() throws InterruptedException {

        RegisterPage rp = new RegisterPage(driver);
        rp.navigateToRegisterPage();
        rp.verifyRegisteringAccountByProvidingOnlyMandatoryFields(fn,ln,email,telephone,password,confirmPassword);

    }
}
