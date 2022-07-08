package ImplementazioneDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import ConnessioneDB.ConnessioneDB;
import Entità.Riproduzione;

public class ImplementazioneDaoRiproduzione 
{
	private Connection connection;
	
	public ImplementazioneDaoRiproduzione() 
	{	
		try 
		{
			connection = ConnessioneDB.getInstance().getConnection();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}

	public ArrayList<Riproduzione> listaDettFascia(String nomeutente, String Password, String utente2)
	{
		ArrayList<Riproduzione> lista = new ArrayList<Riproduzione>();

		try 
		{
			PreparedStatement queryListaRiprod = connection.prepareStatement("SELECT * FROM visualizza_fascia('"+nomeutente+"','"+Password+"','"+utente2+"');");
			ResultSet rs = queryListaRiprod.executeQuery();
			
			if(rs==null)
			{
				System.out.println("Errore");
			}
			while(rs.next())
			{
				Riproduzione r = new Riproduzione(rs.getString("fasciaoraria"),rs.getInt("numero_ascolti"));
				lista.add(r);
			}
			rs.close();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}

		return lista;	
	}
}
