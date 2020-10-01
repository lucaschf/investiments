package tsi.too.investmentcalculation.model;

import static tsi.too.investmentcalculation.Constants.*;

import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.swing.table.AbstractTableModel;

public class InvestimentTableModel extends AbstractTableModel{
	private static final long serialVersionUID = 1L;
	private List<Investment> investiments;
	private String[] columns;

	public InvestimentTableModel(List<Investment> investiments) {
		super();
		this.investiments = investiments;
		
		this.columns = new String[] {
				TYPE, // 0
				NAME,  // 1
				RATING, // 2 
				FGC_PROTECTION, // 3
				DEADLINE, // 4
				INVESTED_VALUE, //5
				RATE_OF_RETURN_PER_YEAR, //6
				DATE, // 7
				RESCUE_DATE, // 8
				INCOME_TAX_RATE, // 9
				IR_VALUE, // 10
				CUMULATIVE_GROSS_AMOUNT, //11
				CUMULATIVE_LIQUID_VALUE, // 12
				GROSS_INCOME, // 13
				LIQUID_INCOME //14
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
		
		switch(col) {
			case 0:
				return investiment.getType().getInitials();
			case 1:
				return investiment.getName();
			case 2:
				return investiment.getRating();
			case 3: 
				return investiment.isProtectedFgc() ? YES : NO;
			case 4:
				return investiment.getDeadline();
			case 5:
				return String.format("%1.2f", investiment.getInvestedValue());				
			case 6:
				return String.format("%1.2f%%", investiment.getRate());	
			case 7:
				return investiment.getInvestimentDate()
						.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
			case 8:
				try {
					return investiment.getRescueDate().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
				}catch (Exception e) {
					return "-";
				}
			case 9:
				return String.format("%1.2f%%", investiment.getIncomeTaxRate());
			case 10:
				return String.format("%1.2f", investiment.getIncomeTaxValue());
			case 11:
				return String.format("%1.2f",investiment.calculateCumulativeGrossValue());
			case 12:
				return String.format("%1.2f",investiment.calculateCumulativeLiquidValue());
			case 13:
				return String.format("%1.2f",investiment.getCumulativeGrossIncome());
			case 14:
				return String.format("%1.2f",investiment.getCumulativeLiquidValue());
			default:
				return null;
		}
	}
}
