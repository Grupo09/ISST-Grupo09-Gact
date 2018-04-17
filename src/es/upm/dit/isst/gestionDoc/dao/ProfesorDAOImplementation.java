package es.upm.dit.isst.gestionDoc.dao;



import org.hibernate.Session;

import es.upm.dit.isst.gestionDoc.dao.model.Profesor;
import es.upm.dit.isst.gestionDoc.dao.SessionFactoryService;


public class ProfesorDAOImplementation implements ProfesorDAO {

	public static ProfesorDAOImplementation instance;

	private ProfesorDAOImplementation() {
	}

	public static ProfesorDAOImplementation getInstance() {
		if (null == instance)
			instance = new ProfesorDAOImplementation();
		return instance;
	}

	@Override
	public void createProfesor(Profesor profesor) {
		Session session = SessionFactoryService.get().openSession();
		try {
			session.beginTransaction();
			session.save(profesor);
			session.getTransaction().commit();
		} catch (Exception e) {
		} finally {
			session.close();
		}
		
	}

	@Override
	public Profesor readProfesor(String email) {
		Session session = SessionFactoryService.get().openSession();
		Profesor profesor = null;
		try {
			profesor = session.get(Profesor.class, email);
		} catch (Exception e) {
		} finally {
			session.close();
		}
		return profesor;
	}

	@Override
	public void updateProfesor(Profesor profesor) {
		Session session = SessionFactoryService.get().openSession();
		try {
			session.beginTransaction();
			session.saveOrUpdate(profesor);
			session.getTransaction().commit();
		} catch (Exception e) {
		} finally {
			session.close();
		}		
		
	}

	@Override
	public void deleteProfesor(Profesor profesor) {
		Session session = SessionFactoryService.get().openSession();
		try {
			session.beginTransaction();
			session.delete(profesor);
			session.getTransaction().commit();
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			session.close();
		}		
		
	}

	@Override
	public Profesor loginProfesor(String email, String password) {
		Session session = SessionFactoryService.get().openSession();
		Profesor profesor = null;
		try {
			session.beginTransaction();
			profesor = (Profesor) session.createQuery("select p from Profesor p where p.email= :email and p.password= :password")
					.setParameter("email", email).setParameter("password", password).uniqueResult();
			session.getTransaction().commit();
		} catch (Exception e) {
		} finally {
			session.close();
		}
		return profesor;
	}

	

}
