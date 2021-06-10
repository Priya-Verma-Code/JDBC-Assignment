package week4_Ass_Package;
import java.sql.*;
import java.io.*;

public class storeAndRetrieveImageInDatabase {
		static void StoreImageInDatabase() {
			try {
				String connectionUrl = "jdbc:mysql://localhost:3306/Collegemanagement";
				Connection con = DriverManager.getConnection(connectionUrl, "root", "root");

				PreparedStatement Prestmt = con.prepareStatement("insert into ImageWildlife values(?,?)");
				Prestmt.setString(1, "Tiger");

				FileInputStream fin = new FileInputStream("C:\\Users\\barma\\Documents\\Priya\\StudyStuff\\Globant_Exercise\\Week4_Assignments\\Tiger.jpg");
				Prestmt.setBinaryStream(2, fin, fin.available());
				int i = Prestmt.executeUpdate();
				System.out.println(i + " records affected");
				con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		static void RetrieveImageFromDatabase() {
			try {
				String connectionUrl = "jdbc:mysql://localhost:3306/Collegemanagement";
				Connection con = DriverManager.getConnection(connectionUrl, "root", "root");

				PreparedStatement prestm = con.prepareStatement("select Photo from ImageWildlife Where Name = 'Tiger'");
				ResultSet ResSet = prestm.executeQuery();
				if (ResSet.next()) {

					Blob b = ResSet.getBlob(1);
					byte byteVar[] = b.getBytes(1, (int) b.length());

					FileOutputStream fout = new FileOutputStream("C:\\Users\\barma\\Documents\\Priya\\StudyStuff\\Globant_Exercise\\Week4_Assignments\\TigerCopy.jpg");
					fout.write(byteVar);

					fout.close();
				}
				System.out.println("Image Created in the provided drive");

				con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		public static void main(String args[]) throws ClassNotFoundException {
			 //storeAndRetrieveImageInDatabase.StoreImageInDatabase();
			 storeAndRetrieveImageInDatabase.RetrieveImageFromDatabase();
		}
	}

