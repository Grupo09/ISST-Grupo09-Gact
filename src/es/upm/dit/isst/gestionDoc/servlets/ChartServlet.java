package es.upm.dit.isst.gestionDoc.servlets;

import java.awt.image.RenderedImage;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import es.upm.dit.isst.gestionDoc.dao.AsignacionDAOImplementation;
import es.upm.dit.isst.gestionDoc.dao.AsignaturaDAOImplementation;
import es.upm.dit.isst.gestionDoc.dao.ProfesorDAOImplementation;
import es.upm.dit.isst.gestionDoc.dao.model.Asignacion;
import es.upm.dit.isst.gestionDoc.dao.model.Asignatura;
import es.upm.dit.isst.gestionDoc.dao.model.Profesor;

/**
 * Servlet implementation class JFreeChartServlet
 */
@WebServlet("/ChartServlet")

public class ChartServlet extends HttpServlet {
 private static final long serialVersionUID = 1L;

 /**
  * @see HttpServlet#HttpServlet()
  */
 public ChartServlet() {
  super();
  // TODO Auto-generated constructor stub
 }

 /**
  * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
  *      response)
  */
 protected void doGet(HttpServletRequest request,
   HttpServletResponse response) throws ServletException, IOException {

	 
 String email = request.getParameter("coord");
 Profesor coordinador = ProfesorDAOImplementation.getInstance().readProfesor(email);
 List<Asignatura> asignaturas  = AsignaturaDAOImplementation.getInstance().readAsignaturaCoordinador(coordinador);
 Asignatura asig = asignaturas.get(0);
 
 List<Asignacion> asignacion = asig.getAsignaciones();
 
 
 


  response.setContentType("image/png");

  ServletOutputStream os = response.getOutputStream();

  DefaultCategoryDataset dataset = new DefaultCategoryDataset();
  
  for(Asignacion a : asignacion) {
	  dataset.addValue(a.getHorasPractica(),"Practica" , a.getProfesor().getNombre());
	  dataset.addValue(a.getHorasLaboratorio(),"Laboratorio" , a.getProfesor().getNombre());
	  dataset.addValue(a.getHorasTeoria(),"Teoria" , a.getProfesor().getNombre());

	}
  
  String text = "Horas totales de "+asig.getAcronimo();

  JFreeChart chart = ChartFactory.createBarChart(text, "",
    "Value", dataset, PlotOrientation.VERTICAL, true, true, false);

  RenderedImage chartImage = chart.createBufferedImage(300, 300);
  ImageIO.write(chartImage, "png", os);
  os.flush();
  os.close();
 }
 
 /**
  * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
  *      response)
  */
 protected void doPost(HttpServletRequest request,
   HttpServletResponse response) throws ServletException, IOException {

 }

}