

import java.awt.print.Printable;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/ServletApp")
public class ServletApp extends HttpServlet {


	public void doPost(jakarta.servlet.http.HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("uname");
		String city =  request.getParameter("ucity");
		
		if(name.equals("Rohan") && city.equals("Pune"))
		{
			System.out.println("success! He is the right rohan logged in");
		}
		else {
			
			System.out.println("Diff rohan logged in");
		}
	}

}
