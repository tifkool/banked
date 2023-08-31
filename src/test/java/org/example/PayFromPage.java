package org.example;


import org.openqa.selenium.By;
import org.testng.Assert;

public class PayFromPage extends BaseTest {

    public void selectFromBankAccount() throws InterruptedException {
        Assert.assertEquals(driver.getTitle(),"Banked | Checkout Demo");
        driver.findElement(By.xpath(loc.getProperty("payFrom.mockBank"))).click();


    }

}
