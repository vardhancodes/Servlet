

import java.io.IOException;

import com.sun.net.httpserver.Authenticator.Success;

import jakarta.annotation.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/RegisterServletApp")
public class RegisterServletApp extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("uname");
		String city = request.getParameter("ucity");
		

		response.sendRedirect("suc.html");
	}

}
