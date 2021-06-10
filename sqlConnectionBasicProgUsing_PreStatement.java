package week4_Ass_Package;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class sqlConnectionBasicProgUsing_PreStatement {
	static void CreateConnectionUsingPreStatement() {

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

				System.out.println(
						"RollNo:" + RollNo + ", Sname: " + Sname + ", Address: " + Address + ", ContNo: " + ContNo);
			}
		} catch (SQLException e) {
			System.out.println("SQLException: " + e.getMessage());
		}
	}

	static void DeleteQueryUsingPreStatement() {
		try {

			String connectionUrl = "jdbc:mysql://localhost:3306/Collegemanagement";
			Connection con = DriverManager.getConnection(connectionUrl, "root", "root");

			PreparedStatement stmt = con.prepareStatement("delete from Administrator where AdminId=?");
			stmt.setInt(1, 900);

			int i = stmt.executeUpdate();
			System.out.println(i + " Records is deleted successfully");

			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	static void InsertQueryUsingPreStatement() {
		try {

			String connectionUrl = "jdbc:mysql://localhost:3306/Collegemanagement";
			Connection con = DriverManager.getConnection(connectionUrl, "root", "root");

			PreparedStatement stmt = con.prepareStatement("insert into Administrator values(?,?,?)");
			stmt.setInt(1, 800);
			stmt.setString(2, "Ninni");
			stmt.setString(3, "ninnipassword");

			int i = stmt.executeUpdate();
			System.out.println(i + "Values of the record inserted Successfully");

			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	static void UpdateQueryUsingPreStatement() {
		try {

			String connectionUrl = "jdbc:mysql://localhost:3306/Collegemanagement";
			Connection con = DriverManager.getConnection(connectionUrl, "root", "root");

			PreparedStatement stmt = con.prepareStatement("update Administrator set Password=? where AdminId=?");
			stmt.setString(1, "pujapassword");// 1 specifies the first parameter in the query i.e. name
			stmt.setInt(2, 700);

			int i = stmt.executeUpdate();
			System.out.println(i + " Specific Value of the record updated Successfully");

			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}

	}

	public static void main(String args[]) throws ClassNotFoundException {

		sqlConnectionBasicProgUsing_PreStatement.CreateConnectionUsingPreStatement();
		sqlConnectionBasicProgUsing_PreStatement.DeleteQueryUsingPreStatement();
		sqlConnectionBasicProgUsing_PreStatement.InsertQueryUsingPreStatement();
		sqlConnectionBasicProgUsing_PreStatement.UpdateQueryUsingPreStatement();

	}
}
