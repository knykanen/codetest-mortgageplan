package model;

import math.Formulas;

public class Customer {
    String name;
    double totalLoan, annualInterestRate, monthlyInterestDecimal, numberPayments, years, monthlyInterestRate;


    public Customer(String name, double totalLoan, double annualInterestRate, double years) {
        this.name = name;
        this.totalLoan = totalLoan;
        this.annualInterestRate = annualInterestRate;
        this.years = years;
        this.monthlyInterestRate = annualInterestRate / 12;
        this.monthlyInterestDecimal = (annualInterestRate / 12) / 100;
        this.numberPayments = years * 12;
    }

    /***
     * @return Customer full name
     */
    public String getName() {
        return name;
    }

    /***
     * @return Total loan that the customer has
     */
    public double getTotalLoan() {
        return totalLoan;
    }

    /***
     * @return Annual interest rate in percent (%)
     */
    public double getAnnualInterestRate() {
        return annualInterestRate;
    }

    /***
     * @return Monthly interest rate in percent (%)
     */
    public double getMonthlyInterestRate() {
        return monthlyInterestRate;
    }

    /***
     * @return Years to pay debt
     */
    public double getYears() {
        return years;
    }

    /***
     * Calculates monthly payment for the customer
     * @return Rounded value of how much the customer needs to pay each month
     */
    public double getMonthlyPayment() {
        Formulas formulas = new Formulas();
        return formulas.round(formulas.mortgageFormula(totalLoan, monthlyInterestDecimal, numberPayments));
    }
}
