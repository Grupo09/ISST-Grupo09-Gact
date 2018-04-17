package es.upm.dit.isst.gestionDoc.dao.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
public class PlanEstudios implements Serializable {
	
	@Id
	private String codigo;
	private String nombre;
	private String acronimo;
	@OneToMany(mappedBy="planEstudios", fetch = FetchType.EAGER)
	@Fetch(FetchMode.SELECT)
	private List<Asignatura> asignaturas;
	
	public PlanEstudios() {
		asignaturas = new ArrayList();
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getAcronimo() {
		return acronimo;
	}

	public void setAcronimo(String acronimo) {
		this.acronimo = acronimo;
	}

	public List<Asignatura> getAsignaturas() {
		return asignaturas;
	}

	public void setAsignaturas(List<Asignatura> asignaturas) {
		this.asignaturas = asignaturas;
	}
	
	

}
