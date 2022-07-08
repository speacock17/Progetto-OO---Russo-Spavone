package GUI;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JButton;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;

import Controller.ControllerAlbum;
import Controller.ControllerArtista;

import Entità.Artista;
import Entità.Utente;


public class ListaArtistaGui 
{
	private JPanel contentPane;
	private JFrame listaArGui;
    private ArrayList<Artista> listArtista = new ArrayList<Artista>();
    @SuppressWarnings("rawtypes")
	private JList listArt;

	public ListaArtistaGui(JFrame clientGui, ControllerArtista controller, Utente utente)
	{
		System.out.println("Sei in listaArtistaGui");
		
		listaArGui = new JFrame();
		listaArGui.setBackground(new Color(20, 20, 20));
		listaArGui.setTitle("Artisti");
		listaArGui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		listaArGui.setBounds(170, 55, 1080, 720);
		listaArGui.setResizable(false);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(20, 20, 20));
		listaArGui.setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel EtichettaArtista = new JLabel("Artisti");
		EtichettaArtista.setForeground(new Color(0,76,153));
		EtichettaArtista.setFont(new Font("Courier", Font.CENTER_BASELINE, 50));
		EtichettaArtista.setBounds(440, 25, 250, 45);
		contentPane.add(EtichettaArtista);
		
		JLabel EtichettaBn = new JLabel("Scegliere un'Artista: (Nome-Nazione-Etichetta)");
		EtichettaBn.setForeground(new Color(255,255,255));
		EtichettaBn.setFont(new Font("Courier", Font.CENTER_BASELINE, 20));
		EtichettaBn.setBounds(20, 75, 700, 45);
		contentPane.add(EtichettaBn);
		
		listArtista=controller.listaArtisti();
		DefaultListModel<String> model = new DefaultListModel<String>();
		listArt = new JList<String>(model);
		
		for(Artista varArt: listArtista)
		{
			model.addElement(varArt.getNome()+"-"+varArt.getNazione()+"-"+varArt.getEtichetta());
		}

		listArt.setBackground(new Color(255, 255, 255));
		listArt.setFont(new Font("Courier", Font.CENTER_BASELINE, 20));
		listArt.setSelectionBackground(new Color(0, 76, 153));
		listArt.setFixedCellHeight(40);
		JScrollPane scrollList = new JScrollPane();
	    scrollList.setViewportView(listArt);
	    listArt.setLayoutOrientation(JList.VERTICAL); 
	    scrollList.setBounds(20, 125, 1040, 490);
	    contentPane.add(scrollList);
	    
	    JButton visualizzaAlbumButton = new JButton("Visualizza Album");
	    visualizzaAlbumButton.setForeground(Color.BLACK);
	    visualizzaAlbumButton.setFont(new Font("Courier", Font.CENTER_BASELINE,20));
	    visualizzaAlbumButton.setBounds(280, 630, 250, 45);
		contentPane.add(visualizzaAlbumButton);
		
		JButton indietro = new JButton("Indietro");
		indietro.setForeground(Color.BLACK);
		indietro.setFont(new Font("Courier", Font.CENTER_BASELINE,20));
		indietro.setBounds(610, 630, 250, 45);
		contentPane.add(indietro);
	    
		listaArGui.setVisible(true);
		
		visualizzaAlbumButton.addMouseListener(new MouseAdapter() 
		{
			public void mouseClicked(MouseEvent e) 
			{
				if(listArt.getSelectedIndex() != -1)
				{
					listaArGui.dispose();
					ControllerAlbum controllerAl= new ControllerAlbum();
					@SuppressWarnings("unused")
					ListaAlbumDiArtista listargui=new ListaAlbumDiArtista(controllerAl,listArtista.get(listArt.getSelectedIndex()),clientGui,utente);
				}
				else
				{
					JOptionPane.showMessageDialog(visualizzaAlbumButton, "Scegliere un Artista.");
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
				listaArGui.dispose();
				clientGui.setVisible(true);
			}
		});
	}
	
	
	public ListaArtistaGui(JFrame clientGui, ControllerArtista controller, Utente utente, int codice)
	{
		System.out.println("Ti trovi in ListaArtistaGui2");
		
		listaArGui = new JFrame();
		listaArGui.setBackground(new Color(20, 20, 20));
		listaArGui.setTitle("Artisti");
		listaArGui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		listaArGui.setBounds(170, 55, 1080, 720);
		listaArGui.setResizable(false);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(20, 20, 20));
		listaArGui.setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel EtichettaArtista = new JLabel("Artisti");
		EtichettaArtista.setForeground(new Color(0,76,153));
		EtichettaArtista.setFont(new Font("Courier", Font.CENTER_BASELINE, 50));
		EtichettaArtista.setBounds(440, 25, 250, 45);
		contentPane.add(EtichettaArtista);
		
		JLabel EtichettaBn = new JLabel("Scegliere un'Artista: (Nome-Nazione-Etichetta)");
		EtichettaBn.setForeground(new Color(255,255,255));
		EtichettaBn.setFont(new Font("Courier", Font.CENTER_BASELINE, 20));
		EtichettaBn.setBounds(20, 75, 700, 45);
		contentPane.add(EtichettaBn);
		
