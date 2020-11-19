package com.InternetBanking.testCases;

import com.InternetBanking.pageObject.FundTransferPage;
import com.InternetBanking.pageObject.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TC_TransferFundTest_011 extends BaseClass{

    @Test
    public void TestTransferFunds(){

        LoginPage loginPage = new LoginPage(driver);
        loginPage.setUserName(userName);
        loginPage.setPassword(passWord);
        loginPage.clickSubmitButton();

        FundTransferPage fundTransferPage = new FundTransferPage(driver);
        fundTransferPage.clickFundTransferLink();

        driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);

        fundTransferPage.setPayerAccountNo("87338");
        fundTransferPage.setPayeeAccountNo("87337");
        fundTransferPage.setFundAmount("100");
        fundTransferPage.setFundDesciption("Test");
        fundTransferPage.clickSubmitButton();

        if (driver.getPageSource().contains("Fund Transfer Details")) {
            Assert.assertEquals(fundTransferPage.getPayerAccNo(), "87338");
            Assert.assertEquals(fundTransferPage.getPayeeAccNo(), "87337");
            Assert.assertEquals(fundTransferPage.getAmountTransfer(), "100");
            logger.info("Transfer Test Passed");
        }else{
            logger.info("Transfer Failed !!!");
        }

    }
}
