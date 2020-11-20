package com.InternetBanking.pageObject;

import com.InternetBanking.testCases.BaseClass;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CustomisedStatementPage{

    private WebDriver driver;

    @FindBy (how = How.NAME, using = "accountno")
    WebElement txtAccountNo;

    @FindBy (how = How.NAME, using = "fdate")
    WebElement fromDate;

    @FindBy (how = How.NAME, using = "tdate")
    WebElement toDate;

    @FindBy (how = How.NAME, using = "amountlowerlimit")
    WebElement txtTransactionValue;

    @FindBy (how = How.NAME, using = "numtransaction")
    WebElement txtNumberOfTransaction;

    @FindBy (how = How.NAME, using = "AccSubmit")
    WebElement submitButton;

    @FindBy (how = How.XPATH, using = "//*[contains(text(),'Customised Statement')]")
    WebElement customStatementLink;

    private WebDriverWait wait;
    private static final int TIMEOUT = 5;
    private static final int POLLING = 100;

    public CustomisedStatementPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, TIMEOUT, POLLING);
    }

    public void clickCustomisedStatementLink(){
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click();", customStatementLink);
    }

    public void setTxtAccountNo(String no){
        txtAccountNo.sendKeys(no);
    }

    public void setToDate(String dd, String mm, String yyyy){
        toDate.sendKeys(dd);
        toDate.sendKeys(mm);
        toDate.sendKeys(yyyy);
    }

    public void setFromDate(String dd, String mm, String yyyy){
        fromDate.sendKeys(dd);
        fromDate.sendKeys(mm);
        fromDate.sendKeys(yyyy);
    }

    public void setTxtTransactionValue(String value){
        txtTransactionValue.sendKeys(value);
    }

    public void setTxtNumberOfTransaction(String num){
        txtNumberOfTransaction.sendKeys(num);
    }

    public void clickSubmit(){
        submitButton.click();
    }

}
