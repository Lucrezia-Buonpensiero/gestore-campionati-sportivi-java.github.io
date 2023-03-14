package giornate;

import java.util.ArrayList;
import squadre.SquadraHockey;

/**
 * Classe che permette di creare gli array degli scontri in casa e trasferta fra le squadre di hockey
 * 
 * @author Lucrezia Buonpensiero
 *
 * @see gestioneSquadre.GestioneSquadreHockey
 */
public class CreazioneGiornateHockey<E> 
{
	private ArrayList<SquadraHockey> squadre;
	private ArrayList <GiornataHockey>giornateCasa;
	private ArrayList <GiornataHockey> giornateTrasferta;
	
	/**
	 * Costruttore usato in fase di caricamento di un campionato
	 * 
	 * @param squadre array squadre hockey
	 * @param giornateCasa array giornate casa
	 * @param giornateTrasferta array giornate trasferta 
	 */
	public CreazioneGiornateHockey(ArrayList<SquadraHockey> squadre, ArrayList<GiornataHockey> giornateCasa, ArrayList<GiornataHockey> giornateTrasferta)
	{
		this.squadre=squadre;
		this.giornateCasa = giornateCasa;
		this.giornateTrasferta = giornateTrasferta;
	}
	
	/**
	 * Costruttore usato in caso di aggiornamento o cancella punti
	 * @param mod se vale true aggiorna i punti altrimenti cancella
	 * 
	 * @see giornate.CreazioneGiornateHockey#AggiornaPuntiHockey()
	 * @see giornate.CreazioneGiornateHockey#CancellaRisultatiCalendario()
	 **/
	public CreazioneGiornateHockey( ArrayList<GiornataHockey> giornateCasa, ArrayList<GiornataHockey> giornateTrasferta, boolean mod )
	{
		this.giornateCasa = giornateCasa;
		this.giornateTrasferta = giornateTrasferta;
		
		if(mod)
		{ AggiornaPuntiHockey(); }
		else
		{ CancellaRisultatiCalendario(); }
	}
	
	/**
	 * Metodo che utilizza l'algoritmo di Berger per generare gli array delle giornate in casa e trasferta
	 */
	public void CreaArrayGiornateHockey()
	{
		int numGiornate;
		GiornataHockey giorno;
		ArrayList<SquadraHockey> giornateCasaApp = new ArrayList<SquadraHockey>(squadre.size()/2);
		ArrayList<SquadraHockey> giornateTrasfertaApp = new ArrayList<SquadraHockey>(squadre.size()/2);
		
		   /**giornate totali (numero totale delle squadre meno 1) */
		    numGiornate = squadre.size() - 1;
		      
		    /** creo gli array di squadre dividendo quello iniziale in 2 ( per scontri in casa e trasferta)*/
		    for (int i = 0; i < squadre.size() /2; i++) 
		    {
		       giornateCasaApp.add(i,(SquadraHockey)squadre.get(i));
		       giornateTrasfertaApp.add(i, (SquadraHockey)squadre.get(squadre.size()- 1 - i)); 
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
			            	giorno = new GiornataHockey( giornateCasaApp.get(j), giornateTrasfertaApp.get(j));
			                giornateCasa.add(giorno);
			            }
			        }
			        else 
			        {
			            for ( int j = 0 ; j < (squadre.size()) / 2 ; j++ ) 
			            {
			            	giorno = new GiornataHockey (giornateTrasfertaApp.get(j), giornateCasaApp.get(j));
			            	giornateTrasferta.add(giorno); 
			            }
			        }
		   
			        /** Ruota  gli elementi delle liste, tenendo fisso il primo elemento*/
			        giornateCasaApp.add(giornateTrasfertaApp.get(0));
			        giornateTrasfertaApp.remove(0);
			        giornateTrasfertaApp.add(giornateCasaApp.get(1));
			        giornateCasaApp.remove(1);
			       
			    } 
	}
	
	/**
	 * Metodo per l'aggiornamento dei punti nella classifica di hockey
	 */
	public void AggiornaPuntiHockey()
	{
		ArrayList<GiornataHockey> sq = new ArrayList<GiornataHockey>();
		sq = giornateCasa;
		
		for ( int i = 0 ; i < sq.size() ; i++ )
		{
			/**
			 * se nessuna delle due squadre si è assentata
			 */
			if ( sq.get(i).getGoalSq1() >= 0  && sq.get(i).getGoalSq2() >= 0 )
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
				if ( sq.get(i).getGoalSq1() < sq.get(i).getGoalSq2() )
				{
					sq.get(i).getSq2().Vittoria();
					sq.get(i).getSq1().Sconfitta();
				}
			}
			/**
			 * se entrambe le squadre si sono assentate
			 */
			else if ( sq.get(i).getGoalSq1() < 0  && sq.get(i).getGoalSq2() < 0 )
			{
					sq.get(i).getSq1().Assenza();
					sq.get(i).getSq2().Assenza();
			}
			/**
			 * se una delle due squadre si è assentata
			 */
			else if ( sq.get(i).getGoalSq1() < 0  || sq.get(i).getGoalSq2() < 0 )
			{
				/**
				 * se la squadra 1 si è assentata
				 */
				if ( sq.get(i).getGoalSq1() < 0 )
				{
					sq.get(i).getSq1().Assenza();
					sq.get(i).getSq2().Vittoria();
				}
				/**
				 * se la squadra 2 si è assentata
				 */
				if ( sq.get(i).getGoalSq2() < 0 )
				{
					sq.get(i).getSq2().Assenza();
					sq.get(i).getSq1().Vittoria();
				}
			}
		}
		
	}
	
	/**
	 * Metodo per cancellare tutti i risultati del calendario corrente
	 */
	public void CancellaRisultatiCalendario()
	{
		ArrayList<GiornataHockey> sq = new ArrayList<GiornataHockey>();
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
