package tsi.too.investmentcalculation.controller;

import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;

import tsi.too.investmentcalculation.Constants;
import tsi.too.investmentcalculation.ext.StringExt;
import tsi.too.investmentcalculation.model.InvestimentFactory;
import tsi.too.investmentcalculation.model.InvestimentTableModel;
import tsi.too.investmentcalculation.model.Investment;
import tsi.too.investmentcalculation.model.Investment.Type;

public class InvestimentController {
	private static InvestimentController instance;
	
	private ArrayList<Investment> investiments = new ArrayList<Investment>();
	
	private InvestimentController() {}
	
	public static InvestimentController getInstance() {
		synchronized (InvestimentController.class){
			if(instance == null)
				instance = new InvestimentController();
			
			return instance;
		}
	}
	
	public void execute(String dataSource[]) {
		extract(dataSource);
		displayData();
	}
	
	private void extract(String[] dataSource) {
		investiments.clear(); // ensure that no data is present on the list
		
		for(String s : dataSource) {
			String split[] = s.split(";");
			
			try {
				investiments.add(InvestimentFactory.create(
						Type.from(split[0]), // type
						split[1], // name
						split[2], // rating
						split[3].equalsIgnoreCase("sim"), // fgcProtection
						StringExt.toInt(split[4]), // deadline
						StringExt.toFloat(split[5].replace(".", "").replace(",", ".")), // investedValue
						StringExt.toFloat(split[6].replace("%","")), // rate
						StringExt.toBrazilianLocalDateOrNull(split[7]), // investimentDate
						StringExt.toBrazilianLocalDateOrNull(split[8]) // rescueDate
						));
			}catch (Exception ignored) {}
		}	
	}	
	
	private void displayData() {
		investiments.sort((investiment, another) -> investiment.getType().getInitials().compareTo(another.getType().getInitials()));
		int colunsWidth[] = {
				50, // type
				120, // name
				50, // rating
				80, // fgc
				50, // deadline
				64, // invested value
				50, // yearly rate
				50, // investment date
				50, // rescue date
				50, // income rate1
				50, // income rate value
				70, // gross cumulative value
				70, // liquid cumulative value
				70, // gross income
				70 // liquid income
		
		};
		
		showDataTable(
				Constants.INVESTIMENTS, 
				new InvestimentTableModel(investiments),
				colunsWidth,
				new Dimension(1132, 272) 
		);
	}
	
	public void showDataTable(String title, TableModel tableModel, int[] colunsWidth, Dimension tableDimension) {
		JTable table = new JTable(tableModel);
		
		TableColumnModel taColumnModel = table.getColumnModel();
		
		if(colunsWidth != null) {
			for(int i = 0; i < colunsWidth.length; i++)
				taColumnModel.getColumn(i).setPreferredWidth(colunsWidth[i]);
		}
		
		table.setPreferredScrollableViewportSize(tableDimension);
		JOptionPane.showMessageDialog(null, new JScrollPane(table), title, JOptionPane.PLAIN_MESSAGE);
	}
}
