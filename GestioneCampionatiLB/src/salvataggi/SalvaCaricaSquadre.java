package salvataggi;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import grafica.ProgressBar;

/**
 * Classe per il salvataggio e il caricamento dei campionati
 * @author Lucrezia Buonpensiero
 *
 * @param <T> tipo giornate
 * @param <E> tipo squadre
 */
public class SalvaCaricaSquadre <E,T>
{
	/**
	 * Array delle squadre
	 * giornate Casa e trasferta
	 */
	private ArrayList<E> squadre;
	private ArrayList<T> giornateCasa;
	private ArrayList<T> giornateTrasferta;
	/**
	 * File I/O di squadre e giornate Casa e trasferta
	 */
	private FileInputStream fGiornateCasa;
	private FileInputStream fGiornateTrasferta;
	private FileInputStream fSquadre;
	
	private FileOutputStream ofGiornateCasa;
	private FileOutputStream ofGiornateTrasferta;
	private FileOutputStream ofSquadre;
	
	/**
	 * Costruttore
	 * @param squadre
	 * @param giornateCasa
	 * @param giornateTrasferta
	 */
	public SalvaCaricaSquadre ( ArrayList<E> squadre, ArrayList<T> giornateCasa, ArrayList<T> giornateTrasferta )
	{
		this.squadre = squadre;
		this.giornateCasa = giornateCasa;
		this.giornateTrasferta = giornateTrasferta;
	}
	
	/**
	 * Metodo che crea i file per il caricamento del campionato di calcio
	 */
	public void CaricaCampionatoCalcio()
	{
		try
		{ fSquadre = new FileInputStream("salvataggi/Calcio/Squadre"); }
		catch ( FileNotFoundException e1 )
		{ JOptionPane.showMessageDialog(null, "File delle squadre non trovato"+ e1.getMessage(), "ERRORE", JOptionPane.ERROR_MESSAGE);}
		
		try
		{ fGiornateTrasferta = new FileInputStream("salvataggi/Calcio/GiornateTrasferta");}
		catch ( FileNotFoundException e2 )
		{ JOptionPane.showMessageDialog(null, "File delle Giornate in Trasferta non trovato"+ e2.getMessage(), "ERRORE", JOptionPane.ERROR_MESSAGE); }
		
		try
		{ fGiornateCasa = new FileInputStream("salvataggi/Calcio/GiornateCasa"); }
		catch ( FileNotFoundException e3 )
		{  JOptionPane.showMessageDialog(null, "File delle Giornate in Casa non trovato"+ e3.getMessage(), "ERRORE", JOptionPane.ERROR_MESSAGE); }
		
	}
	
	/**
	 * Metodo che crea i file per il caricamento del campionato di hockey
	 */
	public void CaricaCampionatoHockey()
	{
		try
		{ fSquadre = new FileInputStream("salvataggi/Hockey/Squadre"); }
		catch ( FileNotFoundException e1 )
		{  JOptionPane.showMessageDialog(null, "File delle squadre non trovato"+ e1.getMessage(), "ERRORE", JOptionPane.ERROR_MESSAGE); }
		
		try
		{ fGiornateTrasferta = new FileInputStream("salvataggi/Hockey/GiornateTrasferta");}
		catch ( FileNotFoundException e2 )
		{ JOptionPane.showMessageDialog(null, "File delle Giornate in Trasferta non trovato"+ e2.getMessage(), "ERRORE", JOptionPane.ERROR_MESSAGE); }
		
		try
		{ fGiornateCasa = new FileInputStream("salvataggi/Hockey/GiornateCasa"); }
		catch ( FileNotFoundException e3 )
		{  JOptionPane.showMessageDialog(null, "File delle Giornate in Casa non trovato"+ e3.getMessage(), "ERRORE", JOptionPane.ERROR_MESSAGE); }
	
	}
	
