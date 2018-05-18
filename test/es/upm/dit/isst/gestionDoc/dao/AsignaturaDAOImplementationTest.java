package es.upm.dit.isst.gestionDoc.dao;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import es.upm.dit.isst.gestionDoc.dao.model.Asignatura;
import es.upm.dit.isst.gestionDoc.dao.model.Departamento;
import es.upm.dit.isst.gestionDoc.dao.model.PlanEstudios;
import es.upm.dit.isst.gestionDoc.dao.model.Profesor;

public class AsignaturaDAOImplementationTest {

	Departamento departamento;
	PlanEstudios planEstudios;
	Profesor profesor;
	
	@Before
	public void setUp() throws Exception {
		planEstudios = new PlanEstudios();
		planEstudios.setAcronimo("plane");
		planEstudios.setCodigo("p000");
		planEstudios.setNombre("Plan De Prueba");
		PlanEstudiosDAOImplementation.getInstance().createPlanEstudios(planEstudios);
				
		departamento = new Departamento();
		departamento.setAcronimo("dept");
		departamento.setCodigo("d000");
		departamento.setNombre("Departamento de prueba");
		DepartamentoDAOImplementation.getInstance().createDepartamento(departamento);
		
		profesor = new Profesor();
		profesor.setEmail("profesor@upm.es");
		profesor.setNombre("Profesor App1 App2");
		profesor.setDepartamento(departamento);
		ProfesorDAOImplementation.getInstance().createProfesor(profesor);
		
		
	}

	@After
	public void tearDown() throws Exception {
		ProfesorDAOImplementation.getInstance().deleteProfesor(profesor);
		PlanEstudiosDAOImplementation.getInstance().deletePlanEstudios(planEstudios);
		DepartamentoDAOImplementation.getInstance().deleteDepartamento(departamento);
		
	}

	@Test
	public void testCreateAsignatura() {
		Asignatura asignatura = new Asignatura();
		asignatura.setAcronimo("asig");
		asignatura.setCodigo("a000");
		asignatura.setNombre("asignatura ejemplo");
		asignatura.setCreditos("4.5");
		asignatura.setCurso(1);
		asignatura.setDepartamentoAsignatura(departamento);
		asignatura.setGrupos(2);
		asignatura.setHorasLaboratorio(30);
		asignatura.setHorasPractica(30);
		asignatura.setHorasTeoria(30);
		asignatura.setCoordinador(profesor);
		
		AsignaturaDAO asignaturaDAO = AsignaturaDAOImplementation.getInstance();
		asignaturaDAO.createAsignatura(asignatura);
		
		Asignatura asignatura2 = asignaturaDAO.readAsignatura("a000");
		assertEquals(asignatura.getAcronimo(), asignatura2.getAcronimo());
		assertEquals(asignatura.getCodigo(), asignatura2.getCodigo());
		assertEquals(asignatura.getNombre(), asignatura2.getNombre());
		assertEquals(asignatura.getCreditos(), asignatura2.getCreditos());
		assertEquals(asignatura.getCurso(), asignatura2.getCurso());
		assertEquals(asignatura.getDepartamentoAsignatura().getCodigo(), asignatura2.getDepartamentoAsignatura().getCodigo());
		assertEquals(asignatura.getGrupos(), asignatura2.getGrupos());
		assertEquals(asignatura.getHorasLaboratorio(), asignatura2.getHorasLaboratorio());
		assertEquals(asignatura.getHorasPractica(), asignatura2.getHorasPractica());
		assertEquals(asignatura.getHorasTeoria(), asignatura2.getHorasTeoria());
		assertEquals(asignatura.getCoordinador().getEmail(), asignatura2.getCoordinador().getEmail());
		
		asignaturaDAO.deleteAsignatura(asignatura);
		
	}

	@Test
	public void testUpdateAsignatura() {
		Asignatura asignatura = new Asignatura();
		asignatura.setAcronimo("asig");
		asignatura.setCodigo("a000");
		asignatura.setNombre("asignatura ejemplo");
		asignatura.setCreditos("4.5");
		asignatura.setCurso(1);
		asignatura.setDepartamentoAsignatura(departamento);
		asignatura.setGrupos(2);
		asignatura.setHorasLaboratorio(30);
		asignatura.setHorasPractica(30);
		asignatura.setHorasTeoria(30);
		asignatura.setCoordinador(profesor);
		
		AsignaturaDAO asignaturaDAO = AsignaturaDAOImplementation.getInstance();
		asignaturaDAO.createAsignatura(asignatura);
		
		Asignatura asignatura2 = asignaturaDAO.readAsignatura("a000");
		asignatura2.setHorasLaboratorio(20);
		asignaturaDAO.updateAsignatura(asignatura2);
		
		Asignatura asignatura3 = asignaturaDAO.readAsignatura("a000");
		assertEquals(asignatura2.getHorasLaboratorio(), asignatura3.getHorasLaboratorio());
		
		asignaturaDAO.deleteAsignatura(asignatura);
		
		
	}

	@Test
	public void testDeleteAsignatura() {
		Asignatura asignatura = new Asignatura();
		asignatura.setAcronimo("asig");
		asignatura.setCodigo("a000");
		asignatura.setNombre("asignatura ejemplo");
		asignatura.setCreditos("4.5");
		asignatura.setCurso(1);
		asignatura.setDepartamentoAsignatura(departamento);
		asignatura.setGrupos(2);
		asignatura.setHorasLaboratorio(30);
		asignatura.setHorasPractica(30);
		asignatura.setHorasTeoria(30);
		asignatura.setCoordinador(profesor);
		
		AsignaturaDAO asignaturaDAO = AsignaturaDAOImplementation.getInstance();
		asignaturaDAO.createAsignatura(asignatura);
		
		asignaturaDAO.deleteAsignatura(asignatura);
		
		Asignatura asignatura2 = asignaturaDAO.readAsignatura("a000");
		assertNull(asignatura2);
		
	}

}
