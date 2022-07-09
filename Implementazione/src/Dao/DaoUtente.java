package Dao;

import java.util.ArrayList;
import Entita.Utente;

public interface DaoUtente 
{
	Utente login(String nomeUtente, String password);
	void Registrazione(String nomeUtente, String Password, String Mail, String Nome, String Cognome, String Nazione, String Abbonamento);
	int unicitaUtente(String nomeUtente);
	int unicitaMail(String Mail);
	void modificaMail(String nomeUtente, String Password, String Mail);
	void modificaPassword(String nomeUtente, String Password, String nuovaPassword);
	void modificaPiano(String nomeUtente, String Password, String nuovoPiano);
	public ArrayList<Utente> listaUtente();
}
