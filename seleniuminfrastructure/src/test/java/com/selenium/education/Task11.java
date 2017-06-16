package com.selenium.education;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.UUID;


/**
 * Created by kormichael on 16.06.2017.
 */
public class Task11 {
    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void start() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);
        driver.get("http://localhost/litecart/en/create_account");
    }

    @Test
    public void task () {
        String email;
        String password;
        email = UUID.randomUUID().toString()+"@qqq.qq";
        password = UUID.randomUUID().toString();
        Actions actions = new Actions(driver);
        Select select;
        try {
            driver.findElement(By.cssSelector("form[name='customer_form'] input[name='firstname']")).sendKeys("John");
            driver.findElement(By.cssSelector("form[name='customer_form'] input[name='lastname']")).sendKeys("Dow");
            driver.findElement(By.cssSelector("form[name='customer_form'] input[name='address1']")).sendKeys("Main st 1/2");
            driver.findElement(By.cssSelector("form[name='customer_form'] input[name='postcode']")).sendKeys("12345");
            driver.findElement(By.cssSelector("form[name='customer_form'] input[name='city']")).sendKeys("City");
            select = new Select(driver.findElement(By.cssSelector("form[name='customer_form'] select[name='country_code']")));
            select.selectByValue("US");
            actions.pause(java.time.Duration.ofSeconds(1)).perform();
            select = new Select(driver.findElement(By.cssSelector("form[name='customer_form'] select[name='zone_code']")));
            select.selectByIndex(3);
            driver.findElement(By.cssSelector("form[name='customer_form'] input[name='email']")).sendKeys(email);
            driver.findElement(By.cssSelector("form[name='customer_form'] input[name='phone']")).sendKeys("+123456789");
            driver.findElement(By.cssSelector("form[name='customer_form'] input[name='password']")).sendKeys(password);
            driver.findElement(By.cssSelector("form[name='customer_form'] input[name='confirmed_password']")).sendKeys(password);
            driver.findElement(By.cssSelector("form[name='customer_form'] button[name='create_account']")).click();
            driver.findElement(By.cssSelector("div#box-account div.content ul.list-vertical a[href$='logout']")).click();
            driver.findElement(By.cssSelector("form[name='login_form'] input[name='email']")).sendKeys(email);
            driver.findElement(By.cssSelector("form[name='login_form'] input[name='password']")).sendKeys(password);
            driver.findElement(By.cssSelector("form[name='login_form'] button[name='login']")).click();
        } catch (Exception e) {
            Assert.fail("Ошибка: "+e.getMessage());
        }
    }

    @After
    public void stop() {
        driver.quit();
        driver = null;
    }
}
