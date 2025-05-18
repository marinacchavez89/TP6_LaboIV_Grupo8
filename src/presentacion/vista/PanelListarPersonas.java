package presentacion.vista;

import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import entidad.Persona;
import javax.swing.JTable;

import javax.swing.table.DefaultTableModel;

public class PanelListarPersonas extends JPanel {
	private JTable table;	 
	private DefaultTableModel modeloTabla;

	public PanelListarPersonas() {
		
		setLayout(null);
		
		// Columnas
		String[] columnas = {"Nombre", "Apellido", "Dni"};
		modeloTabla = new DefaultTableModel(columnas, 0) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		table = new JTable(modeloTabla);
		
		// Scroll para la tabla
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(20, 45, 369, 200);
		add(scrollPane);
	 }
	   
	public void cargarPersonas(List<Persona> personas) {
		modeloTabla.setRowCount(0);
		for (Persona persona : personas) {
			modeloTabla.addRow(new Object[] {persona.getNombre(),persona.getApellido(),persona.getDni()});
		}
	}
	
    public JTable getTable() {
        return table;
    }

    public DefaultTableModel getModeloTabla() {
        return modeloTabla;
    }
}