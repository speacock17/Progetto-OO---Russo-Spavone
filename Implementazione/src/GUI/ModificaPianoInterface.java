package GUI;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
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
public class ModificaPianoInterface extends JFrame
{
	private JPanel contentPane;
	private JFrame modPianoGui;
	

	public ModificaPianoInterface(JFrame impGui, ControllerUtente controller, Utente utente) 
	{
		impGui.setVisible(false);
		modPianoGui=this;
		modPianoGui.setVisible(true);
		modPianoGui.setBackground(new Color(20, 20, 20));
		modPianoGui.setTitle("Modifica Piano Abbonamento");
		modPianoGui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		modPianoGui.setBounds(170, 55, 1080, 720);
		modPianoGui.setResizable(false);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(20, 20, 20));
		modPianoGui.setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel EtichettaBn = new JLabel("Modifica il tuo Abbonamento");
		EtichettaBn.setForeground(new Color(0,76,153));
		EtichettaBn.setFont(new Font("Courier", Font.CENTER_BASELINE, 50));
		EtichettaBn.setBounds(130, 50, 900, 45);
		contentPane.add(EtichettaBn);
		
		JLabel EtichettanuovaPassword = new JLabel("Inserisci il tuo nuovo Piano");
		EtichettanuovaPassword.setForeground(new Color(255,255,255));
		EtichettanuovaPassword.setFont(new Font("Courier", Font.CENTER_BASELINE, 20));
		EtichettanuovaPassword.setBounds(50, 140, 450, 45);
		contentPane.add(EtichettanuovaPassword);
		
		String[] AbbonamentoString = { "Standard", "Studenti", "Gold", "Platinum"};
		JComboBox<String> ListaAbbonamento = new JComboBox<>(AbbonamentoString);
		ListaAbbonamento.setFont(new Font("Courier", Font.CENTER_BASELINE,20));
		ListaAbbonamento.setBounds(400, 140, 250, 45);
		contentPane.add(ListaAbbonamento);
		
		JButton avanza = new JButton("Avanti");
		avanza.setForeground(new Color(20,20,20));
		avanza.setFont(new Font("Courier", Font.CENTER_BASELINE,20));
		avanza.setBounds(330, 220, 150, 45);
		contentPane.add(avanza);
		
		JButton indietro = new JButton("Indietro");
		indietro.setForeground(new Color(20,20,20));
		indietro.setFont(new Font("Courier", Font.CENTER_BASELINE,20));
		indietro.setBounds(530, 220, 150, 45);
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
				String temp = new String(ListaAbbonamento.getItemAt(ListaAbbonamento.getSelectedIndex()));
				if(temp.equals(utente.getPiano()))
				{
					JOptionPane.showMessageDialog(avanza, "Errore, sei già abbonato a questo piano.");
				}
				else
				{
					controller.modificaPiano(utente.getNomeUtente(),utente.getPassword(),ListaAbbonamento.getItemAt(ListaAbbonamento.getSelectedIndex()));
					JOptionPane.showMessageDialog(avanza, "La modifica è avvenuta con successo.");
					modPianoGui.dispose();
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
				modPianoGui.dispose();
				impGui.setVisible(true);
			}
		});
	}



	public ModificaPianoInterface(JFrame admingui, ControllerUtente controller, Utente utente, Utente utente2) 
	{
		modPianoGui=this;
		modPianoGui.setVisible(true);
		modPianoGui.setBackground(new Color(20, 20, 20));
		modPianoGui.setTitle("Modifica Piano");
		modPianoGui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		modPianoGui.setBounds(170, 55, 1080, 720);
		modPianoGui.setResizable(false);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(20, 20, 20));
		modPianoGui.setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel EtichettaBn = new JLabel("Modifica Piano Abbonamento");
		EtichettaBn.setForeground(new Color(0,76,153));
		EtichettaBn.setFont(new Font("Courier", Font.CENTER_BASELINE, 50));
		EtichettaBn.setBounds(130, 50, 900, 45);
		contentPane.add(EtichettaBn);
		
		JLabel EtichettanuovaPassword = new JLabel("Inserisci il nuovo Piano:");
		EtichettanuovaPassword.setForeground(new Color(255,255,255));
		EtichettanuovaPassword.setFont(new Font("Courier", Font.CENTER_BASELINE, 20));
		EtichettanuovaPassword.setBounds(220, 140, 450, 45);
		contentPane.add(EtichettanuovaPassword);
		
		String[] AbbonamentoString = { "Standard", "Studenti", "Gold", "Platinum"};
		JComboBox<String> ListaAbbonamento = new JComboBox<>(AbbonamentoString);
		ListaAbbonamento.setFont(new Font("Courier", Font.CENTER_BASELINE,20));
		ListaAbbonamento.setBounds(540, 140, 250, 45);
		contentPane.add(ListaAbbonamento);
		
		JButton avanza = new JButton("Avanti");
		avanza.setForeground(new Color(20,20,20));
		avanza.setFont(new Font("Courier", Font.CENTER_BASELINE,20));
		avanza.setBounds(330, 220, 150, 45);
		contentPane.add(avanza);
		
		JButton indietro = new JButton("Indietro");
		indietro.setForeground(new Color(20,20,20));
		indietro.setFont(new Font("Courier", Font.CENTER_BASELINE,20));
		indietro.setBounds(530, 220, 150, 45);
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
				String temp = new String(ListaAbbonamento.getItemAt(ListaAbbonamento.getSelectedIndex()));
				if(temp.equals(utente2.getPiano()))
				{
					JOptionPane.showMessageDialog(avanza, "Errore, è l'abbonamento attuale.");
				}
				else
				{
					controller.modificaPiano(utente2.getNomeUtente(),utente2.getPassword(),ListaAbbonamento.getItemAt(ListaAbbonamento.getSelectedIndex()));
					JOptionPane.showMessageDialog(avanza, "La modifica è avvenuta con successo.");
					modPianoGui.dispose();
					admingui.setVisible(true);
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
				modPianoGui.dispose();
				admingui.setVisible(true);
			}
		});
	}
}