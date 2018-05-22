package es.upm.dit.isst.gestionDoc.servlets;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itextpdf.kernel.color.DeviceRgb;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.TextAlignment;
import com.itextpdf.layout.property.UnitValue;
import com.itextpdf.test.annotations.type.SampleTest;
import org.junit.experimental.categories.Category;



import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.io.source.ByteArrayOutputStream;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Image;
import java.util.List;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.test.annotations.WrapToTest;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.TabStop.Alignment;
import com.itextpdf.text.pdf.PdfPCell;
import java.io.FileOutputStream;
import com.itextpdf.layout.element.Table;

import es.upm.dit.isst.gestionDoc.dao.DepartamentoDAOImplementation;
import es.upm.dit.isst.gestionDoc.dao.ProfesorDAOImplementation;
import es.upm.dit.isst.gestionDoc.dao.model.Asignatura;
import es.upm.dit.isst.gestionDoc.dao.model.Departamento;
import es.upm.dit.isst.gestionDoc.dao.model.Profesor;

import com.itextpdf.io.image.ImageData;




/**
 * Servlet implementation class GenerarPDFServlet
 */
@WebServlet("/GenerarPDFServlet")
public class GenerarPDFServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String foto = "jm.jpg";
	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		ServletOutputStream sout = response.getOutputStream();
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PdfDocument pdf = new PdfDocument(new PdfWriter(baos));
		Document document = new Document(pdf);


		Profesor profesor = (Profesor) request.getSession().getAttribute("profesor");

		//ProfesorDAOImplementation.getInstance().readProfesor(profesor.getEmail());
		Departamento codigoDepartamento = profesor.getDepartamento();
		
		System.out.println(codigoDepartamento.getAsignaturas().size());
		System.out.println(codigoDepartamento.getCodigo());
		
		Paragraph p = new Paragraph("Asignaturas del departamento "+ codigoDepartamento.getNombre())
				.setFontSize(20);
		document.add(p);

		//		Image jm = new Image(ImageDataFactory.create(foto));
		//		Paragraph g = new Paragraph("Celeberrimo JM").add(jm);
		//		document.add(g);
		
		
	
//		
//		for (Asignatura asignatura : codigoDepartamento.getAsignaturas())
//			System.out.println(asignatura.getNombre());
//		
//			

		float [] columnWidths = {1,1,2,1,1};
	
		
		Table namespaces = new Table(UnitValue.createPercentArray(columnWidths));
		
	
		namespaces.addCell("CODIGO").setTextAlignment(TextAlignment.CENTER);
		namespaces.addCell("Creditos").setTextAlignment(TextAlignment.CENTER);
		namespaces.addCell("Nombre Asignatura").setTextAlignment(TextAlignment.CENTER);
		namespaces.addCell("Horas Asignadas").setTextAlignment(TextAlignment.CENTER);
		namespaces.addCell("Codigo Plan de estudios").setTextAlignment(TextAlignment.CENTER);
		
		
		for (Asignatura asign : codigoDepartamento.getAsignaturas()) {
			//Table tabla = new Table(UnitValue.createPercentArray(columnWidths));
	
			Cell celda = new Cell().add(new Paragraph(asign.getCodigo()).setTextAlignment(TextAlignment.CENTER));
			namespaces.addCell(celda).setAutoLayout();
		
			celda = new Cell().add(new Paragraph(asign.getCreditos()).setTextAlignment(TextAlignment.CENTER));
			namespaces.addCell(celda).setAutoLayout();
		
			celda = new Cell().add(new Paragraph(asign.getNombre())).setTextAlignment(TextAlignment.CENTER);
			namespaces.addCell(celda).setAutoLayout();
		
			celda = new Cell().add(new Paragraph(Integer.toString(asign.getHorasLaboratorio()+asign.getHorasPractica()+
					asign.getHorasTeoria())).setTextAlignment(TextAlignment.CENTER));
			namespaces.addCell(celda).setAutoLayout();
		
			celda = new Cell().add(new Paragraph(asign.getPlanEstudios().getCodigo()));
			namespaces.addCell(celda).setAutoLayout();
			
			
			

		}
		document.add(namespaces);
		


		// Se cierra el documento
		document.close();

		pdf.close();

		response.setContentType("application/pdf");
		response.setContentLength(baos.size());
		baos.writeTo(sout);

	}

}

