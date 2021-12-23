package one_to_one_foreign_key;

import org.hibernate.Session;
import org.hibernate.Transaction;

import conexion.Hibernate_Util;

public class One_to_one_foreign_key {
	public static void main(String[] args) {
		try (Session s = Hibernate_Util.getSessionFactory().openSession()) {
			Transaction t = null;
		      
			try {
				t = s.beginTransaction();
		        Equipo_foreign_key equipo1 = new Equipo_foreign_key();
		        equipo1.setNombre("Real_Madrdid");
		        equipo1.setFecha_fundacion("06-03-1902");
		        equipo1.setCiudad("Madrid");
		        
		        Entrenador_foreign_key entrenador1 = new Entrenador_foreign_key();
		        entrenador1.setNombre("Carlo");
		        entrenador1.setApellidos("Ancelotti");
		        entrenador1.setEdad(62);
		        entrenador1.setEquipo(equipo1);
		     
		        s.save(entrenador1);
		        
		        Equipo_foreign_key equipo2 = new Equipo_foreign_key();
		        equipo2.setNombre("FC Barcelona");
		        equipo2.setFecha_fundacion("29-11-1899");
		        equipo2.setCiudad("Barcelona");
		        
		        Entrenador_foreign_key entrenador2 = new Entrenador_foreign_key();
		        entrenador2.setNombre("Xavi");
		        entrenador2.setApellidos("Hernandez");
		        entrenador2.setEdad(41);
		        entrenador2.setEquipo(equipo2);
		     
		        s.save(entrenador2);
		        
		        Equipo_foreign_key equipo3 = new Equipo_foreign_key();
		        equipo3.setNombre("Atletico de Madrid");
		        equipo3.setFecha_fundacion("26-04-1903");
		        equipo3.setCiudad("Madrid");
		        
		        Entrenador_foreign_key entrenador3 = new Entrenador_foreign_key();
		        entrenador3.setNombre("Diego Pablo");
		        entrenador3.setApellidos("Simeone");
		        entrenador3.setEdad(51);
		        entrenador3.setEquipo(equipo3);
		     
		        s.save(entrenador3);
		   
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
