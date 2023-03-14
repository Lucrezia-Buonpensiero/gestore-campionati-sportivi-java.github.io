package gestione;

import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

import giornate.Giornata;
import giornate.GiornataCalcio;
import giornate.GiornataHockey;
import giornate.GiornataVolley;

/**
 * Modello tabella per visualizzare i risultati e modificarli
 * @author Lucrezia Buonpensiero
 *
 * @param <E> tipo giornate
 */
public class ModelloTabellaRisultati<E> extends AbstractTableModel
{
	private static final long serialVersionUID = 1L;
	private ArrayList<Giornata> squadre;
	private String[] nomiColonne = {"Squadra Casa","Goal Casa","Squadra Trasferta","Goal Trasferta"};
	private String sport;
	
	/**
	 * Costruttore che inizializza l'array delle squadre da visualizzare nella tabella e la stringa col nome dello sport
	 * @param squadre array giornate
	 * @param sport nome dello sport
	 */
	public ModelloTabellaRisultati ( ArrayList<Giornata> squadre, String sport )
	{
		this.squadre = squadre;
		this.sport = sport;
	}
	
		/**
		 * metodo che estituisce il numero di colonne della tabella.
		 * @return Numero di colonne della tabella
		 */
		public int getColumnCount() 
		{
			return nomiColonne.length;
		}
		
	    /**metodo che ritorna il numero di righe della tabella
	     * @return numero di righe della tabella
	     * */
	    public int getRowCount() { return squadre.size(); } 
	    
	    /**metodo che ritorna il tipo dell'oggetto della cella selezionata*/
	    public Class<? extends Object> getColumnClass ( int colonna )
	    {
	    	return getValueAt(0,colonna).getClass();
	    }
	    
	    /**metodo che ritorna il contenuto di una cella
	     * @return nome squadra 1, goal squadra1, nome squadra 2, goal squadra 2
	     * */
		public Object getValueAt(int riga, int col) 
		{
			Giornata sq = (Giornata) squadre.get(riga);
			
			switch(col) 
			{
				case 0: 
					return sq.getSq1().getNome();
				case 1: 
					return sq.getGoalSq1();
				case 2: 
					return sq.getSq2().getNome();
				case 3: 
					return sq.getGoalSq2();
				default: 
					return "";
			}
		}
	    
