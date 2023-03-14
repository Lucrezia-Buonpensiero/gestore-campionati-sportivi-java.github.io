package giornate;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import squadre.SquadraVolley;

/**
 * Classe che permette di creare gli array degli scontri in casa e trasferta fra le squadre di volley
 * 
 * @author Lucrezia Buonpensiero
 *
 * @see gestioneSquadre.GestioneSquadreVolley
 */
public class CreazioneGiornateVolley<E>
{
	private ArrayList<SquadraVolley> squadre;
	private ArrayList <GiornataVolley>giornateCasa;
	private ArrayList <GiornataVolley> giornateTrasferta;
	
	/**
	 * Costruttore usato in fase di caricamento di un campionato
	 * 
	 * @param squadre array squadre volley
	 * @param giornateCasa array giornate in casa
	 * @param giornateTrasferta array giornate in trasferta
	 */
	public CreazioneGiornateVolley(ArrayList<SquadraVolley> squadre, ArrayList<GiornataVolley> giornateCasa, ArrayList<GiornataVolley> giornateTrasferta)
	{
		this.squadre=squadre;
		this.giornateCasa = giornateCasa;
		this.giornateTrasferta = giornateTrasferta;
	}
	
	/**
	 * Costruttore usato in caso di aggiornamento o cancella punti
	 * @param mod se vale true aggiorna i punti altrimenti cancella
	 * 
	 * @see giornate.CreazioneGiornateVolley#AggiornaPuntiVolley()
	 * @see giornate.CreazioneGiornateVolley#CancellaRisultatiCalendario()
	 **/
	public CreazioneGiornateVolley( ArrayList<GiornataVolley> giornateCasa, ArrayList<GiornataVolley> giornateTrasferta, boolean mod )
	{
		this.giornateCasa = giornateCasa;
		this.giornateTrasferta = giornateTrasferta;
		
		if(mod)
		{ AggiornaPuntiVolley(); }
		else
		{ CancellaRisultatiCalendario(); }
	}

	/**
	 * Metodo che utilizza l'algoritmo di Berger per generare gli array delle giornate in casa e trasferta
	 */
	public void CreaArrayGiornateVolley()
	{
		int numGiornate;
		GiornataVolley giorno;
		ArrayList<SquadraVolley> giornateCasaApp = new ArrayList<SquadraVolley>(squadre.size()/2);
		ArrayList<SquadraVolley> giornateTrasfertaApp = new ArrayList<SquadraVolley>(squadre.size()/2);
		
		   /**giornate totali (numero totale delle squadre meno 1) */
		    numGiornate = squadre.size() - 1;
		      
		    /** creo gli array di squadre dividendo quello iniziale in 2 ( per scontri in casa e trasferta)*/
		    for (int i = 0; i < squadre.size() /2; i++) 
		    {
		       giornateCasaApp.add(i,(SquadraVolley)squadre.get(i));
		       giornateTrasfertaApp.add(i, (SquadraVolley)squadre.get(squadre.size()- 1 - i)); 
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
			            	giorno = new GiornataVolley( giornateCasaApp.get(j), giornateTrasfertaApp.get(j));
			                giornateCasa.add(giorno);
			            }
			        }
			        else 
			        {
			            for ( int j = 0 ; j < (squadre.size()) / 2 ; j++ ) 
			            {
			            	giorno = new GiornataVolley (giornateTrasfertaApp.get(j), giornateCasaApp.get(j));
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
	 * Metodo per l'aggiornamento dei punti nella classifica di volley
	 */
	public void AggiornaPuntiVolley()
	{
		ArrayList<GiornataVolley> sq = new ArrayList<GiornataVolley>();
		sq = giornateCasa;
		
		for ( int i = 0 ; i < sq.size() ; i++ )
		{
			/**
			 * se c'è stato un pareggio invio un messaggio di errore ed esco dal ciclo
			 *
			if ( sq.get(i).getGoalSq1() == sq.get(i).getGoalSq2() )
			{
				JOptionPane.showMessageDialog(null, "La partita non può finire in pareggio", "ATTENZIONE", JOptionPane.ERROR_MESSAGE);
				return;
			}
			
			if ( sq.get(i).getGoalSq1() == 2 && sq.get(i).getGoalSq2() ==  1 || sq.get(i).getGoalSq1() == 1 && sq.get(i).getGoalSq2() ==  2 || sq.get(i).getGoalSq1() == 2 && sq.get(i).getGoalSq2() ==  0 ||sq.get(i).getGoalSq1() == 0 && sq.get(i).getGoalSq2() ==  2)
			{
				JOptionPane.showMessageDialog(null, "La partita non può finire 2 a 1, 1 a 2, 2 a 0, 0 a 2", "ATTENZIONE", JOptionPane.ERROR_MESSAGE);
				sq.get(i).setGoalSq1(0);
				sq.get(i).setGoalSq2(0);
				return;
			}*/
		
			/**
			 * se la squadra 1 ha vinto
			 */
			if ( sq.get(i).getGoalSq1() > sq.get(i).getGoalSq2() )
			{
				sq.get(i).getSq1().Vittoria32();;
				sq.get(i).getSq2().Sconfitta23();;
			}
			/**
			 * se la squadra 2 ha vinto
			 */
			else if ( sq.get(i).getGoalSq1() < sq.get(i).getGoalSq2() )
			{
				sq.get(i).getSq2().Vittoria32();;
				sq.get(i).getSq1().Sconfitta23();;
			}
		}
	}
	
	/**
	 * Metodo per cancellare tutti i risultati del calendario corrente
	 */
	public void CancellaRisultatiCalendario()
	{
		ArrayList<GiornataVolley> sq = new ArrayList<GiornataVolley>();
		sq = giornateCasa;
		
		for ( int i = 0 ; i < sq.size() ; i++ )
		{
			sq.get(i).setGoalSq1(0);
			sq.get(i).getSq1().setNumSconfitte(0);
			sq.get(i).getSq1().setnumSetPersi(0);
			sq.get(i).getSq1().setnumSetVinti(0);
			sq.get(i).getSq1().setNumVittorie(0);
			sq.get(i).getSq1().setPunti(0);
			
			sq.get(i).setGoalSq2(0);
			sq.get(i).getSq2().setNumSconfitte(0);
			sq.get(i).getSq2().setnumSetPersi(0);
			sq.get(i).getSq2().setnumSetVinti(0);
			sq.get(i).getSq2().setNumVittorie(0);
			sq.get(i).getSq2().setPunti(0);
		}
	}
}
