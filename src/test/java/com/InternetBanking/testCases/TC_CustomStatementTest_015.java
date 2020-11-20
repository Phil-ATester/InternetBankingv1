package com.InternetBanking.testCases;

import com.InternetBanking.pageObject.CustomisedStatementPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_CustomStatementTest_015 extends BaseClass {

    @Test
    public void TestCustomStatement(){

        login();

        CustomisedStatementPage customPage = new CustomisedStatementPage(driver);
        customPage.clickCustomisedStatementLink();

        String accountNo = "87413";
        customPage.setTxtAccountNo(accountNo);
        customPage.setFromDate("17", "11", "2020");
        customPage.setToDate("20", "11","2020");
        customPage.setTxtTransactionValue("100");
        customPage.setTxtNumberOfTransaction("2");

        if (driver.getPageSource().contains("Transaction Details for Account No: " + accountNo)){
            Assert.assertTrue(true);
        }else{
            Assert.assertTrue(false);
            logger.info("Custom Statement Test Failed");
        }


    }

}
