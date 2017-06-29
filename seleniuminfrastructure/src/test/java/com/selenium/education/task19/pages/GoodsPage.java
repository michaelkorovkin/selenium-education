package com.selenium.education.task19.pages;

import com.selenium.education.task19.exception.Task19Exception;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.not;
import static org.openqa.selenium.support.ui.ExpectedConditions.textToBePresentInElement;
import static org.openqa.selenium.support.ui.ExpectedConditions.textToBePresentInElementValue;

/**
 * Created by kormichael on 29.06.2017.
 */
public class GoodsPage extends Page  {
    @FindBy (name = "add_cart_product")
    private WebElement addButton;
    @FindBy(xpath = "//i[@title='Home']")
    private WebElement homeButton;
    @FindBy(xpath = "//span[@class='quantity']")
    private WebElement cartGooodsCount;
    @FindBy(xpath = "//select[@name='options[Size]']")
    private WebElement select;
    public GoodsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void addGoodsToCart () throws Task19Exception {
        String goodsCount;
        Select select;
        try {
            goodsCount = cartGooodsCount.getText();
            try {
                select = new Select(driver.findElement(By.xpath("//select[@name='options[Size]']")));
            } catch (Exception e) {
                select = null;
            }
            if (select != null) {
                select.selectByIndex(1);
            }
            addButton.click();
            wait.until(not (textToBePresentInElement(cartGooodsCount, goodsCount)));
            homeButton.click();
        } catch (Exception e) {
            throw new Task19Exception(e.getMessage());
        }
    }

    public WebElement getAddButton() {
        return addButton;
    }

    public void setAddButton(WebElement addButton) {
        this.addButton = addButton;
    }

}
