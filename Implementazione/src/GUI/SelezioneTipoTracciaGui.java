package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Controller.ControllerTraccia;

import Entità.Album;
import Entità.Utente;

public class SelezioneTipoTracciaGui 
{
	private JPanel contentPane;
	private JFrame selezTipoTr;    
	
	public SelezioneTipoTracciaGui(JFrame adminGui, ControllerTraccia controller, Utente utente, int codiceArtista, Album album)
	{
		System.out.println("Ti trovi in selezioneTipoTraccia");
		selezTipoTr = new JFrame();
		selezTipoTr.setBackground(new Color(20, 20, 20));
		selezTipoTr.setTitle("Tipo Traccia");
		selezTipoTr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		selezTipoTr.setBounds(170, 55, 1080, 720);
		selezTipoTr.setResizable(false);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(20, 20, 20));
		selezTipoTr.setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel EtichettaTipo = new JLabel("Tipo Traccia");
		EtichettaTipo.setForeground(new Color(0,76,153));
		EtichettaTipo.setFont(new Font("Courier", Font.CENTER_BASELINE, 50));
		EtichettaTipo.setBounds(355, 25, 450, 55);
		contentPane.add(EtichettaTipo);
		
		JLabel EtichettaBn = new JLabel("Scegliere la Tipologia della traccia:");
		EtichettaBn.setForeground(new Color(255,255,255));
		EtichettaBn.setFont(new Font("Courier", Font.CENTER_BASELINE, 20));
		EtichettaBn.setBounds(315, 85, 1000, 45);
		contentPane.add(EtichettaBn);
	
		JButton originale = new JButton("Originale");
		originale.setForeground(new Color(20,20,20));
		originale.setFont(new Font("Courier", Font.CENTER_BASELINE,20));
		originale.setBounds(275, 135, 200, 150);
		contentPane.add(originale);
	
		JButton derivata = new JButton("Derivate");
		derivata.setForeground(new Color(20,20,20));
		derivata.setFont(new Font("Courier", Font.CENTER_BASELINE,20));
		derivata.setBounds(605, 135, 200, 150);
		contentPane.add(derivata);
    
		selezTipoTr.setVisible(true);
	
	
		originale.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				
			}
		});
		originale.addMouseListener(new MouseAdapter() 
		{
			public void mouseClicked(MouseEvent e) 
			{
				selezTipoTr.dispose();
				@SuppressWarnings("unused")
				InserisciNuovaTracciaGui instrgui=new  InserisciNuovaTracciaGui(adminGui,controller,utente,codiceArtista,album);	
			}
		});

		derivata.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				
			}
		});
		derivata.addMouseListener(new MouseAdapter() 
		{
			public void mouseClicked(MouseEvent e) 
			{
				selezTipoTr.dispose();
				@SuppressWarnings("unused")
				SceltaTracciaOriginaleGui sceltatrgui=new SceltaTracciaOriginaleGui(adminGui,controller,utente,codiceArtista,album);
			}
		});
	}
}