package es.upm.dit.isst.gestionDoc.servlets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
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

import es.upm.dit.isst.gestionDoc.dao.AsignaturaDAOImplementation;
import es.upm.dit.isst.gestionDoc.dao.DepartamentoDAOImplementation;
import es.upm.dit.isst.gestionDoc.dao.PlanEstudiosDAOImplementation;
import es.upm.dit.isst.gestionDoc.dao.model.Asignatura;
import es.upm.dit.isst.gestionDoc.dao.model.PlanEstudios;

/**
 * Servlet implementation class RellenarAsignaturaApiServlet
 */
@WebServlet("/RellenarAsignaturaApiServlet")
public class RellenarAsignaturaApiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String planEstudiosCodigo = req.getParameter("planEstudios");
		String departamentoCodigo = req.getParameter("departamento");
		boolean javot = false;




		PlanEstudios plan = PlanEstudiosDAOImplementation.getInstance().readPlanEstudios(planEstudiosCodigo);

		Asignatura asignatura = new Asignatura();
		AsignaturaDAOImplementation asigna = AsignaturaDAOImplementation.getInstance();

		System.out.println("/"+departamentoCodigo+"/"+planEstudiosCodigo);


		try {

			URL url = new URL("https://www.upm.es/wapi_upm/academico/comun/index.upm/v2/departamento.json/"
					+ departamentoCodigo+"/"
					+ planEstudiosCodigo+
					"/asignaturas");

			HttpURLConnection conn= (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");

			if (conn.getResponseCode()!= 200) {
				//				throw new RuntimeException("Failed : HTTP error code : "
				//						+ conn.getResponseCode());
				
				resp.setContentType("text/html;charset=UTF-8");
				PrintWriter out = resp.getWriter();
				out.println("<script type=\"text/javascript\">");
				out.println("alert('Javot lavate la boca');");
				out.println("location='LoginResponsablePerfil.jsp';");
				out.println("</script>");



			}

			BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));

			String output;
			//JSONArray json = new JSONArray();

			while((output = br.readLine()) !=null) {


				System.out.println(output);
				
				
				//Salida de la lectura si el JSON que me llega está vacio.
				if (output.equals("[]")) {
					break;
				}

				JSONObject json1 = new JSONObject(output.trim());

				Iterator <?> keys1 = json1.keys();

				while (keys1.hasNext()) {

					String key1 = (String) keys1.next();

					JSONObject prueba = json1.getJSONObject(key1);

					Iterator <?> keys = prueba.keys();

					while (keys.hasNext()) {
						String key = (String) keys.next();

						//Ahora aqui tengo que coger los parametros que necesito.

						if ( key.equals("codigo")) {
							asignatura.setCodigo(prueba.getString(key));
						}
						if ( key.equals("nombre")) {
							asignatura.setNombre(prueba.getString(key));
						}
						if ( key.equals("nombre")) {

							//Metodo para obtner un acronimo
//							String acronimo="";
//							String arr [] = prueba.getString(key).split(("\\s+"));
//
//							for (String s : arr) {
//								acronimo=acronimo + s.substring(0,1);
//
							String acronimo=prueba.getString(key).substring(0, 4);
					

							asignatura.setAcronimo(acronimo);
						}
						if ( key.equals("curso")) {
							if (prueba.getString(key).isEmpty()) {
								int aleatori = (int) Math.round((Math.random()*3+1));
								asignatura.setCurso(aleatori );
							}else {
								asignatura.setCurso(Integer.parseInt(prueba.getString(key)));
							}
						}
						if ( key.equals("crepra") || key.equals("credects") || key.equals("creteo") ) {
							asignatura.setCreditos(prueba.getString(key));
						}
						if ( key.equals("departamentos")) {
							//Ahora tengo que extraer el jsonArray

							JSONArray arrDepar = prueba.getJSONArray(key);

							//Ahora recorremos el JSON ARRAY
							for ( int i = 0 ; i < arrDepar.length(); i++) {

								JSONObject pruebaArrDepar = arrDepar.getJSONObject(i);

								Iterator <?> keysArrDepar = pruebaArrDepar.keys();

								//Ahora recorro el JSON Object


								while (keysArrDepar.hasNext()) {
									String keyArrDepar = (String) keysArrDepar.next();

									System.out.println(keyArrDepar);

									if ( keyArrDepar.equals("codigo_departamento")) {
										asignatura
										.setDepartamentoAsignatura
										(DepartamentoDAOImplementation
												.getInstance()
												.readDepartamento(pruebaArrDepar.getString(keyArrDepar)));
									}



								}

							}
						}

						//Hay algunas asignatura que tienen el campo nulo
						if ( key.equals("imparticion") && !(prueba.get(key).toString().equals("[]"))) {
							//Ahora tengo que extraer el jsonObject
							System.out.println(prueba.getString(key));

							JSONObject jsonImpart = prueba.getJSONObject(key);
							Iterator <?> keysImpart = jsonImpart.keys();

							while (keysImpart.hasNext()) {
								String keyArrImpart = (String) keysImpart.next();

								if ( keyArrImpart.equals("1S")) {
									//Ahora obtengo el jsonObject

									JSONObject jsonSemester = jsonImpart.getJSONObject(keyArrImpart);
									Iterator <?> keysSemester = jsonSemester.keys();

									while (keysSemester.hasNext()) {
										String keyArrSemester = (String) keysSemester.next();

										//Ahora los campos que quiero encontrar
										if ( keyArrSemester.equals("codigo_duracion")) {

											//TODO 

											int semester = (int) Math.floor(Math.random()*2 + 1);

											asignatura.setSemestre(semester);
										}
										if ( keyArrSemester.equals("grupos_matricula")) {

											//Saco el JSONArray

											JSONArray jsonGrupo = jsonSemester.getJSONArray(keyArrSemester);

											for (int  j = 0 ; j < jsonGrupo.length(); j++) {

												JSONObject pruebaArrGrupo = jsonGrupo.getJSONObject(j);

												Iterator <?> keysArrGrupo = pruebaArrGrupo.keys();

												//Ahora recorro el JSON Object


												while (keysArrGrupo.hasNext()) {
													String keyArrGrupo = (String) keysArrGrupo.next();

													if ( keyArrGrupo.equals("codigo_grupo")) {

														//Puede ser que el grupo no sea un INT, por lo que hay que analizar si es un STRING o un INTEGER
														try {
															int value = Integer.parseInt(pruebaArrGrupo.getString(keyArrGrupo));
															// Yes!  An integer.
															asignatura.setGrupos(value);
														} catch (NumberFormatException nfe) {

															nfe.printStackTrace();
															// Not an integer

														}finally {
															int value2= (int) Math.floor(Math.random()*200+1);
															asignatura.setGrupos(value2);
														}

													}


												}
											}

											asignatura.setSemestre(1);
										}

									}

								}
							}



						}


					}
					//Aqui va lo que es fijo cada momento
					asignatura.setHorasLaboratorio(0);
					asignatura.setHorasPractica(0);
					asignatura.setHorasTeoria(0);

					asignatura.setCoordinador(null);
					asignatura.setPlanEstudios(plan);
					asigna.createAsignatura(asignatura);




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






	}

}
