package com.selenium.education.task19.pages;

import com.selenium.education.task19.exception.Task19Exception;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;
import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.numberOfElementsToBe;

/**
 * Created by kormichael on 29.06.2017.
 */
public class CartPage extends Page {
    @FindBy(xpath = "//button[@name='remove_cart_item']")
    List<WebElement> removeButtons;

    @FindBy(xpath = "//table[@class='dataTable rounded-corners']/*/tr")
    List<WebElement> rowsElements;

    public CartPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void open() throws Task19Exception {
        try {
            driver.get("http://localhost/litecart/en/checkout");
        } catch (Exception e) {
            throw new Task19Exception(e.getMessage());
        }
    }

    public boolean removeGoods () throws Exception {
        int trCount = 0;
        try {
            trCount = driver.findElements(By.xpath("//table[@class='dataTable rounded-corners']/*/tr")).size();
            removeButtons.get(0).click();
            try {
                wait.until(numberOfElementsToBe(By.xpath("//table[@class='dataTable rounded-corners']/*/tr"),trCount -1));
            } catch (Exception e) {
                //Все товары удалили, таблица на странице не найдена.
                return false;
            }
            if (removeButtons.size() > 0) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            throw new Task19Exception(e.getMessage());
        }

    }
    public List<WebElement> getRemoveButtons() {
        return removeButtons;
    }

    public void setRemoveButtons(List<WebElement> removeButtons) {
        this.removeButtons = removeButtons;
    }

}
