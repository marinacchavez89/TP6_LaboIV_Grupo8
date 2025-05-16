package presentacion.vista;

import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JPanel;
import entidad.Persona;
import javax.swing.JTextField;
import javax.swing.JButton;

public class PanelAgregarPersonas extends JPanel {
	
	private JTextField txtNombre;
    private JTextField txtApellido;
    private JTextField txtDni;

	public PanelAgregarPersonas(DefaultListModel<Persona> modeloPersonas) {
		setLayout(null);
        
        // Nombre
        JLabel lblNombre = new JLabel("Nombre:");
        lblNombre.setBounds(51, 63, 80, 25);
        txtNombre = new JTextField(20);
        txtNombre.setBounds(131, 63, 200, 25);
        add(lblNombre);
        add(txtNombre);

        // Apellido
        JLabel lblApellido = new JLabel("Apellido:");
        lblApellido.setBounds(51, 103, 80, 25);
        txtApellido = new JTextField(20);
        txtApellido.setBounds(131, 103, 200, 25);
        add(lblApellido);
        add(txtApellido);

        // DNI
        JLabel lblDni = new JLabel("DNI:");
        lblDni.setBounds(51, 143, 80, 25);
        txtDni = new JTextField(20);
        txtDni.setBounds(131, 143, 200, 25);
        add(lblDni);
        add(txtDni);
        
        JButton btnAceptar = new JButton("Aceptar");
        btnAceptar.setBounds(242, 208, 89, 23);
        add(btnAceptar);
    }
}

