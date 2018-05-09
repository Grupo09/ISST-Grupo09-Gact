package es.upm.dit.isst.gestionDoc.servlets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.itextpdf.text.log.SysoCounter;

import es.upm.dit.isst.gestionDoc.dao.AsignaturaDAOImplementation;
import es.upm.dit.isst.gestionDoc.dao.DepartamentoDAO;
import es.upm.dit.isst.gestionDoc.dao.DepartamentoDAOImplementation;
import es.upm.dit.isst.gestionDoc.dao.PlanEstudiosDAOImplementation;
import es.upm.dit.isst.gestionDoc.dao.ProfesorDAOImplementation;
import es.upm.dit.isst.gestionDoc.dao.model.Asignatura;
import es.upm.dit.isst.gestionDoc.dao.model.Departamento;
import es.upm.dit.isst.gestionDoc.dao.model.PlanEstudios;
import es.upm.dit.isst.gestionDoc.dao.model.Profesor;

/**
 * Servlet implementation class LoginResponsableServlet
 */
@WebServlet("/LoginResponsableServlet")
public class LoginResponsableServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String menu = req.getParameter("menu");
		System.out.println(menu);
		if (null == menu || menu.equals("0")) {
			req.getSession().setAttribute("menuResponsable", 0);
			resp.sendRedirect(req.getContextPath() + "/LoginResponsable.jsp");
		} else if (menu.equals("1")) {

			req.getSession().setAttribute("menuResponsable", 1);

			resp.sendRedirect(req.getContextPath() + "/LoginResponsable.jsp");

		} else if (menu.equals("2")) {

			req.getSession().setAttribute("menuResponsable", 2);
			req.getSession().setAttribute("plan_list", PlanEstudiosDAOImplementation.getInstance().readAll());

			resp.sendRedirect(req.getContextPath() + "/LoginResponsable.jsp");

		} else if (menu.equals("3")) {
			req.getSession().setAttribute("menuResponsable", 3);
			req.getSession().setAttribute("planEstudios_list", PlanEstudiosDAOImplementation.getInstance().readAll());
			Profesor profesor = (Profesor) req.getSession().getAttribute("profesor");
			List<Profesor> profesores = profesor.getDepartamento().getProfesores();
			req.getSession().setAttribute("profesorDepartamento_list", profesores);
			resp.sendRedirect(req.getContextPath() + "/LoginResponsable.jsp");
		} else if (menu.equals("4")) {
			req.getSession().setAttribute("menuResponsable", 4);
			req.getSession().setAttribute("planEstudios_list", PlanEstudiosDAOImplementation.getInstance().readAll());
			req.getSession().setAttribute("asignaturas_list", AsignaturaDAOImplementation.getInstance().readAll());
			Profesor profesor = (Profesor) req.getSession().getAttribute("profesor");
			List<Profesor> profesores = profesor.getDepartamento().getProfesores();
			req.getSession().setAttribute("profesorDepartamento_list", profesores);
			resp.sendRedirect(req.getContextPath() + "/LoginResponsable.jsp");

		} else if (menu.equals("5")) {
			req.getSession().setAttribute("menuResponsable", 5);
			req.getSession().setAttribute("planEstudios_list", PlanEstudiosDAOImplementation.getInstance().readAll());
			req.getSession().setAttribute("asignaturas_list", AsignaturaDAOImplementation.getInstance().readAll());
			Profesor profesor = (Profesor) req.getSession().getAttribute("profesor");
			List<Profesor> profesores = profesor.getDepartamento().getProfesores();
			req.getSession().setAttribute("profesorDepartamento_list", profesores);
			resp.sendRedirect(req.getContextPath() + "/LoginResponsable.jsp");


		} else if (menu.equals("6")) {
			req.getSession().setAttribute("menuResponsable", 6);
			req.getSession().setAttribute("planEstudios_list", PlanEstudiosDAOImplementation.getInstance().readAll());
			req.getSession().setAttribute("asignaturas_list", AsignaturaDAOImplementation.getInstance().readAll());
			Profesor profesor = (Profesor) req.getSession().getAttribute("profesor");
			List<Profesor> profesores = profesor.getDepartamento().getProfesores();
			req.getSession().setAttribute("profesorDepartamento_list", profesores);
			resp.sendRedirect(req.getContextPath() + "/LoginResponsable.jsp");

		


		}else if (menu.equals("9")) {
			Profesor profesor = (Profesor) req.getSession().getAttribute("profesor");
			
			
			req.getSession().setAttribute("menuResponsable", 9);
			req.getSession().setAttribute("planEstudios_list", PlanEstudiosDAOImplementation.getInstance().readAll());
			req.getSession().setAttribute("profesor", profesor);
			resp.sendRedirect(req.getContextPath() + "/LoginResponsable.jsp");

		}

	}

}
