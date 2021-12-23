package one_to_one_foreign_key;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity 
@Table(name="ENTRENADOR")
public class Entrenador_foreign_key {
	private int id_Entrenador;
	private String nombre;
	private String apellidos;
	private int edad;
	private Equipo_foreign_key equipo;

	public Entrenador_foreign_key() {
	}

	@Id
    @GeneratedValue
    @Column(name = "ID_ENTRENADOR")
	public int getId_Entrenador() {
		return id_Entrenador;
	}

	public void setId_Entrenador(int id_Entrenador) {
		this.id_Entrenador = id_Entrenador;
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

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="ID_EQUIPO")
	public Equipo_foreign_key getEquipo() {
		return equipo;
	}

	public void setEquipo(Equipo_foreign_key equipo) {
		this.equipo = equipo;
	}
	
	
}
