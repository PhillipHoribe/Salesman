import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/SalesmanServlet")
public class SalesmanServlet extends HttpServlet {

	//private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		int SalesmanId = Integer.parseInt(request.getParameter("salesman_id"));		
		String name = request.getParameter("name");
		String city = request.getParameter("city");
		Float commission = Float.parseFloat(request.getParameter("commission"));

		Salesman s = new Salesman();
		s.setSalesman_id(SalesmanId);
		s.setName(name);
		s.setCity(city);
		s.setCommission(commission);
		
		int status = Dao.InsertSalesman(s);
		if (status > 0) {
			out.print("<p>Record saved successfully!</p>");
			request.getRequestDispatcher("index.html").include(request, response);
		} else {
			out.println("Sorry! unable to save record");
		}

		out.close();
	}

}

