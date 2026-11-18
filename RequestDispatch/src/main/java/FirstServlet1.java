

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.net.Authenticator.RequestorType;
import java.net.http.HttpRequest;

import javax.print.attribute.standard.Chromaticity;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/FirstServlet1")
public class FirstServlet1 extends HttpServlet {

	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("CONTROL IN FIRST SERVLET");
		String name = request.getParameter("uname");
		String city = request.getParameter("ucity");
		
		 HttpSession session = request.getSession();
		 session.setAttribute("name", name);
		
		RequestDispatcher rDispatcher = request.getRequestDispatcher("/SecondServlet");
		
		
		PrintWriter printWriter =response.getWriter();
		printWriter.println("<h1> Response from servlet 1 </h1>");
		rDispatcher.forward(request, response);
		printWriter.close();	
	}

}
