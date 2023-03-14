package gestione;

import java.util.ArrayList;
import java.util.Collections;
import javax.swing.table.AbstractTableModel;
import squadre.Squadra;

/**
 * Modello tabella per visualizzare la classifica e la classifica di fine campionato
 * @author Lucrezia Buonpensiero
 *
 * @param <E> tipo squadre
 */
public class ModelloTabella<E> extends AbstractTableModel
{
	private static final long serialVersionUID = 1L;
	private ArrayList<Squadra> squadre;
	private String[] nomiColonne = {"Logo","Nome","Città","Punti","Vittorie","Sconfitte"};
	
	/**
	 * Costruttore che inizializza l'array delle squadre da visualizzare nella tabella
	 * @param squadre array squadre
	 */
	public ModelloTabella ( ArrayList<Squadra> squadre )
	{ this.squadre = squadre; }
	
		/**
		 * metodo che estituisce il numero di colonne della tabella.
		 * @return Numero di colonne della tabella
		 */
		public int getColumnCount() 
		{
			return nomiColonne.length;
		}
		
	    /**metodo che ritorna il numero di righe della tabella
	     * @return Numero righe della tabella
	     * */
	    public int getRowCount() { return squadre.size(); } 
	    
	    /**metodo che ritorna il tipo dell'oggetto della cella selezionata
	     * @return Il tipo del logo (ImageIcon)
	     * */
	    public Class<? extends Object> getColumnClass ( int colonna )
	    {
	    	return getValueAt(0,colonna).getClass();
	    }
	    
	    /**
	     * metodo che ritorna il contenuto di una cella e permette di visualizzarlo nella tabella 
	     * 
	     * @return logo, nome, città, punti, vittorie, sconfitte
	     */
		public Object getValueAt(int riga, int col) 
		{
			/**Ordinamento delle squadre per punti.
			 * Nel Collections.sort vanno specificati l'array e il metodo con cui ordinare
			 * @see Comparatore
			 */
			Collections.sort((ArrayList<Squadra>)squadre, new Comparatore());
			Squadra sq =(Squadra) squadre.get(riga);
			
			switch(col) 
			{
				case 0:
					return sq.getLogo();
				case 1: 
					return sq.getNome();
				case 2: 
					return sq.getCitta();
				case 3: 
					return sq.getPunti();
				case 4: 
					return sq.getNumVittorie();
				case 5: 
					return sq.getNumSconfitte();
				default: 
					return "";
			}
		}
	    
		/**
		 * Metodo per aggiornare la tabella
		 */
		public void RefreshTable()
		{
			this.fireTableDataChanged();
		}
		
	    /**Metodo che ritorna il nome della colonna*/
		public String getColumnName(int col) 
		{
			return nomiColonne[col];
		}
	    
	    /**Metodo che specifica se le celle sono editabili */
	    public boolean isCellEditable(int row, int col) 
	    { return false;}    
}
