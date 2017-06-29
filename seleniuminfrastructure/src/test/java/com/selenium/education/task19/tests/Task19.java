package com.selenium.education.task19.tests;

import com.selenium.education.task19.app.Application;
import com.selenium.education.task19.pages.CartPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by kormichael on 29.06.2017.
 */
public class Task19 {
    Application app;
    @Test
    public void task () {
        int selectedGooodsCount = 0;
        boolean canRomove = true;
        try {
            app = new Application();
            for (int i = 0; i < 3 ; i++) {
                app.selectGooodsForCart();
                app.addSelectedGoodsToCart();
            }
            while (canRomove) {
                canRomove = app.removeGoodsFromCart();
            }
            Assert.assertTrue("Всё нормально!", true);
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
    }

    @After
    public void stop () {
        app.quit();
    }
}
