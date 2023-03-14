package gestione;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

import giornate.Giornata;

/**
 * Modello tabella per visualizzare le giornate filtrate per nome
 * @author Lucrezia Buonpensiero
 *
 * @param <E> tipo giornate
 */
public class ModelloTabellaVistaNome<E> extends AbstractTableModel
{
	private static final long serialVersionUID = 1L;
	private ArrayList<E> casa;
	private String nome;
	private String[] nomiColonne = {"CASA"," ","TRASFERTA"};
	
	/**
	 * Costruttore che inizializza l'array delle giornate e la stringa del nome con valori passati dall'esterno
	 * @param casa array giornate
	 * @param nome nome da cercare
	 */
	public ModelloTabellaVistaNome ( ArrayList<E> casa , String nome )
	{
		this.casa = casa;
		this.nome = nome;
	}
	
	/**
	 * metodo che restituisce il numero di colonne della tabella
	 * @return numero colonne
	 */
	public int getColumnCount() 
	{ return nomiColonne.length; }
	
	 /**metodo che ritorna il nome della colonna
	  * @return nome colonna
	  * */
	public String getColumnName(int col) 
	{ return nomiColonne[col]; }
	
	/**metodo che ritorna il numero di righe della tabella
	 * @return numero righe
	 * */
	public int getRowCount() 
	{ return casa.size(); }
	
	/**
	 * Metodo che ritorna il contenuto di una cella ma solo con il nome selezionato
	 * se non ci sono corrispondenze mostra una tabella vuota
	 * @return nome squadra 1, nome squadra 2
	 */
	@Override
	public Object getValueAt(int riga, int col) 
	{	
		Giornata sqCasa = (Giornata)casa.get(riga);
		
		if( sqCasa.getSq1().getNome().equals(nome) || sqCasa.getSq2().getNome().equals(nome))
		{
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
		else
		{
			switch(col)
			{	
				case 0:
					return " ";
				case 1:
					return " ";
				case 2:
					return " ";
				default:
					return "";
			}
		}
		

	}
	
	 /**metodo che specifica se le celle sono editabili */
    public boolean isCellEditable(int row, int col) 
    {  return false; }
	
}
