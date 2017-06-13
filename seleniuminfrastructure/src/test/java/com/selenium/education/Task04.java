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

    @Test
    public void firstTest() {
        List<WebElement> menuElements;
        WebElement menuElement;
        int count;
        try {
            menuElements = driver.findElements(By.cssSelector("ul[id='box-apps-menu'] li[id='app-']"));
            count = menuElements.size();
            for (int i = 1; i <= count; i++) {
                String locator;
                menuElement = driver.findElement(By.cssSelector("ul[id='box-apps-menu'] li[id='app-']:nth-child(" + i + ") a"));
                System.out.println("Element Text: " + menuElement.getText());
                menuElement.click();
                locator = "ul[id='box-apps-menu'] li[id='app-']:nth-child(" + i + ")";
                clickOnSubmenuElements(locator);
                assertTrue(isElementPresent(driver, By.xpath("//td[@id='content']/h1")));
            }
        } catch (Exception e) {
            System.out.println("Ошибка: "+e.getMessage());
        }
    }

    private void clickOnSubmenuElements(String locator) {
        WebElement parentElement;
        List<WebElement> menuElements;
        WebElement menuElement;
        int count;
        parentElement = driver.findElement(By.cssSelector(locator));
        menuElements = parentElement.findElements(By.cssSelector("ul.docs li"));
        count = menuElements.size();
        if (count == 0) {
            return;
        }
        for (int i = 1; i <= count; i++) {
            menuElement = parentElement.findElement(By.cssSelector("ul.docs li:nth-child(" + i + ") a"));
            System.out.println("Element Text: " + menuElement.getText());
            menuElement.click();
            parentElement = driver.findElement(By.cssSelector(locator));
        }
    }

    boolean isElementPresent(WebDriver driver, By locator) {
        try {
            driver.findElement(locator);
            return true;
        } catch (NoSuchElementException ex) {
            return false;
        }
    }

    @After
    public void stop() {
        driver.quit();
        driver = null;
    }
}
