package GUI;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;

import Controller.ControllerTraccia;

import Entita.Album;
import Entita.Traccia;
import Entita.Utente;


@SuppressWarnings("serial")
public class InserisciNuovaTracciaGui extends JFrame
{
	private JPanel contentPane;
	private JTextField inserimentoNomeTraccia;
	private JTextField inserimentoDurataTraccia;
	private JTextField inserimentoGenereTraccia;
	private JTextField inserimentoQualitaTraccia;
	private JTextField inserimentoTipoTraccia;
	private JTextField inserimentoPercentualeProd;
	private JFrame inserimentoNuovaTraccia;
	
	public InserisciNuovaTracciaGui(JFrame AdminGui, ControllerTraccia controller, Utente utente, int codiceArtista,Album album)
	{
		AdminGui.setVisible(false);
		inserimentoNuovaTraccia=this;
		inserimentoNuovaTraccia.setVisible(true);
		
		inserimentoNuovaTraccia.setBackground(new Color(20, 20, 20));
		inserimentoNuovaTraccia.setTitle("Inserimento Traccia");
		inserimentoNuovaTraccia.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		inserimentoNuovaTraccia.setBounds(170, 55, 1080, 720);
		inserimentoNuovaTraccia.setResizable(false);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(20, 20, 20));
		inserimentoNuovaTraccia.setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel Etichetta = new JLabel("Inserimento Traccia");
		Etichetta.setForeground(new Color(0,76,153));
		Etichetta.setFont(new Font("Courier", Font.CENTER_BASELINE, 50));
		Etichetta.setBounds(260, 25, 750, 45);
		contentPane.add(Etichetta);
		
		JLabel EtichettaNome = new JLabel("Nome Traccia:");
		EtichettaNome.setForeground(new Color(255,255,255));
		EtichettaNome.setFont(new Font("Courier", Font.CENTER_BASELINE, 20));
		EtichettaNome.setBounds(300, 85, 350, 45);
		contentPane.add(EtichettaNome);
		
		inserimentoNomeTraccia = new JTextField();
		inserimentoNomeTraccia.setFont(new Font("Courier", Font.CENTER_BASELINE,20));
		inserimentoNomeTraccia.setBounds(470, 85, 250, 45);
		contentPane.add(inserimentoNomeTraccia);
		
		JLabel EtichettaDurata = new JLabel("Durata:");
		EtichettaDurata.setForeground(new Color(255,255,255));
		EtichettaDurata.setFont(new Font("Courier", Font.CENTER_BASELINE, 20));
		EtichettaDurata.setBounds(300, 135, 350, 45);
		contentPane.add(EtichettaDurata);
		
		inserimentoDurataTraccia = new JTextField();
		inserimentoDurataTraccia.setFont(new Font("Courier", Font.CENTER_BASELINE,20));
		inserimentoDurataTraccia.setBounds(470, 135, 250, 45);
		contentPane.add(inserimentoDurataTraccia);
		
		JLabel EtichettaGenere = new JLabel("Genere:");
		EtichettaGenere.setForeground(new Color(255,255,255));
		EtichettaGenere.setFont(new Font("Courier", Font.CENTER_BASELINE, 20));
		EtichettaGenere.setBounds(300, 185, 350, 45);
		contentPane.add(EtichettaGenere);
		
		inserimentoGenereTraccia = new JTextField();
		inserimentoGenereTraccia.setFont(new Font("Courier", Font.CENTER_BASELINE,20));
		inserimentoGenereTraccia.setBounds(470, 185, 250, 45);
		contentPane.add(inserimentoGenereTraccia);
		
		JLabel EtichettaQualita = new JLabel("Qualita':");
		EtichettaQualita.setForeground(new Color(255,255,255));
		EtichettaQualita.setFont(new Font("Courier", Font.CENTER_BASELINE, 20));
		EtichettaQualita.setBounds(300, 235, 350, 45);
		contentPane.add(EtichettaQualita);
		
		inserimentoQualitaTraccia = new JTextField();
		inserimentoQualitaTraccia.setFont(new Font("Courier", Font.CENTER_BASELINE,20));
		inserimentoQualitaTraccia.setBounds(470, 235, 250, 45);
		contentPane.add(inserimentoQualitaTraccia);
		
