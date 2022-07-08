package Dao;

import java.util.ArrayList;
import Entità.Album;

public interface DaoAlbum 
{
	ArrayList<Album> listaAlbum();
	public ArrayList<Album> listaAlbum(int codice);
	public void InserisciAlbum(String nomeUtente, String Password, int codiceArtista, String Nome, String nomeProduttore, int data);
	public void cancellaAlbum(String nomeUtente, String Password, int codiceAlbum);
}