	/**
	 * Metodo che crea i file per il caricamento del campionato di volley
	 */
	public void CaricaCampionatoVolley ()
	{
		try
		{ fSquadre = new FileInputStream("salvataggi/Volley/Squadre"); }
		catch ( FileNotFoundException e1 )
		{  JOptionPane.showMessageDialog(null, "File delle squadre non trovato"+ e1.getMessage(), "ERRORE", JOptionPane.ERROR_MESSAGE); }
		
		try
		{ fGiornateTrasferta = new FileInputStream("salvataggi/Volley/GiornateTrasferta");}
		catch ( FileNotFoundException e2 )
		{ JOptionPane.showMessageDialog(null, "File delle Giornate in Trasferta non trovato"+ e2.getMessage(), "ERRORE", JOptionPane.ERROR_MESSAGE); }
		
		try
		{ fGiornateCasa = new FileInputStream("salvataggi/Volley/GiornateCasa"); }
		catch ( FileNotFoundException e3 )
		{  JOptionPane.showMessageDialog(null, "File delle Giornate in Casa non trovato"+ e3.getMessage(), "ERRORE", JOptionPane.ERROR_MESSAGE); }
		
	}
	
	/**
	 * Metodo per caricare le squadre
	 */
	public void CaricaSquadre()
	{
		ArrayList<E> nuovaSquadra = null;
		
		try
		{
			ObjectInputStream oSquadre = new ObjectInputStream(fSquadre);
			nuovaSquadra = ( ArrayList<E> ) oSquadre.readObject();
			oSquadre.close();
		}
		catch( IOException ioe )
		{
			JOptionPane.showMessageDialog(null, "Errore caricamento squadre" + ioe.getMessage(), "ERRORE", JOptionPane.ERROR_MESSAGE);
			return;
		}
			catch( ClassNotFoundException cnf )
			{
				JOptionPane.showMessageDialog(null, "Classe non trovata" + cnf.getMessage(), "ERRORE", JOptionPane.ERROR_MESSAGE);
				return;
			}
		
		squadre.removeAll(squadre);
		
		for ( int i = 0 ; i < nuovaSquadra.size() ; i++ )
			squadre.add(nuovaSquadra.get(i));
	}
	
	/**
	 * Metodo per il caricamento delle giornate
	 */
	public void CaricaGiornate()
	{
		ArrayList<T> nuoveGiornateCasa = null;
		ArrayList<T> nuoveGiornateTrasferta = null;
		
		try
		{
			ObjectInputStream oGiornateCasa = new ObjectInputStream(fGiornateCasa);
			nuoveGiornateCasa = ( ArrayList<T> ) oGiornateCasa.readObject();
			oGiornateCasa.close();
			
			ObjectInputStream oGiornateTrasferta = new ObjectInputStream(fGiornateTrasferta);
			nuoveGiornateTrasferta = ( ArrayList<T> ) oGiornateTrasferta.readObject();
			oGiornateTrasferta.close();
			
		}
		catch( IOException ioe )
		{
			JOptionPane.showMessageDialog(null, "Errore caricamento giornate" + ioe.getMessage() ,"ERRORE", JOptionPane.ERROR_MESSAGE );
			return;
		}
			catch ( ClassNotFoundException cnf )
			{
				JOptionPane.showMessageDialog(null,"Classe non trovata"+ cnf.getMessage(),"ERRORE", JOptionPane.ERROR_MESSAGE);
				return;
			}
		
		ProgressBar pBar = new ProgressBar();
		
		//Passaggio giornate negli array
		for( int i = 0 ; i < nuoveGiornateCasa.size() ; i++ )
		{ giornateCasa.add(nuoveGiornateCasa.get(i)); }
		
		for ( int i = 0 ; i < nuoveGiornateTrasferta.size() ; i++ )
		{ giornateTrasferta.add(nuoveGiornateTrasferta.get(i)); }
		 
	}
	
	
	
	/**
	 * File per il salvataggio del campionato di Calcio
	 */
	public void SalvaCampionatoCalcio()
	{
		try 
		{ ofSquadre = new FileOutputStream("salvataggi/Calcio/Squadre");} 
		catch (FileNotFoundException e1) 
		{ JOptionPane.showMessageDialog(null,"Il File delle squadre non esiste"+e1.getMessage(),"ERRORE", JOptionPane.ERROR_MESSAGE); }
		
		try 
		{ ofGiornateCasa = new FileOutputStream("salvataggi/Calcio/GiornateCasa");} 
		catch (FileNotFoundException e2) 
		{ JOptionPane.showMessageDialog(null, "Il File delle giornate in Casa non esiste"+e2.getMessage(),"ERRORE", JOptionPane.ERROR_MESSAGE); }
		
        try 
        { ofGiornateTrasferta = new FileOutputStream("salvataggi/Calcio/GiornateTrasferta"); }
        catch (FileNotFoundException e3)
        { JOptionPane.showMessageDialog(null,"Il File delle giornate in Trasferta non esiste"+e3.getMessage(),"ERRORE", JOptionPane.ERROR_MESSAGE); }
        
	}
	
