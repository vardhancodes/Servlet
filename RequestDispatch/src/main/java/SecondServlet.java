

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/SecondServlet")
public class SecondServlet extends HttpServlet {
	
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter writer = response.getWriter();	
		HttpSession session = request.getSession(false);
		String name = (String) session.getAttribute("name");
		
		writer.println("<h1>Response from second Servlet </h1>" + name);
		writer.close();	
	}

}
