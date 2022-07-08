package Entità;

public class Riproduzione 
{	
	private int IdRiprod;
	private String FasciaOraria;
	private Utente riproduttoreTraccia;
	private Traccia tracciaEseguita;
	private int numRiprod;
	
	public Riproduzione()
	{
		setIdRiprod(0);
		setFasciaOraria("default");
		setRiproduttoreTraccia(null);
		setTracciaEseguita(null);
	}
	
	public Riproduzione(int idRiprod, String fasciaOraria, Utente riproduttoreTraccia, Traccia tracciaEseguita) 
	{
		setIdRiprod(idRiprod);
		setFasciaOraria(fasciaOraria);
		setRiproduttoreTraccia(riproduttoreTraccia);
		setTracciaEseguita(tracciaEseguita);
	}
	
	public Riproduzione(String fasciaOraria,int numriprod)
	{
		setFasciaOraria(fasciaOraria);
		setNumRiprod(numriprod);
	}
	
	public void scriviOutput()
	{
		System.out.println("La Riproduzione è: ");
		System.out.println("id: "+getIdRiprod());
		System.out.println("Fascia Oraria: "+getFasciaOraria());
	}
	
	public int getIdRiprod() 
	{
		return IdRiprod;
	}

	private void setIdRiprod(int idRiprod) 
	{
		this.IdRiprod = idRiprod;
	}
	
	public int getNumRiprod() 
	{
		return numRiprod;
	}
	
	private void setNumRiprod(int numriprod) 
	{
		this.numRiprod = numriprod;
	}
	
	public String getFasciaOraria() 
	{
		return FasciaOraria;
	}
	
	private void setFasciaOraria(String fasciaOraria) 
	{
		this.FasciaOraria = fasciaOraria;
	}
	
	public Utente getRiproduttoreTraccia() 
	{
		return riproduttoreTraccia;
	}
	
	private void setRiproduttoreTraccia(Utente riproduttoreTraccia) 
	{
		this.riproduttoreTraccia = riproduttoreTraccia;
	}
		
	public Traccia getTracciaEseguita() 
	{
		return tracciaEseguita;
	}

	private void setTracciaEseguita(Traccia tracciaEseguita) 
	{
		this.tracciaEseguita = tracciaEseguita;
	}	
}