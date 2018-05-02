package es.upm.dit.isst.gestionDoc.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.upm.dit.isst.gestionDoc.dao.AsignaturaDAOImplementation;
import es.upm.dit.isst.gestionDoc.dao.model.Asignacion;
import es.upm.dit.isst.gestionDoc.dao.model.Asignatura;

/**
 * Servlet implementation class LoginCoordinadorServlet
 */
@WebServlet("/LoginCoordinadorServlet")
public class LoginCoordinadorServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String menu = req.getParameter("menu");
		System.out.println(menu);
		if (null == menu || menu.equals("0")) {
			req.getSession().setAttribute("menuCoordinador", 0);
			resp.sendRedirect(req.getContextPath() + "/LoginCoordinador.jsp");
			req.getSession().setAttribute("asignaturas_list", AsignaturaDAOImplementation.getInstance().readAll());
		} else if (menu.equals("1")) {
			String codigo = req.getParameter("codigo");
			for (Asignatura asignatura : AsignaturaDAOImplementation.getInstance().readAll()) {
				if (asignatura.getCodigo().equals(codigo)) {
					req.getSession().setAttribute("asignatura", asignatura);
					req.getSession().setAttribute("menuCoordinador", 1);
					int horasLaboratorio = 0;
					int horasPractica = 0;
					int horasTeoria = 0;

					for (Asignacion asignacion : asignatura.getAsignaciones()) {
						horasLaboratorio += asignacion.getHorasLaboratorio();
						horasPractica += asignacion.getHorasPractica();
						horasTeoria += asignacion.getHorasTeoria();
					}
					req.getSession().setAttribute("horasLaboratorio", horasLaboratorio);
					req.getSession().setAttribute("horasPractica", horasPractica);
					req.getSession().setAttribute("horasTeoria", horasTeoria);

					resp.sendRedirect(req.getContextPath() + "/LoginCoordinador.jsp");
				}
			}

		}

	}

}
