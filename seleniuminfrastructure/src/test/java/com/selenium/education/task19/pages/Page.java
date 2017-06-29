package com.selenium.education.task19.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by kormichael on 29.06.2017.
 */
public class Page {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected  Actions actions;

    public Page(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
        actions = new Actions(driver);
    }
}
