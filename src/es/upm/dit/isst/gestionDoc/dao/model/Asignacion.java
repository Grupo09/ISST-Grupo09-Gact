package es.upm.dit.isst.gestionDoc.dao.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Asignacion implements Serializable {
	
	@Id @GeneratedValue
	private long id;
	private int horasTeoria;
	private int horasPractica;
	private int horasLaboratorio;
	@ManyToOne
	private Profesor profesor;
	@ManyToOne
	private Asignatura asignatura;
	
	public Asignacion() {}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public Profesor getProfesor() {
		return profesor;
	}

	public void setProfesor(Profesor profesor) {
		this.profesor = profesor;
	}

	public Asignatura getAsignatura() {
		return asignatura;
	}

	public void setAsignatura(Asignatura asignatura) {
		this.asignatura = asignatura;
	};
	

}
