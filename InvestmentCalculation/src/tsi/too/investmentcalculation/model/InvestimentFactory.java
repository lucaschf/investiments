package tsi.too.investmentcalculation.model;

import java.time.LocalDate;
import java.time.Period;

import tsi.too.investmentcalculation.model.Investment.Type;

public abstract class InvestimentFactory {
	public static Investment create(
			Investment.Type type,
			String name, 
			String rating, 
			boolean fgcProtection,
			int deadline, 
			float investedValue,
			float rate,
			LocalDate investimentDate,
			LocalDate rescueDate			
		) throws IllegalArgumentException{
		if(type == Type.FIXED_INCOME) {
			return new FixedIncome(name, rating, fgcProtection, investedValue, investimentDate, rescueDate, deadline, rate);
		}
		
		if(type == Type.VARIABLE_INCOME) {
			var viDeadline = Period.between(investimentDate, rescueDate).getMonths();
			return new VariableIncome(name, rating, fgcProtection, investedValue, investimentDate, rescueDate, viDeadline, rate); 
		}
		
		throw new IllegalArgumentException("No such type");
	}
}