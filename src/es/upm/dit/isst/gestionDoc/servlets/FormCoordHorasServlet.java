package es.upm.dit.isst.gestionDoc.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.upm.dit.isst.gestionDoc.dao.AsignacionDAOImplementation;
import es.upm.dit.isst.gestionDoc.dao.model.Asignacion;

/**
 * Servlet implementation class FormCoordHorasServlet
 */
@WebServlet("/FormCoordHorasServlet")
public class FormCoordHorasServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FormCoordHorasServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		long asignacionId = new Long(Long.parseLong(request.getParameter("asignacion_id")));
		int horasLaboratorio = Integer.parseInt(request.getParameter("horasLaboratorio"));
		int horasPractica = Integer.parseInt(request.getParameter("horasPractica"));
		int horasTeoria = Integer.parseInt(request.getParameter("horasTeoria"));
		Asignacion asignacion = AsignacionDAOImplementation.instance.readAsociacion(asignacionId);
		asignacion.setHorasLaboratorio(horasLaboratorio);
		asignacion.setHorasPractica(horasPractica);
		asignacion.setHorasTeoria(horasTeoria);
		AsignacionDAOImplementation.instance.updateAsignacion(asignacion);
		
		String codigo=request.getParameter("codigo");
		response.sendRedirect(request.getContextPath() + "/LoginCoordinadorServlet?menu=1&codigo="+codigo);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
