package Controller;

import java.util.ArrayList;
import Entità.Riproduzione;
import ImplementazioneDao.ImplementazioneDaoRiproduzione;

public class ControllerRiproduzione 
{
	private ImplementazioneDaoRiproduzione ri;
	private ArrayList<Riproduzione> lista;

	public ControllerRiproduzione()
	{
		ri=new ImplementazioneDaoRiproduzione();
	}
	
	public ArrayList<Riproduzione> listaDettFascia(String nomeutente, String Password, String utente2)
	{
		lista=ri.listaDettFascia(nomeutente,Password,utente2);
		return lista;
	}
}
