package com.demowebshop.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {

    @Test
    public void userLoginPositiveTest() {
        clickOnLoginLink();
        fillLoginForm(new User().setEmail("Sfischer@gmail.com").setPassword("Qwerty1!"));
        clickOnLoginButton();

        Assert.assertTrue(isLogOutLinkPresent());

    }

    @Test
    public void userLoginNegativeTest() {
        clickOnLoginLink();
        fillLoginForm(new User().setPassword("Qwerty1!"));
        clickOnLoginButton();

        Assert.assertTrue(isLogErrorMessagePresent());

    }


}
