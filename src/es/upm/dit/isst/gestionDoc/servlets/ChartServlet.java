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

 Asignatura asig = AsignaturaDAOImplementation.getInstance().readAsignatura(request.getParameter("asig"));
 
 List<Asignacion> asignacion = asig.getAsignaciones();
 
 
 


  response.setContentType("image/png");

  ServletOutputStream os = response.getOutputStream();
  
  DefaultPieDataset dataset = new DefaultPieDataset();

  //DefaultCategoryDataset dataset = new DefaultCategoryDataset();
  
  int horasPracticas = 0;
  int horasLaboratorio =0;
  int horasTeoria =0;
  int horasTotales = asig.getHorasLaboratorio()+asig.getHorasPractica()+asig.getHorasTeoria();
  
  for(Asignacion a : asignacion) {
	  horasPracticas += a.getHorasPractica();
	  horasLaboratorio += a.getHorasLaboratorio();
	  horasTeoria += a.getHorasTeoria();

	}
  
  dataset.setValue("Sin asignar", horasTotales-horasTeoria-horasLaboratorio-horasPracticas);
  dataset.setValue("Laboratorio", horasLaboratorio);
  dataset.setValue("Practicas", horasPracticas);
  dataset.setValue("Teoria", horasTeoria);
  
  

  

  JFreeChart chart = ChartFactory.createPieChart("Asignación de horas", dataset, true, true, false);
  chart.getPlot().setBackgroundPaint(Color.WHITE);
  chart.getPlot().setOutlinePaint(Color.WHITE);
  chart.getLegend().setBorder(0,0,0,0);
  
  PiePlot plot = (PiePlot)chart.getPlot();
  PieSectionLabelGenerator labelGenerator = new StandardPieSectionLabelGenerator("{2}");
  plot.setLabelGenerator(labelGenerator);

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