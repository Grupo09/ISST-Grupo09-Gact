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

import com.itextpdf.text.log.SysoCounter;

import es.upm.dit.isst.gestionDoc.dao.AsignaturaDAOImplementation;
import es.upm.dit.isst.gestionDoc.dao.DepartamentoDAO;
import es.upm.dit.isst.gestionDoc.dao.DepartamentoDAOImplementation;
import es.upm.dit.isst.gestionDoc.dao.PlanEstudiosDAOImplementation;
import es.upm.dit.isst.gestionDoc.dao.ProfesorDAOImplementation;
import es.upm.dit.isst.gestionDoc.dao.model.Asignatura;
import es.upm.dit.isst.gestionDoc.dao.model.Departamento;
import es.upm.dit.isst.gestionDoc.dao.model.PlanEstudios;
import es.upm.dit.isst.gestionDoc.dao.model.Profesor;

/**
 * Servlet implementation class LoginResponsableServlet
 */
@WebServlet("/LoginResponsableServlet")
public class LoginResponsableServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String menu = req.getParameter("menu");
		System.out.println(menu);
		if (null == menu || menu.equals("0")) {
			req.getSession().setAttribute("menuResponsable", 0);
			resp.sendRedirect(req.getContextPath() + "/LoginResponsable.jsp");
		} else if (menu.equals("1")) {

			req.getSession().setAttribute("menuResponsable", 1);

			resp.sendRedirect(req.getContextPath() + "/LoginResponsable.jsp");

		} else if (menu.equals("2")) {

			req.getSession().setAttribute("menuResponsable", 2);
			req.getSession().setAttribute("plan_list", PlanEstudiosDAOImplementation.getInstance().readAll());

			resp.sendRedirect(req.getContextPath() + "/LoginResponsable.jsp");

		} else if (menu.equals("3")) {
			req.getSession().setAttribute("menuResponsable", 3);
			req.getSession().setAttribute("planEstudios_list", PlanEstudiosDAOImplementation.getInstance().readAll());
			Profesor profesor = (Profesor) req.getSession().getAttribute("profesor");
			List<Profesor> profesores = profesor.getDepartamento().getProfesores();
			req.getSession().setAttribute("profesorDepartamento_list", profesores);
			resp.sendRedirect(req.getContextPath() + "/LoginResponsable.jsp");
		} else if (menu.equals("4")) {
			req.getSession().setAttribute("menuResponsable", 4);
			req.getSession().setAttribute("planEstudios_list", PlanEstudiosDAOImplementation.getInstance().readAll());
			req.getSession().setAttribute("asignaturas_list", AsignaturaDAOImplementation.getInstance().readAll());
			Profesor profesor = (Profesor) req.getSession().getAttribute("profesor");
			List<Profesor> profesores = profesor.getDepartamento().getProfesores();
			req.getSession().setAttribute("profesorDepartamento_list", profesores);
			resp.sendRedirect(req.getContextPath() + "/LoginResponsable.jsp");

		} else if (menu.equals("5")) {
			req.getSession().setAttribute("menuResponsable", 5);
			req.getSession().setAttribute("planEstudios_list", PlanEstudiosDAOImplementation.getInstance().readAll());
			req.getSession().setAttribute("asignaturas_list", AsignaturaDAOImplementation.getInstance().readAll());
			Profesor profesor = (Profesor) req.getSession().getAttribute("profesor");
			List<Profesor> profesores = profesor.getDepartamento().getProfesores();
			req.getSession().setAttribute("profesorDepartamento_list", profesores);
			resp.sendRedirect(req.getContextPath() + "/LoginResponsable.jsp");


		} else if (menu.equals("6")) {
			req.getSession().setAttribute("menuResponsable", 6);
			req.getSession().setAttribute("planEstudios_list", PlanEstudiosDAOImplementation.getInstance().readAll());
			req.getSession().setAttribute("asignaturas_list", AsignaturaDAOImplementation.getInstance().readAll());
			Profesor profesor = (Profesor) req.getSession().getAttribute("profesor");
			List<Profesor> profesores = profesor.getDepartamento().getProfesores();
			req.getSession().setAttribute("profesorDepartamento_list", profesores);
			resp.sendRedirect(req.getContextPath() + "/LoginResponsable.jsp");

		}
		else if (menu.equals("7")) {
			Departamento departamento = new Departamento();

			DepartamentoDAO dao = DepartamentoDAOImplementation.getInstance();
			try {

				URL url = new URL("https://www.upm.es/wapi_upm/academico/comun/index.upm/v2/departamento.json");

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

			resp.sendRedirect(req.getContextPath()+"/LoginResponsable.jsp");
		}

		// Aqui voy a tratart como meter todos los planes de estudios
		else if (menu.equals("8")) {
			String codigo = req.getParameter("codigo");

			PlanEstudios plan = new PlanEstudios();



			try {

				URL url = new URL("https://www.upm.es/wapi_upm/academico/comun/index.upm/v2/plan.json");

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

				while((output = br.readLine()) !=null) {


					System.out.println(output);

					JSONObject json1 = new JSONObject(output.trim());

					Iterator <?> keys1 = json1.keys();

					while (keys1.hasNext()) {

						String key1 = (String) keys1.next();


						json = (JSONArray) json1.getJSONArray(key1);

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
									String acronimo="";
									String arr [] = prueba.getString(key).split(("\\s+"));

									for (String s : arr) {
										acronimo=acronimo + s.substring(0,1);

									}
									System.out.println(acronimo);
									plan.setAcronimo(acronimo);
								}

							}
							PlanEstudiosDAOImplementation.getInstance().createPlanEstudios(plan);

						}


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



			req.getSession().setAttribute("menuResponsable", 0);
			resp.sendRedirect(req.getContextPath()+"/LoginResponsable.jsp");



		}else if (menu.equals("9")) {

			req.getSession().setAttribute("menuResponsable", 9);
			req.getSession().setAttribute("planEstudios_list", PlanEstudiosDAOImplementation.getInstance().readAll());

			resp.sendRedirect(req.getContextPath() + "/LoginResponsable.jsp");

		}

	}

}
