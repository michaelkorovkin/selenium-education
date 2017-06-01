package com.selenium.education;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by kormichael on 01.06.2017.
 */
public class Task02 {
    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void start() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);
    }

    @Test
    public void firstTest() {
        WebElement login;
        WebElement password;
        WebElement loginButton;
        try {
            driver.get("http://localhost/litecart/admin/");
            login = driver.findElement(By.name("username"));
            password = driver.findElement(By.name("password"));
            loginButton = driver.findElement(By.name("login"));
            login.sendKeys("admin");
            password.sendKeys("admin1");
            loginButton.click();
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
