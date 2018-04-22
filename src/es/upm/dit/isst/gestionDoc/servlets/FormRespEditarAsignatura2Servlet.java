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
 * Servlet implementation class FormRespEditarAsignatura2
 */
@WebServlet("/FormRespEditarAsignatura2Servlet")
public class FormRespEditarAsignatura2Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String planEstudiosCodigo = req.getParameter("planEstudios");
		String codigo = req.getParameter("codigo");
		String menu = req.getParameter("manera");
		Asignatura asignatura= AsignaturaDAOImplementation.getInstance().readAsignatura(codigo);
		System.out.println(menu);

		// Obtengo los nuevos parametros
		String nombre = req.getParameter("nombre");
		String acronimo = req.getParameter("acronimo");
		String creditos = req.getParameter("creditos");

		System.out.println(req.getParameter("curso")+"/"+req.getParameter("semestre")+"/"+req.getParameter("grupos")+"/"+req.getParameter("horasTeoria")+"/"+req.getParameter("horasPractica")
		+"/"+req.getParameter("horasLaboratorio")+"/"+req.getParameter("coordinador"));
		System.out.println("EL PLAN DE ESTUDIOS CODIGO ES "+planEstudiosCodigo);
		int curso = Integer.parseInt(req.getParameter("curso"));
		int semestre = Integer.parseInt(req.getParameter("semestre"));
		int grupos = Integer.parseInt(req.getParameter("grupos"));
		int horasTeoria = Integer.parseInt(req.getParameter("horasTeoria")); 
		int horasPractica = Integer.parseInt(req.getParameter("horasPractica"));
		int horasLaboratorio = Integer.parseInt(req.getParameter("horasLaboratorio"));
		String coordinadorEmail = req.getParameter("coordinador");

		Profesor coordinador = ProfesorDAOImplementation.getInstance().readProfesor(coordinadorEmail);

		PlanEstudios planEstudios = PlanEstudiosDAOImplementation.getInstance().readPlanEstudios(planEstudiosCodigo);
		String departamentoCodigo = req.getParameter("departamento");
		Departamento departamento = DepartamentoDAOImplementation.getInstance().readDepartamento(departamentoCodigo);
		asignatura.setPlanEstudios(planEstudios);
		asignatura.setCodigo(codigo);
		asignatura.setNombre(nombre);
		asignatura.setAcronimo(acronimo);
		asignatura.setCreditos(creditos);
		asignatura.setCurso(curso);
		asignatura.setSemestre(semestre);
		asignatura.setGrupos(grupos);
		asignatura.setHorasTeoria(horasTeoria);
		asignatura.setHorasPractica(horasPractica);
		asignatura.setHorasLaboratorio(horasLaboratorio);
		asignatura.setDepartamentoAsignatura(departamento);
		asignatura.setCoordinador(coordinador);

		System.out.println("Estoy antes de updatear");
		System.out.println(req.getParameter("curso")+"/"+req.getParameter("semestre")+"/"+req.getParameter("grupos")+"/"+req.getParameter("horasTeoria")+"/"+req.getParameter("horasPractica")
		+"/"+req.getParameter("horasLaboratorio")+"/"+req.getParameter("coordinador"));
		//		
		AsignaturaDAOImplementation.getInstance().updateAsignatura(asignatura);


		String [] profesoresEmail = req.getParameterValues("ProfesoresSeleccionados");
		System.out.println(profesoresEmail.length);

		List<Profesor> profAhora = new ArrayList<>();
		for( String email : profesoresEmail) {
			profAhora.add(ProfesorDAOImplementation.getInstance().readProfesor(email));


		}
		System.out.println("LA LISTA DE AHORA es "+ profAhora.size());
		// Ya tengo los profs de ahora, ahora hago los mismo con los de antes pero solamente en esa asignatura
		List<Profesor> profAntes = new ArrayList<>();
		profAntes.addAll(AsignacionDAOImplementation.getInstance().readProfesor(asignatura));
		System.out.println("La lista de antes es : "+profAntes.size());

		List <Asignacion> asignaciones = AsignacionDAOImplementation.getInstance().readAsociaciones();
		System.out.println("El tamaño de las asignacioneeeees eeeeeees"+ asignaciones.size());
		
		
		//Ahora voy a eliminar las asignaciones de los profesores que por desgracia ya no están 
		
		boolean  profEncontrado=false;
		for (Profesor profesor : profAntes) {
			for (Profesor ahora : profAhora) {
				if (profesor.getEmail().equals(ahora.getEmail())) {
					profEncontrado=true;
					break;
				}
				
			}
			if (!profEncontrado) {
				long id =0;
				for(Asignacion asig: asignaciones) {
					if (asig.getAsignatura().getCodigo().equals(asignatura.getCodigo())
							&& asig.getProfesor().getEmail().equals(profesor.getEmail())) {
						id= asig.getId();
					}
				}
				
				AsignacionDAOImplementation.getInstance().deleteAsignacion(AsignacionDAOImplementation.getInstance().readAsociacion(id));
				profEncontrado=false;
			
			}
		}

		//Ahora ya solo tengo la de las asignatura lueeeego

		for (Profesor profesor : profAhora) {
			boolean encontrado = false;
			for (Asignacion asignacion : asignaciones) {
				if (profesor.getEmail().equals( asignacion.getProfesor().getEmail()) && asignacion.getAsignatura().getCodigo().equals(codigo)) {
					System.out.println("Entre por que ha habido conincidence");
					System.out.println("LA ID ES :   "+ asignacion.getId());
					encontrado=true;
					asignacion.setProfesor(profesor);
					//No tengo que tocar las horas de cada profesor tarea del responsable
//					asignacion.setHorasLaboratorio(horasLaboratorio);
//					asignacion.setHorasPractica(horasPractica);
//					asignacion.setHorasTeoria(horasTeoria);
					asignacion.setAsignatura(asignatura);
					AsignacionDAOImplementation.getInstance().updateAsignacion(asignacion);
					break;
				}
			}
			if (!encontrado) {
				System.out.println("Entre por que NOOOOO ha habido conincidence");
				Asignacion asignacion = new Asignacion();
				asignacion.setProfesor(profesor);
				//No hay que tocar las horas de cada profesor es cosa del cordinador 
//				asignacion.setHorasLaboratorio(horasLaboratorio);
//				asignacion.setHorasPractica(horasPractica);
//				asignacion.setHorasTeoria(horasTeoria);
				asignacion.setAsignatura(asignatura);
				AsignacionDAOImplementation.getInstance().createAsignacion(asignacion);

			}


		}

		req.setAttribute("menuResponsable", 0);
		resp.sendRedirect(req.getContextPath() + "/LoginResponsableServlet");






	}



}