package com.InternetBanking.testCases;

import com.InternetBanking.pageObject.BalanceEnquiryPage;
import com.InternetBanking.pageObject.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TC_BalanceEnquiryTest_013 extends BaseClass{

    @Test
    public void TestBalanceEnquiry(){

        LoginPage loginPage = new LoginPage(driver);
        loginPage.setUserName(userName);
        loginPage.setPassword(passWord);
        loginPage.clickSubmitButton();

        BalanceEnquiryPage balanceEnquiryPage = new BalanceEnquiryPage(driver);
        balanceEnquiryPage.clickBalanceLink();

        balanceEnquiryPage.setAccountNo("87314");
        balanceEnquiryPage.clickSubmitButton();

        driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);

        boolean result = driver.getPageSource().contains("Balance Details for Account ");

        if (result == true){
            Assert.assertTrue(true);
            logger.info("Balance Enquiry Test Passed");
        }else{
            Assert.assertTrue(false);
            logger.info("Balance Enquiry test Failed");
        }

    }
}
