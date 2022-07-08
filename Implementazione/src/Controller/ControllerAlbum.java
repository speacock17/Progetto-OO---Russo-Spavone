package Controller;

import java.util.ArrayList;
import Entità.Album;
import ImplementazioneDao.ImplementazioneDaoAlbum;

public class ControllerAlbum 
{
	private ImplementazioneDaoAlbum al;
	private ArrayList<Album> lista;
	
	public ControllerAlbum()
	{
		al=new ImplementazioneDaoAlbum();
	}
	
	public ArrayList<Album> listaAlbum(int codice)
	{
		lista=al.listaAlbum(codice);
		return lista;
	}
	
	public ArrayList<Album> listaAlbum()
	{
		lista=al.listaAlbum();
		return lista;
	}
	
	public void InserisciAlbum(String nomeUtente, String Password, int codiceArtista, String Nome, String nomeProduttore, int data)
	{
		al.InserisciAlbum(nomeUtente,Password,codiceArtista,Nome,nomeProduttore,data);
	}
	
	public void cancellaAlbum(String nomeUtente, String Password, int codiceAlbum)
	{
		al.cancellaAlbum(nomeUtente,Password,codiceAlbum);
	}
}
