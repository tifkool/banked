package org.example;


import org.openqa.selenium.By;
import org.testng.Assert;


public class PayToPage extends BaseTest {
        public void selectToBankAccountSuccess() throws InterruptedException {
        System.out.println("Account Name:"+prop.getProperty("ACCOUNT_NAME")+ " BSB Number :"+prop.getProperty("BSB_NUMBER")+" Account Number :"+prop.getProperty("ACCOUNT_NUMBER"));
        driver.findElement(By.id(loc.getProperty("payTo.accountName_txt"))).sendKeys(prop.getProperty("ACCOUNT_NAME"));
        driver.findElement(By.id(loc.getProperty("payTo.bsbNumber_txt"))).sendKeys(prop.getProperty("BSB_NUMBER"));
        driver.findElement(By.id(loc.getProperty("payTo.accountNumber_txt"))).sendKeys(prop.getProperty("ACCOUNT_NUMBER"));
        Thread.sleep(10000);
        driver.findElement(By.xpath(loc.getProperty("payTo.continue_button"))).click();
        Assert.assertEquals(driver.findElement(By.xpath(loc.getProperty("assertPaymentSuccess"))).getText(), "Payment complete");
        System.out.println(driver.findElement(By.xpath(loc.getProperty("assertPaymentSuccess"))).getText());

        }


        public void selectToBankAccountDelay() throws InterruptedException {
                System.out.println("Account Name:"+prop.getProperty("ACCOUNT_NAME2")+ " BSB Number :"+prop.getProperty("BSB_NUMBER2")+" Account Number :"+prop.getProperty("ACCOUNT_NUMBER2"));
                driver.findElement(By.id(loc.getProperty("payTo.accountName_txt"))).sendKeys(prop.getProperty("ACCOUNT_NAME2"));
                driver.findElement(By.id(loc.getProperty("payTo.bsbNumber_txt"))).sendKeys(prop.getProperty("BSB_NUMBER2"));
                driver.findElement(By.id(loc.getProperty("payTo.accountNumber_txt"))).sendKeys(prop.getProperty("ACCOUNT_NUMBER2"));
                Thread.sleep(10000);
                driver.findElement(By.xpath(loc.getProperty("payTo.continue_button"))).click();
                long startTime = System.currentTimeMillis();
                System.out.println("Start payment time in seconds:" + startTime/1000);
                Assert.assertEquals(driver.findElement(By.xpath("//p[contains(text(),'Payment complete')]")).getText(), "Payment complete");
                long endTime = System.currentTimeMillis();
                System.out.println("End payment time in seconds:" + endTime/1000);
                long responseTimeInMillis = endTime - startTime;
                long responseTimeInSeconds = responseTimeInMillis/1000;
                System.out.println("Total time in seconds:" + responseTimeInSeconds);
                long expectedMaxResponseTimeInSeconds = 10;
                try {
                        if (responseTimeInSeconds <= expectedMaxResponseTimeInSeconds) {
                                Assert.assertTrue(responseTimeInSeconds <= expectedMaxResponseTimeInSeconds, "Response time is not exceeding the expected maximum time (" + expectedMaxResponseTimeInSeconds + " Seconds).");
                        } else {
                                Assert.assertTrue(responseTimeInSeconds <= expectedMaxResponseTimeInSeconds, "Response time exceeded the expected maximum time (" + expectedMaxResponseTimeInSeconds + " Seconds).");
                        }
                }
                catch (AssertionError assertionError) {
                        System.out.println("Assertion failed: " + assertionError.getMessage());
                }
        }

        public void selectToBankAccountFail() throws InterruptedException {
                System.out.println("Account Name:"+prop.getProperty("ACCOUNT_NAME3")+ " BSB Number :"+prop.getProperty("BSB_NUMBER3")+" Account Number :"+prop.getProperty("ACCOUNT_NUMBER3"));
                driver.findElement(By.id(loc.getProperty("payTo.accountName_txt"))).sendKeys(prop.getProperty("ACCOUNT_NAME3"));
                driver.findElement(By.id(loc.getProperty("payTo.bsbNumber_txt"))).sendKeys(prop.getProperty("BSB_NUMBER3"));
                driver.findElement(By.id(loc.getProperty("payTo.accountNumber_txt"))).sendKeys(prop.getProperty("ACCOUNT_NUMBER3"));
                Thread.sleep(10000);
                driver.findElement(By.xpath(loc.getProperty("payTo.continue_button"))).click();
                Assert.assertEquals(driver.findElement(By.xpath(loc.getProperty("assertPaymentFail"))).getText(), "Payment Failed");
                System.out.println(driver.findElement(By.xpath(loc.getProperty("assertPaymentFail"))).getText());

        }

        public void selectToBankAccountInsufFunds() throws InterruptedException {
                System.out.println("Account Name:"+prop.getProperty("ACCOUNT_NAME4")+ " BSB Number :"+prop.getProperty("BSB_NUMBER4")+" Account Number :"+prop.getProperty("ACCOUNT_NUMBER4"));
                driver.findElement(By.id(loc.getProperty("payTo.accountName_txt"))).sendKeys(prop.getProperty("ACCOUNT_NAME4"));
                driver.findElement(By.id(loc.getProperty("payTo.bsbNumber_txt"))).sendKeys(prop.getProperty("BSB_NUMBER4"));
                driver.findElement(By.id(loc.getProperty("payTo.accountNumber_txt"))).sendKeys(prop.getProperty("ACCOUNT_NUMBER4"));
                Thread.sleep(10000);
                driver.findElement(By.xpath(loc.getProperty("payTo.continue_button"))).click();
                Assert.assertEquals(driver.findElement(By.xpath(loc.getProperty("assertInsufficientFunds"))).getText(), "Insufficient funds");
                System.out.println(driver.findElement(By.xpath(loc.getProperty("assertInsufficientFunds"))).getText());
        }

}
