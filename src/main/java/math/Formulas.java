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
     * Rounds a double into as many decimals as specified with the help of casting.
     * @param value Number to round
     * @param decimals Number of decimals wanted
     * @return Rounded value
     */
    public double round(double value, int decimals) {
        boolean negative = false;
        if (value < 0) negative = true;
        int shiftValue = 1;
        if (decimals != 0) {
            for (int i = 0; i < decimals; i++) {
                shiftValue *= 10;
            }
        }
        double shifted = value * shiftValue;
        int temp;
        if (!negative) temp = (int) (shifted + 0.5);
        else temp = (int) (shifted - 0.5);

        return (double) temp / shiftValue;
    }

    /***
     * Exponents calculator with negative number support
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

        if (base < 0 && exponent % 2 != 0) answer *= -1;
        return answer;
    }
}
