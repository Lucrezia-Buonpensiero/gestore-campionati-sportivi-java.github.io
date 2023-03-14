package gestione;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import giornate.Giornata;

/**
 * Modello tabella per visualizzare le giornate filtrate per numero giornata
 * @author Lucrezia Buonpensiero
 *
 * @param <E> tipo array
 */
public class ModelloTabellaVistaGiornata<E> extends AbstractTableModel
{
	private static final long serialVersionUID = 1L;
	private ArrayList<E> casa;
	private int numGiornata;
	private String[] nomiColonne = {"CASA"," ","TRASFERTA"};
	
	/**
	 * Costruttore che inizializza l'array delle giornate e il numero di giornata cercato con i valori passati dall'esterno
	 * @param casa array giornate casa
	 * @param numGiornata numero giornata da cercare
	 */
	public ModelloTabellaVistaGiornata ( ArrayList<E> casa , int numGiornata )
	{
		this.casa = casa;
		this.numGiornata = numGiornata;
	}
	
	/**
	 * metodo che restituisce il numero di colonne della tabella
	 * @return numero di colonne
	 */
	public int getColumnCount() 
	{ return nomiColonne.length; }
	
	 /**metodo che ritorna il nome della colonna
	  * @return nome della colonna
	  * */
	public String getColumnName(int col) 
	{
		return nomiColonne[col];
	}
	
	/**metodo che ritorna il numero di righe della tabella
	 * @return numero righe della tabella
	 * */
	public int getRowCount() 
	{ return casa.size(); }
	
	/**
	 * metodo che ritorna il contenuto di una cella
	 * 
	 * @return nome squadra 1, nome squadra 2
	 */
	public Object getValueAt(int riga, int col) 
	{	
		Giornata sqCasa = (Giornata)casa.get(riga);
		
			switch(col)
			{	
				case 0:
					return sqCasa.getSq1().getNome();
				case 1:
					return "VS";
				case 2:
					return sqCasa.getSq2().getNome();
				default:
					return "";
			}
	}
	
	 /**metodo che specifica se le celle sono editabili */
    public boolean isCellEditable(int row, int col) 
    {  return false; }
	
}
