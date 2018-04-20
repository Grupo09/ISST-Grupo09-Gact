package es.upm.dit.isst.gestionDoc.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.upm.dit.isst.gestionDoc.dao.AsignacionDAOImplementation;
import es.upm.dit.isst.gestionDoc.dao.model.Profesor;

/**
 * Servlet implementation class LoginProfesorServlet
 */
@WebServlet("/LoginProfesorServlet")
public class LoginProfesorServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String menu = req.getParameter("menu");
		if (menu == null || menu.equals(0)) {
			req.getSession().setAttribute("menuProfesor", 0);
			resp.sendRedirect(req.getContextPath() + "/LoginProfesor.jsp");
		}else if (menu.equals("1")) {
			req.getSession().setAttribute("menuProfesor", 1);
			Profesor profesor = (Profesor) req.getSession().getAttribute("profesor");
			req.getSession().setAttribute("asignatura_list", AsignacionDAOImplementation.getInstance().readAsignaturas(profesor));
			resp.sendRedirect(req.getContextPath() + "/LoginProfesor.jsp");
		} else {
			req.getSession().setAttribute("menuProfesor", 0);
			resp.sendRedirect(req.getContextPath() + "/LoginProfesor.jsp");
		}
	}

}
