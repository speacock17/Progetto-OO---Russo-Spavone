package Entità;

import java.util.ArrayList;

public class Artista 
{	
	private int IdArtista;
	private String Nome;
	private String Nazione;
	private String Etichetta;
	private ArrayList<Album> albumScritto;
	private ArrayList<Traccia> tracciaComposta;
	private ArrayList<Traccia> tracciaPartecipata;
		
	public Artista()
	{
		setIdArtista(0);
		setNome("nessun nome");
		setNazione("nessuna nazione");
		setEtichetta("nessuna etichetta");
		setAlbumScritto(null);
		setTracciaComposta(null);
		setTracciaPartecipata(null);
	}

	public Artista(int idArtista, String nome, String nazione, String etichetta, ArrayList<Album> albumScritto,
			ArrayList<Traccia> tracciaComposta, ArrayList<Traccia> tracciaPartecipata) 
	{
		setIdArtista(idArtista);
		setNome(nome);
		setNazione(nazione);
		setEtichetta(etichetta);
		setAlbumScritto(albumScritto);
		setTracciaComposta(tracciaComposta);
		setTracciaPartecipata(tracciaPartecipata);
	}
	
	public Artista(int idArtista, String nome, String nazione, String etichetta) 
	{
		setIdArtista(idArtista);
		setNome(nome);
		setNazione(nazione);
		setEtichetta(etichetta);
	}
	
	public void scriviOutput()
	{
		System.out.println("La traccia è: ");
		System.out.println("id: "+getIdArtista());
		System.out.println("Nome: "+getNome());
		System.out.println("Nazione: "+getNazione());
		System.out.println("Etichetta: "+getEtichetta());
	}
		
	public int getIdArtista() 
	{
		return IdArtista;
	}

	private void setIdArtista(int idArtista) 
	{
		this.IdArtista = idArtista;
	}
	
	public String getNome() 
	{
		return Nome;
	}
	
	private void setNome(String nome) 
	{
		this.Nome = nome;
	}
	
	public String getNazione() 
	{
		return Nazione;
	}
	
	private void setNazione(String nazione) 
	{
		this.Nazione = nazione;
	}
	
	public String getEtichetta() 
	{
		return Etichetta;
	}
	
	private void setEtichetta(String etichetta) 
	{
		this.Etichetta = etichetta;
	}
	
	public ArrayList<Album> getAlbumScritto() 
	{
		return albumScritto;
	}
	
	private void setAlbumScritto(ArrayList<Album> albumScritto) 
	{
		this.albumScritto = albumScritto;
	}
	
	public ArrayList<Traccia> getTracciaComposta() 
	{
		return tracciaComposta;
	}
	
	private void setTracciaComposta(ArrayList<Traccia> tracciaComposta) 
	{
		this.tracciaComposta = tracciaComposta;
	}
	
	public ArrayList<Traccia> getTracciaPartecipata() 
	{
		return tracciaPartecipata;
	}
	
	private void setTracciaPartecipata(ArrayList<Traccia> tracciaPartecipata) 
	{
		this.tracciaPartecipata = tracciaPartecipata;
	}	
}
