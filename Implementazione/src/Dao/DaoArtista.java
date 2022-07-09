package Dao;

import java.util.ArrayList;
import Entita.Artista;

public interface DaoArtista 
{
	ArrayList<Artista> listaArtisti();
    void InserisciArtista(String nomeUtente, String Password, String nome, String Nazione, String Etichetta);
	public void cancellaArtista(String nomeUtente, String Password, int codiceArtista);
}
