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
        lblNombre.setBounds(20, 20, 80, 25);
        txtNombre = new JTextField(20);
        txtNombre.setBounds(100, 20, 200, 25);
        add(lblNombre);
        add(txtNombre);

        // Apellido
        JLabel lblApellido = new JLabel("Apellido:");
        lblApellido.setBounds(20, 60, 80, 25);
        txtApellido = new JTextField(20);
        txtApellido.setBounds(100, 60, 200, 25);
        add(lblApellido);
        add(txtApellido);

        // DNI
        JLabel lblDni = new JLabel("DNI:");
        lblDni.setBounds(20, 100, 80, 25);
        txtDni = new JTextField(20);
        txtDni.setBounds(100, 100, 200, 25);
        add(lblDni);
        add(txtDni);
    }
}

