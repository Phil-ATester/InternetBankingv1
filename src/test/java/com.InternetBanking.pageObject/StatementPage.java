package com.InternetBanking.pageObject;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StatementPage {

    private WebDriver driver;

    @FindBy(xpath="//*[@href='MiniStatementInput.php']")
    WebElement statementLink;

    @FindBy(name = "accountno")
    WebElement txtAccountNo;

    @FindBy(name = "AccSubmit")
    WebElement submitButton;

    public StatementPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickStatementLink(){
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click();", statementLink);
    }

    public void setAccountNumber(String num){
        txtAccountNo.sendKeys(num);
    }

    public void clickSubmit(){
        submitButton.click();
    }
}
