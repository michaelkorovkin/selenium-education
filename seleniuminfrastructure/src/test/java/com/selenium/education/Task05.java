package com.selenium.education;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Iterator;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by kormichael on 13.06.2017.
 */
public class Task05 {
    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void start() {
        WebElement login;
        WebElement password;
        WebElement loginButton;
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);
        driver.get("http://localhost/litecart/en/");
    }


    @After
    public void stop() {
        driver.quit();
        driver = null;
    }
}
