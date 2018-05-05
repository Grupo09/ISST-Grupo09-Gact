package es.upm.dit.isst.gestionDoc.servlets;

import java.io.IOException;
import java.io.PrintWriter;
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
		//int repetidoCodigo = 0;
		int repetidoAcronimo = 0;
		int repetidoNombre = 0;
		List<PlanEstudios> planes =  PlanEstudiosDAOImplementation.getInstance().readAll();
		PrintWriter out = resp.getWriter();
		for(PlanEstudios planEstudio: planes) {
			 if(!acronimo.equals(plan.getAcronimo()) &&  acronimo.equals(planEstudio.getAcronimo())){
				   repetidoAcronimo++;
			} else if(!nombre.equals(plan.getNombre()) &&  nombre.equals(planEstudio.getNombre())){
				   repetidoNombre++;
			} 
		}
		/*
		if(repetidoCodigo != 0) {
			resp.setContentType("text/html;charset=UTF-8");
			   out.println("<script type=\"text/javascript\">");
			   out.println("alert('Código ya registrado');");
			   out.println("location='LoginResponsable.jsp';");
			   out.println("</script>");
			   
		} else 
			*/
		if(repetidoNombre != 0 && repetidoAcronimo !=0) {
			resp.setContentType("text/html;charset=UTF-8");
			   out.println("<script type=\"text/javascript\">");
			   out.println("alert('Acronimo y nombre ya registrado');");
			   out.println("location='LoginResponsable.jsp';");
			   out.println("</script>");
			   
		}else if(repetidoAcronimo != 0) {
			resp.setContentType("text/html;charset=UTF-8");
			   out.println("<script type=\"text/javascript\">");
			   out.println("alert('Acronimo ya registrado');");
			   out.println("location='LoginResponsable.jsp';");
			   out.println("</script>");
			   
		} else if(repetidoNombre != 0) {
			resp.setContentType("text/html;charset=UTF-8");
			   out.println("<script type=\"text/javascript\">");
			   out.println("alert('Nombre ya registrado');");
			   out.println("location='LoginResponsable.jsp';");
			   out.println("</script>");
			   
		}
		
		else {
		
			plan.setNombre(nombre);
			plan.setAcronimo(acronimo);
			
		
			PlanEstudiosDAOImplementation.getInstance().updatePlanEstudios(plan);
			req.getSession().setAttribute("menuResponsable", 0);
	
			resp.sendRedirect(req.getContextPath() + "/LoginResponsable.jsp");
		}
	 }
		
	}