package com.InternetBanking.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    WebDriver driver;
    @FindBy(name="uid")
    WebElement txtUserName;

    @FindBy(name="password")
    WebElement txtPassword;

    @FindBy(name="btnLogin")
    WebElement btnLogin;

    public LoginPage (WebDriver remoteDriver){
        this.driver = remoteDriver;
        PageFactory.initElements(remoteDriver, this);
    }

    public void setUserName(String userName){
        txtUserName.sendKeys(userName);
    }

    public void setPassword(String pWord){
        txtPassword.sendKeys(pWord);
    }

    public void clickSubmitButton(){
        btnLogin.click();
    }

}
