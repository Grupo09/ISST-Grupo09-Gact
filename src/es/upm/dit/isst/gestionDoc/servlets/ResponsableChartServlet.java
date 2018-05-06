package es.upm.dit.isst.gestionDoc.servlets;

import java.awt.Color;
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
import es.upm.dit.isst.gestionDoc.dao.DepartamentoDAOImplementation;
import es.upm.dit.isst.gestionDoc.dao.ProfesorDAOImplementation;
import es.upm.dit.isst.gestionDoc.dao.model.Asignacion;
import es.upm.dit.isst.gestionDoc.dao.model.Asignatura;
import es.upm.dit.isst.gestionDoc.dao.model.Departamento;
import es.upm.dit.isst.gestionDoc.dao.model.Profesor;

/**
 * Servlet implementation class JFreeChartServlet
 */
@WebServlet("/ResponsableChartServlet")

public class ResponsableChartServlet extends HttpServlet {
 private static final long serialVersionUID = 1L;

 /**
  * @see HttpServlet#HttpServlet()
  */
 public ResponsableChartServlet() {
  super();
  // TODO Auto-generated constructor stub
 }

 /**
  * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
  *      response)
  */
 protected void doGet(HttpServletRequest request,
   HttpServletResponse response) throws ServletException, IOException {

	 
 String codigo = request.getParameter("depart");
 Departamento departamento = DepartamentoDAOImplementation.getInstance().readDepartamento(codigo);
 
 


  response.setContentType("image/png");

  ServletOutputStream os = response.getOutputStream();

  DefaultCategoryDataset dataset = new DefaultCategoryDataset();
  
  List<Asignatura> asignaturas = departamento.getAsignaturas();
  for(Asignatura a : asignaturas) {
 	 List<Asignacion>  asignaciones = a.getAsignaciones();
 	 	  
 		  dataset.addValue(asignaciones.size(),a.getAcronimo() , a.getNombre());

 	 
  }

  
  String text = "Profesores en el "+departamento.getNombre();

  JFreeChart chart = ChartFactory.createBarChart(text, "",
    "Profesores", dataset, PlotOrientation.VERTICAL, true, true, false);
 
  chart.setBackgroundPaint(Color.CYAN);

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
