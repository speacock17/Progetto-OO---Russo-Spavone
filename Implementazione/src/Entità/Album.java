package Entità;

import java.util.ArrayList;

public class Album 
{
	private int IdAlbum;
	private String Titolo;
	private int Anno;
	private ArrayList<Traccia> tracciaContenuta;
	private Produttore produttoreAlbum;
	private ArrayList<Artista> scrittoreAlbum;
		
	public Album()
	{
		setIdAlbum(0);
		setTitolo("nessun titolo");
		setAnno(0);
		setTracciaContenuta(null);
		setProduttoreAlbum(null);
		setScrittoreAlbum(null);
	}
	
	public Album(int idAlbum, String titolo, int anno, ArrayList<Traccia> tracciaContenuta, Produttore produttoreAlbum,
			ArrayList<Artista> scrittoreAlbum) 
	{
		setIdAlbum(idAlbum);
		setTitolo(titolo);
		setAnno(anno);
		setTracciaContenuta(tracciaContenuta);
		setProduttoreAlbum(produttoreAlbum);
		setScrittoreAlbum(scrittoreAlbum);
	}
	
	public Album(int idAlbum, String titolo, int anno) 
	{
		setIdAlbum(idAlbum);
		setTitolo(titolo);
		setAnno(anno);
	}
	
	public Album(int idAlbum, String titolo, int anno, Produttore produttoreAlbum) 
	{
		setIdAlbum(idAlbum);
		setTitolo(titolo);
		setAnno(anno);
		setProduttoreAlbum(produttoreAlbum);
	}

	public void scriviOutput()
	{
		System.out.println("L'Album è: ");
		System.out.println("id: "+getIdAlbum());
		System.out.println("Nome: "+getTitolo());
		System.out.println("Nazione: "+getAnno());
	}
		
	public int getIdAlbum() 
	{
		return IdAlbum;
	}

	private void setIdAlbum(int idAlbum) 
	{
		this.IdAlbum = idAlbum;
	}
	
	public String getTitolo() 
	{
		return Titolo;
	}
	
	private void setTitolo(String titolo) 
	{
		this.Titolo = titolo;
	}
	
	public int getAnno() 
	{
		return Anno;
	}
	
	private void setAnno(int anno) 
	{
		this.Anno = anno;
	}
	
	public ArrayList<Traccia> getTracciaContenuta() 
	{
		return tracciaContenuta;
	}
	
	private void setTracciaContenuta(ArrayList<Traccia> tracciaContenuta) 
	{
		this.tracciaContenuta = tracciaContenuta;
	}
	
	public Produttore getProduttoreAlbum() 
	{
		return produttoreAlbum;
	}
	
	private void setProduttoreAlbum(Produttore produttoreAlbum) 
	{
		this.produttoreAlbum = produttoreAlbum;
	}
	
	public ArrayList<Artista> getScrittoreAlbum() 
	{
		return scrittoreAlbum;
	}
	
	private void setScrittoreAlbum(ArrayList<Artista> scrittoreAlbum) 
	{
		this.scrittoreAlbum = scrittoreAlbum;
	}	
}