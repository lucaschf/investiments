package tsi.too.investmentcalculation.controller;

import java.util.ArrayList;

import tsi.too.investmentcalculation.ext.StringExt;
import tsi.too.investmentcalculation.model.InvestimentFactory;
import tsi.too.investmentcalculation.model.Investment;
import tsi.too.investmentcalculation.model.Investment.Type;
import tsi.too.investmentcalculation.ui.ReportUi;

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
		new ReportUi(investiments);
	}
}
