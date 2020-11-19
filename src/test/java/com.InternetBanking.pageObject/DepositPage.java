package com.InternetBanking.pageObject;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DepositPage {

    private WebDriver driver;

    @FindBy(xpath = "//*[@href='DepositInput.php']")
    WebElement depositLink;

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

    @FindBy(xpath="//tr[td='Amount Credited']//following-sibling::td[2]")
    WebElement tbAmountCredited;


    public DepositPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickDepositLink(){
        //depositLink.click();
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click();", depositLink);
    }

    public void setTxtAccountNo(String num){
        txtAccountNo.sendKeys(num);
    }

    public void setTxtAccountAmount(String amount){
        txtAccountAmount.sendKeys(amount);
    }

    public void clickSubmitButton(){
        submitButton.click();
    }

    public void setTxtDescription(String desc){
        txtDescription.sendKeys(desc);
    }

    public String getCurrentBalance(){
        return tbBalanceValue.getText();
    }

    public String getAmountCredit(){
        return tbAmountCredited.getText();
    }
}
