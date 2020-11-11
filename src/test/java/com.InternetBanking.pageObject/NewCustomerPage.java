package com.InternetBanking.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.logging.Handler;

public class NewCustomerPage {

    WebDriver driver;
    @FindBy (how = How.XPATH, using = "//a[@href='addcustomerpage.php']")
    WebElement NewCustomerLink; //a[@href="addcustomerpage.php"]

    @FindBy (how = How.XPATH, using = "//input[@name='name']") WebElement name;

    @FindBy (how = How.NAME, using = "rad1") WebElement gender;

    @FindBy (how = How.ID, using = "dob") WebElement dob;

    @FindBy (how = How.NAME, using = "addr") WebElement address;

    @FindBy (how = How.NAME, using = "city") WebElement city;

    @FindBy (how = How.XPATH, using = "//input[@name='state']") WebElement state;

    @FindBy (how = How.NAME, using ="pinno") WebElement pin;

    @FindBy (how = How.NAME, using ="telephoneno") WebElement mobileNo;

    @FindBy (how = How.NAME, using ="emailid") WebElement email;

    @FindBy (how = How.NAME, using="password") WebElement password;

    @FindBy (how = How.NAME, using="sub") WebElement submitButton;
    @FindBy (how = How.NAME, using="res") WebElement resetButton;

    private WebDriverWait wait;
    private static final int TIMEOUT = 5;
    private static final int POLLING = 100;

    public NewCustomerPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, TIMEOUT, POLLING);
    }

    public void clickAddNewCustomer() {
        NewCustomerLink.click();
    }

    /*
    //Wait Wrapper Method
    public void waitVisibilityOfElement(By elementBy) {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(elementBy));
    }

    //Write Text
    public void writeText (By elementBy, String text) {
        waitVisibilityOfElement(elementBy);
        driver.findElement(elementBy).clear();
        driver.findElement(elementBy).sendKeys(text);
    }*/

    public void customerName(String custName){
        name.sendKeys(custName);
    }

    public void customerGender (String cgender){
        gender.click();
    }

    public void customerdob (String mm, String dd, String yyyy){
        dob.sendKeys(mm);
        dob.sendKeys(dd);
        dob.sendKeys(yyyy);
    }

    public void customerAddress (String addr){
        address.sendKeys(addr);
    }

    public void custcity(String ccity) {
        city.sendKeys(ccity);
    }

    public void custstate(String cstate) {
        state.sendKeys(cstate);
    }

    public void custpinno(String cpinno) {
        pin.sendKeys(String.valueOf(cpinno));
    }

    public void custtelephoneno(String ctelephoneno) {
        mobileNo.sendKeys(ctelephoneno);
    }

    public void custemailid(String cemailid) {
        email.sendKeys(cemailid);
    }

    public void custpassword(String cpassword) {
        password.sendKeys(cpassword);
    }

    public void custsubmit() {
        submitButton.click();
    }

}
