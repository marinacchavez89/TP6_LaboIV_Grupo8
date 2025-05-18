package presentacion.vista;

import javax.swing.DefaultListModel;
import javax.swing.JPanel;
import entidad.Persona;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;
import javax.swing.JList;

public class PanelEliminarPersonas extends JPanel{
	
	private JLabel lblTitulo;
	private JButton btnEliminar;
	private JList <Persona> listPersonas;
	private DefaultListModel<Persona> modeloPersonas;

	public PanelEliminarPersonas() {
		setLayout(null);
		
		lblTitulo = new JLabel("Eliminar usuarios");
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTitulo.setBounds(133, 47, 132, 14);
		add(lblTitulo);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(145, 225, 107, 23);
		add(btnEliminar);
		
		this.modeloPersonas = new DefaultListModel<>();
		listPersonas = new JList<>(modeloPersonas);
		listPersonas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listPersonas.setBounds(104, 72, 192, 168);
		add(listPersonas);
		
    }
	 public JButton getBtnEliminar() {
	        return btnEliminar;
	 }
	 
	 public DefaultListModel<Persona>getModelPersonas(){
		 return modeloPersonas;
	 }
	 
	 public JList<Persona> getListaPersonas(){
		 return listPersonas;
	 }
	
}	


