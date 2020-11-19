package com.InternetBanking.testCases;

import com.InternetBanking.pageObject.EditAccountPage;
import com.InternetBanking.pageObject.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class TC_EditAccount_007 extends BaseClass{


    @Test
    public void testEditAccount() throws IOException {

        logger.info("addEditAccount_007");
        logger.info("URL is opened");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.setUserName(userName);
        logger.info("Enter Username");
        loginPage.setPassword(passWord);
        logger.info("Enter Password");
        loginPage.clickSubmitButton();
        logger.info("Clicked Login Button");

        logger.info("Select Edit Account");
        EditAccountPage editAccountPage = new EditAccountPage(driver);
        editAccountPage.selectEditAccount();
        logger.info("Entering Account Number");
        editAccountPage.enterAccountNum("87288");
        editAccountPage.selectSubmitButton();
        logger.info("Selecting Saving Account");
        editAccountPage.selectAccountType("Savings");
        logger.info("Clicking Submit");
        editAccountPage.selectSubmitButton();

        logger.info("Validating Page");
        Boolean expectPage = driver.getPageSource().contains("Account details updated Successfully!!!");
        System.out.println("Expected Result: "+ expectPage);

        if (expectPage == true){
            Assert.assertTrue(true);
            logger.info("Edit Account Test Case Passed");
        }else{
            logger.info("Edit Account Test Case Failed");
            captureScreen(driver, "EditAccountTest_007");
            Assert.assertTrue(false);
        }
    }
}
