package libraryManagement;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Servlet implementation class BookName
 */
@WebServlet("/namesearch")
public class BookName extends HttpServlet {
	private static final long serialVersionUID = 1L;
    /**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		String bname = request.getParameter("search");
		String searchby = request.getParameter("buttonvalue");
		RequestDispatcher dispatcher = null;
		Connection con = null;
		//PrintWriter out=response.getWriter();

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library?useSSL=false&allowPublicKeyRetrieval=true","root","V1shal@24");
			PreparedStatement pt=null;
			if (searchby.equals("bookname")) {
				 pt= con.prepareStatement("select * from book_detail where bname=?");
				 pt.setString(1, bname);
			} 
			if (searchby.equals("category")) {
				pt= con.prepareStatement("select * from book_detail where category=?");
				pt.setString(1, bname);
			}
			
			ResultSet rs = pt.executeQuery();
			if (rs.next()) {
				while (rs.next()) {
					request.setAttribute("rstatus", "success");
					request.setAttribute("bid",rs.getInt(1));
					request.setAttribute("bname",rs.getString(2));
					request.setAttribute("bcategory",rs.getString(3));
					request.setAttribute("aname",rs.getString(4));
					dispatcher = request.getRequestDispatcher("view.jsp");
					dispatcher.forward(request, response);
				}
			} else {
				request.setAttribute("rstatus",  "failure");
				dispatcher = request.getRequestDispatcher("see.jsp");
				dispatcher.forward(request, response);
			}
			
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
