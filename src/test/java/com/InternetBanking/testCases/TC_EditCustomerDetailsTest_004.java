package com.InternetBanking.testCases;

import com.InternetBanking.pageObject.EditCustomerPage;
import com.InternetBanking.pageObject.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class TC_EditCustomerDetailsTest_004 extends BaseClass{

    @Test
    public void EditCustomerDetailsTests() throws IOException {

        // Login
        logger.info("EditCustomerDetail_004");
        logger.info("URL is opened");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.setUserName(userName);
        logger.info("Enter Username");
        loginPage.setPassword(passWord);
        logger.info("Enter Password");
        loginPage.clickSubmitButton();
        logger.info("Clicked Login Button");

        // Select edit customer
        logger.info("Select Edit Customer details");
        EditCustomerPage editCustomerPage = new EditCustomerPage(driver);
        editCustomerPage.selectEditCustomer();

        // Enter customer Id
        editCustomerPage.setCustomerIDField("66087");
        editCustomerPage.clickSubmitButton();

        // Edit Customer Detail
        logger.info("Editing Customer details");
        editCustomerPage.editAddress("USA");
        editCustomerPage.editCity("SDG");
        editCustomerPage.editState("AA");
        editCustomerPage.editPIN("234556");
        editCustomerPage.editMobileNo(randomNumber());
        String email = randomString() + "@Gmail.com";
        editCustomerPage.editEmail(email);
        logger.info("Clicking Submit Button");
        editCustomerPage.submit();

        // Verify edit was successful
        logger.info("Verifying Edit");

        Boolean resultPage = driver.getPageSource().contains("Customer details updated Successfully!!!");

        if (resultPage== true){
            Assert.assertTrue(true);
            logger.info("Edit Customer Test Case Passed");
        }else{
            logger.info("Edit Customer Test Case Failed");
            captureScreen(driver, "EditCustomer");
            Assert.assertTrue(false);
        }
    }
}
