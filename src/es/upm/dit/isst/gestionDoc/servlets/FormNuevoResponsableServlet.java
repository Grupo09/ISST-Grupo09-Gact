package es.upm.dit.isst.gestionDoc.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.upm.dit.isst.gestionDoc.dao.DepartamentoDAO;
import es.upm.dit.isst.gestionDoc.dao.DepartamentoDAOImplementation;
import es.upm.dit.isst.gestionDoc.dao.ProfesorDAOImplementation;
import es.upm.dit.isst.gestionDoc.dao.model.Departamento;
import es.upm.dit.isst.gestionDoc.dao.model.Profesor;

/**
 * Servlet implementation class FormNuevoResponsableServlet
 */
@WebServlet("/FormNuevoResponsableServlet")
public class FormNuevoResponsableServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String codigo = req.getParameter("departamento");
		String responsableEmail = req.getParameter("responsable");
		System.out.println(responsableEmail);
		
		if(responsableEmail == null) {
			resp.sendRedirect(req.getContextPath()+"/LoginSecretaria.jsp");
		}else {
			DepartamentoDAO dao = DepartamentoDAOImplementation.getInstance();
			Departamento departamento = dao.readDepartamento(codigo);
			Profesor responsable = 
					(Profesor) ProfesorDAOImplementation.getInstance().readProfesor(responsableEmail);
			departamento.setResponsable(responsable);
			dao.updateDepartamento(departamento);
			req.getSession().setAttribute("departamento_list", dao.readAllDepartamento());
			resp.sendRedirect(req.getContextPath()+"/LoginSecretaria.jsp");
		}
	}

}
