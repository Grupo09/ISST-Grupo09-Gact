package es.upm.dit.isst.gestionDoc.dao;

import java.util.List;

import es.upm.dit.isst.gestionDoc.dao.model.PlanEstudios;

public interface PlanEstudiosDAO {
	
	public void createPlanEstudios(PlanEstudios planEstudios);
	public PlanEstudios readPlanEstudios(String codigo);
	public void updatePlanEstudios(PlanEstudios planEstudios);
	public void deletePlanEstudios(PlanEstudios planEstudios);
	public List<PlanEstudios> readAll();

}
