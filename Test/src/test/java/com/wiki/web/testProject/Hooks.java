
package com.wiki.web.testProject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class Hooks {

    static WebDriver driver;

    @BeforeMethod
    public static void BeforeTest() {
        driver = new ChromeDriver();
        System.out.print("THIS IS BEFORE METHOD");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void AfterTest() {
        System.out.print("THIS IS AFTER METHOD");
        driver.quit();
    }
}
