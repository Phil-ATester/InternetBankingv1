package com.InternetBanking.testCases;

import com.InternetBanking.pageObject.LoginPage;
import com.InternetBanking.pageObject.NewAccountPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class TC_AddAccount_006 extends BaseClass{

    @Test
    public void testAddAccount() throws IOException {

        logger.info("addCustomerTest_003");
        logger.info("URL is opened");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.setUserName(userName);
        logger.info("Enter Username");
        loginPage.setPassword(passWord);
        logger.info("Enter Password");
        loginPage.clickSubmitButton();
        logger.info("Clicked Login Button");

        NewAccountPage accountPage = new NewAccountPage(driver);
        accountPage.clickAddNewAccount();

        logger.info("Add Account Details");
        accountPage.setCustomerId("99406");
        accountPage.selectAccountType("Current");
        accountPage.setInitialDeposit("2000");
        logger.info("Click Submit Button");
        accountPage.clickSubmit();

        logger.info("Validating Page");
        Boolean expectPage = driver.getPageSource().contains("Account Generated Successfully!!!");
        //System.out.println("Expected Result: "+ expectPage);

        if (expectPage == true){
            Assert.assertTrue(true);
            logger.info("Add New Account Test Case Passed");
        }else{
            logger.info("Add New Account Test Case Failed");
            captureScreen(driver, "AddNewAccount");
            Assert.assertTrue(false);
        }

        //driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);

        System.out.println("Account ID: " + accountPage.getAccountId());

    }

    public void printToTXT(){
        String info = "Collected Account Details";

        String accountID = "//tr[td='Account ID']//following-sibling::td[1]";

        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("DD-MM-yyyy HH-mm") ;

        // Wait for the element to be available
        new WebDriverWait(driver,10).until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath(accountID)));

        Writer writer = null;

        // Find the value and write it to the text file 'NewAccount_006 DD-MM-yyyy HH-mm.txt'
        try {
            writer = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream("NewAccount_004 " + dateFormat.format(date) + ".txt"), "utf-8"));
            writer.write("Account Details: " + driver.findElement
                    (By.xpath(accountID))
                    .getText());

        } catch (IOException ex) {
            // report
        } finally {
            try {
                writer.close();
            } catch (Exception ex) {
                ex.printStackTrace();
                System.out.println(ex.getLocalizedMessage());
            }
        }
    }
}
