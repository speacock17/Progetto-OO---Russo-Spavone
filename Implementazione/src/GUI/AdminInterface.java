package GUI;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;

import Controller.ControllerAlbum;
import Controller.ControllerArtista;
import Controller.ControllerProduttore;
import Controller.ControllerTraccia;
import Controller.ControllerUtente;

import Entità.Utente;


@SuppressWarnings("serial")
public class AdminInterface extends JFrame
{
	private JPanel contentPane;
	private JFrame AdminGui;
	private int codiceAzione;
	
	public AdminInterface(JFrame loginGui, ControllerUtente controller, Utente utente) 
	{
		loginGui.setVisible(false);
		AdminGui=this;
		AdminGui.setVisible(true);
		
		AdminGui.setBackground(new Color(20, 20, 20));
		AdminGui.setTitle("Admin");
		AdminGui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		AdminGui.setBounds(170, 55, 1080, 720);
		AdminGui.setResizable(false);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(20, 20, 20));
		AdminGui.setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel etichettaHome = new JLabel("HOME");
		etichettaHome.setForeground(new Color(0,76,153));
		etichettaHome.setFont(new Font("Courier", Font.CENTER_BASELINE, 50));
		etichettaHome.setBounds(480, 25, 120, 45);
		contentPane.add(etichettaHome);
		
		JLabel etichettaNomeCognome= new JLabel("Benvenuto/a: "+utente.getNome()+" "+utente.getCognome());
	    JLabel etichettaBn = new JLabel("Scegliere che operazione eseguire:");
	    
	    etichettaNomeCognome.setForeground(new Color(255,255,255));
	    etichettaNomeCognome.setFont(new Font("Courier", Font.CENTER_BASELINE, 20));
	    etichettaNomeCognome.setBounds(75, 75, 550, 45);
		contentPane.add(etichettaNomeCognome);
		
		etichettaBn.setForeground(new Color(255,255,255));
		etichettaBn.setFont(new Font("Courier", Font.CENTER_BASELINE, 20));
		etichettaBn.setBounds(75, 100, 450, 45);
		contentPane.add(etichettaBn);
		
		JButton nuovoArtistaButton = new JButton("Inserisci un nuovo Artista");
		nuovoArtistaButton.setForeground(new Color(20,20,20));
		nuovoArtistaButton.setFont(new Font("Courier", Font.CENTER_BASELINE,20));
		nuovoArtistaButton.setBounds(70, 150, 370, 45);
		contentPane.add(nuovoArtistaButton);
		
		JButton nuovoAlbumButton = new JButton("Inserisci un nuovo Album");
		nuovoAlbumButton.setForeground(new Color(20,20,20));
		nuovoAlbumButton.setFont(new Font("Courier", Font.CENTER_BASELINE,20));
		nuovoAlbumButton.setBounds(640, 150, 370, 45);
		contentPane.add(nuovoAlbumButton);
		
		JButton nuovaTracciaButton = new JButton("Inserisci una nuova Traccia");
		nuovaTracciaButton.setForeground(new Color(20,20,20));
		nuovaTracciaButton.setFont(new Font("Courier", Font.CENTER_BASELINE,20));
		nuovaTracciaButton.setBounds(70, 210, 370, 45);
		contentPane.add(nuovaTracciaButton);
		
		JButton inserisciFeaturing = new JButton("Inserisci un Featuring");
		inserisciFeaturing.setForeground(new Color(20,20,20));
		inserisciFeaturing.setFont(new Font("Courier", Font.CENTER_BASELINE,20));
		inserisciFeaturing.setBounds(640, 210, 370, 45);
		contentPane.add(inserisciFeaturing);
		
		JButton inserisciProd = new JButton("Inserisci un Produttore");
		inserisciProd.setForeground(new Color(20,20,20));
		inserisciProd.setFont(new Font("Courier", Font.CENTER_BASELINE,20));
		inserisciProd.setBounds(70, 270, 370, 45);
		contentPane.add(inserisciProd);
		
		JButton cancellaArtistaButton = new JButton("Cancella un Artista");
		cancellaArtistaButton.setForeground(new Color(20,20,20));
		cancellaArtistaButton.setFont(new Font("Courier", Font.CENTER_BASELINE,20));
		cancellaArtistaButton.setBounds(640, 270, 370, 45);
		contentPane.add(cancellaArtistaButton);
		
		JButton cancellaAlbumButton = new JButton("Cancella un Album");
		cancellaAlbumButton.setForeground(new Color(20,20,20));
		cancellaAlbumButton.setFont(new Font("Courier", Font.CENTER_BASELINE,20));
		cancellaAlbumButton.setBounds(640, 330, 370, 45);
		contentPane.add(cancellaAlbumButton);
		
