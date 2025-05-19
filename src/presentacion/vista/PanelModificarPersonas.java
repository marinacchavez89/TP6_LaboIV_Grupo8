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
    

    public PanelModificarPersonas() {
    	setLayout(null);
	    this.modeloPersonas = new DefaultListModel<>();
	    listaPersonas = new JList<>(modeloPersonas);
	    listaPersonas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	    
	    // Título arriba de la lista
	    JLabel lblTitulo = new JLabel("Seleccione la persona que desea modificar:");
	    lblTitulo.setBounds(20, 15, 253, 20);
	    add(lblTitulo);

        JScrollPane scrollPane = new JScrollPane(listaPersonas);
        scrollPane.setBounds(20, 45, 387, 200);
        add(scrollPane);

        txtNombre = new JTextField();
        txtNombre.setBounds(20, 256, 86, 20);
        add(txtNombre);

        txtApellido = new JTextField();
        txtApellido.setBounds(116, 256, 86, 20);
        add(txtApellido);

        txtDni = new JTextField();
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
    
    public JTextField getTxtNombre() { 
    	return txtNombre; 
    }
    
    public JTextField getTxtApellido() { 
    	return txtApellido; 
    }
    
    public JTextField getTxtDni() { 
    	return txtDni; 
    }
    
    public JButton getBtnModificar() { 
    	return btnModificar; 
    }
    
   
}