package com.codetest.mortgageplan;

import model.Customer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CustomerTest {

    Customer customer = new Customer("John Doe", 4000, 8, 7);

    @Test
    public void getNameTest() { Assertions.assertEquals("John Doe", customer.getName()); }

    @Test
    public void getTotalLoanTest() {
        Assertions.assertEquals(4000, customer.getTotalLoan(), 0);
    }

    @Test
    public void getAnnualInterestTest() { Assertions.assertEquals(8, customer.getAnnualInterestRate(), 0); }

    @Test
    public void getYearsTest() {
        Assertions.assertEquals(7, customer.getYears(), 0);
    }

    @Test
    public void getMonthlyInterestTest() { Assertions.assertEquals(0.666667, customer.getMonthlyInterestRate(), 0.0001); }

    @Test
    public void getMonthlyPaymentTest() { Assertions.assertEquals(62.34485, customer.getMonthlyPayment(), 0.01); }
}
