package Busc;


import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Recibidor
 */
@WebServlet("/Recibidor")
public class Recibidor extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	// Method to handle GET method request.
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Set response content type
		response.setContentType("text/html");

		String resultado = Buscador.Buscar( request.getParameter("feedback"), request.getParameter("campo"));
		PrintWriter out = response.getWriter();
		
		String title = "¡UGA UGA BUSCA!";
		String docType = "<!doctype html public \"-//w3c//dtd html 4.0 "
				+ "transitional//en\">\n";
		out.println(docType + "<html>\n" + "<head><title>" + title
				+ "</title>"+"<style>\n"+"table {\nwidth:100%;}\ntable, th, td{\nborder:1px solid black;\n"+
				"border-collapse: collapse;}\nth, td{\npadding: 5px;\ntext-align: left;}\n"+
				"table#t01 tr:nth-child(even){\nbackground-color:#eee;}\n"+
				"table#t01 tr:nth-child(odd){\nbackground-color:#fff;}"+
				"table#t01 th{\nbackground-color: black;\ncolor: white;}\n"
				+ "</head>\n</style>\n" + "<body bgcolor=\"#F6F3EC\">\n"
				+ "<h1 align=\"center\">" + title + "</h1>\n" + "<ul>\n"
				+ "  <li><b>Mostrando resultados de : </b>: "
				+ request.getParameter("feedback") + "\n" + "</ul>\n"
				/*+ "</body></html>"*/);
		out.println("<div align='center'>\n");
		out.println("<div  style='height:240px;width:900px;border:1px solid #ccc;font:16px/26px Georgia, Garamond, Serif;overflow:auto;'>\n");
		out.println("<table id='t01'>\n");
		out.println("<tr>\n<th>Contenido</th>\n<th>Fecha</th>\n<th>Usuario</th>\n</tr>");
		out.println(resultado);
		out.println("</table>\n"+"</div>\n"+"</body></html>");

		
	}

	// Method to handle POST method request.
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

	}
}
