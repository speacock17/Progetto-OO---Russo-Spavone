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

import Entità.Album;
import Entità.Artista;
import Entità.Utente;


public class SelezioneAlbumGui 
{
	private JPanel contentPane;
	private JFrame listaAlbGui;
    private ArrayList<Album> listAlbum = new ArrayList<Album>();
    @SuppressWarnings("rawtypes")
	private JList listAlb;

	public SelezioneAlbumGui(JFrame adminGui, ControllerAlbum controller, Utente utente, Artista artista)
	{
		System.out.println("ti trovi in lista artista");
		
		listaAlbGui = new JFrame();
		listaAlbGui.setBackground(new Color(20, 20, 20));
		listaAlbGui.setTitle("Album");
		listaAlbGui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		listaAlbGui.setBounds(170, 55, 1080, 720);
		listaAlbGui.setResizable(false);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(20, 20, 20));
		listaAlbGui.setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel EtichettaArtista = new JLabel("Album");
		EtichettaArtista.setForeground(new Color(0,76,153));
		EtichettaArtista.setFont(new Font("Courier", Font.CENTER_BASELINE, 50));
		EtichettaArtista.setBounds(450, 25, 250, 45);
		contentPane.add(EtichettaArtista);
		
		JLabel EtichettaBn = new JLabel("Scegliere un'Album: (Titolo-Anno-Produttore)");
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
	    
	    JButton avanza = new JButton("Avanti");
	    avanza.setForeground(new Color(20,20,20));
	    avanza.setFont(new Font("Courier", Font.CENTER_BASELINE,20));
	    avanza.setBounds(280, 630, 180, 45);
		contentPane.add(avanza);
		
		JButton indietro = new JButton("Indietro");
		indietro.setForeground(new Color(20,20,20));
		indietro.setFont(new Font("Courier", Font.CENTER_BASELINE,20));
		indietro.setBounds(610, 630, 180, 45);
		contentPane.add(indietro);
	    
		listaAlbGui.setVisible(true);
		
		avanza.addMouseListener(new MouseAdapter() 
		{
			public void mouseClicked(MouseEvent e) 
			{
				if(listAlb.getSelectedIndex() != -1)
				{
					listaAlbGui.dispose();
					ControllerTraccia controllerTr= new ControllerTraccia();
					@SuppressWarnings("unused")
					SelezioneTipoTracciaGui seleztipogui= new SelezioneTipoTracciaGui(adminGui,controllerTr,utente,artista.getIdArtista(),listAlbum.get(listAlb.getSelectedIndex()));
				}
				else
				{
					JOptionPane.showMessageDialog(avanza, "Scegliere un Album.");
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
				listaAlbGui.dispose();
				adminGui.setVisible(true);
			}
		});
	}
}