		inserimentoTipoTraccia = new JTextField("Original");
		
		JLabel EtichettaAccesso = new JLabel("Accesso:");
		EtichettaAccesso.setFont(new Font("Courier", Font.CENTER_BASELINE,20));
		EtichettaAccesso.setForeground(new Color(255,255,255));
		EtichettaAccesso.setBounds(300, 285, 150, 45);
		contentPane.add(EtichettaAccesso);
		
		String[] AccessoString = {"Standard","Studenti","Gold","Platinum"};
		JComboBox<String> ListaAccesso = new JComboBox<>(AccessoString);
		ListaAccesso.setFont(new Font("Courier", Font.CENTER_BASELINE,20));
		ListaAccesso.setBounds(470, 285, 250, 50);
		contentPane.add(ListaAccesso);
		
		JLabel EtichettaPercentuale = new JLabel("Percentuale:");
		EtichettaPercentuale.setFont(new Font("Courier", Font.CENTER_BASELINE,20));
		EtichettaPercentuale.setForeground(new Color(255,255,255));
		EtichettaPercentuale.setBounds(300, 335, 150, 45);
		contentPane.add(EtichettaPercentuale);
		
		inserimentoPercentualeProd = new JTextField();
		inserimentoPercentualeProd.setFont(new Font("Courier", Font.CENTER_BASELINE,20));
		inserimentoPercentualeProd.setBounds(470,335,250,45);
		contentPane.add(inserimentoPercentualeProd);
		
		JButton avanzaInserimento = new JButton("Inserimento");
		avanzaInserimento.setForeground(new Color(20,20,20));
		avanzaInserimento.setFont(new Font("Courier", Font.CENTER_BASELINE,20));
		avanzaInserimento.setBounds(325, 395, 180, 45);
		contentPane.add(avanzaInserimento);
		
