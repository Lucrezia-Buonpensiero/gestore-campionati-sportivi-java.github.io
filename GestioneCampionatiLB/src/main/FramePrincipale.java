package main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import gestioneSquadre.GestioneSquadreCalcio;
import gestioneSquadre.GestioneSquadreHockey;
import gestioneSquadre.GestioneSquadreVolley;
import squadre.SquadraCalcio;
import squadre.SquadraHockey;
import squadre.SquadraVolley;

/**
 * Classe che rappresenta il Frame Principale, ovvero la finestra per la
 * scelta dello sport
 * @author Lucrezia Buonpensiero
 */
public class FramePrincipale extends JFrame implements ActionListener
{
	private static final long serialVersionUID = 1L;
	JPanel pannelloInterno;
	JLabel scritta;
	JButton bottone;
	JComboBox sportsList;
	ImageIcon iconaFrame;
	
	/**
	 * Main
	 */
	public static void main(String[] args) 
	{
		FramePrincipale finestra1 = new FramePrincipale();
	}
	
	/**
	 * Costruttore che richiama i componenti del frame iniziale
	 */
	public FramePrincipale ()
	{
		FrameIniziale();
	}
	
	/**
	 * Metodo contenente le impostazioni del frame e richiama i componenti
	 */
	private void FrameIniziale()
	{
		pannelloInterno = new JPanel();
		
		setResizable(false);
		setTitle("GESTIONE CAMPIONATI");
		setBounds(550,300,400,200);
		setIconImage(Toolkit.getDefaultToolkit().getImage("risorse/iconaFrame/iconaFrame.png"));
		pannelloInterno.setBackground(generatePastelColor(Color.GREEN));
		getContentPane().add(pannelloInterno,BorderLayout.CENTER);
		Componenti();
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	
	/**
	 * Classe che implementa i componenti interni al panel
	 */
	private void Componenti ()
	{
		bottone = new JButton("Avvia");
		getContentPane().add(bottone,BorderLayout.SOUTH);
		bottone.addActionListener(this);
		
		scritta = new JLabel("Seleziona Sport: ");
		getContentPane().add(scritta,BorderLayout.NORTH);
		
		String[] sportStrings = { "(click per selezionare)","Calcio","Pallavolo","Hockey"};
		sportsList = new JComboBox(sportStrings);
		sportsList.setSelectedIndex(0);
		pannelloInterno.add(sportsList);
	}
	
	/**
	 * Classe che in base al colore passato genera e restituisce
	 * lo stesso colore in versione pastello.
	 * Usato per cambiare lo sfondo del frame principale.
	 * 
	 * @param mix il colore base di cui si desidera generare la variante
	 * @return il colore della finestra
	 */
	public static Color generatePastelColor(Color mix) 
	{
	    Random random = new Random();
	    int red = random.nextInt(256);
	    int green = random.nextInt(256);
	    int blue = random.nextInt(256);
	 
	    // mix the color
	    if (mix != null) {
	        red = (red + mix.getRed()) / 2;
	        green = (green + mix.getGreen()) / 2;
	        blue = (blue + mix.getBlue()) / 2;
	    }
	 
	    Color color = new Color(red, green, blue);
	    return color;
	}
	
	/**
	 * ActionListener (ascoltatore degli eventi):
	 * a seconda della voce di menù effettuata
	 * permette di selezionare lo sport 
	 * e creare un ArrayList di squadre del tipo di sport selezionato
	 * 
	 * @see gestioneSquadre.GestioneSquadreCalcio
	 * @see gestioneSquadre.GestioneSquadreVolley
	 * @see gestioneSquadre.GestioneSquadraHockey
	 */
		@Override
		public void actionPerformed(ActionEvent evento) 
		{
			if ( sportsList.getSelectedIndex() == 0 )
			{ JOptionPane.showMessageDialog(null, "Nessuna scelta effettuata", "ATTENZIONE", JOptionPane.ERROR_MESSAGE); }
			if ( sportsList.getSelectedIndex() == 1 )
			{
				ArrayList<SquadraCalcio> sqCalcio = new ArrayList<SquadraCalcio> ();
				
				GestioneSquadreCalcio<SquadraCalcio> frameCalcio = new GestioneSquadreCalcio<SquadraCalcio>(sqCalcio,"Calcio");
				frameCalcio.setVisible(true);
				this.setVisible(false);
			}
			if ( sportsList.getSelectedIndex() == 2 )
			{
				ArrayList<SquadraVolley> sqVolley = new ArrayList<SquadraVolley> ();
				GestioneSquadreVolley<SquadraVolley> frameVolley = new GestioneSquadreVolley<SquadraVolley>(sqVolley,"Volley");
				frameVolley.setVisible(true);
				this.setVisible(false);
			}
			if ( sportsList.getSelectedIndex() == 3 )
			{
				ArrayList<SquadraHockey> sqHockey = new ArrayList<SquadraHockey> ();
				GestioneSquadreHockey<SquadraHockey> frameHockey = new GestioneSquadreHockey<SquadraHockey>(sqHockey,"Hockey");
				frameHockey.setVisible(true);
				this.setVisible(false);
			}
				
		}
	
}
