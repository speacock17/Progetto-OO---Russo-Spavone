package GUI;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JButton;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;

import Entità.Utente;
import Entità.Traccia;

import Controller.ControllerTraccia;

public class ListaFeaturing{
	
	private JPanel contentPane;
	private JFrame listaTrGui;
	private ArrayList<Traccia> listTraccia = new ArrayList<Traccia>();
	@SuppressWarnings("rawtypes")
	private JList listTrac;
	
	public ListaFeaturing(ControllerTraccia controller,JFrame adminGui,Utente utente) 
	{
		System.out.println("Ti trovi in listaFeaturing");
		
		listaTrGui = new JFrame();
		listaTrGui.setBackground(new Color(20, 20, 20));
		listaTrGui.setTitle("Featuring");
		listaTrGui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		listaTrGui.setBounds(170, 55, 1080, 720);
		listaTrGui.setResizable(false);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(20, 20, 20));
		listaTrGui.setContentPane(contentPane);
		contentPane.setLayout(null);
	
		JLabel EtichettaTraccia = new JLabel("Featuring");
		EtichettaTraccia.setForeground(new Color(0,76,153));
		EtichettaTraccia.setFont(new Font("Courier", Font.CENTER_BASELINE, 50));
		EtichettaTraccia.setBounds(405, 25, 350, 55);
		contentPane.add(EtichettaTraccia);
		
		JLabel EtichettaBn = new JLabel("Lista Featuring:");
		EtichettaBn.setForeground(new Color(255,255,255));
		EtichettaBn.setFont(new Font("Courier", Font.CENTER_BASELINE, 20));
		EtichettaBn.setBounds(20, 75, 500, 45);
		contentPane.add(EtichettaBn);
	
		JLabel EtichettaBn2 = new JLabel("(Titolo-Artista Ospite)");
		EtichettaBn2.setForeground(new Color(255,255,255));
		EtichettaBn2.setFont(new Font("Courier", Font.CENTER_BASELINE, 20));
		EtichettaBn2.setBounds(20, 105, 1080, 45);
		contentPane.add(EtichettaBn2);
	
		listTraccia=controller.listaFeaturing();
		DefaultListModel<String> model = new DefaultListModel<String>();
		listTrac = new JList<String>(model);
	
		for(Traccia varTr: listTraccia)
		{
			model.addElement(varTr.getTitolo()+"-"+varTr.getFeat());
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
				adminGui.setVisible(true);
			}
		});
	}
}