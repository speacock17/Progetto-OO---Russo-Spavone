package Controller;

import java.util.ArrayList;
import ImplementazioneDao.ImplementazioneDaoArtista;
import Entita.Artista;

public class ControllerArtista 
{
	private ImplementazioneDaoArtista ar;
	private ArrayList<Artista> lista;
	
	public ControllerArtista()
	{
		ar=new ImplementazioneDaoArtista();
	}
	
	public ArrayList<Artista> listaArtisti()
	{
		lista=ar.listaArtisti();
		return lista;
	}
	
	public void InserisciArtista(String nomeUtente, String Password, String nome, String Nazione, String Etichetta)
	{
		ar.InserisciArtista(nomeUtente,Password,nome,Nazione,Etichetta);
	}
	
	public void cancellaArtista(String nomeUtente, String Password, int codiceArtista)
	{
		ar.cancellaArtista(nomeUtente,Password,codiceArtista);
	}
}
