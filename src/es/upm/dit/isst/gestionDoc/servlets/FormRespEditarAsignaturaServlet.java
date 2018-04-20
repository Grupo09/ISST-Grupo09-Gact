package es.upm.dit.isst.gestionDoc.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.upm.dit.isst.gestionDoc.dao.AsignacionDAOImplementation;
import es.upm.dit.isst.gestionDoc.dao.AsignaturaDAOImplementation;
import es.upm.dit.isst.gestionDoc.dao.DepartamentoDAOImplementation;
import es.upm.dit.isst.gestionDoc.dao.PlanEstudiosDAOImplementation;
import es.upm.dit.isst.gestionDoc.dao.ProfesorDAOImplementation;
import es.upm.dit.isst.gestionDoc.dao.model.Asignacion;
import es.upm.dit.isst.gestionDoc.dao.model.Asignatura;
import es.upm.dit.isst.gestionDoc.dao.model.Departamento;
import es.upm.dit.isst.gestionDoc.dao.model.PlanEstudios;
import es.upm.dit.isst.gestionDoc.dao.model.Profesor;

/**
 * Servlet implementation class FormRespoEditarAsignaturaServlet
 */
@WebServlet("/FormRespEditarAsignaturaServlet")
public class FormRespEditarAsignaturaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String planEstudiosCodigo = req.getParameter("planEstudios");
		String asignaturaCodigo = req.getParameter("codigo");
		String departamentoCodigo = req.getParameter("departamento");
	
		PlanEstudios planEstudios = PlanEstudiosDAOImplementation.getInstance().readPlanEstudios(planEstudiosCodigo);
		
		Departamento departamento = DepartamentoDAOImplementation.getInstance().readDepartamento(departamentoCodigo);
		
		Asignatura asignatura = AsignaturaDAOImplementation.getInstance().readAsignatura(asignaturaCodigo);
		
		req.getSession().setAttribute("planEstudios", planEstudios);
		req.getSession().setAttribute("departamento", departamento);
		req.getSession().setAttribute("asignatura", asignatura);
		

		req.getSession().setAttribute("menuResponsable", 4);
		resp.sendRedirect(req.getContextPath()+"/LoginResponsable.jsp");
	}
	
	

}