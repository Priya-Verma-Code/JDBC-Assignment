package week4_Ass_Package;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

class updateQueryUsing_Prestatement {
	public static void main(String args[]) {
		try {

			String connectionUrl = "jdbc:mysql://localhost:3306/Collegemanagement";
			Connection con = DriverManager.getConnection(connectionUrl, "root", "root");

			PreparedStatement stmt=con.prepareStatement("update Administrator set Password=? where AdminId=?");  
			stmt.setString(1,"pujapassword");//1 specifies the first parameter in the query i.e. name  
			stmt.setInt(2,700);  
			  
			int i=stmt.executeUpdate();  
			System.out.println(i+" Specific Value of the record updated Successfully");  

			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}

	}
}
