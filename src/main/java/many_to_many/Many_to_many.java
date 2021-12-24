package many_to_many;

import java.time.LocalDate;

import org.hibernate.Session;
import org.hibernate.Transaction;

import conexion.Hibernate_Util;

public class Many_to_many {
	public static void main(String[] args) {
		try (Session s= Hibernate_Util.getSessionFactory().openSession()){
			Transaction t = null;
			try {
				t = s.beginTransaction();
				Equipo_m_to_m equipo1 = new Equipo_m_to_m("Real_Madrdid", LocalDate.of(1902, 3, 6), "Madrid");
				Equipo_m_to_m equipo2 = new Equipo_m_to_m("FC Barcelona", LocalDate.of(1899, 11, 29), "Barcelona");
		        Equipo_m_to_m equipo3 = new Equipo_m_to_m("Atletico de Mdrid", LocalDate.of(1903, 4, 26), "Madrid");

		        Competicion competicion1 = new Competicion("La Liga Santander", LocalDate.of(2021, 8, 13), 60000000);
		        Competicion competicion2 = new Competicion("Champions League", LocalDate.of(2021, 9, 14), 82000000);
		        Competicion competicion3 = new Competicion("Copa Del Rey", LocalDate.of(2021, 11, 17), 40000000);

		        equipo1.addCompeticion(competicion1);
		        equipo1.addCompeticion(competicion2);
		        equipo1.addCompeticion(competicion3);
		        
		        equipo2.addCompeticion(competicion1);
		        equipo2.addCompeticion(competicion3);
		        
		        equipo3.addCompeticion(competicion1);
		        equipo3.addCompeticion(competicion2);
		        
		        competicion1.addEquipo(equipo1);
		        competicion1.addEquipo(equipo2);
		        competicion1.addEquipo(equipo3);
		        
		        competicion2.addEquipo(equipo1);
		        competicion2.addEquipo(equipo3);
		        
		        competicion3.addEquipo(equipo1);
		        competicion3.addEquipo(equipo2);
		        
		        s.save(equipo1);
		        s.save(equipo2);
		        s.save(equipo3);
		        
		        s.getTransaction().commit();
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
