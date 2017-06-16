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
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;
import java.util.UUID;

/**
 * Created by kormichael on 16.06.2017.
 */
public class Task12 {
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
        try {
            fullFileName = new File("src/main/resources/b_favorite.png").getAbsolutePath();
            driver.findElement(By.cssSelector("td#sidebar ul#box-apps-menu li#app- > a[href$='catalog']")).click();
            driver.findElement(By.cssSelector("td#sidebar ul#box-apps-menu li#app- > ul.docs li#doc-catalog")).click();
            driver.findElement(By.cssSelector("a.button[href$='edit_product']")).click();
            driver.findElement(By.cssSelector("label input[value='1']")).click();
            driver.findElement(By.cssSelector("input[name='name[en]']")).sendKeys(goodName);
            driver.findElement(By.cssSelector("input[name='code']")).sendKeys("code01");
            driver.findElement(By.cssSelector("input[name='categories[]'][data-name='Root']")).click();
            driver.findElement(By.cssSelector("input[name='categories[]'][data-name='Subcategory']")).click();
            driver.findElement(By.cssSelector("input[name='product_groups[]'][value='1-3']")).click();
            driver.findElement(By.cssSelector("input[name='new_images[]")).sendKeys(fullFileName);
            driver.findElement(By.cssSelector("input[name='date_valid_from']")).sendKeys("01012017");
            driver.findElement(By.cssSelector("input[name='date_valid_to']")).sendKeys("01012020");

            driver.findElement(By.cssSelector("ul.index a[href$='information']")).click();
            select = new Select(driver.findElement(By.cssSelector("select[name='manufacturer_id']")));
            actions.pause(Duration.ofMillis(200)).perform();
            select.selectByValue("1");
            driver.findElement(By.cssSelector("input[name='keywords']")).sendKeys("super keywords");
            driver.findElement(By.cssSelector("input[name='short_description[en]']")).sendKeys("The best elephant!");
            driver.findElement(By.cssSelector("div.trumbowyg-editor")).sendKeys("Let`s buy our elephants!");
            driver.findElement(By.cssSelector("input[name='head_title[en]']")).sendKeys("Head title");
            driver.findElement(By.cssSelector("input[name='meta_description[en]']")).sendKeys("Meta description");

            driver.findElement(By.cssSelector("ul.index a[href$='prices']")).click();
            actions.pause(Duration.ofMillis(200)).perform();
            driver.findElement(By.cssSelector("input[name='purchase_price']")).sendKeys("12.0");
            select = new Select(driver.findElement(By.cssSelector("select[name='purchase_price_currency_code']")));
            select.selectByValue("USD");

            driver.findElement(By.cssSelector("input[name='prices[USD]']")).sendKeys("12");
            driver.findElement(By.cssSelector("input[name='prices[EUR]']")).sendKeys("10");
            driver.findElement(By.cssSelector("span.button-set button[name='save']")).click();

            driver.findElement(By.cssSelector("td#sidebar ul#box-apps-menu li#app- > a[href$='catalog']")).click();
            driver.findElement(By.cssSelector("td#sidebar ul#box-apps-menu li#app- > ul.docs li#doc-catalog")).click();
            driver.findElement(By.cssSelector("a[href$='doc=catalog&category_id=1']")).click();
            driver.findElement(By.cssSelector("a[href$='doc=catalog&category_id=2']")).click();
            Assert.assertTrue(isElementPresent(driver, By.xpath("//a[contains(.,'"+goodName+"')]")));
        } catch (Exception e) {
            Assert.fail("Ошибка: "+e.getMessage());
        }
    }

    private boolean isElementPresent(WebDriver driver, By locator) {
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
