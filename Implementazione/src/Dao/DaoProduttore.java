package Dao;

import java.util.ArrayList;
import Entita.Produttore;

public interface DaoProduttore 
{
	ArrayList<Produttore> listaProduttori();
	public ArrayList<Produttore> listaCompensiProduttori();
	public void InserisciProduttore(String nomeUtente, String Password, String nomeProd);
}
