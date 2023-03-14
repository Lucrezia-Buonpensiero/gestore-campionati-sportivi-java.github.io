package gestioneSquadre;

import java.awt.Toolkit;
import java.io.File;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JTable;

import grafica.InserimentoDatiGUI;
import squadre.SquadraVolley;

/**
 * Classe per l'inserimento dei dati di una squadra di Volley estende l'interfaccia grafica dell'inserimento dati squadre
 * 
 * @author Lucrezia Buonpensiero
 *
 * @see grafica.InserimentoDatiGUI
 * @param <E> SquadraVolley
 */
public class InserimentoDatiVolley<E> extends InserimentoDatiGUI
{
	private ArrayList<SquadraVolley> squadre;
	private int posSq;
	private String sport;
	
	/**
	 * @param sq array squadre volley
	 * @param titolo titolo finestra
	 * @param mod se vale true entra in modalità modifica, altrimenti inserisci
	 * @param posSq posizione della squadra da inserire
	 * @param table tabella
	 * @param sport nome sport
	 */
	public InserimentoDatiVolley(ArrayList<SquadraVolley> sq, String titolo, boolean mod, int posSq, JTable table, String sport) 
	{
		super(titolo, mod, posSq, table);
		setIconImage(Toolkit.getDefaultToolkit().getImage("risorse/iconaFrame/icona"+sport+".png"));
		this.squadre = sq;
		this.posSq = posSq;
		this.sport = sport;
	}
	
	/**
	 * se esiste una squadra con quel nome
	 * ritorna l'indice di posizione nell'array della squadra da modificare
	 * -1 altrimenti
	 * @return posizione della squadra
	 */
	public int cercaSquadraMod ( SquadraVolley sq )
	{
		for ( int i = 0 ; i < squadre.size() ; i++ )
		{
			
			if (squadre.get(i).getNome().equals(sq.getNome()))
			{
				System.out.println("Squadra da modificare trovata");
				return i;
			}
			
		}
		return -1;
	}
	
	/**
	 * Metodo che cerca le squadre con lo stesso nome all'interno dell'array
	 * @return numero maggiore di zero se ha trovato una squadra con lo stesso nome, 0 altrimenti
	 */
	public int controllaSquadre ( SquadraVolley nuovaSquadra )
	{
		{
			if ( nuovaSquadra.getNome().isEmpty() || nuovaSquadra.getCitta().isEmpty()  )
			{
				System.out.println("Uno dei campi immessi è vuoto");
				return 1;
			}
			for ( int i = 0 ; i < squadre.size() ; i++ )
			{
				if ( squadre.get(i).getNome().equals(nuovaSquadra.getNome()))
				{
					System.out.println("Nome squadra già esistente");
					return 2;
				}
			}
			
			return 0;
		}
	}
	
	
	/**
	 * Metodo che permette di modificare la squadra di volley cercata
	 * con mod true
	 * @see grafica.InserimentoDatiGUI#Modifica()
	 */
	public void Modifica ()
	{
		SquadraVolley modSquadra = new SquadraVolley();
		modSquadra.setNome(super.Nome.getText());
		modSquadra.setCitta(super.Citta.getText());
		
		//inserimento del logo
		if( logoPath==null ) 
		{	logoPath=new File("risorse/iconeScudetti/iconaDefault.png"); }
		else
			modSquadra.setLogo(logoPath.getAbsolutePath());
		
		if ( controllaSquadre(modSquadra) != 0 )
			JOptionPane.showMessageDialog(null, "Squadra non modificata, uno dei campi immessi è vuoto o la squadra è doppia", "ATTENZIONE", JOptionPane.ERROR_MESSAGE);
		else
		{ squadre.set(posSq,modSquadra);}
		table.repaint();
		this.setVisible(false);
	}
	
	/**
	 * Metodo che permette di inserire una nuova squadra di volley nell'array
	 * con mod false
	 * @see grafica.InserimentoDatiGUI#Inserisci()
	 */
	public void Inserisci ()
	{
		SquadraVolley modSquadra = new SquadraVolley();
		modSquadra.setNome(super.Nome.getText());
		modSquadra.setCitta(super.Citta.getText());
		
		//selezione logo
		if( logoPath==null ) 
		{ logoPath=new File("risorse/iconeScudetti/iconaDefault.png"); }
		else
			modSquadra.setLogo(logoPath.getAbsolutePath());
				
		if ( controllaSquadre(modSquadra) != 0 )
			JOptionPane.showMessageDialog(null, "Squadra non inserita, uno dei campi immessi è vuoto o la squadra è doppia", "ATTENZIONE", JOptionPane.ERROR_MESSAGE);
		else
		{
			squadre.add(modSquadra);
			System.out.println("Squadra inserita");
		}
		table.repaint();
		this.setVisible(false);
	}
}
