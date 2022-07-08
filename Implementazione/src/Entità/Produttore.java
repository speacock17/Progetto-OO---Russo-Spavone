package Entità;

import java.util.ArrayList;

public class Produttore 
{	
	private int IdProd;
	private String Nome;
	private ArrayList<Album> albumProdotto;
	float Compensi;
	
	public Produttore()
	{	
		setIdProd(0);
		setNome("nessun nome");
		setAlbumProdotto(null);
	}
		
	public Produttore(int idProd, String nome, ArrayList<Album> albumProdotto) 
	{
		setIdProd(idProd);
		setNome(nome);
		setAlbumProdotto(albumProdotto);
	}
	
	public Produttore(int idProd, String nome) 
	{
		setIdProd(idProd);
		setNome(nome);
	}
	
	public Produttore(String nome, float compensi)
	{
		setNome(nome);
		Compensi=compensi;
	}
	
	public void scriviOutput()
	{
		System.out.println("Il Produttore è: ");
		System.out.println("id: "+getIdProd());
		System.out.println("Nome: "+getNome());
	}
	
	public int getIdProd() 
	{
		return IdProd;
	}
	
	private void setIdProd(int idProd)
	{
		IdProd = idProd;
	}
	
	public String getNome() 
	{
		return Nome;
	}
	
	public float getCompensi() 
	{
		return Compensi;
	}
	
	private void setNome(String nome) 
	{
		Nome = nome;
	}
	
	public ArrayList<Album> getAlbumProdotto()
	{
		return albumProdotto;
	}
	
	private void setAlbumProdotto(ArrayList<Album> albumProdotto) 
	{
		this.albumProdotto = albumProdotto;
	}
}