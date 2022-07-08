package GUI;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
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
public class ImpostazioniClient extends JFrame
{
	private JPanel contentPane;
	private JFrame impGui;
	
	public ImpostazioniClient(JFrame clientGui, ControllerUtente controller, Utente utente) 
	{
		clientGui.setVisible(false);
		impGui=this;
		impGui.setVisible(true);
		
		impGui.setBackground(new Color(20, 20, 20));
		impGui.setTitle("Impostazioni");
		impGui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		impGui.setBounds(170, 55, 1080, 720);
		impGui.setResizable(false);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(20, 20, 20));
		impGui.setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel etichettaImp = new JLabel("Impostazioni");
		etichettaImp.setForeground(new Color(0,76,153));
		etichettaImp.setFont(new Font("Courier", Font.CENTER_BASELINE, 50));
		etichettaImp.setBounds(360, 25, 500, 45);
		contentPane.add(etichettaImp);
		
	    JLabel etichettaBn = new JLabel("Scegliere che operazione eseguire:");
	    etichettaBn.setForeground(new Color(255,255,255));
		etichettaBn.setFont(new Font("Courier", Font.CENTER_BASELINE, 20));
		etichettaBn.setBounds(75, 75, 450, 45);
		contentPane.add(etichettaBn);
		 
		JButton modificaMail = new JButton("Modifica la Mail");
		modificaMail.setForeground(new Color(20,20,20));
		modificaMail.setFont(new Font("Courier", Font.CENTER_BASELINE,20));
		modificaMail.setBounds(70, 125, 370, 45);
		contentPane.add(modificaMail);
		
		JButton modificaPassword = new JButton("Modifica la Password");
		modificaPassword.setForeground(new Color(20,20,20));
		modificaPassword.setFont(new Font("Courier", Font.CENTER_BASELINE,20));
		modificaPassword.setBounds(640, 125, 370, 45);
		contentPane.add(modificaPassword);
		
		JButton modificaAbbonamento = new JButton("Modifica il tuo Abbonamento");
		modificaAbbonamento.setForeground(new Color(20,20,20));
		modificaAbbonamento.setFont(new Font("Courier", Font.CENTER_BASELINE,20));
		modificaAbbonamento.setBounds(70, 185, 370, 45);
		contentPane.add(modificaAbbonamento);
		
		JButton tornaIndietro = new JButton("Indietro");
		tornaIndietro.setForeground(new Color(20,20,20));
		tornaIndietro.setFont(new Font("Courier", Font.CENTER_BASELINE,20));
		tornaIndietro.setBounds(640, 185, 370, 45);
		contentPane.add(tornaIndietro);
		
		modificaMail.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				
			}
		});
		modificaMail.addMouseListener(new MouseAdapter() 
		{
			public void mouseClicked(MouseEvent e) 
			{
				impGui.dispose();
				@SuppressWarnings("unused")
				ModificaMailGui mfmail=new ModificaMailGui(impGui, controller, utente);
			}
		});
		
		tornaIndietro.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				
			}
		});
		tornaIndietro.addMouseListener(new MouseAdapter() 
		{
			public void mouseClicked(MouseEvent e) 
			{
				impGui.dispose();
				clientGui.setVisible(true);
			}
		});
		
		modificaPassword.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				
			}
		});
		modificaPassword.addMouseListener(new MouseAdapter() 
		{
			public void mouseClicked(MouseEvent e) 
			{
				impGui.dispose();
				@SuppressWarnings("unused")
				ModificaPasswordGui mfpass=new ModificaPasswordGui(impGui, controller, utente);
			}
		});
		
		modificaAbbonamento.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				
			}
		});
		modificaAbbonamento.addMouseListener(new MouseAdapter() 
		{
			public void mouseClicked(MouseEvent e) 
			{
				impGui.dispose();
				@SuppressWarnings("unused")
				ModificaPianoInterface mfpiano=new ModificaPianoInterface(impGui, controller, utente);
			}
		});
	}
}
