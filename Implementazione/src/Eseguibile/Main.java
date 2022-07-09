package Eseguibile;
import GUI.Login;
import Controller.ControllerUtente;
import java.awt.EventQueue;

public class Main 
{
	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try 
				{
					System.out.println("Avvio della gui");
					ControllerUtente controller= new ControllerUtente();
					@SuppressWarnings("unused")
					Login login= new Login(controller);
				} 
				catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
	}
}
