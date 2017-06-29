package com.selenium.education;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.openqa.selenium.support.ui.ExpectedConditions.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by kormichael on 28.06.2017.
 */
public class Task17 {
    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void start() {
        try {
            driver = new ChromeDriver();
            wait = new WebDriverWait(driver, 10);
            driver.get("http://localhost/litecart/admin");
            driver.findElement(By.name("username")).sendKeys("admin");
            driver.findElement(By.name("password")).sendKeys("admin1");
            driver.findElement(By.name("login")).click();
        } catch (Exception e) {
            System.out.println("Ошибка: "+e.getMessage());
            Assert.fail("Ошибка: "+e.getMessage());
        }
    }

    @Test
    public void task () {
        List<WebElement> goods;
        Iterator<WebElement> iter;
        List<String> locators;
        Iterator<String> locatorsIter;
        try {
            driver.get("http://localhost/litecart/admin/?app=catalog&doc=catalog&category_id=1");
            goods = driver.findElements(By.xpath("//table[@class='dataTable']/*/tr[@class='row']/td/a[contains(text(),'Duck')]"));
            iter = goods.iterator();
            locators = new ArrayList<String>();
            while (iter.hasNext()) {
                locators.add(iter.next().getAttribute("href"));
            }
            locatorsIter = locators.iterator();
            while (locatorsIter.hasNext()) {
                String locator = locatorsIter.next();
                driver.findElement(By.xpath("//table[@class='dataTable']/*/tr[@class='row']/td/a[@href='"+locator+"']")).click();
                wait.until(presenceOfElementLocated(By.xpath("//button[@name='cancel']")));
                driver.findElement(By.xpath("//button[@name='cancel']")).click();
                Assert.assertTrue(driver.manage().logs().get("browser").getAll().size() == 0);
            }
            Assert.assertTrue("Задание выполнено", true);
        } catch (Exception e) {
            System.out.println("Ошибка выполнения теста: "+e.getMessage());
            Assert.fail("Ошибка выполнения теста: "+e.getMessage());
        }

    }

    @After
    public void stop() {
        driver.quit();
        driver = null;
    }
}