		JButton Indietro = new JButton("Indietro");
		Indietro.setForeground(new Color(20,20,20));
		Indietro.setFont(new Font("Courier", Font.CENTER_BASELINE,20));
		Indietro.setBounds(525, 395, 180, 45);
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
				int dur = Integer.parseInt(inserimentoDurataTraccia.getText());
				int perc = Integer.parseInt(inserimentoPercentualeProd.getText());
				if(inserimentoNomeTraccia.getText().length()<=0 || inserimentoNomeTraccia.getText().length()>30)
				{
					JOptionPane.showMessageDialog(avanzaInserimento,"Errore nell'inserimento del titolo.");
				}
				else if(inserimentoGenereTraccia.getText().length()<=0 || inserimentoGenereTraccia.getText().length()>15)
				{
					JOptionPane.showMessageDialog(avanzaInserimento,"Errore nell'inserimento del genere musicale.");
				}
				else if(dur<=0)
				{
					JOptionPane.showMessageDialog(avanzaInserimento,"Errore nell'inserimento della durata.");
				}
				else if(inserimentoQualitaTraccia.getText().length()<=0 || inserimentoQualitaTraccia.getText().length()>20)
				{
					JOptionPane.showMessageDialog(avanzaInserimento,"Errore nell'inserimento della Qualita'.");
				}
				else if(perc<0)
				{
					JOptionPane.showMessageDialog(avanzaInserimento,"Errore nell'inserimento della percentuale.");
				}
				else
				{
					controller.inserisciTracciaOriginal(utente.getNomeUtente(), utente.getPassword(), codiceArtista,album.getTitolo(), inserimentoNomeTraccia.getText(), dur, inserimentoGenereTraccia.getText(), inserimentoQualitaTraccia.getText(), inserimentoTipoTraccia.getText(), ListaAccesso.getItemAt(ListaAccesso.getSelectedIndex()), perc);
					JOptionPane.showMessageDialog(avanzaInserimento,"Inserimento avvenuto con successo.");
					inserimentoNuovaTraccia.dispose();
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
				inserimentoNuovaTraccia.dispose();
				AdminGui.setVisible(true);
			}
		});
	}
	
	
	public InserisciNuovaTracciaGui(JFrame AdminGui, ControllerTraccia controller, Utente utente, int codiceArtista,Album album,Traccia tracciaOriginale) 
	{
		AdminGui.setVisible(false);
		inserimentoNuovaTraccia=this;
		inserimentoNuovaTraccia.setVisible(true);
		
		inserimentoNuovaTraccia.setBackground(new Color(20, 20, 20));
		inserimentoNuovaTraccia.setTitle("Inserimento Traccia");
		inserimentoNuovaTraccia.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		inserimentoNuovaTraccia.setBounds(170, 55, 1080, 720);
		inserimentoNuovaTraccia.setResizable(false);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(20, 20, 20));
		inserimentoNuovaTraccia.setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel Etichetta = new JLabel("Inserimento Traccia");
		Etichetta.setForeground(new Color(0,76,153));
		Etichetta.setFont(new Font("Courier", Font.CENTER_BASELINE, 50));
		Etichetta.setBounds(260, 25, 750, 45);
		contentPane.add(Etichetta);
		
		JLabel EtichettaNome = new JLabel("Nome Traccia:");
		EtichettaNome.setForeground(new Color(255,255,255));
		EtichettaNome.setFont(new Font("Courier", Font.CENTER_BASELINE, 20));
		EtichettaNome.setBounds(300, 85, 350, 45);
		contentPane.add(EtichettaNome);
		
		inserimentoNomeTraccia = new JTextField();
		inserimentoNomeTraccia.setFont(new Font("Courier", Font.CENTER_BASELINE,20));
		inserimentoNomeTraccia.setBounds(470, 85, 250, 45);
		contentPane.add(inserimentoNomeTraccia);
		
		JLabel EtichettaDurata = new JLabel("Durata:");
		EtichettaDurata.setForeground(new Color(255,255,255));
		EtichettaDurata.setFont(new Font("Courier", Font.CENTER_BASELINE, 20));
		EtichettaDurata.setBounds(300, 135, 350, 45);
		contentPane.add(EtichettaDurata);
		
		inserimentoDurataTraccia = new JTextField();
		inserimentoDurataTraccia.setFont(new Font("Courier", Font.CENTER_BASELINE,20));
		inserimentoDurataTraccia.setBounds(470, 135, 250, 45);
		contentPane.add(inserimentoDurataTraccia);
		
		JLabel EtichettaGenere = new JLabel("Genere:");
		EtichettaGenere.setForeground(new Color(255,255,255));
		EtichettaGenere.setFont(new Font("Courier", Font.CENTER_BASELINE, 20));
		EtichettaGenere.setBounds(300, 185, 350, 45);
		contentPane.add(EtichettaGenere);
		
		inserimentoGenereTraccia = new JTextField();
		inserimentoGenereTraccia.setFont(new Font("Courier", Font.CENTER_BASELINE,20));
		inserimentoGenereTraccia.setBounds(470, 185, 250, 45);
		contentPane.add(inserimentoGenereTraccia);
		
		JLabel EtichettaQualita = new JLabel("Qualita' :");
		EtichettaQualita.setForeground(new Color(255,255,255));
		EtichettaQualita.setFont(new Font("Courier", Font.CENTER_BASELINE, 20));
		EtichettaQualita.setBounds(300, 235, 350, 45);
		contentPane.add(EtichettaQualita);
		
		inserimentoQualitaTraccia = new JTextField();
		inserimentoQualitaTraccia.setFont(new Font("Courier", Font.CENTER_BASELINE,20));
		inserimentoQualitaTraccia.setBounds(470, 235, 250, 45);
		contentPane.add(inserimentoQualitaTraccia);
		
		JLabel EtichettaTipo = new JLabel("Tipo:");
		EtichettaTipo.setForeground(new Color(255,255,255));
		EtichettaTipo.setFont(new Font("Courier", Font.CENTER_BASELINE, 20));
		EtichettaTipo.setBounds(300, 285, 350, 45);
		contentPane.add(EtichettaTipo);
		
		inserimentoTipoTraccia = new JTextField();
		inserimentoTipoTraccia.setFont(new Font("Courier", Font.CENTER_BASELINE,20));
		inserimentoTipoTraccia.setBounds(470, 285, 250, 45);
		contentPane.add(inserimentoTipoTraccia);		
		
		JLabel EtichettaAccesso = new JLabel("Accesso:");
		EtichettaAccesso.setFont(new Font("Courier", Font.CENTER_BASELINE,20));
		EtichettaAccesso.setForeground(new Color(255,255,255));
		EtichettaAccesso.setBounds(300, 335, 350, 45);
		contentPane.add(EtichettaAccesso);
		
		String[] AccessoString = {"Standard","Studenti","Gold","Platinum"};
		JComboBox<String> ListaAccesso = new JComboBox<>(AccessoString);
		ListaAccesso.setFont(new Font("Courier", Font.CENTER_BASELINE,20));
		ListaAccesso.setBounds(470, 335, 250, 50);
		contentPane.add(ListaAccesso);
		
		JLabel EtichettaPercentuale = new JLabel("Percentuale:");
		EtichettaPercentuale.setFont(new Font("Courier", Font.CENTER_BASELINE,20));
		EtichettaPercentuale.setForeground(new Color(255,255,255));
		EtichettaPercentuale.setBounds(300, 385, 350, 45);
		contentPane.add(EtichettaPercentuale);
		
		inserimentoPercentualeProd = new JTextField();
		inserimentoPercentualeProd.setFont(new Font("Courier", Font.CENTER_BASELINE,20));
		inserimentoPercentualeProd.setBounds(470,385,250,45);
		contentPane.add(inserimentoPercentualeProd);
		
		JButton avanzaInserimento = new JButton("Inserimento");
		avanzaInserimento.setForeground(new Color(20,20,20));
		avanzaInserimento.setFont(new Font("Courier", Font.CENTER_BASELINE,20));
		avanzaInserimento.setBounds(325, 445, 180, 45);
		contentPane.add(avanzaInserimento);
		
		JButton Indietro = new JButton("Indietro");
		Indietro.setForeground(new Color(20,20,20));
		Indietro.setFont(new Font("Courier", Font.CENTER_BASELINE,20));
		Indietro.setBounds(525, 445, 180, 45);
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
				int dur = Integer.parseInt(inserimentoDurataTraccia.getText());
				int perc = Integer.parseInt(inserimentoPercentualeProd.getText());
				if(inserimentoNomeTraccia.getText().length()<=0 || inserimentoNomeTraccia.getText().length()>30)
				{
					JOptionPane.showMessageDialog(avanzaInserimento,"Errore nell'inserimento del titolo.");
				}
				else if(inserimentoGenereTraccia.getText().length()<=0 || inserimentoGenereTraccia.getText().length()>15)
				{
					JOptionPane.showMessageDialog(avanzaInserimento,"Errore nell'inserimento del genere musicale.");
				}
				else if(dur<=0)
				{
					JOptionPane.showMessageDialog(avanzaInserimento,"Errore nell'inserimento della durata.");
				}
				else if(inserimentoQualitaTraccia.getText().length()<=0 || inserimentoQualitaTraccia.getText().length()>20)
				{
					JOptionPane.showMessageDialog(avanzaInserimento,"Errore nell'inserimento della QualitÃ .");
				}
				else if(perc<0)
				{
					JOptionPane.showMessageDialog(avanzaInserimento,"Errore nell'inserimento della percentuale.");
				}
				else
				{
					controller.inserisciTracciaDerivata(utente.getNomeUtente(), utente.getPassword(), codiceArtista,album.getTitolo(), inserimentoNomeTraccia.getText(), dur, inserimentoGenereTraccia.getText(), inserimentoQualitaTraccia.getText(), inserimentoTipoTraccia.getText(), ListaAccesso.getItemAt(ListaAccesso.getSelectedIndex()), perc, tracciaOriginale.getIdTraccia());
					JOptionPane.showMessageDialog(avanzaInserimento,"Inserimento avvenuto con successo.");
					inserimentoNuovaTraccia.dispose();
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
				inserimentoNuovaTraccia.dispose();
				AdminGui.setVisible(true);
			}
		});
	}
}
