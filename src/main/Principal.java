package main;

import java.awt.EventQueue;
import java.sql.Connection;
import daoImpl.Conexion;




import javax.swing.JFrame;

import presentacion.vista.VentanaPrincipal;

public class Principal extends JFrame {
	
	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
	        EventQueue.invokeLater(new Runnable() {
	            public void run() {
	                try {
	                	System.out.println("Lanzando ventana principal...");
	                    VentanaPrincipal ventanaPrincipal = new VentanaPrincipal();
	                    ventanaPrincipal.setVisible(true);
	                } catch (Exception e) {
	                    e.printStackTrace();
	                }
	            }
	        });
	        Connection con = Conexion.getConexion().getSQLConexion();
	        System.out.println(con != null ? "✅ Conexión OK" : "❌ Conexión fallida");
	    }
}