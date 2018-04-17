package es.upm.dit.isst.gestionDoc.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.upm.dit.isst.gestionDoc.dao.DepartamentoDAO;
import es.upm.dit.isst.gestionDoc.dao.DepartamentoDAOImplementation;
import es.upm.dit.isst.gestionDoc.dao.model.Departamento;

/**
 * Servlet implementation class FormNuevoDepartamentoServlet
 */
@WebServlet("/FormNuevoDepartamentoServlet")
public class FormNuevoDepartamentoServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String codigo = req.getParameter("codigo");
		String nombre = req.getParameter("nombre");
		String acronimo = req.getParameter("acronimo");
		Departamento departamento = new Departamento();
		departamento.setCodigo(codigo);
		departamento.setNombre(nombre);
		departamento.setAcronimo(acronimo);
		DepartamentoDAO dao = DepartamentoDAOImplementation.getInstance();
		dao.createDepartamento(departamento);
		req.getSession().setAttribute("departamento_list", dao.readAllDepartamento());
		resp.sendRedirect(req.getContextPath()+"/LoginSecretaria.jsp");
	}

}
