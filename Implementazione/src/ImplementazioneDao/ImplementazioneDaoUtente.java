package ImplementazioneDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import ConnessioneDB.ConnessioneDB;
import Dao.DaoUtente;
import Entità.Utente;


public class ImplementazioneDaoUtente implements DaoUtente
{	
	private Connection connection;
	
	public ImplementazioneDaoUtente() 
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
	
	public Utente login(String nomeUtente, String Password)
	{
		Utente utente=null;
		int idUtente;
		String nomeutente, password, mail, nome, cognome, nazione, piano, accesso;
		
		try 
		{
			PreparedStatement queryLogin = connection.prepareStatement("SELECT * FROM Utente WHERE NomeUtente = '" + nomeUtente + "'");
			ResultSet rs = queryLogin.executeQuery();
			
			if(rs==null)
			{
				System.out.println("Nome Utente errato.");
			}
			while(rs.next())
			{
				idUtente=rs.getInt("IdUtente");
				nomeutente=rs.getString("NomeUtente");
				password=rs.getString("Password");
				mail=rs.getString("Mail");
				nome=rs.getString("Nome");
				cognome=rs.getString("Cognome");
				nazione=rs.getString("nazione");
				piano=rs.getString("Piano");
				accesso=rs.getString("Accesso");
				
				if(password.equals(Password))
				{
					utente = new Utente(idUtente, nomeutente, password, mail, nome, cognome, nazione, piano, accesso);
				}
				else
				{
					System.out.println("Password Errata.");
				}
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		return utente;
	}
	
	public void Registrazione(String nomeUtente, String Password, String Mail, String Nome, String Cognome, String Nazione, String Abbonamento)
	{		
		try 
		{
			PreparedStatement queryRegistrazione = connection.prepareStatement("call registrazione_utente('"+nomeUtente+"','"+Password+"','"+Mail+"','"+Nome+"','"+Cognome+"','"+Nazione+"','"+Abbonamento+"');");
			queryRegistrazione.execute();
			System.out.println("Procedura eseguita con successo.");
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}	
	}
	
	public int unicitàUtente(String nomeUtente)
	{
		int esito=0;
		try 
		{
			PreparedStatement queryUnicitàUtente = connection.prepareStatement("SELECT COUNT(*) AS ut FROM Utente WHERE NomeUtente='"+nomeUtente+"'");
			ResultSet rs = queryUnicitàUtente.executeQuery();
			System.out.println("Procedura unicità eseguita con successo.");
			
			if(rs==null)
			{
				System.out.println("errore.");
			}
			while(rs.next())
			{
				esito=rs.getInt("ut");
			}
			if(esito==0)
			{
				System.out.println("Nome utente non trovato.");
			}
			else if(esito==1)
			{
				System.out.println("Nome utente già utilizzato.");
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return esito;
	}
	
	public int unicitàMail(String Mail)
	{
		int esito=0;
		try 
		{
			PreparedStatement queryUnicitàMail = connection.prepareStatement("SELECT COUNT(*) AS ut FROM Utente WHERE Mail='"+Mail+"'");
			ResultSet rs = queryUnicitàMail.executeQuery();
			System.out.println("Procedura unicità eseguita con successo.");
			
			if(rs==null)
			{
				System.out.println("errore.");
			}
			while(rs.next())
			{
				esito=rs.getInt("ut");
			}
			if(esito==0)
			{
				System.out.println("Mail non trovata.");
			}
			else if(esito==1)
			{
				System.out.println("Mail già utilizzato.");
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return esito;
	}
	
	public void modificaMail(String nomeUtente, String Password, String Mail)
	{
		try 
		{	
			PreparedStatement queryModificaMail = connection.prepareStatement("call modifica_mail('"+nomeUtente+"','"+Password+"','"+Mail+"');");
			queryModificaMail.execute();
			System.out.println("Procedura eseguita con successo.");
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}	
	}
	
	public void modificaPassword(String nomeUtente, String Password, String nuovaPassword)
	{
		try 
		{	
			PreparedStatement queryModificaPassword = connection.prepareStatement("call modifica_password('"+nomeUtente+"','"+Password+"','"+nuovaPassword+"');");
			queryModificaPassword.execute();
			System.out.println("Procedura eseguita con successo.");
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}	
	}
	
	public void modificaPiano(String nomeUtente, String Password, String nuovoPiano)
	{
		try 
		{	
			PreparedStatement queryModificaPiano = connection.prepareStatement("update utente set piano = '"+nuovoPiano+"'where nomeutente = '"+nomeUtente+"'");
			queryModificaPiano.execute();
			System.out.println("Procedura eseguita con successo.");
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}	
	}
	
	public ArrayList<Utente> listaUtente()
	{
		ArrayList<Utente> lista = new ArrayList<Utente>();
		
		try 
		{
			PreparedStatement queryListaUtente = connection.prepareStatement("SELECT * FROM Utente WHERE accesso='Client';");
			ResultSet rs = queryListaUtente.executeQuery();
			
			if(rs==null)
			{
				System.out.println("Errore");
			}
			while(rs.next())
			{
				Utente u = new Utente(rs.getInt("IdUtente"),rs.getString("nomeutente"),rs.getString("Password"),rs.getString("mail"),rs.getString("nome"),rs.getString("cognome"),rs.getString("nazione"),rs.getString("piano"),rs.getString("Accesso"));
				lista.add(u);
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