		listArtista=controller.listaArtisti();
		DefaultListModel<String> model = new DefaultListModel<String>();
		listArt = new JList<String>(model);
		
		for(Artista varArt: listArtista)
		{
			model.addElement(varArt.getNome()+"-"+varArt.getNazione()+"-"+varArt.getEtichetta());
		}

		listArt.setBackground(new Color(255, 255, 255));
		listArt.setFont(new Font("Courier", Font.CENTER_BASELINE, 20));
		listArt.setSelectionBackground(new Color(0, 76, 153));
		listArt.setFixedCellHeight(40);
		JScrollPane scrollList = new JScrollPane();
	    scrollList.setViewportView(listArt);
	    listArt.setLayoutOrientation(JList.VERTICAL); 
	    scrollList.setBounds(20, 125, 1040, 490);
	    contentPane.add(scrollList);
	   
		JButton indietro = new JButton("Indietro");
		indietro.setForeground(new Color(20,20,20));
		indietro.setFont(new Font("Courier", Font.CENTER_BASELINE,20));
		indietro.setBounds(390, 630, 250, 45);
		contentPane.add(indietro);
	    
		listaArGui.setVisible(true);
	
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
				listaArGui.dispose();
				clientGui.setVisible(true);
			}
		});
	}
	
	
	public ListaArtistaGui(JFrame clientGui, ControllerArtista controller, Utente utente, int codice1, int codice2)
	{
		System.out.println("Ti trovi in ListaArtistaGui3");
		
		listaArGui = new JFrame();
		listaArGui.setBackground(new Color(20, 20, 20));
		listaArGui.setTitle("Artisti");
		listaArGui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		listaArGui.setBounds(170, 55, 1080, 720);
		listaArGui.setResizable(false);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(20, 20, 20));
		listaArGui.setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel EtichettaArtista = new JLabel("Artisti");
		EtichettaArtista.setForeground(new Color(0,76,153));
		EtichettaArtista.setFont(new Font("Courier", Font.CENTER_BASELINE, 50));
		EtichettaArtista.setBounds(440, 25, 250, 45);
		contentPane.add(EtichettaArtista);
		
		JLabel EtichettaBn = new JLabel("Scegliere un'Artista: (Nome-Nazione-Etichetta)");
		EtichettaBn.setForeground(new Color(255,255,255));
		EtichettaBn.setFont(new Font("Courier", Font.CENTER_BASELINE, 20));
		EtichettaBn.setBounds(20, 75, 700, 45);
		contentPane.add(EtichettaBn);
		
		listArtista=controller.listaArtisti();
		DefaultListModel<String> model = new DefaultListModel<String>();
		listArt = new JList<String>(model);
		
		for(Artista varArt: listArtista)
		{
			model.addElement(varArt.getNome()+"-"+varArt.getNazione()+"-"+varArt.getEtichetta());
		}

		listArt.setBackground(new Color(255, 255, 255));
		listArt.setFont(new Font("Courier", Font.CENTER_BASELINE, 20));
		listArt.setSelectionBackground(new Color(0, 76, 153));
		listArt.setFixedCellHeight(40);
		JScrollPane scrollList = new JScrollPane();
	    scrollList.setViewportView(listArt);
	    listArt.setLayoutOrientation(JList.VERTICAL); 
	    scrollList.setBounds(20, 125, 1040, 490);
	    contentPane.add(scrollList);
	    
	    JButton visualizzaAlbumButton = new JButton("Visualizza Album");
	    visualizzaAlbumButton.setForeground(new Color(20,20,20));
	    visualizzaAlbumButton.setFont(new Font("Courier", Font.CENTER_BASELINE,20));
	    visualizzaAlbumButton.setBounds(280, 630, 250, 45);
		contentPane.add(visualizzaAlbumButton);
		
		JButton indietro = new JButton("Indietro");
		indietro.setForeground(new Color(20,20,20));
		indietro.setFont(new Font("Courier", Font.CENTER_BASELINE,20));
		indietro.setBounds(610, 630, 250, 45);
		contentPane.add(indietro);
	    
		listaArGui.setVisible(true);
		
		visualizzaAlbumButton.addMouseListener(new MouseAdapter() 
		{
			public void mouseClicked(MouseEvent e) 
			{
				if(listArt.getSelectedIndex() != -1)
				{
					listaArGui.dispose();
					ControllerAlbum controllerAl= new ControllerAlbum();
					@SuppressWarnings("unused")
					ListaAlbumDiArtista listargui=new ListaAlbumDiArtista(controllerAl,listArtista.get(listArt.getSelectedIndex()),clientGui,utente,1);
				}
				else
				{
					JOptionPane.showMessageDialog(visualizzaAlbumButton, "Scegliere un Artista.");
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
				listaArGui.dispose();
				clientGui.setVisible(true);
			}
		});
	}
}