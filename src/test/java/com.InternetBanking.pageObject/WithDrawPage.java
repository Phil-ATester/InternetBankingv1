package com.InternetBanking.pageObject;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WithDrawPage {

    private WebDriver driver;

    @FindBy(xpath = "//a[@href='WithdrawalInput.php']")
    WebElement withdrawLink;

    @FindBy(name="accountno")
    WebElement txtAccountNo;

    @FindBy(name="ammount")
    WebElement txtAccountAmount;

    @FindBy(name="desc")
    WebElement txtDescription;

    @FindBy(name="AccSubmit")
    WebElement submitButton;

    @FindBy(xpath="//tr[td='Current Balance']//following-sibling::td[2]")
    WebElement tbBalanceValue;

    @FindBy(xpath="//tr[td='Amount Debited']//following-sibling::td[2]")
    WebElement tbAmountDebit;


    public WithDrawPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickWithdrawLink(){
        //withdrawLink.click();
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click();", withdrawLink);
    }

    public void setTxtAccountNo(String num){
        txtAccountNo.sendKeys(num);
    }

    public void setTxtAccountAmount(String amount){
        txtAccountAmount.sendKeys(amount);
    }

    public void setTxtDescription(String desc){
        txtDescription.sendKeys(desc);
    }

    public void clickSubmitButton(){
        submitButton.click();
    }

    public String getCurrentBalance(){
        return tbBalanceValue.getText();
    }

    public String getAmountDebited(){
        return tbAmountDebit.getText();
    }
}
