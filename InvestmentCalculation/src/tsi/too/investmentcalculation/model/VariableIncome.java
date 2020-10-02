package tsi.too.investmentcalculation.model;

import java.time.LocalDate;

import tsi.too.investmentcalculation.Constants;


public class VariableIncome extends Investment {
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
	public IncomeTaxRate getIncomeTaxRate() {
		return IncomeTaxRate.VARIABLE;
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