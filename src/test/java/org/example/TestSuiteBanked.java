package org.example;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;

public class TestSuiteBanked extends BaseTest {

     @Test(priority = 1)
        public void paymentSuccess() throws Exception {

            BaseTest BT = new BaseTest();
            DemoPage home = new DemoPage();
            home.selectCustomer();
            home.selectDropDownOptions();
            home.selectHostedCheckout();
            PayFromPage payfrom = new PayFromPage();
            payfrom.selectFromBankAccount();
            System.out.println("Test 1: Success Payment Scenario");
            PayToPage payto = new PayToPage();
            payto.selectToBankAccountSuccess();
            BT.afterMethod();
        }

    @Test(priority =2)
    public void paymentDelay() throws Exception {

        BaseTest BT = new BaseTest();
        DemoPage home = new DemoPage();
        home.selectCustomer();
        home.selectDropDownOptions();
        home.selectHostedCheckout();
        PayFromPage payfrom = new PayFromPage();
        payfrom.selectFromBankAccount();
        System.out.println("Test 2: Delay in Payment Scenario");
        PayToPage payto = new PayToPage();
        payto.selectToBankAccountDelay();
    }

    @Test(priority =3)
    public void paymentFail() throws Exception {

        BaseTest BT = new BaseTest();
        DemoPage home = new DemoPage();
        home.selectCustomer();
        home.selectDropDownOptions();
        home.selectHostedCheckout();
        PayFromPage payfrom = new PayFromPage();
        payfrom.selectFromBankAccount();
        System.out.println("Test 3: Fail Payment Scenario");
        PayToPage payto = new PayToPage();
        payto.selectToBankAccountFail();
        BT.afterMethod();
    }

    @Test(priority =4)
    public void insufficientFunds() throws Exception {

        BaseTest BT = new BaseTest();
        DemoPage home = new DemoPage();
        home.selectCustomer();
        home.selectDropDownOptions();
        home.selectHostedCheckout();
        PayFromPage payfrom = new PayFromPage();
        payfrom.selectFromBankAccount();
        System.out.println("Test 4: Fail Payment Scenario");
        PayToPage payto = new PayToPage();
        payto.selectToBankAccountInsufFunds();
    }



}
