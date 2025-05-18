package daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import dao.PersonaDao;
import entidad.Persona;

public class PersonaDaoImpl implements PersonaDao{

	private static final String insert = "INSERT INTO personas(Dni, Nombre, Apellido) VALUES(?, ?, ?)";
	private static final String modificar = "UPDATE personas SET Nombre = ?, Apellido = ? WHERE Dni = ?";
	private static final String selectAll = "SELECT dni, nombre, apellido FROM personas";
	private static final String selectPorDni = "SELECT COUNT(*) AS total FROM personas WHERE Dni = ?";
	
	//agregar
	public boolean insert(Persona persona) {
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isInsertExitoso = false;
		try
		{
			statement = conexion.prepareStatement(insert);
			statement.setString(1, persona.getDni());
			statement.setString(2, persona.getNombre());
			statement.setString(3, persona.getApellido());
			if(statement.executeUpdate() > 0)
			{
				conexion.commit();
				isInsertExitoso = true;
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
			try {
				conexion.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		
		return isInsertExitoso;
	}
	
	// borrar
	public boolean delete(Persona persona_a_eliminar) {
		return false;
	}
	
	// Método readAll
	public List<Persona> readAll() {
	    List<Persona> personas = new ArrayList<>();
	    PreparedStatement statement = null;
	    ResultSet resultSet = null;
	    Connection conexion = Conexion.getConexion().getSQLConexion();

	    try {
	        statement = conexion.prepareStatement(selectAll);
	        resultSet = statement.executeQuery();

	        while (resultSet.next()) {
	            String dni = resultSet.getString("dni");
	            String nombre = resultSet.getString("nombre");
	            String apellido = resultSet.getString("apellido");

	            Persona persona = new Persona(dni, nombre, apellido);
	            personas.add(persona);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            if (resultSet != null) resultSet.close();
	            if (statement != null) statement.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    return personas;
	}
	
	//Modificar
	public boolean modificar(Persona persona) {
		PreparedStatement statement;
	    Connection conexion = Conexion.getConexion().getSQLConexion();
	    boolean modificarExitoso = false;	   

	    try {
	        statement = conexion.prepareStatement(modificar);
	        statement.setString(1, persona.getNombre());
	        statement.setString(2, persona.getApellido());
	        statement.setString(3, persona.getDni());

	        if (statement.executeUpdate() > 0) {
	            conexion.commit();
	            modificarExitoso = true;
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	        try {
	            conexion.rollback();
	        } catch (SQLException e1) {
	            e1.printStackTrace();
	        }
	    }

	    return modificarExitoso;
	}
	
	@Override
	public boolean existePersonaPorDni(String dni) {
	    PreparedStatement statement = null;
	    ResultSet resultSet = null;
	    Connection conexion = Conexion.getConexion().getSQLConexion();
	    boolean existe = false;

	    try {
	        statement = conexion.prepareStatement(selectPorDni);
	        statement.setString(1, dni);
	        resultSet = statement.executeQuery();
	        if (resultSet.next()) {
	            existe = resultSet.getInt("total") > 0;
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            if (resultSet != null) resultSet.close();
	            if (statement != null) statement.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    return existe;
	}
}

