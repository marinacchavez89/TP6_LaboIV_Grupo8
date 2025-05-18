package negocioImpl;

import java.util.ArrayList;
import java.util.List;

import dao.PersonaDao;
import daoImpl.PersonaDaoImpl;
import entidad.Persona;
import negocio.PersonaNegocio;

public class PersonaNegocioImpl implements PersonaNegocio{

	PersonaDao pdao = new PersonaDaoImpl();
	
	@Override
	public boolean insert(Persona persona){
		
		 boolean estado = false;
		 
		    try {
		    	if (persona.getNombre().trim().length() > 0 && 
		        		persona.getApellido().trim().length() > 0 &&
		        		persona.getDni().trim().length() > 0 ) {
		    		
		    		 // Validar si ya existe una persona con ese DNI
		            List<Persona> personasExistentes = pdao.readAll();
		            boolean dniExiste = personasExistentes.stream()
		                                    .anyMatch(p -> p.getDni().equals(persona.getDni()));
		            
		            if (dniExiste) {
		                System.out.println("Ya existe una persona con el DNI: " + persona.getDni());
		                return false;
		            }
		            
		            // Si no existe, insertamos
		            estado = pdao.insert(persona);
		        }
		    } catch (Exception e) {
		        System.out.println("Error al insertar la persona: " + e.getMessage());
		        estado = false;
		    }
		    return estado;
	}
	
	@Override
	public List<Persona> readAll() {
	    List<Persona> personas = new ArrayList<>();
	    try {
	        personas = pdao.readAll();
	    } catch (Exception e) {
	        System.out.println("Error al leer personas: " + e.getMessage());
	    }
	    return personas;
	}
	
	@Override
	public boolean modificar(Persona persona){
		
		 boolean estado = false;
		    try {
		        if (persona.getNombre().trim().length() > 0 && 
	        		persona.getApellido().trim().length() > 0 &&
	        		persona.getDni().trim().length() > 0 ) {
		            estado = pdao.modificar(persona);
		        }
		    } catch (Exception e) {
		        System.out.println("Error al modificar la persona: " + e.getMessage());
		        estado = false;
		    }
		    return estado;
	}
}