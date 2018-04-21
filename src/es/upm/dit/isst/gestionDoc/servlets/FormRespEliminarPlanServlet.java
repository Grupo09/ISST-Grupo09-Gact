package es.upm.dit.isst.gestionDoc.servlets;

import java.io.IOException;


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
@WebServlet("/FormRespEliminarPlanServlet")
public class FormRespEliminarPlanServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		
		String codigo = req.getParameter("codigo");
		
		
		PlanEstudios plan = PlanEstudiosDAOImplementation.getInstance().readPlanEstudios(codigo);
		
		
		
	
		PlanEstudiosDAOImplementation.getInstance().deletePlanEstudios(plan);
		req.getSession().setAttribute("menuResponsable", 0);

		resp.sendRedirect(req.getContextPath() + "/LoginResponsable.jsp");
		
	}
		
	}
