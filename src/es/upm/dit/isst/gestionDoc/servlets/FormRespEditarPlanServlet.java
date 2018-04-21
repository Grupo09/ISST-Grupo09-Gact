package es.upm.dit.isst.gestionDoc.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.upm.dit.isst.gestionDoc.dao.PlanEstudiosDAOImplementation;
import es.upm.dit.isst.gestionDoc.dao.model.PlanEstudios;

/**
 * Servlet implementation class FormRespNuevaAsignaturaServlet
 */
@WebServlet("/FormRespEditarPlanServlet")
public class FormRespEditarPlanServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		
		String codigo = req.getParameter("codigo");
		String nombre = req.getParameter("nombre");
		String acronimo = req.getParameter("acronimo");
		
		PlanEstudios plan = PlanEstudiosDAOImplementation.getInstance().readPlanEstudios(codigo);
		
		plan.setNombre(nombre);
		plan.setAcronimo(acronimo);
		
	
		PlanEstudiosDAOImplementation.getInstance().updatePlanEstudios(plan);
		req.getSession().setAttribute("menuResponsable", 0);

		resp.sendRedirect(req.getContextPath() + "/LoginResponsable.jsp");
		
	}
		
	}