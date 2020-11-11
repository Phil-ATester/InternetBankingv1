package com.InternetBanking.testCases;

import com.InternetBanking.pageObject.LoginPage;
import com.InternetBanking.pageObject.NewCustomerPage;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class TC_AddCustomer_003 extends BaseClass {

    @Test
    public void addCustomerTest() throws IOException {

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

        //Add Customer
        NewCustomerPage customerPage = new NewCustomerPage(driver);
        customerPage.clickAddNewCustomer();

        logger.info("Add Customer Details");
        customerPage.customerName("Brian");
        customerPage.customerGender("male");
        customerPage.customerdob("04","15","1936");

        driver.manage().timeouts().pageLoadTimeout(3000, TimeUnit.SECONDS);

        customerPage.customerAddress("UK");
        customerPage.custcity("LDN");
        customerPage.custstate("PP");
        customerPage.custpinno("5466735");
        customerPage.custtelephoneno("34544564565463");

        String email = randomString() + "@Gmail.com";
        customerPage.custemailid(email);
        customerPage.custpassword(randomString());
        logger.info("Click Submit Button");
        customerPage.custsubmit();

        driver.manage().timeouts().pageLoadTimeout(3000, TimeUnit.SECONDS);


        logger.info("Validating Page");
        // Confirm is add customer is successfully
        Boolean expectPage = driver.getPageSource().contains("Customer Registered Successfully!!!");
        System.out.println("Expected Result: "+ expectPage);

        if (expectPage == true){
            Assert.assertTrue(true);
            logger.info("Add New Customer Test Case Passed");
        }else{
            logger.info("Add New Customer Test Case Failed");
            captureScreen(driver, "AddNewCustomer");
            Assert.assertTrue(false);
        }
    }

    /*
    public String randomString(){
        return RandomStringUtils.randomAlphabetic(8);
    }*/

}
