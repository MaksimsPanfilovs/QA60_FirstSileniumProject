package com.ait.qa60;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class FindElementTests {

    WebDriver driver;
    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://ilcarro.web.app");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void findElementByTagName() {
        // find element by tag name
        WebElement element = driver.findElement(By.tagName("h1"));
        System.out.println(element.getText());

        WebElement element1 = driver.findElement(By.tagName("a"));
        System.out.println(element1.getText());

        // find list elements by tag name
        List<WebElement> elements = driver.findElements(By.tagName("a"));
        System.out.println(elements.size());
    }

    @Test
    public void findElementBySimpleLocators() {
        // find by id
        driver.findElement(By.id("city"));

        // find by className
        driver.findElement(By.className("header"));

        // find by linkText
        driver.findElement(By.linkText("Let the car work"));

        // find by partialLinkText
        driver.findElement(By.partialLinkText("car"));
    }

    @Test
    public void findByCssSelectorTest() {
        // find element by tag name ->=== css
        // driver.findElement(By.tagName("h1"));
        driver.findElement(By.cssSelector("h1"));


        // id -> css
        // driver.findElement(By.id("city"));
        driver.findElement(By.cssSelector("#city"));

        // find by className -> css
        // driver.findElement(By.className("header"));
        driver.findElement(By.cssSelector(".header"));

        // [attr= 'value']
        driver.findElement(By.cssSelector("[href='/login?url=%2Fsearch']"));

        // contains -> *
        driver.findElement(By.cssSelector("[href*='login']"));

        // start -> ^
        driver.findElement(By.cssSelector("[href^='/log']"));

        // end on -> $
        driver.findElement(By.cssSelector("[href$='search']"));

        // tag and id
        driver.findElement(By.cssSelector("input#city"));

        // tag and className
        driver.findElement(By.cssSelector("div.search-card"));

        // tag and id and [attr= 'value']
        driver.findElement(By.cssSelector("input#city[type='text']"));

    }

    //  //*[@attr='value']
    @Test
    public void findElementByXpath() {
        // tag -> xpath - //tag
        // driver.findElement(By.tagName("h1"));
        driver.findElement(By.xpath("//h1"));


        // id -> xpath - //*[@id='value']
        // driver.findElement(By.id("city"));
        driver.findElement(By.xpath("//input[@id='city']"));

        // className -> xpath - //*[@class='value']
        // driver.findElement(By.className("header"));
        driver.findElement(By.xpath("//div[@class='header']"));

        // contains -> //*[contains(.,'Text')]
        driver.findElement(By.xpath("//h2[contains(.,'Yalla')]"));

        // equal -> //*[text()='FullText']
        driver.findElement(By.xpath("//h2[text()='Type your data and hit Yalla!']"));
        driver.findElement(By.xpath("//h2[.='Type your data and hit Yalla!']")); // то же самое

        // start-with -> //*[starts-with(@attr,'value')]
        driver.findElement(By.xpath("//label[starts-with(@for,'ci')]"));

        // move up
        driver.findElement(By.xpath("//a[@class='navigation-link']/.."));

        // parent
        driver.findElement(By.xpath("//h1/parent::*"));
        driver.findElement(By.xpath("//h1/..")); // аналогичная запись

        //ancestor
        driver.findElement(By.xpath("//h1/ancestor::*")); // all
        driver.findElement(By.xpath("//h1/ancestor::div")); // two options
        driver.findElement(By.xpath("//h1/ancestor::div[2]")); // one option

        // following-sibling
        driver.findElement(By.xpath("//h1/following-sibling::form"));

        // preceding-sibling
        driver.findElement(By.xpath("//h2/preceding-sibling::*"));


    }

    @AfterMethod(enabled = true)
    public void tearDown() {
        driver.quit();
    }

    // city





}
