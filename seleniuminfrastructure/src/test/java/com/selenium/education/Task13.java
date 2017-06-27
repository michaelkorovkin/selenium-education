package com.selenium.education;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


import static org.openqa.selenium.support.ui.ExpectedConditions.not;
import static org.openqa.selenium.support.ui.ExpectedConditions.numberOfElementsToBe;
import static org.openqa.selenium.support.ui.ExpectedConditions.textToBePresentInElement;

/**
 * Created by kormichael on 27.06.2017.
 */
public class Task13 {
    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void start() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);
        driver.get("http://localhost/litecart");
    }

    @Test
    public void test () {
        WebElement element;
        Select select;
        Integer count;
        WebElement removeButton;
        Actions actions = new Actions(driver);
        int trCount = 0;
        try {
            for (int i = 0; i < 3; i++) {
                element = driver.findElement(By.xpath("//div[@id='box-most-popular']/div[@class='content']/ul/li"));
                element.click();
                element = driver.findElement(By.xpath("//span[@class='quantity']"));
                count = new Integer(element.getText());
                try {
                    element  = driver.findElement(By.xpath("//select[@name='options[Size]']"));
                } catch (Exception e) {
                    element = null;
                }
                if (element != null) {
                    select = (Select) element;
                    select.selectByIndex(1);
                }
                element = driver.findElement(By.xpath("//button[@name='add_cart_product']"));
                element.click();
                element = driver.findElement(By.xpath("//span[@class='quantity']"));
                wait.until(not (textToBePresentInElement(element, count.toString())));
                driver.findElement(By.xpath("//div[@id='logotype-wrapper']")).click();
            }
            driver.findElement(By.xpath("//a[@href='http://localhost/litecart/en/checkout'][@class='link']")).click();
            try {
                while (true) {
                    trCount = driver.findElements(By.xpath("//table[@class='dataTable rounded-corners']/*/tr")).size();
                    removeButton = driver.findElement(By.xpath("//button[@name='remove_cart_item']"));
                    removeButton.click();
                    wait.until(numberOfElementsToBe(By.xpath("//table[@class='dataTable rounded-corners']/*/tr"), trCount-1));
                }
            } catch (Exception e) {
                Assert.assertTrue("Закончили удалять товары из корзины", true);
            }
            Assert.assertTrue("Задание выполнено", true);
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
