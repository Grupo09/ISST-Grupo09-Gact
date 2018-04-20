package es.upm.dit.isst.gestionDoc.dao;

import java.util.List;

import es.upm.dit.isst.gestionDoc.dao.model.Asignatura;
import es.upm.dit.isst.gestionDoc.dao.model.Profesor;

public interface AsignaturaDAO {
	
	public void createAsignatura(Asignatura asignatura);
	public Asignatura readAsignatura(String codigo);
	public void updateAsignatura(Asignatura asignatura);
	public void deleteAsignatura(Asignatura asignatura);
	public List<Asignatura> readAsignaturaCoordinador(Profesor profesor);
	
	// Para hacer un listado de todas las asignaturas
	public List<Asignatura> readAll();

}

