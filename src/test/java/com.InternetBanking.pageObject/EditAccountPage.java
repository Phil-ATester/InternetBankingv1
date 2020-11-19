package com.InternetBanking.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class EditAccountPage {

    private WebDriver driver;
    private By editAccountLink = By.xpath("//a[@href='editAccount.php']");
    private By accountNum = By.xpath("//input[@name='accountno']");
    private By submitButton = By.xpath("//*[@name='AccSubmit']");
    private By customerIdField = By.xpath("//*[@name='txtcid']");
    private By accountType  = By.xpath("//select[@name='a_type']");
    private By balance = By.xpath("//*[@name='txtinidep']");

    public EditAccountPage(WebDriver driver){
        this.driver = driver;
    }

    public void selectSubmitButton(){
        driver.findElement(submitButton).click();
    }

    public void selectAccountType(String type){
        Select objSelect = new Select(driver.findElement(accountType));
        objSelect.selectByValue(type);
    }

    public void enterAccountNum(String num){
        driver.findElement(accountNum).sendKeys(num);
    }

    public void selectEditAccount(){
        driver.findElement(editAccountLink).click();
    }

}
