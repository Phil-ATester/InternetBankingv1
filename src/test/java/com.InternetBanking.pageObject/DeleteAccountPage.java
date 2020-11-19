package com.InternetBanking.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DeleteAccountPage {

    private WebDriver driver;
    private By deleteAccountLink = By.xpath("//*[@href='deleteAccountInput.php']");
    private By accountNum = By.xpath("//input[@name='accountno']");
    private By submitButton = By.xpath("//input[@name='AccSubmit']");

    public DeleteAccountPage(WebDriver driver) {
        this.driver = driver;
    }

    public void selectDeleteAccount(){
        driver.findElement(deleteAccountLink).click();
    }

    public void setAccountNo(String num){
        driver.findElement(accountNum).sendKeys(num);
    }

    public void selectSubmitButton(){
        driver.findElement(submitButton).click();
    }

}
