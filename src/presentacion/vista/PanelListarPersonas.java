package presentacion.vista;

import javax.swing.DefaultListModel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import entidad.Persona;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class PanelListarPersonas extends JPanel {
	private JTable table;	 
	private DefaultTableModel modeloTabla;

	public PanelListarPersonas(DefaultListModel<Persona> modeloPersonas) {
		
		 	setLayout(null);

	        // Columnas
	        String[] columnas = {"Nombre", "Apellido", "Dni"};
	        modeloTabla = new DefaultTableModel(columnas, 0);
	        table = new JTable(modeloTabla);

	        // Scroll para la tabla
	        JScrollPane scrollPane = new JScrollPane(table);
	        scrollPane.setBounds(20, 45, 369, 200);
	        add(scrollPane);

	        // Esto seria para luego cargar datos desde el modelo, se puede editar por foreach, etc.
	        for (int i = 0; i < modeloPersonas.size(); i++) {
	            Persona p = modeloPersonas.get(i);
	            modeloTabla.addRow(new Object[]{p.getNombre(), p.getApellido(), p.getDni()});
	        }
	    }

	    public JTable getTable() {
	        return table;
	    }

	    public DefaultTableModel getModeloTabla() {
	        return modeloTabla;
	    }
}