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

import Entita.Utente;


@SuppressWarnings("serial")
public class ModificaPasswordGui extends JFrame
{
	private JPanel contentPane;
	private JFrame modPassGui;
	
	public ModificaPasswordGui(JFrame impGui, ControllerUtente controller, Utente utente) 
	{
		impGui.setVisible(false);
		modPassGui=this;
		modPassGui.setVisible(true);
		modPassGui.setBackground(new Color(20, 20, 20));
		modPassGui.setTitle("Modifica Password");
		modPassGui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		modPassGui.setBounds(170, 55, 1080, 720);
		modPassGui.setResizable(false);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(20, 20, 20));
		modPassGui.setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel EtichettaBn = new JLabel("Modifica la tua Password");
		EtichettaBn.setForeground(new Color(0,76,153));
		EtichettaBn.setFont(new Font("Courier", Font.CENTER_BASELINE, 50));
		EtichettaBn.setBounds(225, 50, 800, 45);
		contentPane.add(EtichettaBn);
		
		JLabel EtichettanuovaPassword = new JLabel("Inserisci la tua nuova Password:");
		EtichettanuovaPassword.setForeground(new Color(255,255,255));
		EtichettanuovaPassword.setFont(new Font("Courier", Font.CENTER_BASELINE, 20));
		EtichettanuovaPassword.setBounds(50, 140, 450, 45);
		contentPane.add(EtichettanuovaPassword);
		
		JTextField inserimentoNuovaPassword = new JTextField();
		inserimentoNuovaPassword.setFont(new Font("Courier", Font.CENTER_BASELINE,20));
		inserimentoNuovaPassword.setBounds(445, 140, 250, 45);
		contentPane.add(inserimentoNuovaPassword);
		
		JButton avanza = new JButton("Avanti");
		avanza.setForeground(new Color(20,20,20));
		avanza.setFont(new Font("Courier", Font.CENTER_BASELINE,20));
		avanza.setBounds(395, 220, 150, 45);
		contentPane.add(avanza);
		
		JButton indietro = new JButton("Indietro");
		indietro.setForeground(new Color(20,20,20));
		indietro.setFont(new Font("Courier", Font.CENTER_BASELINE,20));
		indietro.setBounds(595, 220, 150, 45);
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
				if(((inserimentoNuovaPassword.getText()).length())<6)
				{
					JOptionPane.showMessageDialog(avanza, "Errore, la tua Password e' troppo breve.");
				}
				else if(((inserimentoNuovaPassword.getText()).equals(utente.getPassword())))
				{
					JOptionPane.showMessageDialog(avanza, "Errore, la password che hai inserito e' quella attuale.");
				}
				else
				{
					controller.modificaPassword(utente.getNomeUtente(),utente.getPassword(),inserimentoNuovaPassword.getText());
					JOptionPane.showMessageDialog(avanza, "La modifica e' avvenuta con successo.");
					modPassGui.dispose();
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
				modPassGui.dispose();
				impGui.setVisible(true);
			}
		});
	}
}