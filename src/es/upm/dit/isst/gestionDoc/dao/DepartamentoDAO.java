package es.upm.dit.isst.gestionDoc.dao;

import java.util.List;

import es.upm.dit.isst.gestionDoc.dao.model.Departamento;

public interface DepartamentoDAO {
	
	public void createDepartamento(Departamento departamento);
	public Departamento readDepartamento(String codigo);
	public void updateDepartamento (Departamento departamento);
	public void deleteDepartamento (Departamento departamento);
	public List<Departamento> readAllDepartamento();

}
