package com.InternetBanking.pageObject;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ChangePasswordPage {

    private WebDriver driver;

    @FindBy(css="a[href='PasswordInput.php']")
    WebElement linkChangePassword;

    @FindBy(css="input[name='oldpassword']")
    WebElement txtOldPassword;

    @FindBy(css="input[name='newpassword']")
    WebElement txtNewPassword;

    @FindBy(css="input[name='confirmpassword']")
    WebElement txtConfirmPassword;

    @FindBy(css="input[name='sub']")
    WebElement submitButton;


    public ChangePasswordPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickChangePassword(){
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click();", linkChangePassword);
    }

    public void setTxtOldPassword(String oldPassword){
        txtOldPassword.sendKeys(oldPassword);
    }

    public void setTxtNewPassword(String newPassword){
        txtNewPassword.sendKeys(newPassword);
    }

    public void setTxtConfirmPassword(String confirmPassword){
        txtConfirmPassword.sendKeys(confirmPassword);
    }

    public void clickSubmitButton(){
        submitButton.click();
    }

}
