package com.InternetBanking.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class EditCustomerPage {

    private WebDriver driver;

    private By customerIDField = By.xpath("//input[@name='cusid']");
    private By submitButton = By.xpath("//input[@name='AccSubmit']");

    private By addressField = By.xpath("//textarea[@name='addr']");
    private By cityField = By.xpath("//input[@name='city']");
    private By stateField = By.xpath("//input[@name='state']");
    private By pinField = By.xpath("//input[@name='pinno']");
    private By telephoneNoField = By.xpath("//input[@name='telephoneno']");
    private By emailField = By.xpath("//input[@name='emailid']");
    private By passwordField = By.xpath("//input[@name='password']");
    private By resetButton = By.xpath("//input[@name='res']");
    private By submitButton2 = By.xpath("//input[@name='sub']");

    private By editCustomerLink = By.xpath("//a[contains(@href, 'EditCustomer')]");

    public EditCustomerPage(WebDriver driver){
        this.driver = driver;
    }

    public void selectEditCustomer(){
        driver.findElement(editCustomerLink).click();
    }

    public void setCustomerIDField (String id){
        driver.findElement(customerIDField).sendKeys(id);
    }

    public void clickSubmitButton (){
        driver.findElement(submitButton).click();
    }

    public void editAddress (String newAddress){
        driver.findElement(addressField).clear();
        driver.findElement(addressField).sendKeys(newAddress);
    }

    public void editCity (String newCity){
        driver.findElement(cityField).clear();
        driver.findElement(cityField).sendKeys(newCity);
    }

    public void editState (String newState){
        driver.findElement(stateField).clear();
        driver.findElement(stateField).sendKeys(newState);
    }

    public void editPIN (String newPIN){
        driver.findElement(pinField).clear();
        driver.findElement(pinField).sendKeys(String.valueOf(newPIN));
    }

    public void editMobileNo (String newNumber){
        driver.findElement(telephoneNoField).clear();
        driver.findElement(telephoneNoField).sendKeys(newNumber);
    }

    public void editEmail (String newEmail){
        driver.findElement(emailField).clear();
        driver.findElement(emailField).sendKeys(newEmail);
    }

    public void submit (){
        driver.findElement(submitButton2).click();
    }

    // get changed data
    //*[@id="customer"]/tbody/tr[11]/td[1]

}
