package grafica;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import gestioneSquadre.*;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.LayoutStyle.ComponentPlacement;

public class InserimentoDatiGUI extends JFrame implements ActionListener
{
	protected JPanel contentPane;
	protected JTextField Nome;
	protected JTextField Citta;
	protected boolean mod;
	protected int posSq;
	protected JTable table;
	protected File logoPath;
	
	/**
	 * Costruttore che inizializza le variabili con valori passati dall'esterno
	 * e inizializza i componenti grafici
	 * 
	 * @param mod  se vale true entro in modifica squadre, altrimenti entro in inserisci squadre
	 */
	public InserimentoDatiGUI( String titolo, boolean mod, int posSq, JTable table ) 
	{
		this.table = table;
		this.mod = mod;
		this.posSq = posSq;
		setTitle(titolo);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		Componenti();
	}

	/**
	 * Componenti
	 */
	public void Componenti()
	{
		/**
		 * Creo Etichette e Bottoni
		 */
		JLabel lblNomeSquadra = new JLabel("Nome Squadra");
		JLabel lblCitt = new JLabel("Città");
		JLabel lblLogo = new JLabel("Logo");
		JButton btnSelezionaLogo = new JButton("Logo");
		JButton btnInserisci = new JButton("Inserisci");
		
		Nome = new JTextField();
		Nome.setColumns(10);
		
		Citta = new JTextField();
		Citta.setColumns(10);
		
		/**
		 * Aggiungo action listener ai bottoni
		 */
		btnSelezionaLogo.addActionListener(this);
		btnInserisci.addActionListener(this);
		
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(20)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
							.addComponent(lblCitt, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(lblNomeSquadra, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addComponent(lblLogo))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(btnSelezionaLogo)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
							.addComponent(Citta)
							.addComponent(Nome, GroupLayout.DEFAULT_SIZE, 244, Short.MAX_VALUE)))
					.addContainerGap(55, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap(313, Short.MAX_VALUE)
					.addComponent(btnInserisci)
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(50)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(Nome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNomeSquadra))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCitt)
						.addComponent(Citta, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblLogo)
						.addComponent(btnSelezionaLogo))
					.addPreferredGap(ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
					.addComponent(btnInserisci)
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
	}
	
	/**Metodo che permette di visualizzare l'interfaccia per selezionare il logo*/
	public void Logo()
	{
		JFileChooser logo = new JFileChooser(new File("risorse/iconeScudetti"));
		logo.showOpenDialog(this.contentPane);
		logo.setFileSelectionMode(JFileChooser.FILES_ONLY);
		logoPath = logo.getSelectedFile();
	}

	/**
	 * ActionListener (ascoltatore degli eventi):
	 * a seconda della voce di menù effettuata
	 * permette di selezionare l'azione da svolgere
	 * 
	 * @see gestioneSquadre.InserimentoDatiCalcio#Modifica()
	 * @see gestioneSquadre.InserimentoDatiCalcio#Inserisci()
	 * 
	 * @see gestioneSquadre.InserimentoDatiHockey#Inserisci()
	 * @see gestioneSquadre.InserimentoDatiHockey#Modifica()
	 * 
	 * @see gestioneSquadre.InserimentoDatiVolley#Modifica()
	 * @see gestioneSquadre.InserimentoDatiVolley#Inserisci()
	 * 
	 */
	@Override
	public void actionPerformed(ActionEvent e) 
	{
			
			if(e.getActionCommand().equals("Inserisci"))
			{
				if(mod)
					Modifica();
				else
					Inserisci();
			}
			
			if (e.getActionCommand().equals("Logo"))
			{
				Logo();
			}
		
	}
	public void Modifica() {};

	public void Inserisci() {}
}
