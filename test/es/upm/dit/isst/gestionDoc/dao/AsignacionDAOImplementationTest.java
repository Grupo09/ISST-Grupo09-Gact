package es.upm.dit.isst.gestionDoc.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import es.upm.dit.isst.gestionDoc.dao.model.Asignacion;
import es.upm.dit.isst.gestionDoc.dao.model.Asignatura;
import es.upm.dit.isst.gestionDoc.dao.model.Profesor;

public class AsignacionDAOImplementationTest {
	
	public Profesor professor;
	public Asignatura asignatura;

	@Before
	public void setUp() throws Exception {
	  professor = new Profesor();
	  professor.setNombre("Profesor1");
	  professor.setEmail("profesor@profesor");
	  professor.setPassword("professor");
	  ProfesorDAOImplementation.getInstance().createProfesor(professor);
	  
	  asignatura = new Asignatura();
	  asignatura.setCodigo("000");
	  asignatura.setNombre("Asignatura1");
	  asignatura.setAcronimo("ASG1");
	  asignatura.setCreditos("4,5");
	  asignatura.setCurso(4);
	  asignatura.setSemestre(2);
	  AsignaturaDAOImplementation.getInstance().createAsignatura(asignatura);
	}

	@After
	public void tearDown() throws Exception {
	  ProfesorDAOImplementation.getInstance().deleteProfesor(professor);
	  professor = null;
	  AsignaturaDAOImplementation.getInstance().deleteAsignatura(asignatura);
	  asignatura=null;	  
	}

	
	@Test
	public void testGetInstance() {
	}

	@Test
	public void testCreateAsignacion() {
		AsignacionDAO dao = AsignacionDAOImplementation.getInstance();
		Asignacion asignacion =new Asignacion();
		asignacion.setId((long) 0);
		asignacion.setAsignatura(asignatura);
		asignacion.setProfesor(professor);
		asignacion.setHorasLaboratorio(3);
		asignacion.setHorasPractica(4);
		asignacion.setHorasTeoria(5);
		dao.createAsignacion(asignacion);
		
		Asignacion asignacion2 = dao.readAsociacion(asignacion.getId());
		assertEquals(asignacion.getId(), asignacion2.getId());
		assertEquals(asignacion.getAsignatura().getCodigo(), asignacion2.getAsignatura().getCodigo());
		assertEquals(asignacion.getProfesor().getEmail(), asignacion2.getProfesor().getEmail());
		assertEquals(asignacion.getHorasLaboratorio(), asignacion2.getHorasLaboratorio());
		assertEquals(asignacion.getHorasPractica(), asignacion2.getHorasPractica());
		assertEquals(asignacion.getHorasTeoria(), asignacion2.getHorasTeoria());
		dao.deleteAsignacion(asignacion);
	}

	@Test
	public void testReadAsociacion() {
		AsignacionDAO dao = AsignacionDAOImplementation.getInstance();
		Asignacion asignacion =new Asignacion();
		asignacion.setId((long) 0);
		asignacion.setAsignatura(asignatura);
		asignacion.setProfesor(professor);
		asignacion.setHorasLaboratorio(3);
		asignacion.setHorasPractica(4);
		asignacion.setHorasTeoria(5);
		dao.createAsignacion(asignacion);
		
		Asignacion asignacion2 = dao.readAsociacion(asignacion.getId());
		assertEquals(asignacion.getId(), asignacion2.getId());
		assertEquals(asignacion.getAsignatura().getCodigo(), asignacion2.getAsignatura().getCodigo());
		assertEquals(asignacion.getProfesor().getEmail(), asignacion2.getProfesor().getEmail());
		assertEquals(asignacion.getHorasLaboratorio(), asignacion2.getHorasLaboratorio());
		assertEquals(asignacion.getHorasPractica(), asignacion2.getHorasPractica());
		assertEquals(asignacion.getHorasTeoria(), asignacion2.getHorasTeoria());
		dao.deleteAsignacion(asignacion);

	}

