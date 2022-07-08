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

import Controller.ControllerUtente;

import Entità.Utente;


@SuppressWarnings("serial")
public class ModificaMailGui extends JFrame
{
	private JPanel contentPane;
	private JFrame modMailGui;
	
	public ModificaMailGui(JFrame impGui, ControllerUtente controller, Utente utente) 
	{
		impGui.setVisible(false);
		modMailGui=this;
		modMailGui.setVisible(true);
		modMailGui.setBackground(new Color(20, 20, 20));
		modMailGui.setTitle("Modifica Mail");
		modMailGui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		modMailGui.setBounds(170, 55, 1080, 720);
		modMailGui.setResizable(false);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(20, 20, 20));
		modMailGui.setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel EtichettaBn = new JLabel("Modifica la tua Mail");
		EtichettaBn.setForeground(new Color(0,76,153));
		EtichettaBn.setFont(new Font("Courier", Font.CENTER_BASELINE, 50));
		EtichettaBn.setBounds(245, 50, 700, 45);
		contentPane.add(EtichettaBn);
		 
		JLabel EtichettanuovaMail = new JLabel("Inserisci la tua nuova Mail:");
		EtichettanuovaMail.setForeground(new Color(255,255,255));
		EtichettanuovaMail.setFont(new Font("Courier", Font.CENTER_BASELINE, 20));
		EtichettanuovaMail.setBounds(50, 140, 350, 45);
		contentPane.add(EtichettanuovaMail);
		
		JTextField inserimentoNuovaMail = new JTextField();
		inserimentoNuovaMail.setFont(new Font("Courier", Font.CENTER_BASELINE,20));
		inserimentoNuovaMail.setBounds(400, 140, 250, 45);
		contentPane.add(inserimentoNuovaMail);
		
		JButton avanza = new JButton("Avanti");
		avanza.setForeground(new Color(20,20,20));
		avanza.setFont(new Font("Courier", Font.CENTER_BASELINE,20));
		avanza.setBounds(345, 210, 150, 45);
		contentPane.add(avanza);
		
		JButton indietro = new JButton("Indietro");
		indietro.setForeground(new Color(20,20,20));
		indietro.setFont(new Font("Courier", Font.CENTER_BASELINE,20));
		indietro.setBounds(545, 210, 150, 45);
		contentPane.add(indietro);
		
		avanza.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				
			}
		});
		avanza.addMouseListener(new MouseAdapter() 
		{
			public void mouseClicked(MouseEvent e) 
			{
				boolean esitoControlloMail;
				esitoControlloMail=Utente.correttezzaMail(inserimentoNuovaMail.getText());
				if(!esitoControlloMail)
				{
					JOptionPane.showMessageDialog(avanza, "Errore, la tua Mail non è valida.");
				}
				else if((inserimentoNuovaMail.getText()).equals(utente.getMail()))
				{
					JOptionPane.showMessageDialog(avanza, "Errore, la mail che hai inserito è quella corrente.");
				}
				else
				{
					controller.modificaMail(utente.getNomeUtente(),utente.getPassword(),inserimentoNuovaMail.getText());
					JOptionPane.showMessageDialog(avanza, "La modifica è avvenuta con successo.");
					modMailGui.dispose();
					impGui.setVisible(true);
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
				modMailGui.dispose();
				impGui.setVisible(true);
			}
		});
	}
}