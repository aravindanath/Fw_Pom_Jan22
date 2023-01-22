package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BaseClass{

    private WebDriver driver;
    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//span[text()='My Account']")
    WebElement clickMyAccountDropmenu;

    @FindBy(xpath = "(//a[.='Login'])[1]")
    WebElement clickLoginOption;

    @FindBy(id="input-email")
    WebElement enterEmailAddress;

    @FindBy(id="input-password")

    WebElement enterPassword;

    @FindBy(xpath = "//input[@type='submit' and @value='Login' and @class='btn btn-primary']")
    WebElement loginButton;

    public void navigateToLoginPage() throws InterruptedException {
        clickMyAccountDropmenu.click();
        Thread.sleep(3000);
        clickLoginOption.click();
    }
    public void enterEmailAddress(String emailAddress) {
        enterEmailAddress.sendKeys(emailAddress);
    }

    public void enterPassword(String password) {
        enterPassword.sendKeys(password);
    }

    public void clickLoginButton() {
        loginButton.click();
    }


}
