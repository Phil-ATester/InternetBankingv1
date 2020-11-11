package com.InternetBanking.testCases;

import com.InternetBanking.utilities.ReadConfig;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;


public class BaseClass {

    public WebDriver driver;

    //public String baseURl = "http://demo.guru99.com/V4/";
    //public String userName = "mngr293865";
    //public String password = "Apemuty";

    ReadConfig readConfig = new ReadConfig();
    public String baseURl = readConfig.getApplicationURL();
    public String userName = readConfig.getUserName();
    public String passWord = readConfig.getPassword();

    public static Logger logger;

    @Parameters("browser")
    @BeforeClass
    public void setUp(String br){

        //System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/Drivers/chromedriver");
        //System.setProperty("webdriver.chrome.driver", readConfig.getChromePath());
        // driver = new ChromeDriver();
        switch(br){
            case "IE":
                //System.setProperty("webdriver.ie.driver", readConfig.getIEPath());
                //driver = new InternetExplorerDriver();
                System.out.println("Internet Explorer Browser selected");
                break;
            case "Firefox":
                //System.setProperty("webdriver.gecko.driver", readConfig.getFireFoxPath());
                //driver = new FireFoxDriver();
                System.out.println("FireFox Browser selected");
                break;
            case "Chrome":
                System.setProperty("webdriver.chrome.driver", readConfig.getChromePath());
                driver = new ChromeDriver();
                break;
            default:
                System.out.println("No Browser Selected");
                break;
        }

        driver.get(baseURl);

        // set the amount of time to wait for a page to load to complete before it throws an error
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);  // time , Timeout unit

        // log4j setup
        logger = Logger.getLogger("InternetBanking");
        PropertyConfigurator.configure("Log4j.properties");

    }

    @AfterClass
    public void teardown(){
        driver.quit();
    }

    public void captureScreen(WebDriver driver, String testName) throws IOException {
        //System.out.println("in Screenshot method");
        TakesScreenshot ts = ((TakesScreenshot) driver);
        File source = ts.getScreenshotAs(OutputType.FILE);
        File target = new File(System.getProperty("user.dir") + "/ScreenShots/" + testName + ".png");
        FileUtils.copyFile(source, target);
        System.out.println("Screenshot Taken");
    }

    public boolean isAlertPresent(){
        try {
            driver.switchTo().alert();
            return true;
        }catch (NoAlertPresentException e){
            return false;
        }
    }

    public String randomString(){
        return RandomStringUtils.randomAlphabetic(8);
    }

    public String randomNumber(){
        return RandomStringUtils.randomNumeric(4);
    }

}
