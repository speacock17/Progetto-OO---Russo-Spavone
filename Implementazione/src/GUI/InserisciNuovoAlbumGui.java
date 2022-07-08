package GUI;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.Font;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import Controller.ControllerAlbum;

import Entità.Artista;
import Entità.Produttore;
import Entità.Utente;


@SuppressWarnings("serial")
public class InserisciNuovoAlbumGui extends JFrame
{
	private JPanel contentPane;
	private JTextField inserimentoNomeAlbum;
	private JTextField inserimentoDataAlbum;
	private JFrame inserimentoAlbumGui;
	
	public InserisciNuovoAlbumGui(ControllerAlbum controller,Produttore produttore,JFrame AdminGui, Utente utente, Artista artista) 
	{
		AdminGui.setVisible(false);
		inserimentoAlbumGui=this;
		inserimentoAlbumGui.setVisible(true);
		inserimentoAlbumGui.setBackground(new Color(20, 20, 20));
		inserimentoAlbumGui.setTitle("Inserimento Album");
		inserimentoAlbumGui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		inserimentoAlbumGui.setBounds(170, 55, 1080, 720);
		inserimentoAlbumGui.setResizable(false);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(20, 20, 20));
		inserimentoAlbumGui.setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel EtichettaBn = new JLabel("Inserimento Album");
		EtichettaBn.setForeground(new Color(0,76,153));
		EtichettaBn.setFont(new Font("Courier", Font.CENTER_BASELINE, 50));
		EtichettaBn.setBounds(290, 50, 650, 45);
		contentPane.add(EtichettaBn);
		
		JLabel EtichettaNome = new JLabel("Nome Album:");
		EtichettaNome.setForeground(new Color(255,255,255));
		EtichettaNome.setFont(new Font("Courier", Font.CENTER_BASELINE, 20));
		EtichettaNome.setBounds(295, 120, 350, 45);
		contentPane.add(EtichettaNome);
		
		inserimentoNomeAlbum = new JTextField();
		inserimentoNomeAlbum.setFont(new Font("Courier", Font.CENTER_BASELINE,20));
		inserimentoNomeAlbum.setBounds(525, 120, 250, 45);
		contentPane.add(inserimentoNomeAlbum);

		JLabel EtichettaData = new JLabel("Anno Pubblicazione:");
		EtichettaData.setForeground(new Color(255,255,255));
		EtichettaData.setFont(new Font("Courier", Font.CENTER_BASELINE, 20));
		EtichettaData.setBounds(295, 170, 350, 45);
		contentPane.add(EtichettaData);
		
		inserimentoDataAlbum = new JTextField();
		inserimentoDataAlbum.setFont(new Font("Courier", Font.CENTER_BASELINE,20));
		inserimentoDataAlbum.setBounds(525,170,250,45);
		contentPane.add(inserimentoDataAlbum);
	
		JButton avanzaInserimento = new JButton("Inserimento");
		avanzaInserimento.setForeground(new Color(20,20,20));
		avanzaInserimento.setFont(new Font("Courier", Font.CENTER_BASELINE,20));
		avanzaInserimento.setBounds(340, 230, 180, 45);
		contentPane.add(avanzaInserimento);
		
		JButton Indietro = new JButton("Indietro");
		Indietro.setForeground(new Color(20,20,20));
		Indietro.setFont(new Font("Courier", Font.CENTER_BASELINE,20));
		Indietro.setBounds(540, 230, 180, 45);
		contentPane.add(Indietro);
		
		avanzaInserimento.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				
			}
		});
		avanzaInserimento.addMouseListener(new MouseAdapter() 
		{
			public void mouseClicked(MouseEvent e) 
			{
				int data = Integer.parseInt(inserimentoDataAlbum.getText());
				if(inserimentoNomeAlbum.getText().length()<=0 || inserimentoNomeAlbum.getText().length()>40)
				{
					JOptionPane.showMessageDialog(avanzaInserimento,"Errore nell'inserimento del titolo.");
				}
				else if(data<=0)
				{
					JOptionPane.showMessageDialog(avanzaInserimento,"Errore nell'inserimento dell'anno.");
				}
				else
				{
					controller.InserisciAlbum(utente.getNomeUtente(), utente.getPassword(), artista.getIdArtista(),inserimentoNomeAlbum.getText(),produttore.getNome(),data);
					JOptionPane.showMessageDialog(avanzaInserimento,"Inserimento avvenuto con successo.");
					inserimentoAlbumGui.dispose();
					AdminGui.setVisible(true);
				}
			}
		});
		
		Indietro.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				
			}
		});
		Indietro.addMouseListener(new MouseAdapter() 
		{
			public void mouseClicked(MouseEvent e) 
			{
				inserimentoAlbumGui.dispose();
				AdminGui.setVisible(true);
			}
		});
	}
}