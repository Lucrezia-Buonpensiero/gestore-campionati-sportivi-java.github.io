package giornate;

import java.util.ArrayList;
import squadre.SquadraCalcio;

/**
 * Classe che permette di creare gli array degli scontri in casa e trasferta fra le squadre di calcio
 * 
 * @author Lucrezia Buonpensiero
 *
 * @see gestioneSquadre.GestioneSquadreCalcio
 */
public class CreazioneGiornateCalcio<E>
{
	private ArrayList<SquadraCalcio> squadre;
	private ArrayList <GiornataCalcio>giornateCasa;
	private ArrayList <GiornataCalcio> giornateTrasferta;
	
	/**
	 * Costruttore usato in fase di caricamento di un campionato
	 * 
	 * @param squadre array squadre calcio
	 * @param giornateCasa array giornate casa
	 * @param giornateTrasferta array giornate trasferta
	 */
	public CreazioneGiornateCalcio(ArrayList<SquadraCalcio> squadre, ArrayList<GiornataCalcio> giornateCasa, ArrayList<GiornataCalcio> giornateTrasferta)
	{
		this.squadre=squadre;
		this.giornateCasa = giornateCasa;
		this.giornateTrasferta = giornateTrasferta;
	}
	
	/**
	 * Costruttore usato in caso di aggiornamento o cancella punti
	 * @param mod se vale true aggiorna i punti altrimenti cancella
	 * 
	 * @see giornate.CreazioneGiornateCalcio#AggiornaPuntiCalcio()
	 * @see giornate.CreazioneGiornateCalcio#CancellaRisultatiCalendario()
	 **/
	public CreazioneGiornateCalcio( ArrayList<GiornataCalcio> giornateCasa, ArrayList<GiornataCalcio> giornateTrasferta, boolean mod )
	{
		this.giornateCasa = giornateCasa;
		this.giornateTrasferta = giornateTrasferta;
		
		if(mod)
		{ AggiornaPuntiCalcio(); }
		else
		{ CancellaRisultatiCalendario(); }
	}
	
	/**
	 * Metodo che utilizza l'algoritmo di Berger per generare gli array delle giornate in casa e trasferta
	 */
	public void CreaArrayGiornateCalcio()
	{
		int numGiornate;
		GiornataCalcio giorno;
		ArrayList<SquadraCalcio> giornateCasaApp = new ArrayList<SquadraCalcio>(squadre.size()/2);
		ArrayList<SquadraCalcio> giornateTrasfertaApp = new ArrayList<SquadraCalcio>(squadre.size()/2);
		
		   /**giornate totali (numero totale delle squadre meno 1) */
		    numGiornate = squadre.size() - 1;
		      
		    /** creo gli array di squadre dividendo quello iniziale in 2 ( per scontri in casa e trasferta )*/
		    for (int i = 0; i < squadre.size() /2; i++) 
		    {
		       giornateCasaApp.add(i,squadre.get(i));
		       giornateTrasfertaApp.add(i,squadre.get(squadre.size()- 1 - i)); 
		    }
		  
		
		    /**Inizio creazione delle giornate*/
			  for (int i = 0 ; i < (numGiornate * 2) ; i++ )
			  {
				  /**
				   * Le prime partite sono quelle in casa
				   * A rotazione delle squadre conclusa si passa alle partite per la trasferta
				   */
			        if ( i <= (numGiornate - 1) )
			        {
			            for ( int j = 0 ; j < (squadre.size()) / 2 ; j++ )
			            {
			            	giorno = new GiornataCalcio( giornateCasaApp.get(j), giornateTrasfertaApp.get(j));
			                giornateCasa.add(giorno);
			            }
			        }
			        else 
			        {
			            for ( int j = 0 ; j < (squadre.size()) / 2 ; j++ ) 
			            {
			            	giorno = new GiornataCalcio (giornateTrasfertaApp.get(j), giornateCasaApp.get(j));
			            	giornateTrasferta.add(giorno); 
			            }
			        }
		   
			        /** Shift degli elementi delle liste, tenendo fisso il primo elemento*/
			        giornateCasaApp.add(giornateTrasfertaApp.get(0));
			        giornateTrasfertaApp.remove(0);
			        giornateTrasfertaApp.add(giornateCasaApp.get(1));
			        giornateCasaApp.remove(1);
			       
			    } 
	}
	
	
	/**
	 * Metodo per l'aggiornamento dei punti nella classifica di calcio
	 */
	public void AggiornaPuntiCalcio()
	{
		ArrayList<GiornataCalcio> sq = new ArrayList<GiornataCalcio>();
		sq = giornateCasa;
		
		for ( int i = 0 ; i < sq.size() ; i++ )
		{
			/**
			 * se c'è stato un pareggio
			 */
			if ( sq.get(i).getGoalSq1() == sq.get(i).getGoalSq2() )
			{
				sq.get(i).getSq1().Pareggio();
				sq.get(i).getSq2().Pareggio();
			}
			/**
			 * se la squadra 1 ha vinto
			 */
			if ( sq.get(i).getGoalSq1() > sq.get(i).getGoalSq2() )
			{
				sq.get(i).getSq1().Vittoria();
				sq.get(i).getSq2().Sconfitta();
			}
			/**
			 * se la squadra 2 ha vinto
			 */
			else if ( sq.get(i).getGoalSq1() < sq.get(i).getGoalSq2() )
			{
				sq.get(i).getSq2().Vittoria();
				sq.get(i).getSq1().Sconfitta();
			}
		}
	}
	
	/**
	 * Metodo per cancellare tutti i risultati del calendario corrente
	 */
	public void CancellaRisultatiCalendario()
	{
		ArrayList<GiornataCalcio> sq = new ArrayList<GiornataCalcio>();
		sq = giornateCasa;
		
		for ( int i = 0 ; i < sq.size() ; i++ )
		{
			sq.get(i).setGoalSq1(0);
			sq.get(i).getSq1().setNumPareggi(0);
			sq.get(i).getSq1().setNumSconfitte(0);
			sq.get(i).getSq1().setnumSetPersi(0);
			sq.get(i).getSq1().setnumSetVinti(0);
			sq.get(i).getSq1().setNumVittorie(0);
			sq.get(i).getSq1().setPunti(0);
			
			sq.get(i).setGoalSq2(0);
			sq.get(i).getSq2().setNumPareggi(0);
			sq.get(i).getSq2().setNumSconfitte(0);
			sq.get(i).getSq2().setnumSetPersi(0);
			sq.get(i).getSq2().setnumSetVinti(0);
			sq.get(i).getSq2().setNumVittorie(0);
			sq.get(i).getSq2().setPunti(0);
		}
	}
}
