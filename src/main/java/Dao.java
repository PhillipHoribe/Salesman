import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Dao {
	public static Connection getConnection() {
		Connection con = null;
		try {
			String url ="jdbc:sqlserver://localhost:1433;databaseName=Salesman;user=test;password=Miguel2021";
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			con = DriverManager.getConnection(url);
		} catch (Exception e) {
			System.out.println(e);
		}
		return con;
	}
	public static int InsertSalesman(Salesman s) {
		int status = 0;
		try {
			Connection con = Dao.getConnection();
			PreparedStatement ps = con
					.prepareStatement("insert into salesman(salesman_id,name,city,commission) values (?,?,?,?)");
			ps.setInt(1, s.getSalesman_id());
			ps.setString(2, s.getName());
			ps.setString(3, s.getCity());
			ps.setFloat(4, s.getCommission());
			
			status = ps.executeUpdate();
			con.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return status;
	}
	public static int InsertCustomer(Customer b) {
		int status = 0;
		try {
			Connection con = Dao.getConnection();
			PreparedStatement ps = con
					.prepareStatement("insert into customer(customer_id,cust_name,city,grade,salesman_id) values (?,?,?,?,?)");
			ps.setInt(1, b.getCustomer_id());
			ps.setString(2, b.getCust_name());
			ps.setString(3, b.getCity());
			ps.setFloat(4, b.getGrade());
			ps.setInt(5, b.getSalesman_id());

			status = ps.executeUpdate();
			con.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return status;
	}
	public static int InsertOrders(Orders c) {
		int status = 0;
		try {
			Connection con = Dao.getConnection();
			PreparedStatement ps = con
					.prepareStatement("insert into orders(ord_no,purch_amt,ord_date,customer_id,salesman_id) values (?,?,?,?,?)");
			ps.setInt(1, c.getOrd_no());
			ps.setFloat(2, c.getPurch_amt());
			ps.setString(3, c.getOrd_date());
			ps.setInt(4, c.getCustomer_id());
			ps.setInt(5, c.getSalesman_id());

			status = ps.executeUpdate();
			con.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return status;
	}
}
