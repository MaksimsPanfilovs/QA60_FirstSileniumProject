package com.demowebshop.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateAccountTests extends TestBase {

    @Test
    public void newUserRegistrationPositiveTest() {
        int i = (int) ((System.currentTimeMillis() / 1000) % 3600);

        clickOnRegistrationLink();
        fillRegistrationForm(new User().setGender("male")
                .setFirstname("Sven").setLastname("Fisher")
                .setEmail("Sfischer" + i + "@gmail.com")
                .setPassword("Qwerty1!"));
        clickOnRegistrationButton();
        clickOnConfirmButton();

        Assert.assertTrue(isLogOutLinkPresent());
    }


    @Test
    public void newUserRegistrationNegativeTest() {
        clickOnRegistrationLink();
        fillRegistrationForm(new User().setGender("male")
                .setFirstname("Sven").setLastname("Fisher")
                .setEmail("Sfischer@gmail.com").setPassword("Qwerty1!"));
        clickOnRegistrationButton();

        Assert.assertTrue(isErrorMessagePresent());
    }


}
