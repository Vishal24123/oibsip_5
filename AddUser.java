package libraryManagement;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Servlet implementation class AddUser
 */
@WebServlet("/adduser")
public class AddUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
      /**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String admin = request.getParameter("admin");
		
		RequestDispatcher dispatcher = null;
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library?useSSL=false&allowPublicKeyRetrieval=true","root","V1shal@24");
			PreparedStatement pt= con.prepareStatement("insert into user_detail(name, email, password, admin) values (?,?,?,?)");
			pt.setString(1, name);
			pt.setString(2, email);
			pt.setString(3, password);
			pt.setString(4, admin);
			
									
			int rowCount = pt.executeUpdate();
			if (rowCount > 0) {
				request.setAttribute("rstatus", "success");
				request.setAttribute("name", name);
				request.setAttribute("email", email);
				request.setAttribute("password",password);
				request.setAttribute("admin", admin);
				
				dispatcher = request.getRequestDispatcher("seeuser.jsp");
			} else {
				request.setAttribute("rstatus", "failure");
				dispatcher = request.getRequestDispatcher("addUser.jsp");
			}
			dispatcher.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}

	