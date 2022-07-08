package Entità;

import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utente 
{	
	private int IdUtente;
	private String NomeUtente;
	private String Password;
	private String Mail;
	private String Nome;
	private String Cognome;
	private String Nazione;
	private String Piano;
	private String Accesso;
	private ArrayList<Riproduzione> riproduzioneTraccia;
	private ArrayList<Traccia> tracciaPreferita;
		
	public Utente()
	{
		setIdUtente(0);
		setNomeUtente("nessun nome");
		setPassword("nessuna password");
		setMail("nessuna mail");
		setNome("nessun nome");
		setCognome("nessun cognome");
		setNazione("nessuna nazione");
		setPiano("nessun piano");
		setAccesso("nessun accesso");
		setRiproduzioneTraccia(null);
		setTracciaPreferita(null);
	}
	
	public Utente(int idUtente, String nomeUtente, String password, String mail, String nome, String cognome,
			String nazione, String piano, String accesso, ArrayList<Riproduzione> riproduzioneTraccia,
			ArrayList<Traccia> tracciaPreferita) 
	{
		setIdUtente(idUtente);
		setNomeUtente(nomeUtente);
		setPassword(password);
		setMail(mail);
		setNome(nome);
		setCognome(cognome);
		setNazione(nazione);
		setPiano(piano);
		setAccesso(accesso);
		setRiproduzioneTraccia(riproduzioneTraccia);
		setTracciaPreferita(tracciaPreferita);
	}
	
	public Utente(int idUtente, String nomeUtente, String password, String mail, String nome, String cognome,
			String nazione, String piano, String accesso) 
	{
		setIdUtente(idUtente);
		setNomeUtente(nomeUtente);
		setPassword(password);
		setMail(mail);
		setNome(nome);
		setCognome(cognome);
		setNazione(nazione);
		setPiano(piano);
		setAccesso(accesso);
	}
	
	public void scriviOutput()
	{
		System.out.println("L'utente è: ");
		System.out.println("id: "+getIdUtente());
		System.out.println("Nome utente: "+getNomeUtente());
		System.out.println("Password: "+getPassword());
		System.out.println("Mail: "+getMail());
		System.out.println("Nome: "+getNome());
		System.out.println("Cognome: "+getCognome());
		System.out.println("Nazione: "+getNazione());
		System.out.println("Piano: "+getPiano());
		System.out.println("Accesso: "+getAccesso());
	}
	
	public int getIdUtente()
	{
		return IdUtente;
	}
	
	public String getNomeUtente()
	{
		return NomeUtente;
	}
	
	public String getPassword()
	{
		return Password;
	}

	public String getMail()
	{
		return Mail;
	}
	
	public String getNome()
	{
		return Nome;
	}
	
	public String getCognome()
	{
		return Cognome;
	}
	
	public String getNazione()
	{
		return Nazione;
	}
	
	public String getPiano()
	{
		return Piano;
	}
	
	public String getAccesso()
	{
		return Accesso;
	}
	
	private void setIdUtente(int nuovoIdUtente)
	{
		this.IdUtente=nuovoIdUtente;
	}
	
	private void setNomeUtente(String nuovoNomeUtente)
	{
		this.NomeUtente=nuovoNomeUtente;
	}
	
	private void setPassword(String nuovaPassword)
	{
		this.Password=nuovaPassword;
	}
	
	private void setMail(String nuovaMail)
	{
		this.Mail=nuovaMail;
	}
	
	private void setNome(String nuovoNome)
	{
		this.Nome=nuovoNome;
	}
	
	private void setCognome(String nuovoCognome)
	{
		this.Cognome=nuovoCognome;
	}
	
	private void setNazione(String nuovaNazione)
	{
		this.Nazione=nuovaNazione;
	}
	
	private void setPiano(String nuovoPiano)
	{
		this.Piano=nuovoPiano;
	}
	
	private void setAccesso(String nuovoAccesso)
	{
		this.Accesso=nuovoAccesso;
	}

	public ArrayList<Riproduzione> getRiproduzioneTraccia() 
	{
		return riproduzioneTraccia;
	}

	private void setRiproduzioneTraccia(ArrayList<Riproduzione> riproduzioneTraccia) 
	{
		this.riproduzioneTraccia = riproduzioneTraccia;
	}

	public ArrayList<Traccia> getTracciaPreferita() 
	{
		return tracciaPreferita;
	}

	private void setTracciaPreferita(ArrayList<Traccia> tracciaPreferita) 
	{
		this.tracciaPreferita = tracciaPreferita;
	}
	
	public static boolean correttezzaMail(String Mail)
	{
		Pattern p = Pattern.compile(".+@.+\\.[a-z]+");
	    Matcher m = p.matcher(Mail);
	    boolean matchFound = m.matches();
	    StringTokenizer st = new StringTokenizer(Mail, ".");
	    String lastToken = null;
	    while (st.hasMoreTokens()) 
	    {
	    	lastToken = st.nextToken();
	    }
	    if (matchFound && lastToken.length() >= 2
	    	&& Mail.length() - 1 != lastToken.length()) 
	    {
	    	return true;
	    } 
	    else 
	    {
	    	return false;
	    }
	}
}
