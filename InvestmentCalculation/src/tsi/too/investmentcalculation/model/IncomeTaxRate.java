package tsi.too.investmentcalculation.model;

public enum IncomeTaxRate {
	VARIABLE(Integer.MIN_VALUE , Integer.MIN_VALUE, 15),
	INCOME_TAX_RATE_22_5(0, 180, 22.5),
	INCOME_TAX_RATE_20(181, 360, 20.0),
	INCOME_TAX_RATE_17_5(361, 720, 17.5),
	INCOME_TAX_RATE_15(721, Integer.MAX_VALUE ,15);
	
	private IncomeTaxRate(int minDaysInclusive, int maxDaysInclusive, double value) {
		this.minDaysInclusive = minDaysInclusive;
		this.maxDaysInclusive = maxDaysInclusive;
		this.value = value;
	}
	
	private int minDaysInclusive;
	private int maxDaysInclusive;
	private double value;
	
	public double getValue() {
		return value;
	}
	
	public static IncomeTaxRate from (int days) throws IllegalArgumentException {
		for(IncomeTaxRate i : values()) {
			if(i.minDaysInclusive <= days && i.maxDaysInclusive >= days)
				return i;
		}
		
		throw new IllegalArgumentException("No such IncomeTaxRate");
	}
}