package com.InternetBanking.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class NewAccountPage {

    private WebDriver driver;

    private By newAccountLink = By.xpath("//*[@href='addAccount.php']");
    private By customerIdField = By.xpath("//*[@name='cusid']");
    private By accountType  = By.xpath("//*[@name='selaccount']");
    private By initialDeposit = By.xpath("//*[@name='inideposit']");
    private By submitButton = By.xpath("//*[@name='button2']");

    public NewAccountPage(WebDriver driver){
        this.driver = driver;
    }

    public void clickAddNewAccount() {
        driver.findElement(newAccountLink).click();
    }

    public void setCustomerId(String id){
        driver.findElement(customerIdField).sendKeys(id);
    }

    public void selectAccountType(String type){
        Select objSelect = new Select(driver.findElement(accountType));
        objSelect.selectByValue(type);
    }

    public void setInitialDeposit(String amount){
        driver.findElement(initialDeposit).sendKeys(amount);
    }

    public void clickSubmit(){
        driver.findElement(submitButton).click();
    }

    public String getAccountId(){
        return driver.findElement(By.xpath("//tr[td='Account ID']//following-sibling::td[2]")).getText();
    }
}
