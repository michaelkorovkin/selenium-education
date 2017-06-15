package com.selenium.education;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by kormichael on 15.06.2017.
 */
public class Task10 {
    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void start() {
//        driver = new FirefoxDriver();
//        driver = new InternetExplorerDriver();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);
        driver.get("http://localhost/litecart/en/");
    }

    @Test
    public void test () {
        WebElement link;
        String name;
        String regularPrice;
        String campaignPrice;
        String regularColor;
        String regularTextDecorationLine;
        String campaingColor;
        String campaingFontWeight;


        try {
            link = driver.findElement(By.cssSelector("div#box-campaigns a.link"));
            name = driver.findElement(By.cssSelector("div#box-campaigns div.name")).getText();
            regularPrice = driver.findElement(By.cssSelector("div#box-campaigns s.regular-price")).getText();
            campaignPrice = driver.findElement(By.cssSelector("div#box-campaigns strong.campaign-price")).getText();
            regularTextDecorationLine = driver.findElement(By.cssSelector("div#box-campaigns s.regular-price")).getCssValue("text-decoration-line");
            regularColor = driver.findElement(By.cssSelector("div#box-campaigns s.regular-price")).getCssValue("color");
            campaingColor = driver.findElement(By.cssSelector("div#box-campaigns strong.campaign-price")).getCssValue("color");
            campaingFontWeight = driver.findElement(By.cssSelector("div#box-campaigns strong.campaign-price")).getCssValue("font-weight");
            Assert.assertTrue(Integer.parseInt(regularPrice.substring(1, regularPrice.length())) >
                    Integer.parseInt(campaignPrice.substring(1, campaignPrice.length())));
            link.click();
            Assert.assertTrue(driver.findElement(By.cssSelector("h1.title")).getText().compareTo(name) == 0);
            Assert.assertTrue(driver.findElement(By.cssSelector("s.regular-price")).getText().compareTo((regularPrice)) == 0);
            Assert.assertTrue(driver.findElement(By.cssSelector("strong.campaign-price")).getText().compareTo(campaignPrice) == 0);
            Assert.assertTrue(driver.findElement(By.cssSelector("s.regular-price")).getCssValue("text-decoration-line")
                    .compareTo(regularTextDecorationLine) == 0);
            Assert.assertTrue(driver.findElement(By.cssSelector("s.regular-price")).getCssValue("color")
                    .compareTo(regularColor) == 0);
            Assert.assertTrue(driver.findElement(By.cssSelector("strong.campaign-price")).getCssValue("color")
                    .compareTo(campaingColor) == 0);
            Assert.assertTrue(driver.findElement(By.cssSelector("strong.campaign-price")).getCssValue("font-weight")
                    .compareTo(campaingFontWeight) == 0);
            regularPrice = driver.findElement(By.cssSelector("s.regular-price")).getText();
            campaignPrice = driver.findElement(By.cssSelector("strong.campaign-price")).getText();
            Assert.assertTrue(Integer.parseInt(regularPrice.substring(1, regularPrice.length())) >
                    Integer.parseInt(campaignPrice.substring(1, campaignPrice.length())));
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
