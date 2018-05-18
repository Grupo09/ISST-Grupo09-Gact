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
import org.jfree.chart.labels.PieSectionLabelGenerator;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

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
 	 
 	  double horasPracticas = 0;
 	  double horasLaboratorio =0;
 	  double horasTeoria =0;
 	  double horasTotales = a.getHorasLaboratorio()+a.getHorasPractica()+a.getHorasTeoria();
 	  
 	  for(Asignacion as : asignaciones) {
 		  horasPracticas += as.getHorasPractica();
 		  horasLaboratorio += as.getHorasLaboratorio();
 		  horasTeoria += as.getHorasTeoria();

 		}
 	  
 


 	  
 	 double porcentaje = 100*((horasPracticas+horasLaboratorio+horasTeoria)/horasTotales);
 	  System.out.println("adios");


 	 dataset.addValue(porcentaje, a.getAcronimo(), a.getNombre());
 	 
 	
 		  

 	 
  }

  
  String text = "Profesores en el "+departamento.getNombre();

  JFreeChart chart = ChartFactory.createBarChart(text, "Asignaturas", "Horas asignadas", dataset, PlotOrientation.VERTICAL, true, true, false);
 
		  chart.getPlot().setBackgroundPaint(Color.WHITE);
		  chart.getPlot().setOutlinePaint(Color.WHITE);
		  chart.getLegend().setBorder(0,0,0,0);
		  chart.getCategoryPlot().getRangeAxis().setRange(0,100);
		  chart.getLegend().visible=false;
		
		  /*
		  PiePlot plot = (PiePlot)chart.getPlot();
		  PieSectionLabelGenerator labelGenerator = new StandardPieSectionLabelGenerator("{1}");
		  plot.setLabelGenerator(labelGenerator);
		  */

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
