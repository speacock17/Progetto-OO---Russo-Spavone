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

import Controller.ControllerProduttore;

import Entità.Utente;


@SuppressWarnings("serial")
public class InserisciProduttoreGui extends JFrame
{
	private JPanel contentPane;
	private JTextField inserimentoNomeProd;
	private JFrame inserimentoProdGui;
	
	public InserisciProduttoreGui(JFrame AdminGui, ControllerProduttore controller, Utente utente) 
	{
		AdminGui.setVisible(false);
		inserimentoProdGui=this;
		inserimentoProdGui.setVisible(true);
		inserimentoProdGui.setBackground(new Color(20, 20, 20));
		inserimentoProdGui.setTitle("Inserimento Produttore");
		inserimentoProdGui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		inserimentoProdGui.setBounds(170, 55, 1080, 720);
		inserimentoProdGui.setResizable(false);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(20, 20, 20));
		inserimentoProdGui.setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel EtichettaBn = new JLabel("Inserimento Produttore");
		EtichettaBn.setForeground(new Color(0,76,153));
		EtichettaBn.setFont(new Font("Courier", Font.CENTER_BASELINE, 50));
		EtichettaBn.setBounds(210, 50, 750, 45);
		contentPane.add(EtichettaBn);
		
		JLabel EtichettaNome = new JLabel("Nome Produttore:");
		EtichettaNome.setForeground(new Color(255,255,255));
		EtichettaNome.setFont(new Font("Courier", Font.CENTER_BASELINE, 20));
		EtichettaNome.setBounds(295, 120, 350, 45);
		contentPane.add(EtichettaNome);
		
		inserimentoNomeProd = new JTextField();
		inserimentoNomeProd.setFont(new Font("Courier", Font.CENTER_BASELINE,20));
		inserimentoNomeProd.setBounds(525, 120, 250, 45);
		contentPane.add(inserimentoNomeProd);
	
		JButton avanzaInserimento = new JButton("Inserimento");
		avanzaInserimento.setForeground(new Color(20,20,20));
		avanzaInserimento.setFont(new Font("Courier", Font.CENTER_BASELINE,20));
		avanzaInserimento.setBounds(340, 180, 180, 45);
		contentPane.add(avanzaInserimento);
		
		JButton Indietro = new JButton("Indietro");
		Indietro.setForeground(new Color(20,20,20));
		Indietro.setFont(new Font("Courier", Font.CENTER_BASELINE,20));
		Indietro.setBounds(540, 180, 180, 45);
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
				controller.InserisciProduttore(utente.getNomeUtente(), utente.getPassword(), inserimentoNomeProd.getText());
				JOptionPane.showMessageDialog(avanzaInserimento,"Inserimento avvenuto con successo.");
				inserimentoProdGui.dispose();
				AdminGui.setVisible(true);
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
				inserimentoProdGui.dispose();
				AdminGui.setVisible(true);
			}
		});
	}
}