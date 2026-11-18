

import java.io.IOException;

import com.sun.net.httpserver.Authenticator.Success;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@WebServlet("/Register")
public class Register extends HttpServlet {

	protected void service(jakarta.servlet.http.HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("uname");
		String pass = request.getParameter("password");
		String mail = request.getParameter("email");
		String city = request.getParameter("ucity");
		
		Model model = new Model();
		model.setUnameString(name);
		model.setUemString(mail);
		model.setUpassString(pass);
		model.setUcityString(city);
		
		int row=model.register();
		
		HttpSession session = request.getSession();
		session.setAttribute("n", name);
		if(row == 0)
		{
			response.sendRedirect("Failure.jsp");
		}
		else 
		{
			response.sendRedirect("Success.jsp");
		}
		
	}

}


