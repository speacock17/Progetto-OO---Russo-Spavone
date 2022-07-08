package Controller;

import java.util.ArrayList;
import ImplementazioneDao.ImplementazioneDaoProduttore;
import Entità.Produttore;

public class ControllerProduttore 
{
	private ImplementazioneDaoProduttore pr;
	private ArrayList<Produttore> lista;
	
	public ControllerProduttore()
	{
		pr=new ImplementazioneDaoProduttore();
	}
	
	public ArrayList<Produttore> listaProduttori()
	{
		lista=pr.listaProduttori();
		return lista;
	}
	
	public ArrayList<Produttore> listaCompensiProduttori()
	{
		lista=pr.listaCompensiProduttori();
		return lista;
	}
	
	public void InserisciProduttore(String nomeUtente, String Password, String nomeProd)
	{
		pr.InserisciProduttore(nomeUtente, Password, nomeProd);
	}
	
}
