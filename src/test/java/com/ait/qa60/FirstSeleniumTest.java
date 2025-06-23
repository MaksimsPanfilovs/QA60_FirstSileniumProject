package com.ait.qa60;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class FirstSeleniumTest {

    WebDriver driver;

    // before - setUp
    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
//        driver.get("https://www.google.com"); // без истории
        // maximize browser to Windows
        driver.manage().window().maximize();

        // wait for all elements
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.navigate().to("https://ilcarro.web.app/search"); // с историей
        driver.navigate().to("https://www.google.com");
        driver.navigate().back();
        driver.navigate().forward();
        driver.navigate().refresh();

    }

    // test - название должно быть прозрачно
    @Test
    public void openGoogleTest() {
        System.out.println("Open");
    }

    // after - tearDown
    @AfterMethod(enabled = false)
    public void tearDown() {
//        driver.quit(); // закрывает все вкладке и браузер
        driver.close(); // закрывает только одну вкладку (only one tab)
    }
}
