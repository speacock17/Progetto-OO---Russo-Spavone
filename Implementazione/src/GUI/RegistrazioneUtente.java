package GUI;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;

import java.awt.Font;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import Controller.ControllerUtente;

import Entità.Utente;


@SuppressWarnings("serial")
public class RegistrazioneUtente extends JFrame
{
	private JPanel contentPane;
	private JTextField inserimentoNomeUtente;
	private JTextField inserimentoPassword;
	private JTextField inserimentoMail;
	private JTextField inserimentoNome;
	private JTextField inserimentoCognome;
	private JFrame registrazioneGui;
	
	public RegistrazioneUtente(JFrame loginGui, ControllerUtente controller) 
	{
		loginGui.setVisible(false);
		registrazioneGui=this;
		registrazioneGui.setVisible(true);
		registrazioneGui.setBackground(new Color(20, 20, 20));
		registrazioneGui.setTitle("Registrazione Cliente");
		registrazioneGui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		registrazioneGui.setBounds(170, 55, 1080, 720);
		registrazioneGui.setResizable(false);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(20, 20, 20));
		registrazioneGui.setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel EtichettaRegistrazione = new JLabel("Registrazione");
		EtichettaRegistrazione.setForeground(new Color(0,76,153));
		EtichettaRegistrazione.setFont(new Font("Courier", Font.CENTER_BASELINE, 50));
		EtichettaRegistrazione.setBounds(345, 20, 500, 70);
		contentPane.add(EtichettaRegistrazione);
		
		JLabel etichettaNomeUtente = new JLabel("Nome Utente:");
		etichettaNomeUtente.setFont(new Font("Courier", Font.CENTER_BASELINE,20));
		etichettaNomeUtente.setForeground(new Color(255,255,255));
		etichettaNomeUtente.setBounds(345, 100, 150, 45);
		contentPane.add(etichettaNomeUtente);
		
		inserimentoNomeUtente = new JTextField();
		inserimentoNomeUtente.setFont(new Font("Courier", Font.CENTER_BASELINE,20));
		inserimentoNomeUtente.setBounds(495, 100, 250, 45);
		contentPane.add(inserimentoNomeUtente);	
		
		JLabel etichettaPassword = new JLabel("Password:");
		etichettaPassword.setFont(new Font("Courier", Font.CENTER_BASELINE,20));
		etichettaPassword.setForeground(new Color(255,255,255));
		etichettaPassword.setBounds(345, 150, 150, 45);
		contentPane.add(etichettaPassword);
		
		inserimentoPassword = new JPasswordField();
		inserimentoPassword.setFont(new Font("Courier", Font.CENTER_BASELINE,20));
		inserimentoPassword.setBounds(495,150,250,45);
		contentPane.add(inserimentoPassword);
		
		JLabel etichettaMail = new JLabel("Mail:");
		etichettaMail.setFont(new Font("Courier", Font.CENTER_BASELINE,20));
		etichettaMail.setForeground(new Color(255,255,255));
		etichettaMail.setBounds(345, 200, 150, 45);
		contentPane.add(etichettaMail);
		
		inserimentoMail = new JTextField();
		inserimentoMail.setFont(new Font("Courier", Font.CENTER_BASELINE,20));
		inserimentoMail.setBounds(495, 200, 250, 45);
		contentPane.add(inserimentoMail);	
		
		JLabel etichettaNome = new JLabel("Nome:");
		etichettaNome.setFont(new Font("Courier", Font.CENTER_BASELINE,20));
		etichettaNome.setForeground(new Color(255,255,255));
		etichettaNome.setBounds(345, 250, 150, 45);
		contentPane.add(etichettaNome);
		
		inserimentoNome = new JTextField();
		inserimentoNome.setFont(new Font("Courier", Font.CENTER_BASELINE,20));
		inserimentoNome.setBounds(495, 250, 250, 45);
		contentPane.add(inserimentoNome);
		
		JLabel etichettaCognome = new JLabel("Cognome:");
		etichettaCognome.setFont(new Font("Courier", Font.CENTER_BASELINE,20));
		etichettaCognome.setForeground(new Color(255,255,255));
		etichettaCognome.setBounds(345, 300, 150, 45);
		contentPane.add(etichettaCognome);
		
