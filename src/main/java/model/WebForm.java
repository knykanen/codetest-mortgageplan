package model;

import math.Formulas;

public class WebForm {
    String totalLoan;
    String interest;
    String years;

    public WebForm() {
        super();
    }

    public String getTotalLoan() {
        return totalLoan;
    }

    public String getInterest() {
        return interest;
    }

    public String getYears() {
        return years;
    }

    public void setTotalLoan(String totalLoan) {
        this.totalLoan = totalLoan;
    }

    public void setInterest(String interest) {
        this.interest = interest;
    }

    public void setYears(String years) {
        this.years = years;
    }

    @Override
    public String toString() {
        Formulas formulas = new Formulas();
        System.out.println(totalLoan);
        if (totalLoan != null && interest != null && years != null) {
            return Double.toString(formulas.round(formulas.mortgageFormula(Double.parseDouble(totalLoan), (Double.parseDouble(interest) / 12 / 100), (Double.parseDouble(years) * 12)), 2));
        }
        else {
            return "";
        }
    }

}
