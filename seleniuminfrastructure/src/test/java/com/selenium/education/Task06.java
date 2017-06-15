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

import java.util.*;


/**
 * Created by kormichael on 14.06.2017.
 */
public class Task06 {
    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void start() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);
        driver.get("http://localhost/litecart/admin");
        try {
            driver.findElement(By.name("username")).sendKeys("admin");
            driver.findElement(By.name("password")).sendKeys("admin1");
            driver.findElement(By.name("login")).click();
        } catch (Exception e) {
            System.out.println("Ошибка при входе в систему: "+e.getMessage());
        }
    }

    @Test
    public void task09 () {
        List<WebElement> countries;
        List<String> countriesNames = new ArrayList<String>();
        List<String> sortedContriesNames = new ArrayList<String>();
        List<String> locators = new ArrayList<String>();
        Iterator<String> iter;
        List<String> manyZonesCountries = new ArrayList<String>();
        WebElement country;
        /*
        Первая часть задания
         */
        driver.get("http://localhost/litecart/admin/?app=countries&doc=countries");
        countries = driver.findElements(By.xpath("//table[@class='dataTable']/*/tr[@class='row']/*/a[not(@title='Edit')]"));
        try {
            for (int i = 0; i < countries.size() ; i++) {
                String locator;
                country = countries.get(i);
                countriesNames.add(country.getText());
                sortedContriesNames.add(country.getText());
                locator = "//table[@class='dataTable']/*/tr[@class='row']["+(i+1)+"]/td[6]";
                if (new Integer(driver.findElement(By.xpath(locator)).getText()).intValue() > 0) {
                    locator = "//table[@class='dataTable']/*/tr[@class='row']["+(i+1)+"]/*/a[not(@title='Edit')]";
                    manyZonesCountries.add(locator);
                }
            }
            Collections.sort(sortedContriesNames);
            Assert.assertTrue(compareLists(countriesNames, sortedContriesNames));
            if (manyZonesCountries.size() > 0) {
                iter = manyZonesCountries.iterator();
                while (iter.hasNext()) {
                    driver.findElement(By.xpath(iter.next())).click();
                    checkCountryZones("//table[@id='table-zones']/*/tr[not(@class='header')]/td[3]");
                }
            }
        /*
            Вторая часть задания
         */
            driver.get("http://localhost/litecart/admin/?app=geo_zones&doc=geo_zones");
            countries = driver.findElements(By.xpath("//table[@class='dataTable']/*/tr[@class='row']/td/a[not(@title='Edit')]"));
            for (int i = 0; i <countries.size() ; i++) {
                locators.add("//table[@class='dataTable']/*/tr[@class='row']["+(i+1)+"]/td/a[not(@title='Edit')]");
            }
            iter = locators.iterator();
            while (iter.hasNext()) {
                driver.findElement(By.xpath(iter.next())).click();
                checkCountryZones("//table[@id='table-zones']/*/tr[not(@class='header')]/td[3]/select/option[@selected]");
            }

        } catch (NumberFormatException e) {
            System.out.println("Ошибка: "+e.getMessage());
        }
    }
    private boolean checkCountryZones (String locator) {
        boolean ret = true;
        List<String> zones = new ArrayList<String>();
        List<String> sortedZones = new ArrayList<String>();
        List<WebElement> elements;
        elements = driver.findElements(By.xpath(locator));
        for (int i = 0; i < elements.size()-1; i++) {
            zones.add(elements.get(i).getText());
            sortedZones.add(elements.get(i).getText());
        }
        Collections.sort(sortedZones);
        ret = compareLists(zones, sortedZones);
        Assert.assertTrue(ret);
        driver.findElement(By.xpath("//button[@name='cancel']")).click();
        return ret;
    }

    private boolean compareLists(List<String> first, List<String> second) {
        int size;
        if (first.size() != second.size()) {
            return false;
        }
        size = first.size();
        for (int i = 0; i < size; i++) {
            if (first.get(i).compareTo(second.get(i)) != 0 ) {
                return false;
            }
        }
        return true;
    }

    @After
    public void stop() {
        driver.quit();
        driver = null;
    }
}
