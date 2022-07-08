package Entità;

import java.util.ArrayList;

public class Traccia 
{
	private int IdTraccia;
	private String Titolo;
	private int Durata;
	private int Anno;
	private String Genere;
	private int Versione;
	private String QualitaAudio;
	private String Tipo;
	private String Accesso;
	private int PercentualeProd;
	private ArrayList<Riproduzione> tracciaRiprodotta;
	private ArrayList<Utente> utenteAggiungiPreferiti;
	private ArrayList<Traccia> tracciaDerivata;
	private Album albumAppartenenza;
	private ArrayList<Artista> artistaCompositore;
	private ArrayList<Artista> artistaPresente;
	private String artistaFeat;
	private String nomeUt;
	private int asc;
	
	public Traccia()
	{	
		setIdTraccia(0);
		setTitolo("nessun titolo");
		setDurata(0);
		setAnno(0);
		setGenere("nessun genere");
		setVersione(0);
		setQualitàAudio("default");
		setTipo("default");
		setAccesso("default");
		setPercentualeProd(0);
		setTracciaRiprodotta(null);
		setUtenteAggiungiPreferiti(null);
		setTracciaDerivata(null);
		setAlbumAppartenenza(null);
		setArtistaCompositore(null);
		setArtistaPresente(null);
	}
	
	public Traccia(int idTraccia, String titolo, int durata, int anno, String genere, int versione, String qualitaAudio,
			String tipo, String accesso, int percentualeProd, ArrayList<Riproduzione> tracciaRiprodotta,
			ArrayList<Utente> utenteAggiungiPreferiti, ArrayList<Traccia> tracciaDerivata, Album albumAppartenenza,
			ArrayList<Artista> artistaCompositore, ArrayList<Artista> artistaPresente) 
	{
		setIdTraccia(idTraccia);
		setTitolo(titolo);
		setDurata(durata);
		setAnno(anno);
		setGenere(genere);
		setVersione(versione);
		setQualitàAudio(qualitàAudio);
		setTipo(tipo);
		setAccesso(accesso);
		setPercentualeProd(percentualeProd);
		setTracciaRiprodotta(tracciaRiprodotta);
		setUtenteAggiungiPreferiti(utenteAggiungiPreferiti);
		setTracciaDerivata(tracciaDerivata);
		setAlbumAppartenenza(albumAppartenenza);
		setArtistaCompositore(artistaCompositore);
		setArtistaPresente(artistaPresente);
	}
	
	public Traccia(String nomeUt,int idTraccia, String titolo,int versione, int asc) 
	{
		setUt(nomeUt);
		setIdTraccia(idTraccia);
		setTitolo(titolo);
		setVersione(versione);
		setAsc(asc);
	}
	
	public Traccia(String nomeTr,String Artosp) 
	{
		setTitolo(nomeTr);
		setFeat(Artosp);
	}
	
	public Traccia(int idTraccia, String titolo, int durata, int anno, String genere, int versione, String qualitàAudio,
			String tipo, String accesso, int percentualeProd) 
	{
		setIdTraccia(idTraccia);
		setTitolo(titolo);
		setDurata(durata);
		setAnno(anno);
		setGenere(genere);
		setVersione(versione);
		setQualitàAudio(qualitàAudio);
		setTipo(tipo);
		setAccesso(accesso);
		setPercentualeProd(percentualeProd);
	}
	
	public void scriviOutput()
	{
		System.out.println("La traccia è: ");
		System.out.println("id: "+getIdTraccia());
		System.out.println("Titolo: "+getTitolo());
		System.out.println("Durata: "+getDurata());
		System.out.println("Anno: "+getAnno());
		System.out.println("Genere: "+getGenere());
		System.out.println("Versione: "+getVersione());
		System.out.println("Qualità Audio: "+getQualitaAudio());
		System.out.println("Tipo: "+getTipo());
		System.out.println("Accesso: "+getAccesso());
		System.out.println("Percentuale Produttore:: "+getPercentualeProd());
	}
		
