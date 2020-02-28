package math;

public class Formulas {
    /***
     * Calculates monthly payment with the formula given: E = U[b(1 + b)^p]/[(1 + b)^p - 1]
     * @return Value of how much is needed to pay each month
     */
    public double mortgageFormula(double totalLoan, double monthlyInterestDecimal, double numberPayments) {
        return totalLoan * (monthlyInterestDecimal * power((1 + monthlyInterestDecimal), numberPayments)) / (power((1 + monthlyInterestDecimal), numberPayments) - 1);
    }

    /***
     * Rounds a double into two decimals with the help of casting.
     * @param value Number to round
     * @return Rounded value
     */
    public double round(double value) {
        double shifted = value * 100;
        int temp = (int) (shifted + 0.5);
        return (double) temp / 100;
    }

    /***
     *
     * @param base Number that is being multiplied repeatedly in the expanded form
     * @param exponent Value that specifies how many times the base will be multiplied by itself
     * @return Answer to the exponentiation
     */
    public double power(double base, double exponent) {
        double answer = 1;
        while (exponent != 0) {
            answer *= base;
            exponent--;
        }
        return answer;
    }
}
