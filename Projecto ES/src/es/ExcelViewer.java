package es;

import javax.swing.JFrame;
	import javax.swing.JOptionPane;
	import javax.swing.JScrollPane;
	import javax.swing.JTable;
	import javax.swing.WindowConstants;
	import javax.swing.table.DefaultTableModel;

	public class ExcelViewer {
		private JFrame frame;
		DefaultTableModel tableModel;

		public ExcelViewer(Excel excel) {
			try {
				this.tableModel = excel.getModelTable();
			} catch (Exception e) {
				e.printStackTrace();
			}

			frame = new JFrame(excel.getName());
			frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

			addFrameContent();
			frame.pack();
		}

		public void open() {
			frame.setVisible(true);
		}

		private void addFrameContent() {
			/*if(tableModel.equals(null)) {
				JOptionPane.showMessageDialog(null, "Erro ao abrir o Visualizador do Excel");
			}

			else { */
			JTable table = new JTable(tableModel);		
			frame.add(new JScrollPane(table));
		}
	}


