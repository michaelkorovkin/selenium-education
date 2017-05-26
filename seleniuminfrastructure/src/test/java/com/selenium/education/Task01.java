package com.selenium.education;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by kormichael on 26.05.2017.
 */
public class Task01 {
    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void start() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);
    }

    @Test
    public void firstTest() {
        driver.get("http://www.mail.ru/");
    }

    @After
    public void stop() {
        driver.quit();
        driver = null;
    }
}
