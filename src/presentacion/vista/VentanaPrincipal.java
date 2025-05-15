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

import entidad.PanelAgregarPersonas;
import entidad.PanelListarPersonas;
import entidad.Persona;


public class VentanaPrincipal extends JFrame {
	private JMenuBar JmenuBar;
	private JMenu JMenuPersonas;
	private JMenuItem JMenuItemAgregar;
	private JMenuItem JMenuItemListar;
	private JPanel contentPane;
	private DefaultListModel<Persona> modeloPersonas; // modelo compartido entre paneles
	
	public VentanaPrincipal() {
		// Inicializamos el modelo para las películas
		modeloPersonas = new DefaultListModel<Persona>();
		
        setTitle("Programa");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().setLayout(new GridLayout(1, 0, 0, 0));
        
        // Agrega el panel a la ventana que se encuentra declarado en la property.
        contentPane = new JPanel();
        getContentPane().add(contentPane);
        contentPane.setLayout(new GridLayout(1, 0, 0, 0));
        
        JmenuBar = new JMenuBar();
        setJMenuBar(JmenuBar);
        
        JMenuPersonas = new JMenu("Personas");
        JmenuBar.add(JMenuPersonas);
        
        JMenuItemAgregar = new JMenuItem("Agregar");
        JMenuItemAgregar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
                contentPane.removeAll();
                PanelAgregarPersonas panelAgregarPersona = new PanelAgregarPersonas(modeloPersonas); // se pasa el modelo
                contentPane.add(panelAgregarPersona);
                contentPane.revalidate();
                contentPane.repaint();
            }
        });
       
        JMenuPersonas.add(JMenuItemAgregar);
                
        JMenuItemListar = new JMenuItem("Listar");
        JMenuItemListar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		// Cambiar el panel a ListarPeliculas				
        		contentPane.removeAll();
				PanelListarPersonas panelListar = new PanelListarPersonas(modeloPersonas);  // Pasamos el modelo
				contentPane.add(panelListar);
				contentPane.revalidate();
				contentPane.repaint();
        	}        	
        });
      
        JMenuPersonas.add(JMenuItemListar);
        
	}
}