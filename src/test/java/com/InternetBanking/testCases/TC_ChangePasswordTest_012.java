package com.InternetBanking.testCases;

import com.InternetBanking.pageObject.ChangePasswordPage;
import com.InternetBanking.pageObject.LoginPage;
import com.InternetBanking.pageObject.WithDrawPage;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TC_ChangePasswordTest_012 extends BaseClass{


    @Test
    public void TestChangePassword(){
        userName = "mngr295524";
        passWord = "test@01";
        String newPassword = "test@02";

        LoginPage loginPage = new LoginPage(driver);
        loginPage.setUserName(userName);
        loginPage.setPassword(passWord);
        loginPage.clickSubmitButton();

        ChangePasswordPage changePasswordPage = new ChangePasswordPage(driver);
        changePasswordPage.clickChangePassword();
        driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
        changePasswordPage.setTxtOldPassword(passWord);
        changePasswordPage.setTxtNewPassword(newPassword);
        changePasswordPage.setTxtConfirmPassword(newPassword);
        changePasswordPage.clickSubmitButton();

        if (driver.switchTo().alert().getText().equals("Password is Changed")){
            driver.switchTo().alert().accept();
            logger.info("Change Password Passed");
        }else {
            logger.info("Change Password Failed");
        }




    }
}
