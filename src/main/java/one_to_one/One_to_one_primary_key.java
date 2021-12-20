package one_to_one;

import org.hibernate.Session;
import org.hibernate.Transaction;

import conexion.Hibernate_Util;

public class One_to_one_primary_key {
	public static void main(String[] args) {
		try (Session s = Hibernate_Util.getSessionFactory().openSession()) {
		      Transaction t = null;
		      
		      try {
		        t = s.beginTransaction();
		        Equipo equipo1 = new Equipo();
		        equipo1.setNombre("Real_Madrdid");
		        equipo1.setFecha_fundacion("06-03-1902");
		        equipo1.setCiudad("Madrid");
		        
		        Entrenador entrenador1 = new Entrenador();
		        entrenador1.setNombre("Carlo");
		        entrenador1.setApellidos("Ancelotti");
		        entrenador1.setEdad(62);
		        
		        equipo1.setEntrenador(entrenador1);
		        entrenador1.setEquipo(equipo1);
		        
		        Equipo equipo2 = new Equipo();
		        equipo2.setNombre("FC Barcelona");
		        equipo2.setFecha_fundacion("29-11-1899");
		        equipo2.setCiudad("Barcelona");
		        
		        Entrenador entrenador2 = new Entrenador();
		        entrenador2.setNombre("Xavi");
		        entrenador2.setApellidos("Hernandez");
		        entrenador2.setEdad(41);
		        
		        equipo2.setEntrenador(entrenador2);
		        entrenador2.setEquipo(equipo2);
		        
		        Equipo equipo3 = new Equipo();
		        equipo3.setNombre("Atletico de Madrid");
		        equipo3.setFecha_fundacion("26-04-1903");
		        equipo3.setCiudad("Madrid");
		        
		        Entrenador entrenador3 = new Entrenador();
		        entrenador3.setNombre("Diego Pablo");
		        entrenador3.setApellidos("Simeone");
		        entrenador3.setEdad(51);
		        
		        equipo3.setEntrenador(entrenador3);
		        entrenador3.setEquipo(equipo3);
		   
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
