package es.upm.dit.isst.gestionDoc.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
 * Servlet implementation class FormRespoEditarAsignatura3Servlet
 */
@WebServlet("/FormRespEditarAsignatura1Servlet")
public class FormRespEditarAsignatura1Servlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//String planEstudiosCodigo = req.getParameter("planEstudios");
		String departamentoCodigo = req.getParameter("departamento");
		String asignaturaCodigo = req.getParameter("codigo");
		
	




		//		req.getSession().setAttribute("planEstudios", planEstudios);
		//		req.getSession().setAttribute("departamento", departamento);
		//		req.getSession().setAttribute("asignaturas_list", lista2);

		Asignatura asignatura  = AsignaturaDAOImplementation.getInstance().readAsignatura(asignaturaCodigo);

		req.getSession().setAttribute("asignatura",asignatura);

		//Ahora vamos a sacar aqui a los profesores que estan asignados y los disponibles

		List <Asignacion> listAsignaciones = AsignacionDAOImplementation.getInstance().readAsociaciones();

		List <Profesor> listProfAsignados = new ArrayList<>();
		List <Profesor> listProfDisponibles = new ArrayList<>();

		//listProfDisponibles = (List<Profesor>) req.getSession().getAttribute("profesorDepartamento_list");
		listProfDisponibles.addAll(DepartamentoDAOImplementation.getInstance().readDepartamento(departamentoCodigo).getProfesores());
		for (Asignacion asig : listAsignaciones) {
			if (asig.getAsignatura().getCodigo().equals(asignaturaCodigo)) {
				listProfAsignados.add(asig.getProfesor());	
				System.out.println("He añadido al profesor a lista de asignaciones  " + asig.getProfesor().getNombre());



			}
		}
		
		System.out.println("Voy a crear la lista de  los profesores disponibles del departamento");
		System.out.println();
		Profesor borrado = null;
		for (int j = 0; j < listProfAsignados.size();j++){
			for (Profesor prof: listProfDisponibles) {
				System.out.println("Los profesores disponibles son   " + prof.getEmail());
				if (prof.getEmail().equals(listProfAsignados.get(j).getEmail())){
					borrado = prof;	
				}
			}
			listProfDisponibles.remove(borrado);
			

		}
		System.out.println("los tamaños son : "+listProfAsignados.size() +":"+listProfDisponibles.size());
		//System.out.println("HOLAAAAAAAAAA es "+ planEstudiosCodigo);

		req.getSession().setAttribute("profAsignatura_lista",listProfAsignados);
		req.getSession().setAttribute("profDisponible_lista",listProfDisponibles);
		//req.getSession().setAttribute("planEstudios", PlanEstudiosDAOImplementation.getInstance().readPlanEstudios(planEstudiosCodigo));

		req.getSession().setAttribute("menuResponsable", 6);
		resp.sendRedirect(req.getContextPath()+"/LoginResponsable.jsp");
	}
}
