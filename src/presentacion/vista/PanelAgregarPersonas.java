package presentacion.vista;

import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import entidad.Persona;
import javax.swing.JTextField;
import javax.swing.JButton;

public class PanelAgregarPersonas extends JPanel {
	
	private JTextField txtNombre;
    private JTextField txtApellido;
    private JTextField txtDni;
    private JButton btnAceptar;

    public PanelAgregarPersonas() {
   	
		super();
		initialize();
	}
    
    public void initialize() {
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
        
        btnAceptar = new JButton("Aceptar");
        btnAceptar.setBounds(242, 208, 89, 23);
        add(btnAceptar);
    }
	
	public JButton getBtnAgregar() {
		return btnAceptar;
	}

	public JTextField getTxtNombre() {
		return txtNombre;
	}

	public void setTxtNombre(JTextField txtNombre) {
		this.txtNombre = txtNombre;
	}

	public JTextField getTxtApellido() {
		return txtApellido;
	}

	public void setTxtApellido(JTextField txtApellido) {
		this.txtApellido = txtApellido;
	}

	public JTextField getTxtDni() {
		return txtDni;
	}

	public void setTxtDni(JTextField txtDni) {
		this.txtDni = txtDni;
	}
	
	public void mostrarMensaje(String mensaje)
	{
		JOptionPane.showMessageDialog(null, mensaje);
	}

}

