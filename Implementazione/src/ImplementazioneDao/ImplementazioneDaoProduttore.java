package ImplementazioneDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import ConnessioneDB.ConnessioneDB;
import Dao.DaoProduttore;
import Entita.Produttore;

public class ImplementazioneDaoProduttore implements DaoProduttore
{
	private Connection connection;

	public ImplementazioneDaoProduttore() 
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


	public ArrayList<Produttore> listaProduttori()
	{
		ArrayList<Produttore> lista = new ArrayList<Produttore>();
	
		try 
		{
			PreparedStatement queryListaProduttore = connection.prepareStatement("SELECT * FROM Produttore;");
			ResultSet rs = queryListaProduttore.executeQuery();
		
			if(rs==null)
			{
				System.out.println("Errore");
			}
			while(rs.next())
			{
				Produttore p = new Produttore(rs.getInt("Idprod"),rs.getString("Nome"));
				lista.add(p);
			}
			rs.close();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	
		return lista;		
	}

	public ArrayList<Produttore> listaCompensiProduttori()
	{
		ArrayList<Produttore> lista = new ArrayList<Produttore>();
	
		try 
		{
			PreparedStatement queryListaProduttore = connection.prepareStatement("SELECT * FROM compensi_totali;");
			ResultSet rs = queryListaProduttore.executeQuery();
		
			if(rs==null)
			{
				System.out.println("Errore");
			}
			while(rs.next())
			{
				Produttore p = new Produttore(rs.getString("Nome"),rs.getFloat("totale_compensi"));
				lista.add(p);
			}
			rs.close();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	return lista;		
	}
	
	
	public void InserisciProduttore(String nomeUtente, String Password, String nomeProd)
	{		
		try 
		{
			PreparedStatement queryInsertProd = connection.prepareStatement("call inserimento_produttore('"+nomeUtente+"','"+Password+"','"+nomeProd+"');");
			queryInsertProd.execute();
			System.out.println("Procedura eseguita con successo.");
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}	
	}

}
