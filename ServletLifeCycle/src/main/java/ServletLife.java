import java.io.IOException;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet("/ServletLife")
public class ServletLife extends HttpServlet {
	static {
		System.out.println("Servlet is loaded");
	}
    public ServletLife() {
        System.out.println("Servlet obj created");
    }

	public void init(ServletConfig config) throws ServletException {
		System.out.println("Servlet initialised");
	}


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Service method to handle http request and to response back");
	}
	
	public void destroy() {
		// TODO Auto-generated method stub
	}

}
