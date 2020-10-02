package tsi.too.investmentcalculation.model;

import java.time.LocalDate;

import tsi.too.investmentcalculation.Constants;

public class FixedIncome extends Investment {	
	public FixedIncome(
			String name, 
			String rating, 
			boolean fgcProtection, 
			float investedValue,
			LocalDate investimentDate,
			LocalDate rescueDate, 
			int deadline, 
			float rate
			) {

		super(name, rating, fgcProtection, Type.FIXED_INCOME, investedValue, investimentDate, rescueDate, deadline, rate);
	}	

	@Override
	public IncomeTaxRate getIncomeTaxRate() {
		return IncomeTaxRate.from(getDeadLineInDays());
	}
	
	@Override
	public String toString() {
		return String.format("%s: %s; %s: %s; %s: %1.2f; %s %d %s",
				getName(), 
				getRating(), 
				Constants.FGC_PROTECTION, 
				(isProtectedFgc() ? Constants.YES : Constants.NO), 
				Constants.INCOME_TAX_RATE,
				getIncomeTaxRate(),
				Constants.DEADLINE, 
				getDeadline(), 
				Constants.MONTHS
		);
	}
}