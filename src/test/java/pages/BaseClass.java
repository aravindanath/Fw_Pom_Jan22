package pages;

import com.github.javafaker.Faker;
import org.apache.commons.io.FileUtils;
import org.ini4j.Ini;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class BaseClass {

    protected WebDriver driver;


    public BaseClass(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }


    public static void scroll(WebDriver driver, WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();",element);
    }

    public static void mouseHover(WebDriver driver, WebElement element){
        Actions act = new Actions(driver);
        act.moveToElement(element).build().perform();
    }
    public static void click(WebDriver driver, WebElement element){
        Actions act = new Actions(driver);
        act.click(element).build().perform();
    }


    public static void dragANDDrop(WebDriver driver, WebElement element1, WebElement element2){
        Actions act = new Actions(driver);
        act.dragAndDrop(element1,element2).build().perform();
    }

    public static void takeScreenshot(WebDriver driver){
        try {
            TakesScreenshot srcShot = (TakesScreenshot) driver;
            File output = srcShot.getScreenshotAs(OutputType.FILE);
            File path = new File("./screenshots.png");
            FileUtils.copyFile(output, path);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static String getValue(String key){
        String path = System.getProperty("user.dir")+File.separator+"config.properties";
        String val =null;
        try {
            FileInputStream fis = new FileInputStream(path);
            Properties prop = new Properties();
            prop.load(fis);
            val = prop.getProperty(key);
        }catch (Exception e){
            e.printStackTrace();
        }
        return val;
    }


    public static String getValue(String title, String key){
        String path = System.getProperty("user.dir")+ File.separator+"testdata"+File.separator+"data.ini";
        String value =null;
        try {
            FileInputStream fis = new FileInputStream(path);
            Ini ini = new Ini();
            ini.load(fis);
            value = ini.get(title, key);
        }catch(Exception e){
            e.printStackTrace();
        }
        return value;
    }

    public static String firstName(){
        Faker faker = new Faker();
       String fn =  faker.name().firstName();
       return fn;
    }

    public static String lastName(){
        Faker faker = new Faker();
        String ln =  faker.name().lastName();
        return ln;
    }

    public static String email(){
        Faker faker = new Faker();
        String ln =  faker.name().lastName()+"@testmail.com";
        return ln;
    }

    public static String telephoneNumber(){
        Faker faker = new Faker();
        String ln =  faker.number().digits(10);
        return ln;
    }
}
