package Dao;

import java.util.ArrayList;
import Entità.Utente;

public interface DaoUtente 
{
	Utente login(String nomeUtente, String password);
	void Registrazione(String nomeUtente, String Password, String Mail, String Nome, String Cognome, String Nazione, String Abbonamento);
	int unicitàUtente(String nomeUtente);
	int unicitàMail(String Mail);
	void modificaMail(String nomeUtente, String Password, String Mail);
	void modificaPassword(String nomeUtente, String Password, String nuovaPassword);
	void modificaPiano(String nomeUtente, String Password, String nuovoPiano);
	public ArrayList<Utente> listaUtente();
}
