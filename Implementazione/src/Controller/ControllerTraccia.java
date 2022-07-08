package Controller;

import java.util.ArrayList;
import Entità.Traccia;
import ImplementazioneDao.ImplementazioneDaoTraccia;

public class ControllerTraccia 
{
	private ImplementazioneDaoTraccia tr;
	private ArrayList<Traccia> lista;
	
	public ControllerTraccia()
	{
		tr=new ImplementazioneDaoTraccia();
	}
	
	public ArrayList<Traccia> listaTraccia(int codice)
	{
		lista=tr.listaTraccia(codice);
		return lista;
	}
	
	public void Riproduzione(String nomeUtente, int codice)
	{
		tr.Riproduzione(nomeUtente,codice);
	}
	
	public void featuring(int codiceTraccia, int codiceArtista)
	{
		tr.featuring(codiceTraccia, codiceArtista);
	}

	
	public ArrayList<Traccia> listaTraccia()
	{
		lista=tr.listaTraccia();
		return lista;
	}
	
	public ArrayList<Traccia> listaFeaturing()
	{
		lista=tr.listaFeaturing();
		return lista;	
	}

	
	public void AggiungiPreferiti(String nomeUtente, String password, int codiceTraccia)
	{
		tr.AggiungiPreferiti(nomeUtente,password,codiceTraccia);
	}
	
	public ArrayList<Traccia> listaPreferiti(int codiceUtente)
	{
		lista=tr.listaPreferiti(codiceUtente);
		return lista;
	}
	
	public ArrayList<Traccia> listaDettAscolti(String nomeutente, String Password, int codiceTraccia, int codiceArtista)
	{
		lista=tr.listaDettAscolti(nomeutente,Password,codiceTraccia,codiceArtista);
		return lista;
	}
	
	public void inserisciTracciaOriginal(String nomeUtente, String password, int codiceArtista, String nomeAlbum, String nomeTraccia, int durata, String genere, String qualita, String tipo, String accesso, int percentuale)
	{
		tr.inserisciTracciaOriginal(nomeUtente,password,codiceArtista, nomeAlbum, nomeTraccia, durata, genere, qualita, tipo, accesso, percentuale);
	}
	
	public void inserisciTracciaDerivata(String nomeUtente, String password, int codiceArtista, String nomeAlbum, String nomeTraccia, int durata, String genere, String qualita, String tipo, String accesso, int percentuale, int tracciaOriginale)
	{
		tr.inserisciTracciaDerivata(nomeUtente,password,codiceArtista, nomeAlbum, nomeTraccia, durata, genere, qualita, tipo, accesso, percentuale,tracciaOriginale);
	}
	
	public void cancellaTraccia(String nomeUtente, String Password, int codiceTraccia)
	{
		tr.cancellaTraccia(nomeUtente,Password,codiceTraccia);
	}
}
