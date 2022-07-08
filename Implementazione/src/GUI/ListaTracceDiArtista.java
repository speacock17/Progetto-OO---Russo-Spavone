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

import Entità.Album;
import Entità.Artista;
import Entità.Utente;
import Entità.Traccia;

import Controller.ControllerTraccia;


public class ListaTracceDiArtista 
{
	private JPanel contentPane;
	private JFrame listaTrGui;
	private ArrayList<Traccia> listTraccia = new ArrayList<Traccia>();
	@SuppressWarnings("rawtypes")
	private JList listTrac;
		
	public ListaTracceDiArtista(ControllerTraccia controller, Album album,JFrame clientGui,Utente utente)
	{
		System.out.println("Ti trovi in ListaTracceDiArtista");
		
		listaTrGui = new JFrame();
		listaTrGui.setBackground(new Color(20, 20, 20));
		listaTrGui.setTitle("Tracce");
		listaTrGui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		listaTrGui.setBounds(170, 55, 1080, 720);
		listaTrGui.setResizable(false);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(20, 20, 20));
		listaTrGui.setContentPane(contentPane);
		contentPane.setLayout(null);
			
		JLabel EtichettaTraccia = new JLabel("Traccia");
		EtichettaTraccia.setForeground(new Color(0,76,153));
		EtichettaTraccia.setFont(new Font("Courier", Font.CENTER_BASELINE, 50));
		EtichettaTraccia.setBounds(450, 25, 250, 45);
		contentPane.add(EtichettaTraccia);
		
		JLabel EtichettaBn = new JLabel("Scegliere una Traccia:");
		EtichettaBn.setForeground(new Color(255,255,255));
		EtichettaBn.setFont(new Font("Courier", Font.CENTER_BASELINE, 20));
		EtichettaBn.setBounds(20, 75, 500, 45);
		contentPane.add(EtichettaBn);
		
		JLabel EtichettaBn2 = new JLabel("(Titolo-Durata-Anno-Genere-Versione-Qualità Audio-Tipo-Accesso-Percentuale Produttore)");
		EtichettaBn2.setForeground(new Color(255,255,255));
		EtichettaBn2.setFont(new Font("Courier", Font.CENTER_BASELINE, 20));
		EtichettaBn2.setBounds(20, 105, 1080, 45);
		contentPane.add(EtichettaBn2);
			
		listTraccia=controller.listaTraccia(album.getIdAlbum());
		DefaultListModel<String> model = new DefaultListModel<String>();
		listTrac = new JList<String>(model);
			
		for(Traccia varTr: listTraccia)
		{
			model.addElement(varTr.getTitolo()+"-"+varTr.getDurata()+"-"+varTr.getAnno()+"-"+varTr.getGenere()+"-"+varTr.getVersione()+"-"+varTr.getQualitàAudio()+"-"+varTr.getTipo()+"-"+varTr.getAccesso()+"-"+varTr.getPercentualeProd());
		}

		listTrac.setBackground(new Color(255, 255, 255));
		listTrac.setFont(new Font("Courier", Font.CENTER_BASELINE, 20));
		listTrac.setSelectionBackground(new Color(0, 76, 153));
		listTrac.setFixedCellHeight(40);
		JScrollPane scrollList = new JScrollPane();
		scrollList.setViewportView(listTrac);
		listTrac.setLayoutOrientation(JList.VERTICAL); 
		scrollList.setBounds(20, 145, 1040, 470);
		contentPane.add(scrollList);
		    
		JButton riproduciTraccia = new JButton("Riproduci");
		riproduciTraccia.setForeground(new Color(20,20,20));
		riproduciTraccia.setFont(new Font("Courier", Font.CENTER_BASELINE,20));
		riproduciTraccia.setBounds(40, 630, 250, 45);
		contentPane.add(riproduciTraccia);
			
