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
 * Servlet implementation class AddBook
 */
@WebServlet("/addbook")
public class AddBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
  	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String bname = request.getParameter("bname");
		String category = request.getParameter("category");
		String aname = request.getParameter("aname");
		
		RequestDispatcher dispatcher = null;
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library?useSSL=false&allowPublicKeyRetrieval=true","root","V1shal@24");
			PreparedStatement pt= con.prepareStatement("insert into book_detail(bname, category, aname) values (?,?,?)");
			pt.setString(1, bname);
			pt.setString(2, category);
			pt.setString(3, aname);
								
			int rowCount = pt.executeUpdate();
			if (rowCount > 0) {
				request.setAttribute("rstatus", "success");
				request.setAttribute("bname", bname);
				request.setAttribute("category", category);
				request.setAttribute("aname",aname);
				
				dispatcher = request.getRequestDispatcher("seebook.jsp");
			} else {
				request.setAttribute("rstatus", "failure");
				dispatcher = request.getRequestDispatcher("addBook.jsp");
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
