package es.upm.dit.isst.gestionDoc.dao;


import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import es.upm.dit.isst.gestionDoc.dao.model.PlanEstudios;
import es.upm.dit.isst.gestionDoc.dao.SessionFactoryService;

public class PlanEstudiosDAOImplementation implements PlanEstudiosDAO {

	public static PlanEstudiosDAOImplementation instance;

	private PlanEstudiosDAOImplementation() {
	}

	public static PlanEstudiosDAOImplementation getInstance() {
		if (null == instance)
			instance = new PlanEstudiosDAOImplementation();
		return instance;
	}

	@Override
	public void createPlanEstudios(PlanEstudios planEstudios) {
		Session session = SessionFactoryService.get().openSession();
		try {
			session.beginTransaction();
			session.save(planEstudios);
			session.getTransaction().commit();
		} catch (Exception e) {
		} finally {
			session.close();
		}
		
	}

	@Override
	public PlanEstudios readPlanEstudios(String codigo) {
		Session session = SessionFactoryService.get().openSession();
		PlanEstudios planEstudios = null;
		try {
			planEstudios = session.get(PlanEstudios.class, codigo);
		} catch (Exception e) {
		} finally {
			session.close();
		}
		return planEstudios;
	}

	@Override
	public void updatePlanEstudios(PlanEstudios planEstudios) {
		Session session = SessionFactoryService.get().openSession();
		try {
			session.beginTransaction();
			session.saveOrUpdate(planEstudios);
			session.getTransaction().commit();
		} catch (Exception e) {
		} finally {
			session.close();
		}		
		
	}

	@Override
	public void deletePlanEstudios(PlanEstudios planEstudios) {
		Session session = SessionFactoryService.get().openSession();
		try {
			session.beginTransaction();
			session.delete(planEstudios);
			session.getTransaction().commit();
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			session.close();
		}		
		
	}

	@Override
	public List<PlanEstudios> readAll() {
		Session session = SessionFactoryService.get().openSession();
		List<PlanEstudios> planEstudios = new ArrayList<>();
		try {
			session.beginTransaction();
			planEstudios.addAll(session.createQuery("from PlanEstudios").getResultList());
			session.getTransaction().commit();
		} catch (Exception e) {
		} finally {
			session.close();
		}
		
		return planEstudios;
	}
	

}
