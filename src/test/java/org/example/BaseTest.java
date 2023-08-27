package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;


//import selenium.import webdriver;
//import selenium.webdriver.chrome.service.import Service;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseTest {

    public static WebDriver driver;
    public static Properties prop = new Properties();
    public static Properties loc = new Properties();

    public static FileReader fr1;
    public static FileReader fr2;

    @BeforeMethod
    @Parameters({"browser"})
    public void beforetest(String browser) throws IOException
    {
        if(browser.equals("chrome")) {

            String exePath = System.getProperty("user.dir") + "\\resources\\drivers\\chromedriver.exe";
            System.setProperty("webdriver.chrome.driver", exePath);
            ChromeOptions option = new ChromeOptions();
            option.addArguments("--remote-allow-origins=*");
            driver = new ChromeDriver(option);


        }
        else if (browser.equals("firefox")) {
            System.out.println("Running Firefox Browser");
            //Gecko driver initialization
            System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir") + "\\resources\\drivers\\geckodriver.exe");
            driver = new FirefoxDriver();
        }

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        FileReader fr1 = new FileReader(System.getProperty("user.dir") + "\\src\\main\\resources\\utils\\config.properties");
        prop.load(fr1);
        String u= prop.getProperty("url");
        driver.get(u);

        FileReader fr2 = new FileReader(System.getProperty("user.dir") + "\\src\\main\\resources\\utils\\locators.properties");
        loc.load(fr2);

        driver.manage().window().maximize();
    }

    @AfterTest
    public void afterMethod()
    {
        driver.close();
    }

}
