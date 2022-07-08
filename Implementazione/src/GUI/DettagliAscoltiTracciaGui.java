package GUI;

import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
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

import Controller.ControllerTraccia;

import Entità.Album;
import Entità.Artista;
import Entità.Utente;
import Entità.Traccia;

public class DettagliAscoltiTracciaGui 
{
	private JPanel contentPane;
	private JFrame listaTrGui;
	private ArrayList<Traccia> listTraccia = new ArrayList<Traccia>();
	@SuppressWarnings("rawtypes")
	private JList listTrac;
		
	public DettagliAscoltiTracciaGui(Artista artista,Traccia traccia,ControllerTraccia controller, Album album,JFrame clientGui,Utente utente)
	{
		System.out.println("Ti trovi in DettagliAscoltiTracciaGui");
			
		listaTrGui = new JFrame();
		listaTrGui.setBackground(new Color(20, 20, 20));
		listaTrGui.setTitle("Dettagli Traccia");
		listaTrGui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		listaTrGui.setBounds(170, 55, 1080, 720);
		listaTrGui.setResizable(false);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(20, 20, 20));
		listaTrGui.setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel EtichettaDettagli = new JLabel("Dettagli");
		EtichettaDettagli.setForeground(new Color(0,76,153));
		EtichettaDettagli.setFont(new Font("Courier", Font.CENTER_BASELINE, 50));
		EtichettaDettagli.setBounds(420, 25, 250, 55);
		contentPane.add(EtichettaDettagli);
		
		JLabel EtichettaBn = new JLabel("Qui sono riportati i dettagli della traccia selezionata:");
		EtichettaBn.setForeground(new Color(255,255,255));
		EtichettaBn.setFont(new Font("Courier", Font.CENTER_BASELINE, 20));
		EtichettaBn.setBounds(20, 75, 1000, 45);
		contentPane.add(EtichettaBn);
		
		JLabel EtichettaBn2 = new JLabel("(Nome Utente-Titolo-Versione-Numero Ascolti)");
		EtichettaBn2.setForeground(new Color(255,255,255));
		EtichettaBn2.setFont(new Font("Courier", Font.CENTER_BASELINE, 20));
		EtichettaBn2.setBounds(20, 105, 1080, 45);
		contentPane.add(EtichettaBn2);
			
		listTraccia=controller.listaDettAscolti(utente.getNomeUtente(),utente.getPassword(),traccia.getIdTraccia(), artista.getIdArtista());
		DefaultListModel<String> model = new DefaultListModel<String>();
		listTrac = new JList<String>(model);
			
		for(Traccia varTr: listTraccia)
		{
			model.addElement(varTr.getNomeUt()+","+varTr.getTitolo()+","+varTr.getVersione()+","+varTr.getAsc());
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
		indietro.setBounds(420, 630, 250, 45);
		contentPane.add(indietro);
		
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
	}
}