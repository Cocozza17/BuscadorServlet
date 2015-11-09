package Busc;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;


public class Buscador {
	

	public static String Buscar(String arg2, String arg1) throws IOException{
		
		BufferedReader reader = new BufferedReader(new FileReader(System.getProperty("user.dir")+"/wordpath.txt"));
		String line = reader.readLine();
		String columna;
		
		if (arg1.equals("Tcortado")) {
			columna = "tweetie";
			arg2=PrograUtil.LimpiarEntrada(arg2,line);
		} else if (arg1.equals("Username")) {
			columna = "name";
		} else {
			columna = "tag";
		}
		{
			try {
				
				String myDriver = "com.mysql.jdbc.Driver";
				
				String myUrl = "jdbc:mysql://localhost/Twit_Base";
				Class.forName(myDriver);
				String query;
				Connection conn = DriverManager.getConnection(myUrl, "root", "");
				if(arg1.equals("Username")){
					 query = "SELECT * FROM (Tweet join "+ arg1 + " on Tweet.id = " + arg1 
							+ ".tweet_id)where "+ columna + " like '%" + arg2+ "%';";

				}
				else{
					 query = "SELECT * FROM (Username join(Tweet join "+ arg1 + " on Tweet.id = " + arg1 
							+ ".tweet_id) on Username.tweet_id = Tweet.id)where "
							+ columna + " like '%" + arg2+ "%';";
					
				}
				java.sql.Statement st = conn.createStatement();
				java.sql.ResultSet rs = st.executeQuery(query);
				String res= "";
				while (rs.next()) {
					
					/*String id = rs.getString("id");*/
					String firstName = rs.getString("tweet");
					String lastName = rs.getString("date");
					String Name = rs.getString("name");
					res+="<tr>\n";
					res+=("<td>"+firstName+"</td>\n<td>"+lastName+"</td>\n<td>"+Name+"</td>\n");
					res+="</tr>\n";
				}
				return res;
				
			}
			catch (Exception e) {
				System.err.println("Got an exception! ");
				System.err.println(e.getMessage());
			}
		}
		return null;
	
		
	}
}
