package GUI;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
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
public class Login extends JFrame
{
	private JPanel contentPane;
	private JPasswordField inserimentoPassword;
	private JTextField inserimentoNomeUtente;
	private ControllerUtente controller;
	private JFrame loginGui;
	private Utente utente;
	
	public Login(ControllerUtente controller)
	{
		System.out.println("Ti trovi in login");
		this.controller=controller;
		LoginInitial();
		loginGui.setVisible(true);
	}
	
	public void LoginInitial() 
	{
		loginGui = new JFrame();
		loginGui.setBackground(new Color(20, 20, 20));
		loginGui.setTitle("Music-2022");
		loginGui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		loginGui.setBounds(170, 55, 1080, 720);
		loginGui.setResizable(false);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(20, 20, 20));
		loginGui.setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel EtichettaDiLogin = new JLabel("Login");
		EtichettaDiLogin.setForeground(new Color(0,76,153));
		EtichettaDiLogin.setFont(new Font("Courier", Font.CENTER_BASELINE, 40));
		EtichettaDiLogin.setBounds(480, 250, 120, 45);
		contentPane.add(EtichettaDiLogin);
		
		JLabel etichettaUsername = new JLabel("Nome Utente:");
		etichettaUsername.setFont(new Font("Courier", Font.CENTER_BASELINE,20));
		etichettaUsername.setForeground(new Color(255, 255, 255));
		etichettaUsername.setBounds(290, 310, 150, 45);
		contentPane.add(etichettaUsername);
		
		JLabel etichettaPassword = new JLabel("Password:");
		etichettaPassword.setFont(new Font("Courier", Font.CENTER_BASELINE,20));
		etichettaPassword.setForeground(new Color(255, 255, 255));
		etichettaPassword.setBounds(325, 370, 150, 45);
		contentPane.add(etichettaPassword);
		
		inserimentoNomeUtente = new JTextField();
		inserimentoNomeUtente.setFont(new Font("Courier", Font.CENTER_BASELINE,20));
		inserimentoNomeUtente.setBounds(430, 310, 250, 45);
		contentPane.add(inserimentoNomeUtente);	
		
		inserimentoPassword = new JPasswordField();
		inserimentoPassword.setFont(new Font("Courier", Font.CENTER_BASELINE,20));
		inserimentoPassword.setBounds(430,370,250,45);
		contentPane.add(inserimentoPassword);
		
		JButton accediButton = new JButton("Accedi");
		accediButton.setForeground(new Color(20,20,20));
		accediButton.setFont(new Font("Courier", Font.CENTER_BASELINE,20));
		accediButton.setBounds(400, 430, 120, 45);
		contentPane.add(accediButton);
		
		accediButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				
			}
		});
		accediButton.addMouseListener(new MouseAdapter() 
		{
			@SuppressWarnings("deprecation")
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				utente = controller.login(inserimentoNomeUtente.getText(), inserimentoPassword.getText());
				if(utente == null) 
				{
					JOptionPane.showMessageDialog(accediButton, "Nome utente o password errati");
				}
				else if(utente.getAccesso().equals("Admin"))
				{
					inserimentoPassword.setText("");
					inserimentoNomeUtente.setText("");
					@SuppressWarnings("unused")
					AdminInterface admin=new AdminInterface(loginGui,controller,utente);
				}
				else if(utente.getAccesso().equals("Client"))
				{
					inserimentoPassword.setText("");
					inserimentoNomeUtente.setText("");
					@SuppressWarnings("unused")
					ClientInterface client=new ClientInterface(loginGui,controller,utente);
				}
			}
		});
		
		
		JButton registratiButton = new JButton("Registrati");
		registratiButton.setForeground(new Color(20,20,20));
		registratiButton.setFont(new Font("Courier", Font.CENTER_BASELINE,20));
		registratiButton.setBounds(570, 430, 150, 45);
		contentPane.add(registratiButton);
		
		registratiButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				
			}
		});
		registratiButton.addMouseListener(new MouseAdapter() 
		{
			public void mouseClicked(MouseEvent e) 
			{
				inserimentoPassword.setText("");
				inserimentoNomeUtente.setText("");
				@SuppressWarnings("unused")
				RegistrazioneUtente regutente=new RegistrazioneUtente(loginGui,controller);
			}
		});
	}
}