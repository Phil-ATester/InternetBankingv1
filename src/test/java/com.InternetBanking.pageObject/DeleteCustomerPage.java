package com.InternetBanking.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DeleteCustomerPage {

    private WebDriver driver;

    private By deleteCustomerLink = By.cssSelector("a[href='DeleteCustomerInput.php']");
    private By customerId = By.cssSelector("input[name='cusid']");
    private By idSubmitBTN = By.cssSelector("input[name='AccSubmit']");

    public DeleteCustomerPage(WebDriver driver){
        this.driver = driver;
    }

    public void selectDeleteCustomer(){
        driver.findElement(deleteCustomerLink).click();
    }

    public void enterCustomerID(String id){
        driver.findElement(customerId).sendKeys(id);
    }

    public void clickIdSubmitBTN(){
        driver.findElement(idSubmitBTN).click();
    }

}
