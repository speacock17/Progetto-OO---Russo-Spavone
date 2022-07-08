package ImplementazioneDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import ConnessioneDB.ConnessioneDB;
import Dao.DaoAlbum;
import Entità.Album;
import Entità.Produttore;

public class ImplementazioneDaoAlbum implements DaoAlbum
{
	private Connection connection;
	
	public ImplementazioneDaoAlbum() 
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

	public ArrayList<Album> listaAlbum()
	{
		ArrayList<Album> lista = new ArrayList<Album>();
		int codiceProd;
	
		try 
		{
			PreparedStatement queryListaArtista = connection.prepareStatement("SELECT * FROM Album;");
			ResultSet rs = queryListaArtista.executeQuery();
		
			if(rs==null)
			{
				System.out.println("Errore");
			}
			while(rs.next())
			{
				codiceProd=rs.getInt("Produttore");
				PreparedStatement queryProd = connection.prepareStatement("SELECT * From produttore WHERE idprod="+codiceProd+";");
				ResultSet rp = queryProd.executeQuery();
				rp.next();
				Produttore p = new Produttore(rp.getInt("idprod"),rp.getString("nome"));
				Album a = new Album(rs.getInt("IdAlbum"),rs.getString("Titolo"),rs.getInt("Anno"),p);
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
	

	public ArrayList<Album> listaAlbum(int codice)
	{
		ArrayList<Album> lista = new ArrayList<Album>();
		int codiceProd;
	
		try 
		{
			PreparedStatement queryListaArtista = connection.prepareStatement("SELECT al.idAlbum, al.titolo, al.anno, al.produttore FROM artistaalbum as ar, album as al WHERE ar.idalbum=al.idalbum AND ar.idartista="+codice+";");
			ResultSet rs = queryListaArtista.executeQuery();
		
			if(rs==null)
			{
				System.out.println("Errore");
			}
			while(rs.next())
			{
				codiceProd=rs.getInt("Produttore");
				PreparedStatement queryProd = connection.prepareStatement("SELECT * From produttore WHERE idprod="+codiceProd+";");
				ResultSet rp = queryProd.executeQuery();
				rp.next();
				Produttore p = new Produttore(rp.getInt("idprod"),rp.getString("nome"));
				Album a = new Album(rs.getInt("IdAlbum"),rs.getString("Titolo"),rs.getInt("Anno"),p);
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

	public void InserisciAlbum(String nomeUtente, String Password, int codiceArtista, String Nome, String nomeProduttore, int data)
	{		
		try 
		{
			PreparedStatement queryInsertAlbum = connection.prepareStatement("call inserimento_album('"+nomeUtente+"','"+Password+"','"+codiceArtista+"','"+Nome+"','"+nomeProduttore+"','"+data+"');");
			queryInsertAlbum.execute();
			System.out.println("Procedura eseguita con successo.");
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}	
	}

	public void cancellaAlbum(String nomeUtente, String Password, int codiceAlbum)
	{		
		try 
		{
			PreparedStatement querycancellaalbum = connection.prepareStatement("call cancella_album('"+nomeUtente+"','"+Password+"','"+codiceAlbum+"');");
			querycancellaalbum.execute();
			System.out.println("Procedura eseguita con successo.");
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}	
	}
}

	
	

	
	
	
	


