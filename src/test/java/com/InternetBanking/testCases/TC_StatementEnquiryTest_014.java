package com.InternetBanking.testCases;

import com.InternetBanking.pageObject.LoginPage;
import com.InternetBanking.pageObject.StatementPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_StatementEnquiryTest_014 extends BaseClass{

    @Test
    public void testStatementEnquiry() {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.setUserName(userName);
        loginPage.setPassword(passWord);
        loginPage.clickSubmitButton();

        String accountNo = "87413";
        StatementPage statementPage = new StatementPage(driver);
        statementPage.clickStatementLink();
        statementPage.setAccountNumber(accountNo);
        statementPage.clickSubmit();

        if (driver.getPageSource().contains("Last Five Transaction Details for Account No: " + accountNo)) {
            Assert.assertTrue(true);
            logger.info("Statement Test Passed");
        }else{
            Assert.assertTrue(false);
            logger.info("Statement Test Failed");
        }
    }
}
