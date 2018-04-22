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
 * Servlet implementation class FormRespoEliminarAsignaturaServlet
 */
@WebServlet("/FormRespEliminarAsignaturaServlet")
public class FormRespEliminarAsignaturaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		String codigo = req.getParameter("asignatura");
		Asignatura asignatura = AsignaturaDAOImplementation.getInstance().readAsignatura(codigo);
		
		
		
		//Primero tenemos que eliminar las asignaciones cuidadiiiiin
		List <Asignacion> listAsignaciones = AsignacionDAOImplementation.getInstance().readAsociaciones();
		List <Asignacion> listAsignacionesB = new ArrayList<>();
		
		for (Asignacion asigna: listAsignaciones) {
			if (asigna.getAsignatura().getCodigo().equals(codigo)) {
				listAsignacionesB.add(asigna);
			}
		}
		
		for (Asignacion asigna : listAsignacionesB) {
		AsignacionDAOImplementation.getInstance().deleteAsignacion(asigna);	
		}
		
		AsignaturaDAOImplementation.getInstance().deleteAsignatura(asignatura);


		req.getSession().setAttribute("menuResponsable", 0);

		resp.sendRedirect(req.getContextPath() + "/LoginResponsable.jsp");
	}

}

