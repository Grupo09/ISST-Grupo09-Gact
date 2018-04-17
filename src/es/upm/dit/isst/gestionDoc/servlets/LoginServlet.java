package es.upm.dit.isst.gestionDoc.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.upm.dit.isst.gestionDoc.dao.AsignacionDAOImplementation;
import es.upm.dit.isst.gestionDoc.dao.AsignaturaDAOImplementation;
import es.upm.dit.isst.gestionDoc.dao.DepartamentoDAOImplementation;
import es.upm.dit.isst.gestionDoc.dao.ProfesorDAOImplementation;
import es.upm.dit.isst.gestionDoc.dao.model.Departamento;
import es.upm.dit.isst.gestionDoc.dao.model.Profesor;


/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private final String ADMIN_EMAIL = "root";
	private final String ADMIN_PASSWORD = "root";
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		Profesor profesor = ProfesorDAOImplementation.getInstance().loginProfesor(email, password);
		
		
		
		if (ADMIN_EMAIL.equals(email) && ADMIN_PASSWORD.equals(password)) {
			req.getSession().setAttribute("adminLogged", true);
			DepartamentoDAOImplementation.getInstance().readDepartamento("1");
			req.getSession().setAttribute("departamento_list", DepartamentoDAOImplementation.getInstance().readAllDepartamento());
			List <Departamento> prueba = (List<Departamento>) req.getSession().getAttribute("departamento_list");
			resp.sendRedirect(req.getContextPath() + "/LoginSecretaria.jsp");
		} else if (null != profesor) {
			req.getSession().setAttribute("profesor", profesor);
			req.getSession().setAttribute("asignatura_list", AsignacionDAOImplementation.getInstance().readAsignaturas(profesor));
			req.getSession().setAttribute("asignaturaCoordinador_list", AsignaturaDAOImplementation.getInstance().readAsignaturaCoordinador(profesor));
			req.getSession().setAttribute("menuProfesor", 0);
			resp.sendRedirect(req.getContextPath() + "/LoginProfesor.jsp");
		}else {
			resp.setContentType("text/html;charset=UTF-8");
			PrintWriter out = resp.getWriter();
			out.println("<script type=\"text/javascript\">");
			   out.println("alert('Usuario o contraseña incorrectos');");
			   out.println("location='FormLogin.jsp';");
			   out.println("</script>");
		}
	}

}
