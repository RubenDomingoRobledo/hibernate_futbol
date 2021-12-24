package many_to_many;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "COMPETICION")
public class Competicion {
	private int id_Competicion;
	private String nombre;
	private LocalDate fechaInicio;
	private int cantidadPremio;
	private Set<Equipo_m_to_m> equipos = new HashSet<Equipo_m_to_m>();
	
	public Competicion() {
	}

	public Competicion(String nombre, LocalDate fechaInicio, int cantidadPremio) {
		this.nombre = nombre;
		this.fechaInicio = fechaInicio;
		this.cantidadPremio = cantidadPremio;
	}
	
	@Id
    @GeneratedValue
    @Column(name = "ID_COMPETICION")
	public int getId_Competicion() {
		return id_Competicion;
	}

	public void setId_Competicion(int id_Competicion) {
		this.id_Competicion = id_Competicion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public LocalDate getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(LocalDate fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public int getCantidadPremio() {
		return cantidadPremio;
	}

	public void setCantidadPremio(int cantidadPremio) {
		this.cantidadPremio = cantidadPremio;
	}
	
	public void addEquipo(Equipo_m_to_m equipo) {
		this.equipos.add(equipo);
	}

	@ManyToMany(mappedBy = "competiciones")
	public Set<Equipo_m_to_m> getEquipos() {
		return equipos;
	}

	public void setEquipos(Set<Equipo_m_to_m> equipos) {
		this.equipos = equipos;
	}	
}
