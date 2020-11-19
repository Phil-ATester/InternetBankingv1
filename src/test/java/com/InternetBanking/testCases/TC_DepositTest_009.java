package com.InternetBanking.testCases;

import com.InternetBanking.pageObject.DepositPage;
import com.InternetBanking.pageObject.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.AssertJUnit.assertTrue;

public class TC_DepositTest_009 extends BaseClass {

    @Test
    public void depositTest_001() {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.setUserName(userName);
        loginPage.setPassword(passWord);
        loginPage.clickSubmitButton();

        DepositPage depositPage = new DepositPage(driver);
        depositPage.clickDepositLink();
        driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);

        String amount = "1000";
        depositPage.setTxtAccountNo("87313");
        depositPage.setTxtAccountAmount(amount);
        depositPage.setTxtDescription("Deposit");
        depositPage.clickSubmitButton();

        if (depositPage.getAmountCredit().equals(amount)){
            System.out.println("Credit Amount: " + depositPage.getAmountCredit());
            assertTrue(true);
            logger.info("deposit test passed");
        }else{
            assertTrue(false);
            logger.info("deposit test failed");
        }


    }
}
