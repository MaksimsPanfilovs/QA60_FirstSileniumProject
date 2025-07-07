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

public class TableTests {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://www.w3schools.com/css/css_table.asp");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void findElementTableWithCssTable() {
        // print number of row
        List<WebElement> rows = driver.findElements(By.cssSelector("tr"));
        System.out.println(rows.size());
        for (WebElement el : rows) {
            System.out.println(el.getText());
            // get row 4
            WebElement element = driver.findElement(By.cssSelector("tr:nth-child(4)")); // xpath -> //tr[4]
            System.out.println(element.getText());
            System.out.println("\n=============================");
            //get first item in row
            WebElement element1 = driver.findElement(By.cssSelector("tr:nth-child(7) td:nth-child(1)"));
            System.out.println(element1.getText());
            System.out.println("\n=============================");

            // get last element
            WebElement canada = driver.findElement(By.cssSelector("tr:nth-child(8) td:nth-child(3)"));
            System.out.println(canada.getText());
            System.out.println("\n=============================");
        }

    }


    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