		inserimentoCognome = new JTextField();
		inserimentoCognome.setFont(new Font("Courier", Font.CENTER_BASELINE,20));
		inserimentoCognome.setBounds(495, 300, 250, 45);
		contentPane.add(inserimentoCognome);
		
		JLabel etichettaNazione = new JLabel("Nazione:");
		etichettaNazione.setFont(new Font("Courier", Font.CENTER_BASELINE,20));
		etichettaNazione.setForeground(new Color(255,255,255));
		etichettaNazione.setBounds(345, 350, 150, 45);
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
		ListaNazione.setFont(new Font("Courier", Font.CENTER_BASELINE,15));
		ListaNazione.setBounds(495, 350, 250, 45);
		contentPane.add(ListaNazione);
		
		JLabel etichettaAbbonamento = new JLabel("Abbonamento:");
		etichettaAbbonamento.setFont(new Font("Courier", Font.CENTER_BASELINE,20));
		etichettaAbbonamento.setForeground(new Color(255,255,255));
		etichettaAbbonamento.setBounds(345, 400, 150, 45);
		contentPane.add(etichettaAbbonamento);
		
		String[] AbbonamentoString = { "Standard", "Studenti", "Gold", "Platinum"};
		JComboBox<String> ListaAbbonamento = new JComboBox<>(AbbonamentoString);
		ListaAbbonamento.setFont(new Font("Courier", Font.CENTER_BASELINE,15));
		ListaAbbonamento.setBounds(495, 400, 250, 45);
		contentPane.add(ListaAbbonamento);
		
		JButton avanzaRegistrazione = new JButton("Registrati");
		avanzaRegistrazione.setForeground(new Color(20,20,20));
		avanzaRegistrazione.setFont(new Font("Courier", Font.CENTER_BASELINE,20));
		avanzaRegistrazione.setBounds(345, 450, 150, 45);
		contentPane.add(avanzaRegistrazione);
		
		avanzaRegistrazione.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				
			}
		});
		avanzaRegistrazione.addMouseListener(new MouseAdapter() 
		{
			public void mouseClicked(MouseEvent e) 
			{
				int esitoControllo;
				int esitoControlloUnicitàMail;
				boolean esitoControlloMail;
				esitoControlloMail=Utente.correttezzaMail(inserimentoMail.getText());
				esitoControllo=controller.unicitàUtente(inserimentoNomeUtente.getText());
				esitoControlloUnicitàMail=controller.unicitàMail(inserimentoMail.getText());
				System.out.println("esito"+esitoControllo);
				if(esitoControllo==1)
				{
					JOptionPane.showMessageDialog(avanzaRegistrazione, "Nome Utente già utilizzato.");
				}
				else if(inserimentoPassword.getText().length()<6)
				{
					JOptionPane.showMessageDialog(avanzaRegistrazione, "Errore, la password deve essere almeno di 6 caratteri.");
				}
				else if(!esitoControlloMail)
				{
					JOptionPane.showMessageDialog(avanzaRegistrazione, "Errore, la tua Mail non è valida.");
				}
				else if(esitoControlloUnicitàMail==1)
				{
					JOptionPane.showMessageDialog(avanzaRegistrazione, "Mail già registrata alla piattaforma.");
				}
				else
				{
					controller.Registrazione(inserimentoNomeUtente.getText(),inserimentoPassword.getText(),inserimentoMail.getText(),inserimentoNome.getText(),inserimentoCognome.getText(),ListaNazione.getItemAt(ListaNazione.getSelectedIndex()),ListaAbbonamento.getItemAt(ListaAbbonamento.getSelectedIndex()));
					JOptionPane.showMessageDialog(avanzaRegistrazione, "Registrazione avvenuta con successo.");
					registrazioneGui.dispose();
					loginGui.setVisible(true);
				}
			}
		});
		
		JButton IndietroRegistrazione = new JButton("Indietro");
		IndietroRegistrazione.setForeground(new Color(20,20,20));
		IndietroRegistrazione.setFont(new Font("Courier", Font.CENTER_BASELINE,20));
		IndietroRegistrazione.setBounds(520, 450, 120, 45);
		contentPane.add(IndietroRegistrazione);
		
		IndietroRegistrazione.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				
			}
		});
		IndietroRegistrazione.addMouseListener(new MouseAdapter() 
		{
			public void mouseClicked(MouseEvent e) 
			{
				registrazioneGui.dispose();
				loginGui.setVisible(true);
			}
		});
	}
}