package one_to_one_primary_key;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity 
@Table(name="ENTRENADOR")
public class Entrenador_primary_key {
	private int id_Entrenador;
	private String nombre;
	private String apellidos;
	private int edad;
	private Equipo_primary_key equipo;

	public Entrenador_primary_key() {
	}

	@Id
	@GeneratedValue(generator = "foreigngen")
    @GenericGenerator(strategy = "foreign", name="foreigngen",
            parameters = @Parameter(name = "property", value="equipo"))
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

	@OneToOne(mappedBy = "entrenador")
	public Equipo_primary_key getEquipo() {
		return equipo;
	}

	public void setEquipo(Equipo_primary_key equipo) {
		this.equipo = equipo;
	}
	
	
}
