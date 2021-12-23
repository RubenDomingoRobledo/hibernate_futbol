package one_to_one_primary_key;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="EQUIPO")
public class Equipo_primary_key {
	private int id_Equipo;
	private String nombre;
	private Date fecha_fundacion;
	private String ciudad;
	private Entrenador_primary_key entrenador;

	public Equipo_primary_key() {
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

	public Date getFecha_fundacion() {
		return fecha_fundacion;
	}

	public void setFecha_fundacion(Date fecha_fundacion) {
		this.fecha_fundacion = fecha_fundacion;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	@OneToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
	public Entrenador_primary_key getEntrenador() {
		return entrenador;
	}

	public void setEntrenador(Entrenador_primary_key entrenador) {
		this.entrenador = entrenador;
	}
}