package com.InternetBanking.testCases;

import com.InternetBanking.pageObject.DepositPage;
import com.InternetBanking.pageObject.LoginPage;
import com.InternetBanking.pageObject.WithDrawPage;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.AssertJUnit.assertTrue;

public class TC_WithdrawTest_010 extends BaseClass{

    @Test
    public void TestWithdraw_001(){

        LoginPage loginPage = new LoginPage(driver);
        loginPage.setUserName(userName);
        loginPage.setPassword(passWord);
        loginPage.clickSubmitButton();

        WithDrawPage withDrawPage = new WithDrawPage(driver);
        withDrawPage.clickWithdrawLink();
        driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);

        String amount = "100";
        withDrawPage.setTxtAccountNo("87313");
        withDrawPage.setTxtAccountAmount(amount);
        withDrawPage.setTxtDescription("WTest");
        withDrawPage.clickSubmitButton();

        if (withDrawPage.getAmountDebited().equals(amount)){
            System.out.println("Amount Debit: " + withDrawPage.getAmountDebited());
            assertTrue(true);
            logger.info("deposit test passed");
        }else{
            assertTrue(false);
            logger.info("deposit test failed");
        }


    }
}
