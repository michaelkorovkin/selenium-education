package com.selenium.education;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static junit.framework.TestCase.assertTrue;

/**
 * Created by kormichael on 07.06.2017.
 */
public class Task04 {
    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void start() {
        WebElement login;
        WebElement password;
        WebElement loginButton;
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);
        driver.get("http://localhost/litecart/admin");
        login = driver.findElement(By.name("username"));
        password = driver.findElement(By.name("password"));
        loginButton = driver.findElement(By.name("login"));
        login.sendKeys("admin");
        password.sendKeys("admin1");
        loginButton.click();
    }


    @After
    public void stop() {
        driver.quit();
        driver = null;
    }
}
