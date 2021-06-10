package week4_Ass_Package;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class sqlConnectionBasicProgUsing_Statement {
	static void CreateConnectionUsingStatement() {

		String sqlSelectAll = "SELECT * FROM Student";
		String connectionUrl = "jdbc:mysql://localhost:3306/Collegemanagement";

		try {
			Connection con = DriverManager.getConnection(connectionUrl, "root", "root");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sqlSelectAll);

			while (rs.next()) {
				long RollNo = rs.getLong("RollNo");
				String Sname = rs.getString("Sname");
				String Address = rs.getString("Address");
				long ContNo = rs.getLong("ContNo");
				System.out.println(
						"RollNo:" + RollNo + ", Sname: " + Sname + ", Address: " + Address + ", ContNo: " + ContNo);
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	static void DeleteQueryUsingStatement() {
		String connectionUrl = "jdbc:mysql://localhost:3306/Collegemanagement";
		int AdminId = 400;
		try {
			Connection con = DriverManager.getConnection(connectionUrl, "root", "root");
			Statement stmt = con.createStatement();

			String sqlQuery = "DELETE from Administrator WHERE AdminId = '" + AdminId + "'";

			int x = stmt.executeUpdate(sqlQuery);

			if (x > 0)
				System.out.println("One Record Successfully Deleted");
			else
				System.out.println("Error Found in the following :(");

			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	static void InsertQueryUsingStatement() {
		String connectionUrl = "jdbc:mysql://localhost:3306/Collegemanagement";
		int RollNo = 4;
		String Sname = "Jolly";
		String Address = "Bangalore";
		int ContNo = 1321432143;
		try {
			Connection con = DriverManager.getConnection(connectionUrl, "root", "root");
			Statement stmt = con.createStatement();

			String sqlQuery = "insert into Student values('" + RollNo + "', '" + Sname + "', '" + Address + "', '"
					+ ContNo + "')";
			int x = stmt.executeUpdate(sqlQuery);
			if (x > 0)
				System.out.println("Record Inserted Successfully");
			else
				System.out.println("Insert Failed");

			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	static void UpdateQueryUsingStatement() {
		String connectionUrl = "jdbc:mysql://localhost:3306/Collegemanagement";
		int AdminId = 500;
		String newpassword = "priyapassword";
		try {

			Connection con = DriverManager.getConnection(connectionUrl, "root", "root");
			Statement stmt = con.createStatement();

			String sqlQuery = "UPDATE Administrator set password = '" + newpassword + "' WHERE AdminId = '" + AdminId
					+ "'";
			int x = stmt.executeUpdate(sqlQuery);

			if (x > 0)
				System.out.println("Password updated Successfully");
			else
				System.out.println("Error found :(");

			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public static void main(String args[]) throws ClassNotFoundException {
		sqlConnectionBasicProgUsing_Statement.CreateConnectionUsingStatement();
		sqlConnectionBasicProgUsing_Statement.DeleteQueryUsingStatement();
		sqlConnectionBasicProgUsing_Statement.InsertQueryUsingStatement();
		sqlConnectionBasicProgUsing_Statement.UpdateQueryUsingStatement();

	}
}