package gestione;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import giornate.Giornata;

/**
 * Modello tabella per visualizzare il calendario degli scontri a coppie di squadre in casa e in trasferta
 * @author Lucrezia Buonpensiero
 *
 * @param <E> tipo giornate
 */
public class ModelloTabellaGiornate<E> extends AbstractTableModel
{
	private static final long serialVersionUID = 1L;
	private ArrayList<E> casa;
	private String[] nomiColonne = {"CASA"," ","TRASFERTA"};
	
	/**
	 * Costruttore che inizializza l'array delle squadre da visualizzare nella tabella
	 * @param casa (può essere sia casa che trasferta)
	 */
	public ModelloTabellaGiornate ( ArrayList<E> casa )
	{ this.casa = casa;	}
	
	/**
	 * metodo che restituisce il numero di colonne della tabella
	 * @return numero colonne tabella
	 */
	public int getColumnCount() 
	{ return nomiColonne.length; }
	
	 /**metodo che ritorna il nome della colonna
	  * @return nome colonna
	  * */
	public String getColumnName(int col) 
	{
		return nomiColonne[col];
	}
	/**metodo che ritorna il numero di righe della tabella
	 * @return numero righe
	 * */
	public int getRowCount() 
	{ return casa.size(); }
	
	 /**
     * metodo che ritorna il contenuto di una cella e permette di visualizzarlo nella tabella 
     * 
     * @return nome squadra 1, nome squadra 2
     */
	@Override
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
