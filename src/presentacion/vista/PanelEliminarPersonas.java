package presentacion.vista;

import javax.swing.DefaultListModel;
import javax.swing.JPanel;
import entidad.Persona;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JList;

public class PanelEliminarPersonas extends JPanel{
	
	private JLabel lblTitulo;
	private JButton btnEliminar;
	private JList listUsuarios;

	public PanelEliminarPersonas(DefaultListModel<Persona> modeloPersonas) {
		setLayout(null);
		
		lblTitulo = new JLabel("Eliminar usuarios");
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTitulo.setBounds(146, 49, 132, 14);
		add(lblTitulo);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(146, 225, 107, 23);
		add(btnEliminar);
		
		listUsuarios = new JList();
		listUsuarios.setBounds(128, 74, 150, 140);
		add(listUsuarios);
		
        // Panel vacio
    }
}	


