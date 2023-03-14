package gestioneSquadre;

import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import giornate.CreazioneGiornateHockey;
import giornate.GiornataHockey;
import grafica.CalendarioGiornateTabGUI;
import grafica.GestioneSquadraGUI;
import salvataggi.SalvaCaricaSquadre;
import squadre.Squadra;
import squadre.SquadraCalcio;
import squadre.SquadraHockey;

/**
 * Classe principale per la gestione della squadra di hockey, estende l'interfaccia grafica per la gestione delle squadre.
 * Comprende i metodi per Inserire, Modificare, Cancellare le squadre di hockey
 * @author Lucrezia Buonpensiero
 * 
 * @param <E> SquadraHockey
 * @see grafica.GestioneSquadraGUI
 */
public class GestioneSquadreHockey<E> extends GestioneSquadraGUI<E>
{
	private static final long serialVersionUID = 1L;
	private ArrayList<E> squadre;
	ArrayList<GiornataHockey> casa;
	ArrayList<GiornataHockey> trasferta;
	private String sport;
	
	/**
	 * Costruttore che richiama la classe padre, genera l'interfaccia grafica e assegna alle variabili i valori esterni passati
	 * 
	 * @param squadre array squadre di Hockey
	 * @param sport stringa contenente il nome dello sport selezionato
	 */
	public GestioneSquadreHockey (ArrayList<E> squadre, String sport)
	{
		super(squadre);
		this.setTitle("Gestione "+sport);
		setIconImage(Toolkit.getDefaultToolkit().getImage("risorse/iconaFrame/icona"+sport+".png"));
		this.squadre = squadre;
		this.sport = sport;
	}

	/**
	 * Metodo che richiama la finestra per l'inserimento dei dati di una squadra di hockey
	 * @see InserimentoDatiHockey
	 */
	public void InserisciSquadra()
	{
			InserimentoDatiHockey<E> insHockey = new InserimentoDatiHockey(squadre,"Inserisci Squadra "+sport, false,0,table,sport);
			insHockey.setVisible(true);
	
	}
	
	/**
	 * Metodo che richiama la finestra per la modifica di una squadra di hockey.
	 * Mostra un messaggio di errore se si prova a cercare una squadra quando l'array delle squadre hockey è vuoto
	 * @see ModificaSquadre
	 * @see grafica.GestioneSquadraGUI#ModificaSquadra()
	 */
	public void ModificaSquadra()
	{
		if ( squadre.isEmpty() )
			JOptionPane.showMessageDialog(null, "Nessuna squadra da modificare!", "ATTENZIONE", JOptionPane.ERROR_MESSAGE);
		else
		{
			ModificaSquadre finestraMod = new ModificaSquadre(squadre,false,table,sport);
			finestraMod.setVisible(true);
		}
	}
	
	/*
	 * Metodo che richiama la finestra per l'eleminazione di una squadra di hockey.
	 * Mostra un messaggio di errore se si cerca di cancellare una squadra quando l'array delle squadre hockey è vuoto.
	 * 
	 * @see CancellaSquadra
	 * @see grafica.GestioneSquadraGUI#CancellaSquadra()
	 */
	public void CancellaSquadra()
	{
		if ( squadre.isEmpty() )
			JOptionPane.showMessageDialog(null, "Nessuna squadra da cancellare!", "ATTENZIONE", JOptionPane.ERROR_MESSAGE);
		else
		{
			ModificaSquadre finestraCanc = new ModificaSquadre(squadre,true,table,sport);
			finestraCanc.setVisible(true);
		}
	}
	
	/**
	 * Metodo che controlla se il numero di squadre immesse è pari.
	 * Se non lo è oppure non ci sono squadre genera dei messaggi di errore per avvertire l'utente.
	 * Se lo è il campionato può cominciare e vengono inizializzati gli array delle giornate a casa e trasferta.
	 * Viene richiamata la classe della creazione delle giornate di hockey per avviare il metodo che genera le giornate.
	 * In seguito viene avviata la classe che mostra il calendario delle giornate generato.
	 * 
	 * @see CreazioneGiornateHockey
	 * @see CalendarioGiornateTabGUI
	 * @see grafica.GestioneSquadraGUI#ControlloParitaSquadre()
	 */
	public void ControlloParitaSquadre()
	{
		if ( squadre.isEmpty() )
			JOptionPane.showMessageDialog(null, "Devi aggiungere delle squadre prima di cominciare il campionato!", "ATTENZIONE", JOptionPane.ERROR_MESSAGE);
		else if ( (squadre.size() % 2) == 0 )
		{
			casa = new ArrayList<GiornataHockey>();
			trasferta = new ArrayList<GiornataHockey>();
				
			CreazioneGiornateHockey<SquadraHockey> creaGiornHockey = new CreazioneGiornateHockey(squadre,casa,trasferta);
			creaGiornHockey.CreaArrayGiornateHockey();
					
			CalendarioGiornateTabGUI frame = new CalendarioGiornateTabGUI(squadre,casa,trasferta,sport);
			frame.setVisible(true);
		}	
		else
		{ JOptionPane.showMessageDialog(null, "Le squadre devono essere pari per cominciare il campionato!", "ATTENZIONE", JOptionPane.ERROR_MESSAGE); }
	}
		
	/**
	 * Metodo che richiama la classe per il caricamento delle squadre e giornate da file
	 * 
	 * @see SalvaCaricaSquadre
	 * @see salvataggi.SalvaCaricaSquadre#CaricaCampionatoCalcio()
	 * @see salvataggi.SalvaCaricaSquadre#CaricaGiornate()
	 * @see salvataggi.SalvaCaricaSquadre#CaricaSquadre()
	 * @see grafica.GestioneSquadraGUI#CaricaSquadre()
	 */
	public void CaricaSquadre()
	{
		SalvaCaricaSquadre s = new SalvaCaricaSquadre(squadre, new ArrayList<GiornataHockey>(), new ArrayList<GiornataHockey>());
		
		s.CaricaCampionatoHockey();
		s.CaricaGiornate();
		s.CaricaSquadre();
		super.tab.RefreshTable();
	}

	/**
	 * Metodo per controllare se esiste la squadra da modificare cercata
	 * @param sq squadra cercata
	 * @return posizione della squadra da modificare all'interno dell'array, se non c'è torna -1
	 */
	public int cercaSquadraMod ( SquadraHockey sq )
	{
		for ( int i = 0 ; i < squadre.size() ; i++ )
		{
			
			if (((SquadraHockey)squadre.get(i)).getNome().equals(sq.getNome()))
			{
				System.out.println("Squadra da modificare trovata");
				return i;
			}
			
		}
		return -1;
	}

	//public int cercaSquadraMod(Squadra sq) { return 0;}
	
}
