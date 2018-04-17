package es.upm.dit.isst.gestionDoc.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.upm.dit.isst.gestionDoc.dao.DepartamentoDAOImplementation;

/**
 * Servlet implementation class LoginNuevoProfesorServlet
 */
@WebServlet("/LoginNuevoProfesorServlet")
public class LoginNuevoProfesorServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getSession().setAttribute("departamento_list", DepartamentoDAOImplementation.getInstance().readAllDepartamento());
		resp.sendRedirect(req.getContextPath()+"/LoginNuevoProfesor.jsp");
	}

}
