package ConnessioneDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnessioneDB
{

	private static ConnessioneDB instance;
	private Connection connection = null;
	private String nome = "postgres";
	private String password = "samsunggalaxys";
	private String url = "jdbc:postgresql://localhost:5432/oo-music";
	
	public ConnessioneDB() throws SQLException
	{
		try 
		{
			connection = DriverManager.getConnection(url,nome,password); 
			if(connection!=null)
				System.out.println("connessione avvenuta");
        }
        catch (SQLException ex) 
		{
        	System.out.println("Database Connection Creation Failed : " + ex.getMessage());
			ex.printStackTrace();
        }
	}
	
	public Connection getConnection() 
	{
		return connection;
	}
	
	public static ConnessioneDB getInstance() throws SQLException 
	{
		if (instance == null) 
		{
			instance = new ConnessioneDB();
		} 
		else if (instance.getConnection().isClosed()) 
		{
			instance = new ConnessioneDB();
		}
		return instance;
	}
}