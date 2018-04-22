package es.upm.dit.isst.gestionDoc.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.upm.dit.isst.gestionDoc.dao.AsignaturaDAOImplementation;
import es.upm.dit.isst.gestionDoc.dao.DepartamentoDAOImplementation;
import es.upm.dit.isst.gestionDoc.dao.PlanEstudiosDAOImplementation;
import es.upm.dit.isst.gestionDoc.dao.model.Asignatura;
import es.upm.dit.isst.gestionDoc.dao.model.Departamento;
import es.upm.dit.isst.gestionDoc.dao.model.PlanEstudios;

/**
 * Servlet implementation class FormRespoEditarAsignatura3Servlet
 */
@WebServlet("/FormRespEditarAsignatura1Servlet")
public class FormRespEditarAsignatura1Servlet extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		String planEstudiosCodigo = req.getParameter("planEstudios");
//		String departamentoCodigo = req.getParameter("departamento");
		String asignaturaCodigo = req.getParameter("codigo");
		
		
		

//		req.getSession().setAttribute("planEstudios", planEstudios);
//		req.getSession().setAttribute("departamento", departamento);
//		req.getSession().setAttribute("asignaturas_list", lista2);

		Asignatura asignatura  = AsignaturaDAOImplementation.getInstance().readAsignatura(asignaturaCodigo);
		
		req.getSession().setAttribute("asignatura",asignatura);
		
		req.getSession().setAttribute("menuResponsable", 6);
		resp.sendRedirect(req.getContextPath()+"/LoginResponsable.jsp");
	}
}
