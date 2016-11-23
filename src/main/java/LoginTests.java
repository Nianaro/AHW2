import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class LoginTests {
    private static String URL = "http://80.92.229.236:81/auth/login";
    private static String USER_NAME_KEY = "username";
    private static String PASSWORD_KEY = "password";
    private static String USER_NAME_VALUE = "admin";
    private static String PASSWORD_VALUE = "123";

    public static void main(String[] args) {
        WebDriver webDriver = new FirefoxDriver();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        webDriver.get(URL);


        WebElement userNameInput = webDriver.findElement(By.id(USER_NAME_KEY));
        userNameInput.sendKeys(USER_NAME_VALUE);


        WebElement passwordInput = webDriver.findElement(By.id(PASSWORD_KEY));
        passwordInput.sendKeys(PASSWORD_VALUE);


        WebElement loginSubmit = webDriver.findElement(By.id("logIn"));
        loginSubmit.click();

        assertText("","","");

        WebElement insertLink = webDriver.findElement(By.xpath(".//a[contains(@href,'/players/insert')]"));
        insertLink.click();

        WebElement loginInput = webDriver.findElement(By.xpath(".//input[contains(@id,'us_login')]"));
        loginInput.sendKeys(USER_NAME_VALUE);


       // webDriver.quit();
    }

public static void assertText(String actualValue, String expectedValue, String errMessage){
    if(expectedValue.equals(actualValue)){
        System.out.println("Passed");
    } else {
        System.out.println("Failed");
    }
}
}