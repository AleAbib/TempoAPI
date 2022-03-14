package tempo.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.ws.Response;

import com.google.gson.Gson;

import tempo.model.Cidade;

@WebServlet("/frete")
public class FreteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			HttpSession sessao = req.getSession();
			Cidade cidade = (Cidade) sessao.getAttribute("cidadeLogada");

	        URL url = new URL("https://api.hgbrasil.com/weather?locale=pt&key=acd8d9b6&array_limit=5&fields=only_results,"
	                + "city_name,date,weekday,description,condition,temp,forecast,max,min,date&city_name="+cidade.getNome());
	        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
	        
	        connection.setRequestMethod("GET");
	        BufferedReader buffer = new BufferedReader(new InputStreamReader(connection.getInputStream()));
	        String output = new String(buffer.readLine().getBytes("UTF-8"));
	        connection.disconnect();

			resp.getWriter().print(output);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