		JButton cancellaTracciaButton = new JButton("Cancella una Traccia");
		cancellaTracciaButton.setForeground(new Color(20,20,20));
		cancellaTracciaButton.setFont(new Font("Courier", Font.CENTER_BASELINE,20));
		cancellaTracciaButton.setBounds(70, 330, 370, 45);
		contentPane.add(cancellaTracciaButton);
		
		JButton viewArtistaButton = new JButton("Visualizza lista Artisti");
		viewArtistaButton.setForeground(new Color(20,20,20));
		viewArtistaButton.setFont(new Font("Courier", Font.CENTER_BASELINE,20));
		viewArtistaButton.setBounds(640, 390, 370, 45);
		contentPane.add(viewArtistaButton);
		
		JButton viewAlbumButton = new JButton("Visualizza lista Album");
		viewAlbumButton.setForeground(new Color(20,20,20));
		viewAlbumButton.setFont(new Font("Courier", Font.CENTER_BASELINE,20));
		viewAlbumButton.setBounds(70, 390, 370, 45);
		contentPane.add(viewAlbumButton);
		
		JButton viewTracciaButton = new JButton("Visualizza lista Traccia");
		viewTracciaButton.setForeground(new Color(20,20,20));
		viewTracciaButton.setFont(new Font("Courier", Font.CENTER_BASELINE,20));
		viewTracciaButton.setBounds(640, 450, 370, 45);
		contentPane.add(viewTracciaButton);
		
		JButton viewUtentiButton = new JButton("Visualizza lista Utenti");
		viewUtentiButton.setForeground(new Color(20,20,20));
		viewUtentiButton.setFont(new Font("Courier", Font.CENTER_BASELINE,20));
		viewUtentiButton.setBounds(70, 450, 370, 45);
		contentPane.add(viewUtentiButton);
		
		JButton viewProdButton = new JButton("Visualizza lista Produttori");
		viewProdButton.setForeground(new Color(20,20,20));
		viewProdButton.setFont(new Font("Courier", Font.CENTER_BASELINE,20));
		viewProdButton.setBounds(640, 510, 370, 45);
		contentPane.add(viewProdButton);
		
		JButton viewDettagliAscoltiButton = new JButton("Visualizza dettagli Ascolti");
		viewDettagliAscoltiButton.setForeground(new Color(20,20,20));
		viewDettagliAscoltiButton.setFont(new Font("Courier", Font.CENTER_BASELINE,20));
		viewDettagliAscoltiButton.setBounds(70, 510, 370, 45);
		contentPane.add(viewDettagliAscoltiButton);
		
		JButton logoutButton = new JButton("LOGOUT");
		logoutButton.setForeground(new Color(20,20,20));
		logoutButton.setFont(new Font("Courier", Font.CENTER_BASELINE,20));
		logoutButton.setBounds(440, 570, 210, 45);
		contentPane.add(logoutButton);
		
		nuovoArtistaButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				
			}
		});
		nuovoArtistaButton.addMouseListener(new MouseAdapter() 
		{
			public void mouseClicked(MouseEvent e) 
			{	
				AdminGui.dispose();
				ControllerArtista controllerAr= new ControllerArtista();
				@SuppressWarnings("unused")
				InserisciNuovoArtistaGui inserisciargui=new InserisciNuovoArtistaGui(AdminGui, controllerAr, utente);
			}
		});
		
		nuovoAlbumButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				
			}
		});
		nuovoAlbumButton.addMouseListener(new MouseAdapter() 
		{
			public void mouseClicked(MouseEvent e) 
			{
				AdminGui.dispose();
				ControllerArtista controllerAr= new ControllerArtista();
				codiceAzione=1;
				@SuppressWarnings("unused")
				SelezioneArtistaGui inseriscialb=new SelezioneArtistaGui(AdminGui, controllerAr, utente, codiceAzione);
			}
		});
		
		nuovaTracciaButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				
			}
		});
		nuovaTracciaButton.addMouseListener(new MouseAdapter() 
		{
			public void mouseClicked(MouseEvent e) 
			{
				AdminGui.dispose();
				ControllerArtista controllerAr= new ControllerArtista();
				codiceAzione=2;
				@SuppressWarnings("unused")
				SelezioneArtistaGui selezArt=new SelezioneArtistaGui(AdminGui,controllerAr,utente,codiceAzione);			
			}
		});
		
		inserisciFeaturing.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				
			}
		});
		inserisciFeaturing.addMouseListener(new MouseAdapter() 
		{
			public void mouseClicked(MouseEvent e) 
			{
				AdminGui.dispose();
				ControllerArtista controllerAr= new ControllerArtista();
				codiceAzione=3;
				@SuppressWarnings("unused")
				SelezioneArtistaGui selezArt=new SelezioneArtistaGui(AdminGui,controllerAr,utente,codiceAzione);			
			}
		});
		
		inserisciProd.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				
			}
		});
		inserisciProd.addMouseListener(new MouseAdapter() 
		{
			public void mouseClicked(MouseEvent e) 
			{
				AdminGui.dispose();
				ControllerProduttore controllerPr= new ControllerProduttore();
				@SuppressWarnings("unused")
				InserisciProduttoreGui insProd=new InserisciProduttoreGui(AdminGui,controllerPr,utente);			
			}
		});
		
		cancellaArtistaButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				
			}
		});
		cancellaArtistaButton.addMouseListener(new MouseAdapter() 
		{
			public void mouseClicked(MouseEvent e) 
			{
				AdminGui.dispose();
				ControllerArtista controllerAr = new ControllerArtista();
				@SuppressWarnings("unused")
				CancellaArtistaGui cancellaartgui=new CancellaArtistaGui(AdminGui, controllerAr , utente);
			}
		});
		
		cancellaAlbumButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				
			}
		});
		cancellaAlbumButton.addMouseListener(new MouseAdapter() 
		{
			public void mouseClicked(MouseEvent e) 
			{
				AdminGui.dispose();
				ControllerAlbum controllerAl = new ControllerAlbum();
				@SuppressWarnings("unused")
				CancellaAlbumGui cancellaalbgui=new CancellaAlbumGui(controllerAl, AdminGui , utente);			
			}
		});
		
		cancellaTracciaButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				
			}
		});
		cancellaTracciaButton.addMouseListener(new MouseAdapter() 
		{
			public void mouseClicked(MouseEvent e) 
			{
				AdminGui.dispose();
				ControllerTraccia controllerTr = new ControllerTraccia();
				@SuppressWarnings("unused")
				CancellaTracciaGui cancellatrgui=new CancellaTracciaGui(controllerTr, AdminGui , utente);
			}
		});
		
		viewArtistaButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				
			}
		});
		viewArtistaButton.addMouseListener(new MouseAdapter() 
		{
			public void mouseClicked(MouseEvent e) 
			{
				AdminGui.dispose();
				ControllerArtista controllerAr = new ControllerArtista();
				@SuppressWarnings("unused")
				ListaArtistaGui listaar=new ListaArtistaGui(AdminGui, controllerAr , utente,1);
			}
		});
		
		viewAlbumButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				
			}
		});
		viewAlbumButton.addMouseListener(new MouseAdapter() 
		{
			public void mouseClicked(MouseEvent e) 
			{
				AdminGui.dispose();
				ControllerAlbum controllerAl = new ControllerAlbum();
				@SuppressWarnings("unused")
				ListaAlbum listaal=new ListaAlbum(controllerAl, AdminGui , utente,1);
			}
		});
		
		viewTracciaButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				
			}
		});
		viewTracciaButton.addMouseListener(new MouseAdapter() 
		{
			public void mouseClicked(MouseEvent e) 
			{
				AdminGui.dispose();
				ControllerTraccia controllerTr = new ControllerTraccia();
				@SuppressWarnings("unused")
				ListaTracce listatrgui=new ListaTracce(controllerTr, AdminGui , utente,1);
			}
		});
		
		viewUtentiButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				
			}
		});
		viewUtentiButton.addMouseListener(new MouseAdapter() 
		{
			public void mouseClicked(MouseEvent e) 
			{
				AdminGui.dispose();
				ControllerUtente controllerUt = new ControllerUtente();
				@SuppressWarnings("unused")
				ListaUtente listautgui=new ListaUtente(controllerUt, AdminGui , utente);
			}
		});
		
		viewProdButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				
			}
		});
		viewProdButton.addMouseListener(new MouseAdapter() 
		{
			public void mouseClicked(MouseEvent e) 
			{
				AdminGui.dispose();
				ControllerProduttore controllerPr = new ControllerProduttore();
				@SuppressWarnings("unused")
				ListaProduttoreGui listaprgui=new ListaProduttoreGui(controllerPr, AdminGui , utente);
			}
		});
		
		viewDettagliAscoltiButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				
			}
		});
		viewDettagliAscoltiButton.addMouseListener(new MouseAdapter() 
		{
			public void mouseClicked(MouseEvent e) 
			{
				AdminGui.dispose();
				ControllerArtista controllerAr= new ControllerArtista();
				@SuppressWarnings("unused")
				ListaArtistaGui listargui=new ListaArtistaGui(AdminGui, controllerAr, utente,1,1);
			}
		});
		
		logoutButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				
			}
		});
		logoutButton.addMouseListener(new MouseAdapter() 
		{
			public void mouseClicked(MouseEvent e) 
			{
				AdminGui.dispose();
				loginGui.setVisible(true);
			}
		});	
	}
}

