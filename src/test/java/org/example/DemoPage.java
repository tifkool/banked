package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class DemoPage extends BaseTest {
    static String title;
    public void verifyULR(String url) {
        Assert.assertEquals(driver.getCurrentUrl(), url);
        title = driver.findElement(By.xpath("//a[contains(text(),'Demo Checkout')]")).getText().trim();
        System.out.println("Title : " + title);

    }

    public static void selectCustomer() {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.id(loc.getProperty("demo.newCustomer_radioButton"))).click();

    }

    public void selectDropDownOptions() throws Exception {
        Select se;
        try {
            se = new Select(driver.findElement(By.id(loc.getProperty("demo.region_dropDown"))));
            se.selectByVisibleText(prop.getProperty("region"));

        } catch (Exception ex) {
            System.out.println("Region is not available");
        }

    }

    public void selectHostedCheckout() {
        driver.findElement(By.xpath(loc.getProperty("demo.hostedCheckout_button"))).click();

        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

    }

}