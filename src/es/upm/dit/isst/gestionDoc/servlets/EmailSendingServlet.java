package es.upm.dit.isst.gestionDoc.servlets;
 
import java.io.IOException;
 
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.upm.dit.isst.gestionDoc.util.EmailUtility;
 
/**
 * A servlet that takes message details from user and send it as a new e-mail
 * through an SMTP server.
 *
 * @author www.codejava.net
 *
 */
@WebServlet("/EmailSendingServlet")
public class EmailSendingServlet extends HttpServlet {
    private String host = "localhost";
    private String port= "2525";
 
    public void init() {
        // reads SMTP server setting from web.xml file
        ServletContext context = getServletContext();
        host = context.getInitParameter("host");
    }
 
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        // reads form fields
        String recipient = request.getParameter("recipient");
        String user = request.getParameter("user");
        String subject = request.getParameter("subject");
        String content = request.getParameter("content");
        try {
            EmailUtility.sendEmail(port, user, recipient, subject,
                    content);
        } catch (Exception ex) {         
        } finally {
        	request.getSession().setAttribute("menuProfesor", 0);
			response.sendRedirect(request.getContextPath() + "/LoginProfesor.jsp");
        }
    }
}
