package Dao;

import java.util.ArrayList;
import Entità.Traccia;

public interface DaoTraccia 
{
	ArrayList<Traccia> listaTraccia();
	public ArrayList<Traccia> listaTraccia(int codice);
	void Riproduzione(String nomeUtente, int codice);
	void featuring(int codiceTraccia, int codiceArtista);
	void AggiungiPreferiti(String nomeUtente, String password, int codiceTraccia);
	ArrayList<Traccia> listaPreferiti(int codiceUtente);
    void inserisciTracciaOriginal(String nomeUtente, String password, int codiceArtista, String nomeAlbum, String nomeTraccia, int durata, String genere, String qualita, String tipo, String accesso, int percentuale);
    void inserisciTracciaDerivata(String nomeUtente, String password, int codiceArtista, String nomeAlbum, String nomeTraccia, int durata, String genere, String qualita, String tipo, String accesso, int percentuale, int tracciaOriginale);
    public void cancellaTraccia(String nomeUtente, String Password, int codiceTraccia);
    public ArrayList<Traccia> listaDettAscolti(String nomeutente, String Password, int codiceTraccia, int codiceArtista);
	public ArrayList<Traccia> listaFeaturing();
}



