package com.InternetBanking.testCases;

import com.InternetBanking.pageObject.LoginPage;
import com.InternetBanking.pageObject.LogoutPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_LogoutTest_016 extends BaseClass{

    @Test
    public void TestLogOut(){

        LoginPage loginPage = new LoginPage(driver);
        loginPage.setUserName(userName);
        loginPage.setPassword(passWord);
        loginPage.clickSubmitButton();

        LogoutPage logoutPage = new LogoutPage(driver);
        logoutPage.clickLogout();

        driver.switchTo().alert();

        if (driver.switchTo().alert().getText().contains("You Have Succesfully Logged Out!!")){
            Assert.assertTrue(true);
        }else{
            Assert.assertTrue(false);
            logger.info(false);
        }

    }

}
