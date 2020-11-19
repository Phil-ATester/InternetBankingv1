package com.InternetBanking.pageObject;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BalanceEnquiryPage {

    private WebDriver driver;

    @FindBy(xpath="//*[@href='BalEnqInput.php']")
    WebElement balanceLink;

    @FindBy(name = "accountno")
    WebElement txtAccountNo;

    @FindBy(name = "AccSubmit")
    WebElement submitButton;

    public BalanceEnquiryPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickBalanceLink(){
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click();", balanceLink);
    }

    public void setAccountNo(String num){
        txtAccountNo.sendKeys(num);
    }

    public void clickSubmitButton(){
        submitButton.click();
    }


}
