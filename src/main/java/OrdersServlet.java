import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/OrdersServlet")
public class OrdersServlet extends HttpServlet {
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		//SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		
		
		int ord_no = Integer.parseInt(request.getParameter("ord_no"));
		Float purch_amt = Float.parseFloat(request.getParameter("purch_amt"));
		String ord_date = request.getParameter("ord_date");
		int customer_id = Integer.parseInt(request.getParameter("customer_id"));
		int salesman_id = Integer.parseInt(request.getParameter("salesman_id"));
		//Date data = formatter.parse(ord_date);

		Orders o = new Orders();
		o.setOrd_no(ord_no);
		o.setPurch_amt(purch_amt);
		o.setOrd_date(ord_date);
		o.setCustomer_id(customer_id);
		o.setSalesman_id(salesman_id);
		
		
		int status = Dao.InsertOrders(o);
		if (status > 0) {
			out.print("<p>Record saved successfully!</p>");
			request.getRequestDispatcher("index.html").include(request, response);
		} else {
			out.println("Sorry! unable to save record");
		}

		out.close();
	}
}