		/**metodo per gestire le modifiche dell'utente e impostare i punti delle squadre nella giornata a seconda dello sport selezionato*/
		public void setValueAt( Object value, int riga, int col )
		{
			
			if ( sport.equals("Calcio"))
			{
				GiornataCalcio sq = (GiornataCalcio) squadre.get(riga);
				if (col == 1)
				{
					//modifica il num di goal fatti sq1
					sq.setGoalSq1(((Integer)value).intValue());
					
					if ( sq.getGoalSq1() > 25 || sq.getGoalSq1() < 0 )
					{
						JOptionPane.showMessageDialog(null, "Errore inserimento punti", "ATTENZIONE", JOptionPane.ERROR_MESSAGE);	
						sq.setGoalSq1(0);
					}
				}
				if (col == 3)
				{
					//modifica il num di goal fatti sq2
					sq.setGoalSq2(((Integer)value).intValue());
					
					if ( sq.getGoalSq2() > 25 || sq.getGoalSq2() < 0 )
					{
						JOptionPane.showMessageDialog(null, "Errore inserimento punti", "ATTENZIONE", JOptionPane.ERROR_MESSAGE);
						sq.setGoalSq2(0);
					}
				}
		
			}
			else if (sport.equals("Hockey"))
			{
				GiornataHockey sq = (GiornataHockey) squadre.get(riga);
				if (col == 1)
				{
					//modifica il num di goal fatti sq1
					sq.setGoalSq1(((Integer)value).intValue());
					
					if ( sq.getGoalSq1() > 25 )
					{
						JOptionPane.showMessageDialog(null, "Errore inserimento punti", "ATTENZIONE", JOptionPane.ERROR_MESSAGE);	
						sq.setGoalSq1(0);
					}
				}
				if (col == 3)
				{
					//modifica il num di goal fatti sq2
					sq.setGoalSq2(((Integer)value).intValue());
					
					if ( sq.getGoalSq2() > 25 )
					{
						JOptionPane.showMessageDialog(null, "Errore inserimento punti", "ATTENZIONE", JOptionPane.ERROR_MESSAGE);
						sq.setGoalSq2(0);
					}
				}
		
			}
			else if ( sport.equals("Volley"))
			{
				GiornataVolley sq = (GiornataVolley) squadre.get(riga);
				
				if (col == 1)
				{
					//modifica il num di goal fatti sq1
					sq.setGoalSq1(((Integer)value).intValue());
					
					if ( sq.getGoalSq1() > 3 || sq.getGoalSq1() < 0 )
					{
						JOptionPane.showMessageDialog(null, "Errore inserimento punti, i valori devono essere compresi fra 1 e 3", "ATTENZIONE", JOptionPane.ERROR_MESSAGE);
						sq.setGoalSq1(0);
						sq.setGoalSq1(0);
					}
					if ( sq.getGoalSq1() == sq.getGoalSq2() )
					{
						JOptionPane.showMessageDialog(null, "Non esiste il pareggio nel volley", "ATTENZIONE", JOptionPane.ERROR_MESSAGE);
						sq.setGoalSq1(0);
						sq.setGoalSq1(0);
					}
					if ( sq.getGoalSq1() == 2 && sq.getGoalSq2() ==  1 || sq.getGoalSq1() == 1 && sq.getGoalSq2() ==  2 || sq.getGoalSq1() == 2 && sq.getGoalSq2() ==  0 ||sq.getGoalSq1() == 0 && sq.getGoalSq2() ==  2)
					{
						JOptionPane.showMessageDialog(null, "La partita non può finire 2 a 1, 1 a 2, 2 a 0, 0 a 2", "ATTENZIONE", JOptionPane.ERROR_MESSAGE);
						sq.setGoalSq1(0);
						sq.setGoalSq2(0);
					}
					
					
				}
				if (col == 3)
				{
					//modifica il num di goal fatti sq2
					sq.setGoalSq2(((Integer)value).intValue());
					
					if ( sq.getGoalSq2() > 3 || sq.getGoalSq2() < 0 )
					{
						JOptionPane.showMessageDialog(null, "Errore inserimento punti, i valori devono essere compresi fra 1 e 3", "ATTENZIONE", JOptionPane.ERROR_MESSAGE);
						sq.setGoalSq1(0);
						sq.setGoalSq2(0);
					}
					if ( sq.getGoalSq1() == sq.getGoalSq2() )
					{
						JOptionPane.showMessageDialog(null, "Non esiste il pareggio nel volley", "ATTENZIONE", JOptionPane.ERROR_MESSAGE);
						sq.setGoalSq1(0);
						sq.setGoalSq2(0);
					}
					if ( sq.getGoalSq1() == 2 && sq.getGoalSq2() ==  1 || sq.getGoalSq1() == 1 && sq.getGoalSq2() ==  2 || sq.getGoalSq1() == 2 && sq.getGoalSq2() ==  0 ||sq.getGoalSq1() == 0 && sq.getGoalSq2() ==  2)
					{
						JOptionPane.showMessageDialog(null, "La partita non può finire 2 a 1, 1 a 2, 2 a 0, 0 a 2", "ATTENZIONE", JOptionPane.ERROR_MESSAGE);
						sq.setGoalSq1(0);
						sq.setGoalSq2(0);
					}
				}
			}
			fireTableDataChanged();
		}
		
		
	    /**metodo che ritorna il nome della colonna
	     * @return nome colonna
	     * */
		public String getColumnName(int col) 
		{
			return nomiColonne[col];
		}
	    
	    /**Metodo che specifica se le celle sono editabili.
	     * In questo caso lo sono le celle della colonna 1 e della colonna 3 che corrispondono ai punti delle squadre nelle giornate
	     *  */
	    public boolean isCellEditable(int row, int col) 
	    { 
	    	if( col == 1 || col == 3 )
	    		return true;
	    	else
	    		return false;
	    }    
}

