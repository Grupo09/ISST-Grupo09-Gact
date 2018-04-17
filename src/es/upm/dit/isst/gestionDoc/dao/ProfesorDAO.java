package es.upm.dit.isst.gestionDoc.dao;

import es.upm.dit.isst.gestionDoc.dao.model.Profesor;

public interface ProfesorDAO {
	
	public void createProfesor(Profesor profesor);
	public Profesor readProfesor(String email);
	public void updateProfesor(Profesor profesor);
	public void deleteProfesor(Profesor profesor);
	public Profesor loginProfesor (String email, String password);
	
}
