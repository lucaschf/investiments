package tsi.too.investmentcalculation.model;

import static tsi.too.investmentcalculation.Constants.*;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import tsi.too.investmentcalculation.Constants;
import tsi.too.investmentcalculation.ext.LocalDateTimeExt;
import tsi.too.investmentcalculation.ext.NumberExt;

public class InvestimentTableModel extends AbstractTableModel{
	private static final long serialVersionUID = 1L;
	private List<Investment> investiments;
	private String[] columns;

	public InvestimentTableModel(List<Investment> investiments) {
		super();
		this.investiments = investiments;

		this.columns = new String[] {
				TYPE, 
				NAME, 
				RATING,
				FGC_PROTECTION,
				DEADLINE, 
				INVESTED_VALUE, 
				RATE_OF_RETURN_PER_YEAR,
				DATE, 
				RESCUE_DATE, 
				INCOME_TAX_RATE, 
				IR_VALUE, 
				CUMULATIVE_GROSS_AMOUNT, 
				CUMULATIVE_LIQUID_VALUE, 
				GROSS_INCOME, 
				LIQUID_INCOME 
		};
	}

	public int getColumnCount() {
		return columns.length ;
	}

	@Override
	public int getRowCount() {
		return investiments.size();
	}

	@Override
	public String getColumnName(int col) {
		return columns[col] ;
	}

	@Override
	public Object getValueAt(int row, int col) {
		var investiment = investiments.get(row);
		switch(getColumnName(col)) {
			case TYPE:
				return investiment.getType().getInitials();
			case NAME:
				return investiment.getName();
			case RATING:
				return investiment.getRating();
			case FGC_PROTECTION: 
				return investiment.isProtectedFgc() ? YES : NO;
			case DEADLINE:
				return String.format("%d %s", investiment.getDeadline(), Constants.MONTHS);
			case INVESTED_VALUE:
				return NumberExt.toBrazilianCurrency(investiment.getInvestedValue());				
			case RATE_OF_RETURN_PER_YEAR:
				return String.format("%1.2f%%", investiment.getRate());	
			case DATE:
				return LocalDateTimeExt.toBrazilianDateString(investiment.getInvestimentDate());
			case RESCUE_DATE:
				try {
					return LocalDateTimeExt.toBrazilianDateString(investiment.getRescueDate());
				}catch (Exception e) {
					return "-";
				}
			case INCOME_TAX_RATE:
				return String.format("%1.2f%%", investiment.getIncomeTaxRate());
			case IR_VALUE:
				return NumberExt.toBrazilianCurrency(investiment.getIncomeTaxValue());
			case CUMULATIVE_GROSS_AMOUNT:
				return NumberExt.toBrazilianCurrency(investiment.calculateCumulativeGrossValue());
			case CUMULATIVE_LIQUID_VALUE:
				return NumberExt.toBrazilianCurrency(investiment.calculateCumulativeLiquidValue());
			case GROSS_INCOME:
				return NumberExt.toBrazilianCurrency(investiment.getCumulativeGrossIncome());
			case LIQUID_INCOME:
				return NumberExt.toBrazilianCurrency(investiment.getCumulativeLiquidValue());
			default:
				
				return null;
		}
	}
}
