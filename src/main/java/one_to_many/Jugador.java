package one_to_many;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "JUGADOR")
public class Jugador {
	private int id_Jugador;
	private String nombre;
	private String apellidos;
	private int edad;
	private String posicion;
	private Equipo equipo;
	
	public Jugador() {
	}

	@Id
    @Column(name = "ID_JUGADOR")
    @GeneratedValue
	public int getId_Jugador() {
		return id_Jugador;
	}

	public void setId_Jugador(int id_Jugador) {
		this.id_Jugador = id_Jugador;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getPosicion() {
		return posicion;
	}

	public void setPosicion(String posicion) {
		this.posicion = posicion;
	}

	@ManyToOne
    @JoinColumn(name = "ID_EQUIPO")
	public Equipo getEquipo() {
		return equipo;
	}

	public void setEquipo(Equipo equipo) {
		this.equipo = equipo;
	}
}
