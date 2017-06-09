package com.selenium.education;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by kormichael on 07.06.2017.
 */
public class Task04 {
    private WebDriver driver;
    private WebDriverWait wait;
    private List<String> locators;

    @Before
    public void start() {
        WebElement login;
        WebElement password;
        WebElement loginButton;
        driver = new ChromeDriver();
//        driver = new FirefoxDriver();
//        driver = new InternetExplorerDriver();
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
        WebElement element;
        Iterator<String> iter;
        fullLocators();
        iter = locators.iterator();
        while (iter.hasNext()) {
            try {
                element = driver.findElement(By.xpath(iter.next()));
                System.out.println(element.getText());
                element.click();
                if (!isElementPresent(driver, By.xpath("//td[@id='content']/h1"))) {
                    System.out.println("Отсутствует заголовок!");
                }
            } catch (Exception e) {
                System.out.println("Что то пошло не так..." + e.getMessage());
            }
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
    private void fullLocators() {
        locators = new ArrayList<String>();
        locators.add("//ul[@id='box-apps-menu']/li[@id='app-']/a[@href='http://localhost/litecart/admin/?app=appearance&doc=template']");
        locators.add("//ul[@id='box-apps-menu']/li[@id='app-']/a[@href='http://localhost/litecart/admin/?app=appearance&doc=template']/../ul[@class='docs']/li[@id='doc-template']");
        locators.add("//ul[@id='box-apps-menu']/li[@id='app-']/a[@href='http://localhost/litecart/admin/?app=appearance&doc=template']/../ul[@class='docs']/li[@id='doc-logotype']");
        locators.add("//ul[@id='box-apps-menu']/li[@id='app-']/a[@href='http://localhost/litecart/admin/?app=catalog&doc=catalog']");
        locators.add("//ul[@id='box-apps-menu']/li[@id='app-']/a[@href='http://localhost/litecart/admin/?app=catalog&doc=catalog']/../ul[@class='docs']/li[@id='doc-catalog']");
        locators.add("//ul[@id='box-apps-menu']/li[@id='app-']/a[@href='http://localhost/litecart/admin/?app=catalog&doc=catalog']/../ul[@class='docs']/li[@id='doc-product_groups']");
        locators.add("//ul[@id='box-apps-menu']/li[@id='app-']/a[@href='http://localhost/litecart/admin/?app=catalog&doc=catalog']/../ul[@class='docs']/li[@id='doc-option_groups']");
        locators.add("//ul[@id='box-apps-menu']/li[@id='app-']/a[@href='http://localhost/litecart/admin/?app=catalog&doc=catalog']/../ul[@class='docs']/li[@id='doc-manufacturers']");
        locators.add("//ul[@id='box-apps-menu']/li[@id='app-']/a[@href='http://localhost/litecart/admin/?app=catalog&doc=catalog']/../ul[@class='docs']/li[@id='doc-suppliers']");
        locators.add("//ul[@id='box-apps-menu']/li[@id='app-']/a[@href='http://localhost/litecart/admin/?app=catalog&doc=catalog']/../ul[@class='docs']/li[@id='doc-delivery_statuses']");
        locators.add("//ul[@id='box-apps-menu']/li[@id='app-']/a[@href='http://localhost/litecart/admin/?app=catalog&doc=catalog']/../ul[@class='docs']/li[@id='doc-sold_out_statuses']");
        locators.add("//ul[@id='box-apps-menu']/li[@id='app-']/a[@href='http://localhost/litecart/admin/?app=catalog&doc=catalog']/../ul[@class='docs']/li[@id='doc-quantity_units']");
        locators.add("//ul[@id='box-apps-menu']/li[@id='app-']/a[@href='http://localhost/litecart/admin/?app=catalog&doc=catalog']/../ul[@class='docs']/li[@id='doc-csv']");
        locators.add("//ul[@id='box-apps-menu']/li[@id='app-']/a[@href='http://localhost/litecart/admin/?app=countries&doc=countries']");
        locators.add("//ul[@id='box-apps-menu']/li[@id='app-']/a[@href='http://localhost/litecart/admin/?app=currencies&doc=currencies']");
        locators.add("//ul[@id='box-apps-menu']/li[@id='app-']/a[@href='http://localhost/litecart/admin/?app=customers&doc=customers']");
        locators.add("//ul[@id='box-apps-menu']/li[@id='app-']/a[@href='http://localhost/litecart/admin/?app=customers&doc=customers']/../ul[@class='docs']/li[@id='doc-customers']");
        locators.add("//ul[@id='box-apps-menu']/li[@id='app-']/a[@href='http://localhost/litecart/admin/?app=customers&doc=customers']/../ul[@class='docs']/li[@id='doc-csv']");
        locators.add("//ul[@id='box-apps-menu']/li[@id='app-']/a[@href='http://localhost/litecart/admin/?app=customers&doc=customers']/../ul[@class='docs']/li[@id='doc-newsletter']");
        locators.add("//ul[@id='box-apps-menu']/li[@id='app-']/a[@href='http://localhost/litecart/admin/?app=geo_zones&doc=geo_zones']");
        locators.add("//ul[@id='box-apps-menu']/li[@id='app-']/a[@href='http://localhost/litecart/admin/?app=languages&doc=languages']");
        locators.add("//ul[@id='box-apps-menu']/li[@id='app-']/a[@href='http://localhost/litecart/admin/?app=languages&doc=languages']/../ul[@class='docs']/li[@id='doc-languages']");
        locators.add("//ul[@id='box-apps-menu']/li[@id='app-']/a[@href='http://localhost/litecart/admin/?app=languages&doc=languages']/../ul[@class='docs']/li[@id='doc-storage_encoding']");
        locators.add("//ul[@id='box-apps-menu']/li[@id='app-']/a[@href='http://localhost/litecart/admin/?app=modules&doc=jobs']");
        locators.add("//ul[@id='box-apps-menu']/li[@id='app-']/a[@href='http://localhost/litecart/admin/?app=modules&doc=jobs']/../ul[@class='docs']/li[@id='doc-jobs']");
        locators.add("//ul[@id='box-apps-menu']/li[@id='app-']/a[@href='http://localhost/litecart/admin/?app=modules&doc=jobs']/../ul[@class='docs']/li[@id='doc-customer']");
        locators.add("//ul[@id='box-apps-menu']/li[@id='app-']/a[@href='http://localhost/litecart/admin/?app=modules&doc=jobs']/../ul[@class='docs']/li[@id='doc-shipping']");
        locators.add("//ul[@id='box-apps-menu']/li[@id='app-']/a[@href='http://localhost/litecart/admin/?app=modules&doc=jobs']/../ul[@class='docs']/li[@id='doc-payment']");
        locators.add("//ul[@id='box-apps-menu']/li[@id='app-']/a[@href='http://localhost/litecart/admin/?app=modules&doc=jobs']/../ul[@class='docs']/li[@id='doc-order_total']");
        locators.add("//ul[@id='box-apps-menu']/li[@id='app-']/a[@href='http://localhost/litecart/admin/?app=modules&doc=jobs']/../ul[@class='docs']/li[@id='doc-order_success']");
        locators.add("//ul[@id='box-apps-menu']/li[@id='app-']/a[@href='http://localhost/litecart/admin/?app=modules&doc=jobs']/../ul[@class='docs']/li[@id='doc-order_action']");
        locators.add("//ul[@id='box-apps-menu']/li[@id='app-']/a[@href='http://localhost/litecart/admin/?app=orders&doc=orders']");
        locators.add("//ul[@id='box-apps-menu']/li[@id='app-']/a[@href='http://localhost/litecart/admin/?app=orders&doc=orders']/../ul[@class='docs']/li[@id='doc-orders']");
        locators.add("//ul[@id='box-apps-menu']/li[@id='app-']/a[@href='http://localhost/litecart/admin/?app=orders&doc=orders']/../ul[@class='docs']/li[@id='doc-order_statuses']");
        locators.add("//ul[@id='box-apps-menu']/li[@id='app-']/a[@href='http://localhost/litecart/admin/?app=reports&doc=monthly_sales']");
        locators.add("//ul[@id='box-apps-menu']/li[@id='app-']/a[@href='http://localhost/litecart/admin/?app=reports&doc=monthly_sales']/../ul[@class='docs']/li[@id='doc-monthly_sales']");
        locators.add("//ul[@id='box-apps-menu']/li[@id='app-']/a[@href='http://localhost/litecart/admin/?app=reports&doc=monthly_sales']/../ul[@class='docs']/li[@id='doc-most_sold_products']");
        locators.add("//ul[@id='box-apps-menu']/li[@id='app-']/a[@href='http://localhost/litecart/admin/?app=reports&doc=monthly_sales']/../ul[@class='docs']/li[@id='doc-most_shopping_customers']");
        locators.add("//ul[@id='box-apps-menu']/li[@id='app-']/a[@href='http://localhost/litecart/admin/?app=settings&doc=store_info']");
        locators.add("//ul[@id='box-apps-menu']/li[@id='app-']/a[@href='http://localhost/litecart/admin/?app=settings&doc=store_info']/../ul[@class='docs']/li[@id='doc-store_info']");
        locators.add("//ul[@id='box-apps-menu']/li[@id='app-']/a[@href='http://localhost/litecart/admin/?app=settings&doc=store_info']/../ul[@class='docs']/li[@id='doc-defaults']");
        locators.add("//ul[@id='box-apps-menu']/li[@id='app-']/a[@href='http://localhost/litecart/admin/?app=settings&doc=store_info']/../ul[@class='docs']/li[@id='doc-general']");
        locators.add("//ul[@id='box-apps-menu']/li[@id='app-']/a[@href='http://localhost/litecart/admin/?app=settings&doc=store_info']/../ul[@class='docs']/li[@id='doc-listings']");
        locators.add("//ul[@id='box-apps-menu']/li[@id='app-']/a[@href='http://localhost/litecart/admin/?app=settings&doc=store_info']/../ul[@class='docs']/li[@id='doc-images']");
        locators.add("//ul[@id='box-apps-menu']/li[@id='app-']/a[@href='http://localhost/litecart/admin/?app=settings&doc=store_info']/../ul[@class='docs']/li[@id='doc-checkout']");
        locators.add("//ul[@id='box-apps-menu']/li[@id='app-']/a[@href='http://localhost/litecart/admin/?app=settings&doc=store_info']/../ul[@class='docs']/li[@id='doc-advanced']");
        locators.add("//ul[@id='box-apps-menu']/li[@id='app-']/a[@href='http://localhost/litecart/admin/?app=settings&doc=store_info']/../ul[@class='docs']/li[@id='doc-security']");
        locators.add("//ul[@id='box-apps-menu']/li[@id='app-']/a[@href='http://localhost/litecart/admin/?app=slides&doc=slides']");
        locators.add("//ul[@id='box-apps-menu']/li[@id='app-']/a[@href='http://localhost/litecart/admin/?app=tax&doc=tax_classes']");
        locators.add("//ul[@id='box-apps-menu']/li[@id='app-']/a[@href='http://localhost/litecart/admin/?app=tax&doc=tax_classes']/../ul[@class='docs']/li[@id='doc-tax_classes']");
        locators.add("//ul[@id='box-apps-menu']/li[@id='app-']/a[@href='http://localhost/litecart/admin/?app=tax&doc=tax_classes']/../ul[@class='docs']/li[@id='doc-tax_rates']");
        locators.add("//ul[@id='box-apps-menu']/li[@id='app-']/a[@href='http://localhost/litecart/admin/?app=translations&doc=search']");
        locators.add("//ul[@id='box-apps-menu']/li[@id='app-']/a[@href='http://localhost/litecart/admin/?app=translations&doc=search']/../ul[@class='docs']/li[@id='doc-search']");
        locators.add("//ul[@id='box-apps-menu']/li[@id='app-']/a[@href='http://localhost/litecart/admin/?app=translations&doc=search']/../ul[@class='docs']/li[@id='doc-scan']");
        locators.add("//ul[@id='box-apps-menu']/li[@id='app-']/a[@href='http://localhost/litecart/admin/?app=translations&doc=search']/../ul[@class='docs']/li[@id='doc-csv']");
        locators.add("//ul[@id='box-apps-menu']/li[@id='app-']/a[@href='http://localhost/litecart/admin/?app=users&doc=users']");
        locators.add("//ul[@id='box-apps-menu']/li[@id='app-']/a[@href='http://localhost/litecart/admin/?app=vqmods&doc=vqmods']");
        locators.add("//ul[@id='box-apps-menu']/li[@id='app-']/a[@href='http://localhost/litecart/admin/?app=vqmods&doc=vqmods']/../ul[@class='docs']/li[@id='doc-vqmods']");
    }

    @After
    public void stop() {
        driver.quit();
        driver = null;
    }
}
