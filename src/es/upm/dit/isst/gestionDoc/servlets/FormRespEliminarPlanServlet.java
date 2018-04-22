package es.upm.dit.isst.gestionDoc.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.upm.dit.isst.gestionDoc.dao.AsignacionDAOImplementation;
import es.upm.dit.isst.gestionDoc.dao.AsignaturaDAOImplementation;
import es.upm.dit.isst.gestionDoc.dao.PlanEstudiosDAOImplementation;
import es.upm.dit.isst.gestionDoc.dao.model.Asignacion;
import es.upm.dit.isst.gestionDoc.dao.model.Asignatura;
import es.upm.dit.isst.gestionDoc.dao.model.PlanEstudios;

/**
 * Servlet implementation class FormRespNuevaAsignaturaServlet
 */
@WebServlet("/FormRespEliminarPlanServlet")
public class FormRespEliminarPlanServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		
		String codigo = req.getParameter("codigo");
		
		
		PlanEstudios plan = PlanEstudiosDAOImplementation.getInstance().readPlanEstudios(codigo);
		
		//Ahi que borrar las asignaturas antes de borrar plan
		
		List<Asignatura> asignatura = AsignaturaDAOImplementation.getInstance().readAll();
		List <Asignatura> asignaturaB = new ArrayList<>();
		
		for (Asignatura a : asignatura) {
			if ( a.getPlanEstudios().getCodigo().equals(codigo)) {
				asignaturaB.add(a);
			}
		}
		
		for (Asignatura a : asignaturaB) {
			for(Asignacion asig: a.getAsignaciones()) {
				AsignacionDAOImplementation.getInstance().deleteAsignacion(asig);
				
			}
			AsignaturaDAOImplementation.getInstance().deleteAsignatura(a);
		}
		//
	
		PlanEstudiosDAOImplementation.getInstance().deletePlanEstudios(plan);
		req.getSession().setAttribute("menuResponsable", 0);

		resp.sendRedirect(req.getContextPath() + "/LoginResponsable.jsp");
		
	}
		
	}
