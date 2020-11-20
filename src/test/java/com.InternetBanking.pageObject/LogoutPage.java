package com.InternetBanking.pageObject;

import com.InternetBanking.testCases.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class LogoutPage {

    private WebDriver driver;
    private By logOut = By.xpath("//*[contains(text(),'Log out')]");

    public LogoutPage (WebDriver driver){
        this.driver = driver;
    }

    public void clickLogout(){
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click();", driver.findElement(logOut));
    }

}
