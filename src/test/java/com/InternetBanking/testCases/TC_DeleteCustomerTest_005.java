package com.InternetBanking.testCases;

import com.InternetBanking.pageObject.DeleteCustomerPage;
import com.InternetBanking.pageObject.LoginPage;
import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class TC_DeleteCustomerTest_005 extends BaseClass {

    @Test
    public void DeleteCustomerTest() throws IOException, InterruptedException {

        //Login
        logger.info("addCustomerTest_003");
        logger.info("URL is opened");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.setUserName(userName);
        logger.info("Enter Username");
        loginPage.setPassword(passWord);
        logger.info("Enter Password");
        loginPage.clickSubmitButton();
        logger.info("Clicked Login Button");

        //Enter customer ID
        logger.info("Enter Customer ID");
        DeleteCustomerPage deleteCustomerPage = new DeleteCustomerPage(driver);
        deleteCustomerPage.selectDeleteCustomer();
        deleteCustomerPage.enterCustomerID("57437");
        deleteCustomerPage.clickIdSubmitBTN();

        //Confirm delete
        driver.switchTo().alert().accept();
        logger.info("Confirm delete");
        Thread.sleep(3000);

        //Item deleted message
        Alert alert = driver.switchTo().alert();
        String message = "Customer deleted Successfully";
        String alertMessage = driver.switchTo().alert().getText();

        //System.out.println("ERROR: (ALERT BOX DETECTED) - ALERT MSG : " + alertText);
        //alert.accept();

       // captureScreen(driver, "Delete Test 001");
        System.out.println(alertMessage);

        if (alertMessage == message){
            Assert.assertTrue(true);
            alert.accept();
            logger.info("Delete Customer Test Case Passed");
        }else {
            logger.info("Delete Customer Test Case Failed");
            captureScreen(driver, "DeleteCustomerTest");
            Assert.assertTrue(false);
        }

    }
}
