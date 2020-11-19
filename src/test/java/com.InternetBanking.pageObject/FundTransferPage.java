package com.InternetBanking.pageObject;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FundTransferPage {

    private WebDriver driver;

    @FindBy(xpath = "//a[@href='FundTransInput.php']")
    WebElement fundTransferLink;

    @FindBy (css="input[name='payersaccount']")
    WebElement txtPayerAccountNo;

    @FindBy (css="input[name='payeeaccount']")
    WebElement txtPayeeAccountNo;

    @FindBy (css="input[name='ammount']")
    WebElement txtAmount;

    @FindBy (css="input[name='desc']")
    WebElement txtDescription;

    @FindBy(name="AccSubmit")
    WebElement submitButton;

    @FindBy(xpath="//tr[td='From Account Number']//following-sibling::td[2]")
    WebElement tbAccountNo;

    @FindBy(xpath="//tr[td='To Account Number']//following-sibling::td[2]")
    WebElement tbToAccountNo;

    @FindBy(xpath="//tr[td='Amount']//following-sibling::td[2]")
    WebElement tbAmountValue;

    public FundTransferPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickFundTransferLink(){
        //fundTransferLink.click();
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click();", fundTransferLink);
    }

    public void setPayeeAccountNo(String payeeAccountNo){
        txtPayeeAccountNo.sendKeys(payeeAccountNo);
    }

    public void setPayerAccountNo(String payerAccountNo){
        txtPayerAccountNo.sendKeys(payerAccountNo);
    }

    public void setFundAmount(String amount){
        txtAmount.sendKeys(amount);
    }

    public void setFundDesciption(String des){
        txtDescription.sendKeys(des);
    }

    public void clickSubmitButton(){
        submitButton.click();
    }

    public String getPayerAccNo(){
        return tbAccountNo.getText();
    }

    public String getPayeeAccNo(){
        return tbToAccountNo.getText();
    }

    public String getAmountTransfer(){
        return tbAmountValue.getText();
    }

}
