package com.InternetBanking.testCases;

import com.InternetBanking.pageObject.DeleteAccountPage;
import com.InternetBanking.pageObject.LoginPage;
import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class TC_DeleteAccount_008 extends BaseClass{

    /*
    Test-Case: Delete a customer account
    Pre-condition: An account already exist for customer
     */

    @Test
    public void deleteAccountTest() throws InterruptedException, IOException {


        logger.info("DeleteAccount_008");
        logger.info("URL is opened");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.setUserName(userName);
        logger.info("Enter Username");
        loginPage.setPassword(passWord);
        logger.info("Enter Password");
        loginPage.clickSubmitButton();
        logger.info("Clicked Login Button");

        logger.info("Enter Customer ID");
        DeleteAccountPage deleteAccountPage = new DeleteAccountPage(driver);
        deleteAccountPage.selectDeleteAccount();
        driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
        deleteAccountPage.setAccountNo("87286");
        deleteAccountPage.selectSubmitButton();

        driver.switchTo().alert().accept();
        logger.info("Confirm delete");
        Thread.sleep(3000);

        Alert alert = driver.switchTo().alert();
        String message = "Account Deleted Sucessfully";
        String alertMessage = driver.switchTo().alert().getText();
        //System.out.println(alertMessage);

        if (alertMessage.equals(message)){
            Assert.assertTrue(true);
            alert.accept();
            logger.info("Delete Customer Test Case Passed");
        }else {
            logger.info("Delete Customer Test Case Failed");
            captureScreen(driver, "DeleteAccountTest_008");
            Assert.assertTrue(false);
            alert.accept();
        }


    }
}
