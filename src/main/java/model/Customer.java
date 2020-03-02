package model;

import math.Formulas;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String fullName;
    double totalLoan, annualInterestRate, monthlyInterestDecimal, monthlyInterestRate, numberPayments, years;

    public Customer() {
    }

    public Customer(String fullName, double totalLoan, double annualInterestRate, double years) {
        this.fullName = fullName;
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
        return fullName;
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
        return formulas.round(formulas.mortgageFormula(totalLoan, monthlyInterestDecimal, numberPayments), 2);
    }
}
