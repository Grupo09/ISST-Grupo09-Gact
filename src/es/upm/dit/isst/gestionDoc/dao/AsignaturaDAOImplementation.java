package es.upm.dit.isst.gestionDoc.dao;

import es.upm.dit.isst.gestionDoc.dao.model.Asignatura;
import es.upm.dit.isst.gestionDoc.dao.model.Profesor;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import es.upm.dit.isst.gestionDoc.dao.SessionFactoryService;

public class AsignaturaDAOImplementation implements AsignaturaDAO {

	public static AsignaturaDAOImplementation instance;

	private AsignaturaDAOImplementation() {
	}

	public static AsignaturaDAOImplementation getInstance() {
		if (null == instance)
			instance = new AsignaturaDAOImplementation();
		return instance;
	}

	@Override
	public void createAsignatura(Asignatura asignatura) {
		Session session = SessionFactoryService.get().openSession();
		try {
			session.beginTransaction();
			session.save(asignatura);
			session.getTransaction().commit();
		} catch (Exception e) {
		} finally {
			session.close();
		}
		
	}

	@Override
	public Asignatura readAsignatura(String codigo) {
		Session session = SessionFactoryService.get().openSession();
		Asignatura asignatura = null;
		try {
			asignatura = session.get(Asignatura.class, codigo);
		} catch (Exception e) {
		} finally {
			session.close();
		}
		return asignatura;
	}

	@Override
	public void updateAsignatura(Asignatura asignatura) {
		Session session = SessionFactoryService.get().openSession();
		try {
			session.beginTransaction();
			session.saveOrUpdate(asignatura);
			session.getTransaction().commit();
		} catch (Exception e) {
		} finally {
			session.close();
		}		
		
	}

	@Override
	public void deleteAsignatura(Asignatura asignatura) {
		Session session = SessionFactoryService.get().openSession();
		try {
			session.beginTransaction();
			System.out.println("Eliminado asignatura");
			session.delete(asignatura);
			session.getTransaction().commit();
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			session.close();
		}		
		
	}

	@Override
	public List<Asignatura> readAsignaturaCoordinador(Profesor profesor) {
		Session session = SessionFactoryService.get().openSession();
		List<Asignatura> asignaturas = new ArrayList<>();
		try {
			session.beginTransaction();
			
			asignaturas.addAll(session.createQuery("select a from Asignatura a where a.coordinador= :profesor")
					.setParameter("profesor", profesor).getResultList());
			session.getTransaction().commit();
		} catch (Exception e) {
		} finally {
			session.close();
		}
		return asignaturas;
		
	}

	@Override
	public List<Asignatura> readAll() {
		Session session = SessionFactoryService.get().openSession();
		List <Asignatura> asignaturas = new ArrayList<>();
		
		try {
			session.beginTransaction();
			
			asignaturas.addAll(session.createQuery("from Asignatura").getResultList());
			
			session.getTransaction().commit();
		}catch (Exception e) {
			
		}finally {
			session.close();
		}
		
		return asignaturas;
	}

}
