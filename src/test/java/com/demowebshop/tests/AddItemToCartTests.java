package com.demowebshop.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddItemToCartTests extends TestBase {

    @BeforeMethod
    public void precondition() {
        clickOnLoginLink();
        fillLoginForm(new User().setEmail("Sfischer@gmail.com").setPassword("Qwerty1!"));
        clickOnLoginButton();
    }

    @Test
    public void addItemToCartPositiveTest() {
        clickOnAddToCartButton();
        clickOnCartLink();
        Assert.assertTrue(isProductPresentInCart());
    }


    @AfterMethod
    public void postRCondition() {
        removeProductFromCart();
    }
}
