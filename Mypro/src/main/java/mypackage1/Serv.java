package mypackage1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Serv
 */
@WebServlet("/Serv")
public class Serv extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		

		String name =request.getParameter("name");
		String email =request.getParameter("email");
		String pass =request.getParameter("pass");
		PrintWriter ps=response.getWriter();
		ps.println("<html><body><h1>your name is :"+name+"</h1>");
		ps.println("<h1>Your email id is :"+email+"</h1>");
		ps.println("<h1>Your pass is :"+pass+"</h1>");	
		ps.println("</body></html>");
	}

}
