package one_to_one_primary_key;

import java.time.LocalDate;

import org.hibernate.Session;
import org.hibernate.Transaction;

import conexion.Hibernate_Util;

public class One_to_one_primary_key {
	public static void main(String[] args) {
		try (Session s = Hibernate_Util.getSessionFactory().openSession()) {
			Transaction t = null;
		      
			try {
				t = s.beginTransaction();
		        Equipo_primary_key equipo1 = new Equipo_primary_key();
		        equipo1.setNombre("Real_Madrdid");
		        equipo1.setFecha_fundacion(LocalDate.of(1902, 3, 6));
		        equipo1.setCiudad("Madrid");
		        
		        Entrenador_primary_key entrenador1 = new Entrenador_primary_key();
		        entrenador1.setNombre("Carlo");
		        entrenador1.setApellidos("Ancelotti");
		        entrenador1.setEdad(62);
		        
		        equipo1.setEntrenador(entrenador1);
		        entrenador1.setEquipo(equipo1);
		        
		        s.save(equipo1);
		        
		        Equipo_primary_key equipo2 = new Equipo_primary_key();
		        equipo2.setNombre("FC Barcelona");
		        equipo2.setFecha_fundacion(LocalDate.of(1899, 11, 29));
		        equipo2.setCiudad("Barcelona");
		        
		        Entrenador_primary_key entrenador2 = new Entrenador_primary_key();
		        entrenador2.setNombre("Xavi");
		        entrenador2.setApellidos("Hernandez");
		        entrenador2.setEdad(41);
		        
		        equipo2.setEntrenador(entrenador2);
		        entrenador2.setEquipo(equipo2);
		        
		        s.save(equipo2);
		        
		        Equipo_primary_key equipo3 = new Equipo_primary_key();
		        equipo3.setNombre("Atletico de Madrid");
		        equipo3.setFecha_fundacion(LocalDate.of(1903, 4, 26));
		        equipo3.setCiudad("Madrid");
		        
		        Entrenador_primary_key entrenador3 = new Entrenador_primary_key();
		        entrenador3.setNombre("Diego Pablo");
		        entrenador3.setApellidos("Simeone");
		        entrenador3.setEdad(51);
		        
		        equipo3.setEntrenador(entrenador3);
		        entrenador3.setEquipo(equipo3);
		        
		        s.save(equipo3);
		   
		        t.commit();
		        s.close();
			}
			catch (Exception e) {
		 	  e.printStackTrace(System.err);
		   	  	if (t != null) {
	    		  t.rollback();
		   	  	}
			}
		}
	}
}
