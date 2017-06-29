package com.selenium.education.task19.app;

import com.selenium.education.task19.exception.Task19Exception;
import com.selenium.education.task19.pages.CartPage;
import com.selenium.education.task19.pages.GoodsPage;
import com.selenium.education.task19.pages.SelectPage;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Created by kormichael on 29.06.2017.
 */
public class Application {
    private WebDriver driver;
    private SelectPage selectPage;
    private GoodsPage goodsPage;
    private CartPage cartPage;

    public Application () {
        driver = new ChromeDriver();
        selectPage = new SelectPage(driver);
        goodsPage = new GoodsPage(driver);
        cartPage = new CartPage(driver);
    }

    public void selectGooodsForCart() throws Exception {
        try {
            selectPage.open();
            selectPage.selectGoods(1);
        } catch (Task19Exception e) {
            throw new Exception(e.getMessage());
        }
    }
    public void addSelectedGoodsToCart () throws Exception {
        try {
            goodsPage.addGoodsToCart();
        } catch (Task19Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public boolean removeGoodsFromCart () throws Exception {
        try {
            cartPage.open();
            return cartPage.removeGoods();
        } catch (Task19Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public void quit () {
        driver.quit();
        driver = null;
    }

}