	public int getIdTraccia() 
	{
		return IdTraccia;
	}

	private void setIdTraccia(int idTraccia) 
	{
		this.IdTraccia = idTraccia;
	}
	
	private void setUt(String NomeUt)
	{
		this.nomeUt=NomeUt;
	}
	
	public String getNomeUt()
	{
		return nomeUt;
	}
	
	private void setAsc(int Asc)
	{
		this.asc=Asc;
	}
	
	public int getAsc()
	{
		return asc;
	}
	
	public String getTitolo() 
	{
		return Titolo;
	}
	
	private void setTitolo(String titolo) 
	{
		this.Titolo = titolo;
	}
	
	public int getDurata() 
	{
		return Durata;
	}
	
	private void setDurata(int durata) 
	{
		this.Durata = durata;
	}
	
	public int getAnno() 
	{
		return Anno;
	}
	
	private void setAnno(int anno) 
	{
		this.Anno = anno;
	}
	
	public String getGenere() 
	{
		return Genere;
	}
	
	private void setFeat(String featuring) 
	{
		this.artistaFeat = featuring;
	}
	
	public String getFeat() 
	{
		return artistaFeat;
	}
	
	private void setGenere(String genere) 
	{
		this.Genere = genere;
	}
	
	public int getVersione() 
	{
		return Versione;
	}
	
	private void setVersione(int versione) 
	{
		this.Versione = versione;
	}
	
	public String getQualitaAudio() 
	{
		return QualitàAudio;
	}
	
	private void setQualitaAudio(String qualitaAudio) 
	{
		this.QualitaAudio = qualitaAudio;
	}
	
	public String getTipo() 
	{
		return Tipo;
	}
	
	private void setTipo(String tipo) 
	{
		this.Tipo = tipo;
	}
	
	public String getAccesso() 
	{
		return Accesso;
	}
	
	private void setAccesso(String accesso) 
	{
		this.Accesso = accesso;
	}
	
	public int getPercentualeProd() 
	{
		return PercentualeProd;
	}
	
	private void setPercentualeProd(int percentualeProd) 
	{
		this.PercentualeProd = percentualeProd;
	}
	
	public ArrayList<Riproduzione> getTracciaRiprodotta() 
	{
		return tracciaRiprodotta;
	}
	
	private void setTracciaRiprodotta(ArrayList<Riproduzione> tracciaRiprodotta) 
	{
		this.tracciaRiprodotta = tracciaRiprodotta;
	}
	
	public ArrayList<Utente> getUtenteAggiungiPreferiti() 
	{
		return utenteAggiungiPreferiti;
	}
	
	private void setUtenteAggiungiPreferiti(ArrayList<Utente> utenteAggiungiPreferiti) 
	{
		this.utenteAggiungiPreferiti = utenteAggiungiPreferiti;
	}
	
	public ArrayList<Traccia> getTracciaDerivata() 
	{
		return tracciaDerivata;
	}
	
	private void setTracciaDerivata(ArrayList<Traccia> tracciaDerivata) 
	{
		this.tracciaDerivata = tracciaDerivata;
	}
	
	public Album getAlbumAppartenenza() 
	{
		return albumAppartenenza;
	}
	
	private void setAlbumAppartenenza(Album albumAppartenenza) 
	{
		this.albumAppartenenza = albumAppartenenza;
	}
	
	public ArrayList<Artista> getArtistaCompositore() 
	{
		return artistaCompositore;
	}
	
	private void setArtistaCompositore(ArrayList<Artista> artistaCompositore) 
	{
		this.artistaCompositore = artistaCompositore;
	}
	
	public ArrayList<Artista> getArtistaPresente() 
	{
		return artistaPresente;
	}
	
	private void setArtistaPresente(ArrayList<Artista> artistaPresente) 
	{
		this.artistaPresente = artistaPresente;
	}
}
