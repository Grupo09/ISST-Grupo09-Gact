package es.upm.dit.isst.gestionDoc.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.upm.dit.isst.gestionDoc.dao.DepartamentoDAOImplementation;
import es.upm.dit.isst.gestionDoc.dao.ProfesorDAOImplementation;
import es.upm.dit.isst.gestionDoc.dao.model.Departamento;
import es.upm.dit.isst.gestionDoc.dao.model.Profesor;

/**
 * Servlet implementation class FormNuevoProfesorServlet
 */
@WebServlet("/FormNuevoProfesorServlet")
public class FormNuevoProfesorServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String codigo = req.getParameter("departamento");
		String email = req.getParameter("email");
		String nombre = req.getParameter("nombre");
		String password = req.getParameter("password");
		if(null == codigo) {
			resp.setContentType("text/html;charset=UTF-8");
			PrintWriter out = resp.getWriter();
			out.println("<script type=\"text/javascript\">");
			   out.println("alert('Debe seleccionar un departamento');");
			   out.println("location='LoginNuevoProfesor.jsp';");
			   out.println("</script>");
				
		}else {
		
			Profesor profesor = new Profesor();
			Departamento departamento = DepartamentoDAOImplementation.getInstance().readDepartamento(codigo);
			profesor.setNombre(nombre);
			profesor.setEmail(email);
			profesor.setPassword(password);
			profesor.setDepartamento(departamento);
			ProfesorDAOImplementation.getInstance().createProfesor(profesor);
			resp.sendRedirect(req.getContextPath()+"/FormLogin.jsp");
			
		}
	
	}
	
}
