package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class LoginTest extends BaseTest {
    String baseUrl = "https://www.saucedemo.com/";
    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }
    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials(){
        // Finding the username field element
        WebElement userName = driver.findElement(By.id("user-name"));
        userName.sendKeys("standard_user");
        // Finding the password field element
        WebElement passwordField = driver.findElement(By.name("password"));
        // sending Password to password field element
        passwordField.sendKeys("secret_sauce");
        // Finding the login button and clicking on it
        WebElement loginButton = driver.findElement(By.name("login-button"));
        loginButton.click();

        //Verify the given text from the requirements
        String expectedTextMessage = "PRODUCTS";
        WebElement actualTextMessageElement = driver.findElement(By.xpath("//span[contains(text(),'Products')]"));
        //Getting the text by using get method
        String actualTextMessage = actualTextMessageElement.getText();
        //Validate expected and actual text message
        Assert.assertEquals("Text is not matching", expectedTextMessage,actualTextMessage);
    }
    @Test
    public void verifyThatSixProductsAreDisplayedOnPage(){
        // Finding the username field element
        WebElement userName = driver.findElement(By.id("user-name"));
        //Sending email address to email field element
        userName.sendKeys("standard_user");
        // Finding the password field element
        WebElement passwordField = driver.findElement(By.name("password"));
        // sending Password to password field element
        passwordField.sendKeys("secret_sauce");
        // Finding the login button and clicking on it
        WebElement loginButton = driver.findElement(By.name("login-button"));
        loginButton.click();

        //Verifying the given text from the requirements
        // Verifying that six products are displayed on page
        int expectedNumberOfProducts = 6;
        List<WebElement> actualNumberOfProducts = driver.findElements(By.className("inventory_item"));
        int totalNumberOfProducts = actualNumberOfProducts.size();

        //Validate expected and actual text message
        Assert.assertEquals("Six products not displayed",expectedNumberOfProducts,totalNumberOfProducts );
    }
    @After
    public void tearDown(){
        closeBrowser();
    }
}

