package tsi.too.investmentcalculation.model;

import java.time.LocalDate;

import tsi.too.investmentcalculation.Constants;

public abstract class Investment{
	private String name;
	private String rating;
	private boolean protectedFgc;
	private final Type type;
	private float investedValue;
	private LocalDate investimentDate;
	private LocalDate rescueDate;
	private int deadline;
	private float rate;
	
	public Investment(String name, String rating, boolean fgcProtection, Type type, float investedValue,
			LocalDate investimentDate, LocalDate rescueDate, int deadline, float rate) {
		super();
		this.name = name;
		this.rating = rating;
		this.protectedFgc = fgcProtection;
		this.type = type;
		this.investedValue = investedValue;
		this.investimentDate = investimentDate;
		this.rescueDate = rescueDate;
		this.deadline = deadline;
		this.rate = rate;
	}

	public String getName() {
		return name;
	}

	public String getRating() {
		return rating;
	}

	public boolean isProtectedFgc() {
		return protectedFgc;
	}

	public Type getType() {
		return type;
	}

	public float getInvestedValue() {
		return investedValue;
	}

	public LocalDate getInvestimentDate() {
		return investimentDate;
	}

	public LocalDate getRescueDate() {
		return rescueDate;
	}

	public int getDeadline() {
		return deadline;
	}

	public float getRate() {
		return rate;
	}

	public abstract IncomeTaxRate getIncomeTaxRate();
		
	public double calculateCumulativeGrossValue() {
		var vp = getInvestedValue();
		var t = getMonthlyRate();
		var p = getDeadline();
		var vf = vp * Math.pow(1 + t, p);
		
		return vf; 
	}
		
	public double getCumulativeGrossIncome() {
		return calculateCumulativeGrossValue() - getInvestedValue();
	}		
	
	public double getIncomeTaxValue() {
		return (getIncomeTaxRate().getValue() / 100) * getCumulativeGrossIncome();
	}
	
	private double getMonthlyRate(){
		var t = Math.pow((1 + getRate() / 100.0), (1.0 / 12.0)) -1;
		return t;
	}
	
	protected int getDeadLineInDays() {
		return getDeadline() * 30;
	}
	
	public double getCumulativeLiquidValue() {
		return calculateCumulativeLiquidValue() - getInvestedValue();
	}
	
	public double calculateCumulativeLiquidValue() {
		return calculateCumulativeGrossValue() - getIncomeTaxValue();
	}
	
	@Override
	public String toString() {
		return "Investiment {name= " + name + ", rating= " + rating + ", fgcProtection= " + protectedFgc + ", type= "
				+ type + ", investedValue= " + investedValue + ", investimentDate= " + investimentDate
				+ ", rescueDate= " + rescueDate + ", deadline= " + deadline + ", rate= " + rate + "}";
	}	
	
	public enum Type {
		FIXED_INCOME(1, Constants.FIXED_INCOME, Constants.FIXED_INCOME_INITIALS),
		VARIABLE_INCOME (2, Constants.VARIABLE_INCOME, Constants.VARIABLE_INCOME_INITIALS);
		
		private int code;
		private String initials;
		private String name;
		
		Type(int code, String name, String initials) {
			this.code = code;
			this.name = name;
			this.initials = initials;
		}
		
		public String getName() {
			return name;
		}
		
		public String getInitials() {
			return initials;
		}
		
		public static Type from(int code) throws IllegalArgumentException {
			for(Type t:values())
				if(t.code == code)
					return t;

			throw new IllegalArgumentException("No such type");
		}
		
		public static Type from(String initials) throws IllegalArgumentException {
			for(Type t:values())
				if(t.initials.equals(initials))
					return t;

			throw new IllegalArgumentException("No such type");
		}
	}
}