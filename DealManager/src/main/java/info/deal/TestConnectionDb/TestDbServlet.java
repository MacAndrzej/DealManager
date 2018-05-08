package info.deal.TestConnectionDb;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 * @author Andrzej
 * 
 *Servlet implementation class TestDbServlet to check connection to database
 *
 */
public class TestDbServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		/* Setup connection variables */
		String user = "postgres";
		String password = "@ndrzej";
		String jdbcUrl = "jdbc:postgresql://localhost:5432/DealCollection?useSSL=false";
		String dirver = "org.postgresql.Driver";

		/* Get connection to database */
		try {
			PrintWriter out = response.getWriter();

			out.println("Connecting to database: " + jdbcUrl);

			Class.forName(dirver);
			Connection myConn = DriverManager.getConnection(jdbcUrl, user, password);

			out.println("Connection succesful");

			myConn.close();

		} catch (Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		}

		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

}
