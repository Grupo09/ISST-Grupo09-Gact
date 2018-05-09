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

import es.upm.dit.isst.gestionDoc.dao.DepartamentoDAO;
import es.upm.dit.isst.gestionDoc.dao.DepartamentoDAOImplementation;
import es.upm.dit.isst.gestionDoc.dao.model.Departamento;

/**
 * Servlet implementation class FormNuevoDepartamentoServlet
 */
@WebServlet("/FormNuevoDepartamentoServlet")
public class FormNuevoDepartamentoServlet extends HttpServlet {

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
		DepartamentoDAO dao = DepartamentoDAOImplementation.getInstance();

		if (menu.equals("1")) {
			Departamento departamento = new Departamento();

			dao = DepartamentoDAOImplementation.getInstance();
			try {

				URL url = new URL("https://www.upm.es/wapi_upm/academico/comun/index.upm/v2/centro.json/9/departamentos");

				HttpURLConnection conn= (HttpURLConnection) url.openConnection();
				conn.setRequestMethod("GET");
				conn.setRequestProperty("Accept", "application/json");

				if (conn.getResponseCode()!= 200) {
					throw new RuntimeException("Failed : HTTP error code : "
							+ conn.getResponseCode());
				}


				BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));


				String output;
				JSONArray json = new JSONArray();

				System.out.println("Output from Server .... \n");
				while((output = br.readLine()) !=null) {

					System.out.println(output);

					json = new JSONArray(output.trim());

				}


				for (int i = 0 ; i < json.length(); i++) {

					JSONObject prueba = json.getJSONObject(i);

					Iterator <?> keys = prueba.keys();

					while (keys.hasNext()) {
						String key = (String) keys.next();
						System.out.println(key);
						System.out.println(prueba.get(key));


						if ( key.equals("codigo")) {
							departamento.setCodigo(prueba.getString(key));
						}
						if ( key.equals("nombre")) {
							departamento.setNombre(prueba.getString(key));
						}
						if ( key.equals("nombre")) {

							//Metodo para obtner un acronimo
							String acronimo="";
							String arr [] = prueba.getString(key).split(("\\s+"));

							for (String s : arr) {
								acronimo=acronimo + s.substring(0,1);


							}
							System.out.println(acronimo);
							departamento.setAcronimo(acronimo);
						}

					}
					departamento.setResponsable(null);
					dao.createDepartamento(departamento);

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

			//resp.sendRedirect(req.getContextPath()+"/LoginSecretaria.jsp");


			
		}else {

			String codigo = req.getParameter("codigo");
			String nombre = req.getParameter("nombre");
			String acronimo = req.getParameter("acronimo");
			Departamento departamento = new Departamento();
			departamento.setCodigo(codigo);
			departamento.setNombre(nombre);
			departamento.setAcronimo(acronimo);
			dao = DepartamentoDAOImplementation.getInstance();
			dao.createDepartamento(departamento);
		}
		dao = DepartamentoDAOImplementation.getInstance();
		req.getSession().setAttribute("departamento_list", dao.readAllDepartamento());
		resp.sendRedirect(req.getContextPath()+"/LoginSecretaria.jsp");
	}
}


