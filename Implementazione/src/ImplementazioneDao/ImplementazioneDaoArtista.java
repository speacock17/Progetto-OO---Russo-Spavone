package ImplementazioneDao;

import java.sql.Connection;import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import ConnessioneDB.ConnessioneDB;
import Dao.DaoArtista;
import Entita.Artista;


public class ImplementazioneDaoArtista implements DaoArtista
{	
	private Connection connection;

	public ImplementazioneDaoArtista() 
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
	
	public ArrayList<Artista> listaArtisti()
	{
		ArrayList<Artista> lista = new ArrayList<Artista>();
		
		try 
		{
			PreparedStatement queryListaArtista = connection.prepareStatement("SELECT * FROM Artista;");
			ResultSet rs = queryListaArtista.executeQuery();
			
			if(rs==null)
			{
				System.out.println("Errore");
			}
			while(rs.next())
			{
				Artista a = new Artista(rs.getInt("IdArtista"),rs.getString("Nome"),rs.getString("Nazione"),rs.getString("Etichetta"));
				lista.add(a);
			}
			rs.close();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		return lista;		
	}

	public void InserisciArtista(String nomeUtente, String Password, String nome, String Nazione, String Etichetta)
	{		
		try 
		{
			PreparedStatement queryPreferiti = connection.prepareStatement("call inserimento_artista('"+nomeUtente+"','"+Password+"','"+nome+"','"+Nazione+"','"+Etichetta+"');");
			queryPreferiti.execute();
			System.out.println("Procedura eseguita con successo.");
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}	
	}

	public void cancellaArtista(String nomeUtente, String Password, int codiceArtista)
	{		
		try 
		{
			PreparedStatement querycancellaartista = connection.prepareStatement("call cancella_artista('"+nomeUtente+"','"+Password+"','"+codiceArtista+"');");
			querycancellaartista.execute();
			System.out.println("Procedura eseguita con successo.");
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}	
	}
}