	/**
	 * File per il salvataggio del campionato di Pallavvolo
	 */
	public void SalvaCampionatoVolley()
	{
		try 
		{ ofSquadre = new FileOutputStream("salvataggi/Volley/Squadre"); } 
		catch ( FileNotFoundException e1 ) 
		{ JOptionPane.showMessageDialog(null, "Il File delle Squadre non esiste" + e1.getMessage(),"ERRORE", JOptionPane.ERROR_MESSAGE); }
		
		try 
		{ ofGiornateCasa = new FileOutputStream("salvataggi/Volley/GiornateCasa"); }
		catch ( FileNotFoundException e2 ) 
		{ JOptionPane.showMessageDialog(null, "Il File delle Giornate in Casa non esiste"+ e2.getMessage(),"ERRORE", JOptionPane.ERROR_MESSAGE); }
		
        try { ofGiornateTrasferta = new FileOutputStream("salvataggi/Volley/GiornateTrasferta"); }
        catch ( FileNotFoundException e3 ) 
        { JOptionPane.showMessageDialog(null, "Il File delle Giornate in Trasferta non esiste"+ e3.getMessage(),"ERRORE", JOptionPane.ERROR_MESSAGE); }
     
	}
	
	/**
	 * File per il salvataggio del campionato di Hockey
	 */
	public void SalvaCampionatoHockey()
	{
		try 
		{ ofSquadre = new FileOutputStream("salvataggi/Hockey/Squadre"); } 
		catch ( FileNotFoundException e1 ) 
		{ JOptionPane.showMessageDialog(null, "Il File delle Squadre non esiste" + e1.getMessage(),"ERRORE", JOptionPane.ERROR_MESSAGE); }
		
		try 
		{ ofGiornateCasa = new FileOutputStream("salvataggi/Hockey/GiornateCasa"); }
		catch ( FileNotFoundException e2 ) 
		{ JOptionPane.showMessageDialog(null, "Il File delle Giornate in Casa non esiste"+ e2.getMessage(),"ERRORE", JOptionPane.ERROR_MESSAGE); }
		
        try { ofGiornateTrasferta = new FileOutputStream("salvataggi/Hockey/GiornateTrasferta"); }
        catch ( FileNotFoundException e3 ) 
        { JOptionPane.showMessageDialog(null, "Il File delle Giornate in Trasferta non esiste"+ e3.getMessage(),"ERRORE", JOptionPane.ERROR_MESSAGE); }
        
	}
	
	/**
	 * Metodo per il salvataggio del campionato sportivo
	 */
	public void SalvaCampionato()
	{
		ProgressBar pBar = new ProgressBar();
		
		try
		{
			ObjectOutputStream squadre1 = new ObjectOutputStream(ofSquadre);
			ObjectOutputStream giornateCasa1 = new ObjectOutputStream(ofGiornateCasa);
			ObjectOutputStream giornateTrasferta1 = new ObjectOutputStream(ofGiornateTrasferta);
			
			squadre1.writeObject(squadre);
	        squadre1.flush();
	        squadre1.close();
	      
	        giornateCasa1.writeObject(giornateCasa);
	        giornateCasa1.flush();
	        giornateCasa1.close();
	      
	        giornateTrasferta1.writeObject(giornateTrasferta);
	        giornateTrasferta1.flush();
	        giornateTrasferta1.close();
	       
		}
		catch ( IOException ioe )
		{ JOptionPane.showMessageDialog(null,  "Impossibile salvare"+ ioe.getMessage(),"ERRORE", JOptionPane.ERROR_MESSAGE); }
		
	}
}
