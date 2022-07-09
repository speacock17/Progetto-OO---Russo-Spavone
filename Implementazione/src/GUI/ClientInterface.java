package GUI;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;

import java.awt.Font;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import Controller.ControllerAlbum;
import Controller.ControllerArtista;
import Controller.ControllerTraccia;

import Controller.ControllerUtente;

import Entita.Utente;

@SuppressWarnings("serial")
public class ClientInterface extends JFrame
{
	private JPanel contentPane;
	private JFrame ClientGui;
	
	public ClientInterface(JFrame loginGui, ControllerUtente controller, Utente utente) 
	{
		loginGui.setVisible(false);
		ClientGui=this;
		ClientGui.setVisible(true);
		
		ClientGui.setBackground(new Color(20, 20, 20));
		ClientGui.setTitle("Home");
		ClientGui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ClientGui.setBounds(170, 55, 1080, 720);
		ClientGui.setResizable(false);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(20, 20, 20));
		ClientGui.setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel etichettaHome = new JLabel("HOME");
		etichettaHome.setForeground(new Color(0,76,153));
		etichettaHome.setFont(new Font("Courier", Font.CENTER_BASELINE, 50));
		etichettaHome.setBounds(480, 25, 120, 45);
		contentPane.add(etichettaHome);
		
	    JLabel etichettaNomeCognome= new JLabel("Benvenuto/a: "+utente.getNome()+" "+utente.getCognome());
	    JLabel etichettaBn = new JLabel("Scegliere operazione da eseguire:");
	    
	    etichettaNomeCognome.setForeground(new Color(255,255,255));
	    etichettaNomeCognome.setFont(new Font("Courier", Font.CENTER_BASELINE, 20));
	    etichettaNomeCognome.setBounds(75, 75, 350, 45);
		contentPane.add(etichettaNomeCognome);
		
		etichettaBn.setForeground(new Color(255,255,255));
		etichettaBn.setFont(new Font("Courier", Font.CENTER_BASELINE, 20));
		etichettaBn.setBounds(75, 100, 450, 45);
		contentPane.add(etichettaBn);
		 
		JButton viewListaArtistiButton = new JButton("Visualizza Artisti");
		viewListaArtistiButton.setForeground(new Color(20,20,20));
		viewListaArtistiButton.setFont(new Font("Courier", Font.CENTER_BASELINE,20));
		viewListaArtistiButton.setBounds(70, 150, 370, 45);
		contentPane.add(viewListaArtistiButton);
		
		JButton viewListaAlbumButton = new JButton("Visualizza Album");
		viewListaAlbumButton.setForeground(new Color(20,20,20));
		viewListaAlbumButton.setFont(new Font("Courier", Font.CENTER_BASELINE,20));
		viewListaAlbumButton.setBounds(640, 150, 370, 45);
		contentPane.add(viewListaAlbumButton);
		
		JButton viewListaTracciaButton = new JButton("Visualizza Tracce");
		viewListaTracciaButton.setForeground(new Color(20,20,20));
		viewListaTracciaButton.setFont(new Font("Courier", Font.CENTER_BASELINE,20));
		viewListaTracciaButton.setBounds(70, 210, 370, 45);
		contentPane.add(viewListaTracciaButton);
		
		JButton viewListaBraniPreferiti = new JButton("Visualizza Brani Preferiti");
		viewListaBraniPreferiti.setForeground(new Color(20,20,20));
		viewListaBraniPreferiti.setFont(new Font("Courier", Font.CENTER_BASELINE,20));
		viewListaBraniPreferiti.setBounds(640, 210, 370, 45);
		contentPane.add(viewListaBraniPreferiti);
		
		JButton viewImpostazioniInterfaceClient = new JButton("Impostazioni");
		viewImpostazioniInterfaceClient.setForeground(new Color(20,20,20));
		viewImpostazioniInterfaceClient.setFont(new Font("Courier", Font.CENTER_BASELINE,20));
		viewImpostazioniInterfaceClient.setBounds(70, 270, 370, 45);
		contentPane.add(viewImpostazioniInterfaceClient);
		
		JButton logoutButton = new JButton("Logout");
		logoutButton.setForeground(new Color(20,20,20));
		logoutButton.setFont(new Font("Courier", Font.CENTER_BASELINE,20));
		logoutButton.setBounds(640, 270, 370, 45);
		contentPane.add(logoutButton);
		
		
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
				ClientGui.dispose();
				loginGui.setVisible(true);
			}
		});
		
		viewImpostazioniInterfaceClient.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				
			}
		});
		viewImpostazioniInterfaceClient.addMouseListener(new MouseAdapter() 
		{
			public void mouseClicked(MouseEvent e) 
			{
				ClientGui.dispose();
				@SuppressWarnings("unused")
				ImpostazioniClient impclient=new ImpostazioniClient(ClientGui, controller, utente);
			}
		});
		
		viewListaArtistiButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				
			}
		});
		viewListaArtistiButton.addMouseListener(new MouseAdapter() 
		{
			public void mouseClicked(MouseEvent e) 
			{
				ClientGui.dispose();
				ControllerArtista controllerAr= new ControllerArtista();
				@SuppressWarnings("unused")
				ListaArtistaGui listargui=new ListaArtistaGui(ClientGui, controllerAr, utente);
			}
		});
		
		viewListaAlbumButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				
			}
		});
		viewListaAlbumButton.addMouseListener(new MouseAdapter() 
		{
			public void mouseClicked(MouseEvent e) 
			{
				ClientGui.dispose();
				ControllerAlbum controllerAl= new ControllerAlbum();
				@SuppressWarnings("unused")
				ListaAlbum listalgui=new ListaAlbum(controllerAl, ClientGui, utente);
			}
		});
		
		viewListaTracciaButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				
			}
		});
		viewListaTracciaButton.addMouseListener(new MouseAdapter() 
		{
			public void mouseClicked(MouseEvent e) 
			{
				ClientGui.dispose();
				ControllerTraccia controllerTr= new ControllerTraccia();
				@SuppressWarnings("unused")
				ListaTracce listtrgui=new ListaTracce(controllerTr, ClientGui, utente);
			}
		});
		
		viewListaBraniPreferiti.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				
			}
		});
		viewListaBraniPreferiti.addMouseListener(new MouseAdapter() 
		{
			public void mouseClicked(MouseEvent e) 
			{
				ClientGui.dispose();
				ControllerTraccia controllerTr= new ControllerTraccia();
				@SuppressWarnings("unused")
				ListaPreferiti listprgui=new ListaPreferiti(controllerTr, ClientGui, utente);
			}
		});
	}
}
