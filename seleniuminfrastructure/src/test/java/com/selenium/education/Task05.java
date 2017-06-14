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
    @Test
    public void firstTest() {
        List<WebElement> goods;
        Iterator<WebElement> iter;
        List<WebElement> stickers;
        WebElement good;
        try {
            goods = driver.findElements(By.cssSelector("div#box-most-popular>div.content li.product.column.shadow.hover-light"));
            System.out.println("Популярных товаров: "+goods.size());
            iter = goods.iterator();
            while (iter.hasNext()) {
                good = iter.next();
                stickers = good.findElements(By.cssSelector("div.sticker"));
                assertTrue(stickers.size() == 1);
            }
            goods = driver.findElements(By.cssSelector("div#box-campaigns>div.content li.product.column.shadow.hover-light"));
            System.out.println("Компанейских товаров: "+goods.size());
            iter = goods.iterator();
            while (iter.hasNext()) {
                good = iter.next();
                stickers = good.findElements(By.cssSelector("div.sticker"));
                assertTrue(stickers.size() == 1);
            }

            goods = driver.findElements(By.cssSelector("div#box-latest-products>div.content li.product.column.shadow.hover-light"));
            System.out.println("Последний выпуск: "+goods.size());
            iter = goods.iterator();
            while (iter.hasNext()) {
                good = iter.next();
                stickers = good.findElements(By.cssSelector("div.sticker"));
                assertTrue(stickers.size() == 1);
            }
        } catch (Exception e) {
            System.out.println("Ошибка: "+e.getMessage());
        }
    }

    @After
    public void stop() {
        driver.quit();
        driver = null;
    }
}
