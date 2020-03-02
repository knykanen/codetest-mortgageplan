package com.codetest.mortgageplan;

import math.Formulas;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class FormulasTest {

	Formulas formulas = new Formulas();

	@Test
	void mortgageFormulaTest() {
		// Check mortgage formula calculation
		Assertions.assertEquals(1741.8806, formulas.mortgageFormula(4012, (5.21/12), 36), 0.1);
		Assertions.assertEquals(772.75410, formulas.mortgageFormula(1300.55, (7.13/12), 24), 0.1);
	}

	@Test
	void roundTest() {
		// Check 0 decimal rounding
		Assertions.assertEquals(32, formulas.round(31.9, 0), 0);
		// Check 2 decimal rounding
		Assertions.assertEquals(3657.50, formulas.round(3657.4999999, 2), 0);
		Assertions.assertEquals(3657.49, formulas.round(3657.4949999, 2), 0);
		// Check 4 decimal rounding
		Assertions.assertEquals(3657.4364, formulas.round(3657.4364364, 4), 0);
		// Check 0 decimal rounding with 0.49 and 0.5
		Assertions.assertEquals(3657.0, formulas.round(3657.4999999, 0), 0);
		Assertions.assertEquals(3658.0, formulas.round(3657.5000000, 0), 0);
		// Check negative rounding
		Assertions.assertEquals(-3461.46, formulas.round(-3461.4577, 2), 0);
	}

	@Test
	void powerTest() {
		// Check normal exponent calculation
		Assertions.assertEquals(32, formulas.power(2, 5), 0);
		// Check negative exponent calculation
		Assertions.assertEquals(-32, formulas.power(-2, 5), 0);
		// Check if 0 exponent value returns 1
		Assertions.assertEquals(1, formulas.power(300, 0), 0);
		// Check if 1 exponent returns base value
		Assertions.assertEquals(300, formulas.power(300, 1), 0);
	}

}
