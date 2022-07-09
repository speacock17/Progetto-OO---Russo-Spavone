package GUI;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;

import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import Entita.Utente;
import Entita.Traccia;

import Controller.ControllerTraccia;


public class ListaPreferiti 
{
	private JPanel contentPane;
	private JFrame listaPref;
	private ArrayList<Traccia> listPreferiti = new ArrayList<Traccia>();
	@SuppressWarnings("rawtypes")
	private JList listPre;
		
	public ListaPreferiti(ControllerTraccia controller,JFrame clientGui,Utente utente)
	{
		System.out.println("Ti Trovi in ListaPreferiti");
		
		listaPref = new JFrame();
		listaPref.setBackground(new Color(20, 20, 20));
		listaPref.setTitle("Preferiti");
		listaPref.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		listaPref.setBounds(170, 55, 1080, 720);
		listaPref.setResizable(false);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(20, 20, 20));
		listaPref.setContentPane(contentPane);
		contentPane.setLayout(null);
			
		JLabel EtichettaTraccia = new JLabel("Preferiti");
		EtichettaTraccia.setForeground(new Color(0,76,153));
		EtichettaTraccia.setFont(new Font("Courier", Font.CENTER_BASELINE, 50));
		EtichettaTraccia.setBounds(405, 25, 450, 45);
		contentPane.add(EtichettaTraccia);
		
		JLabel EtichettaBn = new JLabel("Scegliere una Traccia:");
		EtichettaBn.setForeground(new Color(255,255,255));
		EtichettaBn.setFont(new Font("Courier", Font.CENTER_BASELINE, 20));
		EtichettaBn.setBounds(20, 75, 500, 45);
		contentPane.add(EtichettaBn);
		
		JLabel EtichettaBn2 = new JLabel("(Titolo-Durata-Anno-Genere-Versione-Qualita' Audio-Tipo-Accesso-Percentuale Produttore)");
		EtichettaBn2.setForeground(new Color(255,255,255));
		EtichettaBn2.setFont(new Font("Courier", Font.CENTER_BASELINE, 20));
		EtichettaBn2.setBounds(20, 105, 1080, 45);
		contentPane.add(EtichettaBn2);
			
		listPreferiti=controller.listaPreferiti(utente.getIdUtente());
		DefaultListModel<String> model = new DefaultListModel<String>();
		listPre = new JList<String>(model);
			
		for(Traccia varTr: listPreferiti)
		{
			model.addElement(varTr.getTitolo()+"-"+varTr.getDurata()+"-"+varTr.getAnno()+"-"+varTr.getGenere()+"-"+varTr.getVersione()+"-"+varTr.getQualitaAudio()+"-"+varTr.getTipo()+"-"+varTr.getAccesso()+"-"+varTr.getPercentualeProd());
		}

		listPre.setBackground(new Color(255, 255, 255));
		listPre.setFont(new Font("Courier", Font.CENTER_BASELINE, 20));
		listPre.setSelectionBackground(new Color(0, 76, 153));
		listPre.setFixedCellHeight(40);
		JScrollPane scrollList = new JScrollPane();
		scrollList.setViewportView(listPre);
		listPre.setLayoutOrientation(JList.VERTICAL); 
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
			
		listaPref.setVisible(true);
			
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
				listaPref.dispose();
				clientGui.setVisible(true);
			}
		});
			
		riproduciTraccia.addMouseListener(new MouseAdapter() 
		{
			public void mouseClicked(MouseEvent e) 
			{
				if(listPre.getSelectedIndex() != -1)
				{
					Traccia tra = new Traccia();
					tra=listPreferiti.get(listPre.getSelectedIndex());
							
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
	}
}