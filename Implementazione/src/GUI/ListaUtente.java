package GUI;

import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JButton;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;

import Controller.ControllerRiproduzione;
import Controller.ControllerUtente;

import Entità.Utente;


public class ListaUtente 
{
	private JPanel contentPane;
	private JFrame listaUtGui;
	private ArrayList<Utente> listUtente = new ArrayList<Utente>();
	@SuppressWarnings("rawtypes")
	private JList listUt;
		
	public ListaUtente(ControllerUtente controller,JFrame adminGui,Utente utente)
	{
		System.out.println("Ti trovi in ListaUtente");
		
		listaUtGui = new JFrame();
		listaUtGui.setBackground(new Color(20, 20, 20));
		listaUtGui.setTitle("Utente");
		listaUtGui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		listaUtGui.setBounds(170, 55, 1080, 720);
		listaUtGui.setResizable(false);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(20, 20, 20));
		listaUtGui.setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel EtichettaUtente = new JLabel("Utente");
		EtichettaUtente.setForeground(new Color(0,76,153));
		EtichettaUtente.setFont(new Font("Courier", Font.CENTER_BASELINE, 50));
		EtichettaUtente.setBounds(450, 25, 250, 45);
		contentPane.add(EtichettaUtente);
		
		JLabel EtichettaBn = new JLabel("Scegliere un'Utente:");
		EtichettaBn.setForeground(new Color(255,255,255));
		EtichettaBn.setFont(new Font("Courier", Font.CENTER_BASELINE, 20));
		EtichettaBn.setBounds(20, 75, 500, 45);
		contentPane.add(EtichettaBn);
		
		JLabel EtichettaBn2 = new JLabel("(Nome Utente-Nome-Cognome-Mail-Nazione-Piano)");
		EtichettaBn2.setForeground(new Color(255,255,255));
		EtichettaBn2.setFont(new Font("Courier", Font.CENTER_BASELINE, 20));
		EtichettaBn2.setBounds(20, 105, 900, 45);
		contentPane.add(EtichettaBn2);
			
		listUtente=controller.listaUtente();
		DefaultListModel<String> model = new DefaultListModel<String>();
		listUt = new JList<String>(model);
			
		for(Utente varTr: listUtente)
		{
			model.addElement(varTr.getNomeUtente()+"-"+varTr.getNome()+"-"+varTr.getCognome()+"-"+varTr.getMail()+"-"+varTr.getNazione()+"-"+varTr.getPiano());
		}

		listUt.setBackground(new Color(255, 255, 255));
		listUt.setFont(new Font("Courier", Font.CENTER_BASELINE, 20));
		listUt.setSelectionBackground(new Color(0, 76, 153));
		listUt.setFixedCellHeight(40);
		JScrollPane scrollList = new JScrollPane();
		scrollList.setViewportView(listUt);
		listUt.setLayoutOrientation(JList.VERTICAL); 
		scrollList.setBounds(20, 145, 1040, 470);
		contentPane.add(scrollList);
		    
		JButton cambiaPianoUtente = new JButton("Cambia Piano Utente");
		cambiaPianoUtente.setForeground(new Color(20,20,20));
		cambiaPianoUtente.setFont(new Font("Courier", Font.CENTER_BASELINE,20));
		cambiaPianoUtente.setBounds(80, 625, 250, 45);
		contentPane.add(cambiaPianoUtente);
			
		JButton visualizzaFascia = new JButton("Visualizza Fascia");
		visualizzaFascia.setForeground(new Color(20,20,20));
		visualizzaFascia.setFont(new Font("Courier", Font.CENTER_BASELINE,20));
		visualizzaFascia.setBounds(410, 625, 250, 45);
		contentPane.add(visualizzaFascia);
			
		JButton indietro = new JButton("Indietro");
		indietro.setForeground(new Color(20,20,20));
		indietro.setFont(new Font("Courier", Font.CENTER_BASELINE,20));
		indietro.setBounds(740, 625, 250, 45);
		contentPane.add(indietro);
			
		listaUtGui.setVisible(true);
			
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
				listaUtGui.dispose();
				adminGui.setVisible(true);
			}
		});
			
		cambiaPianoUtente.addMouseListener(new MouseAdapter() 
		{
			public void mouseClicked(MouseEvent e) 
			{
				if(listUt.getSelectedIndex() != -1)
				{
					listaUtGui.dispose();
					@SuppressWarnings("unused")
					ModificaPianoInterface mpint=new ModificaPianoInterface(adminGui, controller, utente,listUtente.get(listUt.getSelectedIndex()));
				}
				else
				{
					JOptionPane.showMessageDialog(cambiaPianoUtente, "Scegliere un Utente.");
				}
			}
		});
			
		visualizzaFascia.addMouseListener(new MouseAdapter() 
		{
			public void mouseClicked(MouseEvent e) 
			{
				if(listUt.getSelectedIndex() != -1)
				{
					listaUtGui.dispose();
					ControllerRiproduzione controllerRi= new ControllerRiproduzione();
				    @SuppressWarnings("unused")
					FasciaUtenteGui fascutgui= new FasciaUtenteGui(adminGui,controllerRi,utente,listUtente.get(listUt.getSelectedIndex()));
				}
				else
				{
					JOptionPane.showMessageDialog(cambiaPianoUtente, "Scegliere un Utente.");
				}
			}
		});
	}	
}