import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/Register")
public class Register extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        System.out.println("Control in Servlet 1");
        
        String n = request.getParameter("uname");    
        String city = request.getParameter("ucity");
        String pass = request.getParameter("password");
        String em = request.getParameter("email");
        
        String url = "jdbc:mysql://localhost:3306/virajdb";
        String dbUser = "root";
        String dbPassword = ""; // Keep blank if your local MySQL has no password
        
        String query = "INSERT INTO register (uname, email, upassword, city) VALUES (?, ?, ?, ?)";

        // 1. Load the MySQL Driver
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "MySQL JDBC Driver not found.");
            return;
        }

        // 2. Try-with-resources automatically closes Connection and PreparedStatement safely
        try (Connection connect = DriverManager.getConnection(url, dbUser, dbPassword);
             PreparedStatement ps = connect.prepareStatement(query)) {
            
            if (connect != null) {
                System.out.println("Database connected successfully!");
            }

            // Set query parameters
            ps.setString(1, n);
            ps.setString(2, em);
            ps.setString(3, pass);
            ps.setString(4, city);

            int rows = ps.executeUpdate();
            
            response.setContentType("text/html");
            PrintWriter pt = response.getWriter();

            if (rows > 0) {
                pt.println("<h1>User registered successfully!</h1>");
            } else {
                pt.println("<h1>Registration failed</h1>");
            }

        } catch (SQLException e) {
            e.printStackTrace();
            response.setContentType("text/html");
            PrintWriter pt = response.getWriter();
            pt.println("<h1>Database Error: " + e.getMessage() + "</h1>");
        }
    }
}