package one_to_many;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;

import conexion.Hibernate_Util;

public class Many_to_one {
	public static void main(String[] args) {
		try (Session s= Hibernate_Util.getSessionFactory().openSession()){
			Transaction t = null;
			try {
				t = s.beginTransaction();
				Equipo_1_to_m equipo1 = new Equipo_1_to_m("Real_Madrdid", LocalDate.of(1902, 3, 6), "Madrid");
				Jugador jugador1_1 = new Jugador("David", "Alaba", 29, "Defensa");
				Jugador jugador1_2 = new Jugador("Luka", "Modric", 36, "Mediocentro");
				Jugador jugador1_3 = new Jugador("Vinicius", "Junior", 21, "Delantero");
				Jugador jugador1_4 = new Jugador("Karim", "Benzema", 34, "Delantero");
			
				Set<Jugador> jugadores1 = new HashSet<Jugador>();
				jugadores1.add(jugador1_1);
				jugadores1.add(jugador1_2);
				jugadores1.add(jugador1_3);
				jugadores1.add(jugador1_4);
				
				equipo1.setJugadores(jugadores1);
		        s.save(equipo1);
		        
		        Equipo_1_to_m equipo2 = new Equipo_1_to_m("FC Barcelona", LocalDate.of(1899, 11, 29), "Barcelona");
				Jugador jugador2_1 = new Jugador("Gerard", "Pique", 34, "Defensa");
				Jugador jugador2_2 = new Jugador("Frenkie", "De Jong", 24, "Mediocentro");
				Jugador jugador2_3 = new Jugador("Pablo", "Gavi", 17, "Mediocentro");
				Jugador jugador2_4 = new Jugador("Memphis", "Depay", 27, "Delantero");
			
				Set<Jugador> jugadores2 = new HashSet<Jugador>();
				jugadores2.add(jugador2_1);
				jugadores2.add(jugador2_2);
				jugadores2.add(jugador2_3);
				jugadores2.add(jugador2_4);
				
				equipo2.setJugadores(jugadores2);
		        s.save(equipo2);
		        
		        Equipo_1_to_m equipo3 = new Equipo_1_to_m("Atletico de Mdrid", LocalDate.of(1903, 4, 26), "Madrid");
				Jugador jugador3_1 = new Jugador("Jose Maria", "Giménez", 26, "Defensa");
				Jugador jugador3_2 = new Jugador("Marcos", "Llorente", 26, "Mediocentro");
				Jugador jugador3_3 = new Jugador("Yannick", "Carrasco", 28, "Mediocentro");
				Jugador jugador3_4 = new Jugador("Luis", "Suárez", 34, "Delantero");
			
				Set<Jugador> jugadores3 = new HashSet<Jugador>();
				jugadores3.add(jugador3_1);
				jugadores3.add(jugador3_2);
				jugadores3.add(jugador3_3);
				jugadores3.add(jugador3_4);
				
				equipo3.setJugadores(jugadores3);
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
