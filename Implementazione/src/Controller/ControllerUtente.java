package Controller;

import java.util.ArrayList;
import ImplementazioneDao.ImplementazioneDaoUtente;
import Entità.Utente;

public class ControllerUtente 
{
	private Utente u;
	private int esitoNomeUtente;
	private int esitoMail;
	private ImplementazioneDaoUtente ui;
	private ArrayList<Utente> lista;

	public ControllerUtente()
	{
		ui=new ImplementazioneDaoUtente();
	}
	
	public Utente login(String nomeUtente, String password)
	{
		u=ui.login(nomeUtente, password);
		return u;
	}
	
	public void Registrazione(String nomeUtente, String Password, String Mail, String Nome, String Cognome, String Nazione, String Abbonamento)
	{
		ui.Registrazione(nomeUtente, Password, Mail, Nome, Cognome, Nazione, Abbonamento);
	}
	
	public int unicitàUtente(String nomeUtente)
	{
		esitoNomeUtente=ui.unicitàUtente(nomeUtente);
		return esitoNomeUtente;
	}
	
	public int unicitàMail(String Mail)
	{
		esitoMail=ui.unicitàMail(Mail);
		return esitoMail;
	}
	
	public void modificaMail(String nomeUtente, String Password, String nuovaMail)
	{
		ui.modificaMail(nomeUtente, Password, nuovaMail);
	}
	
	public void modificaPassword(String nomeUtente, String Password, String nuovaPassword)
	{
		ui.modificaPassword(nomeUtente, Password, nuovaPassword);
	}
	
	public void modificaPiano(String nomeUtente, String Password, String nuovoPiano)
	{
		ui.modificaPiano(nomeUtente, Password, nuovoPiano);
	}
	
	public ArrayList<Utente> listaUtente()
	{
		lista=ui.listaUtente();
		return lista;
	}
}
