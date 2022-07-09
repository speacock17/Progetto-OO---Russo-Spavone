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
import Controller.ControllerTraccia;

import Entita.Album;
import Entita.Artista;
import Entita.Utente;


public class ListaAlbumDiArtista 
{
	private JPanel contentPane;
	private JFrame listaAlGui;
	private ArrayList<Album> listAlbum = new ArrayList<Album>();
	@SuppressWarnings("rawtypes")
	private JList listAlb;
		
	public ListaAlbumDiArtista(ControllerAlbum controller, Artista artista,JFrame clientGui,Utente utente)
	{
		System.out.println("Ti trovi in ListaAlbumDiArtista.");
		
		listaAlGui = new JFrame();
		listaAlGui.setBackground(new Color(20, 20, 20));
		listaAlGui.setTitle("Album");
		listaAlGui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		listaAlGui.setBounds(170, 55, 1080, 720);
		listaAlGui.setResizable(false);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(20, 20, 20));
		listaAlGui.setContentPane(contentPane);
		contentPane.setLayout(null);
			
		JLabel EtichettaAlbum = new JLabel("Album");
		EtichettaAlbum.setForeground(new Color(0,76,153));
		EtichettaAlbum.setFont(new Font("Courier", Font.CENTER_BASELINE, 50));
		EtichettaAlbum.setBounds(450, 25, 250, 45);
		contentPane.add(EtichettaAlbum);
		
		JLabel EtichettaBn = new JLabel("Scegliere un Album: (Titolo-Anno-Produttore)");
		EtichettaBn.setForeground(new Color(255,255,255));
		EtichettaBn.setFont(new Font("Courier", Font.CENTER_BASELINE, 20));
		EtichettaBn.setBounds(20, 75, 700, 45);
		contentPane.add(EtichettaBn);
			
		listAlbum=controller.listaAlbum(artista.getIdArtista());
		DefaultListModel<String> model = new DefaultListModel<String>();
		listAlb = new JList<String>(model);
			
		for(Album varAlb: listAlbum)
		{
			model.addElement(varAlb.getTitolo()+"-"+varAlb.getAnno()+"-"+varAlb.getProduttoreAlbum().getNome());
		}

		listAlb.setBackground(new Color(255, 255, 255));
		listAlb.setFont(new Font("Courier", Font.CENTER_BASELINE, 20));
		listAlb.setSelectionBackground(new Color(0, 76, 153));
		listAlb.setFixedCellHeight(40);	
		JScrollPane scrollList = new JScrollPane();
		scrollList.setViewportView(listAlb);
		listAlb.setLayoutOrientation(JList.VERTICAL); 
		scrollList.setBounds(20, 125, 1040, 490);
		contentPane.add(scrollList);
		    
		JButton visualizzaTracceAlbum = new JButton("Visualizza Tracce");
		visualizzaTracceAlbum.setForeground(new Color(20,20,20));
		visualizzaTracceAlbum.setFont(new Font("Courier", Font.CENTER_BASELINE,20));
		visualizzaTracceAlbum.setBounds(280, 630, 250, 45);
		contentPane.add(visualizzaTracceAlbum);
			
		JButton indietro = new JButton("Indietro");
		indietro.setForeground(new Color(20,20,20));
		indietro.setFont(new Font("Courier", Font.CENTER_BASELINE,20));
		indietro.setBounds(610, 630, 250, 45);
		contentPane.add(indietro);
		
