package com.selenium.education;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import sun.reflect.generics.tree.Tree;

import java.time.Duration;
import java.util.*;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;
/**
 * Created by kormichael on 27.06.2017.
 */
public class Task14 {
    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void start() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);
        driver.get("http://localhost/litecart/admin");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin1");
        driver.findElement(By.name("login")).click();
    }

    @Test
    public void task () {
        Actions actions = new Actions(driver);
        Select select;
        String goodName = UUID.randomUUID().toString();
        String fullFileName;
        WebElement element;
        List<WebElement> aList;
        Iterator<WebElement> iter;
        try {
            driver.findElement(By.xpath("//a[@href='http://localhost/litecart/admin/?app=countries&doc=countries']")).click();
            driver.findElement(By.xpath("//a[@href='http://localhost/litecart/admin/?app=countries&doc=edit_country']")).click();
            aList = driver.findElements(By.xpath("//td/a[@target='_blank']/i"));
            iter = aList.iterator();
            while (iter.hasNext()) {
                String mainWindow = driver.getWindowHandle();
                Set<String> oldWindows = driver.getWindowHandles();
                element = iter.next();
                element.click();
                String newWindow = wait.until(thereIsWindowOtherThan(oldWindows));
                driver.switchTo().window(newWindow);
                driver.close();
                driver.switchTo().window(mainWindow);
            }
            Assert.assertTrue(true);
        } catch (Exception e) {
            Assert.fail("Ошибка: "+e.getMessage());
        }
    }

    public static ExpectedCondition<String> thereIsWindowOtherThan(Set<String> oldWindows) {
        return new ExpectedCondition<String>() {
            public String apply(WebDriver driver) {
                String[] currentWindowsHandlersList;
                String[] oldWindowsHandlers;
                TreeSet<String> sortedSet;
                try {
                    sortedSet = new TreeSet<String>(oldWindows);
                    oldWindowsHandlers = sortedSet.toArray(new String[oldWindows.size()]);
                    sortedSet = new TreeSet<String>(driver.getWindowHandles());
                    currentWindowsHandlersList = sortedSet.toArray(new String[sortedSet.size()]);
                    if (oldWindowsHandlers.length == currentWindowsHandlersList.length) {
                        return null;
                    }
                    for (int i = 0; i < oldWindowsHandlers.length; i++) {
                        if (!oldWindowsHandlers[i].equals(currentWindowsHandlersList[i])) {
                            return currentWindowsHandlersList[i];
                        }
                    }
                    return currentWindowsHandlersList[currentWindowsHandlersList.length-1];
                } catch (Exception e) {
                    System.out.println("Ошибка: "+ e.getMessage());
                    return null;
                }
            }
            public String toString() {
                return "";
            }
        };

    }

    @After
    public void stop() {
        driver.quit();
        driver = null;
    }

}
