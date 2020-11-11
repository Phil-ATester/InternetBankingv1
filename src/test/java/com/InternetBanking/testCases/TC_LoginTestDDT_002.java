package com.InternetBanking.testCases;

import com.InternetBanking.pageObject.LoginPage;
import com.InternetBanking.utilities.XLUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;


public class TC_LoginTestDDT_002 extends BaseClass{
    // DDT Tests

    @Test (dataProvider = "LoginData")
    public void loginDDT(String userName, String passWord) throws IOException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.setUserName(userName);
        logger.info("user name provided");
        loginPage.setPassword(passWord);
        logger.info("password provided");
        loginPage.clickSubmitButton();

        if (isAlertPresent() == true){
            driver.switchTo().alert().accept();  // close alert
            driver.switchTo().defaultContent();
            // captureScreen(driver, "LoginTestDTT_002");
            Assert.assertTrue(false);
            logger.warn("Login Failed");
        }else{
            Assert.assertTrue(true);
            logger.warn("Login Passed");
            // click logout on homepage;
            //driver.findElement(By.xpath("/html/body/div[3]/div/ul/li[15]/a"));
            //driver.findElement(By.className("a[href='Logout']"));
            driver.findElement(By.cssSelector("a:contains('Logout')"));

            driver.switchTo().alert().accept(); // close logout alert on homepage
            driver.switchTo().defaultContent();
        }
    }

    @DataProvider(name="LoginData")
    public Object[][] getData() throws IOException {
        //String path = "com.InternetBanking.testData/LoginData.xlsx";
        String path = "./src/test/java/com.InternetBanking.testData/LoginData.xlsx";

        int rows = XLUtils.getRowCount(path, "Sheet1");
        int cols = XLUtils.getCellCount(path, "Sheet1",1);

        String[][] loginData =  new String[rows][cols];

        for (int i=1; i<=rows; i++){
            for (int j=0; j<cols; j++){
                loginData[i-1][j] = XLUtils.getCellData(path,"Sheet1", i, j);
            }
        }

        return loginData;
    }

    /*
    public boolean isAlertPresent(){
        try {
            driver.switchTo().alert();
            return true;
        }catch (NoAlertPresentException e){
            return false;
        }
    }*/
}
