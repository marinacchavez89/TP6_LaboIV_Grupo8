package presentacion.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import entidad.Persona;
import negocio.PersonaNegocio;
import presentacion.vista.PanelAgregarPersonas;
import presentacion.vista.PanelEliminarPersonas;
import presentacion.vista.VentanaPrincipal;


public class Controlador implements ActionListener {

	private VentanaPrincipal ventanaPrincipal;
	private PanelAgregarPersonas pnlIngresoPersonas;
	private PanelEliminarPersonas pnlEliminarPersonas;
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
		
		//Enlazo todos los eventos
		
		//Eventos menu del Frame principal llamado Ventana
		this.ventanaPrincipal.getMenuAgregar().addActionListener(a->EventoClickMenu_AbrirPanel_AgregarPersona(a));

		//Eventos PanelAgregarPersonas
		 this.pnlIngresoPersonas.getBtnAgregar().addActionListener(a->EventoClickBoton_AgregarPesona_PanelAgregarPersonas(a));
		 
	}
	
	//EventoClickMenu abrir PanelAgregarPersonas
	public void  EventoClickMenu_AbrirPanel_AgregarPersona(ActionEvent a)
	{		
		ventanaPrincipal.getContentPane().removeAll();
		ventanaPrincipal.getContentPane().add(pnlIngresoPersonas);
		ventanaPrincipal.getContentPane().repaint();
		ventanaPrincipal.getContentPane().revalidate();
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
		
		boolean estado = pNeg.insert(nuevaPersona);
		String mensaje;
		if(estado==true)
		{
			mensaje="Persona agregada con exito";
			this.pnlIngresoPersonas.getTxtDni().setText("");
			this.pnlIngresoPersonas.getTxtNombre().setText("");
			this.pnlIngresoPersonas.getTxtApellido().setText("");
		}
		else
			mensaje="Persona no agregada, complete todos los campos";
		
		this.pnlIngresoPersonas.mostrarMensaje(mensaje);	
	}

	
	public void inicializar()
	{
		this.ventanaPrincipal.setVisible(true);
	}
	

	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
