package one_to_many;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="EQUIPO")
public class Equipo {
	private int id_Equipo;
	private String nombre;
	private LocalDate fecha_fundacion;
	private String ciudad;
	private Set<Jugador> jugadores;

	public Equipo() {
	}

	@Id
    @GeneratedValue
    @Column(name = "ID_EQUIPO")
	public int getId_Equipo() {
		return id_Equipo;
	}

	public void setId_Equipo(int id_Equipo) {
		this.id_Equipo = id_Equipo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public LocalDate getFecha_fundacion() {
		return fecha_fundacion;
	}

	public void setFecha_fundacion(LocalDate fecha_fundacion) {
		this.fecha_fundacion = fecha_fundacion;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	@OneToMany(mappedBy = "equipo", cascade = CascadeType.ALL)
	public Set<Jugador> getJugadores() {
		return jugadores;
	}

	public void setJugadores(Set<Jugador> jugadores) {
		this.jugadores = jugadores;
	}
	
}
