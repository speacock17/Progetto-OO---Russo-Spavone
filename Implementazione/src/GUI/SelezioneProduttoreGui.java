package GUI;

import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;

import Controller.ControllerAlbum;
import Controller.ControllerProduttore;

import Entità.Artista;
import Entità.Produttore;
import Entità.Utente;


public class SelezioneProduttoreGui 
{
	private JPanel contentPane;
	private JFrame listaPrGui;
	private ArrayList<Produttore> listProduttore = new ArrayList<Produttore>();
    @SuppressWarnings("rawtypes")
	private JList listPrd;
    
	public SelezioneProduttoreGui(ControllerProduttore controller, Artista artista,JFrame adminGui, Utente utente)
	{
		System.out.println("ti trovi in lista produttore");
		
		listaPrGui = new JFrame();
		listaPrGui.setBackground(new Color(20, 20, 20));
		listaPrGui.setTitle("Produttore");
		listaPrGui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		listaPrGui.setBounds(170, 55, 1080, 720);
		listaPrGui.setResizable(false);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(20, 20, 20));
		listaPrGui.setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel EtichettaArtista = new JLabel("Produttori");
		EtichettaArtista.setForeground(new Color(0,76,153));
		EtichettaArtista.setFont(new Font("Courier", Font.CENTER_BASELINE, 50));
		EtichettaArtista.setBounds(390, 25, 450, 45);
		contentPane.add(EtichettaArtista);
		
		JLabel EtichettaBn = new JLabel("Scegliere un Produttore:");
		EtichettaBn.setForeground(new Color(255,255,255));
		EtichettaBn.setFont(new Font("Courier", Font.CENTER_BASELINE, 20));
		EtichettaBn.setBounds(20, 75, 500, 45);
		contentPane.add(EtichettaBn);
		
		listProduttore=controller.listaProduttori();
		DefaultListModel<String> model = new DefaultListModel<String>();
		listPrd = new JList<String>(model);
		
		for(Produttore varArt: listProduttore)
		{
			model.addElement(varArt.getNome());
		}

		listPrd.setBackground(new Color(255, 255, 255));
		listPrd.setFont(new Font("Courier", Font.CENTER_BASELINE, 20));
		listPrd.setSelectionBackground(new Color(0, 76, 153));
		listPrd.setFixedCellHeight(40);
		JScrollPane scrollList = new JScrollPane();
		scrollList.setViewportView(listPrd);
	    listPrd.setLayoutOrientation(JList.VERTICAL); 
	    scrollList.setBounds(20, 125, 1040, 490);
	    contentPane.add(scrollList);
	    
	    JButton avanza = new JButton("Seleziona Produttore");
	    avanza.setForeground(new Color(20,20,20));
	    avanza.setFont(new Font("Courier", Font.CENTER_BASELINE,20));
	    avanza.setBounds(280, 630, 250, 45);
		contentPane.add(avanza);
		
		JButton indietro = new JButton("Indietro");
		indietro.setForeground(new Color(20,20,20));
		indietro.setFont(new Font("Courier", Font.CENTER_BASELINE,20));
		indietro.setBounds(610, 630, 250, 45);
		contentPane.add(indietro);
	    
		listaPrGui.setVisible(true);
		
		avanza.addMouseListener(new MouseAdapter() 
		{
			public void mouseClicked(MouseEvent e) 
			{
				if(listPrd.getSelectedIndex() != -1)
				{
					listaPrGui.dispose();
					ControllerAlbum controllerAl= new ControllerAlbum();
					@SuppressWarnings("unused")
					InserisciNuovoAlbumGui insAlb=new InserisciNuovoAlbumGui(controllerAl,listProduttore.get(listPrd.getSelectedIndex()),adminGui,utente,artista);
				}
				else
				{
					JOptionPane.showMessageDialog(avanza, "Scegliere un Artista.");
				}
			}
		});
		
		indietro.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				
			}
		});
		indietro.addMouseListener(new MouseAdapter() 
		{
			public void mouseClicked(MouseEvent e) 
			{
				listaPrGui.dispose();
				adminGui.setVisible(true);
			}
		});
	}
}