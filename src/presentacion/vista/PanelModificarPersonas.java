package presentacion.vista;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import entidad.Persona;

public class PanelModificarPersonas extends JPanel {
    protected JTable table;
    protected DefaultTableModel modeloTabla;
    private JTextField txtNombre;
    private JTextField txtApellido;
    private JTextField txtDni;
    private JButton btnModificar;

    public PanelModificarPersonas(DefaultListModel<Persona> modeloPersonas) {
    	setLayout(null);

        // Columnas
        String[] columnas = {"Nombre", "Apellido", "Dni"};
        modeloTabla = new DefaultTableModel(columnas, 0);
        table = new JTable(modeloTabla);

        // Scroll para la tabla
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(20, 45, 387, 200);
        add(scrollPane);
        
        txtNombre = new JTextField();
        txtNombre.setBounds(20, 256, 86, 20);
        add(txtNombre);
        txtNombre.setColumns(10);
        
        txtApellido = new JTextField();
        txtApellido.setColumns(10);
        txtApellido.setBounds(116, 256, 86, 20);
        add(txtApellido);
        
        txtDni = new JTextField();
        txtDni.setColumns(10);
        txtDni.setBounds(212, 256, 86, 20);
        add(txtDni);
        
        btnModificar = new JButton("Modificar");
        btnModificar.setBounds(304, 255, 103, 23);
        add(btnModificar);

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