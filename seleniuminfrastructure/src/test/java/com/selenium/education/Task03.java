package com.selenium.education;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by kormichael on 02.06.2017.
 */
public class Task03 {
    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void start() {
//        driver = new ChromeDriver();
        driver = new FirefoxDriver();
//        driver = new InternetExplorerDriver();
        wait = new WebDriverWait(driver, 10);
    }

    @Test
    public void firstTest() {
        WebElement login;
        WebElement password;
        WebElement loginButton;
        try {
            driver.get("http://google.com");
            System.out.println("Выполнен вход в инет магазин!");
        } catch (Exception e) {
            System.out.println("Что то пошло не так..." + e.getMessage());
        }
    }

    @After
    public void stop() {
        driver.quit();
        driver = null;
    }
}
