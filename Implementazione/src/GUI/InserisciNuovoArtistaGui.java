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

import Controller.ControllerArtista;

import Entità.Utente;


@SuppressWarnings("serial")
public class InserisciNuovoArtistaGui extends JFrame
{
	private JPanel contentPane;
	private JTextField inserimentoNomeArtista;
	private JTextField inserimentoEtichetta;
	private JFrame inserimentoArtistaGui;
	
	public InserisciNuovoArtistaGui(JFrame AdminGui, ControllerArtista controller, Utente utente) 
	{
		AdminGui.setVisible(false);
		inserimentoArtistaGui=this;
		inserimentoArtistaGui.setVisible(true);
		
		inserimentoArtistaGui.setBackground(new Color(20, 20, 20));
		inserimentoArtistaGui.setTitle("Nuovo Artista");
		inserimentoArtistaGui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		inserimentoArtistaGui.setBounds(170, 55, 1080, 720);
		inserimentoArtistaGui.setResizable(false);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(20, 20, 20));
		inserimentoArtistaGui.setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel EtichettaBn = new JLabel("Inserimento Artista");
		EtichettaBn.setForeground(new Color(0,76,153));
		EtichettaBn.setFont(new Font("Courier", Font.CENTER_BASELINE, 50));
		EtichettaBn.setBounds(260, 50, 650, 45);
		contentPane.add(EtichettaBn);
		
		JLabel EtichettaNome = new JLabel("Nome Artista:");
		EtichettaNome.setForeground(new Color(255,255,255));
		EtichettaNome.setFont(new Font("Courier", Font.CENTER_BASELINE, 20));
		EtichettaNome.setBounds(340, 120, 350, 45);
		contentPane.add(EtichettaNome);
		
		inserimentoNomeArtista = new JTextField();
		inserimentoNomeArtista.setFont(new Font("Courier", Font.CENTER_BASELINE,20));
		inserimentoNomeArtista.setBounds(500, 120, 250, 45);
		contentPane.add(inserimentoNomeArtista);
		
		JLabel etichettaNazione = new JLabel("Nazione:");
		etichettaNazione.setForeground(new Color(255,255,255));
		etichettaNazione.setFont(new Font("Courier", Font.CENTER_BASELINE,20));
		etichettaNazione.setBounds(340, 170, 150, 45);
		contentPane.add(etichettaNazione);
		
