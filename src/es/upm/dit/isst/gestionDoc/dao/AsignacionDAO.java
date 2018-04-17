package es.upm.dit.isst.gestionDoc.dao;

import java.util.List;

import es.upm.dit.isst.gestionDoc.dao.model.Asignacion;
import es.upm.dit.isst.gestionDoc.dao.model.Asignatura;
import es.upm.dit.isst.gestionDoc.dao.model.Profesor;

public interface AsignacionDAO {
	
	public void createAsignacion(Asignacion asignacion);
	public Asignacion readAsociacion(long id);
	public void updateAsignacion(Asignacion asignacion);
	public void deleteAsignacion(Asignacion asignacion);
	public List<Asignatura> readAsignaturas(Profesor profesor);
	public List<Profesor> readProfesor(String codigo);

}

