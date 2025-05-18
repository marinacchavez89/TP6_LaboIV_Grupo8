package presentacion.vista;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import entidad.Persona;


public class VentanaPrincipal extends JFrame {
	private JMenuBar jMenuBar;
    private JMenu jMenuPersonas;
    private JMenuItem jMenuItemAgregar;
    private JMenuItem jMenuItemListar;
    private JMenuItem jMenuItemModificar;
    private JMenuItem jMenuItemEliminar;
    private JPanel contentPane;
    private DefaultListModel<Persona> modeloPersonas; // modelo compartido
	
	public VentanaPrincipal() {
		// Inicializamos el modelo para las personas
		modeloPersonas = new DefaultListModel<Persona>();
		
        setTitle("Programa");
        setSize(445, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().setLayout(new GridLayout(1, 0, 0, 0));
        
        // Agrega el panel a la ventana que se encuentra declarado en la property.
        contentPane = new JPanel();
        getContentPane().add(contentPane);
        contentPane.setLayout(new GridLayout(1, 0, 0, 0));
        
        jMenuBar = new JMenuBar();
        setJMenuBar(jMenuBar);
        
        jMenuPersonas = new JMenu("Personas");
        jMenuBar.add(jMenuPersonas);

        jMenuItemAgregar = new JMenuItem("Agregar");
        jMenuPersonas.add(jMenuItemAgregar);

        jMenuItemModificar = new JMenuItem("Modificar");
        jMenuPersonas.add(jMenuItemModificar);

        jMenuItemEliminar = new JMenuItem("Eliminar");
        jMenuPersonas.add(jMenuItemEliminar);

        jMenuItemListar = new JMenuItem("Listar");
        jMenuPersonas.add(jMenuItemListar);
        

	}
	
	// Getters para que el controlador pueda agregar listeners y manipular el contenido
    public JMenuItem getMenuAgregar() {
        return jMenuItemAgregar;
    }

    public JMenuItem getMenuModificar() {
        return jMenuItemModificar;
    }
    
    public JMenuItem getMenuEliminar() {
        return jMenuItemEliminar;
    }

    public JMenuItem getMenuListar() {
        return jMenuItemListar;
    }

}