		JButton indietro = new JButton("Indietro");
		indietro.setForeground(new Color(20,20,20));
		indietro.setFont(new Font("Courier", Font.CENTER_BASELINE,20));
		indietro.setBounds(370, 630, 250, 45);
		contentPane.add(indietro);
			
		JButton preferiti = new JButton("Aggiungi ai Brani Preferiti");
		preferiti.setForeground(new Color(20,20,20));
		preferiti.setFont(new Font("Courier", Font.CENTER_BASELINE,20));
		preferiti.setBounds(700, 630, 350, 45);
		contentPane.add(preferiti);
			
		listaTrGui.setVisible(true);
			
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
				listaTrGui.dispose();
				clientGui.setVisible(true);
			}
		});
			
		riproduciTraccia.addMouseListener(new MouseAdapter() 
		{
			public void mouseClicked(MouseEvent e) 
			{
				if(listTrac.getSelectedIndex() != -1)
				{
					Traccia tra = new Traccia();
					tra=listTraccia.get(listTrac.getSelectedIndex());
							
					if((utente.getPiano().equals("Standard") && !tra.getAccesso().equals("Standard")) 
					|| ((utente.getPiano().equals("Studenti") && !tra.getAccesso().equals("Standard")) 
					&& (utente.getPiano().equals("Studenti") && !tra.getAccesso().equals("Standard"))) 
					|| ((utente.getPiano().equals("Gold") && !tra.getAccesso().equals("Standard")) 
					&& (utente.getPiano().equals("Gold") && !tra.getAccesso().equals("Studenti")) 
					&& (utente.getPiano().equals("Gold") && !tra.getAccesso().equals("Gold"))))
					{
						JOptionPane.showMessageDialog(riproduciTraccia, "Brano non disponibile, passa ad un abbonamento superiore.");
					}
					else
					{
						controller.Riproduzione(utente.getNomeUtente(),tra.getIdTraccia());
						JOptionPane.showMessageDialog(riproduciTraccia, "Traccia riprodotta con successo.");
					}
				}
				else
				{
					JOptionPane.showMessageDialog(riproduciTraccia, "Scegliere una Traccia.");
				}
			}
		});
			
		preferiti.addMouseListener(new MouseAdapter() 
		{
			public void mouseClicked(MouseEvent e) 
			{
				if(listTrac.getSelectedIndex() != -1)
				{
					Traccia tra = new Traccia();
					tra=listTraccia.get(listTrac.getSelectedIndex());
							
					if((utente.getPiano().equals("Standard") && !tra.getAccesso().equals("Standard")) 
					|| ((utente.getPiano().equals("Studenti") && !tra.getAccesso().equals("Standard")) 
					&& (utente.getPiano().equals("Studenti") && !tra.getAccesso().equals("Standard"))) 
					|| ((utente.getPiano().equals("Gold") && !tra.getAccesso().equals("Standard")) 
					&& (utente.getPiano().equals("Gold") && !tra.getAccesso().equals("Studenti")) 
					&& (utente.getPiano().equals("Gold") && !tra.getAccesso().equals("Gold"))))
					{
						JOptionPane.showMessageDialog(riproduciTraccia, "Brano non disponibile, passa ad un abbonamento superiore.");
					}
					else
					{
						controller.AggiungiPreferiti(utente.getNomeUtente(),utente.getPassword(),tra.getIdTraccia());
						JOptionPane.showMessageDialog(riproduciTraccia, "Traccia aggiunta ai preferiti con successo.");
					}
				}
				else
				{
					JOptionPane.showMessageDialog(riproduciTraccia, "Scegliere una Traccia.");
				}
			}
		});
	}
		
	public ListaTracceDiArtista(Artista artista,ControllerTraccia controller, Album album,JFrame clientGui,Utente utente, int codice)
	{
		System.out.println("Ti trovi in ListaTracceDiArtista");
		
		listaTrGui = new JFrame();
		listaTrGui.setBackground(new Color(20, 20, 20));
		listaTrGui.setTitle("Tracce");
		listaTrGui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		listaTrGui.setBounds(170, 55, 1080, 720);
		listaTrGui.setResizable(false);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(20, 20, 20));
		listaTrGui.setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel EtichettaTraccia = new JLabel("Traccia");
		EtichettaTraccia.setForeground(new Color(0,76,153));
		EtichettaTraccia.setFont(new Font("Courier", Font.CENTER_BASELINE, 50));
		EtichettaTraccia.setBounds(450, 25, 250, 45);
		contentPane.add(EtichettaTraccia);
		
		JLabel EtichettaBn = new JLabel("Scegliere una Traccia:");
		EtichettaBn.setForeground(new Color(255,255,255));
		EtichettaBn.setFont(new Font("Courier", Font.CENTER_BASELINE, 20));
		EtichettaBn.setBounds(20, 75, 500, 45);
		contentPane.add(EtichettaBn);
		
		JLabel EtichettaBn2 = new JLabel("(Titolo-Durata-Anno-Genere-Versione-Qualità Audio-Tipo-Accesso-Percentuale Produttore)");
		EtichettaBn2.setForeground(new Color(255,255,255));
		EtichettaBn2.setFont(new Font("Courier", Font.CENTER_BASELINE, 20));
		EtichettaBn2.setBounds(20, 105, 1080, 45);
		contentPane.add(EtichettaBn2);
		
		listTraccia=controller.listaTraccia(album.getIdAlbum());
		DefaultListModel<String> model = new DefaultListModel<String>();
		listTrac = new JList<String>(model);
		
		for(Traccia varTr: listTraccia)
		{
			model.addElement(varTr.getTitolo()+"-"+varTr.getDurata()+"-"+varTr.getAnno()+"-"+varTr.getGenere()+"-"+varTr.getVersione()+"-"+varTr.getQualitàAudio()+"-"+varTr.getTipo()+"-"+varTr.getAccesso()+"-"+varTr.getPercentualeProd());
		}

		listTrac.setBackground(new Color(255, 255, 255));
		listTrac.setFont(new Font("Courier", Font.CENTER_BASELINE, 20));
		listTrac.setSelectionBackground(new Color(0, 76, 153));
		listTrac.setFixedCellHeight(40);
		JScrollPane scrollList = new JScrollPane();
		scrollList.setViewportView(listTrac);
	    listTrac.setLayoutOrientation(JList.VERTICAL); 
	    scrollList.setBounds(20, 145, 1040, 470);
	    contentPane.add(scrollList);
	 
		JButton indietro = new JButton("Indietro");
		indietro.setForeground(new Color(20,20,20));
		indietro.setFont(new Font("Courier", Font.CENTER_BASELINE,20));
		indietro.setBounds(610, 630, 250, 45);
		contentPane.add(indietro);
		
		JButton visualizzaDettagli = new JButton("Visualizza dettagli");
		visualizzaDettagli.setForeground(new Color(20,20,20));
		visualizzaDettagli.setFont(new Font("Courier", Font.CENTER_BASELINE,20));
		visualizzaDettagli.setBounds(280, 630, 250, 45);
		contentPane.add(visualizzaDettagli);
		
		listaTrGui.setVisible(true);
		
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
				listaTrGui.dispose();
				clientGui.setVisible(true);
			}
		});
		
		visualizzaDettagli.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				
			}
		});
		visualizzaDettagli.addMouseListener(new MouseAdapter() 
		{
			public void mouseClicked(MouseEvent e) 
			{
				listaTrGui.dispose();
				@SuppressWarnings("unused")
				DettagliAscoltiTracciaGui dettasc = new DettagliAscoltiTracciaGui(artista, listTraccia.get(listTrac.getSelectedIndex()), controller, album, clientGui, utente);
			}
		});
	}
}