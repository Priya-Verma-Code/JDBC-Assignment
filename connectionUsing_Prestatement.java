package week4_Ass_Package;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class connectionUsing_Prestatement {
	public static void main(String args[]) throws ClassNotFoundException {
		String sqlSelectAll = "SELECT * FROM Student";
		String connectionUrl = "jdbc:mysql://localhost:3306/Collegemanagement";

		try {
			Connection conn = DriverManager.getConnection(connectionUrl, "root", "root");
			PreparedStatement ps = conn.prepareStatement(sqlSelectAll);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				long RollNo = rs.getLong("RollNo");
				String Sname = rs.getString("Sname");
				String Address = rs.getString("Address");
				long ContNo = rs.getLong("ContNo");


				System.out.println("RollNo:" + RollNo + ", Sname: " + Sname 
						+ ", Address: " + Address + ", ContNo: " + ContNo );
			}
		} catch (SQLException e) {
			System.out.println("SQLException: " + e.getMessage());
		}
	}
}
