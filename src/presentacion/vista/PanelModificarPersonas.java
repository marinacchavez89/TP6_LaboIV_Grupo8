package presentacion.vista;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import entidad.Persona;

public class PanelModificarPersonas extends JPanel {
    protected JList<Persona> listaPersonas;
    protected DefaultListModel<Persona> modeloPersonas;
    private JTextField txtNombre;
    private JTextField txtApellido;
    private JTextField txtDni;
    private JButton btnModificar;

    public PanelModificarPersonas(DefaultListModel<Persona> modeloPersonas) {
        setLayout(null);

        this.modeloPersonas = modeloPersonas;
        listaPersonas = new JList<>(modeloPersonas);
        listaPersonas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        JScrollPane scrollPane = new JScrollPane(listaPersonas);
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
      
    }

    public JList<Persona> getListaPersonas() {
        return listaPersonas;
    }

    public DefaultListModel<Persona> getModeloPersonas() {
        return modeloPersonas;
    }
    
}