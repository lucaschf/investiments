package tsi.too.investmentcalculation.model;

import java.time.LocalDate;

public class FixedIncome extends Investment {
	// Income Tax referring to the return on an investment of up to 180 days
	public static final double INCOME_TAX_RATE_22_5 = 22.5;
	
	// Income Tax calculated on the return on an investment from 181 to 360 days
	public static final double INCOME_TAX_RATE_20 = 20.0;
	
	// Income Tax calculated on the return on an investment from 361 to 720 days.
	public static final double INCOME_TAX_RATE_17_5 = 17.5;
	
	// Income Tax calculated on the return on an investment over 720 days.
	public static final double INCOME_TAX_RATE_15 = 15.0;	
	
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
	public double getIncomeTaxRate() {
		int days = getDeadline() / 30;
		
		if(days > 720)
			return INCOME_TAX_RATE_15;
		
		if(days >= 361)
			return INCOME_TAX_RATE_17_5;
		
		if(days >= 181)
			return INCOME_TAX_RATE_20;
		
		return INCOME_TAX_RATE_22_5;
	}
}
