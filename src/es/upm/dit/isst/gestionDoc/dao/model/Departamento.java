package es.upm.dit.isst.gestionDoc.dao.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
public class Departamento implements Serializable {

	@Id
	private String codigo;
	private String acronimo;
	private String nombre;
	@OneToOne
	private Profesor responsable;
	@OneToMany(mappedBy = "departamento", fetch = FetchType.EAGER)
	@Fetch(FetchMode.SELECT)
	private List<Profesor> profesores;
	@OneToMany(mappedBy = "departamentoAsignatura", fetch = FetchType.EAGER)
	@Fetch(FetchMode.SELECT)
	private List<Asignatura> asignatura;

	public Departamento() {
		profesores = new ArrayList();
		asignatura = new ArrayList();
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getAcronimo() {
		return acronimo;
	}

	public void setAcronimo(String acronimo) {
		this.acronimo = acronimo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Profesor getResponsable() {
		return responsable;
	}

	public void setResponsable(Profesor responsable) {
		this.responsable = responsable;
	}

	public List<Profesor> getProfesores() {
		return profesores;
	}

	public void setProfesores(List<Profesor> profesores) {
		this.profesores = profesores;
	}
	public List<Asignatura> getAsignaturas(){
		return this.asignatura;
	}

}
