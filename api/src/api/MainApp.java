package api;
import java.sql.*;

public class MainApp 
{
	public static void main(String[]args)
	{
		String url      ="jdbc:mysql://localhost:3306/";
		String user     ="root";
		String password ="";
		try
		{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection con = DriverManager.getConnection(url, user, password);
			
			Statement stt = con.createStatement();
			
			// Create and select db
			stt.execute("CREATE DATABASE IF NOT EXISTS test");
			stt.execute("USE test");
			
			//create out table
			stt.execute("DROP TABLE IF EXISTS people");
			stt.execute("CREATE TABLE people(" +
					"id BIGINT NOT NULL AUTO_INCREMENT,"
					+ "fname VARCHAR(25),"
					+ "lname VARCHAR(25),"
					+ "PRIMARY KEY(id)"
					+ ")");
			
			// Add some entries
			stt.execute("INSERT INTO people (fname, lname) VALUES" + 
					"('Joe', 'Bloggs'), ('Mary', 'Bloggs'), ('Jill', 'Hill')");
			
			// Get people with surname Bloggs
			ResultSet res = stt.executeQuery("SELECT * FROM people WHERE lname = 'Bloggs'");
			
			while (res.next())
			{
				System.out.println(res.getString("fname") + " " + res.getString("lname"));
			}
			System.out.println("");
			
			// Same as the last query but with a prep'd statement
			PreparedStatement prep = con.prepareStatement("SELECT * FROM people WHERE lname = ?");
			prep.setString(1, "Bloggs");
			
			res = prep.executeQuery();
			while (res.next())
			{
				System.out.println(res.getString("fname") + " " + res.getString("lname"));
			}
			
			// Free resources
			res.close();
			stt.close();
			prep.close();
			con.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
