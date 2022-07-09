package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import Controller.ControllerRiproduzione;

import Entita.Riproduzione;
import Entita.Utente;


public class FasciaUtenteGui 
{
	private JPanel contentPane;
	private JFrame listaRiGui;
    private ArrayList<Riproduzione> listRiproduzione = new ArrayList<Riproduzione>();
    @SuppressWarnings("rawtypes")
	private JList listRiprod;
    
    public FasciaUtenteGui(JFrame adminGui, ControllerRiproduzione controller, Utente utenteAdmin, Utente utenteClient)
	{
    	System.out.println("Ti trovi in FasciaUtenteGui");
		
    	listaRiGui = new JFrame();
		listaRiGui.setVisible(true);
		listaRiGui.setBackground(new Color(20, 20, 20));
		listaRiGui.setTitle("Fascia Oraria");
		listaRiGui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		listaRiGui.setBounds(170, 55, 1080, 720);
		listaRiGui.setResizable(false);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(20, 20, 20));
		listaRiGui.setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel EtichettaFascia = new JLabel("Dettagli Ascolti");
		EtichettaFascia.setForeground(new Color(0,76,153));
		EtichettaFascia.setFont(new Font("Courier", Font.CENTER_BASELINE, 50));
		EtichettaFascia.setBounds(300, 25, 650, 55);
		contentPane.add(EtichettaFascia);
		
		JLabel EtichettaBn = new JLabel("Qui sono riportati gli ascolti effettuati dagli utenti divisi in Fasce Orarie");
		EtichettaBn.setForeground(new Color(255,255,255));
		EtichettaBn.setFont(new Font("Courier", Font.CENTER_BASELINE, 20));
		EtichettaBn.setBounds(20, 75, 1000, 45);
		contentPane.add(EtichettaBn);
		
		JLabel EtichettaBn2 = new JLabel("(Fascia Oraria-Numero Ascolti)");
		EtichettaBn2.setForeground(new Color(255,255,255));
		EtichettaBn2.setFont(new Font("Courier", Font.CENTER_BASELINE, 20));
		EtichettaBn2.setBounds(20, 105, 900, 45);
		contentPane.add(EtichettaBn2);
		
		listRiproduzione=controller.listaDettFascia(utenteAdmin.getNomeUtente(),utenteAdmin.getPassword(),utenteClient.getNomeUtente());
		DefaultListModel<String> model = new DefaultListModel<String>();
		listRiprod = new JList<String>(model);
		
		for(Riproduzione varArt: listRiproduzione)
		{
			model.addElement(varArt.getFasciaOraria()+"-"+varArt.getNumRiprod());
		}

		listRiprod.setBackground(new Color(255, 255, 255));
		listRiprod.setFont(new Font("Courier", Font.CENTER_BASELINE, 20));
		listRiprod.setSelectionBackground(new Color(0, 76, 153));
		listRiprod.setFixedCellHeight(40);		
		JScrollPane scrollList = new JScrollPane();
	    scrollList.setViewportView(listRiprod);
	    listRiprod.setLayoutOrientation(JList.VERTICAL); 
	    scrollList.setBounds(395, 155, 300, 150);
	    contentPane.add(scrollList);
	    
		JButton indietro = new JButton("Indietro");
		indietro.setForeground(Color.BLACK);
		indietro.setFont(new Font("Courier", Font.CENTER_BASELINE,20));
		indietro.setBounds(420, 345, 250, 45);
		contentPane.add(indietro);
	    
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
				listaRiGui.dispose();
				adminGui.setVisible(true);
			}
		});
	}
}