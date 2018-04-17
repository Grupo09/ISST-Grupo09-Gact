package es.upm.dit.isst.gestionDoc.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itextpdf.text.log.SysoCounter;

import es.upm.dit.isst.gestionDoc.dao.AsignacionDAOImplementation;
import es.upm.dit.isst.gestionDoc.dao.AsignaturaDAOImplementation;
import es.upm.dit.isst.gestionDoc.dao.DepartamentoDAOImplementation;
import es.upm.dit.isst.gestionDoc.dao.PlanEstudiosDAOImplementation;
import es.upm.dit.isst.gestionDoc.dao.ProfesorDAOImplementation;
import es.upm.dit.isst.gestionDoc.dao.model.Asignacion;
import es.upm.dit.isst.gestionDoc.dao.model.Asignatura;
import es.upm.dit.isst.gestionDoc.dao.model.Departamento;
import es.upm.dit.isst.gestionDoc.dao.model.PlanEstudios;
import es.upm.dit.isst.gestionDoc.dao.model.Profesor;

/**
 * Servlet implementation class FormRespNuevaAsignaturaServlet
 */
@WebServlet("/FormRespNuevaAsignaturaServlet")
public class FormRespNuevaAsignaturaServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String planEstudiosCodigo = req.getParameter("planEstudios");
		String codigo = req.getParameter("codigo");
		String nombre = req.getParameter("nombre");
		String acronimo = req.getParameter("acronimo");
		String creditos = req.getParameter("creditos");
		int curso = Integer.parseInt(req.getParameter("curso"));
		int semestre = Integer.parseInt(req.getParameter("semestre"));
		int grupos = Integer.parseInt(req.getParameter("grupos"));
		int horasTeoria = Integer.parseInt(req.getParameter("horasTeoria")); 
		int horasPractica = Integer.parseInt(req.getParameter("horasPractica"));
		int horasLaboratorio = Integer.parseInt(req.getParameter("horasLaboratorio"));
		String coordinadorEmail = req.getParameter("coordinador");
		Profesor coordinador = ProfesorDAOImplementation.getInstance().readProfesor(coordinadorEmail);
		Asignatura asignatura = new Asignatura();
		PlanEstudios planEstudios = PlanEstudiosDAOImplementation.getInstance().readPlanEstudios(planEstudiosCodigo);
		String departamentoCodigo = req.getParameter("departamento");
		Departamento departamento = DepartamentoDAOImplementation.getInstance().readDepartamento(departamentoCodigo);
		asignatura.setPlanEstudios(planEstudios);
		asignatura.setCodigo(codigo);
		asignatura.setNombre(nombre);
		asignatura.setAcronimo(acronimo);
		asignatura.setCreditos(creditos);
		asignatura.setCurso(curso);
		asignatura.setSemestre(semestre);
		asignatura.setGrupos(grupos);
		asignatura.setHorasTeoria(horasTeoria);
		asignatura.setHorasPractica(horasPractica);
		asignatura.setHorasLaboratorio(horasLaboratorio);
		asignatura.setDepartamentoAsignatura(departamento);
		asignatura.setCoordinador(coordinador);
		AsignaturaDAOImplementation.getInstance().createAsignatura(asignatura);
		  
		String [] profesoresEmail = req.getParameterValues("ProfesoresSeleccionados");
		System.out.println(profesoresEmail.length);
		if (profesoresEmail != null) {
			for(int i = 0; i<profesoresEmail.length; i++) {
				Asignacion asignacion = new Asignacion();
				Profesor profesor = ProfesorDAOImplementation.getInstance().readProfesor(profesoresEmail[i]);
				asignacion.setProfesor(profesor);
				asignacion.setHorasLaboratorio(0);
				asignacion.setHorasPractica(0);
				asignacion.setHorasTeoria(0);
				asignacion.setAsignatura(asignatura);
				AsignacionDAOImplementation.getInstance().createAsignacion(asignacion);
			}
		}
		
		req.getSession().setAttribute("menuResponsable", 0);
		resp.sendRedirect(req.getContextPath()+"/LoginResponsable.jsp");
	}
	
	

}
