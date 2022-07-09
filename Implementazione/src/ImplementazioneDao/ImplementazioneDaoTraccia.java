package ImplementazioneDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import ConnessioneDB.ConnessioneDB;
import Dao.DaoTraccia;
import Entita.Traccia;


public class ImplementazioneDaoTraccia implements DaoTraccia 
{
	private Connection connection;
	
	public ImplementazioneDaoTraccia() 
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

	public ArrayList<Traccia> listaTraccia()
	{
		ArrayList<Traccia> lista = new ArrayList<Traccia>();
	
		try 
		{
			PreparedStatement queryListaTraccia = connection.prepareStatement("SELECT * FROM Traccia;");
			ResultSet rs = queryListaTraccia.executeQuery();
		
			if(rs==null)
			{
				System.out.println("Errore");
			}
			while(rs.next())
			{
				Traccia t = new Traccia(rs.getInt("IdTraccia"),rs.getString("Titolo"),rs.getInt("Durata"),rs.getInt("Anno"),rs.getString("Genere"),rs.getInt("Versione"),rs.getString("qualitaaudio"),rs.getString("Tipo"),rs.getString("Accesso"),rs.getInt("percentualeprod"));
				lista.add(t);
			}
			rs.close();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return lista;		
	}

	public ArrayList<Traccia> listaDettAscolti(String nomeutente, String Password, int codiceTraccia, int codiceArtista)
	{
		ArrayList<Traccia> lista = new ArrayList<Traccia>();

		try 
		{
			PreparedStatement queryListaTraccia = connection.prepareStatement("SELECT * FROM visualizza_ascolti('"+nomeutente+"','"+Password+"','"+codiceTraccia+"','"+codiceArtista+"');");
			ResultSet rs = queryListaTraccia.executeQuery();
	
			if(rs==null)
			{
				System.out.println("Errore");
			}
			while(rs.next())
			{
				Traccia t = new Traccia(rs.getString("NomeUtente"),rs.getInt("idTraccia"),rs.getString("titolo"),rs.getInt("Versione"),rs.getInt("ascoltieffettuati"));
				lista.add(t);
			}
			rs.close();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return lista;		
	}


	public ArrayList<Traccia> listaTraccia(int codice)
	{
		ArrayList<Traccia> lista = new ArrayList<Traccia>();
	
		try 
		{
			PreparedStatement queryListaTraccia = connection.prepareStatement("SELECT * FROM traccia WHERE album="+codice+";");
			ResultSet rs = queryListaTraccia.executeQuery();
		
			if(rs==null)
			{
				System.out.println("Errore");
			}
			while(rs.next())
			{
				Traccia t = new Traccia(rs.getInt("IdTraccia"),rs.getString("Titolo"),rs.getInt("Durata"),rs.getInt("Anno"),rs.getString("Genere"),rs.getInt("Versione"),rs.getString("qualitaaudio"),rs.getString("Tipo"),rs.getString("Accesso"),rs.getInt("percentualeprod"));
				lista.add(t);
			}
			rs.close();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return lista;		
	}
	
	public ArrayList<Traccia> listaFeaturing()
	{
		ArrayList<Traccia> lista = new ArrayList<Traccia>();
	
		try 
		{
			PreparedStatement queryListaFeaturing = connection.prepareStatement("SELECT a.nome, t.titolo FROM artista a, traccia t, featuring f WHERE a.idartista=f.artistaospite AND t.idtraccia=f.traccia;");
			ResultSet rs = queryListaFeaturing.executeQuery();
		
			if(rs==null)
			{
				System.out.println("Errore");
			}
			while(rs.next())
			{
				Traccia t = new Traccia(rs.getString("titolo"),rs.getString("nome"));
				lista.add(t);
			}
			rs.close();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return lista;		
	}

	public void Riproduzione(String nomeUtente, int codice)
	{		
		try 
		{
			PreparedStatement queryRiproduzione = connection.prepareStatement("call inserimento_riproduzione('"+nomeUtente+"','"+codice+"');");
			queryRiproduzione.execute();
			System.out.println("Procedura eseguita con successo.");
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}	
	}
	
	public void featuring(int codiceTraccia, int codiceArtista)
	{		
		try 
		{
			PreparedStatement queryRiproduzione = connection.prepareStatement("call inserimento_featuring('"+codiceTraccia+"','"+codiceArtista+"');");
			queryRiproduzione.execute();
			System.out.println("Procedura eseguita con successo.");
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}	
	}
	

	public void AggiungiPreferiti(String nomeUtente, String password, int codiceTraccia)
	{		
		try 
		{
			PreparedStatement queryPreferiti = connection.prepareStatement("call inserimento_brani_preferiti('"+nomeUtente+"','"+password+"','"+codiceTraccia+"');");
			queryPreferiti.execute();
			System.out.println("Procedura eseguita con successo.");
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}	
	}

	public ArrayList<Traccia> listaPreferiti(int codiceUtente)
	{
		ArrayList<Traccia> lista = new ArrayList<Traccia>();
	
		try 
		{
			PreparedStatement queryListaTraccia = connection.prepareStatement("SELECT tr.idtraccia, tr.titolo, tr.durata, tr.anno, tr.genere, tr.versione, tr.qualitaaudio, tr.tipo, tr.accesso, tr.percentualeprod FROM traccia tr, branipreferiti bp WHERE bp.traccia=tr.idtraccia AND bp.utente="+codiceUtente+";");
			ResultSet rs = queryListaTraccia.executeQuery();
		
			if(rs==null)
			{
				System.out.println("Errore");
			}
			while(rs.next())
			{
				Traccia t = new Traccia(rs.getInt("IdTraccia"),rs.getString("Titolo"),rs.getInt("Durata"),rs.getInt("Anno"),rs.getString("Genere"),rs.getInt("Versione"),rs.getString("qualitaaudio"),rs.getString("Tipo"),rs.getString("Accesso"),rs.getInt("percentualeprod"));
				lista.add(t);
			}	
			rs.close();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		return lista;		
	}

	public void inserisciTracciaOriginal(String nomeUtente, String password, int codiceArtista, String nomeAlbum, String nomeTraccia, int durata, String genere, String qualita, String tipo, String accesso, int percentuale)
	{		
		try 
		{
			PreparedStatement queryTraccia = connection.prepareStatement("call inserimento_traccia('"+nomeUtente+"','"+password+"','"+codiceArtista+"','"+nomeAlbum+"','"+nomeTraccia+"','"+durata+"','"+genere+"','"+qualita+"','"+tipo+"','"+accesso+"','"+percentuale+"');");
			queryTraccia.execute();
			System.out.println("Procedura eseguita con successo.");
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}	
	}

	public void inserisciTracciaDerivata(String nomeUtente, String password, int codiceArtista, String nomeAlbum, String nomeTraccia, int durata, String genere, String qualita, String tipo, String accesso, int percentuale, int tracciaOriginale)
	{		
		try 
		{
			PreparedStatement queryTraccia = connection.prepareStatement("call inserimento_traccia('"+nomeUtente+"','"+password+"','"+codiceArtista+"','"+nomeAlbum+"','"+nomeTraccia+"','"+durata+"','"+genere+"','"+qualita+"','"+tipo+"','"+accesso+"','"+percentuale+"','"+tracciaOriginale+"');");
			queryTraccia.execute();
			System.out.println("Procedura eseguita con successo.");
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}	
	}

	public void cancellaTraccia(String nomeUtente, String Password, int codiceTraccia)
	{		
		try 
		{
			PreparedStatement queryCancellaTraccia = connection.prepareStatement("call cancella_traccia('"+nomeUtente+"','"+Password+"','"+codiceTraccia+"');");
			queryCancellaTraccia.execute();
			System.out.println("Procedura eseguita con successo.");
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}	
	}
}
