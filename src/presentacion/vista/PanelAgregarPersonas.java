package presentacion.vista;

import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JPanel;
import entidad.Persona;
import javax.swing.JTextField;

public class PanelAgregarPersonas extends JPanel {
	
	private JTextField txtNombre;
    private JTextField txtApellido;
    private JTextField txtDni;

	public PanelAgregarPersonas(DefaultListModel<Persona> modeloPersonas) {
		setLayout(null);
        
        // Nombre
        JLabel lblNombre = new JLabel("Nombre:");
        txtNombre = new JTextField(20);
        add(lblNombre);
        add(txtNombre);

        // Apellido
        JLabel lblApellido = new JLabel("Apellido:");
        txtApellido = new JTextField(20);
        add(lblApellido);
        add(txtApellido);

        // DNI
        JLabel lblDni = new JLabel("DNI:");
        txtDni = new JTextField(20);
        add(lblDni);
        add(txtDni);
    }
}

