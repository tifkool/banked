package org.example;

import org.testng.annotations.Test;


public class TestSuiteBanked extends BaseTest {

     @Test(priority = 1)
        public void paymentSuccess() throws Exception {

            BaseTest BT = new BaseTest();
            DemoPage home = new DemoPage();
            home.selectCustomer();
            home.selectDropDownOptions();
            home.selectHostedCheckout();
            PayFromPage payFrom = new PayFromPage();
            payFrom.selectFromBankAccount();
            System.out.println("Test 1: Success Payment Scenario");
            PayToPage payTo = new PayToPage();
            payTo.selectToBankAccountSuccess();
//            BT.afterMethod();
        }

    @Test(priority =2)
    public void paymentDelay() throws Exception {

        BaseTest BT = new BaseTest();
        DemoPage home = new DemoPage();
        home.selectCustomer();
        home.selectDropDownOptions();
        home.selectHostedCheckout();
        PayFromPage payFrom = new PayFromPage();
        payFrom.selectFromBankAccount();
        System.out.println("Test 2: Delay in Payment Scenario");
        PayToPage payTo = new PayToPage();
        payTo.selectToBankAccountDelay();
    }

    @Test(priority =3)
    public void paymentFail() throws Exception {

        BaseTest BT = new BaseTest();
        DemoPage home = new DemoPage();
        home.selectCustomer();
        home.selectDropDownOptions();
        home.selectHostedCheckout();
        PayFromPage payFrom = new PayFromPage();
        payFrom.selectFromBankAccount();
        System.out.println("Test 3: Fail Payment Scenario");
        PayToPage payTo = new PayToPage();
        payTo.selectToBankAccountFail();
//        BT.afterMethod();
    }

    @Test(priority =4)
    public void insufficientFunds() throws Exception {

        BaseTest BT = new BaseTest();
        DemoPage home = new DemoPage();
        home.selectCustomer();
        home.selectDropDownOptions();
        home.selectHostedCheckout();
        PayFromPage payFrom = new PayFromPage();
        payFrom.selectFromBankAccount();
        System.out.println("Test 4: Fail Payment Scenario");
        PayToPage payTo = new PayToPage();
        payTo.selectToBankAccountInsufFunds();
    }



}
