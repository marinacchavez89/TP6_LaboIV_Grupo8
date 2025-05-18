package presentacion.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import entidad.Persona;
import negocio.PersonaNegocio;
import presentacion.vista.PanelAgregarPersonas;
import presentacion.vista.PanelEliminarPersonas;
import presentacion.vista.PanelModificarPersonas;
import presentacion.vista.VentanaPrincipal;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class Controlador implements ActionListener {

	private VentanaPrincipal ventanaPrincipal;
	private PanelAgregarPersonas pnlIngresoPersonas;
	private PanelEliminarPersonas pnlEliminarPersonas;
	private PanelModificarPersonas pnlModificarPersonas;
	private PersonaNegocio pNeg;
	private ArrayList<Persona> personasEnTabla;
	
	//Constructor
	public Controlador(VentanaPrincipal vista, PersonaNegocio pNeg)
	{
		//Guardo todas las instancias que recibo en el constructor
		this.ventanaPrincipal = vista;
		this.pNeg = pNeg;
		
		//Instancio los paneles
		this.pnlIngresoPersonas = new PanelAgregarPersonas();
		this.pnlModificarPersonas = new PanelModificarPersonas();
		
		//Enlazo todos los eventos
		
		//Eventos menu del Frame principal llamado Ventana
		this.ventanaPrincipal.getMenuAgregar().addActionListener(a->EventoClickMenu_AbrirPanel_AgregarPersona(a));
		this.ventanaPrincipal.getMenuModificar().addActionListener(a->EventoClickMenu_AbrirPanel_ModificarPersona(a));


		//Eventos PanelAgregarPersonas
		this.pnlIngresoPersonas.getBtnAgregar().addActionListener(a->EventoClickBoton_AgregarPesona_PanelAgregarPersonas(a));
		
		// Evento para modificar persona
		this.pnlModificarPersonas.getBtnModificar().addActionListener(a -> EventoClickBoton_ModificarPersona_PanelModificarPersonas(a));
		
		// Evento al seleccionar una persona de la lista
		this.pnlModificarPersonas.getListaPersonas().addListSelectionListener(e -> {
			Persona seleccionada = pnlModificarPersonas.getListaPersonas().getSelectedValue();
			if (seleccionada != null) {
				pnlModificarPersonas.getTxtDni().setText(seleccionada.getDni());
				pnlModificarPersonas.getTxtNombre().setText(seleccionada.getNombre());
				pnlModificarPersonas.getTxtApellido().setText(seleccionada.getApellido());
				pnlModificarPersonas.getTxtDni().setEditable(false); // No permitir editar DNI
			}
		});
		
		// Validación de solo letras para nombre y apellido
		this.pnlIngresoPersonas.getTxtNombre().addKeyListener(new KeyAdapter() {
		    public void keyTyped(KeyEvent e) {
		        char c = e.getKeyChar();
		        if (!Character.isLetter(c) && !Character.isWhitespace(c)) {
		            e.consume(); // Evita que se escriban caracteres no válidos
		        }
		    }
		});

		this.pnlIngresoPersonas.getTxtApellido().addKeyListener(new KeyAdapter() {
		    public void keyTyped(KeyEvent e) {
		        char c = e.getKeyChar();
		        if (!Character.isLetter(c) && !Character.isWhitespace(c)) {
		            e.consume();
		        }
		    }
		});

		// Validación de solo números para DNI
		this.pnlIngresoPersonas.getTxtDni().addKeyListener(new KeyAdapter() {
		    public void keyTyped(KeyEvent e) {
		        char c = e.getKeyChar();
		        if (!Character.isDigit(c)) {
		            e.consume();
		        }
		    }
		});
	}
	
	//EventoClickMenu abrir PanelAgregarPersonas
	public void  EventoClickMenu_AbrirPanel_AgregarPersona(ActionEvent a)
	{		
		ventanaPrincipal.getContentPane().removeAll();
		ventanaPrincipal.getContentPane().add(pnlIngresoPersonas);
		ventanaPrincipal.getContentPane().repaint();
		ventanaPrincipal.getContentPane().revalidate();
	}
	
	public void EventoClickMenu_AbrirPanel_ModificarPersona(ActionEvent a) {
		ventanaPrincipal.getContentPane().removeAll();
		ventanaPrincipal.getContentPane().add(pnlModificarPersonas);
		ventanaPrincipal.getContentPane().repaint();
		ventanaPrincipal.getContentPane().revalidate();

		cargarListaPersonas(); // Llenamos la lista
	}
	
	//EventoClickMenu abrir PanelEliminarPersonas
	public void EventoClickMenu_AbrirPanel_EliminarPersona(ActionEvent a)
	{		
		ventanaPrincipal.getContentPane().removeAll();
		ventanaPrincipal.getContentPane().add(pnlEliminarPersonas);
		ventanaPrincipal.getContentPane().repaint();
		ventanaPrincipal.getContentPane().revalidate();
	}

	//EventoClickBoton agregar persona en PanelAgregarPersonas
	private void EventoClickBoton_AgregarPesona_PanelAgregarPersonas(ActionEvent a) {
		
		String dni = this.pnlIngresoPersonas.getTxtDni().getText();
		String nombre = this.pnlIngresoPersonas.getTxtNombre().getText();
		String ape = this.pnlIngresoPersonas.getTxtApellido().getText();
		Persona nuevaPersona = new Persona(dni, nombre, ape);
		
		 String mensaje;
		 
	    // Validación de campos vacíos
	    if (dni.trim().isEmpty() || nombre.trim().isEmpty() || ape.trim().isEmpty()) {
	        mensaje = "Persona no agregada, complete todos los campos.";
	    } else {
	        try {
	            boolean estado = pNeg.insert(nuevaPersona);
	            if (estado) {
	                mensaje = "Persona agregada con éxito.";
	                this.pnlIngresoPersonas.getTxtDni().setText("");
	                this.pnlIngresoPersonas.getTxtNombre().setText("");
	                this.pnlIngresoPersonas.getTxtApellido().setText("");
	            } else {
	                mensaje = "No se pudo agregar la persona: DNI ya existente.";
	            }
	        } catch (Exception ex) {
	            mensaje = "Error al intentar agregar la persona: " + ex.getMessage();
	            // Opcional: ex.printStackTrace();
	        }
	    }

	    this.pnlIngresoPersonas.mostrarMensaje(mensaje);
	}
	
	private void EventoClickBoton_ModificarPersona_PanelModificarPersonas(ActionEvent a) {
		String dni = pnlModificarPersonas.getTxtDni().getText();
		String nombre = pnlModificarPersonas.getTxtNombre().getText();
		String apellido = pnlModificarPersonas.getTxtApellido().getText();

		if (dni.trim().isEmpty() || nombre.trim().isEmpty() || apellido.trim().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Complete todos los campos para modificar.");
			return;
		}

		Persona personaModificada = new Persona(dni, nombre, apellido);

		if (pNeg.modificar(personaModificada)) {
			JOptionPane.showMessageDialog(null, "Persona modificada con éxito.");
			cargarListaPersonas(); // Refrescamos lista
		} else {
			JOptionPane.showMessageDialog(null, "Error al modificar la persona.");
		}
	}
	
	public void inicializar()
	{
		this.ventanaPrincipal.setVisible(true);
	}
	
	private void cargarListaPersonas() {
		pnlModificarPersonas.getModeloPersonas().clear();
		for (Persona p : pNeg.readAll()) {
			pnlModificarPersonas.getModeloPersonas().addElement(p);
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
