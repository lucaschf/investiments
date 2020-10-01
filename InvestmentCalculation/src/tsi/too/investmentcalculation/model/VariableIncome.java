package tsi.too.investmentcalculation.model;

import java.time.LocalDate;

import tsi.too.investmentcalculation.Constants;


public class VariableIncome extends Investment {
	// Income Tax calculated on income.
	public static final double INCOME_TAX_RATE = 15.0;
	
	public VariableIncome(
			String name, 
			String rating, 
			boolean fgcProtection, 
			float investedValue,
			LocalDate investimentDate,
			LocalDate rescueDate, 
			int deadline, 
			float rate
			) {

		super(name, rating, fgcProtection, Type.VARIABLE_INCOME, investedValue, investimentDate, rescueDate, deadline, rate);
	}
	
	@Override
	public double getIncomeTaxRate() {
		return INCOME_TAX_RATE;
	}
	
	@Override
	public String toString() {
		return String.format("%s: %s; %s: %s",
				getName(),
				getRating(),
				Constants.FGC_PROTECTION,
				isProtectedFgc() ? Constants.YES : Constants.NO
		);
	}
}