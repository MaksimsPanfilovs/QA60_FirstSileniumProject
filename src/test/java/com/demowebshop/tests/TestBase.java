package com.demowebshop.tests;

import com.google.common.io.Files;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class TestBase {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://demowebshop.tricentis.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterMethod(enabled = false)
    public void tearDown() {
        driver.quit();
    }

    public boolean isElementPresent(By locator) {
        return driver.findElements(locator).size() > 0;
    }

    public void type(By locator, String text) {
        if(text !=  null) {
            click(locator);
            driver.findElement(locator).clear();
            driver.findElement(locator).sendKeys(text);
        }
    }

    public void click(By locator) {
        driver.findElement(locator).click();
    }


    public boolean isProductPresentInCart() {
        return isElementPresent(By.xpath("//a[.='14.1-inch Laptop']"));
    }

    public void clickOnCartLink() {
        click(By.cssSelector("li#topcartlink"));
    }

    public void clickOnAddToCartButton() {
        click(By.cssSelector("input.button-2.button-2.product-box-add-to-cart-button[onclick*='/addproducttocart/catalog/31/1/1']"));
    }

    public void removeProductFromCart() {
        click(By.cssSelector("td.remove-from-cart"));
        click(By.cssSelector("input[name='updatecart']"));
    }

    public boolean isLogOutLinkPresent() {
        return isElementPresent(By.cssSelector("[href='/logout']"));
    }

    public void clickOnConfirmButton() {
        click(By.cssSelector("input[value='Continue']"));
    }

    public void clickOnRegistrationButton() {
        click(By.cssSelector("input#register-button"));
    }

    public void fillRegistrationForm(User user) {
        chooseYourGender(user.getGender());
        type(By.cssSelector("input#FirstName"), user.getFirstname());
        type(By.cssSelector("input#LastName"), user.getLastname());
        type(By.cssSelector("input#Email"), user.getEmail());
        type(By.cssSelector("input#Password"), user.getPassword());
        type(By.cssSelector("input#ConfirmPassword"), user.getPassword());
    }

    public void fillLoginForm(User user) {
        type(By.cssSelector("input#Email"), user.getEmail());
        type(By.cssSelector("input#Password"), user.getPassword());
    }

    public void clickOnRegistrationLink() {
        click(By.cssSelector("[href='/register']"));
    }

    public boolean isErrorMessagePresent() {
        return isElementPresent(By.xpath("//li[.='The specified email already exists']"));
    }

    public void chooseYourGender(String gender) {
        if (gender == "male") {
            click(By.cssSelector("input#gender-male"));
        } else if (gender == "female") {
            click(By.cssSelector("input#gender-female"));
        }
    }

    public void pause(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean isAlertDisplayed() {
        Alert alert = new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.alertIsPresent());
        if (alert == null) {
            return false;
        } else {
            driver.switchTo().alert();
            alert.accept();
            return true;
        }

    }

    public String takeScreenshot() {
        File tmp = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File screenshot = new File("screenshots/screen-" + System.currentTimeMillis() + ".png");
        try {
            Files.copy(tmp, screenshot);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return screenshot.getAbsolutePath();
    }



    public void clickOnLoginLink() {
        click(By.cssSelector("[href='/login']"));
    }

    public void clickOnLoginButton() {
        click(By.cssSelector("input[value='Log in']"));
    }

    public boolean isLogErrorMessagePresent() {
        return isElementPresent(By.xpath("//span[contains(.,'unsuccessful')]"));
    }
}
