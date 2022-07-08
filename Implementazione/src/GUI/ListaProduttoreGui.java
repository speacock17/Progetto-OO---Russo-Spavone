package GUI;

import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JButton;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;

import Controller.ControllerProduttore;

import Entità.Produttore;
import Entità.Utente;



public class ListaProduttoreGui 
{
	private JPanel contentPane;
	private JFrame listaPrGui;
    private ArrayList<Produttore> listProduttore = new ArrayList<Produttore>();
    @SuppressWarnings("rawtypes")
	private JList listPr;
		
	public ListaProduttoreGui(ControllerProduttore controller,JFrame adminGui,Utente utente)
	{
		System.out.println("Ti trovi in ListaProduttoreGui");
		
		listaPrGui = new JFrame();
		listaPrGui.setBackground(new Color(20, 20, 20));
		listaPrGui.setTitle("Produttore");
		listaPrGui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		listaPrGui.setBounds(170, 55, 1080, 720);
		listaPrGui.setResizable(false);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(20, 20, 20));
		listaPrGui.setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel EtichettaProduttore = new JLabel("Produttori");
		EtichettaProduttore.setForeground(new Color(0,76,153));
		EtichettaProduttore.setFont(new Font("Courier", Font.CENTER_BASELINE, 50));
		EtichettaProduttore.setBounds(385, 25, 550, 45);
		contentPane.add(EtichettaProduttore);
			
		listProduttore=controller.listaProduttori();
		DefaultListModel<String> model = new DefaultListModel<String>();
		listPr = new JList<String>(model);
			
		for(Produttore varTr: listProduttore)
		{
			model.addElement(varTr.getNome());
		}

		listPr.setBackground(new Color(255, 255, 255));
		listPr.setFont(new Font("Courier", Font.CENTER_BASELINE, 20));
		listPr.setSelectionBackground(new Color(0, 76, 153));
		listPr.setFixedCellHeight(40);
		JScrollPane scrollList = new JScrollPane();
		scrollList.setViewportView(listPr);
	    listPr.setLayoutOrientation(JList.VERTICAL); 
	    scrollList.setBounds(20, 95, 1040, 500);
	    contentPane.add(scrollList);
		    
	    JButton visualizzaGuadagni = new JButton("Visualizza Guadagni");
	    visualizzaGuadagni.setForeground(new Color(20,20,20));
	    visualizzaGuadagni.setFont(new Font("Courier", Font.CENTER_BASELINE,20));
	    visualizzaGuadagni.setBounds(245, 615, 250, 45);
		contentPane.add(visualizzaGuadagni);
			
		JButton indietro = new JButton("Indietro");
		indietro.setForeground(new Color(20,20,20));
		indietro.setFont(new Font("Courier", Font.CENTER_BASELINE,20));
		indietro.setBounds(575, 615, 250, 45);
		contentPane.add(indietro);
			
		listaPrGui.setVisible(true);
			
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
				listaPrGui.dispose();
				adminGui.setVisible(true);
			}
		});
			
		visualizzaGuadagni.addMouseListener(new MouseAdapter() 
		{
			public void mouseClicked(MouseEvent e) 
			{
				listaPrGui.dispose();
				@SuppressWarnings("unused")
				CompensiProdGui compprod=new CompensiProdGui(controller,adminGui,utente);
			}
		});
	}		
}
