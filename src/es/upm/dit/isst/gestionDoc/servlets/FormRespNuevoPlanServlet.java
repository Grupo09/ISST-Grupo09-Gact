package es.upm.dit.isst.gestionDoc.servlets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import es.upm.dit.isst.gestionDoc.dao.PlanEstudiosDAOImplementation;
import es.upm.dit.isst.gestionDoc.dao.model.PlanEstudios;

/**
 * Servlet implementation class FormRespNuevaAsignaturaServlet
 */
@WebServlet("/FormRespNuevoPlanServlet")
public class FormRespNuevoPlanServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String menu = req.getParameter("menu");

		if (menu == null) {
			menu="0";
		}
		System.out.println(menu);
		PlanEstudios plan = new PlanEstudios();

		if (menu.equals("1")) {

			try {

				URL url = new URL("https://www.upm.es/wapi_upm/academico/comun/index.upm/v2/centro.json/9/planes");

				HttpURLConnection conn= (HttpURLConnection) url.openConnection();
				conn.setRequestMethod("GET");
				conn.setRequestProperty("Accept", "application/json");

				if (conn.getResponseCode()!= 200) {
					throw new RuntimeException("Failed : HTTP error code : "
							+ conn.getResponseCode());
				}

				BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));

				String output;

				while((output = br.readLine()) !=null) {


					System.out.println(output);

						JSONArray json = new JSONArray(output.trim());
						for (int i = 0 ; i < json.length(); i++) {

							JSONObject prueba = json.getJSONObject(i);

							Iterator <?> keys = prueba.keys();

							while (keys.hasNext()) {
								String key = (String) keys.next();

								//Ahora aqui tengo que coger los parametros que necesito.

								if ( key.equals("codigo")) {
									plan.setCodigo(prueba.getString(key));
								}
								if ( key.equals("nombre")) {
									plan.setNombre(prueba.getString(key));
								}
								if ( key.equals("nombre")) {

									//Metodo para obtner un acronimo
								

									String acronimo=prueba.getString(key).substring(0, 4);
									plan.setAcronimo(acronimo);
								}

							}
							PlanEstudiosDAOImplementation.getInstance().createPlanEstudios(plan);

						}


					}


				conn.disconnect();

			}catch (MalformedURLException e) {
				e.printStackTrace();
				// TODO: handle exception
			}catch(IOException e) {
				e.printStackTrace();
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}


			resp.sendRedirect(req.getContextPath()+"/LoginSecretaria.jsp");

		}else {

			String codigo = req.getParameter("codigo");
			String nombre = req.getParameter("nombre");
			String acronimo = req.getParameter("acronimo");

			plan = new PlanEstudios();
			plan.setCodigo(codigo);
			plan.setNombre(nombre);
			plan.setAcronimo(acronimo);


			PlanEstudiosDAOImplementation.getInstance().createPlanEstudios(plan);


			req.getSession().setAttribute("menuResponsable", 0);
			resp.sendRedirect(req.getContextPath()+"/LoginResponsable.jsp");
		}



	}
}
