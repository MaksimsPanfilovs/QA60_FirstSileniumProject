package com.ait.qa60;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DemoWebShopTest {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://demowebshop.tricentis.com/");
    }

    @Test
    public void firstTest() {
        System.out.println("Open Shop");
    }

    @Test
    public void findElementBySimpleLocators() {
        driver.findElement(By.tagName("img"));
        driver.findElement(By.linkText("Register"));
        driver.findElement(By.linkText("Log in"));
        driver.findElement(By.linkText("Shopping cart"));
        driver.findElement(By.linkText("Wishlist"));
        driver.findElement(By.id("small-searchterms"));
        driver.findElement(By.className("top-menu"));
        driver.findElement(By.linkText("Shopping cart"));
        driver.findElement(By.partialLinkText("Com"));
        driver.findElement(By.partialLinkText("Ele"));

    }

    @Test
    public void findElementByCssSelector() {
//        driver.findElement(By.cssSelector(".button-1 search-box-button"));
        driver.findElement(By.cssSelector("[href^='/app']"));
        driver.findElement(By.cssSelector("[href*='digit']"));
        driver.findElement(By.cssSelector("[href$='lry']"));
        driver.findElement(By.cssSelector(".nivo-imageLink"));
        driver.findElement(By.cssSelector("#newsletter-subscribe-button"));
        driver.findElement(By.cssSelector(".listbox"));
        driver.findElement(By.cssSelector("h2"));
        driver.findElement(By.cssSelector("strong"));
        driver.findElement(By.cssSelector(".footer-poweredby"));
        driver.findElement(By.cssSelector("[href='http://www.nopcommerce.com/']"));
    }

    @Test
    public void findElementByXpath() {
        driver.findElement(By.xpath("//h2"));
        driver.findElement(By.xpath("//input[@id='newsletter-subscribe-button']"));
        driver.findElement(By.xpath("//div[@class='leftside-3']"));
        driver.findElement(By.xpath("//li[contains(.,'Computers')]"));
        driver.findElement(By.xpath("//strong[.='Categories']"));
        driver.findElement(By.xpath("//a[.='Addresses']"));
        driver.findElement(By.xpath("//h3[contains(.,'Customer')]"));
        driver.findElement(By.xpath("//h3[starts-with(.,'My')]"));
    }

    @AfterMethod(enabled = true)
    public void tearDown() {
        driver.quit();
    }
}