	@Test
	public void testReadAsociaciones() {
		AsignacionDAO dao = AsignacionDAOImplementation.getInstance();
		Asignacion asignacion =new Asignacion();
		asignacion.setAsignatura(asignatura);
		asignacion.setProfesor(professor);
		asignacion.setHorasLaboratorio(3);
		asignacion.setHorasPractica(4);
		asignacion.setHorasTeoria(5);
		dao.createAsignacion(asignacion);
		
		List <Asignacion> asignaciones = dao.readAsociaciones();
		System.out.println(asignaciones.size());
		assertEquals(asignacion.getId(), asignaciones.get(asignaciones.size()-1).getId());
		assertEquals(asignacion.getAsignatura().getCodigo(), asignaciones.get(asignaciones.size()-1).getAsignatura().getCodigo());
		assertEquals(asignacion.getProfesor().getEmail(), asignaciones.get(asignaciones.size()-1).getProfesor().getEmail());
		assertEquals(asignacion.getHorasLaboratorio(), asignaciones.get(asignaciones.size()-1).getHorasLaboratorio());
		assertEquals(asignacion.getHorasPractica(), asignaciones.get(asignaciones.size()-1).getHorasPractica());
		assertEquals(asignacion.getHorasTeoria(), asignaciones.get(asignaciones.size()-1).getHorasTeoria());
		dao.deleteAsignacion(asignacion);
	}

	@Test
	public void testUpdateAsignacion() {
		AsignacionDAO dao = AsignacionDAOImplementation.getInstance();
		Asignacion asignacion =new Asignacion();
		asignacion.setId((long) 0);
		asignacion.setAsignatura(asignatura);
		asignacion.setProfesor(professor);
		asignacion.setHorasLaboratorio(3);
		asignacion.setHorasPractica(4);
		asignacion.setHorasTeoria(5);
		dao.createAsignacion(asignacion);
		
		Asignacion asignacion2 = dao.readAsociacion(asignacion.getId());
		assertEquals(asignacion.getHorasLaboratorio(), asignacion2.getHorasLaboratorio());

		asignacion.setHorasLaboratorio(3);
		dao.updateAsignacion(asignacion);
		
		Asignacion asignacion3 = dao.readAsociacion(asignacion.getId());
		assertEquals(asignacion.getHorasLaboratorio(), asignacion3.getHorasLaboratorio());
		dao.deleteAsignacion(asignacion);

	}

	@Test
	public void testDeleteAsignacion() {
		AsignacionDAO dao = AsignacionDAOImplementation.getInstance();
		Asignacion asignacion =new Asignacion();
		asignacion.setId((long) 0);
		asignacion.setAsignatura(asignatura);
		asignacion.setProfesor(professor);
		asignacion.setHorasLaboratorio(3);
		asignacion.setHorasPractica(4);
		asignacion.setHorasTeoria(5);
		dao.createAsignacion(asignacion);
		
		assertNotNull(dao.readAsociacion(asignacion.getId()));
		dao.deleteAsignacion(asignacion);
		assertNull(dao.readAsociacion(asignacion.getId()));
	}

	@Test
	public void testReadAsignaturas() {
		AsignacionDAO dao = AsignacionDAOImplementation.getInstance();
		Asignacion asignacion =new Asignacion();
		asignacion.setId((long) 0);
		asignacion.setAsignatura(asignatura);
		asignacion.setProfesor(professor);
		asignacion.setHorasLaboratorio(3);
		asignacion.setHorasPractica(4);
		asignacion.setHorasTeoria(5);
		dao.createAsignacion(asignacion);
		
		List<Asignatura> asignaturas = dao.readAsignaturas(professor);
		assertEquals(asignacion.getAsignatura().getCodigo(), asignaturas.get(0).getCodigo());
		assertEquals(asignacion.getAsignatura().getAcronimo(), asignaturas.get(0).getAcronimo());
		assertEquals(asignacion.getAsignatura().getNombre(), asignaturas.get(0).getNombre());
		assertEquals(asignacion.getAsignatura().getCreditos(), asignaturas.get(0).getCreditos());
		assertEquals(asignacion.getAsignatura().getCurso(), asignaturas.get(0).getCurso());
		assertEquals(asignacion.getAsignatura().getSemestre(), asignaturas.get(0).getSemestre());
		dao.deleteAsignacion(asignacion);

	}

	@Test
	public void testReadProfesor() {
		AsignacionDAO dao = AsignacionDAOImplementation.getInstance();
		Asignacion asignacion =new Asignacion();
		asignacion.setId((long) 0);
		asignacion.setAsignatura(asignatura);
		asignacion.setProfesor(professor);
		asignacion.setHorasLaboratorio(3);
		asignacion.setHorasPractica(4);
		asignacion.setHorasTeoria(5);
		dao.createAsignacion(asignacion);
		
		List <Profesor> profesores = dao.readProfesor(asignatura);
		assertEquals(asignacion.getProfesor().getEmail(), profesores.get(0).getEmail());
		assertEquals(asignacion.getProfesor().getNombre(), profesores.get(0).getNombre());
		assertEquals(asignacion.getProfesor().getPassword(), profesores.get(0).getPassword());
		dao.deleteAsignacion(asignacion);

	}

}