		String[] NazioneString = {"Afghanistan","Albania","Algeria","Andorra","Angola","tigua","Arabia Saudita",
				"Argentina","Armenia","Australia","Austria","Azerbaigian","Bahamas","Bahrein","Bangladesh",
				"Barbados","Belgio","Belize","Benin","Bhutan","Bielorussia","Bolivia","Bosnia ed Erzegovina",
				"Botswana","Brasile","Brunei","Bulgaria","Burkina Faso","Burundi","Cambogia","Camerun","Canada",
				"Capo Verde","Ciad","Cile","Cina","Cipro","Città del Vaticano","Colombia","Comore",
				"Corea del Nord","Corea del Sud","Costa d’Avorio","Costa Rica","Croazia","Cuba","Danimarca",
				"Dominica","Ecuador","Egitto","El Salvador","Emirati Arabi Uniti","Eritrea","Estonia","Etiopia",
				"Figi","Filippine","Finlandia","Francia","Gabon","Gambia","Georgia","Germania","Ghana","Giamaica",
				"Giappone","Gibuti","Giordania","Grecia","Grenada","Guatemala","Guinea","Guinea-Bissau",
				"Guinea Equatoriale","Guyana","Haiti","Honduras","India","Indonesia","Iran","Iraq","Irlanda",
				"Islanda","Isole Marshall","Isole Salomone","Israele","Italia","Kazakistan","Kenya",
				"Kirghizistan","Kiribati","Kuwait","Laos","Lesotho","Lettonia","Libano","Liberia","Libia",
				"Liechtenstein","Lituania","Lussemburgo","Macedonia","Madagascar","Malawi","Maldive","Malesia",
				"Mali","Malta","Marocco","Mauritania","Mauritius","Messico","Micronesia","Moldavia","Monaco",
				"Mongolia","Montenegro","Mozambico","Myanmar","Namibia","Nauru","Nepal","Nicaragua","Niger",
				"Nigeria","Norvegia","Nuova Zelanda","Oman","Paesi Bassi","Pakistan","Palau","Palestina",
				"Panama","Papua Nuova Guinea","Paraguay","Perù","Polonia","Portogallo","Qatar","Regno Unito",
				"Repubblica Ceca","Repubblica Centrafricana","Repubblica del Congo",
				"Repubblica Democratica del Congo","Repubblica Dominicana","Romania","Ruanda","Russia",
				"Saint Kitts e Nevis","Saint Vincent e Grenadine","Samoa","San Marino","Santa Lucia",
				"São Tomé e Príncipe","Senegal","Serbia","Seychelles","Sierra Leone","Singapore","Siria",
				"Slovacchia","Slovenia","Somalia","Spagna","Sri Lanka","Stati Uniti","Sudafrica","Sudan",
				"Sudan del Sud","Suriname","Svezia","Svizzera","Swaziland","Tagikistan","Taiwan","Tanzania",
				"Thailandia","Timor Est","Togo","Tonga","Trinidad e Tobago","Tunisia","Turchia","Turkmenistan",
				"Tuvalu","Ucraina","Uganda","Ungheria","Uruguay","Uzbekistan","Vanuatu","Venezuela","Vietnam",
				"Yemen","Zambia","Zimbabwe"};
		JComboBox<String> ListaNazione = new JComboBox<>(NazioneString);
		ListaNazione.setFont(new Font("Courier", Font.CENTER_BASELINE,20));
		ListaNazione.setBounds(500, 170, 250, 50);
		contentPane.add(ListaNazione);
		
		JLabel etichetta = new JLabel("Etichetta:");
		etichetta.setForeground(new Color(255,255,255));
		etichetta.setFont(new Font("Courier", Font.CENTER_BASELINE,20));
		etichetta.setBounds(340, 220, 150, 45);
		contentPane.add(etichetta);
		
		inserimentoEtichetta = new JTextField();
		inserimentoEtichetta.setFont(new Font("Courier", Font.CENTER_BASELINE,20));
		inserimentoEtichetta.setBounds(500,220,250,45);
		contentPane.add(inserimentoEtichetta);
		
		JButton avanzaInserimento = new JButton("Inserimento");
		avanzaInserimento.setForeground(new Color(20,20,20));
		avanzaInserimento.setFont(new Font("Courier", Font.CENTER_BASELINE,20));
		avanzaInserimento.setBounds(370, 285, 170, 45);
		contentPane.add(avanzaInserimento);
		
		JButton Indietro = new JButton("Indietro");
		Indietro.setForeground(new Color(20,20,20));
		Indietro.setFont(new Font("Courier", Font.CENTER_BASELINE,20));
		Indietro.setBounds(560, 285, 170, 45);
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
				if(inserimentoNomeArtista.getText().length()<=0 || inserimentoNomeArtista.getText().length()>20)
				{
					JOptionPane.showMessageDialog(avanzaInserimento,"Errore nell'inserimento del nome.");
				}
				else if(inserimentoEtichetta.getText().length()<=0 || inserimentoEtichetta.getText().length()>40)
				{
					JOptionPane.showMessageDialog(avanzaInserimento,"Errore nell'inserimento dell'Etichetta.");
				}
				else
				{
					controller.InserisciArtista(utente.getNomeUtente(), utente.getPassword(), inserimentoNomeArtista.getText(),ListaNazione.getItemAt(ListaNazione.getSelectedIndex()),inserimentoEtichetta.getText());
					JOptionPane.showMessageDialog(avanzaInserimento,"Inserimento avvenuto con successo.");
					inserimentoArtistaGui.dispose();
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
				inserimentoArtistaGui.dispose();
				AdminGui.setVisible(true);
			}
		});
	}
}