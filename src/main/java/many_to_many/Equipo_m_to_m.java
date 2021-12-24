package many_to_many;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="EQUIPO")
public class Equipo_m_to_m {
	private int id_Equipo;
	private String nombre;
	private LocalDate fecha_fundacion;
	private String ciudad;
	private Set<Competicion> competiciones = new HashSet<Competicion>();

	public Equipo_m_to_m() {
	}

	public Equipo_m_to_m(String nombre, LocalDate fecha_fundacion, String ciudad) {
		this.nombre = nombre;
		this.fecha_fundacion = fecha_fundacion;
		this.ciudad = ciudad;
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

	public void addCompeticion(Competicion competicion) {
		this.competiciones.add(competicion);
	}
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(
			name = "EQUIPO_COMPETICIONES",
			joinColumns = @JoinColumn(name = "ID_EQUIPO"),
			inverseJoinColumns = @JoinColumn(name = "ID_COMPETICION")
	)
	public Set<Competicion> getCompeticiones() {
		return competiciones;
	}

	public void setCompeticiones(Set<Competicion> competiciones) {
		this.competiciones = competiciones;
	}

}
