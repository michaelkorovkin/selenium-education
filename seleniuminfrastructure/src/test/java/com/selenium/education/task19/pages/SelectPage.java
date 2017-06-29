package com.selenium.education.task19.pages;

import com.selenium.education.task19.exception.Task19Exception;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;
import java.util.List;

/**
 * Created by kormichael on 29.06.2017.
 */
public class SelectPage extends Page {
    @FindBy(xpath = "//div[@id='box-most-popular']/*/ul[@class='listing-wrapper products']/li")
    private List<WebElement> goodsList;


    public SelectPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        actions = new Actions(driver);
    }

    public void open() throws Task19Exception {
        try {
            driver.get("http://localhost/litecart/en/");
        } catch (Exception e) {
            throw new Task19Exception(e.getMessage());
        }
    }

    public void selectGoods (int goodsNumber) throws Task19Exception {
        if (goodsNumber > goodsList.size()) {
            throw new Task19Exception("Выбранного товара не существует в магазине");
        }
        goodsList.get(1).click();
        actions.pause(Duration.ofSeconds(1)).perform();
    }

    public List<WebElement> getGoodsList() {
        return goodsList;
    }

    public void setGoodsList(List<WebElement> goodsList) {
        this.goodsList = goodsList;
    }

}
