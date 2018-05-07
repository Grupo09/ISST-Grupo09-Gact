package es.upm.dit.isst.gestionDoc.dao.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
public class Asignatura implements Serializable {
	
	@Id
	private String codigo;
	private String nombre;
	private String acronimo;
	private String creditos;
	private int curso;
	private int semestre;
	private int grupos;
	private int horasTeoria;
	private int horasPractica;
	private int horasLaboratorio;
	@OneToOne
	private Profesor coordinador;
	@OneToMany(mappedBy="asignatura", fetch = FetchType.EAGER)
	@Fetch(FetchMode.SELECT)
	private List<Asignacion> asignaciones;
	@ManyToOne 
	private PlanEstudios planEstudios;
	@ManyToOne
	private Departamento departamentoAsignatura;
	
	
	public Asignatura() {
		asignaciones = new ArrayList();
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

	public String getCreditos() {
		return creditos;
	}

	public void setCreditos(String string) {
		this.creditos = string;
	}

	public int getCurso() {
		return curso;
	}

	public void setCurso(int curso) {
		this.curso = curso;
	}

	public int getSemestre() {
		return semestre;
	}

	public void setSemestre(int semestre) {
		this.semestre = semestre;
	}

	public int getGrupos() {
		return grupos;
	}

	public void setGrupos(int grupos) {
		this.grupos = grupos;
	}

	public int getHorasTeoria() {
		return horasTeoria;
	}

	public void setHorasTeoria(int horasTeoria) {
		this.horasTeoria = horasTeoria;
	}

	public int getHorasPractica() {
		return horasPractica;
	}

	public void setHorasPractica(int horasPractica) {
		this.horasPractica = horasPractica;
	}

	public int getHorasLaboratorio() {
		return horasLaboratorio;
	}

	public void setHorasLaboratorio(int horasLaboratorio) {
		this.horasLaboratorio = horasLaboratorio;
	}

	public Profesor getCoordinador() {
		return coordinador;
	}

	public void setCoordinador(Profesor coordinador) {
		this.coordinador = coordinador;
	}

	public List<Asignacion> getAsignaciones() {
		return asignaciones;
	}

	public void setAsignaciones(List<Asignacion> asignaciones) {
		this.asignaciones = asignaciones;
	}

	public PlanEstudios getPlanEstudios() {
		return planEstudios;
	}

	public void setPlanEstudios(PlanEstudios planEstudios) {
		this.planEstudios = planEstudios;
	}

	public Departamento getDepartamentoAsignatura() {
		return departamentoAsignatura;
	}

	public void setDepartamentoAsignatura(Departamento departamentoAsignatura) {
		this.departamentoAsignatura = departamentoAsignatura;
	}

	
	
	

}
