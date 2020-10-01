package tsi.too.investmentcalculation.ui;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.util.List;

import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableModel;

import tsi.too.investmentcalculation.Constants;
import tsi.too.investmentcalculation.model.InvestimentTableModel;
import tsi.too.investmentcalculation.model.Investment;

@SuppressWarnings("serial")
public class ReportUi extends JDialog {
	private JTable table;

	public ReportUi(List<Investment>  dataSource) throws HeadlessException {
		setModalityType(ModalityType.APPLICATION_MODAL);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setTitle(Constants.INVESTIMENTS);

		setModal(true);		
		setMinimumSize(new Dimension(1134, 100));
		getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		TableModel model = new InvestimentTableModel(dataSource);
		table = new JTable(model);
		table.setFillsViewportHeight(true);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		
		JScrollPane scroll = new JScrollPane(table);
		scroll.setMinimumSize(new Dimension(23, 100));
		scroll.setPreferredSize(new Dimension(1120, 295));
		scroll.setToolTipText("");
		scroll.setViewportBorder(null);
		scroll.setHorizontalScrollBar(null);
		getContentPane().add(scroll);
		
		pack();
		setLocationRelativeTo(null);
		
		setVisible(true);		
	}
}