		listaAlGui.setVisible(true);
			
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
				listaAlGui.dispose();
				clientGui.setVisible(true);
			}
		});
			
		visualizzaTracceAlbum.addMouseListener(new MouseAdapter() 
		{
			public void mouseClicked(MouseEvent e) 
			{
				if(listAlb.getSelectedIndex() != -1)
				{
					listaAlGui.dispose();
					ControllerTraccia controllerTr= new ControllerTraccia();
					@SuppressWarnings("unused")
					ListaTracceDiArtista listtrgui=new ListaTracceDiArtista(controllerTr,listAlbum.get(listAlb.getSelectedIndex()),clientGui,utente);
				}
				else
				{
					JOptionPane.showMessageDialog(visualizzaTracceAlbum, "Scegliere un Album.");
				}
			}
		});
	}
		
		
	public ListaAlbumDiArtista(ControllerAlbum controller, Artista artista,JFrame clientGui,Utente utente, int codice)
	{
		System.out.println("Ti trovi in ListaAlbumDiArtista2");
		
		listaAlGui = new JFrame();
		listaAlGui.setBackground(new Color(20, 20, 20));
		listaAlGui.setTitle("Album");
		listaAlGui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		listaAlGui.setBounds(170, 55, 1080, 720);
		listaAlGui.setResizable(false);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(20, 20, 20));
		listaAlGui.setContentPane(contentPane);
		contentPane.setLayout(null);
			
		JLabel EtichettaAlbum = new JLabel("Album");
		EtichettaAlbum.setForeground(new Color(0,76,153));
		EtichettaAlbum.setFont(new Font("Courier", Font.CENTER_BASELINE, 50));
		EtichettaAlbum.setBounds(450, 25, 250, 45);
		contentPane.add(EtichettaAlbum);
		
		JLabel EtichettaBn = new JLabel("Scegliere un Album: (Titolo-Anno-Produttore)");
		EtichettaBn.setForeground(new Color(255,255,255));
		EtichettaBn.setFont(new Font("Courier", Font.CENTER_BASELINE, 20));
		EtichettaBn.setBounds(20, 75, 700, 45);
		contentPane.add(EtichettaBn);
			
		listAlbum=controller.listaAlbum(artista.getIdArtista());
		DefaultListModel<String> model = new DefaultListModel<String>();
		listAlb = new JList<String>(model);
			
		for(Album varAlb: listAlbum)
		{
			model.addElement(varAlb.getTitolo()+"-"+varAlb.getAnno()+"-"+varAlb.getProduttoreAlbum().getNome());
		}

		listAlb.setBackground(new Color(255, 255, 255));
		listAlb.setFont(new Font("Courier", Font.CENTER_BASELINE, 20));
		listAlb.setSelectionBackground(new Color(0, 76, 153));
		listAlb.setFixedCellHeight(40);
		JScrollPane scrollList = new JScrollPane();
		scrollList.setViewportView(listAlb);
		listAlb.setLayoutOrientation(JList.VERTICAL); 
		scrollList.setBounds(20, 125, 1040, 490);
		contentPane.add(scrollList);
		    
		JButton visualizzaTracceAlbum = new JButton("Visualizza Tracce");
		visualizzaTracceAlbum.setForeground(new Color(20,20,20));
		visualizzaTracceAlbum.setFont(new Font("Courier", Font.CENTER_BASELINE,20));
	    visualizzaTracceAlbum.setBounds(280, 630, 250, 45);
		contentPane.add(visualizzaTracceAlbum);
			
		JButton indietro = new JButton("Indietro");
		indietro.setForeground(new Color(20,20,20));
		indietro.setFont(new Font("Courier", Font.CENTER_BASELINE,20));
		indietro.setBounds(610, 630, 250, 45);
		contentPane.add(indietro);
			
		listaAlGui.setVisible(true);
			
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
				listaAlGui.dispose();
				clientGui.setVisible(true);
			}
		});
			
		visualizzaTracceAlbum.addMouseListener(new MouseAdapter() 
		{
			public void mouseClicked(MouseEvent e) 
			{
				if(listAlb.getSelectedIndex() != -1)
				{
					listaAlGui.dispose();
					ControllerTraccia controllerTr= new ControllerTraccia();
					@SuppressWarnings("unused")
					ListaTracceDiArtista listtrgui=new ListaTracceDiArtista(artista,controllerTr,listAlbum.get(listAlb.getSelectedIndex()),clientGui,utente,1);
				}
				else
				{
					JOptionPane.showMessageDialog(visualizzaTracceAlbum, "Scegliere un Album.");
				}
			}
		});
	}
}