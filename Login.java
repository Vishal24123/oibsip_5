package libraryManagement;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Servlet implementation class Login
 */
@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uemail = request.getParameter("username");
		String upwd = request.getParameter("password");
		HttpSession session = request.getSession();
		RequestDispatcher dispatcher = null;
		String admin=null;
		try {
					
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library?useSSL=false&allowPublicKeyRetrieval=true","root","V1shal@24");
			PreparedStatement pt= con.prepareStatement("select * from user_detail where email = ? and password = ?");
						
			pt.setString(1, uemail); 
			pt.setString(2, upwd); 
			
			ResultSet rs = pt.executeQuery();
			
			if (rs.next()) {
			
				session.setAttribute("name", rs.getString("email"));
				request.setAttribute("uname", rs.getString(1));
				admin=rs.getString(4);
				
			} else {
				request.setAttribute("status", "failed");
				dispatcher = request.getRequestDispatcher("index.jsp");
				dispatcher.forward(request, response);
			}
			
			if (admin.equals("yes")){
				
				dispatcher = request.getRequestDispatcher("action.jsp");
			}
			else {
				
				dispatcher = request.getRequestDispatcher("enquire.jsp");
		} dispatcher.forward(request, response);
		}catch (Exception e) {
			e.printStackTrace();
		} 	
	
	}

}
