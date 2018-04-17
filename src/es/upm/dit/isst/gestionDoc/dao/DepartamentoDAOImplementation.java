package es.upm.dit.isst.gestionDoc.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import es.upm.dit.isst.gestionDoc.dao.model.Departamento;
import es.upm.dit.isst.gestionDoc.dao.SessionFactoryService;


public class DepartamentoDAOImplementation implements DepartamentoDAO {
	
	public static DepartamentoDAOImplementation instance;

	private DepartamentoDAOImplementation() {
	}

	public static DepartamentoDAOImplementation getInstance() {
		if (null == instance)
			instance = new DepartamentoDAOImplementation();
		return instance;
	}

	@Override
	public void createDepartamento(Departamento departamento) {
		Session session = SessionFactoryService.get().openSession();
		try {
			session.beginTransaction();
			session.save(departamento);
			session.getTransaction().commit();
		} catch (Exception e) {
		} finally {
			session.close();
		}
		
	}

	@Override
	public Departamento readDepartamento(String codigo) {
		Session session = SessionFactoryService.get().openSession();
		Departamento departamento = null;
		try {
			departamento = session.get(Departamento.class, codigo);
		} catch (Exception e) {
		} finally {
			session.close();
		}
		return departamento;
	}

	@Override
	public void updateDepartamento(Departamento departamento) {
		Session session = SessionFactoryService.get().openSession();
		try {
			session.beginTransaction();
			session.saveOrUpdate(departamento);
			session.getTransaction().commit();
		} catch (Exception e) {
		} finally {
			session.close();
		}		
	}

	@Override
	public void deleteDepartamento(Departamento departamento) {
		Session session = SessionFactoryService.get().openSession();
		try {
			session.beginTransaction();
			session.delete(departamento);
			session.getTransaction().commit();
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			session.close();
		}		
	}

	@Override
	public List<Departamento> readAllDepartamento() {
		Session session = SessionFactoryService.get().openSession();
		List<Departamento> departamentos = new ArrayList<>();
		try {
			session.beginTransaction();
			departamentos.addAll(session.createQuery("from Departamento").getResultList());
			session.getTransaction().commit();
		} catch (Exception e) {
		} finally {
			session.close();
		}
		
		return departamentos;
	}
	
	

}
