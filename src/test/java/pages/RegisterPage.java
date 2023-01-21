package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage  extends BaseClass{

    private WebDriver driver;

    public RegisterPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }


    @FindBy(xpath = "//span[text()='My Account']")
    WebElement myAccountMenu;

    @FindBy(xpath = "(//a[text()='Register'])[1]")
    WebElement registerMenu;

    @FindBy(id = "input-firstname")
    WebElement firstNameTextField;

    @FindBy(id = "input-lastname")
    WebElement lastNameTextField;

    @FindBy(id = "input-email")
    WebElement emailTextField;

    @FindBy(id = "input-telephone")
    WebElement telephoneTextField;

    @FindBy(id = "input-password")
    WebElement passwordTextField;

    @FindBy(id = "input-confirm")
    WebElement confirmPasswordText;

    @FindBy(xpath = "//input[@name='agree']")
    WebElement agreeCb;

    @FindBy(xpath = "//input[@class='btn btn-primary']")
    WebElement continueButton;


    public void navigateToRegisterPage(){
        myAccountMenu.click();
        registerMenu.click();
    }


    public void verifyRegisteringAccountByProvidingOnlyMandatoryFields(String fn, String ln, String email, String telephone, String password,String confirmPassword) throws InterruptedException {
        firstNameTextField.sendKeys(fn);
        Thread.sleep(3000);
        lastNameTextField.sendKeys(ln);
        Thread.sleep(3000);
        emailTextField.sendKeys(email);
        Thread.sleep(3000);
        telephoneTextField.sendKeys(telephone);
        Thread.sleep(3000);
        passwordTextField.sendKeys(password);
        Thread.sleep(3000);
        confirmPasswordText.sendKeys(confirmPassword);
        Thread.sleep(3000);
        agreeCb.click();
        continueButton.click();
    }




}
