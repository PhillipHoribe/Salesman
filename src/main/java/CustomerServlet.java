import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/CustomerServlet")
public class CustomerServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		int customer_id = Integer.parseInt(request.getParameter("customer_id"));		
		String cust_name = request.getParameter("cust_name");
		String city = request.getParameter("city");
		Float grade = Float.parseFloat(request.getParameter("grade"));
		int salesman_id = Integer.parseInt(request.getParameter("salesman_id"));

		Customer c = new Customer();
		c.setCustomer_id(customer_id);
		c.setCust_name(cust_name);
		c.setCity(city);
		c.setGrade(grade);
		c.setSalesman_id(salesman_id);
		
		int status = Dao.InsertCustomer(c);
		if (status > 0) {
			out.print("<p>Record saved successfully!</p>");
			request.getRequestDispatcher("index.html").include(request, response);
		} else {
			out.println("Sorry! unable to save record");
		}

		out.close();
	}

}
