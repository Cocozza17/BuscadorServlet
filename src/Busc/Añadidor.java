package Busc;
import java.sql.DriverManager;

public class Añadidor {

	public static void Añadir(String Tabla, String Arg1, String Arg2) {

		try {
			// create a mysql database connection
			String myDriver = "com.mysql.jdbc.Driver";
			String myUrl = "jdbc:mysql://localhost/Twit_Base";
			Class.forName(myDriver);
			java.sql.Connection conn = DriverManager.getConnection(myUrl,
					"Cocoloco", "Cocoloco");

			if (Tabla.equals("Username")) {

				// the mysql insert statement
				String query = " insert into Username(name, tweet_id)"
						+ " values (?, ?)";
				// create the mysql insert preparedstatement
				java.sql.PreparedStatement preparedStmt = conn
						.prepareStatement(query);
				preparedStmt.setString(1, Arg1);
				preparedStmt.setString(2, Arg2);
				// execute the preparedstatement
				preparedStmt.execute();
				conn.close();

			} else if (Tabla.equals("Tag")) {

				// the mysql insert statement
				String query = " insert into Tag(tag, tweet_id)"
						+ " values (?, ?)";
				// create the mysql insert preparedstatement
				java.sql.PreparedStatement preparedStmt = conn
						.prepareStatement(query);
				preparedStmt.setString(1, Arg1);
				preparedStmt.setString(2, Arg2);
				// execute the preparedstatement
				preparedStmt.execute();
				conn.close();

			}

			else if (Tabla.equals("Tcortado")) {

				// the mysql insert statement
				String query = " insert into Tcortado(tweet, tweet_id)"
						+ " values (?, ?)";
				// create the mysql insert preparedstatement
				java.sql.PreparedStatement preparedStmt = conn
						.prepareStatement(query);
				preparedStmt.setString(1, Arg1);
				preparedStmt.setString(2, Arg2);
				// execute the preparedstatement
				preparedStmt.execute();
				conn.close();

			}

		} catch (Exception e) {
			System.err.println("Got an exception!");
			System.err.println(e.getMessage());
		}
	}

	public static void Añadir2(String id, String Tweet, String Date) {
		try {
			// create a mysql database connection
			String myDriver = "com.mysql.jdbc.Driver";
			String myUrl = "jdbc:mysql://localhost/Twit_Base";
			Class.forName(myDriver);
			java.sql.Connection conn = DriverManager.getConnection(myUrl,
					"Cocoloco", "Cocoloco");

			// the mysql insert statement
			String query = " insert into Tweet(id, tweet, date)"
					+ " values (?, ?, ?)";
			// create the mysql insert preparedstatement
			java.sql.PreparedStatement preparedStmt = conn
					.prepareStatement(query);
			preparedStmt.setString(1, id);
			preparedStmt.setString(2, Tweet);
			preparedStmt.setString(3, Date);
			// execute the preparedstatement
			preparedStmt.execute();
			conn.close();
		}

		catch (Exception e) {
			System.err.println("Got an exception!");
			System.err.println(e.getMessage());
		}

	}

}
