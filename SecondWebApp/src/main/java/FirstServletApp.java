import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
@WebServlet("/firstServlet")
public class FirstServletApp extends HttpServlet {
	
	
	public FirstServletApp() {
		System.out.println("Servlet obj is created");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name = request.getParameter("uname");
		String city = request.getParameter("ucity");
		
		PrintWriter writer = response.getWriter();
		
		writer.println("Hello " + name);
		writer.println("I know you are from " + city);
		
		writer.close();		
		
	}

}
